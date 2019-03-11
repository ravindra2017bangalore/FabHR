 package com.csipl.hrms.service.adaptor;
 
 import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.organisation.BranchDTO;
import com.csipl.hrms.model.common.Branch;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;


    
public class BranchAdaptor implements Adaptor<BranchDTO,Branch>{

	AddressAdaptor addressAdaptor= new AddressAdaptor();
 	public Branch uiDtoToDatabaseModel(BranchDTO branchDto) {
 		Branch branch=new Branch();
 		Groupg groupg=new Groupg();
 		Company company=new Company();
 		branch.setBranchId(branchDto.getBranchId());
  		branch.setBranchName(branchDto.getBranchName());
  		branch.setUserId(branchDto.getUserId());
  		company.setCompanyId(branchDto.getCompanyId());
  		branch.setCompany(company);
  		
  		
  		if(branch.getBranchId()==null)
  			branch.setDateCreated(new Date());
   		else
   	  		branch.setDateCreated(branchDto.getDateCreated());

  		 
  		branch.setDateUpdate(new Date());
  		branch.setUserIdUpdate(branchDto.getUserIdUpdate());
  		groupg.setGroupId(1l);
  		branch.setGroupg(groupg);
  		
   		branch.setAddress(addressAdaptor.uiDtoToDatabaseModel(branchDto.getAddress()));
        return branch;
	} 
   	@Override
	public List<BranchDTO> databaseModelToUiDtoList(List<Branch> branchList) {
    		List<BranchDTO> branchtDtoList =new ArrayList<BranchDTO>();
    		 for (Branch branch : branchList) {
    			 branchtDtoList.add(databaseModelToUiDto(branch));
			}
   		return branchtDtoList;
	}
     	 
  	@Override
	public BranchDTO databaseModelToUiDto(Branch branch) {
  	
  		BranchDTO branchDto=new BranchDTO();
  		branchDto.setBranchId(branch.getBranchId());
  		branchDto.setBranchName(branch.getBranchName());
  		branchDto.setUserId(branch.getUserId());
  		branchDto.setDateCreated(branch.getDateCreated());
  		if(branch.getAddress()!=null)
  		branchDto.setAddress(addressAdaptor.databaseModelToUiDto(branch.getAddress()));
  		return branchDto;
	}
	@Override
	public List<Branch> uiDtoToDatabaseModelList(List<BranchDTO> branchDtoList) {
 		return null;
	}
   }
 