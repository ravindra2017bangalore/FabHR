package com.hrms.org.payrollprocess.tds;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csipl.hrms.common.enums.StandardDeductionEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.payroll.TdsSummaryChangeDTO;
import com.csipl.hrms.dto.payroll.TdsSummaryDTO;
import com.csipl.hrms.model.employee.Employee;

import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.payroll.PreviousEmployerIncomeTds;
import com.csipl.hrms.model.payroll.TdsApproved;
import com.csipl.hrms.model.payroll.TdsPayroll;
import com.csipl.hrms.model.payroll.TdsPayrollHd;
import com.csipl.hrms.model.payroll.TdsSlab;
import com.csipl.hrms.model.payroll.TdsSlabHd;
import com.csipl.hrms.model.payroll.TdsStandardExemption;
import com.csipl.hrms.model.payroll.TransactionApprovedHd;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.model.payrollprocess.PayOut;

public class InvestmentTax {

	private static final Logger logger = LoggerFactory.getLogger(InvestmentTax.class);

	

	public TdsPayrollHd calculateChangeEmployeeIvestment(TdsSlabHd tdsSlabHd,String financialYear, TdsSummaryChangeDTO tdsSummaryDto, Employee employee) {

		TdsPayrollHd tdsPayrollHd = new TdsPayrollHd();
	
		BigDecimal tdsApprovedAmount = new BigDecimal(0);
		BigDecimal taxAbleAmount = new BigDecimal(0);
		BigDecimal nonTaxAbleAmount = new BigDecimal(0);
		BigDecimal section84ARebateTax =new BigDecimal(0.0);
		BigDecimal section84ARebateLimit =new BigDecimal(HrmsGlobalConstantUtil.section84ARebateLimit);
		BigDecimal section84ARebateAmount =new BigDecimal(HrmsGlobalConstantUtil.section84ARebateAmount);
		BigDecimal searchChargeLimit =new BigDecimal(HrmsGlobalConstantUtil.searchChargeLimit);
		BigDecimal  searchChargeAmount =new BigDecimal(0.0);
		BigDecimal  eduCessAmount =new BigDecimal(0.0);
		List<TdsPayroll> tdsPayrolls = new ArrayList<TdsPayroll>();
		


		// Sort thDS slab
		List<TdsSlab> tdsSlabs = sortTDSSlab(tdsSlabHd);

		BigDecimal tds = new BigDecimal(0);

		// Create bucket and calculate the tax
		if (tdsSummaryDto.getTaxableIncome().compareTo(new BigDecimal(0.0)) > 0) {
			
			
			tdsPayrolls = createBuket(tdsSlabs, tdsSummaryDto.getTaxableIncome(),
					tdsPayrollHd);
			for (TdsPayroll tdsPayroll : tdsPayrolls) {
				tds = tds.add(tdsPayroll.getTaxAmouunt());
			}
			
			
		}
		tdsSummaryDto.setTax(tds);
		BigDecimal taxCalulation=tdsSummaryDto.getTax();
		
		
		
		if(taxCalulation.compareTo(section84ARebateLimit)<=0) {
			taxCalulation=taxCalulation.subtract(section84ARebateAmount);
			tdsSummaryDto.setSection84ARebateAmount(section84ARebateAmount);
		}
		else
			tdsSummaryDto.setSection84ARebateAmount(new BigDecimal(0.0));
		
		if(taxCalulation.compareTo(new BigDecimal(0.0))>0)
		tdsSummaryDto.setSection84ARebateTax(taxCalulation);
		else
			tdsSummaryDto.setSection84ARebateTax(new BigDecimal(0.0));
			
		if(taxCalulation.compareTo(searchChargeLimit)>0)
			searchChargeAmount= (taxCalulation.multiply(tdsSummaryDto.getSurchargePer())).divide(new BigDecimal(100), 2,RoundingMode.CEILING);
		
		if(taxCalulation.compareTo(new BigDecimal(0.0))>0)
          eduCessAmount= (taxCalulation.multiply(tdsSummaryDto.getEducationCessPer())).divide(new BigDecimal(100), 2,RoundingMode.CEILING);

          tdsSummaryDto.setSurcharge(searchChargeAmount);
          tdsSummaryDto.setEducationCess(eduCessAmount);
          
          taxCalulation=taxCalulation.add(searchChargeAmount);
          taxCalulation=taxCalulation.add(eduCessAmount);
         
          if(taxCalulation.compareTo(new BigDecimal(0.0))>0)
          tdsSummaryDto.setTotalTax(taxCalulation);
          else
        	  tdsSummaryDto.setTotalTax(new BigDecimal(0.0));  
          
          if(tdsSummaryDto.getTotalTax().compareTo(new BigDecimal(0.0))>0) {
        	  
          tdsSummaryDto.setNetTaxYearly(tdsSummaryDto.getTotalTax().subtract(tdsSummaryDto.getPotalTax()));
          
          if(tdsSummaryDto.isTdsFullYearFlag())
        	  tdsSummaryDto.setNetTaxMonthly(tdsSummaryDto.getNetTaxYearly().divide(new BigDecimal(12), 2,RoundingMode.CEILING));
          else
        	  tdsSummaryDto.setNetTaxMonthly(tdsSummaryDto.getNetTaxYearly().divide(tdsSummaryDto.getMonth(), 2,RoundingMode.CEILING));
          
          }
          else {
        	  tdsSummaryDto.setNetTaxYearly(new BigDecimal(0.0));
              
              tdsSummaryDto.setNetTaxMonthly(new BigDecimal(0.0)); 
          }
          
		System.out.println("taxAbleAmount 3 : " + taxAbleAmount);
		tdsPayrollHd.setTdsPayrolls(tdsPayrolls);
		tdsPayrollHd.setTaxableAmount(taxAbleAmount);
		tdsPayrollHd.setTdsApproved(nonTaxAbleAmount);
		tdsPayrollHd.setGrossIncome(tdsSummaryDto.getYearlyGross());
		// tdsPayrollHd.setDateUpdate(new Date());
		// tdsPayrollHd.setUserId(userId);
		tdsPayrollHd.setCompanyId(employee.getCompany().getCompanyId());
		tdsPayrollHd.setFinancialYear(financialYear);
		tdsPayrollHd.setEmployee(employee);

		return tdsPayrollHd;
	}


	public TdsSummaryChangeDTO calcutateChangeExamptionAndTaxAmount(List<PayOut> payOutList,TransactionApprovedHd transactionApprovedHd,
			TdsStandardExemption tdsStandardExemption, BigDecimal otherIncomeAmount, List<TdsSlabHd> tdsSlabHdList,
			FinancialYear financialYear, Employee employee,
			List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsList) {

		TdsSummaryChangeDTO tdsSummaryChangeDTO = new TdsSummaryChangeDTO();
		//TdsSlabHd tdsSlabHd = new TdsSlabHd();

		// TdsSummaryDTO tdsSummaryDTO=new TdsSummaryDTO();

		Date joiningDate = employee.getDateOfJoining();
		Date finYearLastDate = financialYear.getDateTo();
		// getDateTdsDif
		logger.info("joiningDate :  "+joiningDate+"  finYearLastDate  "+finYearLastDate);
		String dateDiffersnce = DateUtils.getDateTdsDif(joiningDate, finYearLastDate);
		logger.info("Date month :  "+dateDiffersnce);
		String[] differences = dateDiffersnce.split(",");
		BigDecimal year = new BigDecimal(Integer.parseInt(differences[0]));
		BigDecimal month = new BigDecimal(Integer.parseInt(differences[1]));
		BigDecimal days = new BigDecimal(Integer.parseInt(differences[2]));
		days = days != null ? days.add(new BigDecimal(1)) : new BigDecimal(0);
		boolean tdsFullYearFlag = Integer.parseInt(differences[0]) > 0 ? true : false;
		tdsSummaryChangeDTO.setTdsFullYearFlag(tdsFullYearFlag);
		tdsSummaryChangeDTO.setMonth(month);

		BigDecimal yearlyGross = new BigDecimal(0.0);
		BigDecimal yearlyGrossFy = new BigDecimal(0.0);
		BigDecimal otherIncome = new BigDecimal(0.0);
		BigDecimal preEmpIncome = new BigDecimal(0.0);
		BigDecimal netYearlyIncome = new BigDecimal(0.0);
		BigDecimal exempStandard = new BigDecimal(0.0);
		BigDecimal exempPfAmount = new BigDecimal(0.0);
		BigDecimal exempPtAmount = new BigDecimal(0.0);
		BigDecimal exempEsicAmount = new BigDecimal(0.0);
		BigDecimal exemptedTotalIncome = new BigDecimal(0.0);
		BigDecimal totalIncomeProfessionalTax = new BigDecimal(0.0);
		BigDecimal chapter6a = new BigDecimal(0.0);
		BigDecimal section10 = new BigDecimal(0.0);
		BigDecimal section24 = new BigDecimal(0.0);
		BigDecimal totalDeductionIncome = new BigDecimal(0.0);
		BigDecimal taxableIncome = new BigDecimal(0.0);
		BigDecimal tax = new BigDecimal(0.0);
		BigDecimal surcharge = new BigDecimal(0.0);
		BigDecimal educationCess = new BigDecimal(0.0);
		BigDecimal totalTax = new BigDecimal(0.0);
		BigDecimal netTaxYearly = new BigDecimal(0.0);
		BigDecimal netTaxMonthly = new BigDecimal(0.0);
		 BigDecimal  incomeAfterExemptions=new BigDecimal(0.0);
		 BigDecimal  professionalTax=new BigDecimal(0.0);
		 BigDecimal  providentFund=new BigDecimal(0.0);
		 BigDecimal  potalTax=new BigDecimal(0.0);
		 BigDecimal  taxOnIncome=new BigDecimal(0.0);
		 BigDecimal  priviousSurcharge=new BigDecimal(0.0);
		 BigDecimal  priviousEducationCess=new BigDecimal(0.0);
		 BigDecimal  exempPfAmountFy=new BigDecimal(0.0);
		 BigDecimal  exempPtAmountFy=new BigDecimal(0.0);
		 
		 
	
		for (PayOut payOut : payOutList) {
			System.out.println("payOut.getId().getPayHeadId() is :" + payOut.getId().getPayHeadId());
			if (payOut.getEarningDeduction().equals("EA")) {
				System.out
						.println("payOut.getPayHeadName() before:" + payOut.getPayHeadName() + "--" + netYearlyIncome);
				yearlyGross = yearlyGross.add(payOut.getAmount());
				System.out.println(
						"payOut.getEarningDeduction() after:" + payOut.getAmount() + "-----" + netYearlyIncome);
			}
			if (payOut.getId().getPayHeadId() == StandardDeductionEnum.PF_Employee_Contribution
					.getStandardDeduction()) {
				System.out.println("PF_Employee_Contribution" + payOut.getAmount());
				exempPfAmount = exempPfAmount.add(payOut.getAmount());
			}

			if (payOut.getId().getPayHeadId() == StandardDeductionEnum.PT.getStandardDeduction()) {
				System.out.println("PT amount is : " + payOut.getAmount());
				exempPtAmount = exempPtAmount.add(payOut.getAmount());
			}
		}
		yearlyGross = yearlyGross.multiply(new BigDecimal(12));

		if (tdsFullYearFlag) {
			yearlyGrossFy = yearlyGrossFy.add(yearlyGross);
			exempPfAmountFy=exempPfAmountFy.add(exempPfAmount.multiply(new BigDecimal(12)));
			exempPtAmountFy=exempPtAmountFy.add(exempPtAmount.multiply(new BigDecimal(12)))	;	
		}
		else {
			BigDecimal perMonthGross = yearlyGross.divide(new BigDecimal(12), 2, RoundingMode.CEILING);
			BigDecimal dailyGross = perMonthGross.divide(new BigDecimal(30), 2, RoundingMode.CEILING);

			yearlyGrossFy = month.multiply(perMonthGross).add(dailyGross.multiply(days));
			
			BigDecimal exempPfAmountDays = exempPfAmount.divide(new BigDecimal(30), 2, RoundingMode.CEILING);
			BigDecimal exempPtAmountDays = exempPtAmount.divide(new BigDecimal(30), 2, RoundingMode.CEILING);
			exempPfAmountFy=month.multiply(exempPfAmount).add(exempPfAmountDays.multiply(days));
			exempPtAmountFy=month.multiply(exempPtAmount).add(exempPtAmountDays.multiply(days));

		}
		
		
		
	for(PreviousEmployerIncomeTds peid:previousEmployerIncomeTdsList ) {
			
			if(peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId()!=null && peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId().longValue()==1) {
				
				incomeAfterExemptions=incomeAfterExemptions.add(peid.getAmount());
			}
			if(peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId()!=null && peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId().longValue()==2) {
						
				professionalTax=professionalTax.add(peid.getAmount());
			}
			if(peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId()!=null && peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId().longValue()==3) {
				
				providentFund=providentFund.add(peid.getAmount());
				
			}
			if(peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId()!=null && peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId().longValue()==4) {
				
				
				potalTax=potalTax.add(peid.getAmount());
			}
			if(peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId()!=null && peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId().longValue()==5) {
				
				
				taxOnIncome=taxOnIncome.add(peid.getAmount());
			}
			if(peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId()!=null && peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId().longValue()==6) {
				
				priviousSurcharge=priviousSurcharge.add(peid.getAmount());
				
			}
			if(peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId()!=null && peid.getPreviousEmployerIncome().getPreviousEmployerIncomeId().longValue()==7) {
				
				priviousEducationCess=priviousEducationCess.add(peid.getAmount());
				
			}
			
		}
		
		
		

		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		BigDecimal surcharges = new BigDecimal(0.0);
		BigDecimal eduCharge = new BigDecimal(0.0);

		int age = dateUtils.getAgeCalaulationInstance(employee.getDateOfBirth(), currentDate);
		logger.info("age : " + age + "employee category : " + employee.getGender());
		
		for (TdsSlabHd tdsSlabHd1 : tdsSlabHdList) {
			System.out.println("tdsSlabHd.getTdsCategory() : "+tdsSlabHd1.getTdsCategory());
              if (tdsSlabHd1.getTdsCategory().equals("SU")) {
                for (TdsSlab tdsSlab : tdsSlabHd1.getTdsSlabs()) {
                   surcharges = surcharges.add(tdsSlab.getTdsPercentage());
                  }
			  }
              else if (tdsSlabHd1.getTdsCategory().equals("EC")) {
            	  for (TdsSlab tdsSlab : tdsSlabHd1.getTdsSlabs()) {
                   eduCharge = eduCharge.add(tdsSlab.getTdsPercentage());

				}
			  }
             /* else if (age >= 60) {
				if (tdsSlabHd.getTdsCategory().equals("SE"))
					tdsSlabHd = tdsSlabHd1;

			  }
			 else if (tdsSlabHd1.getTdsCategory().equals(employee.getGender()))
				tdsSlabHd = tdsSlabHd1;*/
		}

		// List<TdsSlab> tdsSlabs = sortTDSSlab(tdsSlabHd); 
		 BigDecimal chapter6a80c=new BigDecimal(0.0);
             if(transactionApprovedHd!=null)
				for(TdsApproved approved:transactionApprovedHd.getTdsApproveds())	{
					
					System.out.println(approved.getTdsGroup()+" -- TDS Group Name -- "+approved.getTdsGroup().getTdsGroupName());
					if(approved.getTdsGroup().getTdsGroupName().equals("Section 10")) {
						System.out.println("Section 10"+approved.getApprovedAmount());
					section10=section10.add(approved.getApprovedAmount());
					}
					else if(approved.getTdsGroup().getTdsGroupName().equals("Section 24")) {
						System.out.println("Section 24"+approved.getApprovedAmount());
						section24=section24.add(approved.getApprovedAmount());
					}
					else if(approved.getTdsGroup().getTdsGroupName().equals("80C")){
						System.out.println("80C"+approved.getApprovedAmount());
						chapter6a80c=chapter6a80c.add(approved.getApprovedAmount());
						tdsSummaryChangeDTO.setTotal80cAmount(chapter6a80c);
						BigDecimal chapter6awithPf=new BigDecimal(0.0);
						chapter6awithPf=chapter6awithPf.add(providentFund);
						chapter6awithPf=chapter6awithPf.add(exempPfAmountFy);
						chapter6awithPf=chapter6awithPf.add(chapter6a80c);
						
						if(chapter6awithPf.compareTo(approved.getTdsGroup().getMaxLimit())>0)
							chapter6a80c=approved.getTdsGroup().getMaxLimit();
						else
							chapter6a80c=chapter6awithPf;
					}
					else {
						chapter6a=chapter6a.add(approved.getApprovedAmount());
					}
					
				}	
             
             chapter6a=chapter6a.add(chapter6a80c);
           
             
		 
	
	
		exempStandard = tdsStandardExemption.getAmount();
		exemptedTotalIncome = exemptedTotalIncome.add(exempStandard);

		otherIncome = otherIncome.add(otherIncomeAmount);
		System.out.println("============= " + otherIncomeAmount.intValue());
		
		netYearlyIncome = netYearlyIncome.add(yearlyGrossFy);
		netYearlyIncome = netYearlyIncome.add(otherIncome);
		netYearlyIncome = netYearlyIncome.add(incomeAfterExemptions);
		
		
		
		
		  totalIncomeProfessionalTax=totalIncomeProfessionalTax.add(exempPtAmountFy);
		  totalIncomeProfessionalTax=totalIncomeProfessionalTax.add(professionalTax);
		  
		  totalDeductionIncome=totalDeductionIncome.add(totalIncomeProfessionalTax);
		  totalDeductionIncome=totalDeductionIncome.add(chapter6a);
		  totalDeductionIncome=totalDeductionIncome.add(section10);
		  totalDeductionIncome=totalDeductionIncome.add(section24);
		  
		  taxableIncome= taxableIncome.add(netYearlyIncome);
		  taxableIncome=taxableIncome.subtract(exemptedTotalIncome);
		  taxableIncome=taxableIncome.subtract(totalDeductionIncome);
		  
		  
			tdsSummaryChangeDTO.setYearlyGross(yearlyGross);
			tdsSummaryChangeDTO.setYearlyGrossFy(yearlyGrossFy);
			tdsSummaryChangeDTO.setOtherIncome(otherIncome);
			tdsSummaryChangeDTO.setIncomeAfterExemptions(incomeAfterExemptions);
			tdsSummaryChangeDTO.setNetYearlyIncome(netYearlyIncome);
			
			tdsSummaryChangeDTO.setExempStandard(exempStandard);
			tdsSummaryChangeDTO.setExemptedTotalIncome(exemptedTotalIncome);
			
			tdsSummaryChangeDTO.setTotalIncomeProfessionalTax(totalIncomeProfessionalTax);
			tdsSummaryChangeDTO.setChapter6a(chapter6a);
			tdsSummaryChangeDTO.setSection10(section10);
			tdsSummaryChangeDTO.setSection24(section24);
		  
		    tdsSummaryChangeDTO.setTotalDeductionIncome(totalDeductionIncome);
		  
		tdsSummaryChangeDTO.setExempPfAmount(exempPfAmountFy);
		tdsSummaryChangeDTO.setExempPtAmount(exempPtAmountFy);
        tdsSummaryChangeDTO.setProfessionalTax(professionalTax);
		tdsSummaryChangeDTO.setProvidentFund(providentFund);
		tdsSummaryChangeDTO.setPotalTax(potalTax);
		tdsSummaryChangeDTO.setTaxOnIncome(taxOnIncome);
		tdsSummaryChangeDTO.setPreviousSurcharge(priviousSurcharge);
		tdsSummaryChangeDTO.setPreviousEducationCess(priviousEducationCess);
		
		if(taxableIncome.compareTo(new BigDecimal(0.0))>0)
		tdsSummaryChangeDTO.setTaxableIncome(taxableIncome);
		else
			tdsSummaryChangeDTO.setTaxableIncome(new BigDecimal(0.0));
	
		tdsSummaryChangeDTO.setSurchargePer(surcharges);
		tdsSummaryChangeDTO.setEducationCessPer(eduCharge);
		
		
		
		System.out.println(tdsSummaryChangeDTO.toString());

		return tdsSummaryChangeDTO;

	}

	/**
	 * @param tdsApprovedList
	 * @param tdsApprovedAmount
	 */
	private BigDecimal calculateNonTaxableAmount(List<TdsApproved> tdsApprovedList, BigDecimal tdsApprovedAmount,
			TdsSummaryDTO tdsSummaryDto) {

		BigDecimal nonTaxableAmount = new BigDecimal(0);
		BigDecimal totalDeclearedAmount = new BigDecimal(0);
		if (tdsApprovedList != null) {
			for (TdsApproved tdsApproved : tdsApprovedList) {
				BigDecimal approvedAmount = tdsApproved.getApprovedAmount();
				nonTaxableAmount = nonTaxableAmount.add(approvedAmount);
				BigDecimal declearedAmount = tdsApproved.getProofAmount();
				totalDeclearedAmount = totalDeclearedAmount.add(declearedAmount);
			}
		}

		tdsSummaryDto.setDeclaredIncomeApproved(nonTaxableAmount);
		tdsSummaryDto.setIncomeDeclared(totalDeclearedAmount);
		tdsApprovedAmount = nonTaxableAmount;

		// List<PayStructure> payStructures = payStructureHd.getPayStructures();

		return nonTaxableAmount;
	}

	/**
	 * 
	 * @param taxableSlab
	 * @param taxableIncome
	 * @return
	 */
	private List<TdsPayroll> createBuket(List<TdsSlab> taxableSlab, BigDecimal taxableIncome,
			TdsPayrollHd tdsPayrollHd) {
		// List<BigDecimal> bucketList = new ArrayList< BigDecimal >();
		List<TdsPayroll> bucketList = new ArrayList<TdsPayroll>();
		/*
		 * BigDecimal amount = new BigDecimal(0.0); BigDecimal temp1 = new
		 * BigDecimal(0.0); BigDecimal temp2 = new BigDecimal(0.0);
		 */

		BigDecimal ramount = new BigDecimal(0.0);
		BigDecimal pamount = new BigDecimal(0.0);
		BigDecimal atamount = new BigDecimal(0.0);
		atamount = taxableIncome;

		for (TdsSlab taxSlab : taxableSlab) {
			BigDecimal limitFrom = taxSlab.getLimitFrom();
			BigDecimal limitTo = taxSlab.getLimitTo();
			TdsPayroll tdsPayroll = new TdsPayroll();

			System.out.println("limitFrom : " + limitFrom + " limitTo : " + limitTo + "amount : " + atamount);
			// && (taxableIncome.compareTo(amount) > 0
			if (limitFrom != null && limitTo != null && atamount != null) {

				BigDecimal limitFromTo = limitTo.subtract(limitFrom);

				ramount = atamount.subtract(limitFromTo);
				System.out.println("ramount" + ramount);

				if (ramount.doubleValue() > 0) {
					atamount = ramount;

					pamount = (limitFromTo.multiply(taxSlab.getTdsPercentage())).divide(new BigDecimal(100), 2,
							RoundingMode.CEILING);
					tdsPayroll.setLimitFrom(limitFrom);
					tdsPayroll.setLimitTo(limitTo);
					tdsPayroll.setTdsPercentage(taxSlab.getTdsPercentage());
					tdsPayroll.setTaxAmouunt(pamount);
					tdsPayroll.setTdsPayrollHd(tdsPayrollHd);
					tdsPayroll.setActualAmount(limitFromTo);
					System.out.println("atamount=ramount :" + atamount + "pamount :" + pamount + "limitFrom : "
							+ limitFrom + "limitTo : " + limitTo + "taxSlab.getTdsPercentage() :"
							+ taxSlab.getTdsPercentage());
					// tdsPayroll.setCompanyId(1l);
					tdsPayroll.setTdsSlab(taxSlab);
					bucketList.add(tdsPayroll);

				} else {

					pamount = (atamount.multiply(taxSlab.getTdsPercentage())).divide(new BigDecimal(100), 2,
							RoundingMode.CEILING);
					tdsPayroll.setLimitFrom(limitFrom);
					tdsPayroll.setLimitTo(limitTo);
					tdsPayroll.setTdsPercentage(taxSlab.getTdsPercentage());
					tdsPayroll.setTaxAmouunt(pamount);
					tdsPayroll.setActualAmount(atamount);
					System.out.println("atamount :" + atamount + "pamount :" + pamount + "limitFrom : " + limitFrom
							+ "limitTo : " + limitTo + "taxSlab.getTdsPercentage() : " + taxSlab.getTdsPercentage());
					tdsPayroll.setTdsSlab(taxSlab);
					tdsPayroll.setTdsPayrollHd(tdsPayrollHd);
					// tdsPayroll.setCompanyId(1l);
					bucketList.add(tdsPayroll);
					break;
				}

			}

		}

		

		return bucketList;

	}

/*	*//**
	 * 
	 * @param bucketList
	 *//*
	private void calculateTax(List<TdsPayroll> bucketList) {

		for (TdsPayroll tdsPayroll : bucketList) {
			BigDecimal tdsPercentage = tdsPayroll.getTdsPercentage();
			BigDecimal actualAmount = tdsPayroll.getActualAmount();

			BigDecimal taxAmount1 = actualAmount.multiply(tdsPercentage);
			BigDecimal taxAmount = taxAmount1.divide(new BigDecimal(100), 2, RoundingMode.CEILING);
			tdsPayroll.setTaxAmouunt(taxAmount);
		}

	}*/


	/**
	 * @param tdsSlabHd
	 * @return
	 */
	private List<TdsSlab> sortTDSSlab(TdsSlabHd tdsSlabHd) {
		List<TdsSlab> tdsSlabs = tdsSlabHd.getTdsSlabs();
		Collections.sort(tdsSlabs, new Comparator<TdsSlab>() {

			@Override
			public int compare(TdsSlab tdsSlab1, TdsSlab tdsSlab2) {
				BigDecimal limitTo1 = tdsSlab1.getLimitFrom();
				BigDecimal limitTo2 = tdsSlab2.getLimitFrom();
				int diff = limitTo1.compareTo(limitTo2);
				return diff;
			}

		});
		return tdsSlabs;
	}
	
	
	
	/*public TdsSummaryDTO calcutateExamptionAndTaxAmount(List<PayOut> payOutList,
	TdsStandardExemption tdsStandardExemption, BigDecimal otherIncomeAmount, TdsSlabHd tdsSlabHd,
	FinancialYear financialYear, Employee employee,
	List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsList) {

TdsSummaryDTO tdsSummaryDTO = new TdsSummaryDTO();
Date joiningDate = employee.getDateOfJoining();
Date finYearLastDate = financialYear.getDateTo();
// getDateTdsDif
String dateDiffersnce = DateUtils.getDateTdsDif(joiningDate, finYearLastDate);
String[] differences = dateDiffersnce.split(",");
BigDecimal year = new BigDecimal(Integer.parseInt(differences[0]));
BigDecimal month = new BigDecimal(Integer.parseInt(differences[1]));
BigDecimal days = new BigDecimal(Integer.parseInt(differences[2]));
days = days != null ? days.add(new BigDecimal(1)) : new BigDecimal(0);
boolean tdsFullYearFlag = Integer.parseInt(differences[0]) > 0 ? true : false;

BigDecimal yearlyGross = new BigDecimal(0.0);
BigDecimal otherIncome = new BigDecimal(0.0);
BigDecimal netYearlyIncome = new BigDecimal(0.0);

BigDecimal exempStandard = new BigDecimal(0.0);
BigDecimal exempPfAmount = new BigDecimal(0.0);
BigDecimal exempPtAmount = new BigDecimal(0.0);
BigDecimal exempEsicAmount = new BigDecimal(0.0);
BigDecimal exempAmountAsPerSlab = new BigDecimal(0.0);
BigDecimal exemptedTotalIncome = new BigDecimal(0.0);

BigDecimal yearlyTaxableIncome = new BigDecimal(0.0);

BigDecimal taxableIncomeFy = new BigDecimal(0.0);

BigDecimal tdsYearlyBeforeDeclaration = new BigDecimal(0.0);
BigDecimal tdsMonthlyBeforeDeclaration = new BigDecimal(0.0);
BigDecimal incomeDeclared = new BigDecimal(0.0);
BigDecimal declaredIncomeApproved = new BigDecimal(0.0);
BigDecimal netTaxableIncome = new BigDecimal(0.0);
BigDecimal tdsYearlyAfterDeclaration = new BigDecimal(0.0);
BigDecimal tdsMonthlyAfterDeclaration = new BigDecimal(0.0);

for (PayOut payOut : payOutList) {
	System.out.println("payOut.getId().getPayHeadId() is :" + payOut.getId().getPayHeadId());
	if (payOut.getEarningDeduction().equals("EA")) {
		System.out
				.println("payOut.getPayHeadName() before:" + payOut.getPayHeadName() + "--" + netYearlyIncome);
		yearlyGross = yearlyGross.add(payOut.getAmount());
		System.out.println(
				"payOut.getEarningDeduction() after:" + payOut.getAmount() + "-----" + netYearlyIncome);
	}
	if (payOut.getId().getPayHeadId() == StandardDeductionEnum.PF_Employee_Contribution
			.getStandardDeduction()) {
		System.out.println("PF_Employee_Contribution" + payOut.getAmount());
		exempPfAmount = exempPfAmount.add(payOut.getAmount());
	}
	if (payOut.getId().getPayHeadId() == StandardDeductionEnum.ESI_Employee_Contribution
			.getStandardDeduction()) {
		System.out.println("ESI_Employee_Contribution" + payOut.getAmount());
		exempEsicAmount = exempEsicAmount.add(payOut.getAmount());
	}

	if (payOut.getId().getPayHeadId() == StandardDeductionEnum.PT.getStandardDeduction()) {
		System.out.println("PT amount is : " + payOut.getAmount());
		exempPtAmount = exempPtAmount.add(payOut.getAmount());
	}
}
yearlyGross = yearlyGross.multiply(new BigDecimal(12));

List<TdsSlab> tdsSlabs = sortTDSSlab(tdsSlabHd);
for (TdsSlab tdsSlab : tdsSlabs) {
	BigDecimal tdsPercentage = tdsSlab.getTdsPercentage();
	if (tdsPercentage == null || tdsPercentage.compareTo(new BigDecimal(0.0)) == 0) {

		exempAmountAsPerSlab = exempAmountAsPerSlab.add(tdsSlab.getLimitTo());
		System.out.println("exemptedAmountAsPerSlab :" + exempAmountAsPerSlab);
	}
}

exempStandard = tdsStandardExemption.getAmount();
exemptedTotalIncome = exemptedTotalIncome.add(exempStandard);
exemptedTotalIncome = exemptedTotalIncome.add(exempPfAmount);
exemptedTotalIncome = exemptedTotalIncome.add(exempEsicAmount);
exemptedTotalIncome = exemptedTotalIncome.add(exempAmountAsPerSlab);
exemptedTotalIncome = exemptedTotalIncome.add(exempPtAmount);

otherIncome = otherIncome.add(otherIncomeAmount);
System.out.println("============= " + otherIncomeAmount.intValue());

netYearlyIncome = netYearlyIncome.add(yearlyGross);
netYearlyIncome = netYearlyIncome.add(otherIncome);

yearlyTaxableIncome = netYearlyIncome.subtract(exemptedTotalIncome);
if (tdsFullYearFlag)
	taxableIncomeFy = taxableIncomeFy.add(yearlyTaxableIncome);
else {
	BigDecimal perMonthTax = yearlyTaxableIncome.divide(new BigDecimal(12), 2, RoundingMode.CEILING);
	BigDecimal dailyTax = perMonthTax.divide(new BigDecimal(30), 2, RoundingMode.CEILING);

	taxableIncomeFy = month.multiply(perMonthTax).add(dailyTax.multiply(days));

}
tdsSummaryDTO.setYearlyGross(yearlyGross);
tdsSummaryDTO.setOtherIncome(otherIncome);
tdsSummaryDTO.setNetYearlyIncome(netYearlyIncome);
tdsSummaryDTO.setExempAmountAsPerSlab(exempAmountAsPerSlab);
tdsSummaryDTO.setExempEsicAmount(exempEsicAmount);
tdsSummaryDTO.setExempPfAmount(exempPfAmount);
tdsSummaryDTO.setExempPtAmount(exempPtAmount);
tdsSummaryDTO.setExempStandard(exempStandard);
tdsSummaryDTO.setExemptedTotalIncome(exemptedTotalIncome);

tdsSummaryDTO.setYearlyTaxableIncome(yearlyTaxableIncome);

tdsSummaryDTO.setTaxableIncomeFy(taxableIncomeFy);

tdsSummaryDTO.setIncomeDeclared(incomeDeclared);
tdsSummaryDTO.setDeclaredIncomeApproved(declaredIncomeApproved);
tdsSummaryDTO.setNetTaxableIncome(netTaxableIncome);

tdsSummaryDTO.setTaxableIncomeFy(taxableIncomeFy);

System.out.println(tdsSummaryDTO.toString());

return tdsSummaryDTO;

}
*/
	
	
/*	
	
	*//**
	 * It will calculate tax on investment of employee
	 * 
	 * @param payStructureHd
	 * @param tdsSlabHd
	 * @param tdsApprovedList
	 * @param financialYear
	 * @return
	 *//*
	public TdsPayrollHd calculateEmployeeIvestment(TdsSlabHd tdsSlabHd, TransactionApprovedHd tdsApprovedHd,
			String financialYear, TdsSummaryDTO tdsSummaryDto, Employee employee,
			List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsList) {

		TdsPayrollHd tdsPayrollHd = new TdsPayrollHd();
		// BigDecimal grossSalary = payStructureHd.getGrossPay();
		BigDecimal tdsApprovedAmount = new BigDecimal(0);
		BigDecimal taxAbleAmount = new BigDecimal(0);
		BigDecimal nonTaxAbleAmount = new BigDecimal(0);
		List<TdsPayroll> tdsPayrolls = new ArrayList<TdsPayroll>();
		List<TdsSlab> taxableSlab = new ArrayList<TdsSlab>();

		// Calculate non taxable amount
		if (tdsApprovedHd != null)
			nonTaxAbleAmount = calculateNonTaxableAmount(tdsApprovedHd.getTdsApproveds(), tdsApprovedAmount,
					tdsSummaryDto);

		// Sort thDS slab
		List<TdsSlab> tdsSlabs = sortTDSSlab(tdsSlabHd);

		// filter TDS slab, it will seperate any seperate taxable and non-taxable slab
		for (TdsSlab tdsSlab : tdsSlabs) {
			BigDecimal tdsPercentage = tdsSlab.getTdsPercentage();
			if (tdsPercentage == null || tdsPercentage.compareTo(new BigDecimal(0.0)) == 0) {

				// nonTaxAbleAmount = nonTaxAbleAmount.add(tdsSlab.getLimitTo());
				// System.out.println("nonTaxAbleAmount :"+nonTaxAbleAmount);
			} else {
				taxableSlab.add(tdsSlab);
			}

		}

		// Create bucket and calculate the tax
		System.out.println("tdsSummaryDto.getTaxableIncomeFy() : " + tdsSummaryDto.getTaxableIncomeFy()
				+ "nonTaxAbleAmount.compareTo(grossSalary)  :"
				+ nonTaxAbleAmount.compareTo(tdsSummaryDto.getTaxableIncomeFy()));
		if (tdsSummaryDto.getTaxableIncomeFy().doubleValue() > 0) {
			BigDecimal tdsBeforeDelaration = new BigDecimal(0);
			TdsPayrollHd tdsPayrollHdBeforeDeclaration = new TdsPayrollHd();
			List<TdsPayroll> tdsPayrollsBeforeDeclaration = createBuket(taxableSlab, tdsSummaryDto.getTaxableIncomeFy(),
					tdsPayrollHdBeforeDeclaration);
			for (TdsPayroll tdsPayroll : tdsPayrollsBeforeDeclaration) {
				tdsBeforeDelaration = tdsBeforeDelaration.add(tdsPayroll.getTaxAmouunt());
			}
			tdsSummaryDto.setTdsYearlyBeforeDeclaration(tdsBeforeDelaration);
			tdsSummaryDto.setTdsMonthlyBeforeDeclaration(
					tdsBeforeDelaration.divide(new BigDecimal(12), 2, RoundingMode.CEILING));
		}

		if (nonTaxAbleAmount.compareTo(tdsSummaryDto.getTaxableIncomeFy()) > 0) {
			taxAbleAmount = new BigDecimal(0);
			tdsSummaryDto.setNetTaxableIncome(taxAbleAmount);
			System.out.println("taxAbleAmount1 : " + taxAbleAmount);
		} else {
			taxAbleAmount = tdsSummaryDto.getTaxableIncomeFy().subtract(nonTaxAbleAmount);
			tdsSummaryDto.setNetTaxableIncome(taxAbleAmount);
			System.out.println("taxAbleAmount2 : " + taxAbleAmount);
			tdsPayrolls = createBuket(taxableSlab, taxAbleAmount, tdsPayrollHd);
			BigDecimal tdsAfterDeclaration = new BigDecimal(0);
			for (TdsPayroll tdsPayroll : tdsPayrolls) {
				tdsAfterDeclaration = tdsAfterDeclaration.add(tdsPayroll.getTaxAmouunt());
			}
			tdsSummaryDto.setTdsYearlyAfterDeclaration(tdsAfterDeclaration);
			tdsSummaryDto.setTdsMonthlyAfterDeclaration(
					tdsAfterDeclaration.divide(new BigDecimal(12), 2, RoundingMode.CEILING));

			// List<TdsPayroll> bucketList = createBuket(taxableSlab, taxAbleAmount);
			// calculateTax(bucketList);
		}

		System.out.println("taxAbleAmount 3 : " + taxAbleAmount);
		tdsPayrollHd.setTdsPayrolls(tdsPayrolls);
		tdsPayrollHd.setTaxableAmount(taxAbleAmount);
		tdsPayrollHd.setTdsApproved(nonTaxAbleAmount);
		tdsPayrollHd.setGrossIncome(tdsSummaryDto.getYearlyGross());
		// tdsPayrollHd.setDateUpdate(new Date());
		// tdsPayrollHd.setUserId(userId);
		tdsPayrollHd.setCompanyId(employee.getCompany().getCompanyId());
		tdsPayrollHd.setFinancialYear(financialYear);
		tdsPayrollHd.setEmployee(employee);

		return tdsPayrollHd;
	}*/

}
