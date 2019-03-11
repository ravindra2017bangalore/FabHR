package com.csipl.hrms.service.payroll;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.TdsTransactionFile;
import com.csipl.hrms.service.employee.repository.EmployeePersonalInformationRepository;
import com.csipl.hrms.service.organization.StorageService;
import com.csipl.hrms.service.payroll.repository.TdsTransactionFileRepository;

@Service("tdsTransactionFileService")
public class TdsTransactionFileServiceImpl implements TdsTransactionFileService {

	@Autowired
	TdsTransactionFileRepository tdsTransactionFileRepository;
	
	@Autowired
	EmployeePersonalInformationRepository employeePersonalInformationRepository;
	
	@Autowired
	StorageService storageService;
	
	@Override
	public void saveTdsTransactionFile(TdsTransactionFile tdsTransactionFile, Long employeeId, MultipartFile file) {
		
			Employee employee=employeePersonalInformationRepository.findOne(employeeId);
			String fileName = file.getOriginalFilename();
			fileName=fileName.substring(0, fileName.lastIndexOf("."));
			fileName=fileName+"_"+employee.getEmployeeCode();
			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			fileName=fileName+"."+extension;
			System.out.println(fileName);
			String path = File.separator + "documents" + File.separator + "EmployeeTdsDocuments";
			String dbPath = path + File.separator + fileName;
			storageService.store(file, path, fileName);
			tdsTransactionFile.setFileName(fileName);
			tdsTransactionFile.setFilePath(dbPath);
		
		tdsTransactionFileRepository.save(tdsTransactionFile);
	}

	@Override
	public List<TdsTransactionFile> getTdsTransactionFiles(Long employeeId) {
		return tdsTransactionFileRepository.findAllTdsTransactionFile(employeeId);
	}

	@Override
	public void delete(Long tdsTransactionFileId) {
		tdsTransactionFileRepository.delete(tdsTransactionFileId);
	}
}
