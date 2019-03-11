package com.csipl.tms.leave.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.tms.dto.leave.TMSLeaveTypeDTO;
import com.csipl.tms.leave.adaptor.LeaveTypeAdaptor;
import com.csipl.tms.leave.service.LeaveTypeService;
import com.csipl.tms.model.leave.TMSLeaveType;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

@RestController
@RequestMapping("/leaveType")
public class LeaveTypeController {

	private static final Logger logger = LoggerFactory.getLogger(LeaveTypeController.class);

	@Autowired
	LeaveTypeService leaveTypeService;

	LeaveTypeAdaptor leaveTypeAdaptor = new LeaveTypeAdaptor();

	@RequestMapping(path = "save/{leavePeriodId}", method = RequestMethod.POST)
	public TMSLeaveTypeDTO saveLeaveType(@RequestBody TMSLeaveTypeDTO leaveTypeDTO,
			@PathVariable("leavePeriodId") Long leavePeriodId) {
		logger.info("saveLeaveType is calling : leaveTypeDto " + leaveTypeDTO);
		TMSLeaveType leaveType = leaveTypeAdaptor.leaveuiDtoToDatabaseModel(leaveTypeDTO, leavePeriodId);
             return leaveTypeAdaptor.databaseModelToUiDto(leaveTypeService.save(leaveType));
	}

	@RequestMapping(path = "searchLeave/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<TMSLeaveTypeDTO> getleaveTypeList(@PathVariable("companyId") Long companyId)
			throws Exception {
		logger.info(" getleaveTypeList is calling companyId >>:" + companyId);
		List<TMSLeaveType> leaveType = leaveTypeService.findAllLeaveType(companyId);
		if (leaveType != null) {
			List<TMSLeaveTypeDTO> leaveTypeHdDTO = leaveTypeAdaptor.databaseModelToUiDtoList(leaveType);
			return leaveTypeHdDTO;
		}
		else
			throw new Exception("Leave List not");
	}

	@RequestMapping(value = "search/{leaveTypeId}", method = RequestMethod.GET)
	public @ResponseBody TMSLeaveTypeDTO getLeaveTypeById(@PathVariable("leaveTypeId") Long leaveTypeId) {
		logger.info("getLeaveRule is calling : ");

		TMSLeaveType tmsLeaveType = leaveTypeService.getLeaveTypeById(leaveTypeId);
		// logger.info("getHalfDayRule is end :" + tmsLeaveType.toString());
		return leaveTypeAdaptor.databaseModelToUiDto(tmsLeaveType);
	}

	

	@RequestMapping(value = "findByLeavePeroid/{leavePeriodId}", method = RequestMethod.GET)
	public @ResponseBody List<TMSLeaveTypeDTO> findByLeavePeroid(@PathVariable("leavePeriodId") Long leavePeriodId)
			throws Exception {
		logger.info(" getAllLeavePeriodIdList    is calling leavePeriodId >>:" + leavePeriodId);
		List<TMSLeaveType> leaveType = leaveTypeService.findAllLeavePeriod(leavePeriodId);
		if (leaveType != null) {
			List<TMSLeaveTypeDTO> leaveTypeHdDTO = leaveTypeAdaptor.databaseModelToUiDtoList(leaveType);
			return leaveTypeHdDTO;
		}
		else
			throw new Exception("leavePeriodId  not");
	}
}



