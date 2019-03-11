package com.csipl.hrms.service.payroll;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.common.enums.StandardEarningEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.payroll.TdsSummaryChangeDTO;
import com.csipl.hrms.dto.payroll.TdsSummaryDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.payroll.OtherIncome;
import com.csipl.hrms.model.payroll.PreviousEmployerIncomeTds;
import com.csipl.hrms.model.payroll.TdsApproved;
import com.csipl.hrms.model.payroll.TdsCityMaster;
import com.csipl.hrms.model.payroll.TdsGroup;
import com.csipl.hrms.model.payroll.TdsHistory;
import com.csipl.hrms.model.payroll.TdsPayrollHd;
import com.csipl.hrms.model.payroll.TdsSlabHd;
import com.csipl.hrms.model.payroll.TdsStandardExemption;
import com.csipl.hrms.model.payroll.TdsSummaryChange;
import com.csipl.hrms.model.payroll.TdsTransaction;
import com.csipl.hrms.model.payroll.TransactionApprovedHd;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.model.payrollprocess.PayOut;
import com.csipl.hrms.service.adaptor.TdsSummaryChangeAdaptor;
import com.csipl.hrms.service.employee.repository.PayStructureRepository;
import com.csipl.hrms.service.payroll.repository.FinancialYearRepository;
import com.csipl.hrms.service.payroll.repository.OtherIncomeRepository;
import com.csipl.hrms.service.payroll.repository.PreviousEmployerIncomeRepository;
import com.csipl.hrms.service.payroll.repository.ReportPayOutRepository;
import com.csipl.hrms.service.payroll.repository.TdsApprovalRepository;
import com.csipl.hrms.service.payroll.repository.TdsCityMasterRepository;
import com.csipl.hrms.service.payroll.repository.TdsHistoryRepository;
import com.csipl.hrms.service.payroll.repository.TdsPayrolHdRepository;
import com.csipl.hrms.service.payroll.repository.TdsSlabRepository;
import com.csipl.hrms.service.payroll.repository.TdsSummaryChangeRepository;
import com.csipl.hrms.service.payroll.repository.TdsTransactionRepository;
import com.hrms.org.payrollprocess.tds.InvestmentTax;

@Transactional
@Service("TdsApprovalService")
public class TdsApprovalServiceImpl implements TdsApprovalService {

	private static final Logger logger = LoggerFactory.getLogger(TdsApprovalServiceImpl.class);

	@Autowired
	FinancialYearRepository financialYearRepository;
	
	@Autowired
	TdsApprovalRepository tdsApprovalRepository;

	@Autowired
	TdsSlabRepository tdsSlabRepository;

	@Autowired
	private PayStructureRepository payStructureRepository;

	@Autowired
	private TdsPayrolHdRepository tdsPayrolHdRepository;

	@Autowired
	TdsTransactionRepository tdsTransactionRepository;

	@Autowired
	ReportPayOutRepository reportPayOutRepository;

	@Autowired
	OtherIncomeRepository otherIncomeRepository;

	@Autowired
	TdsSummaryChangeRepository tdsSummaryChangeRepository;
	
	@Autowired
	TdsCityMasterRepository tdsCityMasterRepository;
	
	@Autowired
	TdsHistoryRepository tdsHistoryRepository;
	
	@Autowired
	PreviousEmployerIncomeRepository previousEmployerIncomeRepository;
	
	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;

	

	InvestmentTax investmentTax = new InvestmentTax();

	
	/**
	 * Method Performed save Or update operation
	 */
	@Override
	public void saveTdsApprovalsList(TransactionApprovedHd transactionApprovedHd, Employee employee,
			FinancialYear financialYear, Long companyId, Long userId, List<PayOut> payOutList,
			TdsStandardExemption tdsStandardExemption, List<OtherIncome> otherIncomeList,boolean payStrFlag,List<TdsTransaction> tdsTrasactionistDb) {
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		TdsSummaryChangeAdaptor tdsSummaryChangeAdaptor=new TdsSummaryChangeAdaptor();
		
		TdsHistory tdsHistory=new TdsHistory();
		
		List<TdsSlabHd> tdsSlabHdList=tdsSlabRepository.findAllTdsSlabList(companyId);
		
		TdsSlabHd tdsSlabHd = null;
		int age = DateUtils.getAgeCalaulation(employee.getDateOfBirth(), currentDate);
		logger.info("age : " + age +"employee category : "+employee.getGender());
		if (age >= 60)
			tdsSlabHd = tdsSlabRepository.finddsSlab(companyId, "SE");
		else
			tdsSlabHd = tdsSlabRepository.finddsSlab(companyId, employee.getGender());// employee.getGender()
	

		logger.info("financialYear.getFinancialYear-------" + financialYear.getFinancialYear() +"employee id :"+ employee.getEmployeeId());

		BigDecimal totalOtherIncome = otherIncomeRepository.findOtherIncomeSum(employee.getEmployeeId(),financialYear.getFinancialYear());
		
		List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsList=previousEmployerIncomeRepository.getAllPreviousEmployerIncome(employee.getEmployeeId(),financialYear.getFinancialYear());
		
		totalOtherIncome = totalOtherIncome == null ? new BigDecimal(0.0) : totalOtherIncome;
		tdsStandardExemption= tdsStandardExemption == null ? new TdsStandardExemption() : tdsStandardExemption;
		
		//TdsSummaryDTO tdsSummaryDto = investmentTax.calcutateExamptionAndTaxAmount(payOutList, tdsStandardExemption,totalOtherIncome, tdsSlabHd, financialYear, employee, previousEmployerIncomeTdsList);
		//TdsPayrollHd tdsPayrollHd = investmentTax.calculateEmployeeIvestment( tdsSlabHd,transactionApprovedHd, financialYear.getFinancialYear(), tdsSummaryDto,employee, previousEmployerIncomeTdsList);

		TdsSummaryChangeDTO tdsSummaryChangeDto = investmentTax.calcutateChangeExamptionAndTaxAmount(payOutList,transactionApprovedHd, tdsStandardExemption,totalOtherIncome, tdsSlabHdList, financialYear, employee, previousEmployerIncomeTdsList);
		TdsPayrollHd tdsChangePayrollHd = investmentTax.calculateChangeEmployeeIvestment( tdsSlabHd, financialYear.getFinancialYear(), tdsSummaryChangeDto,employee);

		
		TdsSummaryChange tdsSummaryChange=tdsSummaryChangeAdaptor.uiDtoToDatabaseModel(tdsSummaryChangeDto);//tdsSummaryAdaptor.uiDtoToDatabaseModel(tdsSummaryDto);
		
		logger.info(tdsSummaryChangeDto.toString());
		tdsSummaryChange.setEmployee(employee);
		tdsSummaryChange.setFinancialYear(financialYear.getFinancialYear());
		tdsSummaryChange.setActive("AC");
		tdsSummaryChange.setDateCreated(new Date());
		// history object
		if(payStrFlag==false) {
		TransactionApprovedHd transactionApprovedHdPrivious = tdsApprovalRepository
				.getTransactionApprovedHd(employee.getEmployeeId(), financialYear.getFinancialYear());
		if (transactionApprovedHdPrivious != null) {
			transactionApprovedHdPrivious.setDateUpdate(new Date());
			transactionApprovedHdPrivious.setActive("DE");
			tdsApprovalRepository.save(transactionApprovedHdPrivious);
		}
		}
		// history object
		TdsPayrollHd tdsPayrollHdPrivious = tdsPayrolHdRepository.getTdsPayrollHd(employee.getEmployeeId(),
				financialYear.getFinancialYear());
		if (tdsPayrollHdPrivious != null) {
			tdsPayrollHdPrivious.setDateUpdate(new Date());
			tdsPayrollHdPrivious.setActive("DE");
			tdsPayrolHdRepository.save(tdsPayrollHdPrivious);
		}
		
		TdsSummaryChange tdsSummaryChangePrevious=tdsSummaryChangeRepository.findTdsSummary(employee.getEmployeeId(),
				financialYear.getFinancialYear());
		if (tdsSummaryChangePrevious != null) {
			tdsSummaryChangePrevious.setDateUpdate(new Date());
			tdsSummaryChangePrevious.setActive("DE");
			tdsSummaryChangeRepository.save(tdsSummaryChangePrevious);
		}
		
		// new declaration
		if(transactionApprovedHd!=null) {
		transactionApprovedHd.setActive("AC");
		tdsApprovalRepository.save(transactionApprovedHd);
		}
		tdsChangePayrollHd.setActive("AC");
		tdsChangePayrollHd.setDateUpdate(new Date());
		tdsPayrolHdRepository.save(tdsChangePayrollHd);
		tdsSummaryChangeRepository.save(tdsSummaryChange);
		if(tdsTrasactionistDb!=null)
		tdsTransactionRepository.save(tdsTrasactionistDb);
		//tdsTransactionRepository.updateStatus(employee.getEmployeeId(),financialYear.getFinancialYear());
		otherIncomeRepository.updateStatus(employee.getEmployeeId(),financialYear.getFinancialYear());
		
		TransactionApprovedHd transactionApprovedHdDb=tdsApprovalRepository.getTransactionApprovedHd(employee.getEmployeeId(), financialYear.getFinancialYear());
		if(transactionApprovedHdDb!=null) {
		tdsHistory.setFinancialYear(financialYear.getFinancialYear());
		tdsHistory.setStatus(transactionApprovedHdDb.getStatus());
		tdsHistory.setDateCreated(new Date());
		tdsHistory.setApproveId(userId);
		Employee emp=new Employee();
		emp.setEmployeeId(employee.getEmployeeId());
		tdsHistory.setEmployee(emp);
		tdsHistoryRepository.save(tdsHistory);
		}
	}
	
	
	@Override
	public TransactionApprovedHd getTransactionApprovedHd(Long employeeId,String financialYear) {
		return tdsApprovalRepository.getTransactionApprovedHd(employeeId,financialYear);
	}

	/**
	 * to get TransactionApprovedHd Object from database
	 */
	@Override
	public TransactionApprovedHd createTdsApprovals(List<TdsGroup> tdsGroupList, List<TdsTransaction> tdsTrasactionist,
			Employee employee, Long companyId, FinancialYear financialYear, String status) {
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		BigDecimal amountMetroPer=new BigDecimal(0.0);
		BigDecimal amountNonMetroPer=new BigDecimal(0.0);
		BigDecimal basicDaAmount=new BigDecimal(0.0);
		BigDecimal actualRentAmount=new BigDecimal(0.0);
		BigDecimal hraPer=new BigDecimal(HrmsGlobalConstantUtil.hraPer);
		TransactionApprovedHd transactionApprovedHd = new TransactionApprovedHd();

		List<TdsApproved> tdsApprovedList = new ArrayList<TdsApproved>();
		
		Date joiningDate = employee.getDateOfJoining();
		Date finYearLastDate = financialYear.getDateTo();
		// getDateTdsDif
		logger.info("joiningDate :  "+joiningDate+"  finYearLastDate  "+finYearLastDate);
		String dateDiffersnce = DateUtils.getDateTdsDif(joiningDate, finYearLastDate);
		logger.info("Date month :  "+dateDiffersnce);
		String[] differences = dateDiffersnce.split(",");
		BigDecimal year = new BigDecimal(Integer.parseInt(differences[0]));
		BigDecimal month = new BigDecimal(Integer.parseInt(differences[1]));
		//BigDecimal days = new BigDecimal(Integer.parseInt(differences[2]));
		//days = days != null ? days.add(new BigDecimal(1)) : new BigDecimal(0);
		boolean tdsFullYearFlag = Integer.parseInt(differences[0]) > 0 ? true : false;
		
		boolean actualRentAmountFlag=false;
		
		PayStructureHd payStructureHd = payStructureRepository.payStructureRevisionList(currentDate,employee.getEmployeeId());
		System.out.println(StandardEarningEnum.BasicSalary.getStandardEarning()+"----------"+StandardEarningEnum.DearnessAllowance.getStandardEarning());
		
	    for(PayStructure payStructure:payStructureHd.getPayStructures()) {
			if(payStructure.getPayHead().getPayHeadId().longValue()==StandardEarningEnum.BasicSalary.getStandardEarning()||payStructure.getPayHead().getPayHeadId().longValue()==StandardEarningEnum.DearnessAllowance.getStandardEarning())
                basicDaAmount=basicDaAmount.add(payStructure.getAmount());
			if(payStructure.getPayHead().getPayHeadId().longValue()==StandardEarningEnum.HouseRentAllowance.getStandardEarning()) {
				actualRentAmountFlag=true;
				actualRentAmount=actualRentAmount.add(payStructure.getAmount());
				System.out.println("----------------"+actualRentAmount);
			}
		}
		
	    List<TdsCityMaster> tdsCityMasterList=tdsCityMasterRepository.getTdsCityMaster(companyId, financialYear.getFinancialYear());
	    for(TdsCityMaster tdsCityMaster:tdsCityMasterList) {
			if(tdsCityMaster.getCityType().equals("ME")) {
				amountMetroPer=amountMetroPer.add(tdsCityMaster.getPercentage());
			}
            if(tdsCityMaster.getCityType().equals("NM"))
            	amountNonMetroPer=amountNonMetroPer.add(tdsCityMaster.getPercentage());
		}
		
	   
	    boolean section10Flag = false;
	    boolean section24Flag = false;
		for (TdsGroup tdsGroup : tdsGroupList) {
			
			 boolean section1024Flag = true;

			TdsApproved tdsApproved = new TdsApproved();

			BigDecimal approvedAmount = new BigDecimal(0.0);
			BigDecimal approvedAmountFor80c = new BigDecimal(0.0);
			BigDecimal limitAmount = new BigDecimal(0.0);
			BigDecimal proofAmount = new BigDecimal(0.0);
			boolean checkFlag = false;
			
			if(tdsGroup.getTdsGroupName().equals("Section 10") ||tdsGroup.getTdsGroupName().equals("Section 24"))
				section1024Flag=false;
			
			logger.info("groupId : ------------------"+tdsGroup.getTdsGroupId().toString());
			for (TdsTransaction tdsTransaction : tdsTrasactionist) {
				if (tdsGroup.getTdsGroupName().equals("80C") && tdsGroup.getTdsGroupId().longValue() == tdsTransaction.getTdsGroup().getTdsGroupId().longValue()) {
					
					if(status.equals("DC")||(status.equals("AP") && tdsTransaction.getApproveStatus()!=null && tdsTransaction.getApproveStatus().equals("Y"))) {
					checkFlag = true;
					limitAmount = tdsGroup.getMaxLimit();
					proofAmount = proofAmount.add(tdsTransaction.getInvestmentAmount());
					approvedAmountFor80c = approvedAmountFor80c.add(tdsTransaction.getInvestmentAmount());
					if (tdsGroup.getMaxLimit().compareTo(approvedAmountFor80c) >= 0)
						approvedAmount = approvedAmount.add(tdsTransaction.getInvestmentAmount());
					else
						approvedAmount = tdsGroup.getMaxLimit();
					if(status.equals("DC")) 
						tdsTransaction.setStatus("Declared");
						else
							tdsTransaction.setStatus("Approved");
					}
					else if(status.equals("AP") && tdsTransaction.getApproveStatus()!=null && tdsTransaction.getApproveStatus().equals("N")) 
						tdsTransaction.setStatus("Rejected");
					else 
						tdsTransaction.setStatus("Pending");
				} 
				else if(tdsGroup.getTdsGroupName().equals("Section 10") && tdsGroup.getTdsGroupId().longValue() == tdsTransaction.getTdsGroup().getTdsGroupId().longValue() && tdsTransaction.getInvestmentAmount().compareTo(new BigDecimal(0.0))>0){
					section10Flag = true;
					
					if(status.equals("DC")||(status.equals("AP") && tdsTransaction.getApproveStatus()!=null && tdsTransaction.getApproveStatus().equals("Y"))) {
					checkFlag = true;
					if(actualRentAmountFlag) {
					actualRentAmount=actualRentAmount.subtract(basicDaAmount.multiply(hraPer).divide(new BigDecimal(100), 2,RoundingMode.CEILING));
					System.out.println("actualRentAmount----------------------"+actualRentAmount);
					}
					proofAmount = proofAmount.add(tdsTransaction.getInvestmentAmount());
					System.out.println("proofAmount-------------------"+proofAmount);
					if(tdsTransaction.getCity().equals("ME")) 
						limitAmount = limitAmount.add(basicDaAmount.multiply(amountMetroPer).divide(new BigDecimal(100), 2,RoundingMode.CEILING));
					if(tdsTransaction.getCity().equals("NM")) 
						limitAmount = limitAmount.add(basicDaAmount.multiply(amountNonMetroPer).divide(new BigDecimal(100), 2,RoundingMode.CEILING));
					
					System.out.println("limitAmount------------------"+limitAmount);
					if(actualRentAmountFlag) {
				    if(actualRentAmount.compareTo(proofAmount)<=0) {
				    	if(actualRentAmount.compareTo(limitAmount)<=0)
				    		approvedAmount=actualRentAmount;
				    	else
				    		approvedAmount=limitAmount;
				    }
				    else
				    {
				    	if(proofAmount.compareTo(limitAmount)<=0)
				    		approvedAmount=proofAmount;
				    	else
				    		approvedAmount=limitAmount;
				    }
				    
					}
					else
					 {
				    	if(proofAmount.compareTo(limitAmount)<=0)
				    		approvedAmount=proofAmount;
				    	else
				    		approvedAmount=limitAmount;
				    }
				    /*if(proofAmount.compareTo(limitAmount)>=0) 
				    	approvedAmount=limitAmount;
				    else
				    	approvedAmount=proofAmount;*/
				    
				    
				    if(tdsFullYearFlag) {
				    	approvedAmount=approvedAmount.multiply(new BigDecimal(12.0));
				    	proofAmount=proofAmount.multiply(new BigDecimal(12.0));
				    	limitAmount=limitAmount.multiply(new BigDecimal(12.0));
				    	
				    }
				    else {
				    	approvedAmount=approvedAmount.multiply(month);
				    	proofAmount=proofAmount.multiply(month);
				    	limitAmount=limitAmount.multiply(month);
				    }
				    
				    
				    if(status.equals("DC")) 
						tdsTransaction.setStatus("Declared");
						else
							tdsTransaction.setStatus("Approved");
					}
					else if(status.equals("AP") && tdsTransaction.getApproveStatus()!=null && tdsTransaction.getApproveStatus().equals("N")) 
						tdsTransaction.setStatus("Rejected");
					else 
						tdsTransaction.setStatus("Pending");
					tdsTransaction.setApprovedAmount(approvedAmount);
				}
				else if(tdsGroup.getTdsGroupName().equals("Section 24") && tdsGroup.getTdsGroupId().longValue() == tdsTransaction.getTdsGroup().getTdsGroupId().longValue() && tdsTransaction.getInvestmentAmount().compareTo(new BigDecimal(0.0))>0){
					logger.info("GroupName : "+tdsTransaction.getTdsGroup().getTdsGroupName());
					section24Flag = true;
					
					if(status.equals("DC")||(status.equals("AP") && tdsTransaction.getApproveStatus()!=null && tdsTransaction.getApproveStatus().equals("Y"))) {
					checkFlag = true;
					limitAmount = limitAmount.add(tdsTransaction.getMaxLimit());
					proofAmount = proofAmount.add(tdsTransaction.getInvestmentAmount());
					if (tdsTransaction.getMaxLimit().compareTo(tdsTransaction.getInvestmentAmount()) >= 0)
						approvedAmount = approvedAmount.add(tdsTransaction.getInvestmentAmount());
					else
						approvedAmount = tdsTransaction.getMaxLimit();
					if(status.equals("DC")) 
						tdsTransaction.setStatus("Declared");
						else
							tdsTransaction.setStatus("Approved");
					}//
					else if(status.equals("AP") && tdsTransaction.getApproveStatus()!=null && tdsTransaction.getApproveStatus().equals("N")) 
						tdsTransaction.setStatus("Rejected");
					else 
						tdsTransaction.setStatus("Pending");
						//checkApprovalFlag=true;
					tdsTransaction.setApprovedAmount(approvedAmount);
					
				}
				else if(section1024Flag && tdsGroup.getTdsGroupId().longValue() == tdsTransaction.getTdsGroup().getTdsGroupId().longValue()) {
					logger.info("groupname :"+tdsTransaction.getTdsGroup().getTdsGroupName());
					if(status.equals("DC")||(status.equals("AP") && tdsTransaction.getApproveStatus()!=null && tdsTransaction.getApproveStatus().equals("Y"))) {
					checkFlag = true;
					logger.info("maxlimit : "+tdsTransaction.getMaxLimit().toString());
					limitAmount = limitAmount.add(tdsTransaction.getMaxLimit());
					proofAmount = proofAmount.add(tdsTransaction.getInvestmentAmount());
					if (tdsTransaction.getMaxLimit().compareTo(tdsTransaction.getInvestmentAmount()) >= 0)
						approvedAmount = approvedAmount.add(tdsTransaction.getInvestmentAmount());
					else
						approvedAmount = approvedAmount.add(tdsTransaction.getMaxLimit());
					if(status.equals("DC")) 
						tdsTransaction.setStatus("Declared");
						else
							tdsTransaction.setStatus("Approved");
					}//
					else if(status.equals("AP") && tdsTransaction.getApproveStatus()!=null && tdsTransaction.getApproveStatus().equals("N")) 
						tdsTransaction.setStatus("Rejected");
					else 
						tdsTransaction.setStatus("Pending");
						//checkApprovalFlag=true;
					tdsTransaction.setApprovedAmount(approvedAmount);
				}
			}
			logger.info("-----------" + checkFlag);
			if (checkFlag) {
				//TdsGroup tdsGroup2 = new TdsGroup();
				//tdsGroup2.setTdsGroupId(tdsGroup.getTdsGroupId());
				tdsApproved.setTdsGroup(tdsGroup);

				// tdsApproved.setLimitAmount(tdsGroup.getMaxLimit());
				tdsApproved.setApprovedAmount(approvedAmount);
				tdsApproved.setProofAmount(proofAmount);
				tdsApproved.setLimitAmount(limitAmount);
				tdsApproved.setTransactionApprovedHd(transactionApprovedHd);
				tdsApprovedList.add(tdsApproved);
			}
			
		}

		
		for(TdsApproved tdsApproved : tdsApprovedList) {
			if(tdsApproved.getTdsGroup().getTdsGroupName().equalsIgnoreCase("Section 10")&& section24Flag && section10Flag) {
				for (TdsTransaction tdsTransaction : tdsTrasactionist) {
					if ( tdsApproved.getTdsGroup().getTdsGroupId().longValue() == tdsTransaction.getTdsGroup().getTdsGroupId().longValue()) {
						tdsTransaction.setApprovedAmount(new BigDecimal(0.0));
					}
				tdsApproved.setApprovedAmount(new BigDecimal(0.0));
			}
		}
	}	
		//Employee employee = new Employee();
		//employee.setEmployeeId(employeeId);
		transactionApprovedHd.setTdsApproveds(tdsApprovedList);
		transactionApprovedHd.setEmployee1(employee);
		transactionApprovedHd.setFinancialYear(financialYear.getFinancialYear());
		if (status.equals("DC"))
			transactionApprovedHd.setStatus("Declared");
		else if (status.equals("AP"))
			transactionApprovedHd.setStatus("Approved");
		
	
		return transactionApprovedHd;
	}

	@Override
	public TransactionApprovedHd getTdsApproved(Long employeeId, Long companyId) {
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		FinancialYear financialYear = financialYearRepository.getFinancialYear(currentDate, companyId);
		return tdsApprovalRepository.getTransactionApprovedHd(employeeId, financialYear.getFinancialYear());
	}

	@Override
	public TdsSummaryDTO getTdsSummary(Employee employee, Long companyId, List<PayOut> payOutList,
			TdsStandardExemption tdsStandardExemption) {
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		TdsSummaryDTO tdsSummaryDto = new TdsSummaryDTO();
		String date = "";
		List<String> monthList = new ArrayList<>();
		String month = "";
		String delim = "'";
		String processMonth = "";
		BigDecimal yearlyGross = new BigDecimal(0.0);
		BigDecimal exemptedPf = new BigDecimal(0.0);
		BigDecimal exemptedPt = new BigDecimal(0.0);
		BigDecimal exemptedEsic = new BigDecimal(0.0);
		BigDecimal exemptedAmountAsPerSlab = new BigDecimal(250000);

		BigDecimal standardExemption = tdsStandardExemption.getAmount();
		BigDecimal taxableIncomeFy = new BigDecimal(196961.94);
		BigDecimal tdsYearlyBeforeDeclaration = new BigDecimal(9848.10);
		BigDecimal declaredIncomeApproved = new BigDecimal(80000);
		BigDecimal tdsYearlyAfterDeclaration = new BigDecimal(5848.10);

		FinancialYear financialYear = financialYearRepository.getFinancialYear(currentDate, companyId);
		BigDecimal totalInvestment = tdsTransactionRepository.getTotalInvestment(employee.getEmployeeId(),
				financialYear.getFinancialYear());
		BigDecimal totalOtherIncome = otherIncomeRepository.findOtherIncomeSum(employee.getEmployeeId(),
				financialYear.getFinancialYear());
		logger.info("totalOtherIncome : " + totalOtherIncome);
		String employeeJoiningDate = getDateStringWithYYYYMMDD(employee.getDateOfJoining());
		logger.info("joining date : " + employeeJoiningDate);
		String dateFrom = getDateStringWithYYYYMMDD(financialYear.getDateFrom());
		logger.info("Date from : " + dateFrom);
		String dateTo = getDateStringWithYYYYMMDD(financialYear.getDateTo());
		logger.info("Date to : " + dateTo);
		DateFormat formater = new SimpleDateFormat("MMM-yyyy");

		Calendar empJoining = Calendar.getInstance();
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();
		try {
			empJoining.setTime(formater.parse(employeeJoiningDate));
			fromDate.setTime(formater.parse(dateFrom));
			toDate.setTime(formater.parse(dateTo));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (empJoining.before(fromDate)) {
			while (fromDate.before(toDate) || fromDate.equals(toDate)) {
				date = formater.format(fromDate.getTime()).toUpperCase();
				logger.info("if : " + date);
				fromDate.add(Calendar.MONTH, 1);
				monthList.add(date);
				logger.info("monthlist : " + monthList);
			}
		} else {
			while (empJoining.before(toDate) || empJoining.equals(toDate)) {
				date = formater.format(empJoining.getTime()).toUpperCase();
				logger.info("else : " + date);
				empJoining.add(Calendar.MONTH, 1);
				monthList.add(date);
			}
		}
		for (String months : monthList) {
			month = month.concat(delim);
			delim = "', '";
			month = month.concat(months);
		}
		delim = "'";
		month = month.concat(delim);
		logger.info("month : " + month);
		StringBuilder sb = new StringBuilder();
		String processMonthForTdsSummaryQuery = "select processMonth FROM ReportPayOut WHERE employeeId= "
				+ employee.getEmployeeId() + " and processMonth IN ( " + month + " )";
		logger.info("Query : " + processMonthForTdsSummaryQuery);
		Query nativeQuery = em.createNativeQuery(processMonthForTdsSummaryQuery);

		// List<Object[]>
		// processMonths=reportPayOutRepository.findProcessMonthForTdsSummary(employee.getEmployeeId(),
		// month);
		final List<Object[]> processMonths = nativeQuery.getResultList();
		if (processMonths != null)
			logger.info("size : " + processMonths.size());
		for (Object[] processMonthForTdsSummary : processMonths) {
			logger.info("" + processMonths);
			processMonth = processMonthForTdsSummary[0] != null ? (String) processMonthForTdsSummary[0] : null;
			logger.info(processMonth);
		}
		/*
		 * logger.info("processMonths : "+processMonths); for (String months:
		 * processMonths) { processMonth=processMonth.concat(delim); delim = "', '";
		 * processMonth=processMonth.concat (months); } delim = "'";
		 * processMonth=processMonth.concat(delim);
		 * logger.info("processMonth : "+processMonth);
		 */
		List<Object[]> objectInvestmentSummaryList = reportPayOutRepository.findTdsSummary(employee.getEmployeeId(),
				processMonth);

		for (Object[] tdsSummary : objectInvestmentSummaryList) {
			yearlyGross = tdsSummary[0] != null ? (new BigDecimal(tdsSummary[0].toString())) : new BigDecimal(0.0);
			exemptedPf = tdsSummary[1] != null ? (new BigDecimal(tdsSummary[1].toString())) : new BigDecimal(0.0);
			exemptedEsic = tdsSummary[2] != null ? (new BigDecimal(tdsSummary[2].toString())) : new BigDecimal(0.0);
			exemptedPt = tdsSummary[3] != null ? (new BigDecimal(tdsSummary[3].toString())) : new BigDecimal(0.0);
		}
		logger.info("yearlyGross : " + yearlyGross + " " + exemptedPf + " " + exemptedEsic + " " + exemptedPt);

		tdsSummaryDto.setYearlyGross(yearlyGross);
		tdsSummaryDto.setOtherIncome(totalOtherIncome);
		if (yearlyGross.compareTo(totalOtherIncome) >= 0)
			tdsSummaryDto.setNetYearlyIncome(yearlyGross.subtract(totalOtherIncome));
		else
			tdsSummaryDto.setNetYearlyIncome(yearlyGross);
		tdsSummaryDto.setExempStandard(standardExemption);
		tdsSummaryDto.setExempPfAmount(exemptedPf);
		tdsSummaryDto.setExempPtAmount(exemptedPt);
		tdsSummaryDto.setExempEsicAmount(exemptedEsic);
		tdsSummaryDto.setExempAmountAsPerSlab(exemptedAmountAsPerSlab);
		BigDecimal totalExemption = exemptedPf
				.add(exemptedPt.add(exemptedEsic.add(exemptedAmountAsPerSlab.add(standardExemption))));
		tdsSummaryDto.setExemptedTotalIncome(totalExemption);
		tdsSummaryDto.setYearlyTaxableIncome(yearlyGross.subtract(totalExemption));
		tdsSummaryDto.setTaxableIncomeFy(taxableIncomeFy);
		tdsSummaryDto.setTdsYearlyBeforeDeclaration(tdsYearlyBeforeDeclaration);
		tdsSummaryDto.setTdsMonthlyBeforeDeclaration(
				tdsYearlyBeforeDeclaration.divide(new BigDecimal(12), 2, RoundingMode.CEILING));
		tdsSummaryDto.setIncomeDeclared(totalInvestment);
		tdsSummaryDto.setDeclaredIncomeApproved(declaredIncomeApproved);
		tdsSummaryDto.setNetTaxableIncome(taxableIncomeFy.subtract(declaredIncomeApproved));
		tdsSummaryDto.setTdsYearlyAfterDeclaration(tdsYearlyAfterDeclaration);
		tdsSummaryDto.setTdsMonthlyAfterDeclaration(
				tdsYearlyAfterDeclaration.divide(new BigDecimal(12), 2, RoundingMode.CEILING));
		return tdsSummaryDto;
	}

	final static DateFormat formater1 = new SimpleDateFormat("MMM-yyyy");

	public static String getDateStringWithYYYYMMDD(Date date) {
		String dateStr = formater1.format(date);

		return dateStr;
	}
}
