package com.csipl.hrms.org.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.common.services.dropdown.DropDownHdService;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.MandatoryInfoDTO;
import com.csipl.hrms.dto.payrollprocess.ReportPayOutSalaryDTO;
import com.csipl.hrms.model.BaseModelWithoutGroup;
import com.csipl.hrms.model.common.City;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.MandatoryInfo;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.MandatoryInfoAdaptor;
import com.csipl.hrms.service.organization.MandatoryInfoService;
import com.csipl.hrms.service.util.SalaryPdfReport;

@RestController
public class MandatoryInfoController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(MandatoryInfoController.class);

	MandatoryInfoAdaptor mandatoryInfoAdaptor = new MandatoryInfoAdaptor();
	@Autowired
	DropDownHdService dropDownHdService;

	@Autowired
	MandatoryInfoService mandatoryInfoService;

	/**
	 * to get List of MandatoryInfo object from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping(path = "/mandatoryInfoDd", method = RequestMethod.GET)
	public @ResponseBody List<MandatoryInfoDTO> getMandatoryInfoDd(@RequestParam("companyId") String companyId,
			HttpServletRequest req) throws PayRollProcessException {
		logger.info("getMandatoryInfoDd is calling : ");
		Long longcompanyId = Long.parseLong(companyId);
		List<MandatoryInfo> records = mandatoryInfoService.find(longcompanyId);

		DrowpdownHd mandatoryInfoDrowpdownHd = dropDownHdService
				.findDropDownById(DropDownEnum.MandatoryInfo.drowpdownId);

		return mandatoryInfoAdaptor.dropDownToUiDto(mandatoryInfoDrowpdownHd, records);
	}

	/**
	 * Method performed save operation
	 * 
	 * @param mandatoryInfoDtoList
	 *            This is the first parameter for getting list of MandatoryInfo
	 *            Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(value = "/mandatoryInfo", method = RequestMethod.POST)
	public void save(@RequestBody List<MandatoryInfoDTO> mandatoryInfoDtoList, HttpServletRequest req)
			throws ErrorHandling, Exception {
		Date oldDate = null;
		Long oldID = null;
		Long companyId = null;
		Long userIdUpdate = null;
		/*
		 * HttpSession session = req.getSession(); User user = (User)
		 * session.getAttribute("User");
		 */
		logger.info("save MandatoryInfoDTO is calling : MandatoryInfoDTOList " + mandatoryInfoDtoList);

		for (MandatoryInfoDTO mandatoryInfDto : mandatoryInfoDtoList) {

			oldID = mandatoryInfDto.getUserId();
			oldDate = mandatoryInfDto.getDateCreated();
			companyId = mandatoryInfDto.getCompanyId();
			userIdUpdate = mandatoryInfDto.getUserIdUpdate();
		}
		logger.info("oldID=mandatoryInfDto.getUserId(); " + oldID);
		logger.info("oldDate=mandatoryInfDto.getDateCreated();" + oldDate);
		DrowpdownHd dropDowns = dropDownHdService.findDropDownById(DropDownEnum.MandatoryInfo.drowpdownId);

		List<MandatoryInfoDTO> mandatoryInfoDdDtos = mandatoryInfoAdaptor.dropDownToUiDto(dropDowns);
		if (mandatoryInfoService.findInfoAndDelete(companyId) == null) {
			List<MandatoryInfo> mandatoryInfoList = mandatoryInfoAdaptor.uiDtoToDatabaseModelList(mandatoryInfoDdDtos,
					mandatoryInfoDtoList);

			for (MandatoryInfo mandatoryInfo : mandatoryInfoList) {
				Company company = new Company();
				company.setCompanyId(companyId);
				mandatoryInfo.setCompany(company);
				mandatoryInfo.setUserIdUpdate(userIdUpdate);
				mandatoryInfo.setDateUpdate(new Date());
				mandatoryInfo.setEffectiveStartDate(new Date());
				mandatoryInfo.setActiveStatus("AC");
				if (oldDate != null && oldID != null) {
					System.out.println("-----------------Not Null Case-------------");
					mandatoryInfo.setDateCreated(oldDate);
					mandatoryInfo.setUserId(oldID);
				} else {
					System.out.println("----------------- Null Case-------------");
					mandatoryInfo.setDateCreated(new Date());
					mandatoryInfo.setUserId(userIdUpdate);
				}

			}
			logger.info("save is end :mandatoryInfoList " + mandatoryInfoList);

			mandatoryInfoService.saveAll(mandatoryInfoList);

		}

	}

}
