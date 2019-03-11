package com.csipl.hrms.service.organization;

import java.io.File;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.service.adaptor.CompanyAdaptor;
import com.csipl.hrms.service.organization.repository.CompanyRepository;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);

	CompanyAdaptor companyAdaptor = new CompanyAdaptor();

	@Autowired
	StorageService storageService;

	@Autowired
	private CompanyRepository companyRepository;

	/**
	 * Method performed fetch operation if admin logged in than all company list fetched otherwise based on companyId
 	 */
	@Override
	public List<Company> getAllCompanys(Long compnyeeId,String userRoles) {
		List<Company> companyList = null;
		boolean flag = false;
		if (userRoles.equals("SuperAdmin")) {

			flag = true;
		}
		if(flag)
			companyList = companyRepository.findAllCompany();
		else
			companyList = companyRepository.findAllCompany(compnyeeId);
		return companyList;
	}
       
	/**
	 * Method performed save operation  
 	 */
	@Override
	public Company save(Company company, MultipartFile file, boolean fileFlag) {
		Company company1 = companyRepository.save(company);
		String fileName = "";
		if (fileFlag) {
			fileName = "Company_" + company1.getCompanyId().toString();
			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			fileName = fileName + "." + extension;
			System.out.println("File with extension : " + fileName);
			String path = File.separator + "images" + File.separator + "companyImages";
			String dbPath = path + File.separator + fileName;
			storageService.store(file, path, fileName);
			company1.setCompanyLogoPath(dbPath);
		}
		return companyRepository.save(company1);
	}

	/**
	 * to get company information based on companyId(primary key)  
 	 */
	@Override
	public Company getCompany(Long companyId) {
		return companyRepository.findOne(companyId);
	}

}
