package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.dto.organisation.DeptDesignationDTO;
import com.csipl.hrms.dto.organisation.DesignationDTO;

import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.DeptDesignation;
import com.csipl.hrms.model.organisation.Designation;

public class DeptDesignationAdaptor implements Adaptor<DeptDesignationDTO, DeptDesignation> {

	public List<DeptDesignation> deptDesgDtoToDatabaseModelList(List<DeptDesignationDTO> deptDesignationDtoList,
			List<DeptDesignation> deptDesgList) {
		List<DeptDesignation> deptDesignationList = new ArrayList<DeptDesignation>();
		for (DeptDesignationDTO deptDesignationDto : deptDesignationDtoList) {
			for (DeptDesignation deptDesignation : deptDesgList) {
				if (deptDesignation.getDesignation().getDesignationId()!=deptDesignationDto.getDesignationId() ) {
					deptDesignation.setActiveStatus("DE");
					deptDesignationList.add(deptDesignation);
				}
			}
			deptDesignationList.add(deptDesgnDtoToDatabaseModel(deptDesignationDto));
		}
		return deptDesignationList;
	}

	public List<DesignationDTO> deptDesignationToDesignationDtoList(List<DeptDesignation> deptDesignationList,
			List<DesignationDTO> designationDtoList) {
		List<DesignationDTO> desgDtoList = new ArrayList<DesignationDTO>();

		for (DesignationDTO designationDto : designationDtoList) {
			for (DeptDesignation deptDesignation : deptDesignationList) {
				if (designationDto.getDesignationId() == deptDesignation.getDesignation().getDesignationId()) {
					designationDto.setCheckedStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
					designationDto.setDepartmentId(deptDesignation.getDepartment().getDepartmentId());
					designationDto.setDeptDesgId(deptDesignation.getDeptDesgId());

				}

			}
			desgDtoList.add(designationDto);

		}
		return desgDtoList;
	}


	public DeptDesignation deptDesgnDtoToDatabaseModel(DeptDesignationDTO deptDesignationDto) {
		DeptDesignation deptDesignation = new DeptDesignation();
		deptDesignation.setDeptDesgId(deptDesignationDto.getDeptDesgId());
		Department department = new Department();
		department.setDepartmentId(deptDesignationDto.getDepartmentId());
		deptDesignation.setDepartment(department);
		Designation designation = new Designation();
		designation.setDesignationId(deptDesignationDto.getDesignationId());
		deptDesignation.setDesignation(designation);
		deptDesignation.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		deptDesignation.setCompanyId(deptDesignationDto.getCompanyId());
		deptDesignation.setUserId(deptDesignationDto.getUserId());
		deptDesignation.setUserIdUpdate(deptDesignationDto.getUserId());
		if (deptDesignationDto.getDeptDesgId() == null)
			deptDesignation.setDateCreated(new Date());
		else
			deptDesignation.setDateCreated(deptDesignationDto.getDateCreated());
		deptDesignation.setDateUpdate(new Date());
		return deptDesignation;
	}

	@Override
	public DeptDesignationDTO databaseModelToUiDto(DeptDesignation deptDesignation) {
		DeptDesignationDTO deptDesignationDto = new DeptDesignationDTO();
		deptDesignationDto.setDeptDesgId(deptDesignation.getDeptDesgId());
		deptDesignationDto.setDepartmentId(deptDesignation.getDepartment().getDepartmentId());
		System.out.println("dept.." + deptDesignation.getDepartment().getDepartmentName());
		deptDesignationDto.setDepartmentName(deptDesignation.getDepartment().getDepartmentName());
		deptDesignationDto.setDesignationId(deptDesignation.getDesignation().getDesignationId());
		deptDesignationDto.setDesignationName(deptDesignation.getDesignation().getDesignationName());
		deptDesignationDto.setCompanyId(deptDesignation.getCompanyId());
		deptDesignationDto.setUserId(deptDesignation.getUserId());
		//deptDesignationDto.setCheckedStatus(checkedStatus);
		return deptDesignationDto;
	}

	public List<DeptDesignationDTO> databaseObjectArrayToUiDtoList(List<Object[]> objectOfDeptList) {
		List<DeptDesignationDTO> deptDesignationDtoList = new ArrayList<DeptDesignationDTO>();
		for (Object[] deptObj : objectOfDeptList) {
			DeptDesignationDTO deptDesgnDto = new DeptDesignationDTO();
			Long deptId = deptObj[0] != null ? Long.parseLong(deptObj[0].toString()) : null;
			String departmentName = deptObj[1] != null ? (String) deptObj[1] : null;
			Long userId = deptObj[2] != null ? Long.parseLong(deptObj[2].toString()) : null;
			deptDesgnDto.setDepartmentName(departmentName);
			deptDesgnDto.setDepartmentId(deptId);
			deptDesgnDto.setUserId(userId);
			deptDesignationDtoList.add(deptDesgnDto);
		}
		return deptDesignationDtoList;
	}

	@Override
	public List<DeptDesignationDTO> databaseModelToUiDtoList(List<DeptDesignation> deptDesignationDtoList) {
		List<DeptDesignationDTO> deptDesgDtoList = new ArrayList<DeptDesignationDTO>();
		for (DeptDesignation deptDesignation : deptDesignationDtoList) {
			
			deptDesgDtoList.add(databaseModelToUiDto(deptDesignation));
		}
		return deptDesgDtoList;
	}

	@Override
	public List<DeptDesignation> uiDtoToDatabaseModelList(List<DeptDesignationDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeptDesignation uiDtoToDatabaseModel(DeptDesignationDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}
}
