package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.employee.TicketDescDTO;
import com.csipl.hrms.dto.employee.TicketRaisingHdDTO;
import com.csipl.hrms.dto.employee.TicketTypeDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.TicketDesc;
import com.csipl.hrms.model.employee.TicketRaisingHD;
import com.csipl.hrms.model.employee.TicketType;

public class TicketManagementAdaptor implements Adaptor<TicketTypeDTO, TicketType> {
	DateUtils dateUtils = new DateUtils();

	@Override
	public List<TicketType> uiDtoToDatabaseModelList(List<TicketTypeDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TicketTypeDTO> databaseModelToUiDtoList(List<TicketType> ticketTypeList) {
		List<TicketTypeDTO> ticketTypeDtoList = new ArrayList<TicketTypeDTO>();
		for (TicketType ticketType : ticketTypeList) {
			ticketTypeDtoList.add(databaseModelToUiDto(ticketType));
		}
		return ticketTypeDtoList;

	}

	@Override
	public TicketType uiDtoToDatabaseModel(TicketTypeDTO ticketTypeDto) {
		TicketType ticketType = new TicketType();
		ticketType.setCategory(ticketTypeDto.getCategory());
		ticketType.setTicketTypeId(ticketTypeDto.getTicketTypeId());
		ticketType.setEmail(ticketTypeDto.getEmail());
		ticketType.setTat(ticketTypeDto.getTat());
		ticketType.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());

		Company company = new Company();
		company.setCompanyId(ticketTypeDto.getCompanyId());
		ticketType.setCompany(company);
		if (ticketTypeDto.getDateCreated() == null)
			ticketType.setDateCreated(new Date());
		else
			ticketType.setDateCreated(ticketTypeDto.getDateCreated());
		ticketType.setDateUpdate(new Date());
		ticketType.setUserIdUpdate(ticketTypeDto.getUserIdUpdate());
		ticketType.setUserId(ticketTypeDto.getUserId());
		// ticketType.setUserId(1l);
		// ticketType.setDateCreated(ticketTypeDto.getDateCreated());
		return ticketType;
	}

	@Override
	public TicketTypeDTO databaseModelToUiDto(TicketType ticketType) {
		TicketTypeDTO ticketTypeDto = new TicketTypeDTO();
		ticketTypeDto.setTicketTypeId(ticketType.getTicketTypeId());
		ticketTypeDto.setCategory(ticketType.getCategory());
		ticketTypeDto.setEmail(ticketType.getEmail());
		ticketTypeDto.setTat(ticketType.getTat());
		ticketTypeDto.setUserId(ticketType.getUserId());
		ticketTypeDto.setDateCreated(ticketType.getDateCreated());
		return ticketTypeDto;

	}

	public TicketRaisingHD uiDtoToTicketRaisingHdModel(TicketRaisingHdDTO ticketRaisingHdDto) {
		TicketRaisingHD ticketRaisingHD = new TicketRaisingHD();
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		ticketRaisingHD.setTicketRaisingHDId(ticketRaisingHdDto.getTicketRaisingHDId());
		System.out.println("ticketRaisingHdDto.getUserId()---" + ticketRaisingHdDto.getUserId());
		ticketRaisingHD.setUserId(ticketRaisingHdDto.getUserId());
		ticketRaisingHD.setUserIdUpdate(ticketRaisingHdDto.getUserIdUpdate());
		Company company = new Company();
		company.setCompanyId(ticketRaisingHdDto.getCompanyId());
		ticketRaisingHD.setCompany(company);
		if (ticketRaisingHD.getTicketRaisingHDId() == null) {
			ticketRaisingHD.setDateCreated(currentDate);
		} else {
			if (ticketRaisingHdDto.getDateCreated() != null)
				ticketRaisingHD.setDateCreated(dateUtils.getDateWirhYYYYMMDD(ticketRaisingHdDto.getDateCreated()));

		}
		ticketRaisingHD.setDateUpdate(currentDate);
		TicketType ticketType = new TicketType();
		ticketType.setCategory(ticketRaisingHdDto.getCategory());
		ticketType.setTicketTypeId(ticketRaisingHdDto.getTicketTypeId());
		ticketRaisingHD.setTicketType(ticketType);
		Employee employee = new Employee();
		employee.setEmployeeId(ticketRaisingHdDto.getEmployeeId());
		ticketRaisingHD.setEmployee(employee);
		ticketRaisingHD.setTitle(ticketRaisingHdDto.getTitle());

		if (ticketRaisingHdDto.getTicketNo() != null) {
			ticketRaisingHD.setTicketNo(ticketRaisingHdDto.getTicketNo());
			System.out.println(ticketRaisingHdDto.getStatus());
			ticketRaisingHD.setStatus(ticketRaisingHdDto.getStatus());
		} else {
			System.out.println("=====open");
			ticketRaisingHD.setStatus("Open");
		}
		ticketRaisingHD.setUserId(ticketRaisingHdDto.getUserId());

		ticketRaisingHD.setTicketDescs(uiDtoToTicketDescList(ticketRaisingHdDto.getTicketDescs(), ticketRaisingHD));
		return ticketRaisingHD;
	}

	public List<TicketDesc> uiDtoToTicketDescList(List<TicketDescDTO> ticketDescDtolist,
			TicketRaisingHD ticketRaisingHD) {
		List<TicketDesc> ticketDescList = new ArrayList<TicketDesc>();
		for (TicketDescDTO ticketDescDto : ticketDescDtolist) {
			ticketDescList.add(uiDtoToDatabaseTicketDescModel(ticketDescDto, ticketRaisingHD));
		}

		return ticketDescList;
	}

	private TicketDesc uiDtoToDatabaseTicketDescModel(TicketDescDTO ticketDescDto, TicketRaisingHD ticketRaisingHD) {
		TicketDesc ticketDesc = new TicketDesc();
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		ticketDesc.setTicketDescId(ticketDescDto.getTicketDescId());
		if (ticketRaisingHD.getTicketRaisingHDId() != null)
			ticketDesc.setStatus(ticketDescDto.getStatus());
		else {

			ticketDesc.setStatus("Open");
		}
		ticketDesc.setDescription(ticketDescDto.getDescription());
		Employee employee = new Employee();
		employee.setEmployeeId(ticketDescDto.getEmployeeId());
		ticketDesc.setEmployee(employee);
		ticketDesc.setTicketRaisingHd(ticketRaisingHD);
		System.out.println("ticketDescDto.getUserId()---" + ticketDescDto.getUserId());
		ticketDesc.setUserId(ticketRaisingHD.getUserId());
		ticketDesc.setUserIdUpdate(ticketRaisingHD.getUserIdUpdate());
		if (ticketDesc.getTicketDescId() == null)
			ticketDesc.setDateCreated(currentDate);
		else if (ticketDescDto.getDateCreated() != null)
			ticketDesc.setDateCreated(dateUtils.getDateWirhYYYYMMDD(ticketDescDto.getDateCreated()));
		return ticketDesc;
	}

	public List<TicketRaisingHdDTO> databaseModelTicketRaisingDtoList(List<TicketRaisingHD> ticketRaisingHDList) {
		List<TicketRaisingHdDTO> ticketRaisingDtoList = new ArrayList<TicketRaisingHdDTO>();
		for (TicketRaisingHD ticketRaising : ticketRaisingHDList) {
			ticketRaisingDtoList.add(databaseModelToTicketRaisingDto(ticketRaising));
		}
		return ticketRaisingDtoList;

	}

	public TicketRaisingHdDTO databaseModelToTicketRaisingDto(TicketRaisingHD ticketRaisingHd) {
		TicketRaisingHdDTO ticketRaisingHdDto = new TicketRaisingHdDTO();
		List<TicketDescDTO> ticketDecsDtoList = new ArrayList<TicketDescDTO>();
		ticketRaisingHdDto.setTicketRaisingHDId(ticketRaisingHd.getTicketRaisingHDId());
		ticketRaisingHdDto.setTitle(ticketRaisingHd.getTitle());
		ticketRaisingHdDto.setStatus(ticketRaisingHd.getStatus());
		ticketRaisingHdDto.setDateCreated(dateUtils.getDateStringWirhYYYYMMDD(ticketRaisingHd.getDateCreated()));
		ticketRaisingHdDto.setUserId(ticketRaisingHd.getUserId());
		ticketRaisingHdDto.setTicketNo(ticketRaisingHd.getTicketNo());
		ticketRaisingHdDto.setUserIdUpdate(ticketRaisingHd.getUserIdUpdate());
		// ticketRaisingHdDto.setTicketTypeId(ticketRaisingHd.getTicketTypeId());
		ticketRaisingHdDto.setTicketTypeId(ticketRaisingHd.getTicketType().getTicketTypeId());
		ticketRaisingHdDto.setEmployeeId(ticketRaisingHd.getEmployee().getEmployeeId());
		ticketRaisingHdDto.setEmployeeCode(ticketRaisingHd.getEmployee().getEmployeeCode());
		ticketRaisingHdDto.setEmployeeName(
				ticketRaisingHd.getEmployee().getFirstName() + " " + ticketRaisingHd.getEmployee().getLastName());
		ticketRaisingHdDto.setCategory(ticketRaisingHd.getTicketType().getCategory());
		ticketRaisingHdDto.setTat(ticketRaisingHd.getTicketType().getTat());
		// System.out.println(ticketRaisingHdDto.getTat());
		int i = 0;
		for (TicketDesc ticketDecs : ticketRaisingHd.getTicketDescs()) {
			TicketDescDTO ticketDecsDto = new TicketDescDTO();
			String fileName = null;
			ticketDecsDto.setTicketDescId(ticketDecs.getTicketDescId());
			ticketDecsDto.setDescription(ticketDecs.getDescription());
			ticketDecsDto.setDateCreated(dateUtils.getDateStringWirhYYYYMMDD(ticketDecs.getDateCreated()));
			ticketDecsDto.setEmployeeName(
					ticketDecs.getEmployee().getFirstName() + " " + ticketDecs.getEmployee().getLastName());
			ticketDecsDto.setEmployeeId(ticketDecs.getEmployee().getEmployeeId());
			ticketDecsDto.setUserId(ticketDecs.getUserId());
			ticketDecsDto.setStatus(ticketDecs.getStatus());
			ticketDecsDto.setFileLocation(ticketDecs.getFileLocation());
			String ticketNo = ticketRaisingHdDto.getTicketNo();
			fileName = ticketNo.substring(1) + "_" + ticketDecsDto.getTicketDescId() + "."
					+ ticketDecs.getFileExtension();
			ticketDecsDto.setFileName(fileName);
			ticketDecsDtoList.add(ticketDecsDto);
		}
		ticketRaisingHdDto.setTicketDescs(ticketDecsDtoList);
		return ticketRaisingHdDto;

	}

}
