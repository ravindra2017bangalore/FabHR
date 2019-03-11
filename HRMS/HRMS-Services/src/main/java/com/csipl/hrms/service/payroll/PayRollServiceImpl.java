package com.csipl.hrms.service.payroll;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.common.services.dropdown.DropDownHdService;
import com.csipl.common.util.EnumUtil;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.common.enums.EarningDeductionEnum;
import com.csipl.hrms.common.enums.StandardDeductionEnum;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.exception.ServiceException;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeFamily;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.EmployeeStatuary;
import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payroll.Epf;
import com.csipl.hrms.model.payroll.Esi;
import com.csipl.hrms.model.payroll.LoanEMI;
import com.csipl.hrms.model.payroll.LoanIssue;
import com.csipl.hrms.model.payroll.OneTimeDeduction;
import com.csipl.hrms.model.payroll.PayHead;
import com.csipl.hrms.model.payroll.ProfessionalTax;
import com.csipl.hrms.model.payrollprocess.Attendance;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.model.payrollprocess.PayRollLock;
import com.csipl.hrms.model.payrollprocess.PayRollLockPK;
import com.csipl.hrms.model.payrollprocess.PayrollControl;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.model.payrollprocess.ReportPayOutPK;
import com.csipl.hrms.service.employee.EmployeeIdProofService;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.employee.EmployeeStatuaryService;
import com.csipl.hrms.service.employee.FamilyService;
import com.csipl.hrms.service.employee.PayStructureService;
import com.csipl.hrms.service.organization.DepartmentServiceImpl;
import com.csipl.hrms.service.organization.repository.CityRepository;
import com.csipl.hrms.service.payroll.repository.AttendanceRepository;
import com.csipl.hrms.service.payroll.repository.PayOutRepository;
import com.csipl.hrms.service.payroll.repository.ReportPayOutRepository;
import com.csipl.hrms.service.util.ConverterUtil;
import com.hrms.org.payrollprocess.PayRollValidation;
import com.hrms.org.payrollprocess.deduction.CalculationPayHead;
import com.hrms.org.payrollprocess.dto.PayRollProcessDTO;
import com.hrms.org.payrollprocess.dto.PayRollProcessHDDTO;
import com.hrms.org.payrollprocess.earning.AttendanceBased;
import com.hrms.org.payrollprocess.earning.EarningTypeFactory;
import com.hrms.org.payrollprocess.loan.LoanCalculation;
import com.hrms.org.payrollprocess.loan.OneTimeDeductionCalculation;
import com.hrms.org.payrollprocess.util.PayRollProcessUtil;

@Transactional
@Service("payRollService")
public class PayRollServiceImpl implements PayRollService {
	
	 private final Logger logger = LoggerFactory.getLogger(PayRollServiceImpl.class);

	@Autowired
	AttendanceService attendanceService;

	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	@Autowired
	private AttendanceRepository attendanceRepository;

	@Autowired
	private EpfService epfService;

	@Autowired
	private EsicService esicService;
	
	@Autowired
	ProfessionalTaxService professionalTaxService;
	
	@Autowired
	PayOutRepository payOutRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	EmployeePersonalInformationService employeeService;
	
	@Autowired
	ReportPayOutRepository reportPayOutRepository;

	@Autowired
	PayrollControlService payrollControlService;
	
	@Autowired
	DropDownHdService dropDownHdService;
	
	@Autowired
	LoanIssueService loanIssueService;
	
	@Autowired
	EmployeeStatuaryService employeeStatuaryService;
	
	@Autowired
	EmployeeIdProofService employeeIdProofService;
	
	@Autowired
	PayRollLockService payRollLockService;
	
	@Autowired
	PayHeadService payHeadService;
	
	@Autowired
	PayStructureService payStructureService;
	
	@Autowired
	OneTimeDeductionService oneTimeDeductionService;
	
	@Autowired
	FamilyService familyService;
	
	
	PayRollValidation payRollValidation = new PayRollValidation();
	
	

	/**
	 * @throws PayRollProcessException 
	 * 	
	 */
	@Override
	public void processPayRoll( long companyId , String payMonth, long userId)  {
		List<Department> departmentList = payrollControlService.findAllDepartmentForPayRoll(companyId, payMonth ); 
		Epf epf = epfService.getEPF(companyId);
		Esi esi = esicService.getESI(companyId);
		
		DrowpdownHd bankList = dropDownHdService.findDropDownById(  DropDownEnum.BankName.drowpdownId );
		
		PayrollControl payrollControl = payrollControlService.findPayrollControlByMonth(companyId, payMonth);
		// payMonth = "01";

		
		for (Department department : departmentList) {
			processPayRollByDepartment(companyId, department.getDepartmentId(), epf, esi, userId, payrollControl, bankList );
		}
		
		
	}

	/**
	 * @throws PayRollProcessException 
	 * 	
	 */

	
	
	/**
	 * 
	 * @param companyId
	 * @param departmentId
	 * @param epf
	 * @param esi
	 * @throws PayRollProcessException 
	 */
	@Override
	public void  processPayRollByDepartment( Long companyId, Long departmentId, Epf epf, Esi esi, Long userId , PayrollControl payrollControl , DrowpdownHd bankList) {
	//public void processPayRollByDepartment( Long companyId, Long departmentId, Epf epf, Esi esi,  Long userId, PayrollControl payrollControl )  {

		//try {
		
		List<ReportPayOut> reportPayOuts = fetchEmployeeForSalary(companyId, departmentId, payrollControl.getProcessMonth() );
		List<Employee> employeeList = fetchEmployeeOfDepartment(departmentId);
		
	
		if ( employeeList != null && employeeList.size() > 0 ) {
			//payRollValidation.validation( attendanceList, employeeList );
			List<PayOut> payOuts = new ArrayList<PayOut>();
		
			calculateNetPay( reportPayOuts , epf, esi, payOuts, userId,  payrollControl, bankList );
			
		
			payOutRepository.save( payOuts );
			reportPayOutRepository.save( reportPayOuts );
			
			PayRollLock payRollLock = new PayRollLock();
			PayRollLockPK pk = new PayRollLockPK();
			pk.setDepartmentId(departmentId);
			pk.setProcessMonth( payrollControl.getProcessMonth() );
			payRollLock.setId(pk);
			payRollLock.setDateCreated(new Date());
			payRollLock.setIsPayRollLocked("true");
			payRollLock.setUserId(userId);
			payRollLock.setScreenName("PayRollProcess");
			Company company = new Company();
			company.setCompanyId(companyId);
			payRollLock.setCompany(company);
			
			payRollLockService.save(payRollLock);
			
		}
		/*} catch ( PayRollProcessException payRollProcessException ) {
			
		}*/

	}

	/**
	 * 
	 * @param companyId
	 * @param departmentId
	 * @return
	 */
	private List<ReportPayOut> fetchEmployeeForSalary( long companyId, long departmentId, String payMonth ) {

		 List<ReportPayOut> reportPayOuts = new ArrayList< ReportPayOut >();
		 
		 reportPayOuts =  attendanceService.fetchEmployeeForSalary( companyId, departmentId, payMonth );
		
		return reportPayOuts;
	};

	/**
	 * 
	 * @param departmentId
	 * @return
	 */
	private List<Employee> fetchEmployeeOfDepartment( long departmentId ) {

		 List<Employee> employees = new ArrayList< Employee >();
		 
		 employees =  attendanceRepository.fetchEmployeeOfDepartment( departmentId );
		 
		 return employees;
	};

	/**
	 * 
	 * @param attendanceList 
	 * @param epf
	 * @param esi
	 * @return
	 */
	private List<PayOut> calculateNetPay(List<ReportPayOut> reportPayOuts , Epf epf, Esi esi, 
			List<PayOut> payOuts , long userId, PayrollControl payrollControl, DrowpdownHd bankList ) {

		EnumUtil enumUtil = new EnumUtil();
		String bankName = null;
		List<LoanIssue> loanIssues =  null;
		List<OneTimeDeduction> oneTimeDeductionList =  null;
		for (ReportPayOut reportPayOut : reportPayOuts) {
			    reportPayOut.setUserId(userId);
			    reportPayOut.setDateCreated(new Date());
			    
			    bankName = enumUtil.getEnumValue( bankList , reportPayOut.getBankShortName() );
			    
			    reportPayOut.setBankName(bankName);
			    
			    List<EmployeeStatuary>  empStatuaries =  employeeStatuaryService.findAllEmployeeStatuary( reportPayOut.getId().getEmployeeId() );
			    
			    List<EmployeeIdProof>  idList =  employeeIdProofService.findAllemployeeIdProofs( reportPayOut.getId().getEmployeeId() );
			    
			    if ( empStatuaries != null ) {
			    	setEmployeeStatuary( reportPayOut, empStatuaries );
			    }
			    
			    if ( idList != null ) {
			    	setEmployeeID( reportPayOut, idList );
			    }
			    
			    BigDecimal payDays =  new BigDecimal( payrollControl.getPayrollDays());
				int daysWorkedStep1 = payDays.subtract( reportPayOut.getAbsense() ).intValueExact();
			    reportPayOut.setPayDays( new BigDecimal (daysWorkedStep1));
			    
			   loanIssues = new ArrayList<LoanIssue>(); 
			   loanIssues = loanIssueService.getLoanIssueDetails( reportPayOut.getId().getEmployeeId(), payrollControl.getProcessMonth() );
			   oneTimeDeductionList = oneTimeDeductionService.findOneTimeDeductionForEmployee(reportPayOut.getId().getEmployeeId() , payrollControl.getProcessMonth()) ;
			  
				processSalaryForEmployee(epf, esi, payOuts, reportPayOut, payrollControl , loanIssues, oneTimeDeductionList );
				
				if ( loanIssues != null)
				loanIssueService.save(loanIssues);
		}

		return payOuts;
	}
	
	private void setEmployeeStatuary( ReportPayOut reportPayOut, List<EmployeeStatuary> statuaries ) {
		
		for ( EmployeeStatuary employeeStatuary : statuaries) {
			if ( employeeStatuary.getStatuaryType().equals("UA") ) {
				reportPayOut.setUanno( employeeStatuary.getStatuaryNumber());
				//reportPayOut.setAadharNo( employeeStatuary.getStatuaryNumber() );
				
				EmployeeFamily empFamily = familyService.findFamily( employeeStatuary.getFamilyId() );
				if ( empFamily != null ) {
					reportPayOut.setEpfNominee(empFamily.getName());
					
					reportPayOut.setEpfNomineeRelation( getReleation( empFamily.getRelation() ));
				}
				
			}
			if (  employeeStatuary.getStatuaryType().equals("PF") ) {
				reportPayOut.setPFNumber( employeeStatuary.getStatuaryNumber() );
				reportPayOut.setEpfJoining(  employeeStatuary.getDateFrom() );
				/*if ( empFamily != null ) {
					reportPayOut.setNominee(empFamily.getName());
					reportPayOut.setNomineeRelation(empFamily.getRelation());
				}*/
				
			}
			if (  employeeStatuary.getStatuaryType().equals("ES") ) {
				reportPayOut.setESICNumber( employeeStatuary.getStatuaryNumber() );
				EmployeeFamily empFamily = familyService.findFamily( employeeStatuary.getFamilyId() );
				if ( empFamily != null ) {
					reportPayOut.setEsicNominee(empFamily.getName());
					reportPayOut.setEsicNomineeRelation( getReleation(  empFamily.getRelation() ));
				}
			}
		}
		
	}
	
	private String getReleation( String releationShip ) {
		
		String releationName = null;
		if ( releationShip.equalsIgnoreCase("FA") ) {
			releationName = "Father";
		} else if ( releationShip.equalsIgnoreCase("SP") ) {
			releationName = "Spouse";
		} else if ( releationShip.equalsIgnoreCase("MO") ) {
			releationName = "Mother";
		} else if ( releationShip.equalsIgnoreCase("CH") ) {
			releationName = "Child";
		} else if ( releationShip.equalsIgnoreCase("SI") ) {
			releationName = "Sister";
		}
		return releationName;
	}
	
	
private void setEmployeeID( ReportPayOut reportPayOut, List<EmployeeIdProof>  idList ) {
		
		for ( EmployeeIdProof  id : idList) {
			/*if ( id.getIdTypeId().equals("AA") ) {
				
				reportPayOut.setAadharNo( id.getIdNumber() );
			}*/
			if (  id.getIdTypeId().equals("PA") ) {
				reportPayOut.setPanno( id.getIdNumber() );
			}
			/*if (  id.getIdTypeId().equals("DL") ) {
				reportPayOut.setESICNumber( id.getIdNumber() );
			}*/
		}
		
	}
	
	
//Note : Please Insert processSalaryForEmployee logic into this processSalaryForEmployeeForTds also 
	/**
	 * @param epf
	 * @param esi
	 * @param payMonth
	 * @param payOuts
	 * @param attendance
	 */
	private void processSalaryForEmployee(Epf epf, Esi esi,  List<PayOut> payOuts,
			ReportPayOut reportPayOut, PayrollControl payrollControl, List<LoanIssue> loanIssues, List<OneTimeDeduction> oneTimeDeductionList ) {
		
		PayRollProcessUtil util = new PayRollProcessUtil();
		BigDecimal netSalary = new BigDecimal(0);
		PayRollProcessHDDTO payRollProcessHDDTO = new PayRollProcessHDDTO();
		
		payRollProcessHDDTO.setPayMonth(payrollControl.getProcessMonth());
		payRollProcessHDDTO.setEpf(epf);
		payRollProcessHDDTO.setEsi(esi);	
		payRollProcessHDDTO.setReportPayOut(reportPayOut);
		setProfessionalTax(reportPayOut, payRollProcessHDDTO);
		List<PayRollProcessDTO> earningPayStructures = new ArrayList<PayRollProcessDTO>();
		
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		
		/*List<PayStructure> payStructures = attendanceRepository
				.fetchPayStructureByEmployee( reportPayOut.getId().getEmployeeId(), currentDate  );*/
		
		logger.info( " reportPayOut.getId().getEmployeeId() "+ reportPayOut.getId().getEmployeeId() );
		
		PayStructureHd payStructureHd = payStructureService.findPayStructure(  reportPayOut.getId().getEmployeeId() );
		
		for ( PayStructure payStructure :  payStructureHd.getPayStructures() ) {
			if ( payStructure.getPayHead().getEarningDeduction() == null ) {
				PayHead payHead = payHeadService.findPayHeadById( payStructure.getPayHead().getPayHeadId() );
				payStructure.setPayHead(payHead);   
			}
		}
		
		 processEarning( payOuts, reportPayOut, util, payRollProcessHDDTO, earningPayStructures, payStructureHd.getPayStructures() , payrollControl  );
		 
		 
		 
		 if (earningPayStructures != null && earningPayStructures.size() > 0) {
			payRollProcessHDDTO.setTotalGrossSalary( reportPayOut.getGrossSalary() );
			payOuts.addAll(calcualteDeduction( payRollProcessHDDTO, reportPayOut, payrollControl, payStructureHd ,loanIssues, oneTimeDeductionList ));
		}
		 
		
		 
		 if ( reportPayOut.getGrossSalary() != null ) {
			 netSalary = reportPayOut.getTotalEarning().subtract( reportPayOut.getTotalDeduction() );
		 }
		
		 reportPayOut.setNetPayableAmount( netSalary );
	}

	//Tds calculation


	/**
	 * @param epf
	 * @param esi
	 * @param payMonth
	 * @param payOuts
	 * @param attendance
	 */
	private void processSalaryForEmployeeForTds(Epf epf, Esi esi,  List<PayOut> payOuts,
			ReportPayOut reportPayOut, PayrollControl payrollControl, List<LoanIssue> loanIssues, List<OneTimeDeduction> oneTimeDeductionList,PayStructureHd payStructureHd  ) {
		
		logger.info("processSalaryForEmployeeForTds is calling :");
		PayRollProcessUtil util = new PayRollProcessUtil();
		BigDecimal netSalary = new BigDecimal(0);
		PayRollProcessHDDTO payRollProcessHDDTO = new PayRollProcessHDDTO();
		
		payRollProcessHDDTO.setPayMonth(payrollControl.getProcessMonth());
		payRollProcessHDDTO.setEpf(epf);
		payRollProcessHDDTO.setEsi(esi);	
		payRollProcessHDDTO.setReportPayOut(reportPayOut);
		setProfessionalTax(reportPayOut, payRollProcessHDDTO);
		List<PayRollProcessDTO> earningPayStructures = new ArrayList<PayRollProcessDTO>();
		
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		
		/*List<PayStructure> payStructures = attendanceRepository
				.fetchPayStructureByEmployee( reportPayOut.getId().getEmployeeId(), currentDate  );*/
		
		logger.info( " reportPayOut.getId().getEmployeeId() "+ reportPayOut.getId().getEmployeeId() );
		
		//PayStructureHd payStructureHd = payStructureService.findPayStructure(  reportPayOut.getId().getEmployeeId() );
		
		for ( PayStructure payStructure :  payStructureHd.getPayStructures() ) {
			if ( payStructure.getPayHead().getEarningDeduction() == null ) {
				PayHead payHead = payHeadService.findPayHeadById( payStructure.getPayHead().getPayHeadId() );
				payStructure.setPayHead(payHead);   
			}
		}
		
		 processEarning( payOuts, reportPayOut, util, payRollProcessHDDTO, earningPayStructures, payStructureHd.getPayStructures() , payrollControl  );
		 
		 
		 
		 if (earningPayStructures != null && earningPayStructures.size() > 0) {
			payRollProcessHDDTO.setTotalGrossSalary( reportPayOut.getGrossSalary() );
			payOuts.addAll(calcualteDeduction( payRollProcessHDDTO, reportPayOut, payrollControl, payStructureHd ,loanIssues, oneTimeDeductionList ));
		}
		 
		
		 
		 if ( reportPayOut.getGrossSalary() != null ) {
			 netSalary = reportPayOut.getTotalEarning().subtract( reportPayOut.getTotalDeduction() );
		 }
		
		 reportPayOut.setNetPayableAmount( netSalary );
	}


	//Tds
	
	
	/**
	 * @param reportPayOut
	 * @param payRollProcessHDDTO
	 */
	private void setProfessionalTax(ReportPayOut reportPayOut, PayRollProcessHDDTO payRollProcessHDDTO) {
		if ( reportPayOut.getStateId() != null ) {
			
			ProfessionalTax professionalTax = professionalTaxService.findProfessionalTaxOfEmployee( reportPayOut.getStateId(), reportPayOut.getCompanyId() );
			payRollProcessHDDTO.setProfessionalTax(professionalTax);
		}
	}

	


	/**
	 * @param payMonth
	 * @param payOuts
	 * @param reportPayOut
	 * @param util
	 * @param payRollProcessHDDTO
	 * @param grossAmountamount
	 * @param earningPayStructures
	 * @param payStructures
	 * @return
	 */
	private BigDecimal processEarning( List<PayOut> payOuts, ReportPayOut reportPayOut,
			PayRollProcessUtil util, PayRollProcessHDDTO payRollProcessHDDTO , 
			List<PayRollProcessDTO> earningPayStructures, List<PayStructure> payStructures, PayrollControl payrollControl ) {
		
		BigDecimal grossAmount = new BigDecimal(0);
		BigDecimal totalEarningAmount = new BigDecimal(0);
		
		if (payStructures != null && payStructures.size() > 0) {
			for (PayStructure payStructure : payStructures) {
			
			
				if (payStructure.getPayHead().getEarningDeduction()
						.equals(EarningDeductionEnum.Earning.getEarningDeductionType())) {
					
					PayRollProcessDTO payRollProcessDTO = new PayRollProcessDTO();
					PayOut payOut = calcualteEarning(payStructure, reportPayOut, payrollControl );
					totalEarningAmount = totalEarningAmount.add( payOut.getAmount() );
					grossAmount = grossAmount.add(payStructure.getAmount());				
					util.fillEarningValueInReportPayOut( reportPayOut, payStructure.getPayHead().getPayHeadId(), payStructure.getAmount(), payOut.getAmount() );			
					payOuts.add(payOut);
					payRollProcessDTO.setPayOut(payOut);
					payRollProcessDTO.setPayStructure(payStructure);
					earningPayStructures.add(payRollProcessDTO);
				}
			}
			reportPayOut.setTotalEarning( totalEarningAmount );
			reportPayOut.setGrossSalary( grossAmount );
			payRollProcessHDDTO.setListPayRollProcessDTOs(earningPayStructures);
		}
		return grossAmount;
	}

	
	/**
	 * 
	 * @param payStructure
	 * @param attendance
	 * @return
	 */
	private PayOut calcualteEarning( PayStructure payStructure, ReportPayOut reportPayOut, PayrollControl payrollControl ) {
		PayOut payOut = new EarningTypeFactory(payStructure.getPayHead().getIncomeType()).getEarningType()
				.calculateEarning( payStructure, reportPayOut , payrollControl );
		return payOut;

	};

	/**
	 * 
	 * @param earningPayStructures
	 * @param attendance
	 * @param epf
	 * @param esi
	 * @return
	 */
	
	private List<PayOut> calcualteDeduction( PayRollProcessHDDTO payRollProcessHDDTO, ReportPayOut reportPayOut, PayrollControl payrollControl, PayStructureHd payStructureHd , List<LoanIssue> loanIssues , List<OneTimeDeduction> oneTimeDeductionList ) {		
		CalculationPayHead calculationPayHead = new CalculationPayHead();
		BigDecimal totalDeductionAmount = new BigDecimal(0);
		List<PayOut> dedudtionPayOuts = calculationPayHead.calculationDeduction( payRollProcessHDDTO, payrollControl, payStructureHd );
		
		// loan calculation 
		 if ( loanIssues != null ) {
			 LoanCalculation loanCalculation = new LoanCalculation();
			 List< PayOut > loanPayOuts = loanCalculation.calculateLoan(loanIssues, reportPayOut, payRollProcessHDDTO.getPayMonth());
			 
			 BigDecimal loanAmount = new BigDecimal(0.0);
			 for (PayOut payout : loanPayOuts ) {
					if ( payout.getAmount() != null) {
						
						 loanAmount = loanAmount.add(payout.getAmount());
					}
				}
			
			 reportPayOut.setLoan( loanAmount );
			 
			 dedudtionPayOuts.addAll( loanPayOuts ) ;
		 }
		
		 //One Time Deduction
		 if ( oneTimeDeductionList != null ) {
			 OneTimeDeductionCalculation oneTimeDeductionCalculation = new OneTimeDeductionCalculation();
			 PayOut payOut = oneTimeDeductionCalculation.calculateOneTimeDeduction(oneTimeDeductionList, reportPayOut, payRollProcessHDDTO.getPayMonth());
			 dedudtionPayOuts.add(payOut);
		 }
		 
		for ( PayOut payOut :  dedudtionPayOuts ) {
			
			if ( payOut != null ) {
				 if(	  payOut.getId().getPayHeadId() != StandardDeductionEnum.PF_Employer_Contribution.getStandardDeduction() 
						   && payOut.getId().getPayHeadId() != StandardDeductionEnum.Pension_Employer_Contribution .getStandardDeduction()  
						   		&&  payOut.getId().getPayHeadId() != StandardDeductionEnum.ESI_Employer_Contribution.getStandardDeduction() ) {
					 
					 logger.info  (" totalDeductionAmount ====== "+totalDeductionAmount );
					 logger.info  (" payOut.getAmount()  ====== "+payOut.getAmount() );
					 
					 if ( totalDeductionAmount != null && payOut != null &&  payOut.getAmount() != null ) {
					   totalDeductionAmount = totalDeductionAmount.add(payOut.getAmount());
					 }
					   
				   } 
			}
		  		
		}
		 
		reportPayOut.setTotalDeduction( totalDeductionAmount );
		return dedudtionPayOuts ;
	};
	
	@Override
	public List<PayOut> processPayRoll(long companyId, long employeeId) {
		logger.info("processPayRoll employeeId is : "+employeeId );
		List<PayOut> payOuts = new ArrayList<PayOut>();
		Epf epf = epfService.getEPF(companyId);
		Esi esi = esicService.getESI(companyId);
		
		
		
		//PayrollControl payrollControl = payrollControlService.findPayrollControlByMonth(companyId, payMonth);
		PayrollControl payrollControl =  new PayrollControl();
		payrollControl.setProcessMonth("MAR-2018");
		payrollControl.setPayrollDays(31);

		Employee employee = employeeService.findEmployeesById(employeeId);
		
		ReportPayOut reportPayOut = new ReportPayOut();
		reportPayOut.setAbsense( new BigDecimal(0) );
		reportPayOut.setPayDays( new BigDecimal(31) );
		reportPayOut.setCompanyId(companyId);
		
		ReportPayOutPK pk = new ReportPayOutPK();
		pk.setProcessMonth( "MAR-2018" );
		pk.setEmployeeId( employee.getEmployeeId()   );
		reportPayOut.setId( pk );
		
		
		if ( employee.getDepartment() != null ) 
			reportPayOut.setDepartmentId(employee.getDepartment().getDepartmentId());
		
		if ( employee.getCity() != null ) 
			reportPayOut.setCityId( employee.getCity().getCityId() );
		if ( employee.getState()!= null ) 
			reportPayOut.setStateId( employee.getState().getStateId() );
		
		reportPayOut.setDateOfJoining( employee.getDateOfJoining()  );
		processSalaryForEmployee( epf, esi  ,payOuts, reportPayOut, payrollControl, null, null );
		 
		 
		 return payOuts;
	}
	
	
	@Override
	public  List<PayOut> processPayRollForTds(long companyId, long employeeId,PayStructureHd payStructureHd )  {
		
		logger.info("processPayRollForTds employeeId is : "+employeeId );
		
		List<PayOut> payOuts = new ArrayList<PayOut>();
		Epf epf = epfService.getEPF(companyId);
		Esi esi = esicService.getESI(companyId);
		
		
		
		//PayrollControl payrollControl = payrollControlService.findPayrollControlByMonth(companyId, payMonth);
		PayrollControl payrollControl =  new PayrollControl();
		payrollControl.setProcessMonth("MAR-2018");
		payrollControl.setPayrollDays(31);

		Employee employee = employeeService.findEmployeesById(employeeId);
		
		ReportPayOut reportPayOut = new ReportPayOut();
		reportPayOut.setAbsense( new BigDecimal(0) );
		reportPayOut.setPayDays( new BigDecimal(31) );
		reportPayOut.setCompanyId(companyId);
		
		ReportPayOutPK pk = new ReportPayOutPK();
		pk.setProcessMonth( "MAR-2018" );
		pk.setEmployeeId( employee.getEmployeeId()   );
		reportPayOut.setId( pk );
		
		
		if ( employee.getDepartment() != null ) 
			reportPayOut.setDepartmentId(employee.getDepartment().getDepartmentId());
		
		if ( employee.getCity() != null ) 
			reportPayOut.setCityId( employee.getCity().getCityId() );
		if ( employee.getState()!= null ) 
			reportPayOut.setStateId( employee.getState().getStateId() );
		
		reportPayOut.setDateOfJoining( employee.getDateOfJoining()  );
		
		processSalaryForEmployeeForTds( epf, esi  ,payOuts, reportPayOut, payrollControl, null, null, payStructureHd  );
		 
		 
		 return payOuts;
	}
		


	

	
	

}
