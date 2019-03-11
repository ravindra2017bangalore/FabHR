package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.impl.client.SystemDefaultCredentialsProvider;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.employee.EmployeeAssetDTO;
import com.csipl.hrms.dto.employee.EmployeeIdProofDTO;
import com.csipl.hrms.dto.employee.ProfessionalInformationDTO;
import com.csipl.hrms.model.employee.EmployeeAsset;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.ProfessionalInformation;

public class EmployeeAssetAdaptor  implements Adaptor<EmployeeAssetDTO, EmployeeAsset> {
	
	public List<EmployeeAsset> empAssetsDtoToDatabaseModelList(List<EmployeeAssetDTO> employeeAssetDtoList,String empId) {
		List<EmployeeAsset> employeeAssetList=new ArrayList<EmployeeAsset>();
		for (EmployeeAssetDTO employeeAssetDTO : employeeAssetDtoList) {
			employeeAssetList.add(empAssetsDtoToDatabaseModel(employeeAssetDTO,empId));
		}
		return employeeAssetList;
	}

	@Override
	public List<EmployeeAssetDTO> databaseModelToUiDtoList(List<EmployeeAsset> EmployeeAssetList) {
		List<EmployeeAssetDTO> EmployeeAssetDtoList=new ArrayList<EmployeeAssetDTO>();
		for(EmployeeAsset employeeAsset:EmployeeAssetList) {
		
			EmployeeAssetDtoList.add(databaseModelToUiDto(employeeAsset));
		}
		return EmployeeAssetDtoList;
	}

	public EmployeeAsset empAssetsDtoToDatabaseModel(EmployeeAssetDTO employeeAssetDto,String empId) {
		DateUtils dateUtils = new DateUtils();
		EmployeeAsset employeeAsset=new EmployeeAsset();
		Long employeeId=Long.parseLong(empId);
		employeeAsset.setEmployeeAssetsId(employeeAssetDto.getEmployeeAssetsId());
		employeeAsset.setItemId(employeeAssetDto.getItemId());
		employeeAsset.setIssueDescription(employeeAssetDto.getIssueDescription() );
		employeeAsset.setAmount(employeeAssetDto.getAmount());
		employeeAsset.setQuantity(employeeAssetDto.getQuantity());
		
		
		System.out.println("DTO Date from : "+employeeAssetDto.getDateFrom());
		System.out.println("DTO Date to :"+employeeAssetDto.getDateTo()+":"+employeeAssetDto.getDateFrom()!=null);
		System.out.println(employeeAssetDto.getDateFrom()!=null &&  ("").equals(employeeAssetDto.getDateFrom()));
		if(employeeAssetDto.getDateFrom()!=null && !("").equals(employeeAssetDto.getDateFrom()))
		employeeAsset.setDateFrom(dateUtils.getDateWirhYYYYMMDD( employeeAssetDto.getDateFrom()));
		
		if(employeeAssetDto.getDateTo()!=null &&  !("").equals(employeeAssetDto.getDateTo()))
		employeeAsset.setDateTo(dateUtils.getDateWirhYYYYMMDD( employeeAssetDto.getDateTo()));	
		
		
		
		employeeAsset.setActiveStatus(employeeAssetDto.getActiveStatus());
		employeeAsset.setEmployeeId(employeeId);
		employeeAsset.setUserId(employeeAssetDto.getUserId());
		if(employeeAssetDto.getDateCreated()==null)
			employeeAsset.setDateCreated(new Date());
		else
		employeeAsset.setDateCreated(employeeAssetDto.getDateCreated());
		employeeAsset.setDateUpdate(new Date());
		employeeAsset.setUserIdUpdate(employeeAssetDto.getUserIdUpdate());
		return employeeAsset;
	}

	@Override
	public EmployeeAssetDTO databaseModelToUiDto(EmployeeAsset employeeAsset) {
		DateUtils dateUtils = new DateUtils();
		EmployeeAssetDTO employeeAssetDto = new EmployeeAssetDTO();
		employeeAssetDto.setEmployeeAssetsId(employeeAsset.getEmployeeAssetsId());
		employeeAssetDto.setIssueDescription(employeeAsset.getIssueDescription());
		employeeAssetDto.setItemId(employeeAsset.getItemId());
		employeeAssetDto.setQuantity(employeeAsset.getQuantity());
		employeeAssetDto.setAmount(employeeAsset.getAmount());
		
		if(employeeAsset.getDateFrom()!=null){
		String dateFrom = dateUtils.getDateStringWirhYYYYMMDD(employeeAsset.getDateFrom());
		employeeAssetDto.setDateFrom(dateFrom);
		}
		if(employeeAsset.getDateTo()!=null) {
		String dateTo = dateUtils.getDateStringWirhYYYYMMDD(employeeAsset.getDateTo());
		employeeAssetDto.setDateTo(dateTo);
		}
		employeeAssetDto.setActiveStatus(employeeAsset.getActiveStatus());
		employeeAssetDto.setUserId(employeeAsset.getUserId());
		employeeAssetDto.setDateCreated(employeeAsset.getDateCreated());
		
		return employeeAssetDto; 
	}


	@Override
	public EmployeeAsset uiDtoToDatabaseModel(EmployeeAssetDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<EmployeeAsset> uiDtoToDatabaseModelList(List<EmployeeAssetDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

}
