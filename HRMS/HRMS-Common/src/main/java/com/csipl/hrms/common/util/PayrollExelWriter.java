package com.csipl.hrms.common.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csipl.hrms.dto.payrollprocess.ReportPayOutDTO;
import com.csipl.hrms.dto.payrollprocess.ReportSummaryDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.payroll.Epf;



public class PayrollExelWriter {
	
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ExcelWriter.class);
	private static double convertBigdecimalToDouble(BigDecimal bigDecimalValue) {
		double doubleValue;
String str123;
		if (bigDecimalValue != null) {
			doubleValue = bigDecimalValue.doubleValue();
		str123 =bigDecimalValue.toString();
		System.out.println("string value..."+str123);}
		else
			doubleValue = 0;
		return doubleValue;
	}
	
	private static String convertBigdecimalToString(BigDecimal bigDecimalValue) {
		double doubleValue;
        String strValue;
		if (bigDecimalValue != null) {
		strValue =bigDecimalValue.toString();
		}
		else
			strValue = "0.00";
		return strValue;
	}
	
	
	public static Workbook PTReport(List<ReportPayOutDTO> reportPayOutList, String[] columns, 
			Company company ,String fromProcessMonth, String toProcessMonth) throws IOException, InvalidFormatException {

		
		 String toProcessMnth = (fromProcessMonth.equals(toProcessMonth)?"":("to "+toProcessMonth));
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances for various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Professional Tax");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.FINE_DOTS);
		CellStyle headerCellStyle1 = workbook.createCellStyle();
		headerCellStyle1.setFont(headerFont);
		headerCellStyle1.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle1.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle1.setFillPattern(FillPatternType.FINE_DOTS);
		CellStyle headerCellStyle11 = workbook.createCellStyle();
		headerCellStyle11.setFont(headerFont);
		headerCellStyle11.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle11.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle cellStyle112 = workbook.createCellStyle();
		cellStyle112.setAlignment(HorizontalAlignment.RIGHT);
		cellStyle112.setVerticalAlignment(VerticalAlignment.CENTER);
		// Create Other rows and cells with employees data
		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
		row0.createCell(0).setCellValue(company.getCompanyName());

		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));
		row1.createCell(0).setCellValue(company.getAddress1().getAddressText()+" ,");
		// sheet.addMergedRegion(new CellRangeAddress(0,1,1,2));

		
	//	String monthAcronym=processMonth.substring(0, 3);
		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2,2,0,2));
		row2.createCell(0).setCellValue(company.getAddress1().getLandmark() +", "+company.getAddress1().getCity().getCityName() +"- "+company.getAddress1().getPincode());
		
		Row row4 = sheet.createRow(4);
		Cell cell1 = row4.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(4,4,0,2));
		cell1.setCellValue("Professional Tax Statement");
		cell1.setCellStyle(headerCellStyle11);
		

		Row row5 = sheet.createRow(5);
		sheet.addMergedRegion(new CellRangeAddress(5,5,0,2));
		row5.createCell(0).setCellValue(fromProcessMonth + " "+toProcessMnth);
		
		if(reportPayOutList.isEmpty() ||reportPayOutList.equals(" ") ) {
			Font headerFont1 = workbook.createFont();
			headerFont1.setBold(true);
			headerFont1.setFontHeightInPoints((short) 16);
			headerFont1.setColor(IndexedColors.BLACK.getIndex());
      
			CellStyle headerCellStyle12 = workbook.createCellStyle();
			headerCellStyle12.setFont(headerFont);
			headerCellStyle12.setAlignment(HorizontalAlignment.CENTER);
			headerCellStyle12.setVerticalAlignment(VerticalAlignment.CENTER);
			headerCellStyle12.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
			headerCellStyle12.setFillPattern(FillPatternType.FINE_DOTS);
	
			Row headerRow = sheet.createRow(6);
			sheet.addMergedRegion(new CellRangeAddress(6,7,3,8));
			Cell cell0 = headerRow.createCell(3);
			cell0.setCellValue(" Data not available");
			cell0.setCellStyle(headerCellStyle12);
		}
		else {
			System.out.println("pt report");
		// Create a Row
		Row headerRow = sheet.createRow(6);

		// Creating cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(
				workbook.getCreationHelper().createDataFormat().getFormat("#.##"));
		int rowNum = 7;
		
		BigDecimal sumPTamout = new BigDecimal(0);
	
		for (ReportPayOutDTO reportPayOut : reportPayOutList) {
			if(reportPayOut.getPt()!=null && (reportPayOut.getPt().compareTo(BigDecimal.ZERO)>0)){
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(reportPayOut.getEmployeeCode());
			row.createCell(1).setCellValue(reportPayOut.getName());
			row.createCell(2).setCellValue(reportPayOut.getDepartmentName());
			row.createCell(3).setCellValue(reportPayOut.getDesignationName());
			sumPTamout=sumPTamout.add(reportPayOut.getPt()!=null?reportPayOut.getPt():BigDecimal.ZERO);
			Cell createdCell = row.createCell(4);
			createdCell.setCellValue(convertBigdecimalToString(reportPayOut.getPt()));
			createdCell.setCellStyle(cellStyle112);
		
			row.createCell(5).setCellValue(reportPayOut.getProcessMonth());
			row.createCell(6).setCellValue(reportPayOut.getStateName());}
		}
		//headerCellStyle.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
		Row row11 = sheet.createRow(rowNum++);
		for(int i=0;i<3;i++) {
			Cell cell00 = row11.createCell(i);
			cell00.setCellStyle(headerCellStyle1);
		}
		
		Cell cell0 = row11.createCell(3);
		cell0.setCellValue(" Total");
		cell0.setCellStyle(headerCellStyle1);
		Cell cell11 = row11.createCell(4);
		cell11.setCellValue(convertBigdecimalToDouble(sumPTamout));
		cell11.setCellStyle(headerCellStyle1);
		Cell cell15 = row11.createCell(5);
		cell15.setCellStyle(headerCellStyle1);
		Cell cell16 = row11.createCell(6);
		cell16.setCellStyle(headerCellStyle1);
		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
		}
		
		/*
		 * // Write the output to a file FileOutputStream fileOut = new
		 * FileOutputStream("E:\\poi-generated-file.xlsx"); workbook.write(fileOut);
		 * fileOut.close();
		 */
		return workbook;
	}

	
	public static Workbook provisionReport(List<ReportPayOutDTO> reportPayOutList, String[] columns, Date fromDate,
			Date toDate, Company company, Long departmentId) throws IOException, InvalidFormatException {

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances for various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Provision");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String fromdateString = dateFormat.format(fromDate);
		System.out.println(fromdateString);

		String todateString = dateFormat.format(toDate);
		System.out.println(todateString);
		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.FINE_DOTS);
		CellStyle headerCellStyle1 = workbook.createCellStyle();
		headerCellStyle1.setFont(headerFont);
		headerCellStyle1.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle cellStyle112 = workbook.createCellStyle();
		cellStyle112.setAlignment(HorizontalAlignment.RIGHT);
		cellStyle112.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat("0.00"));
		CellStyle cellStyle1 = workbook.createCellStyle();
		/*
		 * cellStyle1.setDataFormat(
		 * workbook.getCreationHelper().createDataFormat().getFormat("#.##00"));
		 */

		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
		row0.createCell(0).setCellValue(company.getCompanyName());

		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
		row1.createCell(0).setCellValue(company.getAddress1().getAddressText() + ",");

		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 3));
		row2.createCell(0).setCellValue(company.getAddress1().getLandmark() + ", "
				+ company.getAddress1().getCity().getCityName() + "- " + company.getAddress1().getPincode());

		Row row4 = sheet.createRow(4);

		Cell createdCell1 = row4.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 1));
		createdCell1.setCellValue("Provision Statement");
		createdCell1.setCellStyle(headerCellStyle1);

		Row row5 = sheet.createRow(5);

		sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 4));
		Cell createdDateCell1 = row5.createCell(0);
		createdDateCell1.setCellValue("From- " + fromdateString + "  To- " + todateString);

		if (reportPayOutList.isEmpty() || reportPayOutList.equals("")) {
			Font headerFont1 = workbook.createFont();
			headerFont1.setBold(true);
			headerFont1.setFontHeightInPoints((short) 16);
			headerFont1.setColor(IndexedColors.BLACK.getIndex());

			CellStyle headerCellStyle12 = workbook.createCellStyle();
			headerCellStyle12.setFont(headerFont);
			headerCellStyle12.setAlignment(HorizontalAlignment.CENTER);
			headerCellStyle12.setVerticalAlignment(VerticalAlignment.CENTER);
			headerCellStyle12.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
			headerCellStyle12.setFillPattern(FillPatternType.FINE_DOTS);

			Row headerRow = sheet.createRow(6);
			sheet.addMergedRegion(new CellRangeAddress(6, 7, 3, 8));
			Cell cell0 = headerRow.createCell(3);
			cell0.setCellValue(" Data not available");
			cell0.setCellStyle(headerCellStyle12);
		} else {
			Row row6 = sheet.createRow(6);

			if (departmentId != 0) {
				for (ReportPayOutDTO reportPayOut : reportPayOutList) {
					row6.createCell(0).setCellValue("Department-" + reportPayOut.getDepartmentName());
					break;
				}
			} else
				row6.createCell(0).setCellValue("Department-" + "All");
			// Create a Row
			Row headerRow = sheet.createRow(7);

			// Creating cells
			for (int i = 0; i < columns.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columns[i]);
				cell.setCellStyle(headerCellStyle);
			}

			// Create Cell Style for formatting Date

			int rowNum = 8;

			for (ReportPayOutDTO reportPayOut : reportPayOutList) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(reportPayOut.getName());
				row.createCell(1).setCellValue(reportPayOut.getEmployeeCode());
				row.createCell(2).setCellValue(reportPayOut.getBankName());
				row.createCell(3).setCellValue(reportPayOut.getAccountNumber());
				Cell createdCell = row.createCell(4);
				createdCell.setCellValue(convertBigdecimalToString(reportPayOut.getNetPayableAmount()));
				createdCell.setCellStyle(cellStyle112);

				Cell createdDateCell = row.createCell(5);
				createdDateCell.setCellValue(reportPayOut.getProvisionDateCreated());
				createdDateCell.setCellStyle(dateCellStyle);
				row.createCell(6).setCellValue(reportPayOut.getEmpDetp());
			}
			headerCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
			// Resize all columns to fit the content size
			for (int i = 0; i < columns.length; i++) {
				sheet.autoSizeColumn(i);
			}
		}
		/*
		 * // Write the output to a file FileOutputStream fileOut = new
		 * FileOutputStream("E:\\poi-generated-file.xlsx"); workbook.write(fileOut);
		 * fileOut.close();
		 */
		return workbook;
	}
	

	public static Workbook payrollMonthlyReport(List<ReportPayOutDTO> reportPayOutList, String[] columns, String fromProcessMonth,
			Company company,Long departmentId) throws IOException, InvalidFormatException {

		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("Payroll Summery");
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		Font rowFont = workbook.createFont();
		rowFont.setBold(true);
		rowFont.setFontHeightInPoints((short) 14);
		rowFont.setColor(IndexedColors.BLACK.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.FINE_DOTS);
		CellStyle headerCellStyle1 = workbook.createCellStyle();
		headerCellStyle1.setFont(headerFont);
		headerCellStyle1.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle1.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle1.setFillPattern(FillPatternType.FINE_DOTS);
		CellStyle headerCellStyle11 = workbook.createCellStyle();
		headerCellStyle11.setFont(headerFont);
		headerCellStyle11.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle11.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle rowCellStyle = workbook.createCellStyle();
		rowCellStyle.setFont(rowFont);
		
		CellStyle cellStyle112 = workbook.createCellStyle();
		cellStyle112.setAlignment(HorizontalAlignment.RIGHT);
		cellStyle112.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(
				workbook.getCreationHelper().createDataFormat().getFormat("0.00"));
		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
		row0.createCell(0).setCellValue(company.getCompanyName());
		
		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));
		row1.createCell(0).setCellValue(company.getAddress1().getAddressText()+",");
		
		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2,2,0,3));
		row2.createCell(0).setCellValue(company.getAddress1().getLandmark() +" , "+company.getAddress1().getCity().getCityName() +"- "+company.getAddress1().getPincode());

		Row row4 = sheet.createRow(4);
		Cell createdCell1 = row4.createCell(0);
		sheet.addMergedRegion(new CellRangeAddress(4,4,0,1));
		createdCell1.setCellValue("Payroll Register");
		createdCell1.setCellStyle(headerCellStyle11);
		Row row5 = sheet.createRow(5);
		row5.createCell(0).setCellValue(fromProcessMonth);
		if(reportPayOutList.isEmpty() ||reportPayOutList.equals("") ) {
			Font headerFont1 = workbook.createFont();
			headerFont1.setBold(true);
			headerFont1.setFontHeightInPoints((short) 16);
			headerFont1.setColor(IndexedColors.BLACK.getIndex());
      
			CellStyle headerCellStyle12 = workbook.createCellStyle();
			headerCellStyle12.setFont(headerFont);
			headerCellStyle12.setAlignment(HorizontalAlignment.CENTER);
			headerCellStyle12.setVerticalAlignment(VerticalAlignment.CENTER);
			headerCellStyle12.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
			headerCellStyle12.setFillPattern(FillPatternType.FINE_DOTS);
	
			Row headerRow = sheet.createRow(6);
			sheet.addMergedRegion(new CellRangeAddress(6,7,3,8));
			Cell cell0 = headerRow.createCell(3);
			cell0.setCellValue(" Data not available");
			cell0.setCellStyle(headerCellStyle12);
		}
		else {
		Row row6 = sheet.createRow(6);
		if(departmentId!=0) {
			for (ReportPayOutDTO reportPayOut : reportPayOutList) {
			row6.createCell(0).setCellValue("Department-"+reportPayOut.getDepartmentName());
			break;
			}
		}
		else
			row6.createCell(0).setCellValue("Department-"+"All");
		Row headerRow = sheet.createRow(7);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		BigDecimal sumBasic = new BigDecimal(0);
		BigDecimal sumDearnessAllowance = new BigDecimal(0);
		BigDecimal sumConveyanceAllowance = new BigDecimal(0);
		BigDecimal sumHra = new BigDecimal(0);
		BigDecimal sumMedicalAllowance = new BigDecimal(0);
		BigDecimal sumAdvanceBonus = new BigDecimal(0);
		BigDecimal sumSpecialAllowance = new BigDecimal(0);
		BigDecimal sumCompanyBenefits = new BigDecimal(0);
		BigDecimal sumOtherAllowance = new BigDecimal(0);
		BigDecimal sumGrossSalary = new BigDecimal(0);
		BigDecimal sumAbsense = new BigDecimal(0);
		BigDecimal sumCasualleave = new BigDecimal(0);
		BigDecimal sumSeekleave = new BigDecimal(0);
		BigDecimal sumPaidleave = new BigDecimal(0);
		BigDecimal sumPresense = new BigDecimal(0);
		BigDecimal sumPublicholidays = new BigDecimal(0);
		BigDecimal sumWeekoff = new BigDecimal(0);
		BigDecimal totalPayDays = new BigDecimal(0);
		//BigDecimal sumOvertime = new BigDecimal(0);
		BigDecimal sumBasicEarning = new BigDecimal(0);
		BigDecimal sumDearnessAllowanceEarning = new BigDecimal(0);
		BigDecimal sumConveyanceAllowanceEarning = new BigDecimal(0);
		BigDecimal sumHraEarning = new BigDecimal(0);
		BigDecimal sumMedicalAllowanceEarning = new BigDecimal(0);
		BigDecimal sumAdvanceBonusEarning = new BigDecimal(0);
		BigDecimal sumSpecialAllowanceEarning= new BigDecimal(0);
		BigDecimal totalCompanyBenefitsEarning = new BigDecimal(0);
		BigDecimal sumOtherAllowanceEarning = new BigDecimal(0);
		BigDecimal sumTotalEarning = new BigDecimal(0);
		BigDecimal sumLoan = new BigDecimal(0);
		BigDecimal sumProvidentFundEmployee = new BigDecimal(0);
		BigDecimal sumEsi_Employee= new BigDecimal(0);
		BigDecimal sumPt = new BigDecimal(0);
		BigDecimal sumTds = new BigDecimal(0);
		BigDecimal sumTotalDeduction = new BigDecimal(0);
		BigDecimal sumNetPayableAmount = new BigDecimal(0);
		int rowNum = 8;
		for (ReportPayOutDTO reportPayOut : reportPayOutList) {
			Row row = sheet.createRow(rowNum++);

			row.createCell(0).setCellValue(reportPayOut.getName());
			row.createCell(1).setCellValue(reportPayOut.getEmployeeCode());
			row.createCell(2).setCellValue(reportPayOut.getBankName());
			row.createCell(3).setCellValue(reportPayOut.getAccountNumber());

			Cell dateOfJoining = row.createCell(4);
			dateOfJoining.setCellValue(reportPayOut.getDateOfJoining());
			dateOfJoining.setCellStyle(dateCellStyle);
			sumBasic = sumBasic.add((reportPayOut.getBasic()!=null?reportPayOut.getBasic():BigDecimal.ZERO));
			
				Cell createdCell = row.createCell(5);
			    createdCell.setCellValue(convertBigdecimalToString(reportPayOut.getBasic()));
			    createdCell.setCellStyle(cellStyle112);
			
			sumDearnessAllowance = sumDearnessAllowance.add((reportPayOut.getDearnessAllowance()!=null?reportPayOut.getDearnessAllowance():BigDecimal.ZERO));
			
				Cell createdCell2 = row.createCell(6);
				createdCell2.setCellValue(convertBigdecimalToString(reportPayOut.getDearnessAllowance()));
				createdCell2.setCellStyle(cellStyle112);

			sumConveyanceAllowance = sumConveyanceAllowance.add(reportPayOut.getConveyanceAllowance()!=null?reportPayOut.getConveyanceAllowance():BigDecimal.ZERO);
				Cell createdCell3 = row.createCell(7);
				createdCell3.setCellValue(convertBigdecimalToString(reportPayOut.getConveyanceAllowance()));
				createdCell3.setCellStyle(cellStyle112);	
			
			sumHra = sumHra.add(reportPayOut.getHra()!=null?reportPayOut.getHra():BigDecimal.ZERO);
			    Cell createdCell4 = row.createCell(8);
				createdCell4.setCellValue(convertBigdecimalToString(reportPayOut.getHra()));
				createdCell4.setCellStyle(cellStyle112);	
			
			sumMedicalAllowance = sumMedicalAllowance.add(reportPayOut.getMedicalAllowance()!=null?reportPayOut.getMedicalAllowance():BigDecimal.ZERO);
			    Cell createdCell5 = row.createCell(9);
				createdCell5.setCellValue(convertBigdecimalToString(reportPayOut.getMedicalAllowance()));
				createdCell5.setCellStyle(cellStyle112);	
			
			sumAdvanceBonus = sumAdvanceBonus.add(reportPayOut.getAdvanceBonus()!=null?reportPayOut.getAdvanceBonus():BigDecimal.ZERO);
				Cell createdCell6 = row.createCell(10);
				createdCell6.setCellValue(convertBigdecimalToString(reportPayOut.getAdvanceBonus()) );
				createdCell6.setCellStyle(cellStyle112);	
		
			sumSpecialAllowance = sumSpecialAllowance.add(reportPayOut.getSpecialAllowance()!=null?reportPayOut.getSpecialAllowance():BigDecimal.ZERO);
		
				Cell createdCell7 = row.createCell(11);
				createdCell7.setCellValue(convertBigdecimalToString(reportPayOut.getSpecialAllowance()) );
				createdCell7.setCellStyle(cellStyle112);	
			
			sumCompanyBenefits = sumCompanyBenefits.add(reportPayOut.getCompanyBenefits()!=null?reportPayOut.getCompanyBenefits():BigDecimal.ZERO);
			Cell createdCell8 = row.createCell(12);
				createdCell8.setCellValue(convertBigdecimalToString(reportPayOut.getCompanyBenefits()));
				createdCell8.setCellStyle(cellStyle112);	
			
			sumOtherAllowance = sumOtherAllowance.add(reportPayOut.getOtherAllowance()!=null?reportPayOut.getOtherAllowance():BigDecimal.ZERO);
			
			    Cell createdCell9 = row.createCell(13);
				createdCell9.setCellValue(convertBigdecimalToString(reportPayOut.getOtherAllowance()));
				createdCell9.setCellStyle(cellStyle112);	
			
			sumGrossSalary = sumGrossSalary.add(reportPayOut.getGrossSalary()!=null?reportPayOut.getGrossSalary():BigDecimal.ZERO);
			
				Cell createdCell10 = row.createCell(14);
				createdCell10.setCellValue(convertBigdecimalToString(reportPayOut.getGrossSalary()));
				createdCell10.setCellStyle(cellStyle112);	
			
			sumAbsense = sumAbsense.add(reportPayOut.getAbsense()!=null?reportPayOut.getAbsense():BigDecimal.ZERO);			
			row.createCell(15).setCellValue(convertBigdecimalToDouble(reportPayOut.getAbsense()));
			sumCasualleave = sumCasualleave.add(reportPayOut.getCasualleave()!=null?reportPayOut.getCasualleave():BigDecimal.ZERO);
			row.createCell(16).setCellValue(convertBigdecimalToDouble(reportPayOut.getCasualleave()));
			sumSeekleave = sumSeekleave.add(reportPayOut.getSeekleave()!=null?reportPayOut.getSeekleave():BigDecimal.ZERO);
			row.createCell(17).setCellValue(convertBigdecimalToDouble(reportPayOut.getSeekleave()));
			sumPaidleave = sumPaidleave.add(reportPayOut.getPaidleave()!=null?reportPayOut.getPaidleave():BigDecimal.ZERO);
			row.createCell(18).setCellValue(convertBigdecimalToDouble(reportPayOut.getPaidleave()));
			sumPresense = sumPresense.add(reportPayOut.getPresense()!=null?reportPayOut.getPresense():BigDecimal.ZERO);
			row.createCell(19).setCellValue(convertBigdecimalToDouble(reportPayOut.getPresense()));
			sumPublicholidays = sumPublicholidays.add(reportPayOut.getPublicholidays()!=null?reportPayOut.getPublicholidays():BigDecimal.ZERO);
			row.createCell(20).setCellValue(convertBigdecimalToDouble(reportPayOut.getPublicholidays()));
			sumWeekoff = sumWeekoff.add(reportPayOut.getWeekoff()!=null?reportPayOut.getWeekoff():BigDecimal.ZERO);
			row.createCell(21).setCellValue(convertBigdecimalToDouble(reportPayOut.getWeekoff()));
			//sumOvertime = sumOvertime.add(reportPayOut.getOvertime()!=null?reportPayOut.getOvertime():BigDecimal.ZERO);
			//row.createCell(22).setCellValue(convertBigdecimalToDouble(reportPayOut.getOvertime()));
			totalPayDays = totalPayDays.add(reportPayOut.getPayDays()!=null?reportPayOut.getPayDays():BigDecimal.ZERO);
			row.createCell(22).setCellValue(convertBigdecimalToDouble(reportPayOut.getPayDays()));
			sumBasicEarning = sumBasicEarning.add(reportPayOut.getBasicEarning()!=null?reportPayOut.getBasicEarning():BigDecimal.ZERO);
			
				Cell createdCell11 = row.createCell(23);
				createdCell11.setCellValue(convertBigdecimalToString(reportPayOut.getBasicEarning()));
				createdCell11.setCellStyle(cellStyle112);	
			
			sumDearnessAllowanceEarning = sumDearnessAllowanceEarning.add(reportPayOut.getDearnessAllowanceEarning()!=null?reportPayOut.getDearnessAllowanceEarning():BigDecimal.ZERO);
			
				Cell createdCell12 = row.createCell(24);
				createdCell12.setCellValue(Double.valueOf(convertBigdecimalToString(reportPayOut.getDearnessAllowanceEarning())));
				createdCell12.setCellStyle(cellStyle112);	
			
			sumConveyanceAllowanceEarning = sumConveyanceAllowanceEarning.add(reportPayOut.getConveyanceAllowanceEarning()!=null?reportPayOut.getConveyanceAllowanceEarning():BigDecimal.ZERO);
			
				Cell createdCell13 = row.createCell(25);
				createdCell13.setCellValue(convertBigdecimalToString(reportPayOut.getConveyanceAllowanceEarning()));
				createdCell13.setCellStyle(cellStyle112);	
			sumHraEarning =  sumHraEarning.add(reportPayOut.getHraEarning()!=null?reportPayOut.getHraEarning():BigDecimal.ZERO);
			
				Cell createdCell14 = row.createCell(26);
				createdCell14.setCellValue(convertBigdecimalToString(reportPayOut.getHraEarning()));
				createdCell14.setCellStyle(cellStyle112);	
			
			sumMedicalAllowanceEarning = sumMedicalAllowanceEarning.add(reportPayOut.getMedicalAllowanceEarning()!=null?reportPayOut.getMedicalAllowanceEarning():BigDecimal.ZERO);
			
				Cell createdCell15 = row.createCell(27);
				createdCell15.setCellValue(convertBigdecimalToString(reportPayOut.getMedicalAllowanceEarning()));
				createdCell15.setCellStyle(cellStyle112);	
			
			sumAdvanceBonusEarning = sumAdvanceBonusEarning.add(reportPayOut.getAdvanceBonusEarning()!=null?reportPayOut.getAdvanceBonusEarning():BigDecimal.ZERO);
			
				Cell createdCell16 = row.createCell(28);
				createdCell16.setCellValue(convertBigdecimalToDouble(reportPayOut.getAdvanceBonusEarning()));
				createdCell16.setCellStyle(cellStyle112);	
			
			sumSpecialAllowanceEarning = sumSpecialAllowanceEarning.add(reportPayOut.getSpecialAllowanceEarning()!=null?reportPayOut.getSpecialAllowanceEarning():BigDecimal.ZERO);
			
				Cell createdCell17 = row.createCell(29);
				createdCell17.setCellValue(convertBigdecimalToString(reportPayOut.getSpecialAllowanceEarning()));
				createdCell17.setCellStyle(cellStyle112);	
			
			totalCompanyBenefitsEarning = totalCompanyBenefitsEarning.add(reportPayOut.getCompanyBenefitsEarning()!=null?reportPayOut.getAbsense():BigDecimal.ZERO);
			
				Cell createdCell18 = row.createCell(30);
				createdCell18.setCellValue(convertBigdecimalToString(reportPayOut.getCompanyBenefitsEarning()));
				createdCell18.setCellStyle(cellStyle112);	
			
			sumOtherAllowanceEarning = sumOtherAllowanceEarning.add(reportPayOut.getOtherAllowanceEarning()!=null?reportPayOut.getOtherAllowanceEarning():BigDecimal.ZERO);
			
				Cell createdCell19 = row.createCell(31);
				createdCell19.setCellValue(convertBigdecimalToString(reportPayOut.getOtherAllowanceEarning()));
				createdCell19.setCellStyle(cellStyle112);	
			
			sumTotalEarning = sumTotalEarning.add(reportPayOut.getTotalEarning()!=null?reportPayOut.getTotalEarning():BigDecimal.ZERO);
			Cell createdCell20 = row.createCell(32);
				createdCell20.setCellValue(convertBigdecimalToString(reportPayOut.getTotalEarning()));
				createdCell20.setCellStyle(cellStyle112);	
			
			sumLoan = sumLoan.add(reportPayOut.getLoan()!=null?reportPayOut.getLoan():BigDecimal.ZERO);
			
				Cell createdCell21 = row.createCell(33);
				createdCell21.setCellValue(convertBigdecimalToString(reportPayOut.getLoan()));
				createdCell21.setCellStyle(cellStyle112);	
			
			sumProvidentFundEmployee = sumProvidentFundEmployee.add(reportPayOut.getProvidentFundEmployee()!=null?reportPayOut.getProvidentFundEmployee():BigDecimal.ZERO);
			
				Cell createdCell22 = row.createCell(34);
				createdCell22.setCellValue(convertBigdecimalToString(reportPayOut.getProvidentFundEmployee()));
				createdCell22.setCellStyle(cellStyle112);	
			
			sumEsi_Employee = sumEsi_Employee.add(reportPayOut.getEsi_Employee()!=null?reportPayOut.getEsi_Employee():BigDecimal.ZERO);
				Cell createdCell23 = row.createCell(35);
				createdCell23.setCellValue(convertBigdecimalToString(reportPayOut.getEsi_Employee()));
				createdCell23.setCellStyle(cellStyle112);	
			
			sumPt = sumPt.add(reportPayOut.getPt()!=null?reportPayOut.getPt():BigDecimal.ZERO);
			
				Cell createdCell24 = row.createCell(36);
				createdCell24.setCellValue(convertBigdecimalToString(reportPayOut.getPt()));
				createdCell24.setCellStyle(cellStyle112);	
			
			sumTds = sumTds.add(reportPayOut.getTds()!=null?reportPayOut.getTds():BigDecimal.ZERO);
			
				Cell createdCell25 = row.createCell(37);
				createdCell25.setCellValue(convertBigdecimalToString(reportPayOut.getTds()));
				createdCell25.setCellStyle(cellStyle112);	
			
			sumTotalDeduction = sumTotalDeduction.add(reportPayOut.getTotalDeduction()!=null?reportPayOut.getTotalDeduction():BigDecimal.ZERO);
			
				Cell createdCell26 = row.createCell(38);
				createdCell26.setCellValue(convertBigdecimalToString(reportPayOut.getTotalDeduction()));
				createdCell26.setCellStyle(cellStyle112);	
			
			sumNetPayableAmount = sumNetPayableAmount.add(reportPayOut.getNetPayableAmount()!=null?reportPayOut.getNetPayableAmount():BigDecimal.ZERO);
			
				Cell createdCell27 = row.createCell(39);
				createdCell27.setCellValue(convertBigdecimalToString(reportPayOut.getNetPayableAmount()));
				createdCell27.setCellStyle(cellStyle112);	
			
		}
		
		//headerCellStyle.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
		Row row = sheet.createRow(rowNum);
		for(int i=0;i<4;i++) {
			Cell cell11 = row.createCell(i);
			cell11.setCellStyle(headerCellStyle1);
		}
		Cell cell0 = row.createCell(4);
		cell0.setCellValue("Grand Total");
		cell0.setCellStyle(headerCellStyle1);

		Cell cell = row.createCell(5);
		cell.setCellValue(convertBigdecimalToDouble(sumBasic));
		cell.setCellStyle(headerCellStyle1);

		Cell cell1 = row.createCell(6);
		cell1.setCellValue(convertBigdecimalToDouble(sumDearnessAllowance));
		cell1.setCellStyle(headerCellStyle1);

		Cell cell2 = row.createCell(7);
		cell2.setCellValue(convertBigdecimalToDouble(sumConveyanceAllowance));
		cell2.setCellStyle(headerCellStyle1);

		Cell cell3 = row.createCell(8);
		cell3.setCellValue(convertBigdecimalToDouble(sumHra));
		cell3.setCellStyle(headerCellStyle1);

		Cell cell4 = row.createCell(9);
		cell4.setCellValue(convertBigdecimalToDouble(sumMedicalAllowance));
		cell4.setCellStyle(headerCellStyle1);

		Cell cell5 = row.createCell(10);
		cell5.setCellValue(convertBigdecimalToDouble(sumAdvanceBonus));
		cell5.setCellStyle(headerCellStyle1);

		Cell cell6 = row.createCell(11);
		cell6.setCellValue(convertBigdecimalToDouble(sumSpecialAllowance));
		cell6.setCellStyle(headerCellStyle1);

		Cell cell8 = row.createCell(12);
		cell8.setCellValue(convertBigdecimalToDouble(sumCompanyBenefits));
		cell8.setCellStyle(headerCellStyle1);

		Cell cell9 = row.createCell(13);
		cell9.setCellValue(convertBigdecimalToDouble(sumOtherAllowance));
		cell9.setCellStyle(headerCellStyle1);

		Cell cell10 = row.createCell(14);
		cell10.setCellValue(convertBigdecimalToDouble(sumGrossSalary));
		cell10.setCellStyle(headerCellStyle1);

		Cell cell11 = row.createCell(15);
		cell11.setCellValue(convertBigdecimalToDouble(sumAbsense));
		cell11.setCellStyle(headerCellStyle1);

		Cell cell12 = row.createCell(16);
		cell12.setCellValue(convertBigdecimalToDouble(sumCasualleave));
		cell12.setCellStyle(headerCellStyle1);

		Cell cell13 = row.createCell(17);
		cell13.setCellValue(convertBigdecimalToDouble(sumSeekleave));
		cell13.setCellStyle(headerCellStyle1);

		Cell cell14 = row.createCell(18);
		cell14.setCellValue(convertBigdecimalToDouble(sumPaidleave));
		cell14.setCellStyle(headerCellStyle1);

		Cell cell15 = row.createCell(19);
		cell15.setCellValue(convertBigdecimalToDouble(sumPresense));
		cell15.setCellStyle(headerCellStyle1);

		Cell cell16 = row.createCell(20);
		cell16.setCellValue(convertBigdecimalToDouble(sumPublicholidays));
		cell16.setCellStyle(headerCellStyle1);

		Cell cell17 = row.createCell(21);
		cell17.setCellValue(convertBigdecimalToDouble(sumWeekoff));
		cell17.setCellStyle(headerCellStyle1);

		/*Cell cell18 = row.createCell(22);
		cell18.setCellValue(convertBigdecimalToDouble(sumOvertime));
		cell18.setCellStyle(headerCellStyle1);*/

		Cell cell19 = row.createCell(22);
		cell19.setCellValue(convertBigdecimalToDouble(totalPayDays));
		cell19.setCellStyle(headerCellStyle1);

		Cell cell20 = row.createCell(23);
		cell20.setCellValue(convertBigdecimalToDouble(sumBasicEarning));
		cell20.setCellStyle(headerCellStyle1);

		Cell cell21 = row.createCell(24);
		cell21.setCellValue(convertBigdecimalToDouble(sumDearnessAllowanceEarning));
		cell21.setCellStyle(headerCellStyle1);

		Cell cell22 = row.createCell(25);
		cell22.setCellValue(convertBigdecimalToDouble(sumConveyanceAllowanceEarning));
		cell22.setCellStyle(headerCellStyle1);

		Cell cell23 = row.createCell(26);
		cell23.setCellValue(convertBigdecimalToDouble(sumHraEarning));
		cell23.setCellStyle(headerCellStyle1);

		Cell cell24 = row.createCell(27);
		cell24.setCellValue(convertBigdecimalToDouble(sumMedicalAllowanceEarning));
		cell24.setCellStyle(headerCellStyle1);

		Cell cell25 = row.createCell(28);
		cell25.setCellValue(convertBigdecimalToDouble(sumAdvanceBonusEarning));
		cell25.setCellStyle(headerCellStyle1);

		Cell cell26 = row.createCell(29);
		cell26.setCellValue(convertBigdecimalToDouble(sumSpecialAllowanceEarning));
		cell26.setCellStyle(headerCellStyle1);

		Cell cell27 = row.createCell(30);
		cell27.setCellValue(convertBigdecimalToDouble(totalCompanyBenefitsEarning));
		cell27.setCellStyle(headerCellStyle1);

		Cell cell28 = row.createCell(31);
		cell28.setCellValue(convertBigdecimalToDouble(sumOtherAllowanceEarning));
		cell28.setCellStyle(headerCellStyle1);

		Cell cell29 = row.createCell(32);
		cell29.setCellValue(convertBigdecimalToDouble(sumTotalEarning));
		cell29.setCellStyle(headerCellStyle1);

		Cell cell30 = row.createCell(33);
		cell30.setCellValue(convertBigdecimalToDouble(sumLoan));
		cell30.setCellStyle(headerCellStyle1);

		Cell cell31 = row.createCell(34);
		cell31.setCellValue(convertBigdecimalToDouble(sumProvidentFundEmployee));
		cell31.setCellStyle(headerCellStyle1);

		Cell cell32 = row.createCell(35);
		cell32.setCellValue(convertBigdecimalToDouble(sumEsi_Employee));
		cell32.setCellStyle(headerCellStyle1);

		Cell cell33 = row.createCell(36);
		cell33.setCellValue(convertBigdecimalToDouble(sumPt));
		cell33.setCellStyle(headerCellStyle1);
		
		Cell cell34 = row.createCell(37);
		cell34.setCellValue(convertBigdecimalToDouble(sumTds));
		cell34.setCellStyle(headerCellStyle1);

		Cell cell35 = row.createCell(38);
		cell35.setCellValue(convertBigdecimalToDouble(sumTotalDeduction));
		cell35.setCellStyle(headerCellStyle1);

		Cell cell36 = row.createCell(39);
		cell36.setCellValue(convertBigdecimalToDouble(sumNetPayableAmount));
		cell36.setCellStyle(headerCellStyle1);

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}}
		return workbook;
	}	
	public static Workbook bankReport(List<ReportPayOutDTO> reportPayOutDtoList1, String[] columns, Company company, String processMonth) throws IOException, InvalidFormatException {
  		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
 		/*
		 * CreationHelper helps us create instances for various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();
 		// Create a Sheet
		Sheet sheet = workbook.createSheet("Bank Report");
 		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.FINE_DOTS);
		
		
		CellStyle headerCellStyle1 = workbook.createCellStyle();
		headerCellStyle1.setFont(headerFont);
		headerCellStyle1.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		// Create Other rows and cells with employees data
		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
		row0.createCell(0).setCellValue(company.getCompanyName());

		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));
 		row1.createCell(0).setCellValue(company.getAddress1().getAddressText()+" ,");
 		
 		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2,2,0,2));
		row2.createCell(0).setCellValue(company.getAddress1().getLandmark() +", "+company.getAddress1().getCity().getCityName() +"- "+company.getAddress1().getPincode());
 	
		CellStyle headerCellStyle2 = workbook.createCellStyle();
		headerCellStyle2.setFont(headerFont);
		headerCellStyle2.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
 		
		Row row4 = sheet.createRow(4);
		sheet.addMergedRegion(new CellRangeAddress(4,4,0,1));
   		Cell cell1 = row4.createCell(0);
		cell1.setCellValue("Bank Payment Summery");	
		cell1.setCellStyle(headerCellStyle2);
		
		
		
		Row row5 = sheet.createRow(5);
		row5.createCell(0).setCellValue(processMonth);
   		// Create a Row
		Row headerRow = sheet.createRow(7);
  		 
 
		// Creating cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);

		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		BigDecimal totalAmount = new BigDecimal(0);
 		int rowNum = 8;
 		 
		for (ReportPayOutDTO reportPayOut : reportPayOutDtoList1) {
  			Row row = sheet.createRow(rowNum++);
  			row.createCell(0).setCellValue(reportPayOut.getName());
			row.createCell(1).setCellValue(reportPayOut.getEmployeeCode());
			row.createCell(2).setCellValue(reportPayOut.getBankName());
			row.createCell(3).setCellValue(reportPayOut.getAccountNumber());
 			row.createCell(4).setCellValue(convertBigdecimalToDouble(reportPayOut.getNetPayableAmount()));
 			row.createCell(5).setCellValue(reportPayOut.getDepartmentName());
 			totalAmount = totalAmount.add(reportPayOut.getNetPayableAmount());
 		} 
		CellStyle headerCellStyle3 = workbook.createCellStyle();
		headerCellStyle3.setFont(headerFont);
		headerCellStyle3.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
		Row row = sheet.createRow(rowNum);
 		for(int i=0;i<3;i++) {
			Cell cell11 = row.createCell(i);
			cell11.setCellValue("TOTAL");
 			cell11.setCellStyle(headerCellStyle);
		}
		Row rowNew5 = sheet.createRow(rowNum);
		Cell cell0 = rowNew5.createCell(0);
 		cell0.setCellValue("");
 		Cell cell8 = rowNew5.createCell(1);
 		cell8.setCellValue("");
 		Cell cell9 = rowNew5.createCell(2);
 		cell9.setCellValue("");
 		Cell cell3 = rowNew5.createCell(3);
 		cell3.setCellValue("TOTAL");
		cell3.setCellStyle(headerCellStyle);
  		
		Cell cell6 = rowNew5.createCell(4);
		headerCellStyle1.setAlignment(HorizontalAlignment.RIGHT);

		cell6.setCellValue(convertBigdecimalToDouble(totalAmount));
		cell6.setCellStyle(headerCellStyle);
		/*Cell cell5 = rowNew5.createCell(5);
 		cell5.setCellValue("");
		cell5.setCellStyle(headerCellStyle);*/
		
 		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);


		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

 		return workbook;
	}
	
	public static Workbook reconciliationReport(List<ReportPayOutDTO> reportPayOutDtoList, String[] columns,
			Company company, String processMonth, String checkReco, Long departmentId)
			throws IOException, InvalidFormatException {

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
		CreationHelper createHelper = workbook.getCreationHelper();
		// Create a Sheet
		Sheet sheet = null;
		if (checkReco.equals("true"))
			sheet = workbook.createSheet("Non Reconciliation Report");
		else
			sheet = workbook.createSheet("Reconciliation Report");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		// Create a CellStyle with the font
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.FINE_DOTS);

		CellStyle headerCellStyle1 = workbook.createCellStyle();
		headerCellStyle1.setFont(headerFont);
		headerCellStyle1.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		// Create Other rows and cells with employees data
		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
		row0.createCell(0).setCellValue(company.getCompanyName());

		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 1));
		row1.createCell(0).setCellValue(company.getAddress1().getAddressText() + " ,");

		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 2));
		row2.createCell(0).setCellValue(company.getAddress1().getLandmark() + ", "
				+ company.getAddress1().getCity().getCityName() + "- " + company.getAddress1().getPincode());

		CellStyle headerCellStyle2 = workbook.createCellStyle();
		headerCellStyle2.setFont(headerFont);
		headerCellStyle2.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);

		Row row4 = sheet.createRow(4);
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 1));
		Cell cell1 = row4.createCell(0);
		cell1.setCellValue("Payroll Reconciliation Statement");
		cell1.setCellStyle(headerCellStyle2);

		Row row5 = sheet.createRow(5);
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 1));
		row5.createCell(0).setCellValue("Month: -" + processMonth);

		Row row6 = sheet.createRow(6);
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 1));

		if (departmentId != 0) {
			for (ReportPayOutDTO reportPayOutDto : reportPayOutDtoList) {
				row6.createCell(0).setCellValue("Department-" + reportPayOutDto.getDepartmentName());
				break;
			}
		} else
			row6.createCell(0).setCellValue("Department-" + "All");

		// Create a Row
		Row headerRow = sheet.createRow(8);

		// Creating cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);

		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		BigDecimal totalAmount = new BigDecimal(0);
		int rowNum = 9;
		if (departmentId == 0) {
			for (ReportPayOutDTO reportPayOut : reportPayOutDtoList) {

				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(reportPayOut.getEmployeeCode());
				row.createCell(1).setCellValue(reportPayOut.getName());
				row.createCell(2).setCellValue(reportPayOut.getBankName());
				row.createCell(3).setCellValue(reportPayOut.getAccountNumber());
				row.createCell(4).setCellValue(convertBigdecimalToDouble(reportPayOut.getNetPayableAmount()));

				Cell contractOverDateCell = row.createCell(5);
				if (reportPayOut.getReconciliationDate() != null)
					contractOverDateCell.setCellValue(reportPayOut.getReconciliationDate());
				else
					row.createCell(5).setCellValue("Under Process");
				contractOverDateCell.setCellStyle(dateCellStyle);
				contractOverDateCell.setCellStyle(dateCellStyle);

				if (reportPayOut.getTransactionNo() != null)
					row.createCell(6).setCellValue(reportPayOut.getTransactionNo());
				else
					row.createCell(6).setCellValue("Under Process");

				totalAmount = totalAmount.add(reportPayOut.getNetPayableAmount());
			}
		} else {

			for (ReportPayOutDTO reportPayOut : reportPayOutDtoList) {

				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(reportPayOut.getEmployeeCode());
				row.createCell(1).setCellValue(reportPayOut.getName());
				row.createCell(2).setCellValue(reportPayOut.getDepartmentName());

				row.createCell(3).setCellValue(reportPayOut.getBankName());
				row.createCell(4).setCellValue(reportPayOut.getAccountNumber());
				row.createCell(5).setCellValue(convertBigdecimalToDouble(reportPayOut.getNetPayableAmount()));

				Cell contractOverDateCell = row.createCell(6);
				if (reportPayOut.getReconciliationDate() != null)
					contractOverDateCell.setCellValue(reportPayOut.getReconciliationDate());
				else
					row.createCell(6).setCellValue("Under Process");
				contractOverDateCell.setCellStyle(dateCellStyle);
				contractOverDateCell.setCellStyle(dateCellStyle);

				if (reportPayOut.getTransactionNo() != null)
					row.createCell(7).setCellValue(reportPayOut.getTransactionNo());
				else
					row.createCell(7).setCellValue("Under Process");

				totalAmount = totalAmount.add(reportPayOut.getNetPayableAmount());
			}
		}
		Row rowNew5 = sheet.createRow(rowNum);
		// Create a CellStyle with the font
		headerCellStyle1.setFont(headerFont);
		headerCellStyle1.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);

		Row row = sheet.createRow(rowNum);
		for (int i = 0; i < 2; i++) {
			Cell cell11 = row.createCell(i);
			cell11.setCellStyle(headerCellStyle);
		}

		Cell cell101 = row.createCell(0);
		cell101.setCellValue("");
		cell101.setCellStyle(headerCellStyle);

		Cell cell102 = row.createCell(1);
		cell102.setCellValue("");
		cell102.setCellStyle(headerCellStyle);

		Cell cell103 = row.createCell(2);
		cell103.setCellValue("");
		cell103.setCellStyle(headerCellStyle);
		
		
		if(departmentId!=0) {
		Cell cell104 = row.createCell(3);
		cell104.setCellValue("");
		cell104.setCellStyle(headerCellStyle);
		
		Cell cell3 = row.createCell(4);
		cell3.setCellValue("TOTAL ");
		cell3.setCellStyle(headerCellStyle);

		Cell cell6 = row.createCell(5);
		cell6.setCellValue(convertBigdecimalToDouble(totalAmount));
		cell6.setCellStyle(headerCellStyle);

		Cell cell7 = row.createCell(6);
		cell7.setCellValue("");
		cell7.setCellStyle(headerCellStyle);

		Cell cell8 = row.createCell(7);
		cell8.setCellValue("");
		cell8.setCellStyle(headerCellStyle);
		
 		}
		else {
			Cell cell3 = row.createCell(3);
			cell3.setCellValue("TOTAL ");
			cell3.setCellStyle(headerCellStyle);

			Cell cell6 = row.createCell(4);
			cell6.setCellValue(convertBigdecimalToDouble(totalAmount));
			cell6.setCellStyle(headerCellStyle);

			Cell cell7 = row.createCell(5);
			cell7.setCellValue("");
			cell7.setCellStyle(headerCellStyle);

			Cell cell8 = row.createCell(6);
			cell8.setCellValue("");
			cell8.setCellStyle(headerCellStyle);
		}

		

/*		if (departmentId != 0) {
			Cell cell9 = row.createCell(7);
			cell9.setCellValue("");
			cell9.setCellStyle(headerCellStyle);
		}
*/		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
		return workbook;
	}
	
	public static Workbook payrollMonthlyReportByEmpId(List<ReportPayOutDTO> reportPayOutList, String[] columns, String fromProcessMonth, String toProcessMonth,
			Company company) throws IOException, InvalidFormatException {

		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();
        String toProcessMnth = (fromProcessMonth.equals(toProcessMonth)?"":(" to "+toProcessMonth));
		Sheet sheet = workbook.createSheet("Payroll Summery");
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		Font rowFont = workbook.createFont();
		rowFont.setBold(true);
		rowFont.setFontHeightInPoints((short) 14);
		rowFont.setColor(IndexedColors.BLACK.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.FINE_DOTS);
		CellStyle headerCellStyle1 = workbook.createCellStyle();
		headerCellStyle1.setFont(headerFont);
		headerCellStyle1.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle1.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle1.setFillPattern(FillPatternType.FINE_DOTS);
		CellStyle headerCellStyle11 = workbook.createCellStyle();
		headerCellStyle11.setFont(headerFont);
		headerCellStyle11.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle11.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle rowCellStyle = workbook.createCellStyle();
		rowCellStyle.setFont(rowFont);

		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		row0.createCell(0).setCellValue(company.getCompanyName());
		
		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));
		row1.createCell(0).setCellValue(company.getAddress1().getAddressText()+" ,");
		
		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2,2,0,3));
		row2.createCell(0).setCellValue(company.getAddress1().getLandmark() +" , "+company.getAddress1().getCity().getCityName() +"- "+company.getAddress1().getPincode());

 		Row row4 = sheet.createRow(4);
 		Cell celll = row4.createCell(0);
		celll.setCellValue("Payroll Register");
		celll.setCellStyle(headerCellStyle11);
		
		Row row5 = sheet.createRow(5);
		sheet.addMergedRegion(new CellRangeAddress(5,5,0,1));
		row5.createCell(0).setCellValue(fromProcessMonth + toProcessMnth);
		if(reportPayOutList.isEmpty() ||reportPayOutList.equals("") ) {
			Font headerFont1 = workbook.createFont();
			headerFont1.setBold(true);
			headerFont1.setFontHeightInPoints((short) 16);
			headerFont1.setColor(IndexedColors.BLACK.getIndex());
      
			CellStyle headerCellStyle12 = workbook.createCellStyle();
			headerCellStyle12.setFont(headerFont);
			headerCellStyle12.setAlignment(HorizontalAlignment.CENTER);
			headerCellStyle12.setVerticalAlignment(VerticalAlignment.CENTER);
			headerCellStyle12.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
			headerCellStyle12.setFillPattern(FillPatternType.FINE_DOTS);
	
			Row headerRow = sheet.createRow(6);
			sheet.addMergedRegion(new CellRangeAddress(6,7,3,8));
			Cell cell0 = headerRow.createCell(3);
			cell0.setCellValue(" Data not available");
			cell0.setCellStyle(headerCellStyle12);
		}
		else {
		Row headerRow = sheet.createRow(6);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}
		BigDecimal sumBasic = new BigDecimal(0);
		BigDecimal sumDearnessAllowance = new BigDecimal(0);
		BigDecimal sumConveyanceAllowance = new BigDecimal(0);
		BigDecimal sumHra = new BigDecimal(0);
		BigDecimal sumMedicalAllowance = new BigDecimal(0);
		BigDecimal sumAdvanceBonus = new BigDecimal(0);
		BigDecimal sumSpecialAllowance = new BigDecimal(0);
		BigDecimal sumCompanyBenefits = new BigDecimal(0);
		BigDecimal sumOtherAllowance = new BigDecimal(0);
		BigDecimal sumGrossSalary = new BigDecimal(0);
		BigDecimal sumAbsense = new BigDecimal(0);
		BigDecimal sumCasualleave = new BigDecimal(0);
		BigDecimal sumSeekleave = new BigDecimal(0);
		BigDecimal sumPaidleave = new BigDecimal(0);
		BigDecimal sumPresense = new BigDecimal(0);
		BigDecimal sumPublicholidays = new BigDecimal(0);
		BigDecimal sumWeekoff = new BigDecimal(0);
		BigDecimal totalPayDays = new BigDecimal(0);
		//BigDecimal sumOvertime = new BigDecimal(0);
		BigDecimal sumBasicEarning = new BigDecimal(0);
		BigDecimal sumDearnessAllowanceEarning = new BigDecimal(0);
		BigDecimal sumConveyanceAllowanceEarning = new BigDecimal(0);
		BigDecimal sumHraEarning = new BigDecimal(0);
		BigDecimal sumMedicalAllowanceEarning = new BigDecimal(0);
		BigDecimal sumAdvanceBonusEarning = new BigDecimal(0);
		BigDecimal sumSpecialAllowanceEarning= new BigDecimal(0);
		BigDecimal totalCompanyBenefitsEarning = new BigDecimal(0);
		BigDecimal sumOtherAllowanceEarning = new BigDecimal(0);
		BigDecimal sumTotalEarning = new BigDecimal(0);
		BigDecimal sumLoan = new BigDecimal(0);
		BigDecimal sumProvidentFundEmployee = new BigDecimal(0);
		BigDecimal sumEsi_Employee= new BigDecimal(0);
		BigDecimal sumPt = new BigDecimal(0);
		BigDecimal sumTds = new BigDecimal(0);
		BigDecimal sumTotalDeduction = new BigDecimal(0);
		BigDecimal sumNetPayableAmount = new BigDecimal(0);
		int rowNum = 7;
		for (ReportPayOutDTO reportPayOut : reportPayOutList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(reportPayOut.getProcessMonth());
			row.createCell(1).setCellValue(reportPayOut.getName());
			row.createCell(2).setCellValue(reportPayOut.getEmployeeCode());
			row.createCell(2).setCellValue(reportPayOut.getBankName());
			row.createCell(4).setCellValue(reportPayOut.getAccountNumber());

			Cell dateOfJoining = row.createCell(5);
			dateOfJoining.setCellValue(reportPayOut.getDateOfJoining());
			dateOfJoining.setCellStyle(dateCellStyle);
			sumBasic = sumBasic.add((reportPayOut.getBasic()!=null?reportPayOut.getBasic():BigDecimal.ZERO));
			row.createCell(6).setCellValue(convertBigdecimalToDouble(reportPayOut.getBasic()));
			sumDearnessAllowance = sumDearnessAllowance.add((reportPayOut.getDearnessAllowance()!=null?reportPayOut.getDearnessAllowance():BigDecimal.ZERO));
			row.createCell(7).setCellValue(convertBigdecimalToDouble(reportPayOut.getDearnessAllowance()));
			sumConveyanceAllowance = sumConveyanceAllowance.add(reportPayOut.getConveyanceAllowance()!=null?reportPayOut.getConveyanceAllowance():BigDecimal.ZERO);
			row.createCell(8).setCellValue(convertBigdecimalToDouble(reportPayOut.getConveyanceAllowance()));
			sumHra = sumHra.add(reportPayOut.getHra()!=null?reportPayOut.getHra():BigDecimal.ZERO);
			row.createCell(9).setCellValue(convertBigdecimalToDouble(reportPayOut.getHra()));
			sumMedicalAllowance = sumMedicalAllowance.add(reportPayOut.getMedicalAllowance()!=null?reportPayOut.getMedicalAllowance():BigDecimal.ZERO);
			row.createCell(10).setCellValue(convertBigdecimalToDouble(reportPayOut.getMedicalAllowance()));
			sumAdvanceBonus = sumAdvanceBonus.add(reportPayOut.getAdvanceBonus()!=null?reportPayOut.getAdvanceBonus():BigDecimal.ZERO);
			row.createCell(11).setCellValue(convertBigdecimalToDouble(reportPayOut.getAdvanceBonus()));
			sumSpecialAllowance = sumSpecialAllowance.add(reportPayOut.getSpecialAllowance()!=null?reportPayOut.getSpecialAllowance():BigDecimal.ZERO);
			row.createCell(12).setCellValue(convertBigdecimalToDouble(reportPayOut.getSpecialAllowance()));
			sumCompanyBenefits = sumCompanyBenefits.add(reportPayOut.getCompanyBenefits()!=null?reportPayOut.getCompanyBenefits():BigDecimal.ZERO);
			row.createCell(13).setCellValue(convertBigdecimalToDouble(reportPayOut.getCompanyBenefits()));
			sumOtherAllowance = sumOtherAllowance.add(reportPayOut.getOtherAllowance()!=null?reportPayOut.getOtherAllowance():BigDecimal.ZERO);
			row.createCell(14).setCellValue(convertBigdecimalToDouble(reportPayOut.getOtherAllowance()));
			sumGrossSalary = sumGrossSalary.add(reportPayOut.getGrossSalary()!=null?reportPayOut.getGrossSalary():BigDecimal.ZERO);
			row.createCell(15).setCellValue(convertBigdecimalToDouble(reportPayOut.getGrossSalary()));
			sumAbsense = sumAbsense.add(reportPayOut.getAbsense()!=null?reportPayOut.getAbsense():BigDecimal.ZERO);			
			row.createCell(16).setCellValue(convertBigdecimalToDouble(reportPayOut.getAbsense()));
			sumCasualleave = sumCasualleave.add(reportPayOut.getCasualleave()!=null?reportPayOut.getCasualleave():BigDecimal.ZERO);
			row.createCell(17).setCellValue(convertBigdecimalToDouble(reportPayOut.getCasualleave()));
			sumSeekleave = sumSeekleave.add(reportPayOut.getSeekleave()!=null?reportPayOut.getSeekleave():BigDecimal.ZERO);
			row.createCell(18).setCellValue(convertBigdecimalToDouble(reportPayOut.getSeekleave()));
			sumPaidleave = sumPaidleave.add(reportPayOut.getPaidleave()!=null?reportPayOut.getPaidleave():BigDecimal.ZERO);
			row.createCell(19).setCellValue(convertBigdecimalToDouble(reportPayOut.getPaidleave()));
			sumPresense = sumPresense.add(reportPayOut.getPresense()!=null?reportPayOut.getPresense():BigDecimal.ZERO);
			row.createCell(20).setCellValue(convertBigdecimalToDouble(reportPayOut.getPresense()));
			sumPublicholidays = sumPublicholidays.add(reportPayOut.getPublicholidays()!=null?reportPayOut.getPublicholidays():BigDecimal.ZERO);
			row.createCell(21).setCellValue(convertBigdecimalToDouble(reportPayOut.getPublicholidays()));
			sumWeekoff = sumWeekoff.add(reportPayOut.getWeekoff()!=null?reportPayOut.getWeekoff():BigDecimal.ZERO);
			row.createCell(22).setCellValue(convertBigdecimalToDouble(reportPayOut.getWeekoff()));
			//sumOvertime = sumOvertime.add(reportPayOut.getOvertime()!=null?reportPayOut.getOvertime():BigDecimal.ZERO);
			//row.createCell(23).setCellValue(convertBigdecimalToDouble(reportPayOut.getOvertime()));
			totalPayDays = totalPayDays.add(reportPayOut.getPayDays()!=null?reportPayOut.getPayDays():BigDecimal.ZERO);
			row.createCell(23).setCellValue(convertBigdecimalToDouble(reportPayOut.getPayDays()));
			sumBasicEarning = sumBasicEarning.add(reportPayOut.getBasicEarning()!=null?reportPayOut.getBasicEarning():BigDecimal.ZERO);
			row.createCell(24).setCellValue(convertBigdecimalToDouble(reportPayOut.getBasicEarning()));
			sumDearnessAllowanceEarning = sumDearnessAllowanceEarning.add(reportPayOut.getDearnessAllowanceEarning()!=null?reportPayOut.getDearnessAllowanceEarning():BigDecimal.ZERO);
			row.createCell(25).setCellValue(convertBigdecimalToDouble(reportPayOut.getDearnessAllowanceEarning()));
			sumConveyanceAllowanceEarning = sumConveyanceAllowanceEarning.add(reportPayOut.getConveyanceAllowanceEarning()!=null?reportPayOut.getConveyanceAllowanceEarning():BigDecimal.ZERO);
			row.createCell(26).setCellValue(convertBigdecimalToDouble(reportPayOut.getConveyanceAllowanceEarning()));
			sumHraEarning =  sumHraEarning.add(reportPayOut.getHraEarning()!=null?reportPayOut.getHraEarning():BigDecimal.ZERO);
			row.createCell(27).setCellValue(convertBigdecimalToDouble(reportPayOut.getHraEarning()));
			sumMedicalAllowanceEarning = sumMedicalAllowanceEarning.add(reportPayOut.getMedicalAllowanceEarning()!=null?reportPayOut.getMedicalAllowanceEarning():BigDecimal.ZERO);
			row.createCell(28).setCellValue(convertBigdecimalToDouble(reportPayOut.getMedicalAllowanceEarning()));
			sumAdvanceBonusEarning = sumAdvanceBonusEarning.add(reportPayOut.getAdvanceBonusEarning()!=null?reportPayOut.getAdvanceBonusEarning():BigDecimal.ZERO);
			row.createCell(29).setCellValue(convertBigdecimalToDouble(reportPayOut.getAdvanceBonusEarning()));
			sumSpecialAllowanceEarning = sumSpecialAllowanceEarning.add(reportPayOut.getSpecialAllowanceEarning()!=null?reportPayOut.getSpecialAllowanceEarning():BigDecimal.ZERO);
			row.createCell(30).setCellValue(convertBigdecimalToDouble(reportPayOut.getSpecialAllowanceEarning()));
			totalCompanyBenefitsEarning = totalCompanyBenefitsEarning.add(reportPayOut.getCompanyBenefitsEarning()!=null?reportPayOut.getAbsense():BigDecimal.ZERO);
			row.createCell(31).setCellValue(convertBigdecimalToDouble(reportPayOut.getCompanyBenefitsEarning()));
			sumOtherAllowanceEarning = sumOtherAllowanceEarning.add(reportPayOut.getOtherAllowanceEarning()!=null?reportPayOut.getOtherAllowanceEarning():BigDecimal.ZERO);
			row.createCell(32).setCellValue(convertBigdecimalToDouble(reportPayOut.getOtherAllowanceEarning()));
			sumTotalEarning = sumTotalEarning.add(reportPayOut.getTotalEarning()!=null?reportPayOut.getTotalEarning():BigDecimal.ZERO);
			row.createCell(33).setCellValue(convertBigdecimalToDouble(reportPayOut.getTotalEarning()));
			sumLoan = sumLoan.add(reportPayOut.getLoan()!=null?reportPayOut.getLoan():BigDecimal.ZERO);
			row.createCell(34).setCellValue(convertBigdecimalToDouble(reportPayOut.getLoan()));
			sumProvidentFundEmployee = sumProvidentFundEmployee.add(reportPayOut.getProvidentFundEmployee()!=null?reportPayOut.getProvidentFundEmployee():BigDecimal.ZERO);
			row.createCell(35).setCellValue(convertBigdecimalToDouble(reportPayOut.getProvidentFundEmployee()));
			sumEsi_Employee = sumEsi_Employee.add(reportPayOut.getEsi_Employee()!=null?reportPayOut.getEsi_Employee():BigDecimal.ZERO);
			row.createCell(36).setCellValue(convertBigdecimalToDouble(reportPayOut.getEsi_Employee()));
			sumPt = sumPt.add(reportPayOut.getPt()!=null?reportPayOut.getPt():BigDecimal.ZERO);
			row.createCell(37).setCellValue(convertBigdecimalToDouble(reportPayOut.getPt()));
			sumTds = sumTds.add(reportPayOut.getTds()!=null?reportPayOut.getTds():BigDecimal.ZERO);
			row.createCell(38).setCellValue(convertBigdecimalToDouble(reportPayOut.getTds()));
			sumTotalDeduction = sumTotalDeduction.add(reportPayOut.getTotalDeduction()!=null?reportPayOut.getTotalDeduction():BigDecimal.ZERO);
			row.createCell(39).setCellValue(convertBigdecimalToDouble(reportPayOut.getTotalDeduction()));
			sumNetPayableAmount = sumNetPayableAmount.add(reportPayOut.getNetPayableAmount()!=null?reportPayOut.getNetPayableAmount():BigDecimal.ZERO);
			row.createCell(40).setCellValue(convertBigdecimalToDouble(reportPayOut.getNetPayableAmount()));
		}
		
		headerCellStyle.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
		Row row = sheet.createRow(rowNum);
		for(int i=0;i<5;i++) {
			Cell cell11 = row.createCell(i);
			cell11.setCellStyle(headerCellStyle1);
		}
		Cell cell0 = row.createCell(5);
		cell0.setCellValue("Grand Total");
		cell0.setCellStyle(headerCellStyle1);

		Cell cell = row.createCell(6);
		cell.setCellValue(convertBigdecimalToDouble(sumBasic));
		cell.setCellStyle(headerCellStyle1);

		Cell cell1 = row.createCell(7);
		cell1.setCellValue(convertBigdecimalToDouble(sumDearnessAllowance));
		cell1.setCellStyle(headerCellStyle1);

		Cell cell2 = row.createCell(8);
		cell2.setCellValue(convertBigdecimalToDouble(sumConveyanceAllowance));
		cell2.setCellStyle(headerCellStyle1);

		Cell cell3 = row.createCell(9);
		cell3.setCellValue(convertBigdecimalToDouble(sumHra));
		cell3.setCellStyle(headerCellStyle1);

		Cell cell4 = row.createCell(10);
		cell4.setCellValue(convertBigdecimalToDouble(sumMedicalAllowance));
		cell4.setCellStyle(headerCellStyle1);

		Cell cell5 = row.createCell(11);
		cell5.setCellValue(convertBigdecimalToDouble(sumAdvanceBonus));
		cell5.setCellStyle(headerCellStyle1);

		Cell cell6 = row.createCell(12);
		cell6.setCellValue(convertBigdecimalToDouble(sumSpecialAllowance));
		cell6.setCellStyle(headerCellStyle1);

		Cell cell8 = row.createCell(13);
		cell8.setCellValue(convertBigdecimalToDouble(sumCompanyBenefits));
		cell8.setCellStyle(headerCellStyle1);

		Cell cell9 = row.createCell(14);
		cell9.setCellValue(convertBigdecimalToDouble(sumOtherAllowance));
		cell9.setCellStyle(headerCellStyle1);

		Cell cell10 = row.createCell(15);
		cell10.setCellValue(convertBigdecimalToDouble(sumGrossSalary));
		cell10.setCellStyle(headerCellStyle1);

		Cell cell11 = row.createCell(16);
		cell11.setCellValue(convertBigdecimalToDouble(sumAbsense));
		cell11.setCellStyle(headerCellStyle1);

		Cell cell12 = row.createCell(17);
		cell12.setCellValue(convertBigdecimalToDouble(sumCasualleave));
		cell12.setCellStyle(headerCellStyle1);

		Cell cell13 = row.createCell(18);
		cell13.setCellValue(convertBigdecimalToDouble(sumSeekleave));
		cell13.setCellStyle(headerCellStyle1);

		Cell cell14 = row.createCell(19);
		cell14.setCellValue(convertBigdecimalToDouble(sumPaidleave));
		cell14.setCellStyle(headerCellStyle1);

		Cell cell15 = row.createCell(20);
		cell15.setCellValue(convertBigdecimalToDouble(sumPresense));
		cell15.setCellStyle(headerCellStyle1);

		Cell cell16 = row.createCell(21);
		cell16.setCellValue(convertBigdecimalToDouble(sumPublicholidays));
		cell16.setCellStyle(headerCellStyle1);

		Cell cell17 = row.createCell(22);
		cell17.setCellValue(convertBigdecimalToDouble(sumWeekoff));
		cell17.setCellStyle(headerCellStyle1);

		/*Cell cell18 = row.createCell(23);
		cell18.setCellValue(convertBigdecimalToDouble(sumOvertime));
		cell18.setCellStyle(headerCellStyle1);
*/
		Cell cell19 = row.createCell(23);
		cell19.setCellValue(convertBigdecimalToDouble(totalPayDays));
		cell19.setCellStyle(headerCellStyle1);

		Cell cell20 = row.createCell(24);
		cell20.setCellValue(convertBigdecimalToDouble(sumBasicEarning));
		cell20.setCellStyle(headerCellStyle1);

		Cell cell21 = row.createCell(25);
		cell21.setCellValue(convertBigdecimalToDouble(sumDearnessAllowanceEarning));
		cell21.setCellStyle(headerCellStyle1);

		Cell cell22 = row.createCell(26);
		cell22.setCellValue(convertBigdecimalToDouble(sumConveyanceAllowanceEarning));
		cell22.setCellStyle(headerCellStyle1);

		Cell cell23 = row.createCell(27);
		cell23.setCellValue(convertBigdecimalToDouble(sumHraEarning));
		cell23.setCellStyle(headerCellStyle1);

		Cell cell24 = row.createCell(28);
		cell24.setCellValue(convertBigdecimalToDouble(sumMedicalAllowanceEarning));
		cell24.setCellStyle(headerCellStyle1);

		Cell cell25 = row.createCell(29);
		cell25.setCellValue(convertBigdecimalToDouble(sumAdvanceBonusEarning));
		cell25.setCellStyle(headerCellStyle1);

		Cell cell26 = row.createCell(30);
		cell26.setCellValue(convertBigdecimalToDouble(sumSpecialAllowanceEarning));
		cell26.setCellStyle(headerCellStyle1);

		Cell cell27 = row.createCell(31);
		cell27.setCellValue(convertBigdecimalToDouble(totalCompanyBenefitsEarning));
		cell27.setCellStyle(headerCellStyle1);

		Cell cell28 = row.createCell(32);
		cell28.setCellValue(convertBigdecimalToDouble(sumOtherAllowanceEarning));
		cell28.setCellStyle(headerCellStyle1);

		Cell cell29 = row.createCell(33);
		cell29.setCellValue(convertBigdecimalToDouble(sumTotalEarning));
		cell29.setCellStyle(headerCellStyle1);

		Cell cell30 = row.createCell(34);
		cell30.setCellValue(convertBigdecimalToDouble(sumLoan));
		cell30.setCellStyle(headerCellStyle1);

		Cell cell31 = row.createCell(35);
		cell31.setCellValue(convertBigdecimalToDouble(sumProvidentFundEmployee));
		cell31.setCellStyle(headerCellStyle1);

		Cell cell32 = row.createCell(36);
		cell32.setCellValue(convertBigdecimalToDouble(sumEsi_Employee));
		cell32.setCellStyle(headerCellStyle1);

		Cell cell33 = row.createCell(37);
		cell33.setCellValue(convertBigdecimalToDouble(sumPt));
		cell33.setCellStyle(headerCellStyle1);
		
		Cell cell34 = row.createCell(38);
		cell34.setCellValue(convertBigdecimalToDouble(sumTds));
		cell34.setCellStyle(headerCellStyle1);

		Cell cell35 = row.createCell(39);
		cell35.setCellValue(convertBigdecimalToDouble(sumTotalDeduction));
		cell35.setCellStyle(headerCellStyle1);

		Cell cell36 = row.createCell(40);
		cell36.setCellValue(convertBigdecimalToDouble(sumNetPayableAmount));
		cell36.setCellStyle(headerCellStyle1);

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}}
		return workbook;
	}

	
	public static Workbook payrollEpfEcrReport(List<ReportPayOutDTO> reportPayOutList, String[] columns,
			String processMonth, Company company, String empCount, ReportSummaryDTO reportSummary)
			throws IOException, InvalidFormatException {

		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("EPF-ECR");

		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.FINE_DOTS);

		CellStyle headerCellStyle1 = workbook.createCellStyle();
		headerCellStyle1.setFont(headerFont);
		headerCellStyle1.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle1.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle1.setFillPattern(FillPatternType.FINE_DOTS);
		CellStyle headerCellStyle11 = workbook.createCellStyle();
		headerCellStyle11.setFont(headerFont);
		headerCellStyle11.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle11.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle headerCellStyle111 = workbook.createCellStyle();
		headerCellStyle111.setFont(headerFont);
		headerCellStyle111.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle111.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle headerCellStyle112 = workbook.createCellStyle();
		headerCellStyle112.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle112.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle cellStyle112 = workbook.createCellStyle();
		cellStyle112.setAlignment(HorizontalAlignment.RIGHT);
		cellStyle112.setVerticalAlignment(VerticalAlignment.CENTER);
		
		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 10));
		Cell cellCom = row0.createCell(0);
		cellCom.setCellValue(company.getCompanyName());
		cellCom.setCellStyle(headerCellStyle111);

		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 10));
		Cell cellAdd = row1.createCell(0);
		cellAdd.setCellValue(company.getAddress1().getState().getStateName() + " , "
				+ company.getAddress1().getCity().getCityName() + "- " + company.getAddress1().getPincode());
		cellAdd.setCellStyle(headerCellStyle111);

		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 10));
		row2.createCell(0).setCellValue("PF Code -" + company.getEpfNo());
		// row1.createCell(1).setCellValue(company.getEpfNo());

		Row row3 = sheet.createRow(3);
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 3));
		row3.createCell(0).setCellValue("Total Number of Employees ");
		sheet.addMergedRegion(new CellRangeAddress(3, 3, 4, 10));
		row3.createCell(4).setCellValue(empCount);
		Row row4 = sheet.createRow(4);
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 3));
		row4.createCell(0).setCellValue("Total Number of Excluded Employees");
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 4, 10));
		Cell cellemp = row4.createCell(4);
		cellemp.setCellValue(reportSummary.getEpfExcludedEmpCount().doubleValue());
		cellemp.setCellStyle(headerCellStyle112);
		Row row5 = sheet.createRow(5);
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 3));
		row5.createCell(0).setCellValue("Gross Wages of Excluded Employees ");
		sheet.addMergedRegion(new CellRangeAddress(5, 5, 4, 10));
		Cell cellSum = row5.createCell(4);
		cellSum.setCellValue(convertBigdecimalToDouble(reportSummary.getEpfExcludedGrassSum()));
		cellSum.setCellStyle(headerCellStyle112);
		Row row6 = sheet.createRow(6);
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 0, 3));

		row6.createCell(0).setCellValue("Month -"+processMonth);
		sheet.addMergedRegion(new CellRangeAddress(6, 6, 4, 10));
		row6.createCell(4).setCellValue("");

		Row headerRow = sheet.createRow(7);
		// Creating cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);

		}

		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		int rowNum = 8;

		if (reportPayOutList != null) {

			for (ReportPayOutDTO reportPayOut : reportPayOutList) {

				Row row = sheet.createRow(rowNum++);

				if (reportPayOut.getUnNo() != null && reportPayOut.getUnNo().trim() != "")
					row.createCell(0).setCellValue(reportPayOut.getUnNo());
				else
					row.createCell(0).setCellValue("Under Process");

				row.createCell(1).setCellValue(reportPayOut.getName());
				Cell celltotalearning = row.createCell(2);
				celltotalearning.setCellValue(convertBigdecimalToString(reportPayOut.getTotalEarning()));
				celltotalearning.setCellStyle(cellStyle112);
				String str = FormateUtil.ExcelDataPattern(convertBigdecimalToString(reportPayOut.getBasicEarning()));
				
				CellStyle cellStyle = workbook.createCellStyle();
				cellStyle.setDataFormat(workbook.getCreationHelper().createDataFormat().getFormat(str));
				Cell cellEarning = row.createCell(3);
				cellEarning.setCellValue(convertBigdecimalToString(((reportPayOut.getBasicEarning()!=null)?reportPayOut.getBasicEarning():BigDecimal.ZERO).add((reportPayOut.getDearnessAllowance()!=null)?reportPayOut.getDearnessAllowance():BigDecimal.ZERO)));
				cellEarning.setCellStyle(cellStyle112);
				Cell cellpension =row.createCell(4);
				cellpension.setCellValue(convertBigdecimalToString(reportPayOut.getPensionEarningSalary()));
				cellpension.setCellStyle(cellStyle112);
				Cell cellpensionearning =row.createCell(5);
				cellpensionearning.setCellValue(convertBigdecimalToString(reportPayOut.getPensionEarningSalary()));
				cellpensionearning.setCellStyle(cellStyle112);
				Cell cellProvidentFund =row.createCell(6);
				cellProvidentFund.setCellValue(convertBigdecimalToString(reportPayOut.getProvidentFundEmployee()));
				cellProvidentFund.setCellStyle(cellStyle112);
				Cell cellProvident =row.createCell(7);
				cellProvident.setCellValue(convertBigdecimalToString(reportPayOut.getProvidentFundEmployer()));
				cellProvident.setCellStyle(cellStyle112);
				Cell cellProfund =row.createCell(8);
				cellProfund	.setCellValue(convertBigdecimalToString(reportPayOut.getProvidentFundEmployerPension()));
				cellProfund.setCellStyle(cellStyle112);
				row.createCell(9).setCellValue(convertBigdecimalToDouble(reportPayOut.getAbsense()));
				row.createCell(10).setCellValue(0.00);

			}

		}

		headerCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		/*
		 * // Write the output to a file FileOutputStream fileOut = new
		 * FileOutputStream("E:\\poi-epf.xlsx"); workbook.write(fileOut);
		 * fileOut.close();
		 */
		return workbook;
	}

	
	public static Workbook payrollEsicEcrReport(List<ReportPayOutDTO> reportPayOutList, String[] columns, String processMonth,
			Company company,String empCount, ReportSummaryDTO reportSummary) throws IOException, InvalidFormatException {

	
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("ESI-ECR");

		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.FINE_DOTS);
		
		CellStyle headerCellStyle1 = workbook.createCellStyle();
		headerCellStyle1.setFont(headerFont);
		headerCellStyle1.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle1.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle1.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headerCellStyle1.setFillPattern(FillPatternType.FINE_DOTS);
		CellStyle headerCellStyle11 = workbook.createCellStyle();
		headerCellStyle11.setFont(headerFont);
		headerCellStyle11.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle11.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle headerCellStyle111 = workbook.createCellStyle();
		headerCellStyle111.setFont(headerFont);
		headerCellStyle111.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle111.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle headerCellStyle112 = workbook.createCellStyle();
		headerCellStyle112.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle112.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle cellStyle112 = workbook.createCellStyle();
		cellStyle112.setAlignment(HorizontalAlignment.RIGHT);
		cellStyle112.setVerticalAlignment(VerticalAlignment.CENTER);
		
		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
	    Cell	cellCom=row0.createCell(0);
		cellCom.setCellValue(company.getCompanyName());
		cellCom.setCellStyle(headerCellStyle111);
		

		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,5));
		  Cell	cellAdd=row1.createCell(0);
		  cellAdd.setCellValue(company.getAddress1().getState().getStateName() +" , "+company.getAddress1().getCity().getCityName() +"- "+company.getAddress1().getPincode());
		  cellAdd.setCellStyle(headerCellStyle111);
		
		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2,2,0,5));
		row2.createCell(0).setCellValue("ESIC Code - " +company.getEsicNo());
		//row1.createCell(1).setCellValue(company.getEpfNo());

		Row row3 = sheet.createRow(3);
		sheet.addMergedRegion(new CellRangeAddress(3,3,0,2));
		row3.createCell(0).setCellValue("Total Number of Employees " );
		sheet.addMergedRegion(new CellRangeAddress(3,3,3,5));
		row3.createCell(3).setCellValue(empCount );
		Row row4 = sheet.createRow(4);
		sheet.addMergedRegion(new CellRangeAddress(4,4,0,2));
		row4.createCell(0).setCellValue("Total Number of Excluded Employees" );
		sheet.addMergedRegion(new CellRangeAddress(4,4,3,5));
	Cell cellemp=	row4.createCell(3);
	cellemp .setCellValue(reportSummary.getEpfExcludedEmpCount().doubleValue());
	cellemp.setCellStyle(headerCellStyle112);
		Row row5 = sheet.createRow(5);
		sheet.addMergedRegion(new CellRangeAddress(5,5,0,2));
		row5.createCell(0).setCellValue("Gross Wages of Excluded Employees ");
		sheet.addMergedRegion(new CellRangeAddress(5,5,3,5));
		Cell cellSum=row5.createCell(3);
		cellSum.setCellValue(convertBigdecimalToDouble(reportSummary.getEpfExcludedGrassSum()));
		cellSum.setCellStyle(headerCellStyle112);
		Row row6 = sheet.createRow(6);
		sheet.addMergedRegion(new CellRangeAddress(6,6,0,2));

		row6.createCell(0).setCellValue("Month -"+processMonth);
		sheet.addMergedRegion(new CellRangeAddress(6,6,3,5));
		row6.createCell(3).setCellValue("");
		
int j=1;
		Row headerRow = sheet.createRow(7);
		// Creating cells
		for (int i = 0 ; i < columns.length; i++) {
			
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);

		}
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		int rowNum = 8;
		
	
		if (reportPayOutList != null) {

			for (ReportPayOutDTO reportPayOut : reportPayOutList) {
				
				Row row = sheet.createRow(rowNum++);
				
				if(reportPayOut.getEsiNo()!=null && reportPayOut.getEsiNo().trim()!="")
				row.createCell(0).setCellValue(reportPayOut.getEsiNo());
				else
					row.createCell(0).setCellValue("Under Process");
			
				row.createCell(1).setCellValue(reportPayOut.getName());
				row.createCell(2).setCellValue(convertBigdecimalToDouble(reportPayOut.getPayDays()));
				Cell cellTotal =row.createCell(3);
				cellTotal.setCellValue(convertBigdecimalToDouble(reportPayOut.getTotalEarning()));
				cellTotal.setCellStyle(cellStyle112);
				row.createCell(4).setCellValue("");
				row.createCell(5).setCellValue("");
				
			}
				
		}
		
		headerCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
	
	
		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		/*
		 * // Write the output to a file FileOutputStream fileOut = new
		 * FileOutputStream("E:\\poi-epf.xlsx"); workbook.write(fileOut);
		 * fileOut.close();
		 */
		return workbook;
	}

}

