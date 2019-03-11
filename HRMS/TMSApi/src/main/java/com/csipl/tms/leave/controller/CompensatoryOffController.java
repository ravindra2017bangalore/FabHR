package com.csipl.tms.leave.controller;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.services.notification.NotificationServices;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.candidate.CandidateSearchDTO;
import com.csipl.hrms.dto.employee.SeparationDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.Separation;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.dto.common.PageIndex;
import com.csipl.tms.dto.leave.CompOffSearchDTO;
import com.csipl.tms.dto.leave.CompensatoryOffDTO;
import com.csipl.tms.dto.shift.ShiftDTO;
import com.csipl.tms.empcommondetail.service.EmpCommonDetailService;
import com.csipl.tms.leave.adaptor.CompensatoryOffAdaptor;
import com.csipl.tms.leave.service.CompensatoryOffPaginationService;
import com.csipl.tms.leave.service.CompensatoryOffService;
import com.csipl.tms.model.empcommondetails.EmpCommonDetail;
import com.csipl.tms.model.leave.CompensatoryOff;
import com.csipl.tms.model.shift.Shift;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/compensatoryOff")
public class CompensatoryOffController {

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(CompensatoryOffController.class);
	
	int count;
	@Autowired
	private CompensatoryOffService compensatoryOffService;
	
	@Autowired
	private CompensatoryOffPaginationService compensatoryOffPaginationService;
	
	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;
	
	
	
	CompensatoryOffAdaptor compensatoryOffAdaptor=new CompensatoryOffAdaptor();
	
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved Shift"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update shift"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param shiftDto
	 *            This is the first parameter for getting shift Object from UI
	 */
	@ApiOperation(value = "Save or Update CompensatoryOff")
	@RequestMapping( method = RequestMethod.POST)
	public void saveCompensatoryOff(@RequestBody CompensatoryOffDTO compensatoryOffDTO) {
		
		
		logger.info("compensatoryOffDTO is calling : " + " : compensatoryOffDTO " + compensatoryOffDTO);
		CompensatoryOff compensatoryOff = compensatoryOffAdaptor.uiDtoToDatabaseModel(compensatoryOffDTO);
		logger.info("compensatoryOff is end  :" + "compensatoryOff" + compensatoryOff);
		 compensatoryOffService.saveAll(compensatoryOff);
		
		//return  compensatoryOffAdaptor.databaseModelToUiDto(CompensatoryOffResult);CompensatoryOff CompensatoryOffResult =
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the Shift List"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param companyId
	 *            This is the first parameter for getting companyId from UI
	 */
	@ApiOperation(value = "View List of shift based on company ID")
	@RequestMapping(value="/{companyId}",method = RequestMethod.GET)
	public List<CompensatoryOffDTO> CompensatoryOffList(@PathVariable("companyId") Long companyId) {
		logger.info("CompensatoryOffList is calling : " + " : companyId " + companyId);
		
		List<CompensatoryOff> CompensatoryOffList = compensatoryOffService.findAllCompensatoryOff(companyId);
		
		List<CompensatoryOffDTO> CompensatoryOffDTOList = compensatoryOffAdaptor.databaseModelToUiDtoList(CompensatoryOffList);
		
		logger.info("shiftList is end  :" + "shiftDtoList" + CompensatoryOffDTOList);
	
		return CompensatoryOffDTOList;
	}
	
	@RequestMapping(value = "/pending/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<CompensatoryOffDTO> findMyCompOffPendingReqList(@PathVariable("employeeId") Long employeeId ) throws ErrorHandling {
		logger.info("findAllCompOffPending is calling : "+employeeId);
 		List<CompensatoryOff> compOffPendingList = compensatoryOffService.findMyCompOffPendingReqList(employeeId);
		if (compOffPendingList != null)
			return compensatoryOffAdaptor.databaseModelToUiDtoList(compOffPendingList);
		else
			throw new ErrorHandling("No one compOff pending request");

	}
	
	@RequestMapping(value = "/excludedPending/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<CompensatoryOffDTO> findMyCompOffExcludedPendingReqList(@PathVariable("employeeId") Long employeeId ) throws ErrorHandling {
		logger.info("findAllCompOffExcludedPending is calling : "+employeeId);
 		List<CompensatoryOff> compOffExcludedPendingList = compensatoryOffService.findMyCompOffExcludedPendingReqList(employeeId);
		if (compOffExcludedPendingList != null)
			return compensatoryOffAdaptor.databaseModelToUiDtoList(compOffExcludedPendingList);
		else
			throw new ErrorHandling("No one  completed request");

	}
	
	@RequestMapping(value = "/compOffData/{compOffId}", method = RequestMethod.GET)
	public @ResponseBody CompensatoryOffDTO compensatoryOff(@PathVariable("compOffId") String compOffId,
			HttpServletRequest req) {
		Employee approvalEmp = null;
		Employee employeeEmp = null;
		logger.info("compensatoryOff is calling : " + "compOffId :" + compOffId);
		Long tmsCompensantoryOffId = Long.parseLong(compOffId);
		CompensatoryOff compensatoryOff   =compensatoryOffService.getCompensatoryOff(tmsCompensantoryOffId);
		
		if (compensatoryOff.getEmployeeId() != null) {
			Long employeeId = compensatoryOff.getEmployeeId();
			employeeEmp = employeePersonalInformationService.getEmployeeInfo(employeeId);
		}
		if (compensatoryOff.getApprovalId() != null) {
			Long approvalId = compensatoryOff.getApprovalId();
			approvalEmp = employeePersonalInformationService.getEmployeeInfo(approvalId);
		}
		
		CompensatoryOffDTO compensatoryOffDTO = compensatoryOffAdaptor.databaseModelToUiDto(compensatoryOff, employeeEmp, approvalEmp);
		
//		compensatoryOffAdaptor.databaseModelToUiDto(compensatoryOffService.getCompensatoryOff(tmsCompensantoryOffId));
		return compensatoryOffDTO;
	}

	@RequestMapping(value = "/pendingRequest/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<CompensatoryOffDTO> findAllCompOffPendingReqList(@PathVariable("companyId") Long companyId ) throws ErrorHandling {
		logger.info("findAllCompOffPendingReqList is calling : "+companyId);
 		List<CompensatoryOff> compOffPendingList = compensatoryOffService.findAllCompOffPendingReqList(companyId);
		if (compOffPendingList != null)
			return compensatoryOffAdaptor.databaseModelToUiDtoList(compOffPendingList);
		else
			throw new ErrorHandling("No one compOff pending request");

	}
	@RequestMapping(value = "/excludedPendingRequest/{companyId}", method = RequestMethod.GET)
	public @ResponseBody List<CompensatoryOffDTO> findAllCompOffExcludedPendingReqList(@PathVariable("companyId") Long companyId ) throws ErrorHandling {
		logger.info("findAllCompOffExcludedPendingReqList is calling : "+companyId);
 		List<CompensatoryOff> compOffExcludedPendingList = compensatoryOffService.findAllCompOffExcludedPendingReqList(companyId);
		if (compOffExcludedPendingList != null)
			return compensatoryOffAdaptor.databaseModelToUiDtoList(compOffExcludedPendingList);
		else
			throw new ErrorHandling("No one  completed request");

	}
	@GetMapping(value = "/CompOffCount/{companyId}/{pageSize}/{status}")
	public @ResponseBody EntityCountDTO getCompOffCount(@PathVariable("companyId") String companyId,
			@PathVariable("pageSize") String pageSize,@PathVariable("status") boolean status,
			HttpServletRequest req) throws PayRollProcessException {

		List<PageIndex> pageIndexList = new ArrayList<PageIndex>();

		Long longCompanyId = Long.parseLong(companyId);
		int parPageRecord = Integer.parseInt(pageSize);
		EntityCountDTO entityCountDTO = new EntityCountDTO();
		compensatoryOffPaginationService.getCompOffCount(longCompanyId,entityCountDTO,status);
		count = entityCountDTO.getCount();
		System.out.println("Count :" + count);
		int pages = (count + parPageRecord - 1) / parPageRecord;
		System.out.println("Pages : -" + pages);
		for (int i = 1; i <= pages; i++) {
			PageIndex pageIndex = new PageIndex();
			pageIndex.setPageIndex(i);
			pageIndexList.add(pageIndex);
		}
		entityCountDTO.setPageIndexs(pageIndexList);
		entityCountDTO.setCount(count);
		return entityCountDTO;
	}
	@RequestMapping(value = "/compOffList/{status}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CompensatoryOffDTO> getAllCompOffDetails(@PathVariable("status") boolean status,@RequestBody CompOffSearchDTO compOffSearchDTO)
			throws PayRollProcessException {
		logger.info(" Compensatory off is calling  :");

		List<Object[]> compOffList = compensatoryOffPaginationService.findCandidatePagedAndFilterResult(compOffSearchDTO.getCompanyId(), compOffSearchDTO,status);
			

		return compensatoryOffAdaptor.modeltoDTOList(compOffList, compOffSearchDTO);
	}
}
