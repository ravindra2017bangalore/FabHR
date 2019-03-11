package com.csipl.tms.attendanceregularizationrequest.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.tms.dto.attendanceregularizationrequest.AttendanceRegularizationRequestDTO;
import com.csipl.tms.dto.common.SearchDTO;
import com.csipl.tms.model.attendanceregularizationrequest.AttendanceRegularizationRequest;
import com.csipl.tms.service.Adaptor;

public class AttendanceRegularizationRequestAdaptor
		implements Adaptor<AttendanceRegularizationRequestDTO, AttendanceRegularizationRequest> {

	@Override
	public List<AttendanceRegularizationRequest> uiDtoToDatabaseModelList(
			List<AttendanceRegularizationRequestDTO> uiobj) {
		return null;
	}

	@Override
	public List<AttendanceRegularizationRequestDTO> databaseModelToUiDtoList(
			List<AttendanceRegularizationRequest> attendanceRegularizationRequestList) {

		List<AttendanceRegularizationRequestDTO> attendanceRegularizationRequestDtoList = new ArrayList<AttendanceRegularizationRequestDTO>();
		attendanceRegularizationRequestList.forEach(attendanceRegularizationRequest -> {
			attendanceRegularizationRequestDtoList.add(arRequestDetailsModelToUiDto(attendanceRegularizationRequest));
		});
		return attendanceRegularizationRequestDtoList;
	}

	private AttendanceRegularizationRequestDTO arRequestDetailsModelToUiDto(
			AttendanceRegularizationRequest attendanceRegularizationRequest) {
		AttendanceRegularizationRequestDTO arRequestDto = new AttendanceRegularizationRequestDTO();
		arRequestDto.setArID(attendanceRegularizationRequest.getArID());
		arRequestDto.setEmployeeId(attendanceRegularizationRequest.getEmployeeId());
		arRequestDto.setApprovalId(attendanceRegularizationRequest.getApprovalId());
		arRequestDto.setApprovalRemark(attendanceRegularizationRequest.getApprovalRemark());
		arRequestDto.setEmployeeRemark(attendanceRegularizationRequest.getEmployeeRemark());
		arRequestDto.setCancelRemark(attendanceRegularizationRequest.getCancelRemark());
		arRequestDto.setDateCreated(attendanceRegularizationRequest.getDateCreated());
		if (attendanceRegularizationRequest.getArCategory().equals("MP")) {
			arRequestDto.setArCategory("MP");
			arRequestDto.setArCategoryValue(DropDownCache.getInstance().getDropDownValue(
					DropDownEnum.ARCategory.getDropDownName(), attendanceRegularizationRequest.getArCategory()));
		}
		if (attendanceRegularizationRequest.getArCategory().equals("MN")) {
			arRequestDto.setArCategory("MN");
			arRequestDto.setArCategoryValue(DropDownCache.getInstance().getDropDownValue(
					DropDownEnum.ARCategory.getDropDownName(), attendanceRegularizationRequest.getArCategory()));
		}
		if (attendanceRegularizationRequest.getArCategory().equals("CN")) {
			arRequestDto.setArCategory("CN");
			arRequestDto.setArCategoryValue(DropDownCache.getInstance().getDropDownValue(
					DropDownEnum.ARCategory.getDropDownName(), attendanceRegularizationRequest.getArCategory()));
		}
		if (attendanceRegularizationRequest.getArCategory().equals("PC")) {
			arRequestDto.setArCategory("PC");
			arRequestDto.setArCategoryValue(DropDownCache.getInstance().getDropDownValue(
					DropDownEnum.ARCategory.getDropDownName(), attendanceRegularizationRequest.getArCategory()));
		}

		arRequestDto.setActionableDate(attendanceRegularizationRequest.getActionableDate());

		arRequestDto.setFromDate(attendanceRegularizationRequest.getFromDate());
		arRequestDto.setToDate(attendanceRegularizationRequest.getToDate());
		arRequestDto.setDays(attendanceRegularizationRequest.getDays());
		if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.PENDING_CODE)) {
			arRequestDto.setStatus(StatusMessage.PENDING_CODE);
			arRequestDto.setStatusValue(StatusMessage.PENDING_VALUE);
		}
		if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.APPROVED_CODE)) {
			arRequestDto.setStatus(StatusMessage.APPROVED_CODE);
			arRequestDto.setStatusValue(StatusMessage.APPROVED_VALUE);
		}
		if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.REJECTED_CODE)) {
			arRequestDto.setStatus(StatusMessage.REJECTED_CODE);
			arRequestDto.setStatusValue(StatusMessage.REJECTED_VALUE);
		}
		if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.CANCEL_CODE)) {
			arRequestDto.setStatus(StatusMessage.CANCEL_CODE);
			arRequestDto.setStatusValue(StatusMessage.CANCEL_VALUE);
		}

		return arRequestDto;
	}

	@Override
	public AttendanceRegularizationRequest uiDtoToDatabaseModel(
			AttendanceRegularizationRequestDTO attendanceRegularizationRequestDto) {
		AttendanceRegularizationRequest attendanceRegularizationRequest = new AttendanceRegularizationRequest();

		attendanceRegularizationRequest.setEmployeeId(attendanceRegularizationRequestDto.getEmployeeId());
		attendanceRegularizationRequest.setCompanyId(attendanceRegularizationRequestDto.getCompanyId());
		attendanceRegularizationRequest.setArID(attendanceRegularizationRequestDto.getArID());
		attendanceRegularizationRequest.setUserId(attendanceRegularizationRequestDto.getUserId());
		attendanceRegularizationRequest.setUserIdUpdate(attendanceRegularizationRequestDto.getUserIdUpdate());
		attendanceRegularizationRequest.setArCategory(attendanceRegularizationRequestDto.getArCategory());
		if (attendanceRegularizationRequestDto.getApprovalRemark() != null)
			attendanceRegularizationRequest.setApprovalRemark(attendanceRegularizationRequestDto.getApprovalRemark());
		if (attendanceRegularizationRequestDto.getApprovalId() != null) {
			attendanceRegularizationRequest.setApprovalId(attendanceRegularizationRequestDto.getApprovalId());
		}
		attendanceRegularizationRequest.setEmployeeCode(attendanceRegularizationRequestDto.getEmployeeCode());
		attendanceRegularizationRequest.setEmployeeRemark(attendanceRegularizationRequestDto.getEmployeeRemark());
		attendanceRegularizationRequest.setDays(attendanceRegularizationRequestDto.getDays());
		attendanceRegularizationRequest.setFromDate(attendanceRegularizationRequestDto.getFromDate());
		attendanceRegularizationRequest.setToDate(attendanceRegularizationRequestDto.getToDate());
		attendanceRegularizationRequest.setStatus(attendanceRegularizationRequestDto.getStatus());
		attendanceRegularizationRequest.setCancelRemark(attendanceRegularizationRequestDto.getCancelRemark());
		attendanceRegularizationRequest.setDateUpdate(new Date());
		if (attendanceRegularizationRequestDto.getArID() != null)
			attendanceRegularizationRequest.setDateCreated(attendanceRegularizationRequestDto.getDateCreated());
		else
			attendanceRegularizationRequest.setDateCreated(new Date());

		if (attendanceRegularizationRequestDto.getApprovalId() != null) {
			attendanceRegularizationRequest.setActionableDate(new Date());
		}

		return attendanceRegularizationRequest;
	}

	public AttendanceRegularizationRequestDTO arRequestDetailsObjToUiDto(
			AttendanceRegularizationRequest attendanceRegularizationRequest, Employee employeeEmp,
			Employee approvalEmp) {

		AttendanceRegularizationRequestDTO attendanceRegularizationRequestDto = new AttendanceRegularizationRequestDTO();
		if (employeeEmp.getEmployeeCode() != null) {
			attendanceRegularizationRequestDto.setEmployeeCode(employeeEmp.getEmployeeCode());
		}
		if (employeeEmp.getFirstName() != null && employeeEmp.getLastName() != null) {
			attendanceRegularizationRequestDto
					.setEmployeeName(employeeEmp.getFirstName() + " " + employeeEmp.getLastName());
		}
		if (approvalEmp != null) {
			attendanceRegularizationRequestDto.setApprovalByEmpCode(approvalEmp.getEmployeeCode());
			attendanceRegularizationRequestDto
					.setApprovalByEmpName(approvalEmp.getFirstName() + " " + approvalEmp.getLastName());

			attendanceRegularizationRequestDto.setActionableDate(new Date());
			approvalEmp.getDepartment().getDepartmentName();

			attendanceRegularizationRequestDto
					.setApprovalByEmpDepartment(approvalEmp.getDepartment().getDepartmentName());
			attendanceRegularizationRequestDto
					.setApprovalByEmpDesignation(approvalEmp.getDesignation().getDesignationName());
		}

		attendanceRegularizationRequestDto.setArID(attendanceRegularizationRequest.getArID());
		attendanceRegularizationRequestDto.setEmployeeId(attendanceRegularizationRequest.getEmployeeId());
		attendanceRegularizationRequestDto.setApprovalId(attendanceRegularizationRequest.getApprovalId());

		if (attendanceRegularizationRequest.getArCategory().equals("MP")) {
			attendanceRegularizationRequestDto.setArCategory("MP");
			attendanceRegularizationRequestDto.setArCategoryValue(DropDownCache.getInstance().getDropDownValue(
					DropDownEnum.ARCategory.getDropDownName(), attendanceRegularizationRequest.getArCategory()));
		}
		if (attendanceRegularizationRequest.getArCategory().equals("MN")) {
			attendanceRegularizationRequestDto.setArCategory("MN");
			attendanceRegularizationRequestDto.setArCategoryValue(DropDownCache.getInstance().getDropDownValue(
					DropDownEnum.ARCategory.getDropDownName(), attendanceRegularizationRequest.getArCategory()));
		}
		if (attendanceRegularizationRequest.getArCategory().equals("CN")) {
			attendanceRegularizationRequestDto.setArCategory("CN");
			attendanceRegularizationRequestDto.setArCategoryValue(DropDownCache.getInstance().getDropDownValue(
					DropDownEnum.ARCategory.getDropDownName(), attendanceRegularizationRequest.getArCategory()));
		}
		if (attendanceRegularizationRequest.getArCategory().equals("PC")) {
			attendanceRegularizationRequestDto.setArCategory("PC");
			attendanceRegularizationRequestDto.setArCategoryValue(DropDownCache.getInstance().getDropDownValue(
					DropDownEnum.ARCategory.getDropDownName(), attendanceRegularizationRequest.getArCategory()));
		}
		attendanceRegularizationRequestDto.setFromDate(attendanceRegularizationRequest.getFromDate());
		attendanceRegularizationRequestDto.setToDate(attendanceRegularizationRequest.getToDate());
		attendanceRegularizationRequestDto.setDays(attendanceRegularizationRequest.getDays());
		if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.PENDING_CODE)) {
			attendanceRegularizationRequestDto.setStatus(StatusMessage.PENDING_CODE);
			attendanceRegularizationRequestDto.setStatusValue(StatusMessage.PENDING_VALUE);
		}
		if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.APPROVED_CODE)) {
			attendanceRegularizationRequestDto.setStatus(StatusMessage.APPROVED_CODE);
			attendanceRegularizationRequestDto.setStatusValue(StatusMessage.APPROVED_VALUE);
		}
		if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.REJECTED_CODE)) {
			attendanceRegularizationRequestDto.setStatus(StatusMessage.REJECTED_CODE);
			attendanceRegularizationRequestDto.setStatusValue(StatusMessage.REJECTED_VALUE);
		}
		if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.CANCEL_CODE)) {
			attendanceRegularizationRequestDto.setStatus(StatusMessage.CANCEL_CODE);
			attendanceRegularizationRequestDto.setStatusValue(StatusMessage.CANCEL_VALUE);
		}
		attendanceRegularizationRequestDto.setApprovalRemark(attendanceRegularizationRequest.getApprovalRemark());
		attendanceRegularizationRequestDto.setEmployeeRemark(attendanceRegularizationRequest.getEmployeeRemark());

		attendanceRegularizationRequestDto.setCompanyId(attendanceRegularizationRequest.getCompanyId());
		attendanceRegularizationRequestDto.setUserId(attendanceRegularizationRequest.getUserId());
		attendanceRegularizationRequestDto.setDateCreated(attendanceRegularizationRequest.getDateCreated());
		attendanceRegularizationRequestDto.setUserIdUpdate(attendanceRegularizationRequest.getUserIdUpdate());
		attendanceRegularizationRequestDto.setUpdatedDate(attendanceRegularizationRequest.getDateUpdate());

		if (employeeEmp != null) {
			attendanceRegularizationRequestDto
					.setEmployeeDepartment(employeeEmp.getDepartment().getDepartmentName());
			attendanceRegularizationRequestDto
					.setEmployeeDesignation(employeeEmp.getDesignation().getDesignationName());
		}
		attendanceRegularizationRequestDto.setCancelRemark(attendanceRegularizationRequest.getCancelRemark());
		attendanceRegularizationRequestDto.setActionableDate(attendanceRegularizationRequest.getActionableDate());

		return attendanceRegularizationRequestDto;

	}

	public List<AttendanceRegularizationRequestDTO> arModelListToArDtoList(List<Object[]> arRequestList) {
		List<AttendanceRegularizationRequestDTO> arRequestDtoList = new ArrayList<AttendanceRegularizationRequestDTO>();

		for (Object[] arRequest : arRequestList) {
			AttendanceRegularizationRequestDTO arRequestDto = new AttendanceRegularizationRequestDTO();
			Long employeeId = arRequest[1] != null ? Long.parseLong(arRequest[1].toString()) : null;
			Long approvalId = arRequest[2] != null ? Long.parseLong(arRequest[2].toString()) : null;
			String arCategory = arRequest[3] != null ? (String) arRequest[3] : null;
			Date fromDate = arRequest[4] != null ? (Date) (arRequest[4]) : null;
			Date toDate = arRequest[5] != null ? (Date) (arRequest[5]) : null;
			Long day = arRequest[6] != null ? Long.parseLong(arRequest[6].toString()) : null;
			String status = arRequest[7] != null ? (String) arRequest[7] : null;
			Long compnayId = arRequest[10] != null ? Long.parseLong(arRequest[10].toString()) : null;
			Date actionableDate = arRequest[11] != null ? (Date) (arRequest[11]) : null;
			arRequestDto.setEmployeeId(employeeId);
			arRequestDto.setApprovalId(approvalId);
			arRequestDto.setArCategory(arCategory);
			arRequestDto.setFromDate(fromDate);
			arRequestDto.setToDate(toDate);
			arRequestDto.setDays(day);
			arRequestDto.setStatus(status);
			arRequestDto.setCompanyId(compnayId);
			arRequestDto.setActionableDate(actionableDate);
			arRequestDtoList.add(arRequestDto);
		}
		return arRequestDtoList;

	}

	@Override
	public AttendanceRegularizationRequestDTO databaseModelToUiDto(AttendanceRegularizationRequest dbobj) {
		return null;
	}

	public List<AttendanceRegularizationRequestDTO> objarListToObjUiDtoList(List<Object[]> arRequestObjList) {
		List<AttendanceRegularizationRequestDTO> arRequestDtoList = new ArrayList<AttendanceRegularizationRequestDTO>();

		for (Object[] arRequestObj : arRequestObjList) {
			AttendanceRegularizationRequestDTO arRequestDto = new AttendanceRegularizationRequestDTO();
			String empCode = arRequestObj[0] != null ? (String) arRequestObj[0] : null;
			String firstName = arRequestObj[1] != null ? (String) arRequestObj[1] : null;
			String lastName = arRequestObj[2] != null ? (String) arRequestObj[2] : null;
			String departmentName = arRequestObj[3] != null ? (String) arRequestObj[3] : null;
			Long arId = arRequestObj[4] != null ? Long.parseLong(arRequestObj[4].toString()) : null;
			Date dateCreated = arRequestObj[5] != null ? (Date) (arRequestObj[5]) : null;
			String arCatagory = arRequestObj[6] != null ? (String) arRequestObj[6] : null;
			Date actionDate = arRequestObj[7] != null ? (Date) (arRequestObj[7]) : null;
			Date fromDate = arRequestObj[8] != null ? (Date) (arRequestObj[8]) : null;
			Date toDate = arRequestObj[9] != null ? (Date) (arRequestObj[9]) : null;
			Long days = arRequestObj[10] != null ? Long.parseLong(arRequestObj[10].toString()) : null;
			String status = arRequestObj[11] != null ? (String) arRequestObj[11] : null;
			Long employeeId = arRequestObj[12] != null ? Long.parseLong(arRequestObj[12].toString()) : null;
			String employeeRemark = arRequestObj[13] != null ? (String) arRequestObj[13] : null;
			Long userId = arRequestObj[14] != null ? Long.parseLong(arRequestObj[14].toString()) : null;
			String designationName = arRequestObj[15] != null ? (String) arRequestObj[15] : null;
			arRequestDto.setEmployeeCode(empCode);
			arRequestDto.setEmployeeName(firstName + " " + lastName);
			arRequestDto.setEmployeeDepartment(departmentName);
			arRequestDto.setArID(arId);
			arRequestDto.setDateCreated(dateCreated);
			arRequestDto.setEmployeeId(employeeId);
			arRequestDto.setEmployeeRemark(employeeRemark);
			arRequestDto.setUserId(userId);
			arRequestDto.setEmployeeDesignation(designationName);
			if (arCatagory.equals("MP")) {
				arRequestDto.setArCategory("MP");
				arRequestDto.setArCategoryValue(DropDownCache.getInstance()
						.getDropDownValue(DropDownEnum.ARCategory.getDropDownName(), arCatagory));
			}
			if (arCatagory.equals("MN")) {
				arRequestDto.setArCategory("MN");
				arRequestDto.setArCategoryValue(DropDownCache.getInstance()
						.getDropDownValue(DropDownEnum.ARCategory.getDropDownName(), arCatagory));
			}
			if (arCatagory.equals("CN")) {
				arRequestDto.setArCategory("CN");
				arRequestDto.setArCategoryValue(DropDownCache.getInstance()
						.getDropDownValue(DropDownEnum.ARCategory.getDropDownName(), arCatagory));
			}
			if (arCatagory.equals("PC")) {
				arRequestDto.setArCategory("PC");
				arRequestDto.setArCategoryValue(DropDownCache.getInstance()
						.getDropDownValue(DropDownEnum.ARCategory.getDropDownName(), arCatagory));
			}

			arRequestDto.setActionableDate(actionDate);
			arRequestDto.setFromDate(fromDate);
			arRequestDto.setToDate(toDate);
			arRequestDto.setDays(days);
			if (status.equals(StatusMessage.PENDING_CODE)) {
				arRequestDto.setStatus(StatusMessage.PENDING_CODE);
				arRequestDto.setStatusValue(StatusMessage.PENDING_VALUE);
			}
			if (status.equals(StatusMessage.APPROVED_CODE)) {
				arRequestDto.setStatus(StatusMessage.APPROVED_CODE);
				arRequestDto.setStatusValue(StatusMessage.APPROVED_VALUE);
			}
			if (status.equals(StatusMessage.REJECTED_CODE)) {
				arRequestDto.setStatus(StatusMessage.REJECTED_CODE);
				arRequestDto.setStatusValue(StatusMessage.REJECTED_VALUE);
			}

			if (status.equals(StatusMessage.CANCEL_CODE)) {
				arRequestDto.setStatus(StatusMessage.CANCEL_CODE);
				arRequestDto.setStatusValue(StatusMessage.CANCEL_VALUE);
			}
			arRequestDtoList.add(arRequestDto);
		}

		return arRequestDtoList;
	}

	public List<AttendanceRegularizationRequestDTO> modeltoDTOList(List<Object[]> arRequestList, SearchDTO searcDto) {
		List<AttendanceRegularizationRequestDTO> attendanceRegularizationRequestDtoList = new ArrayList<AttendanceRegularizationRequestDTO>();

		for (Object[] arRequestObj : arRequestList) {
			AttendanceRegularizationRequestDTO attendanceRegularizationRequestDto = new AttendanceRegularizationRequestDTO();

			if (arRequestObj[0] != null) {
				attendanceRegularizationRequestDto.setEmployeeCode(arRequestObj[0].toString());
			}

			if (arRequestObj[1] != null && arRequestObj[2] != null) {
				String firstName = arRequestObj[1].toString();
				String lastName = arRequestObj[2].toString();
				attendanceRegularizationRequestDto.setEmployeeName(firstName + " " + lastName);
				attendanceRegularizationRequestDto
						.setCharFirstName(Character.toString(firstName.charAt(0)).toUpperCase());
				attendanceRegularizationRequestDto
						.setCharLastName(Character.toString(lastName.charAt(0)).toUpperCase());
			}

			if (arRequestObj[3] != null) {
				attendanceRegularizationRequestDto.setEmployeeDepartment(arRequestObj[3].toString());
			}

			if (arRequestObj[4] != null) {
				attendanceRegularizationRequestDto
						.setArID((arRequestObj[4] != null ? Long.parseLong(arRequestObj[4].toString()) : null));
			}

			if (arRequestObj[5] != null) {
				Date dateCreate = (Date) (arRequestObj[5]);
				attendanceRegularizationRequestDto.setDateCreated(dateCreate);
			}

			if (arRequestObj[6].toString().equals("MP")) {
				attendanceRegularizationRequestDto.setArCategory("MP");
				attendanceRegularizationRequestDto.setArCategoryValue(DropDownCache.getInstance()
						.getDropDownValue(DropDownEnum.ARCategory.getDropDownName(), arRequestObj[6].toString()));
			}
			if (arRequestObj[6].toString().equals("MN")) {
				attendanceRegularizationRequestDto.setArCategory("MN");
				attendanceRegularizationRequestDto.setArCategoryValue(DropDownCache.getInstance()
						.getDropDownValue(DropDownEnum.ARCategory.getDropDownName(), arRequestObj[6].toString()));
			}
			if (arRequestObj[6].toString().equals("CN")) {
				attendanceRegularizationRequestDto.setArCategory("CN");
				attendanceRegularizationRequestDto.setArCategoryValue(DropDownCache.getInstance()
						.getDropDownValue(DropDownEnum.ARCategory.getDropDownName(), arRequestObj[6].toString()));
			}
			if (arRequestObj[6].toString().equals("PC")) {
				attendanceRegularizationRequestDto.setArCategory("PC");
				attendanceRegularizationRequestDto.setArCategoryValue(DropDownCache.getInstance()
						.getDropDownValue(DropDownEnum.ARCategory.getDropDownName(), arRequestObj[6].toString()));
			}

			if (arRequestObj[7] != null) {
				Date actionableDate = (Date) (arRequestObj[7]);
				attendanceRegularizationRequestDto.setActionableDate(actionableDate);
			}

			if (arRequestObj[8] != null) {
				Date fromDate = (Date) (arRequestObj[8]);
				attendanceRegularizationRequestDto.setFromDate(fromDate);
			}

			if (arRequestObj[9] != null) {
				Date toDate = (Date) (arRequestObj[9]);
				attendanceRegularizationRequestDto.setToDate(toDate);
			}

			if (arRequestObj[10] != null) {
				attendanceRegularizationRequestDto
						.setDays(arRequestObj[10] != null ? Long.parseLong(arRequestObj[10].toString()) : null);
			}

			if (arRequestObj[11].toString().equals(StatusMessage.PENDING_CODE)) {
				attendanceRegularizationRequestDto.setStatus(StatusMessage.PENDING_CODE);
				attendanceRegularizationRequestDto.setStatusValue(StatusMessage.PENDING_VALUE);
			}
			if (arRequestObj[11].toString().equals(StatusMessage.APPROVED_CODE)) {
				attendanceRegularizationRequestDto.setStatus(StatusMessage.APPROVED_CODE);
				attendanceRegularizationRequestDto.setStatusValue(StatusMessage.APPROVED_VALUE);
			}
			if (arRequestObj[11].toString().equals(StatusMessage.REJECTED_CODE)) {
				attendanceRegularizationRequestDto.setStatus(StatusMessage.REJECTED_CODE);
				attendanceRegularizationRequestDto.setStatusValue(StatusMessage.REJECTED_VALUE);
			}

			if (arRequestObj[11].toString().equals(StatusMessage.CANCEL_CODE)) {
				attendanceRegularizationRequestDto.setStatus(StatusMessage.CANCEL_CODE);
				attendanceRegularizationRequestDto.setStatusValue(StatusMessage.CANCEL_VALUE);
			}

			if (arRequestObj[12] != null) {
				attendanceRegularizationRequestDto
						.setEmployeeId(arRequestObj[12] != null ? Long.parseLong(arRequestObj[12].toString()) : null);
			}

			if (arRequestObj[13] != null) {
				attendanceRegularizationRequestDto.setEmployeeRemark(arRequestObj[13].toString());
			}

			if (arRequestObj[14] != null) {
				attendanceRegularizationRequestDto
						.setUserId(arRequestObj[14] != null ? Long.parseLong(arRequestObj[14].toString()) : null);
			}

			if (arRequestObj[15] != null) {
				attendanceRegularizationRequestDto.setEmployeeDesignation(arRequestObj[15].toString());
			}

			if (arRequestObj[16] != null) {
				attendanceRegularizationRequestDto.setApprovalRemark(arRequestObj[16].toString());
			}

			attendanceRegularizationRequestDtoList.add(attendanceRegularizationRequestDto);

		}

		return attendanceRegularizationRequestDtoList;
	}

}
