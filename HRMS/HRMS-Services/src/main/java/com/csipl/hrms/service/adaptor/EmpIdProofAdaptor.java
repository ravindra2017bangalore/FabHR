package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.candidate.CandidateIdProofDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeIdProof;

public class EmpIdProofAdaptor implements Adaptor<CandidateIdProofDTO, EmployeeIdProof> {

	@Override
	public List<EmployeeIdProof> uiDtoToDatabaseModelList(List<CandidateIdProofDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateIdProofDTO> databaseModelToUiDtoList(List<EmployeeIdProof> empIdProofList) {
		List<CandidateIdProofDTO> candidateIdProofDtoList = new ArrayList<CandidateIdProofDTO>();
		for (EmployeeIdProof employeeIdProof : empIdProofList) {
			candidateIdProofDtoList.add(databaseModelToUiDto(employeeIdProof));
		}
		return candidateIdProofDtoList;
	}

	@Override
	public EmployeeIdProof uiDtoToDatabaseModel(CandidateIdProofDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidateIdProofDTO databaseModelToUiDto(EmployeeIdProof employeeIdProof) {
		CandidateIdProofDTO candidateIdProofDto = new CandidateIdProofDTO();
		candidateIdProofDto.setCandidateIdProofsId(employeeIdProof.getEmployeeIdProofsId());
		candidateIdProofDto.setActiveStatus(employeeIdProof.getActiveStatus());
		candidateIdProofDto.setIdNumber(employeeIdProof.getIdNumber());
		candidateIdProofDto.setUserId(employeeIdProof.getUserId());
		candidateIdProofDto.setDateCreated(employeeIdProof.getDateCreated());
		candidateIdProofDto.setDocumentName(employeeIdProof.getDocumentName());
		candidateIdProofDto.setIdProofDoc(employeeIdProof.getIdProofDoc());
		if (employeeIdProof.getDateFrom() != null) {
			// Date dateFrom = candidateIdProof.getDateFrom();
			candidateIdProofDto.setDateFrom(employeeIdProof.getDateFrom());
			System.out.println(employeeIdProof.getDateFrom());
		}
		if (employeeIdProof.getDateTo() != null) {
			// String dateTo = dateUtils.getDateStringWirhYYYYMMDD(
			// candidateIdProof.getDateTo() );
			candidateIdProofDto.setDateTo(employeeIdProof.getDateTo());
			System.out.println(employeeIdProof.getDateTo());
		}
		candidateIdProofDto.setIdTypeId(employeeIdProof.getIdTypeId());
		candidateIdProofDto.setIdTypeIdValue(DropDownCache.getInstance()
				.getDropDownValue(DropDownEnum.SelectIdType.getDropDownName(), employeeIdProof.getIdTypeId()));
		System.out.println(employeeIdProof.toString());
		candidateIdProofDto.setCandidateId(employeeIdProof.getEmployee().getEmployeeId());
		return candidateIdProofDto;
	}

	public List<EmployeeIdProof> candidateIdProofDtoToDatabaseModelList(
			List<CandidateIdProofDTO> candidateIdProofDtoList, Long canId) {
		List<EmployeeIdProof> employeeIdProofList = new ArrayList<EmployeeIdProof>();
		for (CandidateIdProofDTO employeeIdProofDto : candidateIdProofDtoList) {
			employeeIdProofList.add(candidateIdProofDtoToDatabaseModel(employeeIdProofDto, canId));
		}
		return employeeIdProofList;
	}

	public EmployeeIdProof candidateIdProofDtoToDatabaseModel(CandidateIdProofDTO candidateIdProofDTO,
			long employeeId) {
		System.out.println("candidateIdProofDtoToDatabaseModel");
		System.out.println("Candidate Id >>" + employeeId);
		DateUtils dateUtils = new DateUtils();
		EmployeeIdProof employeeIdProof = new EmployeeIdProof();
		employeeIdProof.setEmployeeIdProofsId(candidateIdProofDTO.getCandidateIdProofsId());
		employeeIdProof.setActiveStatus(candidateIdProofDTO.getActiveStatus());
		employeeIdProof.setUserId(candidateIdProofDTO.getUserId());
		if (candidateIdProofDTO.getDateFrom() != null && !("").equals(candidateIdProofDTO.getDateFrom()))
			employeeIdProof.setDateFrom(candidateIdProofDTO.getDateFrom());
		if (candidateIdProofDTO.getDateTo() != null && !("").equals(candidateIdProofDTO.getDateTo()))
			employeeIdProof.setDateTo(candidateIdProofDTO.getDateTo());

		employeeIdProof.setIdTypeId(candidateIdProofDTO.getIdTypeId());
		employeeIdProof.setIdNumber(candidateIdProofDTO.getIdNumber());
		employeeIdProof.setDocumentName(candidateIdProofDTO.getDocumentName());
	
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employeeIdProof.setEmployee(employee);
		;
		if (candidateIdProofDTO.getDateCreated() == null)
			employeeIdProof.setDateCreated(new Date());
		else
			employeeIdProof.setDateCreated(candidateIdProofDTO.getDateCreated());
		employeeIdProof.setDateUpdate(new Date());
		System.out.println("candidateIdProof...." + employeeIdProof.toString());
		employeeIdProof.setUserId(1l);

		return employeeIdProof;
	}

}
