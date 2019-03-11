package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.employee.PayStructureDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.PayStructure;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.payroll.PayHead;

public class PayStructureAdaptor implements Adaptor<PayStructureDTO, PayStructure> {
	public List<PayStructure> uiDtoToDatabaseModelListWithId(List<PayStructureDTO> payStructureDtoList,
			PayStructureHd payStructureHd) {
		List<PayStructure> payStructureList = new ArrayList<PayStructure>();
		for (PayStructureDTO payStructureDto : payStructureDtoList) {
			payStructureList.add(uiDtoToDatabaseModelWithId(payStructureDto, payStructureHd));
		}
		return payStructureList;
	}

	/**
	 * Employee Upload
	 * 
	 * @param payStructureDtoList
	 * @param payStructureHd
	 * @return
	 */
	public List<PayStructure> uiDtoToDatabaseModelListWithId(List<PayStructureDTO> payStructureDtoList,
			PayStructureHd payStructureHd, Employee employee) {
		List<PayStructure> payStructureList = new ArrayList<PayStructure>();
		for (PayStructureDTO payStructureDto : payStructureDtoList) {
			payStructureList.add(uiDtoToDatabaseModelWithId(payStructureDto, payStructureHd, employee));
		}
		return payStructureList;
	}

	@Override
	public List<PayStructureDTO> databaseModelToUiDtoList(List<PayStructure> payStructureList) {
		List<PayStructureDTO> payStructureDtoList = new ArrayList<PayStructureDTO>();
		for (PayStructure payStructure : payStructureList) {
			payStructureDtoList.add(databaseModelToUiDto(payStructure));
		}
		return payStructureDtoList;
	}

	public PayStructure uiDtoToDatabaseModelWithId(PayStructureDTO payStructureDto, PayStructureHd payStructureHd) {
		PayStructure payStructure = new PayStructure();
		PayHead payHead = new PayHead();
		payStructure.setPayStructureId(payStructureDto.getPayStructureId());
		payHead.setPayHeadId(payStructureDto.getPayHeadId());
		payStructure.setPayHead(payHead);
		payStructure.setAmount(payStructureDto.getAmount());
		payStructure.setPayStructureHd(payStructureHd);

		if (payStructureDto.getPayStructureId() != null) {
			payStructure.setUserId(payStructureDto.getUserId());
			payStructure.setDateCreated(payStructureDto.getDateCreated());
		} else {
			payStructure.setUserId(payStructureHd.getUserId());
			payStructure.setDateCreated(new Date());
		}
		payStructure.setUserIdUpdate(payStructureHd.getUserIdUpdate());
		payStructure.setDateUpdate(new Date());

		return payStructure;

	}

	/**
	 * Employee Upload
	 * 
	 * @param payStructureDto
	 * @param payStructureHd
	 * @return
	 */

	public PayStructure uiDtoToDatabaseModelWithId(PayStructureDTO payStructureDto, PayStructureHd payStructureHd,
			Employee employee) {
		PayStructure payStructure = new PayStructure();
		PayHead payHead = new PayHead();
		payStructure.setPayStructureId(payStructureDto.getPayStructureId());
		payHead.setPayHeadId(payStructureDto.getPayHeadId());
		payStructure.setPayHead(payHead);
		payStructure.setAmount(payStructureDto.getAmount());
		payStructure.setUserId(employee.getUserId());
		payStructure.setDateCreated(new Date());
		payStructure.setPayStructureHd(payStructureHd);
		return payStructure;

	}

	@Override
	public PayStructureDTO databaseModelToUiDto(PayStructure payStructure) {
		PayStructureDTO payStructureDto = new PayStructureDTO();
		payStructureDto.setAmount(payStructure.getAmount());
		payStructureDto.setPayStructureId(payStructure.getPayStructureId());
		if (payStructure.getPayStructureHd() != null)
			payStructureDto.setPayStructureHdId(payStructure.getPayStructureHd().getPayStructureHdId());
		if (payStructure.getPayHead() != null) {
			payStructureDto.setPayHeadId(payStructure.getPayHead().getPayHeadId());
			payStructureDto.setPayHeadName(payStructure.getPayHead().getPayHeadName());
		}
		payStructureDto.setUserId(payStructure.getUserId());
		payStructureDto.setDateCreated(payStructure.getDateCreated());
		return payStructureDto;
	}

	public List<PayStructure> uiDtoToDatabaseModelListWithIdRevision(List<PayStructureDTO> payStructureDtoList,
			PayStructureHd payStructureHd) {
		List<PayStructure> payStructureList = new ArrayList<PayStructure>();
		for (PayStructureDTO payStructureDto : payStructureDtoList) {
			payStructureList.add(uiDtoToDatabaseModelWithIdRevision(payStructureDto, payStructureHd));
		}
		return payStructureList;
	}

	public PayStructure uiDtoToDatabaseModelWithIdRevision(PayStructureDTO payStructureDto,
			PayStructureHd payStructureHd) {
		PayStructure payStructure = new PayStructure();
		PayHead payHead = new PayHead();
		// payStructure.setPayStructureId(payStructureDto.getPayStructureId());
		payHead.setPayHeadId(payStructureDto.getPayHeadId());
		payStructure.setPayHead(payHead);
		payStructure.setAmount(payStructureDto.getAmount());
		payStructure.setPayStructureHd(payStructureHd);
  
		if (payStructureDto.getPayStructureId() != null) {
			payStructure.setUserId(payStructureDto.getUserId());
			payStructure.setDateCreated(payStructureDto.getDateCreated());
		} else {
			payStructure.setUserId(payStructureHd.getUserId());
			payStructure.setDateCreated(new Date());
		}
		payStructure.setUserIdUpdate(payStructureHd.getUserIdUpdate());
		payStructure.setDateUpdate(new Date());
		

		return payStructure;

	}

	@Override
	public List<PayStructure> uiDtoToDatabaseModelList(List<PayStructureDTO> payStructureDtoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PayStructure uiDtoToDatabaseModel(PayStructureDTO payStructureDto) {
		// TODO Auto-generated method stub
		return null;
	}

}