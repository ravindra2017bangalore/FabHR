package com.csipl.hrms.service.organization;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.model.common.Company;

public interface CompanyService {
	
	public List<Company> getAllCompanys(Long compnyeeId,String userRoles);
	public Company getCompany(Long companyId);
	 public Company save(Company company, MultipartFile file, boolean fileFlag);

}

