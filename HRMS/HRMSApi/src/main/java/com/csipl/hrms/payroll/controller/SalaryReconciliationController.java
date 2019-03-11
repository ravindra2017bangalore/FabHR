package com.csipl.hrms.payroll.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.AppUtils;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.common.util.SalaryReconciliationCSVReader;
import com.csipl.hrms.dto.payrollprocess.PayOutDTO;
import com.csipl.hrms.model.payrollprocess.PayRollLock;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.service.payroll.PayRollLockService;
import com.csipl.hrms.service.payroll.ReportPayOutService;
import com.csipl.hrms.service.payroll.SalaryReconciliationService;

@RequestMapping("/salaryReconciliation")
@RestController
public class SalaryReconciliationController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(SalaryReconciliationController.class);
	@Autowired
	SalaryReconciliationService salaryReconciliationService;
	@Autowired
	ReportPayOutService reportPayOutService;

	@Autowired
	PayRollLockService payRollLockService;
	/** 
	 * Method performed save operation with attendance attachment file 
	 * @param file
	 *            This is the first parameter for taking file Input
	 * @param payOut
	 *            This is the second parameter for getting payOut Object from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
	public @ResponseBody ErrorHandling salaryReconciliation(@RequestPart("uploadFile") MultipartFile file,
			@RequestPart("info") PayOutDTO payOut, HttpServletRequest req)
			throws PayRollProcessException, IOException {
	    ErrorHandling error = new ErrorHandling();
		/*HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");*/
        Boolean deptFlag=false;
        
		List<String> listEmpCode = new ArrayList<>();
		List<String> listDB = new ArrayList<>();
		List<String> listSalaryCsvExitNotTran = new ArrayList<>();
		List<String> listempwithAccountDB = new ArrayList<String>();
		List<String> listempwithAccountCSV = new ArrayList<String>();
		List<ReportPayOut> report=new ArrayList<ReportPayOut>();
		List<ReportPayOut> reportForSave=new ArrayList<ReportPayOut>();
		HashMap<String,ReportPayOut> mapEmpWithReport= new HashMap<String,ReportPayOut>();
		String processMonth = payOut.getProcessMonth();
		Long departmentId = payOut.getDepartmentId();
		Long longCompanyId = payOut.getCompanyId();
		Long userId = payOut.getUserId();
		
		if(departmentId>0) {
			deptFlag=true;
	      report = salaryReconciliationService.fetchEmpDetailsForSalaryReconciliation(processMonth,departmentId);
		}
		else {
		report = salaryReconciliationService.fetchEmpDetailsForSalRecoAllDept(processMonth,longCompanyId);
		}
		
		System.out.println("========report======="+report.size());
		try {
			if (report.size() > 0) {
				for (ReportPayOut reportPayout : report) {

					mapEmpWithReport.put(reportPayout.getEmployeeCode(), reportPayout);
					listDB.add(reportPayout.getEmployeeCode());
					listempwithAccountDB
							.add(reportPayout.getEmployeeCode().trim() + "#" + reportPayout.getAccountNumber().trim());
				}
			} else {

				error.setMessage(HrmsGlobalConstantUtil.ERROR_MESSAGE);
				return error;

			}
		} catch (Exception e) {
			error.setMessage(HrmsGlobalConstantUtil.ERROR_MESSAGE);
			return error;
		}
		SalaryReconciliationCSVReader.parseCSV(AppUtils.createCsvFile(file), report,reportForSave,mapEmpWithReport, listempwithAccountCSV, listEmpCode,
				listSalaryCsvExitNotTran, userId);
		
		Collection<String> similarEmpWithAcc = new HashSet<String>(listempwithAccountDB);
		Collection<String> differentEmpWithAcc = new HashSet<String>();
		differentEmpWithAcc.addAll(listempwithAccountDB);
		differentEmpWithAcc.addAll(listempwithAccountCSV);
		similarEmpWithAcc.retainAll(listempwithAccountDB);
		differentEmpWithAcc.removeAll(similarEmpWithAcc);
		Collection<String> similar = new HashSet<String>(listEmpCode);
		Collection<String> different = new HashSet<String>();
		different.addAll(listDB);
		different.addAll(listEmpCode);
		similar.retainAll(listDB);
		System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", listEmpCode, listDB, similar, different);
		System.out.printf("One:%s%nTwo:%s%nSimilar:%s%nDifferent:%s%n", listempwithAccountCSV, listempwithAccountDB,
				similarEmpWithAcc, differentEmpWithAcc);
		if (different.size() > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append(" System can't upload  file due to mismatch of employ code : \n ");
			builder.append(" Mismatch employee Codes are " + different);

			throw new PayRollProcessException(builder.toString());
		} else if (listSalaryCsvExitNotTran.size() > 0) {

			StringBuilder builder = new StringBuilder();
			builder.append(" System can't upload  file due to not exit transaction code .Do Yor want to Proceed : \n ");
			builder.append(" Mismatch Employee Transaction Codes are " + listSalaryCsvExitNotTran);
			throw new PayRollProcessException(builder.toString());
		} else if (differentEmpWithAcc.size() > 0) {

			StringBuilder builder = new StringBuilder();
			builder.append(" System can't upload  file due to not exit Account Number .Do Yor want to Proceed : \n ");
			builder.append(" Mismatch Employee Transaction Codes are " + differentEmpWithAcc);
			throw new PayRollProcessException(builder.toString());

		} else {
			PayRollLock  prl= new PayRollLock();
			List<PayRollLock> listPrl = new ArrayList<PayRollLock>();
			List<PayRollLock> listPrlSave = new ArrayList<PayRollLock>();
			if(deptFlag) {
			 prl= payRollLockService.findpayRollLock(processMonth,departmentId);
			 prl.setIsPayRollLocked("false");
			 prl.setUserId(userId);
			 prl.setDateCreated(new DateUtils().getCurrentDate());
			 salaryReconciliationService.save(reportForSave,prl);
			  error.setMessage(HrmsGlobalConstantUtil.SUCCESSFULLY_MESSAGE);
			}else {
				listPrl= payRollLockService.findpayRollLock(processMonth);	
				for(PayRollLock p:listPrl) {
					p.setIsPayRollLocked("false");
					p.setUserId(userId);
					p.setDateCreated(new DateUtils().getCurrentDate());
					listPrlSave.add(p);
					
				}
				salaryReconciliationService.save(reportForSave,listPrlSave);
			   error.setMessage(HrmsGlobalConstantUtil.SUCCESSFULLY_MESSAGE);
			}
			
             return error;
			
		}
		

	}


}