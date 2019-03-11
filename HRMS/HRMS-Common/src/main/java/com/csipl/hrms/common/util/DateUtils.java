package com.csipl.hrms.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {

	private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat df_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final DateFormat MMMdateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	private static final DateFormat DBdateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private static DateFormat DBdateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	  final static DateFormat formater1 = new SimpleDateFormat("MMM-yyyy");

	public Date getCurrentDate() {

		Date dateobj = new Date();
		String today = df.format(dateobj);
		Date currentDate = null;
		try {
			currentDate = df.parse(today);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return currentDate;

	}

	public Timestamp getCurrentDateWithTimestamp()  {
		Date dateobj = new Date();
		System.out.println("dateobj"+dateobj);
 		Date date = null;

		try {
			date = (Date) df_time.parse(getDateStringWirhYYYYMMDD1(dateobj));
		} catch (ParseException e) {
 			e.printStackTrace();
		}
 		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}
	
	public Timestamp getCurrentDateWithTimestamp(String dateStr)  {
 		Date date = null;
		try {
			date = (Date) df.parse(dateStr);
		} catch (ParseException e) {
 			e.printStackTrace();
		}
 		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}

	public String getCurrentDateTime() {

		Date dateobj = new Date();

		// formatting Date with time information
		DBdateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		String date = DBdateFormat1.format(dateobj);
		System.out.println("Today in dd-MM-yy:HH:mm:SS : " + date);

		return date;

	}

	public String getDateStringWirhYYYYMMDD(Date date) {
		String dateStr = df.format(date);

		return dateStr;
	}
	
	
	public String getDateStringWirhYYYYMMDD1(Date date) {
		String dateStr = df_time.format(date);

		return dateStr;
	}
	
	public static Date getDateForProcessMonth (String processMonth) {
		
		Date date = null;
		try {
			date = formater1.parse(processMonth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return date;
	}


	public Date getDateWirhYYYYMMDD(String dateStr) {
		System.out.println("dateStr is :" + dateStr + "----" + df.toString());
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return date;
	}

	public int getYear(Date date) {
		return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date)).getYear();
	}

	public int getMonth(Date date) {
		return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date)).getMonthValue();
	}

	public int getDate(Date date) {
		return LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date)).getDayOfMonth();

	}

	public static int findMonthDay(int year, int month) {

		Map<Integer, Integer> monthDays = new HashMap<Integer, Integer>();
		monthDays.put(1, 31);
		monthDays.put(3, 31);
		monthDays.put(4, 30);
		monthDays.put(5, 31);
		monthDays.put(6, 30);
		monthDays.put(7, 31);
		monthDays.put(8, 31);
		monthDays.put(9, 30);
		monthDays.put(10, 31);
		monthDays.put(11, 30);
		monthDays.put(12, 31);
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0))
			monthDays.put(2, 29);
		else
			monthDays.put(2, 28);
		return monthDays.get(month);
	}

	public static String createDate(String inputString, String month, int year) {

		int days = 0;
		System.out.println(inputString);
		// String inputString = "01-JAN-2018";

		try {
			Date inputDate = MMMdateFormat.parse(inputString);
			days = DateUtils.findMonthDay(inputDate.getYear(), inputDate.getMonth() + 1);
			// days= inputDate.getMonth().minLength();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String date = "01-" + month + "-" + year + "  to  " + days + "-" + month + "-" + year;
		return date;
	}

	public static String getMonthOfProcess(Date inputDate) {
		DateFormat mmm = new SimpleDateFormat("MMM");
		String month = mmm.format(inputDate);
		return month.trim();
	}

	public static String getYearOfProcess(Date inputDate) {
		DateFormat mmm = new SimpleDateFormat("YYYY");
		String year = mmm.format(inputDate);
		return year.trim();
	}

	/**
	 * 
	 * @param date
	 * @return
	 */

	public static Calendar toCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static Date getPayMonth(String processMonth) {
		String year = processMonth.substring(processMonth.indexOf("-") + 1, processMonth.length());
		String month = processMonth.substring(0, processMonth.indexOf("-"));
		String dateInString = null;
		Date dt = null;
		try {
			Date date = new SimpleDateFormat("MMMM").parse(month);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int monthumber = cal.get(Calendar.MONTH) + 1;
			int day = findMonthDay(Integer.parseInt(year), monthumber);
			dateInString = day + "-" + monthumber + "-" + year;
			dt = DBdateFormat.parse(dateInString);

		} catch (ParseException e) {

			e.printStackTrace();
		}
		return dt;
	}

	public static void main(String s[]) {
		/*
		 * Date dt = new Date(); String year = DateUtils.getYearOfProcess( dt );
		 * System.out.println( " date  =====  "+year );
		 */

		String processMonth = "APR-2018";
		// String year = processMonth.substring( processMonth.indexOf("-")+1,
		// processMonth.length() );
		// String month = processMonth.substring( 0, processMonth.indexOf("-") );

		Date dt = getDateForProcessMonth(processMonth);
		System.out.println( " dt == "+dt);

	}
	//getDateDiffInDDMMYYYY
	public static String getDateTdsDif(Date from, Date currentDate) {
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();
		fromDate.setTime(from);
		toDate.setTime(currentDate);
		int increment = 0;
		int year, month, day;
		if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH)) {
			increment = fromDate.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		// DAY CALCULATION
		if (increment != 0) {
			day = (toDate.get(Calendar.DAY_OF_MONTH) + increment) - fromDate.get(Calendar.DAY_OF_MONTH);
			increment = 1;
		} else {
			day = toDate.get(Calendar.DAY_OF_MONTH) - fromDate.get(Calendar.DAY_OF_MONTH);
		}
		// MONTH CALCULATION
		if ((fromDate.get(Calendar.MONTH) + increment) > toDate.get(Calendar.MONTH)) {
			month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + increment);
			increment = 1;
		} else {
			month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + increment);
			increment = 0;
		}
		// YEAR CALCULATION
		year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);
		
		return year+","+month+","+day;
	}
	

	public static String getDateDifferenceInDDMMYYYY(Date from, Date currentDate) {
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();
		fromDate.setTime(from);
		toDate.setTime(currentDate);
		int increment = 0;
		int year, month, day;
		if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH)) {
			increment = fromDate.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		// DAY CALCULATION
		if (increment != 0) {
			day = (toDate.get(Calendar.DAY_OF_MONTH) + increment) - fromDate.get(Calendar.DAY_OF_MONTH);
			increment = 1;
		} else {
			day = toDate.get(Calendar.DAY_OF_MONTH) - fromDate.get(Calendar.DAY_OF_MONTH);
		}
		// MONTH CALCULATION
		if ((fromDate.get(Calendar.MONTH) + increment) > toDate.get(Calendar.MONTH)) {
			month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + increment);
			increment = 1;
		} else {
			month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + increment);
			increment = 0;
		}
		// YEAR CALCULATION
		year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);
		return year + " Years " + month + " Months " + day + " Days";
	}

	public static int getAgeCalaulation(Date from, Date currentDate) {
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();
		fromDate.setTime(from);
		toDate.setTime(currentDate);
		int increment = 0;
		int year;
		// YEAR CALCULATION
		year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);
		return year;
	}

	
	
	public  int getAgeCalaulationInstance(Date from, Date currentDate) {
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();
		fromDate.setTime(from);
		toDate.setTime(currentDate);
		int increment = 0;
		int year;
		// YEAR CALCULATION
		year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);
		return year;
	}
	
	
	public static String getDateFormat(Long noticeDate) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(strDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DATE, noticeDate.intValue());
		String strNoticeDate = dateFormat.format(cal.getTime());
		return strNoticeDate;
	}

	/**
	 * subtract days to date
	 * 
	 * @param date
	 *            ,It is first parameter it will get date input
	 * @param days
	 *            , It is second parameter it will get no. of days to subtractDays
	 *            in date
	 * @return
	 */
	public static Date subtractDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
		return cal.getTime();
	}
	
	public static Date dateToDateConvWithYYYYMMDD(Date date) {
		// Setting the pattern yyyyy-MM-dd hh:mm:ss
	    SimpleDateFormat sm = new SimpleDateFormat("yyyyy-MM-dd hh:mm:ss");
	    // date is the java.util.Date in yyyy-MM-dd format
	    // Converting it into String using formatter
	    String strDate = sm.format(date);
	    //Converting the String back to java.util.Date
	    Date dateEnd=null;
	    try {
	    	dateEnd = sm.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  		return dateEnd;
	}
	
	public static Date asDate(LocalDate localDate) {
	    return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	  }

	  public static Date asDate(LocalDateTime localDateTime) {
	    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	  }

	  public static LocalDate asLocalDate(Date date) {
	    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	  }

	  public static LocalDateTime asLocalDateTime(Date date) {
	    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	  }

		public static String getDateStringWithYYYYMMDD(Date date) {
			String dateStr = formater1.format(date);

			return dateStr;
		}
		public static String dateFormate(Date date) {
			String newDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
	 		return newDate;
	 	}
		
}
