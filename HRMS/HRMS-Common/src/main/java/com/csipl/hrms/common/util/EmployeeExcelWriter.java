package com.csipl.hrms.common.util;

import java.io.IOException;
import java.math.BigDecimal;
 import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.EmployeeStatuary;
import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.employee.PayStructureHd;

public class EmployeeExcelWriter {
	private static double convertBigdecimalToDouble(BigDecimal bigDecimalValue) {
		double doubleValue;

		if (bigDecimalValue != null)
			doubleValue = bigDecimalValue.doubleValue();
		else
			doubleValue = 0.0;
		return doubleValue;
	}

	public static Workbook employeeReport(String[] columns, List<Employee> employeeList, String status)
			throws IOException, InvalidFormatException {

		// Create a Workbook
		Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

		/*
		 * CreationHelper helps us create instances for various things like DataFormat,
		 * Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way
		 */
		CreationHelper createHelper = workbook.getCreationHelper();

		// Create a Sheet
	Sheet sheet = workbook.createSheet("Employee Report");

		// Create a Font for styling header cells
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeightInPoints((short) 12);
		headerFont.setColor(IndexedColors.BLACK.getIndex());

		// Create a CellStyle with the font
		// Create a CellStyle with the font
		CellStyle headCellStyle = workbook.createCellStyle();
		headCellStyle.setFont(headerFont);
		headCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headCellStyle.setFillBackgroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
		headCellStyle.setFillPattern(FillPatternType.FINE_DOTS);

		
		CellStyle headerCellStyle = workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		headerCellStyle.setAlignment(HorizontalAlignment.CENTER);
		headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		headerCellStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		headerCellStyle.setFillPattern(FillPatternType.FINE_DOTS);

		
		
		
		
		/*
		 * // Create Other rows and cells with employees data Row row0 =
		 * sheet.createRow(0); row0.createCell(0).setCellValue("  ");
		 * row0.createCell(1).setCellValue("Name of the EST:");
		 * row0.createCell(2).setCellValue("A");
		 * 
		 * Row row1 = sheet.createRow(1); row1.createCell(0).setCellValue("  ");
		 * row1.createCell(1).setCellValue("ESIC CODE NO-");
		 * row1.createCell(2).setCellValue("B"); // sheet.addMergedRegion(new
		 * CellRangeAddress(0,1,1,2));
		 * 
		 * 
		 * // String monthAcronym=processMonth.substring(0, 3); Row row2 =
		 * sheet.createRow(2); row2.createCell(0).setCellValue("  ");
		 * row2.createCell(1).setCellValue("SALARY SHEET FOR MONTH OF -");
		 * row2.createCell(2).setCellValue( "PM");
		 */
		// Create a Row

		// Create Cell Style for formatting Date
		CellStyle dateCellStyle = workbook.createCellStyle();
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
		Row row0 = sheet.createRow(0);

		/*
		 * sheet.addMergedRegion(new CellRangeAddress(0,0,0,0)); Cell cell0 =
		 * row0.createCell(0); //cell0.setCellValue("Employee Code");
		 * cell0.setCellStyle(headerCellStyle);
		 * 
		 * sheet.addMergedRegion(new CellRangeAddress(0,0,1,1)); Cell cell1 =
		 * row0.createCell(1); //cell1.setCellValue("FIRST Name");
		 * cell1.setCellStyle(headerCellStyle);
		 * 
		 * sheet.addMergedRegion(new CellRangeAddress(0,0,2,2)); Cell cell2 =
		 * row0.createCell(2); //cell2.setCellValue("Midel Name");
		 * cell2.setCellStyle(headerCellStyle);
		 * 
		 * sheet.addMergedRegion(new CellRangeAddress(0,0,3,3)); Cell cell3 =
		 * row0.createCell(3); //cell3.setCellValue("Last name");
		 * cell3.setCellStyle(headerCellStyle);
		 * 
		 * sheet.addMergedRegion(new CellRangeAddress(0,0,4,4)); Cell cell4 =
		 * row0.createCell(4); //cell4.setCellValue("DOB");
		 * cell4.setCellStyle(headerCellStyle);
		 * 
		 * sheet.addMergedRegion(new CellRangeAddress(0,0,5,5)); Cell cell5 =
		 * row0.createCell(5); //cell5.setCellValue("Gender");
		 * cell5.setCellStyle(headerCellStyle);
		 * 
		 * sheet.addMergedRegion(new CellRangeAddress(0,0,6,6)); Cell cell6 =
		 * row0.createCell(6); //cell6.setCellValue("DOJ");
		 * cell6.setCellStyle(headerCellStyle);
		 * 
		 * sheet.addMergedRegion(new CellRangeAddress(0,0,7,7)); Cell cell7 =
		 * row0.createCell(7); // cell7.setCellValue("Marital Status");
		 * cell7.setCellStyle(headerCellStyle);
		 */

		
		Row headerRow = sheet.createRow(1);

		// Creating cells
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(headCellStyle);

		}

		// Create Cell Style for formatting Date
		dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

		int rowNum = 2;
		if(status.equals("AC")) {
			
			
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
			Cell cell1 = row0.createCell(0);
			cell1.setCellValue("");
			cell1.setCellStyle(headCellStyle);

			
			
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 8, 16));
			Cell cell8 = row0.createCell(8);
			cell8.setCellValue("Present Address");
			cell8.setCellStyle(headerCellStyle);

			// Row row1 = sheet.createRow(1);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 17, 25));
			Cell cell9 = row0.createCell(17);
			cell9.setCellValue("Permanent Address");
			cell9.setCellStyle(headerCellStyle);

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 26, 34));
			Cell cell2 = row0.createCell(26);
			cell2.setCellValue("");
			cell2.setCellStyle(headCellStyle);
			
			
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 35, 36));
			Cell cell10 = row0.createCell(35);
			cell10.setCellValue("ID and Address Proof");
			cell10.setCellStyle(headerCellStyle);

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 37, 39));
			Cell cell11 = row0.createCell(37);
			cell11.setCellValue("Statutory Info.");
			cell11.setCellStyle(headerCellStyle);

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 40, 43));
			Cell cell12 = row0.createCell(40);
			cell12.setCellValue("Banking details");
			cell12.setCellStyle(headerCellStyle);

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 44, 55));
			Cell cell13 = row0.createCell(44);
			cell13.setCellValue("Payheads");
			cell13.setCellStyle(headerCellStyle);

			
			
			
		for (Employee employee : employeeList) {
			Row row = sheet.createRow(rowNum++);
			// row.createCell(0).setCellValue(srNo++);
			if (employee.getEmployeeCode() != null)
				row.createCell(0).setCellValue(employee.getEmployeeCode());
			row.createCell(1).setCellValue(employee.getFirstName());
			if (employee.getMiddleName() != null)
				row.createCell(2).setCellValue(employee.getMiddleName());
			row.createCell(3).setCellValue(employee.getLastName());
			Cell dateOfBirthCell = row.createCell(4);
			dateOfBirthCell.setCellValue(employee.getDateOfBirth());
			dateOfBirthCell.setCellStyle(dateCellStyle);
			row.createCell(5).setCellValue(employee.getGenderValue());
			Cell dateOfJoiningCell = row.createCell(6);

			dateOfJoiningCell.setCellValue(employee.getDateOfJoining());
			dateOfJoiningCell.setCellStyle(dateCellStyle);

			row.createCell(7).setCellValue(employee.getMaritalStatusValue());
			if (employee.getAddress1() != null) {
				row.createCell(8).setCellValue(employee.getAddress1().getAddressText());
				row.createCell(9).setCellValue(employee.getAddress1().getLandmark());
				if (employee.getAddress1().getCountry() != null)
					row.createCell(10).setCellValue(employee.getAddress1().getCountry().getCountryName());
				if (employee.getAddress1().getState() != null)
					row.createCell(11).setCellValue(employee.getAddress1().getState().getStateName());
				if (employee.getAddress1().getCity() != null)
					row.createCell(12).setCellValue(employee.getAddress1().getCity().getCityName());
				row.createCell(13).setCellValue(employee.getAddress1().getPincode());
				row.createCell(14).setCellValue(employee.getAddress1().getMobile());
				row.createCell(15).setCellValue(employee.getAddress1().getTelephone());
				row.createCell(16).setCellValue(employee.getAddress1().getEmailId());
			}

			if (employee.getAddress2() != null) {
				row.createCell(17).setCellValue(employee.getAddress2().getAddressText());
				row.createCell(18).setCellValue(employee.getAddress2().getLandmark());
				if (employee.getAddress2().getCountry() != null)
					row.createCell(19).setCellValue(employee.getAddress2().getCountry().getCountryName());
				if (employee.getAddress2().getState() != null)
					row.createCell(20).setCellValue(employee.getAddress2().getState().getStateName());
				if (employee.getAddress2().getCity() != null)
					row.createCell(21).setCellValue(employee.getAddress2().getCity().getCityName());
				row.createCell(22).setCellValue(employee.getAddress2().getPincode());
				row.createCell(23).setCellValue(employee.getAddress2().getMobile());
				row.createCell(24).setCellValue(employee.getAddress2().getTelephone());
				row.createCell(25).setCellValue(employee.getAddress2().getEmailId());
			}

			if (employee.getCity() != null)
				row.createCell(26).setCellValue(employee.getCity().getCityName());
			if (employee.getState() != null)
				row.createCell(27).setCellValue(employee.getState().getStateName());
			row.createCell(28).setCellValue(employee.getBloodGroupValue());
			if (employee.getProbationDays() != null)
				row.createCell(29).setCellValue(employee.getProbationDays());
			if (employee.getEmpType() != null)
				row.createCell(30).setCellValue(employee.getEmpTypeValue());
			if (employee.getDepartment() != null)
				row.createCell(31).setCellValue(employee.getDepartment().getDepartmentName());
			if (employee.getDesignation() != null)
				row.createCell(32).setCellValue(employee.getDesignation().getDesignationName());
			/*
			 * if (employeeDto.getContractOverDate() != null)
			 * row.createCell(24).setCellValue(employeeDto.getContractOverDate());
			 */
			Cell contractOverDateCell = row.createCell(33);
			contractOverDateCell.setCellValue(employee.getContractOverDate());
			contractOverDateCell.setCellStyle(dateCellStyle);

			if (employee.getReferenceName() != null)
				row.createCell(34).setCellValue(employee.getReferenceName());

			String   pan = "";
			for (EmployeeIdProof employeeIdProof : employee.getEmployeeIdProofs()) {
			 
				if (employeeIdProof.getIdTypeId().equals("PA")) {
					pan = employeeIdProof.getIdNumber();
				}
			}
			String pfNumber = "", unaNumber = "", esiNumber = "";
			for (EmployeeStatuary employeeStatuary : employee.getEmployeeStatuaries()) {
				if (employeeStatuary.getStatuaryType().equals("PF")) {
					pfNumber = employeeStatuary.getStatuaryNumber();
				}
				if (employeeStatuary.getStatuaryType().equals("UA")) {
					unaNumber = employeeStatuary.getStatuaryNumber();
				}
				if (employeeStatuary.getStatuaryType().equals("ES")) {
					esiNumber = employeeStatuary.getStatuaryNumber();
				}
			}

			if (employee.getAdharNumber() != null) {
				row.createCell(35).setCellValue(employee.getAdharNumber());
			}

			if (pan != null) {
				row.createCell(36).setCellValue(pan);
			}
			if (pfNumber != null) {
				row.createCell(37).setCellValue(pfNumber);
			}
			if (unaNumber != null)
				row.createCell(38).setCellValue(unaNumber);

			if (esiNumber != "")
				row.createCell(39).setCellValue(esiNumber);

			String   ifscCode = "", accountNumber = "";
			for (EmployeeBank employeeBank : employee.getEmployeeBanks()) {
				if (employeeBank.getAccountType().equals("SA")) {
 					accountNumber = employeeBank.getAccountNumber();
 					ifscCode = employeeBank.getIfscCode();

				}
			}

			if (employee.getAccountTypeValue() != null)
				row.createCell(40).setCellValue(employee.getAccountTypeValue());
			if (employee.getBankNameValue() != null)
				row.createCell(41).setCellValue(employee.getBankNameValue());
			if (accountNumber != null)
				row.createCell(42).setCellValue(accountNumber);
			if (ifscCode != null)
				row.createCell(43).setCellValue(ifscCode);
 			BigDecimal basicSalary = new BigDecimal(0);
			BigDecimal dearnessAllowance = new BigDecimal(0);
			BigDecimal houseRentAllowance = new BigDecimal(0);
			BigDecimal conveyanceAllowance = new BigDecimal(0);
			BigDecimal specialAllowance = new BigDecimal(0);
			BigDecimal medicalAllowance = new BigDecimal(0);
			BigDecimal advanceBonus = new BigDecimal(0);
			BigDecimal performanceLinkedIncome = new BigDecimal(0);
			BigDecimal companyBenefits = new BigDecimal(0);
			BigDecimal leaveTravelAllowance = new BigDecimal(0);
			BigDecimal uniformAllowance = new BigDecimal(0);
			for (PayStructureHd payStructureHd : employee.getPayStructureHds()) {
 				for (PayStructure payStructure : payStructureHd.getPayStructures()) {
					if (payStructure.getPayHead().getPayHeadId() == 1) {
						basicSalary = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 2) {
						dearnessAllowance = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 3) {
						houseRentAllowance = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 4) {
						conveyanceAllowance = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 5) {
						specialAllowance = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 6) {
						uniformAllowance = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 7) {
						leaveTravelAllowance = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 8) {
						medicalAllowance = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 9) {
						advanceBonus = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 10) {
						performanceLinkedIncome = payStructure.getAmount();
					}
					if (payStructure.getPayHead().getPayHeadId() == 11) {
						companyBenefits = payStructure.getAmount();
					}
				}

			}

		 

			if (basicSalary != null)
				row.createCell(44).setCellValue(convertBigdecimalToDouble(basicSalary));
			else
				row.createCell(44).setCellValue(0.00);

 			if (dearnessAllowance != null)
				row.createCell(45).setCellValue(convertBigdecimalToDouble(dearnessAllowance));
 			else
				row.createCell(45).setCellValue(0.00);
			if (houseRentAllowance != null)
				row.createCell(46).setCellValue(convertBigdecimalToDouble(houseRentAllowance));
			else
				row.createCell(46).setCellValue(0.00);
			if (conveyanceAllowance != null)
				row.createCell(47).setCellValue(convertBigdecimalToDouble(conveyanceAllowance));
			else
				row.createCell(47).setCellValue(0.00);
			if (specialAllowance != null)
				row.createCell(48).setCellValue(convertBigdecimalToDouble(specialAllowance));
			else
				row.createCell(48).setCellValue(0.00);
			if (medicalAllowance != null)
				row.createCell(49).setCellValue(convertBigdecimalToDouble(medicalAllowance));
			else
				row.createCell(49).setCellValue(0.00);
			if (advanceBonus != null)
				row.createCell(50).setCellValue(convertBigdecimalToDouble(advanceBonus));
			else
				row.createCell(50).setCellValue(0.00);
			if (performanceLinkedIncome != null)
				row.createCell(51).setCellValue(convertBigdecimalToDouble(performanceLinkedIncome));
			else
				row.createCell(51).setCellValue(0.00);
			if (companyBenefits != null)
				row.createCell(52).setCellValue(convertBigdecimalToDouble(companyBenefits));
			else
				row.createCell(52).setCellValue(0.00);
			if (leaveTravelAllowance != null)
				row.createCell(53).setCellValue(convertBigdecimalToDouble(leaveTravelAllowance));
			else
				row.createCell(53).setCellValue(0.00);
			if (uniformAllowance != null )
				row.createCell(54).setCellValue(convertBigdecimalToDouble(uniformAllowance));
			else	
				row.createCell(54).setCellValue("Amit");
		}
		 
		}
		else {
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
			Cell cell1 = row0.createCell(0);
			cell1.setCellValue("");
			cell1.setCellStyle(headCellStyle);

			
			
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 9, 17));
			Cell cell8 = row0.createCell(9);
			cell8.setCellValue("Present Address");
			cell8.setCellStyle(headerCellStyle);

			// Row row1 = sheet.createRow(1);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 18, 26));
			Cell cell9 = row0.createCell(18);
			cell9.setCellValue("Permanent Address");
			cell9.setCellStyle(headerCellStyle);

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 27, 35));
			Cell cell2 = row0.createCell(27);
			cell2.setCellValue("");
			cell2.setCellStyle(headCellStyle);
			
			
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 36, 37));
			Cell cell10 = row0.createCell(36);
			cell10.setCellValue("ID and Address Proof");
			cell10.setCellStyle(headerCellStyle);

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 38, 40));
			Cell cell11 = row0.createCell(38);
			cell11.setCellValue("Statutory Info.");
			cell11.setCellStyle(headerCellStyle);

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 41, 44));
			Cell cell12 = row0.createCell(41);
			cell12.setCellValue("Banking details");
			cell12.setCellStyle(headerCellStyle);

			sheet.addMergedRegion(new CellRangeAddress(0, 0, 45, 56));
			Cell cell13 = row0.createCell(45);
			cell13.setCellValue("Payheads");
			cell13.setCellStyle(headerCellStyle);

			for (Employee employee : employeeList) {
				Row row = sheet.createRow(rowNum++);
				// row.createCell(0).setCellValue(srNo++);
				if (employee.getEmployeeCode() != null)
					row.createCell(0).setCellValue(employee.getEmployeeCode());
				row.createCell(1).setCellValue(employee.getFirstName());
				if (employee.getMiddleName() != null)
					row.createCell(2).setCellValue(employee.getMiddleName());
				row.createCell(3).setCellValue(employee.getLastName());
				Cell dateOfBirthCell = row.createCell(4);
				dateOfBirthCell.setCellValue(employee.getDateOfBirth());
				dateOfBirthCell.setCellStyle(dateCellStyle);
				
				row.createCell(5).setCellValue(employee.getGenderValue());

				Cell dateOfJoingCell = row.createCell(6);
				dateOfJoingCell.setCellValue(employee.getDateOfJoining());
				dateOfJoingCell.setCellStyle(dateCellStyle);
				
				
				Cell dateOfJoiningCell = row.createCell(7);
 				dateOfJoiningCell.setCellValue(employee.getDateUpdate());
				dateOfJoiningCell.setCellStyle(dateCellStyle);

				row.createCell(8).setCellValue(employee.getMaritalStatusValue());
				if (employee.getAddress1() != null) {
					row.createCell(9).setCellValue(employee.getAddress1().getAddressText());
					row.createCell(10).setCellValue(employee.getAddress1().getLandmark());
					if (employee.getAddress1().getCountry() != null)
						row.createCell(11).setCellValue(employee.getAddress1().getCountry().getCountryName());
					if (employee.getAddress1().getState() != null)
						row.createCell(12).setCellValue(employee.getAddress1().getState().getStateName());
					if (employee.getAddress1().getCity() != null)
						row.createCell(13).setCellValue(employee.getAddress1().getCity().getCityName());
					row.createCell(14).setCellValue(employee.getAddress1().getPincode());
					row.createCell(15).setCellValue(employee.getAddress1().getMobile());
					row.createCell(16).setCellValue(employee.getAddress1().getTelephone());
					row.createCell(17).setCellValue(employee.getAddress1().getEmailId());
				}

				if (employee.getAddress2() != null) {
					row.createCell(18).setCellValue(employee.getAddress2().getAddressText());
					row.createCell(19).setCellValue(employee.getAddress2().getLandmark());
					if (employee.getAddress2().getCountry() != null)
						row.createCell(20).setCellValue(employee.getAddress2().getCountry().getCountryName());
					if (employee.getAddress2().getState() != null)
						row.createCell(21).setCellValue(employee.getAddress2().getState().getStateName());
					if (employee.getAddress2().getCity() != null)
						row.createCell(22).setCellValue(employee.getAddress2().getCity().getCityName());
					row.createCell(23).setCellValue(employee.getAddress2().getPincode());
					row.createCell(24).setCellValue(employee.getAddress2().getMobile());
					row.createCell(25).setCellValue(employee.getAddress2().getTelephone());
					row.createCell(26).setCellValue(employee.getAddress2().getEmailId());
				}

				if (employee.getCity() != null)
					row.createCell(27).setCellValue(employee.getCity().getCityName());
				if (employee.getState() != null)
					row.createCell(28).setCellValue(employee.getState().getStateName());
				row.createCell(29).setCellValue(employee.getBloodGroupValue());
				if (employee.getProbationDays() != null)
					row.createCell(30).setCellValue(employee.getProbationDays());
				if (employee.getEmpType() != null)
					row.createCell(31).setCellValue(employee.getEmpTypeValue());
				if (employee.getDepartment() != null)
					row.createCell(32).setCellValue(employee.getDepartment().getDepartmentName());
				if (employee.getDesignation() != null)
					row.createCell(33).setCellValue(employee.getDesignation().getDesignationName());
				/*
				 * if (employeeDto.getContractOverDate() != null)
				 * row.createCell(24).setCellValue(employeeDto.getContractOverDate());
				 */
				Cell contractOverDateCell = row.createCell(34);
				contractOverDateCell.setCellValue(employee.getContractOverDate());
				contractOverDateCell.setCellStyle(dateCellStyle);

				if (employee.getReferenceName() != null)
					row.createCell(35).setCellValue(employee.getReferenceName());

				String   pan = "";
				for (EmployeeIdProof employeeIdProof : employee.getEmployeeIdProofs()) {
				 
					if (employeeIdProof.getIdTypeId().equals("PA")) {
						pan = employeeIdProof.getIdNumber();
					}
				}
				String pfNumber = "", unaNumber = "", esiNumber = "";
				for (EmployeeStatuary employeeStatuary : employee.getEmployeeStatuaries()) {
					if (employeeStatuary.getStatuaryType().equals("PF")) {
						pfNumber = employeeStatuary.getStatuaryNumber();
					}
					if (employeeStatuary.getStatuaryType().equals("UA")) {
						unaNumber = employeeStatuary.getStatuaryNumber();
					}
					if (employeeStatuary.getStatuaryType().equals("ES")) {
						esiNumber = employeeStatuary.getStatuaryNumber();
					}
				}

				if (employee.getAdharNumber() != null) {
					row.createCell(36).setCellValue(employee.getAdharNumber());
				}

				if (pan != null) {
					row.createCell(37).setCellValue(pan);
				}
				if (pfNumber != null) {
					row.createCell(38).setCellValue(pfNumber);
				}
				if (unaNumber != null)
					row.createCell(39).setCellValue(unaNumber);

				if (esiNumber != "")
					row.createCell(40).setCellValue(esiNumber);

				String   ifscCode = "", accountNumber = "";
				for (EmployeeBank employeeBank : employee.getEmployeeBanks()) {
					if (employeeBank.getAccountType().equals("SA")) {
	 					accountNumber = employeeBank.getAccountNumber();
	 					ifscCode = employeeBank.getIfscCode();

					}
				}

				if (employee.getAccountTypeValue() != null)
					row.createCell(41).setCellValue(employee.getAccountTypeValue());
				if (employee.getBankNameValue() != null)
					row.createCell(42).setCellValue(employee.getBankNameValue());
				if (accountNumber != null)
					row.createCell(43).setCellValue(accountNumber);
				if (ifscCode != null)
					row.createCell(44).setCellValue(ifscCode);
 				BigDecimal basicSalary = new BigDecimal(0);
				BigDecimal dearnessAllowance = new BigDecimal(0);
				BigDecimal houseRentAllowance = new BigDecimal(0);
				BigDecimal conveyanceAllowance = new BigDecimal(0);
				BigDecimal specialAllowance = new BigDecimal(0);
				BigDecimal medicalAllowance = new BigDecimal(0);
				BigDecimal advanceBonus = new BigDecimal(0);
				BigDecimal performanceLinkedIncome = new BigDecimal(0);
				BigDecimal companyBenefits = new BigDecimal(0);
				BigDecimal leaveTravelAllowance = new BigDecimal(0);
				BigDecimal uniformAllowance = new BigDecimal(0);
				for (PayStructureHd payStructureHd : employee.getPayStructureHds()) {
 
					for (PayStructure payStructure : payStructureHd.getPayStructures()) {
						if (payStructure.getPayHead().getPayHeadId() == 1) {
							basicSalary = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 2) {
							dearnessAllowance = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 3) {
							houseRentAllowance = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 4) {
							conveyanceAllowance = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 5) {
							specialAllowance = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 6) {
							uniformAllowance = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 7) {
							leaveTravelAllowance = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 8) {
							medicalAllowance = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 9) {
							advanceBonus = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 10) {
							performanceLinkedIncome = payStructure.getAmount();
						}
						if (payStructure.getPayHead().getPayHeadId() == 11) {
							companyBenefits = payStructure.getAmount();
						}
					}

				}

			 

				if (basicSalary != null)
					row.createCell(45).setCellValue(convertBigdecimalToDouble(basicSalary));
				else
					row.createCell(45).setCellValue(0.00);

	 			if (dearnessAllowance != null)
					row.createCell(46).setCellValue(convertBigdecimalToDouble(dearnessAllowance));
	 			else
					row.createCell(46).setCellValue(0.00);
				if (houseRentAllowance != null)
					row.createCell(47).setCellValue(convertBigdecimalToDouble(houseRentAllowance));
				else
					row.createCell(47).setCellValue(0.00);
				if (conveyanceAllowance != null)
					row.createCell(48).setCellValue(convertBigdecimalToDouble(conveyanceAllowance));
				else
					row.createCell(48).setCellValue(0.00);
				if (specialAllowance != null)
					row.createCell(49).setCellValue(convertBigdecimalToDouble(specialAllowance));
				else
					row.createCell(49).setCellValue(0.00);
				if (medicalAllowance != null)
					row.createCell(50).setCellValue(convertBigdecimalToDouble(medicalAllowance));
				else
					row.createCell(50).setCellValue(0.00);
				if (advanceBonus != null)
					row.createCell(51).setCellValue(convertBigdecimalToDouble(advanceBonus));
				else
					row.createCell(51).setCellValue(0.00);
				if (performanceLinkedIncome != null)
					row.createCell(52).setCellValue(convertBigdecimalToDouble(performanceLinkedIncome));
				else
					row.createCell(52).setCellValue(0.00);
				if (companyBenefits != null)
					row.createCell(53).setCellValue(convertBigdecimalToDouble(companyBenefits));
				else
					row.createCell(53).setCellValue(0.00);
				if (leaveTravelAllowance != null)
					row.createCell(54).setCellValue(convertBigdecimalToDouble(leaveTravelAllowance));
				else
					row.createCell(54).setCellValue(0.00);
				if (uniformAllowance != null )
					row.createCell(55).setCellValue(convertBigdecimalToDouble(uniformAllowance));
				else
					row.createCell(55).setCellValue("Jaiswal");
			}
			 
		}
		
		
		
 		sheet.addMergedRegion(new CellRangeAddress(rowNum + 1, rowNum + 1, 4, 6));
  		sheet.addMergedRegion(new CellRangeAddress(rowNum + 2, rowNum + 2, 5, 6));

		// Resize all columns to fit the content size
		for (int i = 0; i < columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
 	 
		return workbook;
	}
}
