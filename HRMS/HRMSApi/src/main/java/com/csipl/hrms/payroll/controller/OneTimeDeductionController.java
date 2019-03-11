package com.csipl.hrms.payroll.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.dto.payroll.OneTimeDeductionDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.OneTimeDeduction;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.org.controller.ClientController;
import com.csipl.hrms.service.adaptor.OneTimeDeductionAdaptor;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.payroll.OneTimeDeductionService;
import com.csipl.hrms.service.payroll.ReportPayOutService;

@RequestMapping("/onetimededuction")
@RestController
public class OneTimeDeductionController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	@Autowired
	OneTimeDeductionService oneTimeDeductionService;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	ReportPayOutService reportPayOutService;

	OneTimeDeductionAdaptor oneTimeDeductionAdaptor = new OneTimeDeductionAdaptor();

	/**
	 * @param oneTimeDeductionDTO
	 *            This is the first parameter for getting oneTimeDeduction Object
	 *            from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveOneTimeDeduction(@RequestBody OneTimeDeductionDTO oneTimeDeductionDTO, HttpServletRequest req)
			throws ErrorHandling {
		OneTimeDeduction oneTimeDeduction = oneTimeDeductionAdaptor.uiDtoToDatabaseModel(oneTimeDeductionDTO);

		System.out.println("Company id in Onetimededuction==================" + oneTimeDeductionDTO.getCompanyId());

		// userUpdateInfo(oneTimeDeduction, req);
		Long empCount = reportPayOutService.checkPayrollOfEmployee(oneTimeDeductionDTO.getEmployeeId(),
				oneTimeDeductionDTO.getDeductionMonth());
		if (empCount != null && empCount > 0)
			throw new ErrorHandling("Deduction already done of this employee for this process month");
		else
			oneTimeDeductionService.save(oneTimeDeduction);
	}

	/**
	 * Set user info
	 * 
	 * @param oneTimeDeduction
	 * @param req
	 */
	// public void userUpdateInfo(OneTimeDeduction oneTimeDeduction,
	// HttpServletRequest req) {
	//// HttpSession session = req.getSession();
	//// User user = (User) session.getAttribute("User");
	//// Company company = new Company();
	//// company.setCompanyId(user.getCompany().getCompanyId());
	//// oneTimeDeduction.setCompany(company);
	//// oneTimeDeduction.setDateCreated(new Date());
	//// oneTimeDeduction.setUpdateDate(new Date());
	//// oneTimeDeduction.setUserId(user.getUserId());
	//
	//
	//
	// }

	/**
	 * Get complete deduction list
	 * 
	 * @param req
	 * @return
	 * @throws PayRollProcessException
	 * @throws ParseException
	 */
	@RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<OneTimeDeductionDTO> findAllOneTimeDeducTionList(
			@PathVariable("companyId") String companyId, HttpServletRequest req) throws PayRollProcessException {
		Long longCompanyId = Long.parseLong(companyId);
		List<OneTimeDeductionDTO> oneTimeDeductionDTOList = new ArrayList<OneTimeDeductionDTO>();
		List<Object[]> oneTimeDeductionList = oneTimeDeductionService.getAllOneTimeDeduction(longCompanyId);

		for (Object[] report : oneTimeDeductionList) {
			OneTimeDeductionDTO oneTimeDeductionDTO = new OneTimeDeductionDTO();
			String fname = report[0] != null ? (String) report[0] : null;
			String lname = report[1] != null ? (String) report[1] : null;
			String deductionMonth = report[2] != null ? (String) report[2] : null;
			Long deductionId = report[3] != null ? Long.parseLong(report[3].toString()) : null;
			BigDecimal deductionAmount = report[4] != null ? (new BigDecimal(report[4].toString())) : null;
			Long employeeId = report[5] != null ? Long.parseLong(report[5].toString()) : null;
			String departmentName = report[6] != null ? (String) report[6] : null;
			String designationName = report[7] != null ? (String) report[7] : null;
			String employeeCode = report[8] != null ? (String) report[8] : null;
			String remarks = report[9] != null ? (String) report[9] : null;
			Long userId = report[10] != null ? Long.parseLong(report[10].toString()) : null;
			Date dateCreated = report[11] != null ? (Date) (report[11]) : null;
			oneTimeDeductionDTO.setUserId(userId);
			if (dateCreated != null)
				oneTimeDeductionDTO.setDateCreated(dateCreated);
			oneTimeDeductionDTO.setEmployeeId(employeeId);
			oneTimeDeductionDTO.setEmployeeCode(employeeCode);
			oneTimeDeductionDTO.setemployeeName(fname +" "+lname);
			oneTimeDeductionDTO.setLovName("("+employeeCode+") "+fname +" "+lname);

			oneTimeDeductionDTO.setDepartmentName(departmentName);
			oneTimeDeductionDTO.setDesignationName(designationName);
			oneTimeDeductionDTO.setDeductionMonth(deductionMonth);
			oneTimeDeductionDTO.setDeductionAmount(deductionAmount);
			oneTimeDeductionDTO.setDeductionId(deductionId);
			oneTimeDeductionDTO.setRemarks(remarks);
			oneTimeDeductionDTOList.add(oneTimeDeductionDTO);
		}
		return oneTimeDeductionDTOList;
	}

	/**
	 * One time deduction bulk upload
	 * 
	 * @param file
	 * @param oneTimeDeductionDto
	 * @param req
	 * @return
	 * @throws IOException
	 * @throws PayRollProcessException
	 * @throws ErrorHandling
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = {
			"multipart/form-data" })
	public ErrorHandling oneTimeDeuctionBulkUpload(@RequestPart("uploadFile") MultipartFile file,
			@RequestPart("info") OneTimeDeductionDTO oneTimeDeductionDto, HttpServletRequest req)
			throws IOException, PayRollProcessException, ErrorHandling {
		ErrorHandling error = new ErrorHandling();
		StringBuffer sb = new StringBuffer();
		String delim = ", ";
		Long longCompanyId = oneTimeDeductionDto.getCompanyId();
		Long userId = oneTimeDeductionDto.getUserId();
		List<OneTimeDeduction> oneTimeDeductionList = csvReaderFile(createCsvFile(file),
				oneTimeDeductionDto.getDeductionMonth(), longCompanyId, userId, req);
		for (OneTimeDeduction oneTimeDeduction : oneTimeDeductionList) {
			Long empCount = reportPayOutService.checkPayrollOfEmployee(oneTimeDeduction.getEmployee().getEmployeeId(),
					oneTimeDeduction.getDeductionMonth());
			if (empCount == 0) {
				oneTimeDeductionService.saveOneTimeDeductionBulk(oneTimeDeductionList);
				error.setErrorMessage("Deductions uploaded successfully");
			} else
				sb.append(oneTimeDeduction.getEmployee().getEmployeeCode() + delim);
		}
		if (sb.length() > 0) {
			System.out.println("if : " + sb.length());
			throw new ErrorHandling(
					"Deduction already done of employee code " + sb.toString() + " for this process month");
		}
		return error;
	}

	/**
	 * Read data from file
	 * 
	 * @param file
	 * @param processMonth
	 * @param req
	 * @return
	 * @throws PayRollProcessException
	 * @throws ErrorHandling
	 */
	public List<OneTimeDeduction> csvReaderFile(File file, String processMonth, Long longCompanyId, Long userId,
			HttpServletRequest req) throws PayRollProcessException, ErrorHandling {
		List<OneTimeDeduction> oneTimeDeductionList = new ArrayList<>();
		/*
		 * HttpSession session = req.getSession(); User user = (User)
		 * session.getAttribute("User");
		 */
		StringBuffer sb = new StringBuffer();
		String delim = ", ";
		try {
			@SuppressWarnings("resource")
			CSVParser parser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT.withHeader());
			String employeeCode = null, deductionAmount = null, remarks = null;
			for (CSVRecord record : parser) {
				employeeCode = record.get("Employee Code");
				deductionAmount = record.get("Amount deducted");
				remarks = record.get("Remarks");
				Employee employee = employeePersonalInformationService.findEmployees(employeeCode,longCompanyId);
				if (employee != null) {
					OneTimeDeduction oneTimeDeduction = new OneTimeDeduction();
					Company company = new Company();
					company.setCompanyId(longCompanyId);
					oneTimeDeduction.setUserId(userId);
					oneTimeDeduction.setCompany(company);
					oneTimeDeduction.setDateCreated(new Date());
					oneTimeDeduction.setUpdateDate(new Date());
					oneTimeDeduction.setEmployee(employee);
					oneTimeDeduction.setDeductionAmount(new BigDecimal(deductionAmount));
					oneTimeDeduction.setRemarks(remarks);
					oneTimeDeduction.setDeductionMonth(processMonth);
					oneTimeDeductionList.add(oneTimeDeduction);

				} else {
					sb.append(employeeCode + delim);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (sb.length() > 0)
			throw new ErrorHandling("Employee code " + sb.toString() + "not entered correctly");

		return oneTimeDeductionList;

	}

	public static File createCsvFile(MultipartFile file) {
		String csvFileName = "OneTimeDeductionUpload";
		File dir = new File(
				File.pathSeparator + HrmsGlobalConstantUtil.APP_BASE_FOLDER + File.pathSeparator + "BulkUpload");
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

	@RequestMapping(path = "/payrollEmployee", method = RequestMethod.GET)
	public @ResponseBody OneTimeDeductionDTO checkPayrollOfEmployee(@PathVariable("employeeId") String employeeId,
			@PathVariable("deductionMonth") String deductionMonth, HttpServletRequest req)
			throws PayRollProcessException {
		Long empId = Long.parseLong(employeeId);
		OneTimeDeductionDTO oneTimeDeductionDTO = new OneTimeDeductionDTO();
		Long count = reportPayOutService.checkPayrollOfEmployee(empId, deductionMonth);
		if (count > 0)
			oneTimeDeductionDTO.setFlag(true);
		else
			oneTimeDeductionDTO.setFlag(false);

		System.out.println("=====Flag Value : ======" + oneTimeDeductionDTO.isFlag());
		return oneTimeDeductionDTO;
	}
}
