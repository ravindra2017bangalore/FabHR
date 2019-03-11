package com.csipl.hrms.payroll.controller;

import com.csipl.hrms.service.adaptor.InvestmentAdaptor;
import com.csipl.hrms.service.adaptor.OtherIncomeAdaptor;
import com.csipl.hrms.service.adaptor.PreviousEmployerIncomeAdaptor;
import com.csipl.hrms.service.adaptor.TdsApprovedAdaptor;
import com.csipl.hrms.service.adaptor.TdsTransactionAdaptor;
import com.csipl.hrms.service.adaptor.TdsTransactionFileAdaptor;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.employee.PayStructureService;
import com.csipl.hrms.service.payroll.FinancialYearService;
import com.csipl.hrms.service.payroll.InvestmentService;
import com.csipl.hrms.service.payroll.OtherIncomeService;
import com.csipl.hrms.service.payroll.PreviousEmployerIncomeService;
import com.csipl.hrms.service.payroll.TdsApprovalService;
import com.csipl.hrms.service.payroll.TdsStandardExemptionService;
import com.csipl.hrms.service.payroll.TdsTransactionFileService;
import com.csipl.hrms.service.payroll.TdsTransactionService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

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
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.payroll.InvestmentDTO;
import com.csipl.hrms.dto.payroll.OtherIncomeDTO;
import com.csipl.hrms.dto.payroll.PreviousEmployerIncomeTdsDTO;
import com.csipl.hrms.dto.payroll.TdsGroupDTO;
import com.csipl.hrms.dto.payroll.TdsTransactionDTO;
import com.csipl.hrms.dto.payroll.TdsTransactionFileDTO;
import com.csipl.hrms.dto.payroll.TransactionApprovedHdDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.OtherIncome;
import com.csipl.hrms.model.payroll.PreviousEmployerIncomeTds;
import com.csipl.hrms.model.payroll.TdsGroup;
import com.csipl.hrms.model.payroll.TdsSection;
import com.csipl.hrms.model.payroll.TdsStandardExemption;
import com.csipl.hrms.model.payroll.TdsTransaction;
import com.csipl.hrms.model.payroll.TdsTransactionFile;
import com.csipl.hrms.model.payroll.TransactionApprovedHd;
import com.csipl.hrms.model.payrollprocess.FinancialYear;
import com.csipl.hrms.model.payrollprocess.PayOut;

@RequestMapping("/investment")
@RestController
public class InvestmentController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(InvestmentController.class);
	DateUtils dateUtils = new DateUtils();

	@Autowired
	InvestmentService investmentService;

	@Autowired
	FinancialYearService financialYearService;

	@Autowired
	TdsApprovalService tdsApprovalService;

	@Autowired
	TdsTransactionService tdsTransactionService;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	TdsTransactionFileService tdsTransactionFileService;

	@Autowired
	OtherIncomeService otherIncomeService;

	@Autowired
	TdsStandardExemptionService tdsStandardExemptionService;

	@Autowired
	PayStructureService payStructureService;

	@Autowired
	PreviousEmployerIncomeService previousEmployerIncomeService;

	InvestmentAdaptor investmentAdaptor = new InvestmentAdaptor();
	TdsTransactionAdaptor tdsTransactionAdaptor = new TdsTransactionAdaptor();
	TdsApprovedAdaptor tdsApprovedAdaptor = new TdsApprovedAdaptor();
	TdsTransactionFileAdaptor tdsTtansactionFileAdaptor = new TdsTransactionFileAdaptor();
	OtherIncomeAdaptor otherIncomeAdaptor = new OtherIncomeAdaptor();
	PreviousEmployerIncomeAdaptor previousEmployerIncomeAdaptor = new PreviousEmployerIncomeAdaptor();

	/**
	 * @param tdsGroupDto
	 *            This is the first parameter for getting tdsGroup Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveInvestment(@RequestBody TdsGroupDTO tdsGroupDto, HttpServletRequest req) {
		TdsGroup tdsGroup = new TdsGroup();
		if (tdsGroupDto.getTdsGroupId() == null)
			tdsGroup = investmentAdaptor.uiDtoToDatabaseModel(tdsGroupDto);
		else {
			Long tdsGroupId = tdsGroupDto.getTdsGroupId();
			TdsGroup tdsGroupUpdate = investmentService.getInvestment(tdsGroupId);
			tdsGroup = investmentAdaptor.uiDtoToDatabaseModel(tdsGroupDto);
			tdsGroup.setTdsGroupId(null);
			for (TdsSection tdsSection : tdsGroup.getTdsSections()) {
				tdsSection.setTdsSectionId(null);
			}
			tdsGroupUpdate.setEffectiveEndDate(dateUtils.getDateWirhYYYYMMDD(tdsGroupDto.getEffectiveStartDate()));
			investmentService.save(tdsGroupUpdate);
		}
		investmentService.save(tdsGroup);
	}

	/**
	 * to get List of Investment Objects from database
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<InvestmentDTO> findAllInvestment(@RequestParam("companyId") Long companyId,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		List<TdsGroup> tdsGroupList = investmentService.getInvestmentList(companyId);
		if (tdsGroupList != null)
			return investmentAdaptor.databseModelToInvestmentDtoList(tdsGroupList);
		else
			throw new ErrorHandling("Tds entry not found in system");
	}

	/**
	 * to get TdsGroup Object from database based on tdsGroupId (Primary Key)
	 */
	@RequestMapping(value = "/getInvestment/{tdsGroupId}", method = RequestMethod.GET)
	public @ResponseBody TdsGroupDTO findInvestment(@PathVariable("tdsGroupId") String tdsGroupId,
			HttpServletRequest req) {
		Long longTdsGroupId = Long.parseLong(tdsGroupId);
		return investmentAdaptor.databaseModelToUiDto(investmentService.getInvestment(longTdsGroupId));
	}

	/**
	 * to get List of TdsTransaction Objects from database based on employeeId and
	 * companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/tdsTransaction", method = RequestMethod.GET)
	public @ResponseBody List<TdsTransactionDTO> getTdsTransactionList(@RequestParam("employeeId") String employeeId,
			@RequestParam("companyId") Long companyId, HttpServletRequest req) throws PayRollProcessException {
		Long empId = Long.parseLong(employeeId);
		List<TdsTransactionDTO> tdsTransactionDtoList = tdsTransactionAdaptor
				.databaseModelToObjectArray(tdsTransactionService.getTdsTransactionObjectList(empId, companyId));
		return tdsTransactionDtoList;
	}

	/**
	 * @param employeeId
	 *            This is the first parameter for getting employeeId from UI
	 * @param tdsTransactionDtoList
	 *            This is the second parameter for getting List of tdsTransaction
	 *            objects from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/tdsTransaction", method = RequestMethod.POST)
	public void saveTdsTransaction(@RequestParam("employeeId") String employeeId,
			@RequestParam("companyId") Long companyId, @RequestBody List<TdsTransactionDTO> tdsTransactionDtoList,
			HttpServletRequest req) throws PayRollProcessException {

		Long empId = Long.parseLong(employeeId);
		List<TdsTransaction> tdsTransactionList = tdsTransactionAdaptor
				.uiDtoToTdsTransactionModelList(tdsTransactionDtoList, empId);
		List<TdsTransaction> tdsTransactionList1 = new ArrayList<TdsTransaction>();
		List<TdsTransaction> tdsTransactionListOld = tdsTransactionService.getTdsTransactionList(empId, companyId);

		tdsTransactionList.forEach(tdsTransaction -> {
			// no investment found
			if (tdsTransaction.getTdsTransactionId() == null && tdsTransaction.getInvestmentAmount() == null) {

			} else if (tdsTransaction.getTdsTransactionId() == null) {
				System.out.println("tdsTransaction.getTdsTransactionId()");
				tdsTransaction.setStatus("Pending");
				tdsTransactionList1.add(tdsTransaction);
				// boolean newFlag = tdsTransaction == null ||
				// tdsTransaction.getTdsTransactionId() == null;
				// editLogInfoWithoutCG(tdsTransaction, newFlag, req);
			} else {
				if (tdsTransaction.getInvestmentAmount() == null)
					tdsTransaction.setInvestmentAmount(new BigDecimal(0.0));
				for (TdsTransaction tdsTransactionOld : tdsTransactionListOld) {

					if (tdsTransactionOld.getTdsTransactionId().equals(tdsTransaction.getTdsTransactionId())) {
						System.out
								.println("tdsTransactionOld comparation start" + tdsTransactionOld.getInvestmentAmount()
										+ "---------------" + tdsTransaction.getInvestmentAmount());
						System.out.println("-----" + tdsTransactionOld.getInvestmentAmount()
								.compareTo(tdsTransaction.getInvestmentAmount()));
						if (tdsTransactionOld.getInvestmentAmount()
								.compareTo(tdsTransaction.getInvestmentAmount()) == 0)
							System.out.println("tdsTransactionOld.getInvestmentAmount()");
						else
							tdsTransaction.setStatus("Pending");

						tdsTransactionList1.add(tdsTransaction);
						// boolean newFlag = tdsTransaction == null ||
						// tdsTransaction.getTdsTransactionId() == null;
						// editLogInfoWithoutCG(tdsTransaction, newFlag, req);
					}
				} // end inner for
			}
		});

		tdsTransactionService.save(tdsTransactionList1, empId, companyId);
	}

	/**
	 * @param employeeId
	 *            This is the first parameter for getting employeeId from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 * @param file
	 *            This is the third parameter for getting file Input from UI
	 * @param tdsTransactionDto
	 *            This is the forth parameter for getting tdsTransaction object from
	 *            UI
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/tdsTransactionFile", method = RequestMethod.POST)
	public void saveTdsTransactionFile(@RequestParam("employeeId") String employeeId, HttpServletRequest req,
			@RequestPart("uploadDocument") MultipartFile file,
			@RequestPart("info") TdsTransactionFileDTO tdsTransactionFileDto) throws ErrorHandling {
		Long empId = Long.parseLong(employeeId);
		TdsTransactionFile tdsTransactionFile = tdsTtansactionFileAdaptor
				.uiDtoToTdsTransactionFileModel(tdsTransactionFileDto, empId);
		/*
		 * boolean newFlag = tdsTransactionFile == null ||
		 * tdsTransactionFile.getTdsTransactionFileId() == null; //
		 * editLogInfoWithoutCG(tdsTransactionFile, newFlag, req); //
		 * List<TdsTransactionFile> //
		 * tdsTransactionFileList=tdsTransactionFileService.getTdsTransactionFiles(empId
		 * );
		 */ tdsTransactionFileService.saveTdsTransactionFile(tdsTransactionFile, empId, file);
	}

	@RequestMapping(path = "/tdsTransactionFile", method = RequestMethod.GET)
	public @ResponseBody List<TdsTransactionFileDTO> gettdsTransactionFiles(
			@RequestParam("employeeId") String employeeId, HttpServletRequest req) throws ErrorHandling {
		System.out.println("Tds Transaction file controller");
		Long empId = Long.parseLong(employeeId);
		List<TdsTransactionFile> tdsTransactionFileList = tdsTransactionFileService.getTdsTransactionFiles(empId);
		if (tdsTransactionFileList != null)
			return tdsTtansactionFileAdaptor.databaseModelToUiDtoList(tdsTransactionFileList);
		else
			throw new ErrorHandling("Tds transaction files not uploaded");
	}

	@RequestMapping(path = "/tdsTransactionFile", method = RequestMethod.DELETE)
	public void deleteEmpIdProof(@RequestParam("tdsTranactionFileId") String tdsTranactionFileId,
			HttpServletRequest req) {
		Long id = Long.parseLong(tdsTranactionFileId);
		tdsTransactionFileService.delete(id);
	}

	/**
	 * @param employeeId
	 *            This is the first parameter for getting employeeId from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 * 
	 * @throws PayRollProcessException
	 */

	@RequestMapping(path = "/tdsDeclaration", method = RequestMethod.POST)

	public void tdsApproval(@RequestParam("employeeId") String employeeId, @RequestParam("status") String status,
			@RequestParam("companyId") Long companyId, @RequestParam("userId") Long userId, HttpServletRequest req)
			throws PayRollProcessException {

		logger.info("tdsDeclaration is calling employeeId :" + employeeId + "status is :" + status);
		// HttpSession session = req.getSession();
		// User user = (User) session.getAttribute("User");
		// logger.info("user : " + user);
		// Long userId = user.getUserId();
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		Long empId = Long.parseLong(employeeId);

		logger.info("Employee PayStrure Information.." + currentDate + "company id" + companyId);

		List<PayOut> payOutList = payStructureService.processPayroll(companyId, empId);
		TdsStandardExemption tdsStandardExemption = tdsStandardExemptionService.getTdsStandardExemption(companyId);
		List<OtherIncome> otherIncomeList = otherIncomeService.findOtherIncomes(empId, companyId);
		Employee employee = employeePersonalInformationService.findEmployeesById(empId);

		logger.info("payOutList " + payOutList + "tdsStandardExemption : " + tdsStandardExemption + "otherIncomeList :"
				+ otherIncomeList + "employee" + employee);

		// tds declaration process required data gethering----
		FinancialYear financialYear = financialYearService.findCurrentFinancialYear(currentDate, companyId);
		List<TdsGroup> tdsGroupList = investmentService.getInvestmentList(companyId);
		List<TdsTransaction> tdsTrasactionist = tdsTransactionService.getTdsTrasactionListforApproval(empId,
				financialYear.getFinancialYear());

		logger.info("financialYear " + financialYear + "tdsGroupList : " + tdsGroupList + "tdsTrasactionist :"
				+ tdsTrasactionist + "getCompanyId" + companyId);

		// tds declaration approved amount calculation-----
		TransactionApprovedHd transactionApprovedHd = tdsApprovalService.createTdsApprovals(tdsGroupList,
				tdsTrasactionist, employee, companyId, financialYear, status);
		boolean newFlag = transactionApprovedHd == null || transactionApprovedHd.getTransactionApprovedHdId() == null;
		// editLogInfoWithoutCG(transactionApprovedHd, newFlag, req);

		transactionApprovedHd.setDateUpdate(new Date());
		transactionApprovedHd.setUserIdUpdate(userId);
		if (newFlag) {
			transactionApprovedHd.setDateCreated(new Date());
			transactionApprovedHd.setUserId(userId);
		}
		logger.info("transactionApprovedHd" + transactionApprovedHd);

		// Actual tds calculation
		tdsApprovalService.saveTdsApprovalsList(transactionApprovedHd, employee, financialYear, companyId, userId,
				payOutList, tdsStandardExemption, otherIncomeList, false, tdsTrasactionist);
	}

	@RequestMapping(path = "/tdsApproval", method = RequestMethod.GET)
	public @ResponseBody TransactionApprovedHdDTO gettdsApproved(@RequestParam("employeeId") String employeeId,
			@RequestParam("companyId") Long companyId, HttpServletRequest req)
			throws ErrorHandling, PayRollProcessException {
		Long empId = Long.parseLong(employeeId);
		TransactionApprovedHd transactionApprovedHd = tdsApprovalService.getTdsApproved(empId, companyId);
		if (transactionApprovedHd != null)
			return tdsApprovedAdaptor.databaseModelToUiDto(transactionApprovedHd);
		else
			throw new ErrorHandling("Tds not yet approved");
	}

	@RequestMapping(path = "/otherIncome", method = RequestMethod.POST)
	public List<OtherIncomeDTO> saveOtherIncome(@RequestParam("employeeId") String employeeId,
			@RequestParam("companyId") Long companyId, @RequestBody List<OtherIncomeDTO> otherIncomeDtoList,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		Long empId = Long.parseLong(employeeId);
		List<OtherIncome> otherIncomeList = otherIncomeAdaptor.uiDtoToOtherIncomeList(otherIncomeDtoList, empId);
		otherIncomeList.forEach(otherIncome -> {
			otherIncome.setStatus("Pending");
			// boolean newFlag = otherIncome == null || otherIncome.getOtherIncomeId() ==
			// null;
			// editLogInfoWithoutGroup(otherIncome, newFlag, req);
		});
		List<OtherIncome> otherIncomeListResult = otherIncomeService.save(otherIncomeList, companyId);
		return otherIncomeAdaptor.databaseModelToUiDtoList(otherIncomeListResult);
	}

	@RequestMapping(path = "/otherIncome", method = RequestMethod.GET)
	public @ResponseBody List<OtherIncomeDTO> findOtherIncomes(@RequestParam("employeeId") String employeeId,
			@RequestParam("companyId") Long companyId, HttpServletRequest req) throws PayRollProcessException {
		Long empId = Long.parseLong(employeeId);
		return otherIncomeAdaptor.databaseModelToUiDtoList(otherIncomeService.findOtherIncomes(empId, companyId));
	}

	@RequestMapping(path = "/tdsPreviousEmployerIncome", method = RequestMethod.GET)
	public @ResponseBody List<PreviousEmployerIncomeTdsDTO> getPreviousEmployerIncomeList(
			@RequestParam("employeeId") String employeeId, @RequestParam("companyId") Long companyId,
			HttpServletRequest req) throws PayRollProcessException {
		logger.info("PreviousIncome employeeId - " + employeeId);
		Long empId = Long.parseLong(employeeId);
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		FinancialYear financialYear = financialYearService.findCurrentFinancialYear(currentDate, companyId);
		List<PreviousEmployerIncomeTdsDTO> previousEmployerIncomeTdsDtoList = previousEmployerIncomeAdaptor
				.databaseModelToObjectArray(previousEmployerIncomeService.getPreviousEmployerIncomeObjectList(empId,
						financialYear.getFinancialYear()));
		return previousEmployerIncomeTdsDtoList;
	}

	@RequestMapping(path = "/tdsPreviousEmployerIncome", method = RequestMethod.POST)
	public void savePreviousEmployerIncomeList(@RequestParam("employeeId") String employeeId,
			@RequestBody List<PreviousEmployerIncomeTdsDTO> PreviousEmployerIncomeTdsDtoList,
			@RequestParam("companyId") Long companyId, HttpServletRequest req) throws PayRollProcessException {
		logger.info("PreviousIncome employeeId - " + employeeId);
		Long empId = Long.parseLong(employeeId);
		List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsList = previousEmployerIncomeAdaptor
				.uiDtoToDatabaseModelList(PreviousEmployerIncomeTdsDtoList, empId);

		List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsList1 = new ArrayList<PreviousEmployerIncomeTds>();

		List<PreviousEmployerIncomeTds> previousEmployerIncomeTdsListOld = previousEmployerIncomeService
				.getPreviousEmployerIncomeList(empId, companyId);

		previousEmployerIncomeTdsList.forEach(previousEmployerIncomeTds -> {
			if (previousEmployerIncomeTds.getPreviousEmployerIncomeTdsId() == null
					&& previousEmployerIncomeTds.getAmount() == null) {

			} else if (previousEmployerIncomeTds.getPreviousEmployerIncomeTdsId() == null) {
				previousEmployerIncomeTdsList1.add(previousEmployerIncomeTds);
				// boolean newFlag = previousEmployerIncomeTds == null
				// || previousEmployerIncomeTds.getPreviousEmployerIncomeTdsId() == null;
				// editLogInfoWithoutCG(previousEmployerIncomeTds, newFlag, req);
			} else {
				if (previousEmployerIncomeTds.getAmount() == null)
					previousEmployerIncomeTds.setAmount(new BigDecimal(0.0));
				for (PreviousEmployerIncomeTds previousEmployerIncomeTdsOld : previousEmployerIncomeTdsListOld) {

					if (previousEmployerIncomeTdsOld.getPreviousEmployerIncomeTdsId()
							.equals(previousEmployerIncomeTds.getPreviousEmployerIncomeTdsId())
							&& previousEmployerIncomeTdsOld.getAmount()
									.compareTo(previousEmployerIncomeTds.getAmount()) != 0) {

						previousEmployerIncomeTdsList1.add(previousEmployerIncomeTds);
						// boolean newFlag = previousEmployerIncomeTds == null
						// || previousEmployerIncomeTds.getPreviousEmployerIncomeTdsId() == null;
						// editLogInfoWithoutCG(previousEmployerIncomeTds, newFlag, req);
					}
				} // end inner for
			}
		});
		previousEmployerIncomeService.save(previousEmployerIncomeTdsList1, companyId);
	}
}
