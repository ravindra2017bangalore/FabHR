package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.employee.BankDetailsDTO;
import com.csipl.hrms.dto.employee.EmployeeIdProofDTO;
import com.csipl.hrms.dto.employee.ProfessionalInformationDTO;
import com.csipl.hrms.dto.payroll.TdsGroupDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.ProfessionalInformation;
import com.csipl.hrms.model.payroll.TdsGroup;
import com.csipl.hrms.model.payroll.TdsSection;

public class EmployeeIdProofAdaptor implements Adaptor<EmployeeIdProofDTO, EmployeeIdProof> {

	public EmployeeIdProof employeeIdProofDtoToDatabaseModel(EmployeeIdProofDTO employeeIdProofDto, Long employeeId) {
		System.out.println("employeeIdProofDtoToDatabaseModel");
		System.out.println("EMPloyee Id >>" + employeeId);
		DateUtils dateUtils = new DateUtils();
		EmployeeIdProof employeeIdProof = new EmployeeIdProof();
		employeeIdProof.setEmployeeIdProofsId(employeeIdProofDto.getEmployeeIdProofsId());
		employeeIdProof.setActiveStatus(employeeIdProofDto.getActiveStatus());
		// employeeIdProof.setUserId(employeeIdProofDto.getUserId());
		if (employeeIdProofDto.getDateFrom() != null && !("").equals(employeeIdProofDto.getDateFrom()))
			employeeIdProof.setDateFrom(dateUtils.getDateWirhYYYYMMDD(employeeIdProofDto.getDateFrom()));
		if (employeeIdProofDto.getDateTo() != null && !("").equals(employeeIdProofDto.getDateTo()))
			employeeIdProof.setDateTo(dateUtils.getDateWirhYYYYMMDD(employeeIdProofDto.getDateTo()));
		employeeIdProof.setIdTypeId(employeeIdProofDto.getIdTypeId());
		employeeIdProof.setIdNumber(employeeIdProofDto.getIdNumber());
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employeeIdProof.setEmployee(employee);
		employeeIdProof.setUserIdUpdate(employeeIdProofDto.getUserIdUpdate());
		employeeIdProof.setUserId(1l);
		if (employeeIdProofDto.getDateCreated() == null)
			employeeIdProof.setDateCreated(new Date());
		else
			employeeIdProof.setDateCreated(employeeIdProofDto.getDateCreated());
		employeeIdProof.setDateUpdate(new Date());
		return employeeIdProof;
	}

	public EmployeeIdProof employeeIdProofDtoToDatabaseModel(EmployeeIdProofDTO employeeIdProofDto, Employee employee) {
		EmployeeIdProof employeeIdProof = new EmployeeIdProof();
		DateUtils dateUtils = new DateUtils();
		employeeIdProof.setEmployeeIdProofsId(employeeIdProofDto.getEmployeeIdProofsId());
		employeeIdProof.setActiveStatus(employeeIdProofDto.getActiveStatus());

		if (employeeIdProofDto.getDateFrom() != null && !("").equals(employeeIdProofDto.getDateFrom()))
			employeeIdProof.setDateFrom(dateUtils.getDateWirhYYYYMMDD(employeeIdProofDto.getDateFrom()));

		if (employeeIdProofDto.getDateTo() != null && !("").equals(employeeIdProofDto.getDateTo()))
			employeeIdProof.setDateTo(dateUtils.getDateWirhYYYYMMDD(employeeIdProofDto.getDateTo()));
		employeeIdProof.setIdTypeId(employeeIdProofDto.getIdTypeId());
		employeeIdProof.setIdNumber(employeeIdProofDto.getIdNumber());
		employeeIdProof.setUserId(employee.getUserId());
		employeeIdProof.setDateCreated(new Date());
		employeeIdProof.setEmployee(employee);
		return employeeIdProof;
	}

	public List<EmployeeIdProof> employeeIdProofDtoToDatabaseModelList(List<EmployeeIdProofDTO> employeeIdProofDtoList,
			Long empId) {
		List<EmployeeIdProof> employeeIdProofList = new ArrayList<EmployeeIdProof>();
		for (EmployeeIdProofDTO employeeIdProofDto : employeeIdProofDtoList) {
			employeeIdProofList.add(employeeIdProofDtoToDatabaseModel(employeeIdProofDto, empId));
		}
		return employeeIdProofList;
	}

	public List<EmployeeIdProof> employeeIdProofDtoToDatabaseModelList(List<EmployeeIdProofDTO> employeeIdProofDtoList,
			Employee employee) {
		List<EmployeeIdProof> employeeIdProofList = new ArrayList<EmployeeIdProof>();
		for (EmployeeIdProofDTO employeeIdProofDto : employeeIdProofDtoList) {
			employeeIdProofList.add(employeeIdProofDtoToDatabaseModel(employeeIdProofDto, employee));
		}
		return employeeIdProofList;
	}

	@Override
	public List<EmployeeIdProofDTO> databaseModelToUiDtoList(List<EmployeeIdProof> employeeIdProofList) {
		List<EmployeeIdProofDTO> employeeIdProofDtoList = new ArrayList<EmployeeIdProofDTO>();
		for (EmployeeIdProof employeeIdProof : employeeIdProofList) {
			employeeIdProofDtoList.add(databaseModelToUiDto(employeeIdProof));
		}
		return employeeIdProofDtoList;
	}

	@Override
	public EmployeeIdProofDTO databaseModelToUiDto(EmployeeIdProof employeeIdProof) {
		DateUtils dateUtils = new DateUtils();
		EmployeeIdProofDTO employeeIdProofDto = new EmployeeIdProofDTO();
		employeeIdProofDto.setEmployeeIdProofsId(employeeIdProof.getEmployeeIdProofsId());
		employeeIdProofDto.setActiveStatus(employeeIdProof.getActiveStatus());
		employeeIdProofDto.setIdNumber(employeeIdProof.getIdNumber());
		employeeIdProofDto.setUserId(employeeIdProof.getUserId());
		employeeIdProofDto.setDateCreated(employeeIdProof.getDateCreated());
		if (employeeIdProof.getDateFrom() != null) {
			String dateFrom = dateUtils.getDateStringWirhYYYYMMDD(employeeIdProof.getDateFrom());
			employeeIdProofDto.setDateFrom(dateFrom);
		}
		if (employeeIdProof.getDateTo() != null) {
			String dateTo = dateUtils.getDateStringWirhYYYYMMDD(employeeIdProof.getDateTo());
			employeeIdProofDto.setDateTo(dateTo);
		}
		employeeIdProofDto.setIdTypeId(employeeIdProof.getIdTypeId());
		return employeeIdProofDto;
	}

	@Override
	public List<EmployeeIdProof> uiDtoToDatabaseModelList(List<EmployeeIdProofDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeIdProof uiDtoToDatabaseModel(EmployeeIdProofDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

}
