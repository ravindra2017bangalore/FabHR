package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.candidate.CandidateOfficialInformationDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeStatuary;

public class EmpOfficialAdaptor {
	public CandidateOfficialInformationDTO databaseModelToUiDto(Employee employee,
			List<EmployeeStatuary> employeeStatuaryList) {
		CandidateOfficialInformationDTO candidateOfficialInformationDto = new CandidateOfficialInformationDTO();
		candidateOfficialInformationDto.setCandidateId(employee.getEmployeeId());

		for (EmployeeStatuary employeeStatuary : employeeStatuaryList) {
			if (employeeStatuary.getStatuaryType().equals("UA")) {
				candidateOfficialInformationDto.setUanNumber(employeeStatuary.getStatuaryNumber());
				candidateOfficialInformationDto.setUanId(employeeStatuary.getStatuaryId());
			}
			if (employeeStatuary.getStatuaryType().equals("PF")) {
				candidateOfficialInformationDto.setPfNumber(employeeStatuary.getStatuaryNumber());
				candidateOfficialInformationDto.setPfEnrollDate(employeeStatuary.getDateFrom());
				candidateOfficialInformationDto.setPfId(employeeStatuary.getStatuaryId());
			}
			if (employeeStatuary.getStatuaryType().equals("AC")) {
				candidateOfficialInformationDto.setAccidentalInsurance(employeeStatuary.getStatuaryNumber());
				candidateOfficialInformationDto.setAiFromDate(employeeStatuary.getDateFrom());
				candidateOfficialInformationDto.setAiToDate(employeeStatuary.getDateTo());
				candidateOfficialInformationDto.setAiId(employeeStatuary.getStatuaryId());

			}
			if (employeeStatuary.getStatuaryType().equals("ES")) {
				candidateOfficialInformationDto.setEsiNumber(employeeStatuary.getStatuaryNumber());
				candidateOfficialInformationDto.setEsiEnrollDate(employeeStatuary.getDateFrom());
				candidateOfficialInformationDto.setEsicId(employeeStatuary.getStatuaryId());

			}
			if (employeeStatuary.getStatuaryType().equals("ME")) {
				candidateOfficialInformationDto.setMedicalInsurance(employeeStatuary.getStatuaryNumber());
				candidateOfficialInformationDto.setMiFromDate(employeeStatuary.getDateFrom());
				candidateOfficialInformationDto.setMiToDate(employeeStatuary.getDateTo());
				candidateOfficialInformationDto.setMiId(employeeStatuary.getStatuaryId());
			}

			candidateOfficialInformationDto.setUserId(employeeStatuary.getUserId());
			candidateOfficialInformationDto.setUserIdUpdate(employeeStatuary.getUserIdUpdate());
			candidateOfficialInformationDto.setDateCreated(employeeStatuary.getDateCreated());
			candidateOfficialInformationDto.setDateUpdate(employeeStatuary.getDateUpdate());
		}

		candidateOfficialInformationDto.setGrade(employee.getGradesId());
		candidateOfficialInformationDto.setProbationDays(employee.getProbationDays());
		candidateOfficialInformationDto.setNoticePeriod(employee.getNoticePeriodDays());
		return candidateOfficialInformationDto;
	}

	public Employee UIDtoToEmployeeModel(CandidateOfficialInformationDTO candidateOfficialInformationDto,
			Employee employee) {
		employee.setNoticePeriodDays(candidateOfficialInformationDto.getNoticePeriod());
		employee.setProbationDays(candidateOfficialInformationDto.getProbationDays());
		employee.setGradesId(candidateOfficialInformationDto.getGrade());
		return employee;
	}

	public List<EmployeeStatuary> UIDtoToStatutoryModelList(
			CandidateOfficialInformationDTO candidateOfficialInformationDto, Long empId) {
		List<EmployeeStatuary> empStatutoryList = new ArrayList<EmployeeStatuary>();

		if (candidateOfficialInformationDto.getPfNumber() != null) {
			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			System.out.println("PF notes..." + candidateOfficialInformationDto.getPfId());
			employeeStatuary.setStatuaryId(candidateOfficialInformationDto.getPfId());
			employeeStatuary.setStatuaryType("PF");
			employeeStatuary.setStatuaryNumber(candidateOfficialInformationDto.getPfNumber());
			employeeStatuary.setDateFrom(candidateOfficialInformationDto.getPfEnrollDate());
			Employee employee = new Employee();
			employee.setEmployeeId(empId);
			employeeStatuary.setEmployee(employee);
			empStatutoryList.add(employeeStatuary);
		}

		if (candidateOfficialInformationDto.getAccidentalInsurance() != null) {
			System.out.println("Ac notes..." + candidateOfficialInformationDto.getAiId());
			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			employeeStatuary.setStatuaryId(candidateOfficialInformationDto.getAiId());
			employeeStatuary.setStatuaryType("AC");
			employeeStatuary.setStatuaryNumber(candidateOfficialInformationDto.getAccidentalInsurance());
			employeeStatuary.setDateFrom(candidateOfficialInformationDto.getAiFromDate());
			employeeStatuary.setDateTo(candidateOfficialInformationDto.getAiToDate());
			Employee employee = new Employee();
			employee.setEmployeeId(empId);
			employeeStatuary.setEmployee(employee);
			empStatutoryList.add(employeeStatuary);
		}
		if (candidateOfficialInformationDto.getUanNumber() != null) {
			System.out.println("Ac notes..." + candidateOfficialInformationDto.getUanId());

			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			employeeStatuary.setStatuaryId(candidateOfficialInformationDto.getUanId());
			employeeStatuary.setStatuaryType("UA");
			employeeStatuary.setStatuaryNumber(candidateOfficialInformationDto.getUanNumber());
			Employee employee = new Employee();
			employee.setEmployeeId(empId);
			employeeStatuary.setEmployee(employee);
			empStatutoryList.add(employeeStatuary);
		}
		if (candidateOfficialInformationDto.getEsiNumber() != null) {
			System.out.println("Ac notes..." + candidateOfficialInformationDto.getEsicId());
			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			employeeStatuary.setStatuaryId(candidateOfficialInformationDto.getEsicId());
			employeeStatuary.setStatuaryType("ES");
			employeeStatuary.setStatuaryNumber(candidateOfficialInformationDto.getEsiNumber());
			employeeStatuary.setDateFrom(candidateOfficialInformationDto.getEsiEnrollDate());
			Employee employee = new Employee();
			employee.setEmployeeId(empId);
			employeeStatuary.setEmployee(employee);
			empStatutoryList.add(employeeStatuary);
		}
		if (candidateOfficialInformationDto.getMedicalInsurance() != null) {
			System.out.println("Ac notes..." + candidateOfficialInformationDto.getMiId());

			EmployeeStatuary employeeStatuary = new EmployeeStatuary();
			employeeStatuary.setStatuaryId(candidateOfficialInformationDto.getMiId());
			employeeStatuary.setStatuaryType("ME");
			employeeStatuary.setStatuaryNumber(candidateOfficialInformationDto.getMedicalInsurance());
			employeeStatuary.setDateFrom(candidateOfficialInformationDto.getMiFromDate());
			employeeStatuary.setDateTo(candidateOfficialInformationDto.getMiToDate());
			Employee employee = new Employee();
			employee.setEmployeeId(empId);
			employeeStatuary.setEmployee(employee);
			empStatutoryList.add(employeeStatuary);
		}

		for (EmployeeStatuary employeeStatuary : empStatutoryList) {
			/*
			 * Employee employee = new Employee(); employee.setEmployeeId(employeeId);
			 * employeeStatuary.setEmployee(employee);
			 */
			employeeStatuary.setUserId(candidateOfficialInformationDto.getUserId());
			employeeStatuary.setUserIdUpdate(candidateOfficialInformationDto.getUserId());
			employeeStatuary.setDateCreated(candidateOfficialInformationDto.getDateCreated());
			employeeStatuary.setDateUpdate(new Date());
		}
		return empStatutoryList;
	}
}
