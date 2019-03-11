package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.payroll.TdsTransactionFileDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.payroll.TdsTransactionFile;

public class TdsTransactionFileAdaptor implements Adaptor<TdsTransactionFileDTO, TdsTransactionFile> {

	@Override
	public List<TdsTransactionFile> uiDtoToDatabaseModelList(List<TdsTransactionFileDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TdsTransactionFileDTO> databaseModelToUiDtoList(List<TdsTransactionFile> tdsTransactionFileList) {
		List<TdsTransactionFileDTO> tdsTransactionFileDtoList=new ArrayList<>();
		for(TdsTransactionFile tdsTransactionFile:tdsTransactionFileList) {
			tdsTransactionFileDtoList.add(databaseModelToUiDto(tdsTransactionFile));
		}
		return tdsTransactionFileDtoList;
	}

	@Override
	public TdsTransactionFile uiDtoToDatabaseModel(TdsTransactionFileDTO tdsTransactionFileDto) {
		// TODO Auto-generated method stub
		return null; 
	}

	public TdsTransactionFile uiDtoToTdsTransactionFileModel(TdsTransactionFileDTO tdsTransactionFileDto, Long empId) {
		TdsTransactionFile tdsTransactionFile=new TdsTransactionFile();
		Employee employee=new Employee();
		tdsTransactionFile.setTdsTransactionFileId(tdsTransactionFileDto.getTdsTransactionFileId());
		tdsTransactionFile.setTitle(tdsTransactionFileDto.getTitle());
		tdsTransactionFile.setUserId(tdsTransactionFileDto.getUserId());
		tdsTransactionFile.setUserIdUpdate(tdsTransactionFileDto.getUserIdUpdate());
		if(tdsTransactionFileDto.getDateCreated()!=null)
		tdsTransactionFile.setDateCreated(tdsTransactionFileDto.getDateCreated());
		else
			tdsTransactionFile.setDateCreated(new Date());
		employee.setEmployeeId(empId);
		tdsTransactionFile.setEmployee(employee);
		tdsTransactionFile.setFilePath(tdsTransactionFileDto.getFilePath());
		return tdsTransactionFile; 
	}
	
	@Override
	public TdsTransactionFileDTO databaseModelToUiDto(TdsTransactionFile tdsTransactionFile) {
		TdsTransactionFileDTO tdsTransactionFileDto=new TdsTransactionFileDTO();
		tdsTransactionFileDto.setTdsTransactionFileId(tdsTransactionFile.getTdsTransactionFileId());
		tdsTransactionFileDto.setTitle(tdsTransactionFile.getTitle());
		tdsTransactionFileDto.setFileName(tdsTransactionFile.getFileName());
		tdsTransactionFileDto.setFilePath(tdsTransactionFile.getFilePath());
		tdsTransactionFileDto.setEmployeeId(tdsTransactionFile.getEmployee().getEmployeeId());
		tdsTransactionFileDto.setUserId(tdsTransactionFile.getUserId());
		tdsTransactionFileDto.setDateCreated(tdsTransactionFile.getDateCreated());
		return tdsTransactionFileDto;
	}

}
