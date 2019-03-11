package com.csipl.hrms.org.controller;

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

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.CompanyDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.org.BaseController;
import com.csipl.hrms.service.adaptor.CompanyAdaptor;
import com.csipl.hrms.service.organization.CompanyService;
import com.csipl.hrms.service.organization.StorageService;

@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	CompanyAdaptor companyAdaptor = new CompanyAdaptor();

	@Autowired
	CompanyService companyService;
	@Autowired
	StorageService storageService;

	/**
	 * Method performed save operation with file
	 * 
	 * @param file
	 *            This is the first parameter for taking file Input
	 * @param companyDto
	 *            This is the second parameter for getting company Object from UI
	 * @param req
	 *            This is the third parameter to maintain user session
	 */
	@RequestMapping(value = "/file", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void saveCompany(@RequestPart("uploadFile") MultipartFile file, @RequestPart("info") CompanyDTO companyDto,
			HttpServletRequest req) {
		logger.info("saveCompany is calling : " + " : CompanyDTO " + companyDto + ":uploadFile" + file);

		/*
		 * HttpSession session = req.getSession(); User user = (User)
		 * session.getAttribute("User");
		 */
		Company company = companyAdaptor.uiDtoToDatabaseModel(companyDto);
		companyService.save(company, file, true);
		logger.info("saveCompany is end  :" + company);
	}

	/**
	 * Method performed save operation without any file
	 * 
	 * @param companyDto
	 *            This is the first parameter for getting company Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody CompanyDTO companyDto, HttpServletRequest req) {
		logger.info("saveCompany is calling : " + " : CompanyDTO " + companyDto);
		/*HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");*/
		Company company = companyAdaptor.uiDtoToDatabaseModel(companyDto);
		logger.info("Company  : " + company );
		//setUserProfileForCompany(company, user);
		companyService.save(company, null, false);
		logger.info("saveCompany is end  :" + company);
	}

	/**
	 * to get Company object from database based on companyId (primary key)
	 */
	@RequestMapping(path = "/{companyId}", method = RequestMethod.GET)
	public @ResponseBody CompanyDTO getCompany(@PathVariable("companyId") String companyId, HttpServletRequest req) {
		logger.info("saveCompany is calling : ");
		Long longcompanyId = Long.parseLong(companyId);
		/*
		 * HttpSession session = req.getSession(); User user = (User)
		 * session.getAttribute("User");
		 */
		Company company = companyService.getCompany(longcompanyId);
		logger.info("getCompany is end  :" + company);
		return companyAdaptor.databaseModelToUiDto(company);
	}

	/**
	 * to get List Company from database based on companyId (primary key)
	 */
	@RequestMapping(value="/{userRoles}/{companyId}",method = RequestMethod.GET)
	public @ResponseBody List<CompanyDTO> findAllCompanys(@PathVariable("userRoles") String userRoles,
			@PathVariable("companyId") String companyId, HttpServletRequest req) throws ErrorHandling {
		logger.info("findAllCompanys is calling : ");
		Long longcompanyId = Long.parseLong(companyId);
		/*
		 * HttpSession session = req.getSession(); User user = (User)
		 * session.getAttribute("User");
		 */
		List<Company> companyList = companyService.getAllCompanys(longcompanyId, userRoles);
		logger.info("findAllCompanys is end :  companyList" + companyList);
		if (companyList != null && companyList.size() > 0)
			return companyAdaptor.databaseModelToUiDtoList(companyList);
		throw new ErrorHandling("Company data not present");
	}

	/**
	 * to maintain user session
	 */
	private void setUserProfileForCompany(Company company, User user) {
		logger.info("setUserProfileForCompany is calling : Company " + company.getCompanyId() + "User" + user);
		logger.info(" Company address1 :" + company.getAddress1().getAddressId());
		logger.info(" Company address2 :" + company.getAddress2().getAddressId());
		if (company.getGroupg() == null) {
			Groupg groupg = new Groupg();
			groupg.setGroupId(1l);
			company.setGroupg(groupg);
		}
		if (company.getCompanyId() == null) {
			company.setUserId(user.getUserId());
			company.setDateCreated(new Date());
		}
		company.setUserIdUpdate(user.getUserId());
		company.setDateUpdate(new Date());
		if (company.getAddress1().getAddressId() != null) {
			company.getAddress1().setUserId(user.getUserId());
			company.getAddress1().setDateCreated(new Date());
		}

		if (company.getAddress2().getAddressId() != null) {
			company.getAddress2().setUserId(user.getUserId());
			company.getAddress2().setDateCreated(new Date());
		}

		company.getAddress1().setUserIdUpdate(user.getUserId());
		company.getAddress1().setDateUpdate(new Date());
	}

}
