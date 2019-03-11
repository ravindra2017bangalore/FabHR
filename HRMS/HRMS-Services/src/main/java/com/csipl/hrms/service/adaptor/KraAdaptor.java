package com.csipl.hrms.service.adaptor;
 
import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.employee.KraDTO;
import com.csipl.hrms.model.employee.Kra;
import com.csipl.hrms.model.organisation.Department;
import com.csipl.hrms.model.organisation.Designation;

public class KraAdaptor implements Adaptor<KraDTO,Kra>{

	@Override
	public List<Kra> uiDtoToDatabaseModelList(List<KraDTO> kraDtoList) {
		
		List<Kra> kraList=new ArrayList<Kra>();
		for(KraDTO kraDto: kraDtoList) {
			kraList.add(uiDtoToDatabaseModel(kraDto));
		}
		return kraList;
	}

	@Override
	public List<KraDTO> databaseModelToUiDtoList(List<Kra> kraList) {
		
		List<KraDTO> kraDtoList=new ArrayList<KraDTO>();
		for(Kra kra: kraList) {
			kraDtoList.add(databaseModelToUiDto(kra));
		}
		return kraDtoList;
	}

	@Override
	public Kra uiDtoToDatabaseModel(KraDTO kraDto) {
		
		Kra kra=new Kra();
		kra.setKraName(kraDto.getKraName());
		kra.setKraId(kraDto.getKraId());
  		Department department = new Department();
		department.setDepartmentId(kraDto.getDepartmentId());
		department.setDepartmentName(kraDto.getDepartmentName());
		kra.setDepartment(department);
		Designation designation=new Designation();
		designation.setDesignationId(kraDto.getDesignationId());
		designation.setDesignationName(kraDto.getDesignationName());
		kra.setDesignation(designation);
		return kra;
	}

	@Override
	public KraDTO databaseModelToUiDto(Kra kra) {
		
		KraDTO kraDto=new KraDTO();
		kraDto.setKraId(kra.getKraId());
		kraDto.setKraName(kra.getKraName());
		if(kra.getDepartment()!=null) {
		kraDto.setDepartmentId(kra.getDepartment().getDepartmentId());
		kraDto.setDepartmentName(kra.getDepartment().getDepartmentName());
		}
		if(kra.getDesignation()!=null) {
		kraDto.setDesignationId(kra.getDesignation().getDesignationId());
		kraDto.setDesignationName(kra.getDesignation().getDesignationName());
		}
		return kraDto;
	}
}
