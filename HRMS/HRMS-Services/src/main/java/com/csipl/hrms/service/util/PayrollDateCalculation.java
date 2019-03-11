package com.csipl.hrms.service.util;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.payroll.InvestmentFinancialYearDTO;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.model.payrollprocess.PayrollControl;

public class PayrollDateCalculation {
	DateUtils dateUtils = new DateUtils();
	PayrollControl payrollControl = new PayrollControl();

	public Date getLastDate(Date date) {
		Date lastDate = new Date();

		if (dateUtils.getMonth(date) == 1) {

			Calendar cal = Calendar.getInstance();
			int day = 31;
			int year = dateUtils.getYear(date);
			cal.set(dateUtils.getYear(date), 11, day);
			lastDate = cal.getTime();
			System.out.println("lastDate 00 " + lastDate);
		} else {
			if (dateUtils.getMonth(date) == 4) {
				Calendar cal = Calendar.getInstance();
				int month = dateUtils.getMonth(date) - 1;
				int year = dateUtils.getYear(date) + 1;

				cal.set(year, 2, 31);
				lastDate = cal.getTime();
				System.out.println("lastDate" + lastDate);
			}
		}
		return lastDate;
	}

	public String getFinancialYear(Date date) {

		String financialYear = null;
		try {

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.YEAR, 1); // to get previous year add -1
			Date nextYear = cal.getTime();
			financialYear = Integer.toString(dateUtils.getYear(date)) + "-"
					+ Integer.toString(dateUtils.getYear(nextYear));
			System.out.println("Financial Year" + financialYear);
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return financialYear;
	}

	public List<PayrollControl> getPayrollControl(FinancialYear financialYaer) {
		int payrollDays;
		List<PayrollControl> payrollControllList = new ArrayList<PayrollControl>();

		Calendar cal = Calendar.getInstance();
		Date nextMonth = financialYaer.getDateFrom();

		System.out.println(financialYaer.getIsPayrollDaysManuals());
		for (int i = 0; i < 12; i++) {
			PayrollControl payrollControl = new PayrollControl();
			String processMonth = null;
			int year = dateUtils.getYear(nextMonth);
			int month = dateUtils.getMonth(nextMonth);
			cal.setTime(nextMonth);
			cal.add(Calendar.MONTH, 1);
			nextMonth = cal.getTime();

			String[] shortMonths = new DateFormatSymbols().getShortMonths();
			String monthAcronym = shortMonths[month - 1];
			processMonth = monthAcronym.toUpperCase() + "-" + String.valueOf(year);

			System.out.println(processMonth);
			payrollControl.setProcessMonth(processMonth);
			if (financialYaer.getIsPayrollDaysManuals().equals("Y")) {
				payrollDays = 26;
			} else {
				payrollDays = DateUtils.findMonthDay(year, month);
			}
			System.out.println(payrollDays);
			payrollControl.setPayrollDays(payrollDays);
			payrollControl.setActiveStatus("AC");
			payrollControl.setFinancialYear(financialYaer);
			payrollControllList.add(payrollControl);
		}

		return payrollControllList;
	}

	public List<InvestmentFinancialYearDTO> employeeSalarySlipProcessMonth() {
		List<InvestmentFinancialYearDTO> investmentFinancialYearDtoList = new ArrayList<InvestmentFinancialYearDTO>();
		Calendar cal = Calendar.getInstance();
		Date currentDate = dateUtils.getCurrentDate();
		for (int i = 0; i < 6; i++) {
			InvestmentFinancialYearDTO investmentFinancialYearDto = new InvestmentFinancialYearDTO();
			String processMonth = null;
			int year = dateUtils.getYear(currentDate);
			System.out.println("year : " + year);
			int month = dateUtils.getMonth(currentDate);
			System.out.println("month : " + month);
			cal.setTime(currentDate);
			cal.add(Calendar.MONTH, -1);
			currentDate = cal.getTime();
			// System.out.println("currentDate : "+currentDate);
			String[] shortMonths = new DateFormatSymbols().getShortMonths();
			String monthAcronym = shortMonths[month - 1];
			processMonth = monthAcronym.toUpperCase() + "-" + String.valueOf(year);
			investmentFinancialYearDto.setFinancialYear(processMonth);
			investmentFinancialYearDtoList.add(investmentFinancialYearDto);

		}
		return investmentFinancialYearDtoList;
	}

	public static void main(String args[]) {

	}

}
