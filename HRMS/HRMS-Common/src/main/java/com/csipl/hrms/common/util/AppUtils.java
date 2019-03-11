package com.csipl.hrms.common.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.model.common.Company;

import com.csipl.hrms.model.payrollprocess.Attendance;
import com.csipl.hrms.model.payrollprocess.AttendancePK;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Component
@PropertySource("classpath:application.properties")
@Configuration
public class AppUtils {
	private static final Logger logger = LoggerFactory.getLogger(AppUtils.class);

	private static final Random generator = new Random();
	InputStream in = null;

	public static final String baseurl = "http://apivm.valuemobo.com/SMS/SMS_ApiKey.asmx/SMS_APIKeyNUC?";
	//public static final String url = "http://10.1.1.100:8081/candidate";
	//public static final String url = "http://localhost:8080/candidate";
	//public static final String url ="http://10.1.1.100:8081/candidate/#/candidateRegistration?candidateId=";

	public static final String url ="http://localhost:8080/candidate/#/candidateRegistration?candidateId=";

	public static final String apikey = "rvRHvT8LG6U9h1B";
	public static final String msgtext = "";
	public static final String senderid = "CSIPLI";

	/*public Integer generateOtp(String key) {

		int otp = 100000 + generator.nextInt(900000);
		otpCache.put(key, otp);
		return otp;
	}
*/
	public List<String> csvReaderFile(File file, Map<String, Attendance> csvEmployees, String processMonth, long userId,
			long companyId, long departmentId, long payRollDays, StringBuffer sb) throws PayRollProcessException {

		List<String> listCsv = new ArrayList<>();
		try {
			CSVParser parser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT.withHeader());

			String payDays = null, absense = null, employeeCode = null, employeeName = null, presense = null,
					srno = null;
			String weekoff = null, publicholidays = null, paidleave = null, casualleave = null, seekleave = null;
			String csvProcessMonth = null;
			
			for (CSVRecord record : parser) {

				srno = record.get("SNo");
				payDays = record.get("Today days in Month").trim();

				absense = record.get("Absent");
				employeeCode = record.get("Employee Code").trim();
				sb.append("'").append(employeeCode + "',");
				employeeName = record.get("Employee Name");
				presense = record.get("Present");
				weekoff = record.get("Week Off");
				publicholidays = record.get("Public Holiday");
				paidleave = record.get("Earned Leave");
				casualleave = record.get("Casual Leave");
				seekleave = record.get("Seek Leave");
				csvProcessMonth = record.get("Process month");
				Attendance attendance = new Attendance();
				Company company = new Company();
				company.setCompanyId(companyId);
				attendance.setUserId(userId);
				attendance.setCompany(company);

				if (payDays != null && !payDays.trim().equals("")) {
					int dayOfMonth = Integer.parseInt(payDays);

					if (payRollDays != dayOfMonth) {
						throw new PayRollProcessException(
								"PayDays is not equal to system pay roll days : " + payRollDays);
					}
				} else {
					throw new PayRollProcessException("PayDays is not equal to system pay roll days : " + payRollDays);
				}

				if (csvProcessMonth != null && !csvProcessMonth.trim().equals("")) {

					if (!csvProcessMonth.equalsIgnoreCase(processMonth)) {
						logger.info("processMonth is not equal to system configure month : ", processMonth);
						throw new PayRollProcessException(
								"processMonth is not equal to system configure month : " + processMonth);
					}
				} else {
					logger.info(
							"processMonth is not equal to system configure month when csvProcessMonth is not available in csv  : ",
							processMonth);
					throw new PayRollProcessException(
							"processMonth is not equal to system configure month : " + processMonth);
				}

				/*
				 * if ( departmentId > 0) { Department department = new Department();
				 * department.setDepartmentId(departmentId);
				 * attendance.setDepartment(department); }
				 */

				attendance.setDateCreated(new Date());
				attendance.setSrno(Integer.parseInt(srno));

				AttendancePK pk = new AttendancePK();
				pk.setEmployeeCode(employeeCode);
				pk.setProcessMonth(processMonth);
				attendance.setId(pk);

				attendance.setEmployeeName(employeeName);
				attendance.setPresense(new BigDecimal(presense));
				attendance.setWeekoff(new BigDecimal(weekoff));
				attendance.setPublicholidays(new BigDecimal(publicholidays));
				attendance.setPaidleave(new BigDecimal(paidleave));
				attendance.setCasualleave(new BigDecimal(casualleave));
				attendance.setSeekleave(new BigDecimal(seekleave));
				attendance.setAbsense(new BigDecimal(absense));
				attendance.setPayDays(new BigDecimal(payDays));

				/*
				 * if(departmentId>0) { Department department=new Department();
				 * department.setDepartmentId(departmentId);
				 * attendance.setDepartment(department); }
				 */
				csvEmployees.put(employeeCode, attendance);
				listCsv.add(employeeCode);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listCsv;

	}

	public HashMap<String, ArrayList<EmployeeDTO>> createMapFromDB(List<EmployeeDTO> empDB) {
		HashMap<String, ArrayList<EmployeeDTO>> hashMap = new HashMap<String, ArrayList<EmployeeDTO>>();
		HashMap<String, ArrayList<EmployeeDTO>> hashMapErrorObj = new HashMap<String, ArrayList<EmployeeDTO>>();

		
		for (EmployeeDTO emp : empDB) {

			if (emp.getDepartmentId() != null && emp.getBankId() != null && emp.getPayStructureHdId() != null) {
				ArrayList<EmployeeDTO> empDto = new ArrayList<>();
				empDto.add(emp);
				hashMap.put(emp.getEmployeeCode(), empDto);
			}
		}
		// System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", listCsv,
		// listDB, similar, different);
		return hashMap;
	}

	public String sendOtpBySms(String message, String mobileNumber) {

		String url = null;
		String stst = null;

		try {

			url = baseurl + "&apiKey=" + URLEncoder.encode(apikey, "UTF-8") + "&cellNoList="
					+ URLEncoder.encode(mobileNumber, "UTF-8") + "&msgtext=" + URLEncoder.encode(message, "UTF-8")
					+ "&senderid=" + URLEncoder.encode(senderid, "UTF-8");
			System.out.println("=======url=" + url);

		} catch (Exception ex) {

			ex.printStackTrace();
		}

		stst = getUrlData(url);

		return stst;

	}

	public static String getUrlData(String url_val) {

		String websiteData = null;

		try {
			// System.setProperty("java.net.useSystemProxies", "true");
			// Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.5",
			// 8888));
			// java.net.Proxy proxy = new java.net.Proxy(Type.HTTP, new
			// InetSocketAddress("192.168.1.5", 8888));
			URL url = new URL(url_val);

			URLConnection connection = url.openConnection();
			connection.connect();
			InputStream inputstream = connection.getInputStream();
			websiteData = generateString(inputstream);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return websiteData;
	}

	public static String generateString(InputStream stream) {

		InputStreamReader reader = new InputStreamReader(stream);
		BufferedReader buffer = new BufferedReader(reader);
		StringBuilder sb = new StringBuilder();
		try {
			String cur;
			while ((cur = buffer.readLine()) != null) {
				sb.append(cur + "\n");
			}

		} catch (Exception e) {
		}
		return sb.toString();
	}

	public static File createCsvFile(MultipartFile file) {
		String csvFileName = "AttandanceXLS";
		File dir = new File(
				File.pathSeparator + HrmsGlobalConstantUtil.APP_BASE_FOLDER + File.pathSeparator + "AttandanceXLS");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File fileCsv = null;
		try {
			fileCsv = File.createTempFile(csvFileName, ".csv", dir);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileCsv));
			stream.write(file.getBytes());
			stream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileCsv;
	}

	public String store(MultipartFile file, String filePath, String fileName) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				rootPath = rootPath + File.separator + HrmsGlobalConstantUtil.APP_BASE_FOLDER + File.separator
						+ filePath; // "\\webapps\\images\\groupImages";
				System.out.println(rootPath);
				File dir = new File(rootPath + File.separator);
				System.out.println(dir);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);
				System.out.println(serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location=" + serverFile.getAbsolutePath());

				return serverFile.getAbsolutePath();
			} catch (Exception e) {
				e.printStackTrace();
				return "You failed to upload " + fileName + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + fileName + " because the file was empty.";
		}
	}

	// private final Path rootLocation = Paths.get("D:\\Photo");
	public Resource loadFile(String filename) {
		try {
			Path file = Paths.get(filename).resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public static File createEmpFile(MultipartFile file) {
		String csvFileName = "empExcel";
		File dir = new File(
				File.pathSeparator + HrmsGlobalConstantUtil.APP_BASE_FOLDER + File.pathSeparator + "AttandanceXLS");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File fileCsv = null;
		try {
			fileCsv = File.createTempFile(csvFileName, ".xls", dir);
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileCsv));
			stream.write(file.getBytes());
			stream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileCsv;
	}

	public static String SHA1(String text) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-1");
			byte[] sha1hash = new byte[40];
			md.update(text.getBytes("iso-8859-1"), 0, text.length());
			sha1hash = md.digest();
			return convertToHex(sha1hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException u) {
			u.printStackTrace();
		}
		return "";
	}

	private static String convertToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}
	
	public static String concatenate(List<String> listOfItems, String separator) {
		StringBuilder sb = new StringBuilder();
		Iterator<String> stit = listOfItems.iterator();

		while (stit.hasNext()) {
			sb.append(stit.next());
			if (stit.hasNext()) {
				sb.append(separator);
			}
		}

		return sb.toString();
	}
	
	
	/**
	 * Checks if is collection empty.
	 *
	 * @param collection the collection
	 * @return true, if is collection empty
	 */
	private static boolean isCollectionEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if is object empty.
	 *
	 * @param object the object
	 * @return true, if is object empty
	 */
	public static boolean isObjectEmpty(Object object) {
		if(object == null) return true;
		else if(object instanceof String) {
			if (((String)object).trim().length() == 0) {
				return true;
			}
		} else if(object instanceof Collection) {
			return isCollectionEmpty((Collection<?>)object);
		}
		return false;
	}
}
