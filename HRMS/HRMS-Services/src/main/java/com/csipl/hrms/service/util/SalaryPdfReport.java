package com.csipl.hrms.service.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class SalaryPdfReport extends PdfPageEventHelper {
	private static final Logger logger = LoggerFactory.getLogger(SalaryPdfReport.class);
 	Document document = new Document(PageSize.A4, 36, 36, 54, 36);
	public static final FontFamily fontFamily = Font.FontFamily.HELVETICA;
	public static final FontFamily fontFamilyForHeading = Font.FontFamily.TIMES_ROMAN;
	public static final int fontSize = 9;
	public static final int fontSizeForHeading = 12;
	public static final int normalFontType = Font.NORMAL;
	final BaseColor fontColorBlack = BaseColor.BLACK;
	public static final BaseColor redFontColor = BaseColor.RED;
	final int boldFontType = Font.BOLD;
	final int boldFont = Font.BOLD;
	Font paraFont = new Font(fontFamily, fontSize, normalFontType, fontColorBlack);
	Font headingFont = new Font(fontFamilyForHeading, fontSizeForHeading, boldFont, fontColorBlack);
	Font subHeadingFont = new Font(fontFamilyForHeading, fontSize, boldFontType);
	PdfPCell cell = new PdfPCell();
	 
	PdfPCell cellHeader = new PdfPCell();
	
	public ByteArrayInputStream salaryPdfReport(ReportPayOut reportPayOut, Company companay, City city,
			Employee employee) throws Exception {
		/*
		 * Code For process Month
		 */
		  String USER_PASSWORD = reportPayOut.getEmployeeCode();
		  String OWNER_PASSWORD = "csipl";
		String processMonth=null;
		if(reportPayOut!=null)
		  processMonth = reportPayOut.getId().getProcessMonth();
 		logger.info("salaryPdfReport is calling : " + " processMonth  " + processMonth);

		String[] shortMonths = new DateFormatSymbols().getMonths();
		//System.out.println(Integer.valueOf(processMonth) % 100);
		//String monthAcronym = shortMonths[(Integer.valueOf(processMonth) % 100) - 1].toUpperCase();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfWriter pdfWriter = PdfWriter.getInstance(document, out);
		Rectangle rectangle = new Rectangle(30, 30, 550, 800);
		pdfWriter.setBoxSize("rectangle", rectangle);
 		pdfWriter.setEncryption(USER_PASSWORD.getBytes(),OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_PRINTING,PdfWriter.ENCRYPTION_AES_128);
 		HeaderFooterPageEvent event = new HeaderFooterPageEvent();
	    pdfWriter.setPageEvent(event);
 		document.open();
  		employeeInfo(reportPayOut, companay, city, processMonth, employee);
 		earningsAndDeductionsDetails(reportPayOut);
 		document.close();
 		
		return new ByteArrayInputStream(out.toByteArray());
	}// salaryPdfReport

	public void employeeInfo(ReportPayOut reportPayOut, Company company, City city,
			String processMonth, Employee employee) throws Exception {

		cell.setBorder(Rectangle.NO_BORDER);
 		cellHeader.setBorder(Rectangle.NO_BORDER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
 		cellHeader.setBorder(Rectangle.NO_BORDER);
		cellHeader.setBorder(Rectangle.BOTTOM);
		cell.setBackgroundColor(BaseColor.WHITE);
		cell.setPadding(1.5F);
		 
		/*
		 * Code By Ravindra Singh Parihar Date:22/02/2018
		 */
		Font compnyNameFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
		Font compnyInfoFont = new Font(FontFamily.HELVETICA, 9, Font.NORMAL);


		if (company.getCompanyLogoPath() != null && !company.getCompanyLogoPath().equals("")) {
			PdfPTable c_logoTable = new PdfPTable(1);
			c_logoTable.setWidthPercentage(80.0F);
			c_logoTable.setWidths(new float[] { 1.0F });
			
			// Image Code
			PdfPCell c_logoCell = new PdfPCell();
			c_logoCell.setBorder(Rectangle.NO_BORDER);
			String rootPath = System.getProperty("catalina.home");
 	 		logger.info("salaryPdfReport is calling : " + " CompanyLogoPath  " + company.getCompanyLogoPath());

			String path = company.getCompanyLogoPath() != null ? company.getCompanyLogoPath() : "";
			rootPath = rootPath + File.separator + HrmsGlobalConstantUtil.APP_BASE_FOLDER + File.separator + path;
  	 		logger.info("salaryPdfReport is calling : " + " rootPath  " + rootPath);

			try {
			Image image = Image.getInstance(rootPath);
			if (image != null) {

				System.out.println("image" + image);
				float scaler = ((document.getPageSize().getWidth()) / image.getWidth()) * 19;
				image.setAlignment(Image.ORIGINAL_WMF);
				image.setAlignment(Image.ALIGN_LEFT);
				image.scalePercent(scaler);
				c_logoCell.addElement(image);
				c_logoTable.addCell(c_logoCell);
				document.add(c_logoTable);
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}

			PdfPTable c_nameTable = new PdfPTable(1);
			c_nameTable.setWidthPercentage(80.0F);
			c_nameTable.setWidths(new float[] { 1.0F });
			PdfPCell c_nameCell = new PdfPCell();
			PdfPCell c_compnyInfoCell = new PdfPCell();

			c_nameCell.setVerticalAlignment(Element.ALIGN_CENTER);
			c_nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
  			c_nameCell.setBorder(Rectangle.NO_BORDER);
			c_nameCell.setPhrase(new Phrase(company.getCompanyName(), compnyNameFont));
			
			c_compnyInfoCell.setVerticalAlignment(Element.ALIGN_CENTER);
			c_compnyInfoCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			c_compnyInfoCell.setBorder(Rectangle.NO_BORDER);
			
			c_compnyInfoCell.setPhrase(new Phrase(company.getAddress1().getState().getStateName()+" "+company.getAddress1().getCity().getCityName()+" - "+company.getAddress1().getPincode(), compnyInfoFont));
   			c_nameTable.addCell(c_nameCell);
   			c_nameTable.addCell(c_compnyInfoCell);
 			document.add(c_nameTable);
			

		}
		PdfPTable tableHead = new PdfPTable(1);
		tableHead.setSpacingBefore(15.0F);
		tableHead.setSpacingAfter(10.0F);
		tableHead.setWidthPercentage(80.0F);
		tableHead.setWidths(new float[] { 1.0F });
		cellHeader.setPaddingBottom(5);
		cellHeader.setPaddingTop(15);
		cellHeader.setPhrase(
				new Phrase("PAY SLIP- " +processMonth, subHeadingFont));
 		tableHead.addCell(cellHeader);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(80.0F);
		table.setWidths(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
		cell.setPhrase(new Phrase("Employee Name", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(reportPayOut.getName(), paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PAN ", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(reportPayOut.getPanno(), paraFont));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Employee Id", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(reportPayOut.getEmployeeCode(), paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("UID", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(reportPayOut.getAadharNo(), paraFont));
		table.addCell(cell);
 
		cell.setPhrase(new Phrase("Designation", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(
				employee.getDesignation() != null ? employee.getDesignation().getDesignationName() : "", paraFont));
		table.addCell(cell);

		cell.setPhrase(new Phrase("UAN", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(reportPayOut.getUanno(), paraFont));
		table.addCell(cell);
 		
		cell.setPhrase(new Phrase("Location", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(city.getCityName(), paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("PF Number", paraFont));//
		table.addCell(cell);
		cell.setPhrase(new Phrase(reportPayOut.getPFNumber(), paraFont));
		table.addCell(cell);
 	
		cell.setPhrase(new Phrase("Date of Joining", paraFont));
		table.addCell(cell);
		String dOfJo = reportPayOut.getDateOfJoining() != null ? reportPayOut.getDateOfJoining().toString() : "";
		if (!dOfJo.equals("")) {
			String[] dOfJos = dOfJo.split("-");
			if (dOfJos.length > 2)
				dOfJo = dOfJos[2] + "-" + dOfJos[1] + "-" + dOfJos[0];
		}
		cell.setPhrase(new Phrase(dOfJo, paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("ESI Number", paraFont)); 
		table.addCell(cell);
		cell.setPhrase(new Phrase(
				reportPayOut.getESICNumber() != null ? reportPayOut.getESICNumber().toString() : "", paraFont));
		table.addCell(cell);

 		cell.setPhrase(new Phrase("Bank Name", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(reportPayOut.getBankName(), paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("Account No", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(reportPayOut.getAccountNumber(), paraFont));
		table.addCell(cell);
 		cell.setPhrase(new Phrase("Pay Days", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase(convertBigdecimalToStringThrowInt(reportPayOut.getPayableDays()), paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("", paraFont));
		table.addCell(cell);
		cell.setPhrase(new Phrase("", paraFont));
		table.addCell(cell);
		document.add(tableHead);
		document.add(table);
	}// ImployeeInfo

	public void earningsAndDeductionsDetails(ReportPayOut reportPayOut) throws Exception {
		PdfPCell cell = new PdfPCell();
		cell.setBorder(Rectangle.NO_BORDER);
 		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
 		cell.setVerticalAlignment(Element.ALIGN_CENTER);
	 	PdfPTable table = new PdfPTable(4);
		table.setSpacingAfter(10.0F);
		PdfPCell cellED = new PdfPCell();
		cellED.setPaddingBottom(5);
		cellED.setPaddingTop(15);

		cellED.setBorder(Rectangle.NO_BORDER);
		cellED.setBorder(Rectangle.NO_BORDER);
		cellED.setBorder(Rectangle.BOTTOM);
		cellED.setPaddingLeft(2);
		table.setWidthPercentage(80.0F);
		table.setWidths(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
		cellED.setPhrase(new Phrase("Earnings", subHeadingFont));
		table.addCell(cellED);
		cellED.setPhrase(new Phrase("Amount ", subHeadingFont));
		table.addCell(cellED);
		cellED.setPhrase(new Phrase("Deductions :", subHeadingFont));
		table.addCell(cellED);
		cellED.setPhrase(new Phrase("Amount", subHeadingFont));
		table.addCell(cellED);
  		document.add(table);

		/*
		 * Earnings and Deductions details validation code... by ravindra singh parihar
		 * date:21/2/2018
		 * 
		 */
		BigDecimal basicEarning = reportPayOut.getBasicEarning();
		String basicEarning1 = basicEarning != null && basicEarning.doubleValue() > 0 ? basicEarning.toString() : "";

		BigDecimal hraEarning = reportPayOut.getHRAEarning();
		String hraEarning1 = hraEarning != null && hraEarning.doubleValue() > 0 ? hraEarning.toString() : "";

		BigDecimal conveyanceAllowanceEarning = reportPayOut.getConveyanceAllowanceEarning();
		String conveyanceAllowanceEarning1 = conveyanceAllowanceEarning != null
				&& conveyanceAllowanceEarning.doubleValue() > 0 ? conveyanceAllowanceEarning.toString() : "";

		BigDecimal advanceBonusEarning = reportPayOut.getAdvanceBonusEarning();
		String advanceBonusEarning1 = advanceBonusEarning != null && advanceBonusEarning.doubleValue() > 0

				? advanceBonusEarning.toString()
				: "";

		BigDecimal medicalAllowanceEarning = reportPayOut.getMedicalAllowanceEarning();
		String medicalAllowanceEarning1 = medicalAllowanceEarning != null && medicalAllowanceEarning.doubleValue() > 0
				? medicalAllowanceEarning.toString()
				: "";

		BigDecimal specialAllowanceEarning = reportPayOut.getSpecialAllowanceEarning();
		String specialAllowanceEarning1 = specialAllowanceEarning != null && specialAllowanceEarning.doubleValue() > 0
				? specialAllowanceEarning.toString()
				: "";

		BigDecimal uniformAllowanceEarning = reportPayOut.getUniformAllowanceEarning();
		String uniformAllowanceEarning1 = uniformAllowanceEarning != null && uniformAllowanceEarning.doubleValue() > 0
				? uniformAllowanceEarning.toString()
				: "";
		BigDecimal leaveTravelAllowanceEarning = reportPayOut.getLeaveTravelAllowanceEarning();
		String leaveTravelAllowanceEarning1 = leaveTravelAllowanceEarning != null
				&& leaveTravelAllowanceEarning.doubleValue() > 0 ? leaveTravelAllowanceEarning.toString() : "";
		BigDecimal otherAllowanceEarning = reportPayOut.getOtherAllowanceEarning();
		String otherAllowanceEarning1 = otherAllowanceEarning != null && otherAllowanceEarning.doubleValue() > 0
				? otherAllowanceEarning.toString()
				: "";
		BigDecimal companyBenefitsEarning = reportPayOut.getCompanyBenefitsEarning();
		String companyBenefitsEarning1 = companyBenefitsEarning != null && companyBenefitsEarning.doubleValue() > 0
				? companyBenefitsEarning.toString()
				: "";
		BigDecimal dearnessAllowanceEarning = reportPayOut.getDearnessAllowanceEarning();
		String dearnessAllowanceEarning1 = dearnessAllowanceEarning != null
				&& dearnessAllowanceEarning.doubleValue() > 0 ? dearnessAllowanceEarning.toString() : "";
		/*
		 * code by ravindra singh parihar date:21/2/2018
		 * 
		 */
		Paragraph paragraph = new Paragraph();
		PdfPCell cell123 = new PdfPCell();
		cell123.setVerticalAlignment(Element.ALIGN_CENTER);
		PdfPCell cell124 = new PdfPCell();
		cell124.setBorder(Rectangle.NO_BORDER);
		PdfPCell cell124A = new PdfPCell();
		cell124A.setVerticalAlignment(Element.ALIGN_RIGHT);
		cell124A.setBorder(Rectangle.NO_BORDER);
		cell124A.setPaddingLeft(Element.ALIGN_RIGHT);
		cell124A.setPaddingLeft(2);
		PdfPCell cell125 = new PdfPCell();
		cell125.setBorder(Rectangle.NO_BORDER);
		PdfPCell cell125A = new PdfPCell();
		cell125A.setVerticalAlignment(Element.ALIGN_RIGHT);
		cell125A.setPaddingLeft(Element.ALIGN_RIGHT);
		cell125A.setBorder(Rectangle.NO_BORDER);
		cell125A.setPaddingLeft(2);

		// Main table

		PdfPTable mainTable = new PdfPTable(2);

		mainTable.setWidthPercentage(100.0F);
		mainTable.setWidths(new float[] { 1.0F, 1.0F });
		// First table
		PdfPCell firstTableCell = new PdfPCell();
		firstTableCell.setBorder(PdfPCell.NO_BORDER);
		PdfPTable firstTable = new PdfPTable(2);
		firstTable.setHorizontalAlignment(Element.ALIGN_RIGHT);
		firstTable.setWidthPercentage(80.0F);

		// append code
		if (!basicEarning1.equals("")) {
			cell124.setPhrase(new Phrase("Basic Salary", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(new Phrase(basicEarning1, paraFont));
			firstTable.addCell(cell124A);
		}

		if (!hraEarning1.equals("")) {
			cell124.setPhrase(new Phrase("HRA", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(new Phrase(hraEarning1, paraFont));
			firstTable.addCell(cell124A);
		}

		if (!conveyanceAllowanceEarning1.equals("")) {
			cell124.setPhrase(new Phrase("Conveyance Allowance", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(new Phrase(conveyanceAllowanceEarning1, paraFont));
			firstTable.addCell(cell124A);
		}

		if (!advanceBonusEarning1.equals("")) {
			cell124.setPhrase(new Phrase("Advance Bonus", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(new Phrase(advanceBonusEarning1, paraFont));
			firstTable.addCell(cell124A);
		}

		if (!uniformAllowanceEarning1.equals("")) {
			cell124.setPhrase(new Phrase("Uniform Allowance", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(
					new Phrase(convertBigdecimalToString(reportPayOut.getUniformAllowanceEarning()), paraFont));
			firstTable.addCell(cell124A);
		}

		if (!leaveTravelAllowanceEarning1.equals("")) {
			cell124.setPhrase(new Phrase("LTA", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(
					new Phrase(convertBigdecimalToString(reportPayOut.getLeaveTravelAllowanceEarning()), paraFont));
			firstTable.addCell(cell124A);
		}
		if (!otherAllowanceEarning1.equals("")) {
			cell124.setPhrase(new Phrase("Other Allowance", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(
					new Phrase(convertBigdecimalToString(reportPayOut.getOtherAllowanceEarning()), paraFont));
			firstTable.addCell(cell124A);
		}
		if (!companyBenefitsEarning1.equals("")) {
			cell124.setPhrase(new Phrase("Company Benefits", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(
					new Phrase(convertBigdecimalToString(reportPayOut.getCompanyBenefitsEarning()), paraFont));
			firstTable.addCell(cell124A);
		}

		if (!dearnessAllowanceEarning1.equals("")) {
			cell124.setPhrase(new Phrase("DA Allowance", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(new Phrase(dearnessAllowanceEarning1, paraFont));
			firstTable.addCell(cell124A);
		}
		if (!medicalAllowanceEarning1.equals("")) {
			cell124.setPhrase(new Phrase("Medical Allowance", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(new Phrase(medicalAllowanceEarning1, paraFont));
			firstTable.addCell(cell124A);
		}

		if (!specialAllowanceEarning1.equals("")) {
			cell124.setPhrase(new Phrase("Special Allowance", paraFont));
			firstTable.addCell(cell124);
			cell124A.setPhrase(new Phrase(specialAllowanceEarning1, paraFont));
			firstTable.addCell(cell124A);
		}

		firstTableCell.addElement(firstTable);
		mainTable.addCell(firstTableCell);

		/*
		 * code By RAvindra singh Date:22/02/2018
		 */
		BigDecimal providentFundEmployee = reportPayOut.getProvidentFundEmployee();
		String providentFundEmployee1 = providentFundEmployee != null && providentFundEmployee.doubleValue() > 0
				? providentFundEmployee.toString()
				: "";

		BigDecimal eSI_Employee = reportPayOut.getESI_Employee();
		String eSI_Employee1 = eSI_Employee != null && eSI_Employee.doubleValue() > 0 ? eSI_Employee.toString() : "";

		BigDecimal tds = reportPayOut.getTds();
		String tds1 = tds != null && tds.doubleValue() > 0 ? tds.toString() : "";

		BigDecimal pt = reportPayOut.getPt();
		String pt1 = pt != null && pt.doubleValue() > 0 ? pt.toString() : "";

		BigDecimal employeeLoan = reportPayOut.getLoan();
		String employeeLoan1 = employeeLoan != null && employeeLoan.doubleValue() > 0 ? employeeLoan.toString() : "";

		BigDecimal totalDeduction = reportPayOut.getTotalDeduction();
		String totalDeduction1 = totalDeduction != null && totalDeduction.doubleValue() > 0 ? totalDeduction.toString()
				: "";

		BigDecimal otherDeduction = reportPayOut.getOtherDeduction();
		String otherDeduction1 = otherDeduction != null && otherDeduction.doubleValue() > 0 ? otherDeduction.toString()
				: "";

		PdfPCell secondTableCell = new PdfPCell();
		secondTableCell.setBorder(PdfPCell.NO_BORDER);
		PdfPTable secondTable = new PdfPTable(2);
 		secondTable.setHorizontalAlignment(Element.ALIGN_LEFT);
		secondTable.setWidthPercentage(80.0F);

		if (!providentFundEmployee1.equals("")) {
			cell125.setPhrase(new Phrase("EPF", paraFont));
			secondTable.addCell(cell125);
			cell125A.setPhrase(new Phrase(providentFundEmployee1, paraFont));
			secondTable.addCell(cell125A);
		}
		if (!eSI_Employee1.equals("")) {
			cell125.setPhrase(new Phrase("ESI", paraFont));
			secondTable.addCell(cell125);
			cell125A.setPhrase(new Phrase(eSI_Employee1, paraFont));
			secondTable.addCell(cell125A);
		}
		if (!tds1.equals("")) {
			cell125.setPhrase(new Phrase("TDS:", paraFont));
			secondTable.addCell(cell125);
			cell125A.setPhrase(new Phrase(tds1, paraFont));
			secondTable.addCell(cell125A);
		}
		if (!pt1.equals("")) {
			cell125.setPhrase(new Phrase("Professional Tax", paraFont));
			secondTable.addCell(cell125);
			cell125A.setPhrase(new Phrase(pt1, paraFont));
			secondTable.addCell(cell125A);
		}
		if (!employeeLoan1.equals("")) {
			cell125.setPhrase(new Phrase("Loan & Advance", paraFont));
			secondTable.addCell(cell125);
			cell125A.setPhrase(new Phrase(employeeLoan1, paraFont));
			secondTable.addCell(cell125A);
		}

		if (!otherDeduction1.equals("")) {
			cell125.setPhrase(new Phrase("Other Deduction", paraFont));
			secondTable.addCell(cell125);
			cell125A.setPhrase(new Phrase(otherDeduction1, paraFont));
			secondTable.addCell(cell125A);
		}
	 
		secondTableCell.addElement(secondTable);
		mainTable.addCell(secondTableCell);
		paragraph.add(mainTable);

		PdfPCell cellE = new PdfPCell();
		cellE.setBorder(Rectangle.NO_BORDER);
		cellE.setBorder(Rectangle.BOTTOM);
		cellE.setPaddingBottom(5);

		cellE.setVerticalAlignment(Element.ALIGN_CENTER);

		PdfPCell cellD = new PdfPCell();
		cellD.setBorder(Rectangle.NO_BORDER);
		cellD.setBorder(Rectangle.BOTTOM);
		cellD.setPaddingBottom(5);
		cellD.setVerticalAlignment(Element.ALIGN_CENTER);

		PdfPCell cellfEA = new PdfPCell();
		cellfEA.setBorder(Rectangle.NO_BORDER);
		cellfEA.setBorder(Rectangle.BOTTOM);
		cellfEA.setPaddingBottom(5);

		cellfEA.setVerticalAlignment(Element.ALIGN_CENTER);
		cellfEA.setPaddingLeft(2);
		PdfPCell cellfDA = new PdfPCell();
		cellfDA.setBorder(Rectangle.NO_BORDER);
		cellfDA.setBorder(Rectangle.BOTTOM);
		cellfDA.setPaddingBottom(5);

		cellfDA.setVerticalAlignment(Element.ALIGN_CENTER);

		cellfDA.setPaddingLeft(2);
		PdfPTable tablefooter = new PdfPTable(4);
		tablefooter.setWidthPercentage(80.0F);
		tablefooter.setWidths(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
		cellE.setPhrase(new Phrase("Total Earnings", subHeadingFont));
		tablefooter.addCell(cellE);
		cellfEA.setPhrase(new Phrase(convertBigdecimalToString(reportPayOut.getTotalEarning()), subHeadingFont));
		tablefooter.addCell(cellfEA);
		cellD.setPhrase(new Phrase("Total Deductions", subHeadingFont));
		tablefooter.addCell(cellD);
		cellfDA.setPhrase(new Phrase(totalDeduction1, subHeadingFont));
		tablefooter.addCell(cellfDA);
		paragraph.add(tablefooter);
		document.add(paragraph);
		PdfPTable tblNetAmountInWord = new PdfPTable(2);
		tblNetAmountInWord.setWidthPercentage(80.0F);
		tblNetAmountInWord.setWidths(new float[] {0.5F, 1.5F });
		PdfPCell cellNetAmountInWord = new PdfPCell();

		cellNetAmountInWord.setBorder(Rectangle.NO_BORDER);
		cellNetAmountInWord.setBorder(Rectangle.BOTTOM);
		cellNetAmountInWord.setPaddingBottom(5);

		cellNetAmountInWord.setVerticalAlignment(Element.ALIGN_CENTER);
		cellNetAmountInWord.setHorizontalAlignment(Element.ALIGN_LEFT);

		cellNetAmountInWord.setPhrase(
				new Phrase("Amount in words(Rs.)",
						subHeadingFont));
		tblNetAmountInWord.addCell(cellNetAmountInWord);
 		cellNetAmountInWord.setHorizontalAlignment(Element.ALIGN_RIGHT);
 		cellNetAmountInWord.setPhrase(
				new Phrase(convertToIndianCurrency(convertBigdecimalToString(reportPayOut.getNetPayableAmount())),
						subHeadingFont));
 		tblNetAmountInWord.addCell(cellNetAmountInWord);
		PdfPTable tblNetAmount = new PdfPTable(4);
		tblNetAmount.setWidthPercentage(80.0F);
		tblNetAmount.setWidths(new float[] { 1.0F, 1.0F, 1.0F, 1.0F });
		PdfPCell cellNetAmount = new PdfPCell();
		cellNetAmount.setBorder(Rectangle.NO_BORDER);
		cellNetAmount.setBorder(Rectangle.BOTTOM);
		cellNetAmount.setPaddingBottom(5);

		cellNetAmount.setVerticalAlignment(Element.ALIGN_CENTER);

		cellNetAmount.setPhrase(new Phrase("Net Amount", subHeadingFont));
		tblNetAmount.addCell(cellNetAmount);
		cellNetAmount.setPhrase(new Phrase("", subHeadingFont));
		tblNetAmount.addCell(cellNetAmount);
		cellNetAmount.setPhrase(new Phrase("", subHeadingFont));
		tblNetAmount.addCell(cellNetAmount);
		cellNetAmount
				.setPhrase(new Phrase(convertBigdecimalToString(reportPayOut.getNetPayableAmount()), subHeadingFont));
		cellNetAmount.setVerticalAlignment(Element.ALIGN_RIGHT);
		tblNetAmount.addCell(cellNetAmount);
		PdfPTable msgTbl = new PdfPTable(1);
		msgTbl.setWidthPercentage(80.0F);
		msgTbl.setWidths(new float[] { 1.0F });
		PdfPCell cellMsg = new PdfPCell();
		cellMsg.setBorder(Rectangle.NO_BORDER);
		cellMsg.setPaddingLeft(2);
		cellMsg.setPaddingTop(37);
		cellMsg.setPhrase(
				new Phrase("This is a computer generated salary slip, does not require seal and signature.", paraFont));
		msgTbl.addCell(cellMsg);
		document.add(tblNetAmount);
		document.add(tblNetAmountInWord);
		document.add(msgTbl);

	}// earningsAndDeductionsDetails

	private static String convertBigdecimalToString(BigDecimal value) {
		String stringValue = "";
		if (value != null && !value.equals("")) {
			stringValue = value.toString();
		}
		return stringValue;
	}//convertBigdecimalToString

	private static String convertBigdecimalToStringThrowInt(BigDecimal value) {
		String stringValue = "";
		if (value != null && !value.equals("")) {
			Integer intValue = value.intValue();
			stringValue = intValue.toString();
		}
		return stringValue;
	}//convertBigdecimalToStringThrowInt

	public static String convertToIndianCurrency(String num) {
		BigDecimal bd = new BigDecimal(num);
		long number = bd.longValue();
		long no = bd.longValue();
		int decimal = (int) (bd.remainder(BigDecimal.ONE).doubleValue() * 100);
		int digits_length = String.valueOf(no).length();
		int i = 0;
		ArrayList<String> str = new ArrayList<>();
		HashMap<Integer, String> words = new HashMap<>();
		words.put(0, "");
		words.put(1, "One");
		words.put(2, "Two");
		words.put(3, "Three");
		words.put(4, "Four");
		words.put(5, "Five");
		words.put(6, "Six");
		words.put(7, "Seven");
		words.put(8, "Eight");
		words.put(9, "Nine");
		words.put(10, "Ten");
		words.put(11, "Eleven");
		words.put(12, "Twelve");
		words.put(13, "Thirteen");
		words.put(14, "Fourteen");
		words.put(15, "Fifteen");
		words.put(16, "Sixteen");
		words.put(17, "Seventeen");
		words.put(18, "Eighteen");
		words.put(19, "Nineteen");
		words.put(20, "Twenty");
		words.put(30, "Thirty");
		words.put(40, "Forty");
		words.put(50, "Fifty");
		words.put(60, "Sixty");
		words.put(70, "Seventy");
		words.put(80, "Eighty");
		words.put(90, "Ninety");
		String digits[] = { "", "Hundred", "Thousand", "Lakh", "Crore" };
		while (i < digits_length) {
			int divider = (i == 2) ? 10 : 100;
			number = no % divider;
			no = no / divider;
			i += divider == 10 ? 1 : 2;
			if (number > 0) {
				int counter = str.size();
				String plural = (counter > 0 && number > 9) ? "s" : "";
				String tmp = (number < 21) ? words.get(Integer.valueOf((int) number)) + " " + digits[counter] + plural
						: words.get(Integer.valueOf((int) Math.floor(number / 10) * 10)) + " "
								+ words.get(Integer.valueOf((int) (number % 10))) + " " + digits[counter] + plural;
				str.add(tmp);
			} else {
				str.add("");
			}
		}

		Collections.reverse(str);
		String rupees = String.join(" ", str).trim();

		String paise = (decimal) > 0 ? " And  " + words.get(Integer.valueOf((int) (decimal - decimal % 10))) + " "
						+ words.get(Integer.valueOf((int) (decimal % 10)))
				: "And Zero ";
		return rupees + paise + " Paise";
	}//convertToIndianCurrency

}// class
