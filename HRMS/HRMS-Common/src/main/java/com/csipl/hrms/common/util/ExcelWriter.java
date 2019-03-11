package com.csipl.hrms.common.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;


import com.csipl.hrms.dto.payrollprocess.ReportPayOutDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payroll.Epf;
import com.csipl.hrms.model.payroll.Esi;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;

import com.itextpdf.text.log.SysoCounter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExcelWriter {

	private static double convertBigdecimalToDouble(BigDecimal bigDecimalValue) {
		double doubleValue;

		if (bigDecimalValue != null)
			doubleValue = bigDecimalValue.doubleValue();
		else
			doubleValue = 0.0;
		return doubleValue;
	}
	
	
	private static Department getDesignationId(Map<Long, Department> designationMap, Long designationId) {

		return designationMap.get(designationId);
	}
	

	public static Workbook esiReport(List<ReportPayOutDTO> reportPayOutList, String[] columns, String processMonth,
			Company company, Esi esi) throws IOException, InvalidFormatException {
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances for various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("ESI");

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
		headerCellStyle11.setAlignment(HorizontalAlignment.RIGHT);
		headerCellStyle11.setVerticalAlignment(VerticalAlignment.CENTER);
		CellStyle headerCellStyle111 = workbook.createCellStyle();
		headerCellStyle111.setFont(headerFont);
		headerCellStyle111.setAlignment(HorizontalAlignment.LEFT);
		headerCellStyle111.setVerticalAlignment(VerticalAlignment.CENTER);
		// Create Other rows and cells with employees data
		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,2));
	    Cell	cellCom=row0.createCell(0);
		cellCom.setCellValue(company.getCompanyName());
		cellCom.setCellStyle(headerCellStyle111);
		
		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,2));
		row1.createCell(0).setCellValue("ESIC CODE NO-" +company.getEsicNo());
	
		// sheet.addMergedRegion(new CellRangeAddress(0,1,1,2));

		
	//	String monthAcronym=processMonth.substring(0, 3);
		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2,2,0,2));
		row2.createCell(0).setCellValue("SALARY SHEET FOR MONTH OF -"+ processMonth);
	
		// Create a Row
		Row headerRow = sheet.createRow(3);

		// Creating cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);

		}

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		BigDecimal sumEarning = new BigDecimal(0);

		int rowNum = 4;
		int srNo = 1;
		BigDecimal sumGrossSalary = new BigDecimal(0);
		BigDecimal sumESI = new BigDecimal(0);
		for (ReportPayOutDTO reportPayOut : reportPayOutList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(srNo++);
			row.createCell(1).setCellValue(reportPayOut.getEmployeeCode());

			if(reportPayOut.getEsiNo()!=null ||reportPayOut.getEsiNo()=="")
			row.createCell(2).setCellValue(reportPayOut.getEsiNo());
			else
			row.createCell(2).setCellValue("Under Process");
			row.createCell(3).setCellValue(reportPayOut.getName());
			row.createCell(4).setCellValue(reportPayOut.getFatherName());
			row.createCell(5).setCellValue(reportPayOut.getNominee());
			row.createCell(6).setCellValue(reportPayOut.getNomineeRelation());

			Cell dateOfBirthCell = row.createCell(7);
			dateOfBirthCell.setCellValue(reportPayOut.getDOB());
			dateOfBirthCell.setCellStyle(dateCellStyle);

			row.createCell(8).setCellValue(reportPayOut.getGender());

			Cell dateOfJoiningCell = row.createCell(9);
			dateOfJoiningCell.setCellValue(reportPayOut.getEpfJoining());
			dateOfJoiningCell.setCellStyle(dateCellStyle);

			row.createCell(10).setCellValue(convertBigdecimalToDouble(reportPayOut.getPresense()));
			sumGrossSalary = sumGrossSalary.add((reportPayOut.getGrossSalary()!=null)?reportPayOut.getGrossSalary():BigDecimal.ZERO);

			row.createCell(11).setCellValue(convertBigdecimalToDouble(reportPayOut.getGrossSalary()));
			sumEarning = sumEarning.add((reportPayOut.getTotalEarning()!=null)?reportPayOut.getTotalEarning():BigDecimal.ZERO);
			row.createCell(12).setCellValue(convertBigdecimalToDouble(reportPayOut.getTotalEarning()));
			sumESI = sumESI.add((reportPayOut.getEsi_Employee()!=null)?reportPayOut.getEsi_Employee():BigDecimal.ZERO);
			row.createCell(13).setCellValue(convertBigdecimalToDouble(reportPayOut.getEsi_Employee()));

		}
		headerCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
		Row row = sheet.createRow(rowNum);
for(int i=0;i<11;i++ ) {
	Cell cell11 = row.createCell(i);
	cell11.setCellStyle(headerCellStyle1);

}
		Cell cell = row.createCell(11);
		cell.setCellValue(convertBigdecimalToDouble(sumGrossSalary));
		cell.setCellStyle(headerCellStyle1);

		Cell cell1 = row.createCell(12);
		cell1.setCellValue(convertBigdecimalToDouble(sumEarning));
		cell1.setCellStyle(headerCellStyle1);

		Cell cell2 = row.createCell(13);
		cell2.setCellValue(convertBigdecimalToDouble(sumESI));
		cell2.setCellStyle(headerCellStyle1);

		Row rowNew = sheet.createRow(rowNum + 1);
		sheet.addMergedRegion(new CellRangeAddress(rowNum + 1, rowNum + 1, 8, 11));
		Cell cell3 = rowNew.createCell(8);

		cell3.setCellValue("EMPLOYER CONT " + esi.getEmployerPer() + "@");
		cell3.setCellStyle(headerCellStyle11);

		BigDecimal emoPer = (sumEarning.multiply(esi.getEmployerPer())).divide(new BigDecimal(100));
		Cell cell4 = rowNew.createCell(13);

		cell4.setCellValue(convertBigdecimalToDouble(emoPer));
		cell4.setCellStyle(headerCellStyle11);

		Row rowNew1 = sheet.createRow(rowNum + 2);
		sheet.addMergedRegion(new CellRangeAddress(rowNum + 2, rowNum + 2, 8, 11));
		Cell cell5 = rowNew1.createCell(8);

		cell5.setCellValue("TOTAL AMOUNT");
		cell5.setCellStyle(headerCellStyle11);

		Cell cell6 = rowNew1.createCell(13);
		cell6.setCellValue(convertBigdecimalToDouble(sumESI.add(emoPer)));
		cell6.setCellStyle(headerCellStyle11);

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		/*
		 * // Write the output to a file FileOutputStream fileOut = new
		 * FileOutputStream("E:\\poi-generated-file.xlsx"); workbook.write(fileOut);
		 * fileOut.close();
		 */
		return workbook;
	}

	public static Workbook payoutReport(List<ReportPayOut> reportPayOutList, String[] columns, String processMonth,
			String departmentName) throws IOException, InvalidFormatException {

		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("Payroll Report");

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

		CellStyle rowCellStyle = workbook.createCellStyle();
		rowCellStyle.setFont(rowFont);

		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		Row row = sheet.createRow(0);

		Cell paySheet = row.createCell(0);
		paySheet.setCellValue("Pay Sheet");
		paySheet.setCellStyle(rowCellStyle);
		Cell dept = row.createCell(2);
		dept.setCellValue("Department:");
		dept.setCellStyle(rowCellStyle);
		Cell paySheet1 = row.createCell(3);
		if (departmentName != null)
			paySheet1.setCellValue(departmentName);
		else
			paySheet1.setCellValue("All Department");

		Row row1 = sheet.createRow(1);
		String month = processMonth.substring(0, 3);
		int year = Integer.valueOf( processMonth.substring(4, 8));
		
		row1.createCell(0).setCellValue(DateUtils.createDate("01-"+processMonth,month,year));

		//row1.createCell(0).setCellValue(processMonth);
	
		Row headerRow = sheet.createRow(2);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		int rowNum = 3;
		for (ReportPayOut reportPayOut : reportPayOutList) {
			Row row2 = sheet.createRow(rowNum++);

			row2.createCell(0).setCellValue(reportPayOut.getName());
			row2.createCell(1).setCellValue(reportPayOut.getEmployeeCode());
			row2.createCell(2).setCellValue(reportPayOut.getBankName());
			row2.createCell(3).setCellValue(reportPayOut.getAccountNumber());

			Cell dateOfJoining = row2.createCell(4);
			dateOfJoining.setCellValue(reportPayOut.getDateOfJoining());
			dateOfJoining.setCellStyle(dateCellStyle);

			row2.createCell(5).setCellValue(convertBigdecimalToDouble(reportPayOut.getBasic()));
			row2.createCell(6).setCellValue(convertBigdecimalToDouble(reportPayOut.getDearnessAllowance()));
			row2.createCell(7).setCellValue(convertBigdecimalToDouble(reportPayOut.getConveyanceAllowance()));
			row2.createCell(8).setCellValue(convertBigdecimalToDouble(reportPayOut.getHra()));
			row2.createCell(9).setCellValue(convertBigdecimalToDouble(reportPayOut.getMedicalAllowance()));
			row2.createCell(10).setCellValue(convertBigdecimalToDouble(reportPayOut.getAdvanceBonus()));
			row2.createCell(11).setCellValue(convertBigdecimalToDouble(reportPayOut.getSpecialAllowance()));
			row2.createCell(12).setCellValue(convertBigdecimalToDouble(reportPayOut.getCompanyBenefits()));
			row2.createCell(13).setCellValue(convertBigdecimalToDouble(reportPayOut.getOtherAllowance()));
			row2.createCell(14).setCellValue(convertBigdecimalToDouble(reportPayOut.getGrossSalary()));
			row2.createCell(15).setCellValue(convertBigdecimalToDouble(reportPayOut.getAbsense()));
			row2.createCell(16).setCellValue(convertBigdecimalToDouble(reportPayOut.getCasualleave()));
			row2.createCell(17).setCellValue(convertBigdecimalToDouble(reportPayOut.getSeekleave()));
			row2.createCell(18).setCellValue(convertBigdecimalToDouble(reportPayOut.getPaidleave()));
			row2.createCell(19).setCellValue(convertBigdecimalToDouble(reportPayOut.getPresense()));
			row2.createCell(20).setCellValue(convertBigdecimalToDouble(reportPayOut.getPublicholidays()));
			row2.createCell(21).setCellValue(convertBigdecimalToDouble(reportPayOut.getWeekoff()));
			//row2.createCell(22).setCellValue(convertBigdecimalToDouble(reportPayOut.getOvertime()));
			row2.createCell(22).setCellValue(convertBigdecimalToDouble(reportPayOut.getPayDays()));
			row2.createCell(23).setCellValue(convertBigdecimalToDouble(reportPayOut.getBasicEarning()));
			row2.createCell(24).setCellValue(convertBigdecimalToDouble(reportPayOut.getDearnessAllowanceEarning()));
			row2.createCell(25).setCellValue(convertBigdecimalToDouble(reportPayOut.getConveyanceAllowanceEarning()));
			row2.createCell(26).setCellValue(convertBigdecimalToDouble(reportPayOut.getHRAEarning()));
			row2.createCell(27).setCellValue(convertBigdecimalToDouble(reportPayOut.getMedicalAllowanceEarning()));
			row2.createCell(28).setCellValue(convertBigdecimalToDouble(reportPayOut.getAdvanceBonusEarning()));
			row2.createCell(29).setCellValue(convertBigdecimalToDouble(reportPayOut.getSpecialAllowanceEarning()));
			row2.createCell(30).setCellValue(convertBigdecimalToDouble(reportPayOut.getCompanyBenefitsEarning()));
			row2.createCell(31).setCellValue(convertBigdecimalToDouble(reportPayOut.getOtherAllowanceEarning()));
			row2.createCell(32).setCellValue(convertBigdecimalToDouble(reportPayOut.getTotalEarning()));
			row2.createCell(33).setCellValue(convertBigdecimalToDouble(reportPayOut.getLoan()));
			row2.createCell(34).setCellValue(convertBigdecimalToDouble(reportPayOut.getOtherDeduction()));
 			row2.createCell(35).setCellValue(convertBigdecimalToDouble(reportPayOut.getProvidentFundEmployee()));
			row2.createCell(36).setCellValue(convertBigdecimalToDouble(reportPayOut.getESI_Employee()));
			row2.createCell(37).setCellValue(convertBigdecimalToDouble(reportPayOut.getPt()));
			row2.createCell(38).setCellValue(convertBigdecimalToDouble(reportPayOut.getTds()));
			row2.createCell(39).setCellValue(convertBigdecimalToDouble(reportPayOut.getTotalDeduction()));
			row2.createCell(40).setCellValue(convertBigdecimalToDouble(reportPayOut.getNetPayableAmount()));
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		return workbook;
	}

	public static Workbook trfReport(List<ReportPayOut> reportPayOutList, String[] columns,String processMonth,
			String departmentName, Map<Long, Department> hashMapReport)
			throws IOException, InvalidFormatException {

		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("TRF Report");

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

		CellStyle rowCellStyle = workbook.createCellStyle();
		rowCellStyle.setFont(rowFont);

		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));

		Row row = sheet.createRow(0);
		Cell paySheet = row.createCell(0);
		paySheet.setCellValue("TRF Sheet");
		paySheet.setCellStyle(rowCellStyle);
		sheet.addMergedRegion(new CellRangeAddress(0,0,2,3));
		Cell dept = row.createCell(2);
		Cell paySheet1 = row.createCell(2);
		if (departmentName != null)
			paySheet1.setCellValue("Department:"+departmentName);
		else
			paySheet1.setCellValue("Department:"+"All ");
		dept.setCellStyle(rowCellStyle);
		
		
		Row headerRow = sheet.createRow(1);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);
		}

		int rowNum = 2;
		for (ReportPayOut reportPayOut : reportPayOutList) {
			Row row1 = sheet.createRow(rowNum++);

			row1.createCell(0).setCellValue(reportPayOut.getName());
			row1.createCell(1).setCellValue(reportPayOut.getEmployeeCode());
			row1.createCell(2).setCellValue(reportPayOut.getBankName());
			row1.createCell(3).setCellValue(reportPayOut.getAccountNumber());
			row1.createCell(4).setCellValue(convertBigdecimalToDouble(reportPayOut.getNetPayableAmount()));
			row1.createCell(5).setCellValue(processMonth);
		    Department department = getDesignationId(hashMapReport, reportPayOut.getDepartmentId());
			row1.createCell(6).setCellValue(department.getDepartmentName());
		}

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}

		return workbook;
	}

	public static Workbook epfReport(List<ReportPayOutDTO> reportPayOutList, String[] columns, String processMonth,
			Company company, Epf epf) throws IOException, InvalidFormatException {

	
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		CreationHelper createHelper = workbook.getCreationHelper();

		Sheet sheet = workbook.createSheet("EPF");

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
		Row row0 = sheet.createRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,1));
	   Cell	cellCom=row0.createCell(0);
		cellCom.setCellValue(company.getCompanyName());
		cellCom.setCellStyle(headerCellStyle11);
		
		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,1));
		row1.createCell(0).setCellValue("EPF CODE -" +company.getEpfNo());
		//row1.createCell(1).setCellValue(company.getEpfNo());

		
	//	String monthAcronym=processMonth.substring(0, 3);
		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2,2,0,2));

		row2.createCell(0).setCellValue("SALARY SHEET FOR MONTH OF -"+processMonth);

		Row row3 = sheet.createRow(3);
		row3.createCell(0);

		Row headerRow = sheet.createRow(4);
		// Creating cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headerCellStyle);

		}
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		int rowNum = 5;
		int srNo = 1;
		BigDecimal totalAmount = new BigDecimal(0);
		BigDecimal sumGrossSalary = new BigDecimal(0);
		BigDecimal sumPfBasic = new BigDecimal(0);
		BigDecimal sumAllowance = new BigDecimal(0);
		BigDecimal sumEarnGrossSalary = new BigDecimal(0);
		BigDecimal sumEarnBasic = new BigDecimal(0);
		BigDecimal sumPensionSalary = new BigDecimal(0);
		BigDecimal sumEarnAllowance = new BigDecimal(0);
		BigDecimal sumDeduction = new BigDecimal(0);
		
		if (reportPayOutList != null) {

			for (ReportPayOutDTO reportPayOut : reportPayOutList) {
				
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(srNo++);
				row.createCell(1).setCellValue(reportPayOut.getEmployeeCode());
				if(reportPayOut.getUnNo()!=null)
				row.createCell(2).setCellValue(reportPayOut.getUnNo());
				else
					row.createCell(2).setCellValue("Under Process");
				/*if(reportPayOut.getPFNumber()!=null)
				row.createCell(2).setCellValue(reportPayOut.getPFNumber());
				else
					row.createCell(2).setCellValue("Under Process");*/
				row.createCell(3).setCellValue(reportPayOut.getName());
				row.createCell(4).setCellValue(reportPayOut.getFatherName());
				row.createCell(5).setCellValue(reportPayOut.getNominee());
				row.createCell(6).setCellValue(reportPayOut.getNomineeRelation());
				Cell dateOfBirthCell = row.createCell(7);
				dateOfBirthCell.setCellValue(reportPayOut.getDOB());
				dateOfBirthCell.setCellStyle(dateCellStyle);

				row.createCell(8).setCellValue(reportPayOut.getGender());

				Cell epfJoiningCell = row.createCell(9);
				epfJoiningCell.setCellValue(reportPayOut.getDateOfJoining());
				epfJoiningCell.setCellStyle(dateCellStyle);
				row.createCell(10).setCellValue(reportPayOut.getMaritalStatus());
				row.createCell(11).setCellValue(reportPayOut.getAccountNumber());
				row.createCell(12).setCellValue(reportPayOut.getIfscCode());
				row.createCell(13).setCellValue(reportPayOut.getAadharNo());
				row.createCell(14).setCellValue(reportPayOut.getPanNo());
				row.createCell(15).setCellValue(reportPayOut.getMobNo());
				row.createCell(16).setCellValue(reportPayOut.getEmail());
				sumGrossSalary = sumGrossSalary.add((reportPayOut.getGrossSalary()!=null)?reportPayOut.getGrossSalary():BigDecimal.ZERO);
				row.createCell(17).setCellValue(convertBigdecimalToDouble(reportPayOut.getGrossSalary()));
				if(reportPayOut.getDearnessAllowance()!=null && reportPayOut.getBasic()!=null) {
				sumPfBasic = sumPfBasic.add(reportPayOut.getBasic().add(reportPayOut.getDearnessAllowance()));
				row.createCell(18).setCellValue(convertBigdecimalToDouble(reportPayOut.getBasic().add(reportPayOut.getDearnessAllowance())));
				}
				else
				{  
					sumPfBasic = sumPfBasic.add((reportPayOut.getBasic()!=null)?reportPayOut.getBasic():BigDecimal.ZERO);
					row.createCell(18).setCellValue(convertBigdecimalToDouble(reportPayOut.getBasic()));
				}	
				
				sumAllowance = sumAllowance
						.add(reportPayOut.getGrossSalary().subtract(((reportPayOut.getBasic()!=null)?reportPayOut.getBasic():BigDecimal.ZERO).add((reportPayOut.getDearnessAllowance()!=null)?reportPayOut.getDearnessAllowance():BigDecimal.ZERO)));
				row.createCell(19).setCellValue(convertBigdecimalToDouble(
						reportPayOut.getGrossSalary().subtract((reportPayOut.getProvidentFundEmployee()!=null)?reportPayOut.getProvidentFundEmployee():BigDecimal.ZERO)));

				row.createCell(20).setCellValue(convertBigdecimalToDouble(reportPayOut.getPresense()));
				row.createCell(21).setCellValue(convertBigdecimalToDouble(reportPayOut.getAbsense()));
				sumEarnGrossSalary = sumEarnGrossSalary.add((reportPayOut.getTotalEarning()!=null)?reportPayOut.getTotalEarning():BigDecimal.ZERO);
				row.createCell(22).setCellValue(convertBigdecimalToDouble(reportPayOut.getTotalEarning()));
				sumEarnBasic = sumEarnBasic.add(((reportPayOut.getBasicEarning()!=null)?reportPayOut.getBasicEarning():BigDecimal.ZERO).add((reportPayOut.getDearnessAllowance()!=null)?reportPayOut.getDearnessAllowance():BigDecimal.ZERO));
				row.createCell(23).setCellValue(convertBigdecimalToDouble(((reportPayOut.getBasicEarning()!=null)?reportPayOut.getBasicEarning():BigDecimal.ZERO).add((reportPayOut.getDearnessAllowance()!=null)?reportPayOut.getDearnessAllowance():BigDecimal.ZERO)));
				sumEarnAllowance = sumEarnAllowance
						.add(reportPayOut.getTotalEarning().subtract(reportPayOut.getBasicEarning()));
				row.createCell(24).setCellValue(convertBigdecimalToDouble(reportPayOut.getTotalEarning().subtract(reportPayOut.getBasicEarning())));
				sumPensionSalary = sumPensionSalary.add((reportPayOut.getPensionEarningSalary()!=null)?reportPayOut.getPensionEarningSalary():BigDecimal.ZERO);
				row.createCell(25).setCellValue(convertBigdecimalToDouble(reportPayOut.getPensionEarningSalary()));
				sumDeduction = sumDeduction.add((reportPayOut.getProvidentFundEmployee()!=null)?reportPayOut.getProvidentFundEmployee():BigDecimal.ZERO);
				row.createCell(26).setCellValue(convertBigdecimalToDouble(reportPayOut.getProvidentFundEmployee()));

			
				}
		}
		
		headerCellStyle.setVerticalAlignment(VerticalAlignment.JUSTIFY);
		Row row = sheet.createRow(rowNum);
        for(int i=0 ;i<17 ;i++) {
	    Cell cellblank = row.createCell(i);
	    cellblank.setCellStyle(headerCellStyle1);
        }
		Cell cell = row.createCell(17);
		cell.setCellValue(convertBigdecimalToDouble(sumGrossSalary));
		cell.setCellStyle(headerCellStyle1);

		Cell cell1 = row.createCell(18);
		cell1.setCellValue(convertBigdecimalToDouble(sumPfBasic));
		cell1.setCellStyle(headerCellStyle1);

		Cell cell2 = row.createCell(19);
		cell2.setCellValue(convertBigdecimalToDouble(sumAllowance));
		cell2.setCellStyle(headerCellStyle1);
		
		Cell cell11 = row.createCell(20);
		cell11.setCellStyle(headerCellStyle1);
		
		Cell cell111 = row.createCell(21);
		cell111.setCellStyle(headerCellStyle1);
		

		Cell cell3 = row.createCell(22);
		cell3.setCellValue(convertBigdecimalToDouble(sumEarnGrossSalary));
		cell3.setCellStyle(headerCellStyle1);

		Cell cell4 = row.createCell(23);
		cell4.setCellValue(convertBigdecimalToDouble(sumEarnBasic));
		cell4.setCellStyle(headerCellStyle1);

		Cell cell5 = row.createCell(24);
		cell5.setCellValue(convertBigdecimalToDouble(sumEarnAllowance));
		cell5.setCellStyle(headerCellStyle1);

		Cell cell6 = row.createCell(25);
		cell6.setCellValue(convertBigdecimalToDouble(sumPensionSalary));
		cell6.setCellStyle(headerCellStyle1);

		Cell cell7 = row.createCell(26);
		cell7.setCellValue(convertBigdecimalToDouble(sumDeduction));
		cell7.setCellStyle(headerCellStyle1);

		Row rowNew1 = sheet.createRow(rowNum + 2);
		sheet.addMergedRegion(new CellRangeAddress(rowNum + 2, rowNum + 2, 21, 24));
		Cell cell18 = rowNew1.createCell(21);
		cell18.setCellValue("EMPLOYER SHARE ");
		cell18.setCellStyle(headerCellStyle11);

		Cell cell19 = rowNew1.createCell(26);
		cell19.setCellValue(convertBigdecimalToDouble(sumDeduction));
		cell19.setCellStyle(headerCellStyle11);

		Row rowNew2 = sheet.createRow(rowNum + 3);
		sheet.addMergedRegion(new CellRangeAddress(rowNum + 3, rowNum + 3, 21, 24));
		Cell cell20 = rowNew2.createCell(21);
		cell20.setCellValue("ADM CHARGES " + epf.getAdminPer() + "% -:");
		cell20.setCellStyle(headerCellStyle11);

		Cell cell21 = rowNew2.createCell(26);
		BigDecimal epfAdm = (sumEarnBasic.multiply(epf.getAdminPer())).divide(new BigDecimal(100));
		BigDecimal fiveHundred = new BigDecimal(500);
		epfAdm = ((epfAdm).compareTo(fiveHundred) < 0) ? fiveHundred : epfAdm;
		cell21.setCellValue(convertBigdecimalToDouble(epfAdm));
		cell21.setCellStyle(headerCellStyle11);

		Row rowNew3 = sheet.createRow(rowNum + 4);
		sheet.addMergedRegion(new CellRangeAddress(rowNum + 4, rowNum + 4, 21, 24));
		Cell cell22 = rowNew3.createCell(21);
		cell22.setCellValue("EDLI CHARGES " + epf.getEdliPer() + "% -:");
		cell22.setCellStyle(headerCellStyle11);

		sheet.addMergedRegion(new CellRangeAddress(rowNum + 4, rowNum + 4, 6, 7));
		Cell cell23 = rowNew3.createCell(26);
		BigDecimal epfEDLI = (sumPensionSalary.multiply(epf.getEdliPer())).divide(new BigDecimal(100));
		cell23.setCellValue(convertBigdecimalToDouble(epfEDLI));
		cell23.setCellStyle(headerCellStyle11);

		Row rowNew4 = sheet.createRow(rowNum + 5);
		sheet.addMergedRegion(new CellRangeAddress(rowNum + 5, rowNum + 5, 21, 24));
		Cell cell24 = rowNew4.createCell(21);
		cell24.setCellValue("EDLI EXP CHARGES " + epf.getEdliExpPer() + "% -:");
		cell24.setCellStyle(headerCellStyle11);

		Cell cell25 = rowNew4.createCell(26);
		BigDecimal epfEDLIExp = (sumPensionSalary.multiply(epf.getEdliExpPer())).divide(new BigDecimal(100));

		BigDecimal twoHundred = new BigDecimal(200);

		epfEDLIExp = ((epfEDLIExp).compareTo(twoHundred) < 0) ? twoHundred : epfEDLIExp;
		cell25.setCellValue(convertBigdecimalToDouble(epfEDLIExp));
		cell25.setCellStyle(headerCellStyle11);

		Row rowNew5 = sheet.createRow(rowNum + 6);

		totalAmount = totalAmount.add(totalAmount);
		BigDecimal totalAmount2 = totalAmount.add(totalAmount);

		BigDecimal totalAmount3 = totalAmount2.add(sumDeduction);
		BigDecimal totalAmount4 = totalAmount3.add(epfAdm);
		BigDecimal totalAmount5 = totalAmount4.add(epfEDLI);
		BigDecimal totalAmount6 = totalAmount5.add(epfEDLIExp);

		sheet.addMergedRegion(new CellRangeAddress(rowNum + 6, rowNum + 6, 21, 24));
		Cell cell26 = rowNew5.createCell(21);
		cell26.setCellValue("TOTAL AMOUNT -:");

		cell26.setCellStyle(headerCellStyle11);

		Cell cell27 = rowNew5.createCell(26);

		cell27.setCellValue(convertBigdecimalToDouble(totalAmount6));
		cell27.setCellStyle(headerCellStyle11);

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