package com.csipl.hrms.common.util;

public class FormateUtil {
   public static String ExcelDataPattern(String doubleValue) {
	   String str = doubleValue.toString();
	  // System.out.println(str);
	   int lenght =str.length();
	  // System.out.println(str.substring(str.indexOf(".")+1, lenght));
	   int len =(str.substring(str.indexOf(".")+1, lenght)).length();
	   String  strValue = str.substring(str.indexOf(".")+1, lenght);
	    if (len==0 || strValue.charAt(0)==0) {
		   return "#.00";
	   }
	   else if (len==1 && strValue.charAt(0)!=0) {
		return "#.#0";
	}
	   else {
		   return "#.##";
	   }
   
   }
   
}

