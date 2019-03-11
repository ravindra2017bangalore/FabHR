package com.csipl.hrms.service.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import com.csipl.hrms.dto.payroll.LoanEMIDTO;
import com.csipl.hrms.dto.payroll.LoanIssueDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.payroll.LoanIssue;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class LoanEmiPdf  {
	Font compnyNameFont = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
	
	Document document = new Document(PageSize.A4, 36, 36, 54, 36);
	public static final FontFamily fontFamily = Font.FontFamily.HELVETICA;
	public static final FontFamily fontFamilyForHeading = Font.FontFamily.HELVETICA;
	public static final int fontSize = 8;
	public static final int fontSizeForHeading = 13;
	public static final int normalFontType = Font.NORMAL;
	final BaseColor fontColorBlack = BaseColor.BLACK;
	public static final BaseColor redFontColor = BaseColor.RED;
	final int boldFontType = Font.BOLD;
	final int boldFont = Font.BOLD;
	Font paraFont = new Font(fontFamily, fontSize, normalFontType, fontColorBlack);
	Font headingFont = new Font(fontFamilyForHeading, fontSizeForHeading, boldFont, fontColorBlack);
	Font subHeadingFont = new Font(fontFamilyForHeading, fontSize, boldFontType);

	PdfPCell cellHeader = new PdfPCell();
	public static final int webSiteFontSize = 10;
	PdfPCell cell = new PdfPCell();
	PdfPCell cell1 = new PdfPCell();
	PdfPCell cell2 = new PdfPCell();
	PdfPCell itemCell = new PdfPCell();
	public static final int compnyHeadingFontSize = 24;
	public static final float lineSpacing = 8f;
	int i=1;

	Font compnyHeadFont = new Font(fontFamily, compnyHeadingFontSize, normalFontType, redFontColor);

	public ByteArrayInputStream loanPdfReport(LoanIssueDTO LoanIssueDto, Company company, List<LoanEMIDTO> loanEMIDTOList) throws Exception {
  		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfWriter pdfWriter = PdfWriter.getInstance(document, out);
		Rectangle rectangle = new Rectangle(30, 30, 550, 800);
 		HeaderFooterPageEvent event = new HeaderFooterPageEvent();
	    pdfWriter.setPageEvent(event);
		pdfWriter.setBoxSize("rectangle", rectangle);
    	 document.open();
 	        addComapanyName(company);
	        employeeInformation(company, LoanIssueDto);
	        loanDetails(LoanIssueDto);
	        loanEmiDetails(LoanIssueDto,loanEMIDTOList);
  	        document.close();
  		return new ByteArrayInputStream(out.toByteArray());
	}// loanPdfReport

	private void addComapanyName(Company company) throws Exception {

		if (company.getCompanyLogoPath() != null && !company.getCompanyLogoPath().equals("")) {
			PdfPTable c_logoTable = new PdfPTable(1);
			c_logoTable.setWidthPercentage(100.0F);
			c_logoTable.setWidths(new float[] { 1.0F });
			// Image Code
			PdfPCell c_logoCell = new PdfPCell();
			c_logoCell.setBorder(Rectangle.NO_BORDER);
			String rootPath = System.getProperty("catalina.home");
 			String path = company.getCompanyLogoPath() != null ? company.getCompanyLogoPath() : "";
			rootPath = rootPath + File.separator + "webapps" + File.separator + path;
			System.out.println("rootPath" + rootPath);
			try {
				Image image = Image.getInstance(rootPath);
 				if (image != null) {
  					float scaler = ((document.getPageSize().getWidth()) / image.getWidth()) * 19;
  					image.setAlignment(Image.ORIGINAL_WMF);
					image.setAlignment(Image.ALIGN_LEFT);
					image.scalePercent(scaler);
 					c_logoCell.addElement(image);
 					c_logoTable.addCell(c_logoCell);
					document.add(c_logoTable);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			PdfPTable c_nameTable = new PdfPTable(1);
			c_nameTable.setWidthPercentage(100.0F);
			c_nameTable.setWidths(new float[] { 1.0F });
			PdfPCell c_nameCell = new PdfPCell();
			c_nameCell.setVerticalAlignment(Element.ALIGN_CENTER);
			c_nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			//c_nameCell.setPaddingLeft(50);
			c_nameCell.setBorder(Rectangle.NO_BORDER);
			c_nameCell.setPhrase(new Phrase(company.getCompanyName(), compnyNameFont));
			c_nameCell.setPaddingBottom(30);
			c_nameTable.addCell(c_nameCell);
			document.add(c_nameTable);

		}
	}
	
	public void employeeInformation(Company company, LoanIssueDTO loanIssueDto) throws Exception {
 		PdfPTable employeeInfoTable = new PdfPTable(8);
 		employeeInfoTable.setWidths(new float[] { 1.2F, 0.8F, 1.2F, 1.0F, 0.9F,1.0F,0.9F,1.0F });

		employeeInfoTable.setWidthPercentage(100);
		PdfPCell cellHeadCode = new PdfPCell();
		PdfPCell cellHeadName = new PdfPCell();
		PdfPCell cellHeadDepartment = new PdfPCell();
		PdfPCell cellHeadDesignation = new PdfPCell();
 		
		PdfPCell cellHeadCodeValue = new PdfPCell();
		PdfPCell cellHeadNameValue = new PdfPCell();
		PdfPCell cellHeadDepartmentValue = new PdfPCell();
		PdfPCell cellHeadDesignationValue = new PdfPCell();
		 
		cellHeadCode.setBorder(Rectangle.NO_BORDER);
		cellHeadName.setBorder(Rectangle.NO_BORDER);
		cellHeadDepartment.setBorder(Rectangle.NO_BORDER);
		cellHeadDesignation.setBorder(Rectangle.NO_BORDER);
		 
		cellHeadCodeValue.setBorder(Rectangle.NO_BORDER);
		cellHeadNameValue.setBorder(Rectangle.NO_BORDER);
		cellHeadDepartmentValue.setBorder(Rectangle.NO_BORDER);
		cellHeadDesignationValue.setBorder(Rectangle.NO_BORDER);
		
		Paragraph empCodeName    = new Paragraph("Employee Code:- ", subHeadingFont);
		Paragraph empCodeValue    = new Paragraph(loanIssueDto.getEmployeeCode(), paraFont);
 		cellHeadCode.setPhrase(new Phrase(empCodeName));
 		cellHeadCodeValue.setPhrase(new Phrase(empCodeValue));
 		Paragraph empName    = new Paragraph("Employee Name:- " , subHeadingFont);
		Paragraph empNameValue    = new Paragraph(  loanIssueDto.getEmployeeName(), paraFont);
 		cellHeadName.setPhrase(new Phrase(empName));
 		cellHeadNameValue.setPhrase(new Phrase(empNameValue));
  		Paragraph departmentName = new Paragraph("Department:- " , subHeadingFont);
  		Paragraph departmentValue = new Paragraph(loanIssueDto.getDepartmentName(), paraFont);
   		cellHeadDepartment.setPhrase(new Phrase(departmentName));
   		cellHeadDepartmentValue.setPhrase(new Phrase(departmentValue));
 		Paragraph designationName= new Paragraph("Designation:- " , subHeadingFont);
 		Paragraph designationValue= new Paragraph(loanIssueDto.getDesignationName(), paraFont);
 		cellHeadDesignation.setPhrase(new Phrase(designationName));
 		cellHeadDesignationValue.setPhrase(new Phrase(designationValue));
 		employeeInfoTable.addCell(cellHeadCode);
		employeeInfoTable.addCell(cellHeadCodeValue);
		
 		employeeInfoTable.addCell(cellHeadName);
		employeeInfoTable.addCell(cellHeadNameValue);

		employeeInfoTable.addCell(cellHeadDepartment);
		employeeInfoTable.addCell(cellHeadDepartmentValue);

		employeeInfoTable.addCell(cellHeadDesignation);
		employeeInfoTable.addCell(cellHeadDesignationValue);
		document.add(employeeInfoTable);
	}

	private void loanDetails(LoanIssueDTO loanIssueDto) throws Exception {
		PdfPCell cellHead = new PdfPCell();
		PdfPCell cellPara = new PdfPCell();
		cellHead.setBorder(Rectangle.NO_BORDER);
		cellHead.setVerticalAlignment(Element.ALIGN_CENTER);
		cellHead.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cellPara.setBorder(Rectangle.NO_BORDER);
		cellPara.setVerticalAlignment(Element.ALIGN_CENTER);
		cellPara.setHorizontalAlignment(Element.ALIGN_RIGHT);

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100.0F);
		table.setSpacingAfter(10.0F);
		cellHead.setPaddingBottom(5);
		cellHead.setPaddingTop(15);
		cellHead.setBorder(Rectangle.NO_BORDER);
		cellHead.setBorder(Rectangle.NO_BORDER);
		cellHead.setBorder(Rectangle.BOTTOM);
		cellHead.setPaddingLeft(2);
		table.setWidthPercentage(100.0F);
		table.setWidths(new float[] { 1.0F, 1.0F, 1.4F, 0.8F, 0.8F, 1.0F });

		cellHead.setPhrase(new Phrase("Loan Heads ", subHeadingFont));
		table.addCell(cellHead);
		
		//Emi start date
//	 	cellHead.setPhrase(new Phrase("Emi start date", subHeadingFont));
//		table.addCell(cellHead);
		 
		cellHead.setPhrase(new Phrase("Emi start date", subHeadingFont));
		table.addCell(cellHead);
		
		cellHead.setPhrase(new Phrase("Amount", subHeadingFont));
		table.addCell(cellHead);
		cellHead.setPhrase(new Phrase("Remaining Amount", subHeadingFont));
		table.addCell(cellHead);
//		cellHead.setPhrase(new Phrase("Status", subHeadingFont));
//		table.addCell(cellHead);
		
		cellHead.setPhrase(new Phrase("No of Emi", subHeadingFont));
		table.addCell(cellHead);
		cellHead.setPhrase(new Phrase("Narration", subHeadingFont));
		table.addCell(cellHead);
		BigDecimal loanAmount = loanIssueDto.getLoanAmount();
		String loanAmount1 = loanAmount != null && loanAmount.doubleValue() > 0 ? loanAmount.toString() : "";

		BigDecimal loanPendingAmount = loanIssueDto.getLoanPendingAmount();
		String loanPendingAmount1 = loanPendingAmount != null && loanPendingAmount.doubleValue() > 0
				? loanPendingAmount.toString()
				: "";

		Integer noOfEmi = loanIssueDto.getNoOfEmi();
		String noOfEmi1 = noOfEmi != null && noOfEmi.intValue() > 0 ? noOfEmi.toString() : "";

		cellPara.setPhrase(new Phrase("" + loanIssueDto.getLoanTypeLabel(), paraFont));
		table.addCell(cellPara);
		cellPara.setPhrase(new Phrase("" + loanIssueDto.getEmiStartDate(), paraFont));
		table.addCell(cellPara);
		cellPara.setPhrase(new Phrase("" + loanAmount1, paraFont));
		table.addCell(cellPara);

		cellPara.setPhrase(new Phrase("" + loanPendingAmount, paraFont));
		table.addCell(cellPara);

	
		cellPara.setPhrase(new Phrase("" + noOfEmi1, paraFont));
		table.addCell(cellPara);
		cellPara.setPhrase(new Phrase("" + loanIssueDto.getNaration(), paraFont));
		table.addCell(cellPara);
		document.add(table);
	}// loanDetails

	private void loanEmiDetails(LoanIssueDTO loanIssueDto,List<LoanEMIDTO> loanEMIDTOList) throws Exception {
		PdfPCell cellHead = new PdfPCell();
		PdfPCell cellPara = new PdfPCell();
		cellHead.setBorder(Rectangle.NO_BORDER);
		cellHead.setVerticalAlignment(Element.ALIGN_CENTER);
		cellHead.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cellPara.setBorder(Rectangle.NO_BORDER);
		cellPara.setVerticalAlignment(Element.ALIGN_CENTER);
		cellPara.setHorizontalAlignment(Element.ALIGN_RIGHT);

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100.0F);
		table.setSpacingAfter(10.0F);
		cellHead.setPaddingBottom(5);
		cellHead.setPaddingTop(15);
		cellHead.setBorder(Rectangle.NO_BORDER);
		cellHead.setBorder(Rectangle.NO_BORDER);
		cellHead.setBorder(Rectangle.BOTTOM);
		cellHead.setPaddingLeft(2);
		table.setWidthPercentage(100.0F);

		table.setWidths(new float[] { 0.5F,  1.2F, 1.1F, 1.3F, 0.9F });//2...1.1F,3... 1.1F,
		cellHead.setPhrase(new Phrase("S.No.", subHeadingFont));
		table.addCell(cellHead);
//		cellHead.setPhrase(new Phrase("Deduction Date", subHeadingFont));
//		table.addCell(cellHead);
//	 	cellHead.setPhrase(new Phrase("Loan Heads", subHeadingFont));
//		table.addCell(cellHead);
		cellHead.setPhrase(new Phrase("Deduction Date", subHeadingFont));
		table.addCell(cellHead);
		cellHead.setPhrase(new Phrase("Amount", subHeadingFont));
		table.addCell(cellHead);
		cellHead.setPhrase(new Phrase("EMI", subHeadingFont));
		table.addCell(cellHead);
	
		cellHead.setPhrase(new Phrase("Remaining", subHeadingFont));
		table.addCell(cellHead);

		for (LoanEMIDTO loanEMIDto : loanEMIDTOList) {
   			System.out.println("BigDecimal loanIssueDto.getLoanAmount() "+loanEMIDto.getLoanAmount());
			BigDecimal emiLoanAmount = loanEMIDto.getLoanAmount();
			String emiLoanAmount1 = emiLoanAmount != null && emiLoanAmount.doubleValue() > 0 ? emiLoanAmount.toString() : "";
 			BigDecimal emiAmount = loanEMIDto.getEmiAmount();
			String emiAmount1 = emiAmount != null && emiAmount.doubleValue() > 0 ? emiAmount.toString() : "";
 			BigDecimal emiRemaining = loanEMIDto.getRemaining();
			String emiRemaining1 = emiRemaining != null && emiRemaining.doubleValue() > 0 ? emiRemaining.toString()
					: "";
 				cellPara.setPhrase(new Phrase("" + i, paraFont));
				table.addCell(cellPara);
  			String emiStartDate = loanIssueDto.getEmiStartDate() != null ? loanIssueDto.getEmiStartDate().toString()
					: "";
			if (!emiStartDate.equals("")) {
				String[] dOfJos = emiStartDate.split("-");
				if (dOfJos.length > 2)
					emiStartDate = dOfJos[2] + "-" + dOfJos[1] + "-" + dOfJos[0];
			}
 			String emiDate = loanEMIDto.getEmiDate() != null ? loanEMIDto.getEmiDate().toString() : "";
			if (!emiDate.equals("")) {
				String[] dOfJos = emiDate.split("-");
				if (dOfJos.length > 2)
					emiDate = dOfJos[2] + "-" + dOfJos[1] + "-" + dOfJos[0];
			}

	/*		cellPara.setPhrase(new Phrase("" + emiStartDate, paraFont));
			table.addCell(cellPara);
			
			*/

		/*	cellPara.setPhrase(new Phrase("" + loanIssueDto.getLoanTypeLabel(), paraFont));
			table.addCell(cellPara);
*/
			cellPara.setPhrase(new Phrase("" + emiDate, paraFont));
			table.addCell(cellPara);
			cellPara.setPhrase(new Phrase("" + emiLoanAmount1, paraFont));
			table.addCell(cellPara);

			cellPara.setPhrase(new Phrase("" +emiAmount1, paraFont));
			table.addCell(cellPara);

		
			cellPara.setPhrase(new Phrase("" + emiRemaining, paraFont));
			table.addCell(cellPara);
			i=i+1;
 
		}
		
		
		PdfPTable msgTbl = new PdfPTable(1);
		msgTbl.setWidthPercentage(100.0F);
		msgTbl.setWidths(new float[] { 1.0F });
		PdfPCell cellMsg = new PdfPCell();
		cellMsg.setBorder(Rectangle.NO_BORDER);
		cellMsg.setPaddingLeft(2);
		cellMsg.setPaddingTop(37);
		cellMsg.setPhrase(
				new Phrase("This is a computer generated loan statement, does not require seal and signature.", paraFont));
		msgTbl.addCell(cellMsg);
  		
  		document.add(table);
		document.add(msgTbl);
	}
	  public void onStartPage(PdfWriter writer,Document document) {
	    	Rectangle rect = writer.getBoxSize("art");
	        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Top Left"), rect.getLeft(), rect.getTop(), 0);
	        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Top Right"), rect.getRight(), rect.getTop(), 0);
	    }
	    public void onEndPage(PdfWriter writer,Document document) {
	    	Rectangle rect = writer.getBoxSize("art");
	        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Bottom Left"), rect.getLeft(), rect.getBottom(), 0);
	        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase("Bottom Right"), rect.getRight(), rect.getBottom(), 0);
	    }
}
