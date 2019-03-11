package com.csipl.hrms.util;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class UIUtil {

	public static List<String>  sortProcessMonth(List<String> months) {
		List<Date> listDates = new ArrayList<Date>();
		DateFormat format = new SimpleDateFormat("MMM-yyyy", Locale.ENGLISH);
		List<String> sortedMonths = new ArrayList<String>();
		
		if ( months == null ) {
			return sortedMonths;
		}

		for (String month : months) {

			try {
				Date date = format.parse(month);
				listDates.add(date);

			} catch (Exception e) {
			}

		}

		Collections.sort(listDates);

		for (Date date : listDates) {
			String str = format.format(date);
			sortedMonths.add(str);
		}

		return sortedMonths;

	}
	
	public static void main( String s[] ) {
		ArrayList<String> ar=new ArrayList<String>();
		ar.add("JAN-2015");
		ar.add("FEB-2017");
		ar.add("MAR-2017");
		ar.add("APR-2017");
		ar.add("DEC-2015");
		ar.add("FEB-2013");
		
		UIUtil util = new UIUtil();
		List<String> sortedMonths = util.sortProcessMonth(ar);
		
		for ( String month : sortedMonths ) {
			System.out.println("month ====  "+month);
		}

	}

}
