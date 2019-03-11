package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.organisation.DepartmentDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.organisation.Department;

public class DepartmentAdaptor implements Adaptor<DepartmentDTO, Department> {

	public Department uiDtoToDatabaseModel(DepartmentDTO departmentDto) {
		Department department = new Department();
		Groupg groupg = new Groupg();
		Company company = new Company();
		company.setCompanyId(departmentDto.getCompanyId());
		department.setCompany(company);
		if (departmentDto != null) {
			department.setUserId(departmentDto.getUserId());
			department.setDepartmentId(departmentDto.getDepartmentId());
			department.setDepartmentName(departmentDto.getDepartmentName());
		}

		if (department.getDepartmentId() == null)
			department.setDateCreated(new Date());
		else
			department.setDateCreated(departmentDto.getDateCreated());

		department.setDateUpdate(new Date());
		department.setUserIdUpdate(departmentDto.getUserIdUpdate());
		groupg.setGroupId(1l);
		department.setGroupg(groupg);

		return department;
	}

	@Override
	public List<Department> uiDtoToDatabaseModelList(List<DepartmentDTO> departmentDtoList) {
		return null;
	}

	@Override
	public List<DepartmentDTO> databaseModelToUiDtoList(List<Department> departmentList) {
		List<DepartmentDTO> departmentDtoList = new ArrayList<DepartmentDTO>();
		for (Department department : departmentList) {
			departmentDtoList.add(databaseModelToUiDto(department));
		}
		return departmentDtoList;
	}

	@Override
	public DepartmentDTO databaseModelToUiDto(Department department) {
		DepartmentDTO departmentDto = new DepartmentDTO();
		departmentDto.setDepartmentName(department.getDepartmentName());
		departmentDto.setDepartmentId(department.getDepartmentId());
		departmentDto.setUserId(department.getUserId());
		departmentDto.setDateCreated(department.getDateCreated());
		return departmentDto;
	}
}
