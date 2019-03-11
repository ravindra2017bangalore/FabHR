package com.csipl.hrms.service.adaptor;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.payrollprocess.ReportPayOutDTO;
import com.csipl.hrms.dto.payrollprocess.ReportSummaryDTO;

public class PayrollReportAdaptor {
	public List<ReportPayOutDTO> objectListToReportPayoutList(List<Object[]> objectReportPayoutList) {
		List<ReportPayOutDTO> reportPayoutList = new ArrayList<>();
		for (Object[] reportPayoutObj : objectReportPayoutList) {
			ReportPayOutDTO reportPayoutDto = new ReportPayOutDTO();
			// Long
			// tdsGroupId=reportPayoutObj[0]!=null?Long.parseLong(tdsTransactionObj[0].toString()):null;
			// Long
			// tdsSectionId=tdsTransactionObj[1]!=null?Long.parseLong(tdsTransactionObj[1].toString()):null;
			String employeeCode = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
			String employeeName = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
			String departmentName = reportPayoutObj[2] != null ? (String) reportPayoutObj[2] : null;
			String desginationName = reportPayoutObj[3] != null ? (String) reportPayoutObj[3] : null;
			String processMonth = reportPayoutObj[4] != null ? (String) reportPayoutObj[4] : null;
			BigDecimal pt = reportPayoutObj[5] != null ? (new BigDecimal(reportPayoutObj[5].toString())) : null;
			String stateName = reportPayoutObj[6] != null ? (String) reportPayoutObj[6] : null;
			reportPayoutDto.setEmployeeCode(employeeCode);
			reportPayoutDto.setName(employeeName);
			reportPayoutDto.setDepartmentName(departmentName);
			reportPayoutDto.setDesignationName(desginationName);
			reportPayoutDto.setProcessMonth(processMonth);
			reportPayoutDto.setPt(pt);
			reportPayoutDto.setStateName(stateName);
			reportPayoutList.add(reportPayoutDto);
		}
		return reportPayoutList;
	}

	public List<ReportPayOutDTO> objectListToProvisionReportList(List<Object[]> objectReportPayoutList) {
		List<ReportPayOutDTO> reportPayoutList = new ArrayList<>();
		for (Object[] reportPayoutObj : objectReportPayoutList) {
			ReportPayOutDTO reportPayoutDto = new ReportPayOutDTO();
			
			// tdsGroupId=reportPayoutObj[0]!=null?Long.parseLong(tdsTransactionObj[0].toString()):null;
			// Long
			// tdsSectionId=tdsTransactionObj[1]!=null?Long.parseLong(tdsTransactionObj[1].toString()):null;
			String employeeName = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
			String employeeCode = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
			String bankName = reportPayoutObj[2] != null ? (String) reportPayoutObj[2] : null;
			String accountNo = reportPayoutObj[3] != null ? (String) reportPayoutObj[3] : null;
			
			BigDecimal	netAmount = reportPayoutObj[4] != null ? (new BigDecimal(reportPayoutObj[4].toString())) : null;
			
			Date dateCreated = reportPayoutObj[5] != null ? (Date) reportPayoutObj[5] : null;
			String departmentName = reportPayoutObj[6] != null ? (String) reportPayoutObj[6] : null;
			reportPayoutDto.setEmployeeCode(employeeCode);
			reportPayoutDto.setName(employeeName);
			reportPayoutDto.setBankName(bankName);
			reportPayoutDto.setAccountNumber(accountNo);
			reportPayoutDto.setNetPayableAmount(netAmount);
			reportPayoutDto.setProvisionDateCreated(dateCreated);
			reportPayoutDto.setEmpDetp(departmentName);
			reportPayoutDto.setDepartmentName(departmentName);
			reportPayoutList.add(reportPayoutDto);
		}
		return reportPayoutList;
	}

	

	public List<ReportPayOutDTO> objectListToMonthlyReportList(List<Object[]> monthlyReportList) {
		List<ReportPayOutDTO> reportPayoutList = new ArrayList<>();
		for (Object[] reportPayoutObj : monthlyReportList) {
			ReportPayOutDTO reportPayoutDto = new ReportPayOutDTO();
			
			String employeeName = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
			String employeeCode = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
			String bankName = reportPayoutObj[2] != null ? (String) reportPayoutObj[2] : null;
			String accountNo = reportPayoutObj[3] != null ? (String) reportPayoutObj[3] : null;
			/*if (reportPayoutObj[4] != null)
				netAmount = reportPayoutObj[4] != null ? (new BigDecimal(reportPayoutObj[4].toString())) : null;
			else
				netAmount = new BigDecimal(0);*/
			Date dateOfJoining = reportPayoutObj[4] != null ? (Date) reportPayoutObj[4] : null;
			BigDecimal basic=reportPayoutObj[5]!=null?(new BigDecimal(reportPayoutObj[5].toString())):null;
			BigDecimal da=reportPayoutObj[6]!=null?(new BigDecimal(reportPayoutObj[6].toString())):null;
			BigDecimal conveyanceAllowance=reportPayoutObj[7]!=null?(new BigDecimal(reportPayoutObj[7].toString())):null;
			BigDecimal employeeHRA=reportPayoutObj[8]!=null?(new BigDecimal(reportPayoutObj[8].toString())):null;
			BigDecimal medicaAllowance=reportPayoutObj[9]!=null?(new BigDecimal(reportPayoutObj[9].toString())):null;
			BigDecimal advanceBonus=reportPayoutObj[10]!=null?(new BigDecimal(reportPayoutObj[10].toString())):null;
			BigDecimal specialAllowance=reportPayoutObj[11]!=null?(new BigDecimal(reportPayoutObj[11].toString())):null;
			BigDecimal companyBenifits=reportPayoutObj[12]!=null?(new BigDecimal(reportPayoutObj[12].toString())):null;
			BigDecimal otherAllowance=reportPayoutObj[13]!=null?(new BigDecimal(reportPayoutObj[13].toString())):null;
			BigDecimal totelGrassSalary=reportPayoutObj[14]!=null?(new BigDecimal(reportPayoutObj[14].toString())):null;
			BigDecimal absent=reportPayoutObj[15]!=null?(new BigDecimal(reportPayoutObj[15].toString())):null;
			BigDecimal casualLeave=reportPayoutObj[16]!=null?(new BigDecimal(reportPayoutObj[16].toString())):null;
			BigDecimal sickLeave=reportPayoutObj[17]!=null?(new BigDecimal(reportPayoutObj[17].toString())):null;
			BigDecimal paidLeave=reportPayoutObj[18]!=null?(new BigDecimal(reportPayoutObj[18].toString())):null;
			BigDecimal prsent=reportPayoutObj[19]!=null?(new BigDecimal(reportPayoutObj[19].toString())):null;
			BigDecimal publicHoliday=reportPayoutObj[20]!=null?(new BigDecimal(reportPayoutObj[20].toString())):null;
			BigDecimal weeklyOff=reportPayoutObj[21]!=null?(new BigDecimal(reportPayoutObj[21].toString())):null;
			BigDecimal overTime=reportPayoutObj[22]!=null?(new BigDecimal(reportPayoutObj[22].toString())):null;
			BigDecimal payDays=reportPayoutObj[23]!=null?(new BigDecimal(reportPayoutObj[23].toString())):null;
			BigDecimal basicEarning=reportPayoutObj[24]!=null?(new BigDecimal(reportPayoutObj[24].toString())):null;
			BigDecimal daEarning=reportPayoutObj[25]!=null?(new BigDecimal(reportPayoutObj[25].toString())):null;
			BigDecimal conveyanceEarning=reportPayoutObj[26]!=null?(new BigDecimal(reportPayoutObj[26].toString())):null;
			BigDecimal employeeHraEarning=reportPayoutObj[27]!=null?(new BigDecimal(reportPayoutObj[27].toString())):null;
			BigDecimal medicalAllowEarning=reportPayoutObj[28]!=null?(new BigDecimal(reportPayoutObj[28].toString())):null;
			BigDecimal addvanceBonusEarning=reportPayoutObj[29]!=null?(new BigDecimal(reportPayoutObj[29].toString())):null;
			BigDecimal specialAllEarning=reportPayoutObj[30]!=null?(new BigDecimal(reportPayoutObj[30].toString())):null;
			BigDecimal companyBenifitsEarning=reportPayoutObj[31]!=null?(new BigDecimal(reportPayoutObj[31].toString())):null;
			BigDecimal otherAlloEarning=reportPayoutObj[32]!=null?(new BigDecimal(reportPayoutObj[32].toString())):null;
			BigDecimal totelEarning=reportPayoutObj[33]!=null?(new BigDecimal(reportPayoutObj[33].toString())):null;
			BigDecimal empLoan=reportPayoutObj[34]!=null?(new BigDecimal(reportPayoutObj[34].toString())):null;
			BigDecimal PF=reportPayoutObj[35]!=null?(new BigDecimal(reportPayoutObj[35].toString())):null;
			BigDecimal ESIC=reportPayoutObj[36]!=null?(new BigDecimal(reportPayoutObj[36].toString())):null;
			BigDecimal PT=reportPayoutObj[37]!=null?(new BigDecimal(reportPayoutObj[37].toString())):null;
			BigDecimal TDS=reportPayoutObj[38]!=null?(new BigDecimal(reportPayoutObj[38].toString())):null;
			BigDecimal totelDeduction=reportPayoutObj[39]!=null?(new BigDecimal(reportPayoutObj[39].toString())):null;
			BigDecimal netAmount=reportPayoutObj[40]!=null?(new BigDecimal(reportPayoutObj[40].toString())):null;
			String departmentName = reportPayoutObj[41] != null ? (String) reportPayoutObj[41] : null;
			//String departmentName = reportPayoutObj[6] != null ? (String) reportPayoutObj[6] : null;
			reportPayoutDto.setEmployeeCode(employeeCode);
			reportPayoutDto.setName(employeeName);
			reportPayoutDto.setBankName(bankName);
			reportPayoutDto.setAccountNumber(accountNo);
			reportPayoutDto.setDateOfJoining(dateOfJoining);
			reportPayoutDto.setNetPayableAmount(netAmount);
			reportPayoutDto.setBasic(basic);
			reportPayoutDto.setDearnessAllowance(da);
			reportPayoutDto.setConveyanceAllowance(conveyanceAllowance);
			reportPayoutDto.setHra(employeeHRA);
			reportPayoutDto.setMedicalAllowance(medicaAllowance);
			reportPayoutDto.setAdvanceBonus(advanceBonus);
			reportPayoutDto.setSpecialAllowance(specialAllowance);
			reportPayoutDto.setCompanyBenefits(companyBenifits);
			reportPayoutDto.setOtherAllowance(otherAllowance);
			reportPayoutDto.setGrossSalary(totelGrassSalary);;
			reportPayoutDto.setAbsense(absent);
			reportPayoutDto.setCasualleave(casualLeave);
			reportPayoutDto.setSeekleave(sickLeave);
			reportPayoutDto.setPaidleave(paidLeave);
			reportPayoutDto.setPresense(prsent);
			reportPayoutDto.setPublicholidays(publicHoliday);
			reportPayoutDto.setWeekoff(weeklyOff);
			reportPayoutDto.setOvertime(overTime);
			reportPayoutDto.setPayDays(payDays);
			reportPayoutDto.setBasicEarning(basicEarning);
			reportPayoutDto.setDearnessAllowanceEarning(daEarning);
			reportPayoutDto.setConveyanceAllowanceEarning(conveyanceEarning);
			reportPayoutDto.setHraEarning(employeeHraEarning);
			reportPayoutDto.setMedicalAllowanceEarning(medicalAllowEarning);
			reportPayoutDto.setAdvanceBonusEarning(addvanceBonusEarning);
			reportPayoutDto.setSpecialAllowanceEarning(specialAllEarning);
			reportPayoutDto.setCompanyBenefitsEarning(companyBenifitsEarning);
			reportPayoutDto.setOtherAllowanceEarning(otherAlloEarning);
			reportPayoutDto.setTotalEarning(totelEarning);
			reportPayoutDto.setEmployeeLoansAdvnaceEarning(empLoan);
			reportPayoutDto.setProvidentFundEmployee(PF);
			reportPayoutDto.setEsi_Employee(ESIC);
			reportPayoutDto.setPt(PT);
			reportPayoutDto.setTds(TDS);
			reportPayoutDto.setTotalDeduction(totelDeduction);
			reportPayoutDto.setNetPayableAmount(netAmount);
			//reportPayoutDto.setProvisionDateCreated(dateCreated);
			reportPayoutDto.setDepartmentName(departmentName);
			reportPayoutList.add(reportPayoutDto);
		}
		return reportPayoutList;
	}
	public List<ReportPayOutDTO> objectListToBankReportList(List<Object[]> objectReportPayoutList){
		 List<ReportPayOutDTO>  reportPayoutList = new ArrayList<>();
			for (Object[] reportPayoutObj : objectReportPayoutList) {
				ReportPayOutDTO reportPayOutDto=new ReportPayOutDTO();
				String employeeCode = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
				String name = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
				String bankName = reportPayoutObj[2] != null ? (String) reportPayoutObj[2] : null;
				String accountNumber = reportPayoutObj[3] != null ? (String) reportPayoutObj[3] : null;
				BigDecimal netPayableAmount = reportPayoutObj[4] != null ? (new BigDecimal(reportPayoutObj[4].toString()))
						: null;
				String processMonth = reportPayoutObj[5] != null ? (String) reportPayoutObj[5] : null;
				String departmentName = reportPayoutObj[6] != null ? (String) reportPayoutObj[6] : null;
 				reportPayOutDto.setEmployeeCode(employeeCode);
				reportPayOutDto.setName(name);
				reportPayOutDto.setBankName(bankName);
				reportPayOutDto.setAccountNumber(accountNumber);
				reportPayOutDto.setNetPayableAmount(netPayableAmount);
				reportPayOutDto.setProcessMonth(processMonth);
				reportPayOutDto.setDepartmentName(departmentName);
 				reportPayoutList.add(reportPayOutDto);
			}

		return reportPayoutList;	
	}

	public List<ReportPayOutDTO> objectListToRecoReportList(List<Object[]> objectReportPayoutList) {
 				 List<ReportPayOutDTO>  reportPayoutList = new ArrayList<>();
			for (Object[] reportPayoutObj : objectReportPayoutList) {
				ReportPayOutDTO reportPayOutDto=new ReportPayOutDTO();
				String employeeCode = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
				String name = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
				String bankName = reportPayoutObj[2] != null ? (String) reportPayoutObj[2] : null;
				String accountNumber = reportPayoutObj[3] != null ? (String) reportPayoutObj[3] : null;
				BigDecimal netPayableAmount = reportPayoutObj[4] != null ? (new BigDecimal(reportPayoutObj[4].toString()))
						: null;
 				String processMonth = reportPayoutObj[5] != null ? (String) reportPayoutObj[5] : null;
				String departmentName = reportPayoutObj[6] != null ? (String) reportPayoutObj[6] : null;
				String transactionNo = reportPayoutObj[7] != null ? (String) reportPayoutObj[7] : null;
				Date recoDate = reportPayoutObj[8] != null ? (Date) reportPayoutObj[8] : null;
				reportPayOutDto.setEmployeeCode(employeeCode);
				reportPayOutDto.setName(name);
				reportPayOutDto.setBankName(bankName);
				reportPayOutDto.setAccountNumber(accountNumber);
				reportPayOutDto.setNetPayableAmount(netPayableAmount);
				reportPayOutDto.setProcessMonth(processMonth);
				reportPayOutDto.setDepartmentName(departmentName);
				reportPayOutDto.setReconciliationDate(recoDate);
				reportPayOutDto.setTransactionNo(transactionNo);
				
				System.out.println("EMP CODE"+reportPayOutDto.getEmployeeCode());
				System.out.println("EMP Name"+reportPayOutDto.getName());
				System.out.println("EMP BankName"+reportPayOutDto.getBankName());
				System.out.println("EMP AccountNumber"+reportPayOutDto.getAccountNumber());
				System.out.println("EMP ProcessMonth"+reportPayOutDto.getProcessMonth());
				System.out.println("EMP DepartmentName"+reportPayOutDto.getDepartmentName());
				System.out.println("EMP ReconciliationDate"+reportPayOutDto.getReconciliationDate());
				System.out.println("EMP TransactionNo"+reportPayOutDto.getTransactionNo());
   		
				reportPayoutList.add(reportPayOutDto); 
			}
		
		
 		return reportPayoutList;
	}
	public List<ReportPayOutDTO> objectListToEmpMonthlyReportList(List<Object[]> monthlyReportList) {
		List<ReportPayOutDTO> reportPayoutList = new ArrayList<>();
		for (Object[] reportPayoutObj : monthlyReportList) {
			ReportPayOutDTO reportPayoutDto = new ReportPayOutDTO();
			String processMonth = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
			String employeeName = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
			String employeeCode = reportPayoutObj[2] != null ? (String) reportPayoutObj[2] : null;
			String bankName = reportPayoutObj[3] != null ? (String) reportPayoutObj[3] : null;
			String accountNo = reportPayoutObj[4] != null ? (String) reportPayoutObj[4] : null;
			/*if (reportPayoutObj[4] != null)
				netAmount = reportPayoutObj[4] != null ? (new BigDecimal(reportPayoutObj[4].toString())) : null;
			else
				netAmount = new BigDecimal(0);*/
			Date dateOfJoining = reportPayoutObj[5] != null ? (Date) reportPayoutObj[5] : null;
			BigDecimal basic=reportPayoutObj[6]!=null?(new BigDecimal(reportPayoutObj[6].toString())):null;
			BigDecimal da=reportPayoutObj[7]!=null?(new BigDecimal(reportPayoutObj[7].toString())):null;
			BigDecimal conveyanceAllowance=reportPayoutObj[8]!=null?(new BigDecimal(reportPayoutObj[8].toString())):null;
			BigDecimal employeeHRA=reportPayoutObj[9]!=null?(new BigDecimal(reportPayoutObj[9].toString())):null;
			BigDecimal medicaAllowance=reportPayoutObj[10]!=null?(new BigDecimal(reportPayoutObj[10].toString())):null;
			BigDecimal advanceBonus=reportPayoutObj[11]!=null?(new BigDecimal(reportPayoutObj[11].toString())):null;
			BigDecimal specialAllowance=reportPayoutObj[12]!=null?(new BigDecimal(reportPayoutObj[12].toString())):null;
			BigDecimal companyBenifits=reportPayoutObj[13]!=null?(new BigDecimal(reportPayoutObj[13].toString())):null;
			BigDecimal otherAllowance=reportPayoutObj[14]!=null?(new BigDecimal(reportPayoutObj[14].toString())):null;
			BigDecimal totelGrassSalary=reportPayoutObj[15]!=null?(new BigDecimal(reportPayoutObj[15].toString())):null;
			BigDecimal absent=reportPayoutObj[16]!=null?(new BigDecimal(reportPayoutObj[16].toString())):null;
			BigDecimal casualLeave=reportPayoutObj[17]!=null?(new BigDecimal(reportPayoutObj[17].toString())):null;
			BigDecimal sickLeave=reportPayoutObj[18]!=null?(new BigDecimal(reportPayoutObj[18].toString())):null;
			BigDecimal paidLeave=reportPayoutObj[19]!=null?(new BigDecimal(reportPayoutObj[19].toString())):null;
			BigDecimal prsent=reportPayoutObj[20]!=null?(new BigDecimal(reportPayoutObj[20].toString())):null;
			BigDecimal publicHoliday=reportPayoutObj[21]!=null?(new BigDecimal(reportPayoutObj[21].toString())):null;
			BigDecimal weeklyOff=reportPayoutObj[22]!=null?(new BigDecimal(reportPayoutObj[22].toString())):null;
			BigDecimal overTime=reportPayoutObj[23]!=null?(new BigDecimal(reportPayoutObj[23].toString())):null;
			BigDecimal payDays=reportPayoutObj[24]!=null?(new BigDecimal(reportPayoutObj[24].toString())):null;
			BigDecimal basicEarning=reportPayoutObj[25]!=null?(new BigDecimal(reportPayoutObj[25].toString())):null;
			BigDecimal daEarning=reportPayoutObj[26]!=null?(new BigDecimal(reportPayoutObj[26].toString())):null;
			BigDecimal conveyanceEarning=reportPayoutObj[27]!=null?(new BigDecimal(reportPayoutObj[27].toString())):null;
			BigDecimal employeeHraEarning=reportPayoutObj[28]!=null?(new BigDecimal(reportPayoutObj[28].toString())):null;
			BigDecimal medicalAllowEarning=reportPayoutObj[29]!=null?(new BigDecimal(reportPayoutObj[29].toString())):null;
			BigDecimal addvanceBonusEarning=reportPayoutObj[30]!=null?(new BigDecimal(reportPayoutObj[30].toString())):null;
			BigDecimal specialAllEarning=reportPayoutObj[31]!=null?(new BigDecimal(reportPayoutObj[31].toString())):null;
			BigDecimal companyBenifitsEarning=reportPayoutObj[32]!=null?(new BigDecimal(reportPayoutObj[32].toString())):null;
			BigDecimal otherAlloEarning=reportPayoutObj[33]!=null?(new BigDecimal(reportPayoutObj[33].toString())):null;
			BigDecimal totelEarning=reportPayoutObj[34]!=null?(new BigDecimal(reportPayoutObj[34].toString())):null;
			BigDecimal empLoan=reportPayoutObj[35]!=null?(new BigDecimal(reportPayoutObj[35].toString())):null;
			BigDecimal PF=reportPayoutObj[36]!=null?(new BigDecimal(reportPayoutObj[36].toString())):null;
			BigDecimal ESIC=reportPayoutObj[37]!=null?(new BigDecimal(reportPayoutObj[37].toString())):null;
			BigDecimal PT=reportPayoutObj[38]!=null?(new BigDecimal(reportPayoutObj[38].toString())):null;
			BigDecimal TDS=reportPayoutObj[39]!=null?(new BigDecimal(reportPayoutObj[39].toString())):null;
			BigDecimal totelDeduction=reportPayoutObj[40]!=null?(new BigDecimal(reportPayoutObj[40].toString())):null;
			BigDecimal netAmount=reportPayoutObj[41]!=null?(new BigDecimal(reportPayoutObj[41].toString())):null;

			//String departmentName = reportPayoutObj[6] != null ? (String) reportPayoutObj[6] : null;
			reportPayoutDto.setProcessMonth(processMonth);
			reportPayoutDto.setEmployeeCode(employeeCode);
			reportPayoutDto.setName(employeeName);
			reportPayoutDto.setBankName(bankName);
			reportPayoutDto.setAccountNumber(accountNo);
			reportPayoutDto.setDateOfJoining(dateOfJoining);
			reportPayoutDto.setNetPayableAmount(netAmount);
			reportPayoutDto.setBasic(basic);
			reportPayoutDto.setDearnessAllowance(da);
			reportPayoutDto.setConveyanceAllowance(conveyanceAllowance);
			reportPayoutDto.setHra(employeeHRA);
			reportPayoutDto.setMedicalAllowance(medicaAllowance);
			reportPayoutDto.setAdvanceBonus(advanceBonus);
			reportPayoutDto.setSpecialAllowance(specialAllowance);
			reportPayoutDto.setCompanyBenefits(companyBenifits);
			reportPayoutDto.setOtherAllowance(otherAllowance);
			reportPayoutDto.setGrossSalary(totelGrassSalary);;
			reportPayoutDto.setAbsense(absent);
			reportPayoutDto.setCasualleave(casualLeave);
			reportPayoutDto.setSeekleave(sickLeave);
			reportPayoutDto.setPaidleave(paidLeave);
			reportPayoutDto.setPresense(prsent);
			reportPayoutDto.setPublicholidays(publicHoliday);
			reportPayoutDto.setWeekoff(weeklyOff);
			reportPayoutDto.setOvertime(overTime);
			reportPayoutDto.setPayDays(payDays);
			reportPayoutDto.setBasicEarning(basicEarning);
			reportPayoutDto.setDearnessAllowanceEarning(daEarning);
			reportPayoutDto.setConveyanceAllowanceEarning(conveyanceEarning);
			reportPayoutDto.setHraEarning(employeeHraEarning);
			reportPayoutDto.setMedicalAllowanceEarning(medicalAllowEarning);
			reportPayoutDto.setAdvanceBonusEarning(addvanceBonusEarning);
			reportPayoutDto.setSpecialAllowanceEarning(specialAllEarning);
			reportPayoutDto.setCompanyBenefitsEarning(companyBenifitsEarning);
			reportPayoutDto.setOtherAllowanceEarning(otherAlloEarning);
			reportPayoutDto.setTotalEarning(totelEarning);
			reportPayoutDto.setEmployeeLoansAdvnaceEarning(empLoan);
			reportPayoutDto.setProvidentFundEmployee(PF);
			reportPayoutDto.setEsi_Employee(ESIC);
			reportPayoutDto.setPt(PT);
			reportPayoutDto.setTds(TDS);
			reportPayoutDto.setTotalDeduction(totelDeduction);
			reportPayoutDto.setNetPayableAmount(netAmount);
			//reportPayoutDto.setProvisionDateCreated(dateCreated);
			//reportPayoutDto.setEmpDetp(departmentName);
			reportPayoutList.add(reportPayoutDto);
		}
		return reportPayoutList;
	}
	



public List<ReportPayOutDTO> objectListToEpfReport(List<Object[]> epfReportList) {
	List<ReportPayOutDTO> reportPayoutList = new ArrayList<>();
	for (Object[] reportPayoutObj : epfReportList) {
		ReportPayOutDTO reportPayoutDto = new ReportPayOutDTO();
		
		
		String employeeCode = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
		String uanNo = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
		String employeeName = reportPayoutObj[2] != null ? (String) reportPayoutObj[2] : null;
		String fatherName = reportPayoutObj[3] != null ? (String) reportPayoutObj[3] : null;
		String nominee = reportPayoutObj[4] != null ? (String) reportPayoutObj[4] : null;
		String nomineeRelation = reportPayoutObj[5] != null ? (String) reportPayoutObj[5] : null;
		Date dateOfBirth = reportPayoutObj[6] != null ? (Date) reportPayoutObj[6] : null;
		String gender = reportPayoutObj[7] != null ? (String) reportPayoutObj[7] : null;
		Date EpfJoining = reportPayoutObj[8] != null ? (Date) reportPayoutObj[8] : null;
		String maritalStatus = reportPayoutObj[9] != null ? (String) reportPayoutObj[9] : null;
		String accountNo = reportPayoutObj[10] != null ? (String) reportPayoutObj[10] : null;
		String ifscCode = reportPayoutObj[11] != null ? (String) reportPayoutObj[11] : null;
		String adharNo = reportPayoutObj[12] != null ? (String) reportPayoutObj[12] : null;
		String PANNo = reportPayoutObj[13] != null ? (String) reportPayoutObj[13] : null;
		String mobNo = reportPayoutObj[14] != null ? (String) reportPayoutObj[14] : null;
		String email = reportPayoutObj[15] != null ? (String) reportPayoutObj[15] : null;
		BigDecimal grassSalary=reportPayoutObj[16]!=null?(new BigDecimal(reportPayoutObj[16].toString())):null;
		BigDecimal basic=reportPayoutObj[17]!=null?(new BigDecimal(reportPayoutObj[17].toString())):null;
		BigDecimal da=reportPayoutObj[18]!=null?(new BigDecimal(reportPayoutObj[18].toString())):null;
		BigDecimal prsent=reportPayoutObj[19]!=null?(new BigDecimal(reportPayoutObj[19].toString())):null;
		BigDecimal absent=reportPayoutObj[20]!=null?(new BigDecimal(reportPayoutObj[20].toString())):null;
		BigDecimal totelGrassSalary=reportPayoutObj[21]!=null?(new BigDecimal(reportPayoutObj[21].toString())):null;
		BigDecimal basicEarning=reportPayoutObj[22]!=null?(new BigDecimal(reportPayoutObj[22].toString())):null;
		
		BigDecimal PensionEarningSalary=reportPayoutObj[23]!=null?(new BigDecimal(reportPayoutObj[23].toString())):null;
		BigDecimal ProvidentFundEmployee=reportPayoutObj[24]!=null?(new BigDecimal(reportPayoutObj[24].toString())):null;
	    reportPayoutDto.setEmployeeCode(employeeCode);
	    reportPayoutDto.setUnNo(uanNo);
		reportPayoutDto.setName(employeeName);
		reportPayoutDto.setFatherName(fatherName);
		reportPayoutDto.setNomineeRelation(nominee);
		reportPayoutDto.setNomineeRelation(DropDownCache.getInstance().getDropDownValue( DropDownEnum.Relation.getDropDownName() , nomineeRelation ));
		reportPayoutDto.setDOB(dateOfBirth);
		reportPayoutDto.setGender( DropDownCache.getInstance().getDropDownValue( DropDownEnum.Gender.getDropDownName() , gender ) );
		reportPayoutDto.setEpfJoining(EpfJoining);
		reportPayoutDto.setMaritalStatus(DropDownCache.getInstance().getDropDownValue( DropDownEnum.MaritalStatus.getDropDownName() , maritalStatus ));
		reportPayoutDto.setAccountNumber(accountNo);
		reportPayoutDto.setIfscCode(ifscCode);
		reportPayoutDto.setAadharNo(adharNo);
		reportPayoutDto.setPanNo(PANNo);
		reportPayoutDto.setMobNo(mobNo);
		reportPayoutDto.setEmail(email);
		reportPayoutDto.setGrossSalary(grassSalary);
		reportPayoutDto.setBasic(basic);
		reportPayoutDto.setDearnessAllowance(da);
		reportPayoutDto.setPresense(prsent);
		reportPayoutDto.setAbsense(absent);
		reportPayoutDto.setTotalEarning(totelGrassSalary);
		
		reportPayoutDto.setBasicEarning(basicEarning);
	
		reportPayoutDto.setPensionEarningSalary(PensionEarningSalary);
		reportPayoutDto.setProvidentFundEmployee(ProvidentFundEmployee);
				
		reportPayoutList.add(reportPayoutDto);
	}
	return reportPayoutList;
}


public List<ReportPayOutDTO> objectListToESICReport(List<Object[]> epfReportList) {
	List<ReportPayOutDTO> reportPayoutList = new ArrayList<>();
	for (Object[] reportPayoutObj : epfReportList) {
		ReportPayOutDTO reportPayoutDto = new ReportPayOutDTO();
		
		
		String employeeCode = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
		String esicNo = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
		String employeeName = reportPayoutObj[2] != null ? (String) reportPayoutObj[2] : null;
		String fatherName = reportPayoutObj[3] != null ? (String) reportPayoutObj[3] : null;
		String nominee = reportPayoutObj[4] != null ? (String) reportPayoutObj[4] : null;
		String nomineeRelation = reportPayoutObj[5] != null ? (String) reportPayoutObj[5] : null;
		Date dateOfBirth = reportPayoutObj[6] != null ? (Date) reportPayoutObj[6] : null;
		String gender = reportPayoutObj[7] != null ? (String) reportPayoutObj[7] : null;
		Date dateOfJoining = reportPayoutObj[8] != null ? (Date) reportPayoutObj[8] : null;
		BigDecimal present=reportPayoutObj[9]!=null?(new BigDecimal(reportPayoutObj[9].toString())):null;
		BigDecimal grassSalary=reportPayoutObj[10]!=null?(new BigDecimal(reportPayoutObj[10].toString())):null;
		BigDecimal totalEarning=reportPayoutObj[11]!=null?(new BigDecimal(reportPayoutObj[11].toString())):null;
		BigDecimal ESI_employee=reportPayoutObj[12]!=null?(new BigDecimal(reportPayoutObj[12].toString())):null;
		
	
	    reportPayoutDto.setEmployeeCode(employeeCode);
	    reportPayoutDto.setEsiNo(esicNo);
		reportPayoutDto.setName(employeeName);
		reportPayoutDto.setFatherName(fatherName);
		reportPayoutDto.setNomineeRelation(nominee);
		reportPayoutDto.setNomineeRelation(DropDownCache.getInstance().getDropDownValue( DropDownEnum.Relation.getDropDownName() , nomineeRelation ));
		reportPayoutDto.setDOB(dateOfBirth);
		reportPayoutDto.setGender( DropDownCache.getInstance().getDropDownValue( DropDownEnum.Gender.getDropDownName() , gender ) );
		reportPayoutDto.setDateOfJoining(dateOfJoining);
			
		reportPayoutDto.setPresense(present);
		reportPayoutDto.setGrossSalary(grassSalary);
		reportPayoutDto.setTotalEarning(totalEarning);
		reportPayoutDto.setEsi_Employee(ESI_employee);
		reportPayoutList.add(reportPayoutDto);
	}
	return reportPayoutList;
}

public List<ReportPayOutDTO> objectListToEpfEcrReportList(List<Object[]> objectReportPayoutList) {
	List<ReportPayOutDTO> reportPayoutList = new ArrayList<>();
	for (Object[] reportPayoutObj : objectReportPayoutList) {
		ReportPayOutDTO reportPayoutDto = new ReportPayOutDTO();
		// Long
		// tdsGroupId=reportPayoutObj[0]!=null?Long.parseLong(tdsTransactionObj[0].toString()):null;
		// Long
		// tdsSectionId=tdsTransactionObj[1]!=null?Long.parseLong(tdsTransactionObj[1].toString()):null;
		String UANNo = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
		String employeeName = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
		BigDecimal totalEarning = reportPayoutObj[2] != null ? (new BigDecimal(reportPayoutObj[2].toString())) : null;
		BigDecimal basicEarning = reportPayoutObj[3] != null ? (new BigDecimal(reportPayoutObj[3].toString())) : null;
		BigDecimal pensionEarningSalary = reportPayoutObj[4] != null ? (new BigDecimal(reportPayoutObj[4].toString())) : null;
		BigDecimal absent=reportPayoutObj[5]!=null?(new BigDecimal(reportPayoutObj[5].toString())):null;
		BigDecimal providentFundEmployee = reportPayoutObj[6] != null ? (new BigDecimal(reportPayoutObj[6].toString())) : null;
		BigDecimal providentFundEmployer = reportPayoutObj[7] != null ? (new BigDecimal(reportPayoutObj[7].toString())) : null;
		BigDecimal providentFundEmployerPension=reportPayoutObj[8]!=null?(new BigDecimal(reportPayoutObj[8].toString())):null;
		reportPayoutDto.setUnNo(UANNo);
		reportPayoutDto.setName(employeeName);
		reportPayoutDto.setTotalEarning(totalEarning);
		reportPayoutDto.setBasicEarning(basicEarning);
		reportPayoutDto.setPensionEarningSalary(pensionEarningSalary);
		reportPayoutDto.setAbsense(absent);
		reportPayoutDto.setProvidentFundEmployee(providentFundEmployee);
		reportPayoutDto.setProvidentFundEmployer(providentFundEmployer);
		reportPayoutDto.setProvidentFundEmployerPension(providentFundEmployerPension);
		reportPayoutList.add(reportPayoutDto);
	}
	return reportPayoutList;
}

public ReportSummaryDTO objectListToReportSummary(List<Object[]> objectReportPayout) {
	
	
		ReportSummaryDTO reportSummary = new ReportSummaryDTO();
		for (Object[] report : objectReportPayout) {
			BigInteger  empcount = report[0] != null ? (BigInteger) report[0] : null;
			BigDecimal grassSum = report[1] != null ? (BigDecimal) report[1] : null;
			
			reportSummary.setEpfExcludedEmpCount(empcount);
			reportSummary.setEpfExcludedGrassSum(grassSum);
		}
		
	
	return reportSummary;
}

public List<ReportPayOutDTO> objectListToEsiEcrReportList(List<Object[]> objectReportPayoutList) {
	List<ReportPayOutDTO> reportPayoutList = new ArrayList<>();
	for (Object[] reportPayoutObj : objectReportPayoutList) {
		ReportPayOutDTO reportPayoutDto = new ReportPayOutDTO();
	
		String esicNo = reportPayoutObj[0] != null ? (String) reportPayoutObj[0] : null;
		String employeeName = reportPayoutObj[1] != null ? (String) reportPayoutObj[1] : null;
		BigDecimal payDays = reportPayoutObj[2] != null ? (new BigDecimal(reportPayoutObj[2].toString())) : null;
		BigDecimal totalEarning = reportPayoutObj[3] != null ? (new BigDecimal(reportPayoutObj[3].toString())) : null;
		
		
		reportPayoutDto.setEsiNo(esicNo);
		reportPayoutDto.setName(employeeName);
		reportPayoutDto.setTotalEarning(totalEarning);
		reportPayoutDto.setPayDays(payDays);
	
		reportPayoutList.add(reportPayoutDto);
	}
	return reportPayoutList;
}

}