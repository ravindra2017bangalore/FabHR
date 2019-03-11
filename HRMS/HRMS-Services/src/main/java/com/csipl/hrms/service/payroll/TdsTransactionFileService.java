package com.csipl.hrms.service.payroll;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.model.payroll.TdsTransactionFile;

public interface TdsTransactionFileService {
	public void saveTdsTransactionFile(TdsTransactionFile tdsTransactionFile, Long employeeId, MultipartFile file);
	public List<TdsTransactionFile> getTdsTransactionFiles(Long employeeId);
	public void delete(Long tdsTransactionFileId);
}
