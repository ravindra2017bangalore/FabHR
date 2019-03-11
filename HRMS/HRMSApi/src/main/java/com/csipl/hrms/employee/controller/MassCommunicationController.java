package com.csipl.hrms.employee.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.employee.MassCommunicationDTO;

import com.csipl.hrms.model.employee.MassCommunication;

import com.csipl.hrms.service.adaptor.MassCommunicationAdaptor;
import com.csipl.hrms.service.employee.MassCommunicationService;

@RestController
@RequestMapping("/massCommunication")
public class MassCommunicationController {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(MassCommunicationController.class);

	@Autowired
	MassCommunicationService massCommunicationService;

	MassCommunicationAdaptor massCommunicationAdaptor = new MassCommunicationAdaptor();

	/**
	 * @param massCommunicationDTO
	 *            This is the first parameter for getting MassCommunication Object
	 *            from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void saveMasscommunicaton(@RequestBody MassCommunicationDTO massCommunicationDTO, HttpServletRequest req) {
		logger.info("saveMasscommunicaton is calling : " + "MassCommunicationDTO : " + massCommunicationDTO);
		MassCommunication massCommunication = massCommunicationAdaptor.uiDtoToDatabaseModel(massCommunicationDTO);
		// boolean newFlag =massCommunication!=null &&
		// massCommunication.getMassCommunicationId() != null ? false:true;
		// editLogInfo(massCommunication, newFlag, req);
		logger.info("saveMasscommunicaton is end  :" + "massCommunication" + massCommunication);
		massCommunicationService.save(massCommunication);
	}

	/**
	 * to get List of MassCommunications from database based on companyId
	 * 
	 * @throws PayRollProcessException
	 */
	@RequestMapping( value="/{companyId}",method = RequestMethod.GET)
	public @ResponseBody List<MassCommunicationDTO> getAllMassCommunications(@PathVariable("companyId") Long companyId,
			HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		List<MassCommunication> massCommunicationList = massCommunicationService.getAllMassCommunications(companyId);
		logger.info("getAllEmployeeFamilyDetails is calling :" + "massCommunicationList" + massCommunicationList);

		if (massCommunicationList != null && massCommunicationList.size() > 0)
			return massCommunicationAdaptor.databaseModelToUiDtoList(massCommunicationList);
		else
			throw new ErrorHandling(" MassCommunication Data not present");
	}
}
