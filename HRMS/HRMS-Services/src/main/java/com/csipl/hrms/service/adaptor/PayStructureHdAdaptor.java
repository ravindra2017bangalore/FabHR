package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.dto.employee.PayStructureHdDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.organisation.Grade;

public class PayStructureHdAdaptor implements Adaptor<PayStructureHdDTO, PayStructureHd> {
	PayStructureAdaptor payStructureAdaptor = new PayStructureAdaptor();

	@Override
	public PayStructureHd uiDtoToDatabaseModel(PayStructureHdDTO payStructureHdDto) {
		PayStructureHd payStructureHd = new PayStructureHd();
		Grade grade = new Grade();
		Employee employee = new Employee();
		payStructureHd.setPayStructureHdId(payStructureHdDto.getPayStructureHdId());
		payStructureHd.setUpdateFlage(payStructureHdDto.isUpdateFlag());
		employee.setEmployeeId(payStructureHdDto.getEmployeeId());
		payStructureHd.setEmployee(employee);
		grade.setGradesId(payStructureHdDto.getGradesId());
		payStructureHd.setGrade(grade);
		payStructureHd.setGrossPay(payStructureHdDto.getGrossPay());
		if (payStructureHdDto.isRevisionUpdateFlag())
			payStructureHd.setEffectiveDate(payStructureHdDto.getEffectiveDate());
		else
			payStructureHd.setEffectiveDate(new Date());
		payStructureHd.setActiveStatus(payStructureHdDto.getActiveStatus());

		if (payStructureHdDto.getDateEnd() != null)
			payStructureHd.setDateEnd(payStructureHdDto.getDateEnd());
		payStructureHd.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		payStructureHd.setIsNoPFDeduction(payStructureHdDto.getIsNoPFDeduction());

		if (payStructureHd.getPayStructureHdId() != null) {
		} else {
			payStructureHd.setDateCreated(new Date());
		}
		
		payStructureHd.setDateUpdate(new Date());
		payStructureHd.setUserId(payStructureHdDto.getUserId());
		payStructureHd.setUserIdUpdate(payStructureHdDto.getUserIdUpdate());
		payStructureHd.setPayStructures(payStructureAdaptor
				.uiDtoToDatabaseModelListWithId(payStructureHdDto.getPayStructureDtoList(), payStructureHd));

		return payStructureHd;
	}

	@Override
	public PayStructureHdDTO databaseModelToUiDto(PayStructureHd payStructureHd) {
		PayStructureHdDTO payStructureHdDto = new PayStructureHdDTO();
		if (payStructureHd.getEmployee() != null)
			payStructureHdDto.setEmployeeId(payStructureHd.getEmployee().getEmployeeId());

		payStructureHdDto.setPayStructureHdId(payStructureHd.getPayStructureHdId());
		if (payStructureHd.getGrade() != null) {
			payStructureHdDto.setGradesId(payStructureHd.getGrade().getGradesId());
			payStructureHdDto.setGradesName(payStructureHd.getGrade().getGradesName());

		}
		payStructureHdDto.setGrossPay(payStructureHd.getGrossPay());
		payStructureHdDto.setEffectiveDate(payStructureHd.getEffectiveDate());
		payStructureHdDto.setDateEnd(payStructureHd.getDateEnd());
		payStructureHdDto.setActiveStatus(payStructureHd.getActiveStatus());
		payStructureHdDto.setUserId(payStructureHd.getUserId());
		payStructureHdDto.setDateCreated(payStructureHd.getDateCreated());
		payStructureHdDto.setEmployeeCode(payStructureHd.getEmployee().getEmployeeCode());
		payStructureHdDto.setFirstName(payStructureHd.getEmployee().getFirstName());
		payStructureHdDto.setLastName(payStructureHd.getEmployee().getLastName());
		payStructureHdDto.setDepartmentName(payStructureHd.getEmployee().getDepartment().getDepartmentName());
		payStructureHdDto.setDesignationName(payStructureHd.getEmployee().getDesignation().getDesignationName());

		if (payStructureHd.getPayStructures() != null)
			payStructureHdDto.setPayStructureDtoList(
					payStructureAdaptor.databaseModelToUiDtoList(payStructureHd.getPayStructures()));
		payStructureHdDto.setActiveStatus(payStructureHd.getActiveStatus());
		payStructureHdDto.setIsNoPFDeduction(payStructureHd.getIsNoPFDeduction());

		return payStructureHdDto;
	}

	@Override
	public List<PayStructureHd> uiDtoToDatabaseModelList(List<PayStructureHdDTO> payStructureHdDtoList) {

		List<PayStructureHd> PayStructureHdList = new ArrayList<PayStructureHd>();

		payStructureHdDtoList.forEach(payStructureHdDTO -> {
			PayStructureHd payStructureHd = uiDtoToDatabaseModel(payStructureHdDTO);

			payStructureHd.setPayStructures(payStructureAdaptor
					.uiDtoToDatabaseModelListWithId(payStructureHdDTO.getPayStructureDtoList(), payStructureHd));

			PayStructureHdList.add(payStructureHd);
		});

		return PayStructureHdList;
	}

	public List<PayStructureHd> uiDtoToDatabaseModelList(List<PayStructureHdDTO> payStructureHdDtoList,
			Employee employee) {

		List<PayStructureHd> PayStructureHdList = new ArrayList<PayStructureHd>();

		payStructureHdDtoList.forEach(payStructureHdDTO -> {
			PayStructureHd payStructureHd = uiDtoToDatabaseModel(payStructureHdDTO, employee);

			/*
			 * payStructureHd.setPayStructures(payStructureAdaptor
			 * .uiDtoToDatabaseModelListWithId( payStructureHdDTO.getPayStructureDtoList(),
			 * payStructureHd) );
			 */

			PayStructureHdList.add(payStructureHd);
		});

		return PayStructureHdList;
	}

	public PayStructureHd uiDtoToDatabaseModel(PayStructureHdDTO payStructureHdDto, Employee employee) {
		PayStructureHd payStructureHd = new PayStructureHd();
		Grade grade = new Grade();

		payStructureHd.setPayStructureHdId(payStructureHdDto.getPayStructureHdId());
		employee.setEmployeeId(payStructureHdDto.getEmployeeId());
		payStructureHd.setEmployee(employee);

		payStructureHd.setUserId(employee.getUserId());
		payStructureHd.setDateCreated(new Date());
		grade.setGradesId(payStructureHdDto.getGradesId());
		payStructureHd.setGrade(grade);
		payStructureHd.setGrossPay(payStructureHdDto.getGrossPay());
		payStructureHd.setEffectiveDate(payStructureHdDto.getEffectiveDate());
		payStructureHd.setActiveStatus(payStructureHdDto.getActiveStatus());
		payStructureHd.setPayStructures(payStructureAdaptor
				.uiDtoToDatabaseModelListWithId(payStructureHdDto.getPayStructureDtoList(), payStructureHd, employee));
		payStructureHd.setIsNoPFDeduction(payStructureHdDto.getIsNoPFDeduction());

		return payStructureHd;
	}

	@Override
	public List<PayStructureHdDTO> databaseModelToUiDtoList(List<PayStructureHd> payStructureHdList) {
		List<PayStructureHdDTO> payStructureHdDtoList = new ArrayList<PayStructureHdDTO>();
		for (PayStructureHd payStructureHd : payStructureHdList) {
			payStructureHdDtoList.add(databaseModelToUiDto(payStructureHd));
		}
		return payStructureHdDtoList;
	}

	public PayStructureHd uiDtoToDatabaseModelRevision(PayStructureHdDTO payStructureHdDto) {
		PayStructureHd payStructureHd = new PayStructureHd();
		Grade grade = new Grade();
		Employee employee = new Employee();
		// payStructureHd.setPayStructureHdId(payStructureHdDto.getPayStructureHdId());
		payStructureHd.setUserId(payStructureHdDto.getUserId());
		payStructureHd.setDateCreated(payStructureHdDto.getDateCreated());
		payStructureHd.setUpdateFlage(payStructureHdDto.isUpdateFlag());
		employee.setEmployeeId(payStructureHdDto.getEmployeeId());
		payStructureHd.setEmployee(employee);
		grade.setGradesId(payStructureHdDto.getGradesId());
		payStructureHd.setGrade(grade);
		payStructureHd.setGrossPay(payStructureHdDto.getGrossPay());
		payStructureHd.setEffectiveDate(payStructureHdDto.getEffectiveDate());
		payStructureHd.setActiveStatus(payStructureHdDto.getActiveStatus());
		
		
		if (payStructureHdDto.getPayStructureHdId() != null) {
		} else {
			payStructureHd.setDateCreated(new Date());
		}
		
		payStructureHd.setDateUpdate(new Date());
		payStructureHd.setUserId(payStructureHdDto.getUserId());
		payStructureHd.setUserIdUpdate(payStructureHdDto.getUserIdUpdate());
		
		
		payStructureHd.setPayStructures(payStructureAdaptor
				.uiDtoToDatabaseModelListWithIdRevision(payStructureHdDto.getPayStructureDtoList(), payStructureHd));

		payStructureHd.setActiveStatus(ActiveStatusEnum.ActiveStatus.getActiveStatus());
		payStructureHd.setIsNoPFDeduction(payStructureHdDto.getIsNoPFDeduction());

		return payStructureHd;
	}

}
