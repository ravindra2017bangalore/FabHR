package com.csipl.hrms.service.util;
 import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
 import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterPageEvent extends PdfPageEventHelper{
    Font ffont = new Font(Font.FontFamily.UNDEFINED, 8, Font.ITALIC);
 	  /*public void onStartPage(PdfWriter writer,Document document) {
	    	 Rectangle rect = writer.getBoxSize("rectangle");
		        Phrase headerLeft = new Phrase("Header left", ffont);
		        Phrase headerRight = new Phrase("Header right", ffont);
		        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER,headerLeft, rect.getLeft(), rect.getTop(), 0);
		        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, headerRight, rect.getRight(), rect.getTop(), 0);
	    }*/
	    public void onEndPage(PdfWriter writer,Document document) {
	    	PdfContentByte cb = writer.getDirectContent();
	    	 Rectangle rect = writer.getBoxSize("rectangle");
 	        Phrase footer = new Phrase("Powered by FABHR", ffont);
	        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,footer,rect.getRight(),  rect.getBottom(), 0);
  	    }
 }
