package com.csipl.hrms.service.adaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.dto.payrollprocess.HeaderReportPayOutDTO;
import com.csipl.hrms.dto.payrollprocess.ReportPayOutDTO;
import com.csipl.hrms.dto.payrollprocess.ReportPayOutSalaryDTO;
import com.csipl.hrms.dto.payrollprocess.ReportPayoutSearchDTO;
import com.csipl.hrms.dto.report.EsiInfoDTO;
import com.csipl.hrms.dto.report.EsiReportTableDTO;
import com.csipl.hrms.dto.report.PfReportDTO;
import com.csipl.hrms.dto.report.PfReportTableDTO;
import com.csipl.hrms.dto.search.EmployeeSearchDTO;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.service.util.ConverterUtil;

public class ReportPayOutAdaptor  {

 
	public List<ReportPayOutDTO> modeltoDTOList(List<Object[]> reportPayOutList, ReportPayoutSearchDTO reportPayoutSearchDto) {
		List<ReportPayOutDTO> reportPayOutDTOList = new ArrayList<ReportPayOutDTO>();

		for (Object[] reportPayOutObj : reportPayOutList) {
			ReportPayOutDTO reportPayOutDto = new ReportPayOutDTO();
			String name=reportPayOutObj[0]!=null?(String)reportPayOutObj[0]:null;
			String employeeCode=reportPayOutObj[1]!=null?(String)reportPayOutObj[1]:null;
			String bankName=reportPayOutObj[2]!=null?(String)reportPayOutObj[2]:null;
			String accountNumber=reportPayOutObj[3]!=null?(String)reportPayOutObj[3]:null;
			Date dateOfJoining = reportPayOutObj[4] != null ? (Date) reportPayOutObj[4] : null;
			BigDecimal basic=reportPayOutObj[5]!=null?(BigDecimal)reportPayOutObj[5]:null;
			BigDecimal grossSalary=reportPayOutObj[6]!=null?(BigDecimal)reportPayOutObj[6]:null;
			BigDecimal otherAllowance=reportPayOutObj[7]!=null?(BigDecimal)reportPayOutObj[7]:null;
			BigDecimal absense=reportPayOutObj[8]!=null?(BigDecimal)reportPayOutObj[8]:null;
			BigDecimal casualleave=reportPayOutObj[9]!=null?(BigDecimal)reportPayOutObj[9]:null;
			BigDecimal seekleave=reportPayOutObj[10]!=null?(BigDecimal)reportPayOutObj[10]:null;
			BigDecimal payDays=reportPayOutObj[11]!=null?(BigDecimal)reportPayOutObj[11]:null;
			BigDecimal presense=reportPayOutObj[12]!=null?(BigDecimal)reportPayOutObj[12]:null;
			BigDecimal publicholidays=reportPayOutObj[13]!=null?(BigDecimal)reportPayOutObj[13]:null;
			BigDecimal weekoff=reportPayOutObj[14]!=null?(BigDecimal)reportPayOutObj[14]:null;
			BigDecimal overtime=reportPayOutObj[15]!=null?(BigDecimal)reportPayOutObj[15]:null;
			BigDecimal basicEarning=reportPayOutObj[16]!=null?(BigDecimal)reportPayOutObj[16]:null;
			BigDecimal totalEarning=reportPayOutObj[17]!=null?(BigDecimal)reportPayOutObj[17]:null;
			BigDecimal otherAllowanceEarning=reportPayOutObj[18]!=null?(BigDecimal)reportPayOutObj[18]:null;
			BigDecimal employeeLoansAdvnace=reportPayOutObj[19]!=null?(BigDecimal)reportPayOutObj[19]:null;
			BigDecimal providentFundEmployee=reportPayOutObj[20]!=null?(BigDecimal)reportPayOutObj[20]:null;
			BigDecimal esi_Employee=reportPayOutObj[21]!=null?(BigDecimal)reportPayOutObj[21]:null;
			BigDecimal pt=reportPayOutObj[22]!=null?(BigDecimal)reportPayOutObj[22]:null;
			BigDecimal tds=reportPayOutObj[23]!=null?(BigDecimal)reportPayOutObj[23]:null;
			BigDecimal totalDeduction=reportPayOutObj[24]!=null?(BigDecimal)reportPayOutObj[24]:null;
			
			/*BigDecimal conveyanceAllowance=reportPayOutObj[7]!=null?(BigDecimal)reportPayOutObj[7]:null;
			BigDecimal hra=reportPayOutObj[8]!=null?(BigDecimal)reportPayOutObj[8]:null;
			BigDecimal hraEarning=reportPayOutObj[9]!=null?(BigDecimal)reportPayOutObj[9]:null;
			BigDecimal advanceBonus=reportPayOutObj[14]!=null?(BigDecimal)reportPayOutObj[14]:null;
			BigDecimal advanceBonusEarning=reportPayOutObj[15]!=null?(BigDecimal)reportPayOutObj[15]:null;
			BigDecimal companyBenefits=reportPayOutObj[18]!=null?(BigDecimal)reportPayOutObj[18]:null;
			BigDecimal companyBenefitsEarning=reportPayOutObj[19]!=null?(BigDecimal)reportPayOutObj[19]:null;
			BigDecimal conveyanceAllowanceEarning=reportPayOutObj[20]!=null?(BigDecimal)reportPayOutObj[20]:null;
			BigDecimal employeeLoansAdvnaceEarning=reportPayOutObj[22]!=null?(BigDecimal)reportPayOutObj[22]:null;
			BigDecimal esi_Employer=reportPayOutObj[24]!=null?(BigDecimal)reportPayOutObj[24]:null;
			BigDecimal loan=reportPayOutObj[26]!=null?(BigDecimal)reportPayOutObj[26]:null;
			BigDecimal medicalAllowance=reportPayOutObj[27]!=null?(BigDecimal)reportPayOutObj[27]:null;
			BigDecimal medicalAllowanceEarning=reportPayOutObj[28]!=null?(BigDecimal)reportPayOutObj[28]:null;
			BigDecimal netPayableAmount=reportPayOutObj[29]!=null?(BigDecimal)reportPayOutObj[29]:null;
			BigDecimal paidleave=reportPayOutObj[30]!=null?(BigDecimal)reportPayOutObj[30]:null;
			BigDecimal providentFundEmployer=reportPayOutObj[34]!=null?(BigDecimal)reportPayOutObj[34]:null;
			BigDecimal providentFundEmployerPension=reportPayOutObj[35]!=null?(BigDecimal)reportPayOutObj[35]:null;
			BigDecimal specialAllowance=reportPayOutObj[39]!=null?(BigDecimal)reportPayOutObj[39]:null;
			BigDecimal specialAllowanceEarning=reportPayOutObj[40]!=null?(BigDecimal)reportPayOutObj[40]:null;
			Long cityId=reportPayOutObj[45]!=null?Long.parseLong(reportPayOutObj[45].toString()):null;
			Long companyId=reportPayOutObj[46]!=null?Long.parseLong(reportPayOutObj[46].toString()):null;
			String unNo=reportPayOutObj[47]!=null?(String)reportPayOutObj[47]:null;
			String panNo=reportPayOutObj[48]!=null?(String)reportPayOutObj[48]:null;
			String aadharNo=reportPayOutObj[49]!=null?(String)reportPayOutObj[49]:null;
			String stateName=reportPayOutObj[50]!=null?(String)reportPayOutObj[50]:null;
			Date provisionDateCreated = reportPayOutObj[51] != null ? (Date) reportPayOutObj[51] : null;*/
			
			reportPayOutDto.setName(name);
			reportPayOutDto.setEmployeeCode(employeeCode);
			reportPayOutDto.setBankName(bankName);
			reportPayOutDto.setAccountNumber(accountNumber);
			reportPayOutDto.setDateOfJoining(dateOfJoining);
			reportPayOutDto.setBasic(basic);
			//reportPayOutDto.setConveyanceAllowance(conveyanceAllowance);
			//reportPayOutDto.setHra(hra);
			//reportPayOutDto.setHraEarning(hraEarning);
			reportPayOutDto.setOtherAllowance(otherAllowance);
			reportPayOutDto.setOvertime(overtime);
			reportPayOutDto.setOtherAllowanceEarning(otherAllowanceEarning);
			reportPayOutDto.setAbsense(absense);
			//reportPayOutDto.setAdvanceBonus(advanceBonus);
			//reportPayOutDto.setAdvanceBonusEarning(advanceBonusEarning);
			reportPayOutDto.setBasicEarning(basicEarning);
			reportPayOutDto.setCasualleave(casualleave);
			//reportPayOutDto.setCompanyBenefits(companyBenefits);
			//reportPayOutDto.setCompanyBenefitsEarning(companyBenefitsEarning);
			//reportPayOutDto.setConveyanceAllowanceEarning(conveyanceAllowanceEarning);
			reportPayOutDto.setEmployeeLoansAdvnace(employeeLoansAdvnace);
			//reportPayOutDto.setEmployeeLoansAdvnaceEarning(employeeLoansAdvnaceEarning);
			reportPayOutDto.setEsi_Employee(esi_Employee);
			//reportPayOutDto.setEsi_Employer(esi_Employer);
			reportPayOutDto.setGrossSalary(grossSalary);
			//reportPayOutDto.setLoan(loan);
			//reportPayOutDto.setMedicalAllowance(medicalAllowance);
			//reportPayOutDto.setMedicalAllowanceEarning(medicalAllowanceEarning);
			//reportPayOutDto.setNetPayableAmount(netPayableAmount);
			//reportPayOutDto.setPaidleave(paidleave);
			reportPayOutDto.setPayDays(payDays);
			reportPayOutDto.setPresense(presense);
			reportPayOutDto.setProvidentFundEmployee(providentFundEmployee);
			//reportPayOutDto.setProvidentFundEmployer(providentFundEmployer);
			//reportPayOutDto.setProvidentFundEmployerPension(providentFundEmployerPension);
			reportPayOutDto.setPt(pt);
			reportPayOutDto.setPublicholidays(publicholidays);
			reportPayOutDto.setSeekleave(seekleave);
			//reportPayOutDto.setSpecialAllowance(specialAllowance);
			//reportPayOutDto.setSpecialAllowanceEarning(specialAllowanceEarning);
			reportPayOutDto.setTds(tds);
			reportPayOutDto.setTotalDeduction(totalDeduction);
			reportPayOutDto.setTotalEarning(totalEarning);
			reportPayOutDto.setWeekoff(weekoff);
			//reportPayOutDto.setCityId(cityId);
			//reportPayOutDto.setCompanyId(companyId);
			//reportPayOutDto.setUnNo(unNo);
			//reportPayOutDto.setPanNo(panNo);
			//reportPayOutDto.setAadharNo(aadharNo);
			//reportPayOutDto.setStateName(stateName);
			//reportPayOutDto.setProvisionDateCreated(provisionDateCreated);
			reportPayOutDTOList.add(reportPayOutDto);
			
		}

		return reportPayOutDTOList;
	}	
	
 public List<HeaderReportPayOutDTO> objectListToReportPayOutDTOList(List<Object[]> objectOfReportList, String processMonth) {
 		List<HeaderReportPayOutDTO>  reportPayOutDtoList=new ArrayList<HeaderReportPayOutDTO>();				
		for (Object[] reportPayOutObj : objectOfReportList) {
			HeaderReportPayOutDTO reportPayOutDto=new HeaderReportPayOutDTO();
			Long departmentId=reportPayOutObj[0]!=null?Long.parseLong(reportPayOutObj[0].toString()):null;
			String departmentName=reportPayOutObj[1]!=null?(String)reportPayOutObj[1]:null;
		 	BigDecimal sumOfBasicEarning=reportPayOutObj[2]!=null?(BigDecimal)reportPayOutObj[2]:null;
		 	BigDecimal sumOfGrossSalary=reportPayOutObj[3]!=null?(BigDecimal)reportPayOutObj[3]:null;
		 	BigDecimal sumOfNetPayableAmount=reportPayOutObj[4]!=null?(BigDecimal)reportPayOutObj[4]:null;
		 	BigDecimal sumOfProvidentFundEmployer=reportPayOutObj[5]!=null?(BigDecimal)reportPayOutObj[5]:null;
 		 	BigDecimal sumOfProvidentFundEmployee=reportPayOutObj[6]!=null?(BigDecimal)reportPayOutObj[6]:null;
 		 	BigDecimal sumOfEsi_Employee=reportPayOutObj[7]!=null?(BigDecimal)reportPayOutObj[7]:null;
		 	BigDecimal sumOfEsi_Employer=reportPayOutObj[8]!=null?(BigDecimal)reportPayOutObj[8]:null;
		 	BigDecimal sumOfPt=reportPayOutObj[9]!=null?(BigDecimal)reportPayOutObj[9]:null;
		 	BigDecimal sumOfTds=reportPayOutObj[10]!=null?(BigDecimal)reportPayOutObj[10]:null;
		 	BigDecimal sumOfloan=reportPayOutObj[11]!=null?(BigDecimal)reportPayOutObj[11]:null;
		 	reportPayOutDto.setDepartmentId(departmentId);
		 	reportPayOutDto.setDepartmentName(departmentName);
		 	reportPayOutDto.setSumOfBasicEarning(sumOfBasicEarning);
		 	reportPayOutDto.setSumOfGrossSalary(sumOfGrossSalary);
		 	reportPayOutDto.setSumOfNetPayableAmount(sumOfNetPayableAmount);
		 	reportPayOutDto.setSumOfProvidentFundEmployer(sumOfProvidentFundEmployer);
 		 	reportPayOutDto.setSumOfProvidentFundEmployee(sumOfProvidentFundEmployee);
 		 	reportPayOutDto.setSumOfEsi_Employee(sumOfEsi_Employee);
 		 	reportPayOutDto.setSumOfEsi_Employer(sumOfEsi_Employer);
 		 	reportPayOutDto.setSumOfPt(sumOfPt);
 		 	reportPayOutDto.setSumOfTds(sumOfTds);
 		 	reportPayOutDto.setSumOfloan(sumOfloan);
 		 	reportPayOutDto.setProcessMonth(processMonth);
 		 	reportPayOutDtoList.add(reportPayOutDto);
   		}
 			 return reportPayOutDtoList;
	}


public List<ReportPayOut> uiDtoToDatabaseModelList(List<ReportPayOutDTO> uiobj) {
	// TODO Auto-generated method stub
	return null;
}


public List<ReportPayOutDTO> databaseModelToUiDtoList(List<ReportPayOut> reportPayOutList) {
	 List<ReportPayOutDTO> reportPayOutDtoList=new ArrayList<ReportPayOutDTO>();
	for (ReportPayOut reportPayOut : reportPayOutList) {
		reportPayOutDtoList.add(databaseModelToUiDto(reportPayOut));
	}
	
   	return reportPayOutDtoList;
}

public List<EsiInfoDTO> databaseModelToESIDtoList1(List<ReportPayOut> reportPayOutList) {
	 List<EsiInfoDTO> esiInfoDtoList=new ArrayList<EsiInfoDTO>();
	for (ReportPayOut reportPayOut : reportPayOutList) {
		esiInfoDtoList.add(databaseModelToEsiDto(reportPayOut));
	}
	
  	return esiInfoDtoList;
}
public EsiInfoDTO databaseModelToEsiDto(ReportPayOut reportPayOut) {
	
	EsiInfoDTO esiInfodto= new EsiInfoDTO();
	esiInfodto.setName(reportPayOut.getName());
	esiInfodto.setFatherName(reportPayOut.getFatherName());
	esiInfodto.setAadharNo(reportPayOut.getAadharNo());
	esiInfodto.setDob(reportPayOut.getDob());
	esiInfodto.setMobileNo(reportPayOut.getMobileNo());
	esiInfodto.setEsicNumber(reportPayOut.getESICNumber());
	return esiInfodto;
} 

public EsiInfoDTO databaseModelToESIDtoList(List<ReportPayOut> reportPayOutList) {
	EsiInfoDTO esiInfoDto=new EsiInfoDTO();
		List<EsiReportTableDTO> EsiReportTableDtoList= new ArrayList<EsiReportTableDTO>();
	
   int i=0;
	for (ReportPayOut reportPayOut : reportPayOutList) {
		
		if(i==0) {
			esiInfoDto=databaseModelToEsiDto(reportPayOut);
			i++;
		}
		EsiReportTableDTO esiReportTableDto=new EsiReportTableDTO();
	
		esiReportTableDto.setEsi_Employee(reportPayOut.getESI_Employee());
		esiReportTableDto.setEsi_Employer(reportPayOut.getESI_Employer());
	
		esiReportTableDto.setProcessMonth(reportPayOut.getId()!=null?reportPayOut.getId().getProcessMonth():"");
		EsiReportTableDtoList.add(esiReportTableDto);
	}
	
	esiInfoDto.setEsiReportTableDtoList(EsiReportTableDtoList);
 	return esiInfoDto;
}



public ReportPayOut uiDtoToDatabaseModel(ReportPayOutDTO uiobj) {
	// TODO Auto-generated method stub
	return null;
}


public ReportPayOutDTO databaseModelToUiDto(ReportPayOut reportPayOut) {
	ReportPayOutDTO reportPayOutDto=new ReportPayOutDTO();
	reportPayOutDto.setName(reportPayOut.getName());
	reportPayOutDto.setEmployeeCode(reportPayOut.getEmployeeCode());
	reportPayOutDto.setBankName(reportPayOut.getBankName());
	reportPayOutDto.setAccountNumber(reportPayOut.getAccountNumber());
	reportPayOutDto.setDateOfJoining(reportPayOut.getDateOfJoining());
	reportPayOutDto.setBasic(reportPayOut.getBasic());
	reportPayOutDto.setGrossSalary(reportPayOut.getGrossSalary());
	reportPayOutDto.setOtherAllowance(reportPayOut.getOtherAllowance());
	reportPayOutDto.setConveyanceAllowance(reportPayOut.getConveyanceAllowance());
	reportPayOutDto.setHra(reportPayOut.getHra());
	reportPayOutDto.setHraEarning(reportPayOut.getHRAEarning());
	reportPayOutDto.setOvertime(reportPayOut.getOvertime());
	reportPayOutDto.setOtherAllowanceEarning(reportPayOut.getOtherAllowanceEarning());
	
	reportPayOutDto.setAbsense(reportPayOut.getAbsense());
	reportPayOutDto.setAdvanceBonus(reportPayOut.getAdvanceBonus());
	reportPayOutDto.setAdvanceBonusEarning(reportPayOut.getAdvanceBonusEarning());
	reportPayOutDto.setBasicEarning(reportPayOut.getBasicEarning());
	reportPayOutDto.setCasualleave(reportPayOut.getCasualleave());
	reportPayOutDto.setCompanyBenefits(reportPayOut.getCompanyBenefits());
	reportPayOutDto.setCompanyBenefitsEarning(reportPayOut.getCompanyBenefitsEarning());
	reportPayOutDto.setConveyanceAllowanceEarning(reportPayOut.getConveyanceAllowanceEarning());
	reportPayOutDto.setEmployeeLoansAdvnace(reportPayOut.getLoan());
	//reportPayOutDto.setEmployeeLoansAdvnaceEarning(reportPayOut.getEmployeeLoansAdvnaceEarning());
	reportPayOutDto.setEsi_Employee(reportPayOut.getESI_Employee());
	reportPayOutDto.setEsi_Employer(reportPayOut.getESI_Employer());
	reportPayOutDto.setGrossSalary(reportPayOut.getGrossSalary());
	reportPayOutDto.setLoan(reportPayOut.getLoan());
	reportPayOutDto.setMedicalAllowance(reportPayOut.getMedicalAllowance());
	reportPayOutDto.setMedicalAllowanceEarning(reportPayOut.getMedicalAllowanceEarning());
	reportPayOutDto.setNetPayableAmount(reportPayOut.getNetPayableAmount());
	reportPayOutDto.setPaidleave(reportPayOut.getPaidleave());
	reportPayOutDto.setPayDays(reportPayOut.getPayableDays());
	reportPayOutDto.setPresense(reportPayOut.getPresense());
	reportPayOutDto.setProvidentFundEmployee(reportPayOut.getProvidentFundEmployee());
	reportPayOutDto.setProvidentFundEmployer(reportPayOut.getProvidentFundEmployer());
	reportPayOutDto.setProvidentFundEmployerPension(reportPayOut.getProvidentFundEmployerPension());
	reportPayOutDto.setPt(reportPayOut.getPt());
	reportPayOutDto.setPublicholidays(reportPayOut.getPublicholidays());
	reportPayOutDto.setSeekleave(reportPayOut.getSeekleave());
	reportPayOutDto.setSpecialAllowance(reportPayOut.getSpecialAllowance());
	reportPayOutDto.setSpecialAllowanceEarning(reportPayOut.getSpecialAllowanceEarning());
	reportPayOutDto.setTds(reportPayOut.getTds());
	reportPayOutDto.setTotalDeduction(reportPayOut.getTotalDeduction());
	reportPayOutDto.setTotalEarning(reportPayOut.getTotalEarning());
	reportPayOutDto.setWeekoff(reportPayOut.getWeekoff());
	reportPayOutDto.setCityId(reportPayOut.getCityId());
  	reportPayOutDto.setDateOfJoining(reportPayOut.getDateOfJoining());
  	reportPayOutDto.setCompanyId(reportPayOut.getCompanyId());
  	reportPayOutDto.setUnNo(reportPayOut.getUanno());
  	reportPayOutDto.setPanNo(reportPayOut.getPanno());
  	reportPayOutDto.setAadharNo(reportPayOut.getAadharNo());
 	return reportPayOutDto;
}
 

public PfReportDTO databaseModelToPfUiDto(List<ReportPayOut> reportPayOutList) {
	PfReportDTO pfReportDto = new PfReportDTO();
	List<PfReportTableDTO> pfReportTableDtoList = new ArrayList<PfReportTableDTO>();

	int i = 0;
	for (ReportPayOut reportPayOut : reportPayOutList) {

		if (i == 0) {
			pfReportDto = databaseModelToPfUiDto(reportPayOut);
			i++;
		}
		PfReportTableDTO pfReportTableDTO = new PfReportTableDTO();
   
		pfReportTableDTO.setProvidentFundEmployee(reportPayOut.getProvidentFundEmployee());
		pfReportTableDTO.setProvidentFundEmployer(reportPayOut.getProvidentFundEmployer());
		pfReportTableDTO.setProvidentFundEmployerPension(reportPayOut.getProvidentFundEmployerPension());
		pfReportTableDTO.setProcessMonth(reportPayOut.getId()!=null?reportPayOut.getId().getProcessMonth():"");
		System.out.println(pfReportTableDTO.getProvidentFundEmployee());
		System.out.println(pfReportTableDTO.getProvidentFundEmployer());
		pfReportTableDtoList.add(pfReportTableDTO);
	}

	pfReportDto.setPfReportTableDtoList(pfReportTableDtoList);
	return pfReportDto;
}

public PfReportDTO databaseModelToPfUiDto(ReportPayOut reportPayOut) {
	PfReportDTO pfReportDto = new PfReportDTO();
	pfReportDto.setName(reportPayOut.getName());
	pfReportDto.setUanno(reportPayOut.getUanno());
	pfReportDto.setDob(reportPayOut.getDob());
	pfReportDto.setAadharNo(reportPayOut.getAadharNo());
	pfReportDto.setFatherName(reportPayOut.getFatherName());
	pfReportDto.setMobileNo(reportPayOut.getMobileNo());
	return pfReportDto;
}
public List<ReportPayOutSalaryDTO> databaseModelToUiSalaryDtoList(List<Object[]>  reportPayOutListObj) {
	 List<ReportPayOutSalaryDTO> reportPayOutSalaryDtoList=new ArrayList<ReportPayOutSalaryDTO>();
 
	 for (Object[] reportPayOutObj : reportPayOutListObj) {
		ReportPayOutSalaryDTO reportPayOutSalaryDto=new ReportPayOutSalaryDTO();

 		Long departmentId=reportPayOutObj[0]!=null?Long.parseLong(reportPayOutObj[0].toString()):null;
		String employeeCode=reportPayOutObj[1]!=null?(String)reportPayOutObj[1]:null;
		String name=reportPayOutObj[2]!=null?(String)reportPayOutObj[2]:null;
		Date dateOfJoining=reportPayOutObj[3]!=null?(Date)reportPayOutObj[3]:null;
  		String departmentName=reportPayOutObj[4]!=null?(String)reportPayOutObj[4]:null;
  		String designationName=reportPayOutObj[5]!=null?(String)reportPayOutObj[5]:null;
  		String email=reportPayOutObj[6]!=null?(String)reportPayOutObj[6]:null;
 		Long employeeId=reportPayOutObj[7]!=null?Long.parseLong(reportPayOutObj[7].toString()):null;
  		String processMonth=reportPayOutObj[8]!=null?(String)reportPayOutObj[8]:null;

  		
  		
  		reportPayOutSalaryDto.setEmployeeCode(employeeCode);
  		reportPayOutSalaryDto.setName(name);
  		reportPayOutSalaryDto.setDateOfJoining(dateOfJoining);
  		reportPayOutSalaryDto.setDepartment(departmentName);
  		reportPayOutSalaryDto.setDesignation(designationName);
  		reportPayOutSalaryDto.setEmail(email);
  		reportPayOutSalaryDto.setEmployeeId(employeeId);
  		reportPayOutSalaryDto.setProcessMonth(processMonth);
  		reportPayOutSalaryDtoList.add(reportPayOutSalaryDto);
 	}
	
 	return reportPayOutSalaryDtoList;
}
 }
