package com.csipl.tms.attendanceCalculation.controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.csipl.tms.dto.attendancelog.AttendanceLogDetailsDTO;

import java.io.IOException;
import java.util.List;

public class AttendanceReportExcelWriter {

	public static Workbook attendanceReport(List<AttendanceLogDetailsDTO> attendanceLogDetailsDtoList, String[] columns)
			throws IOException, InvalidFormatException {
		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances for various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
		Sheet sheet = workbook.createSheet("Attendance Report");

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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
		Cell cellCom = row0.createCell(0);
		cellCom.setCellValue("");
		cellCom.setCellStyle(headerCellStyle111);

		Row row1 = sheet.createRow(1);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 2));
		row1.createCell(0).setCellValue("Present-" + 20 + " Leave-	 " + 5 + " Absent- " + 400);

		// sheet.addMergedRegion(new CellRangeAddress(0,1,1,2));

		// String monthAcronym=processMonth.substring(0, 3);
		Row row2 = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 2));
		// row2.createCell(0).setCellValue("A" + "JAN");

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

		int rowNum = 4;
		int srNo = 1;

		for (AttendanceLogDetailsDTO attendanceLogDetailsDto : attendanceLogDetailsDtoList) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(srNo++);
			row.createCell(1).setCellValue(attendanceLogDetailsDto.getName());

			row.createCell(2).setCellValue(attendanceLogDetailsDto.getStatus());

			row.createCell(3).setCellValue(attendanceLogDetailsDto.getPunchRecord());
			row.createCell(4).setCellValue(attendanceLogDetailsDto.getLocation());
			row.createCell(5).setCellValue(attendanceLogDetailsDto.getMode());
			row.createCell(6).setCellValue(attendanceLogDetailsDto.getDelayedTime());

		}

		return workbook;
	}

}