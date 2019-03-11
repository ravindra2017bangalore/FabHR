package com.csipl.hrms.service.adaptor;

import java.util.List;

import com.csipl.hrms.dto.payroll.TransactionApprovedHdDTO;
import com.csipl.hrms.model.payroll.TransactionApprovedHd;

public class TdsApprovedAdaptor implements Adaptor<TransactionApprovedHdDTO, TransactionApprovedHd> {

	@Override
	public List<TransactionApprovedHd> uiDtoToDatabaseModelList(List<TransactionApprovedHdDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionApprovedHdDTO> databaseModelToUiDtoList(List<TransactionApprovedHd> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionApprovedHd uiDtoToDatabaseModel(TransactionApprovedHdDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionApprovedHdDTO databaseModelToUiDto(TransactionApprovedHd transactionApprovedHd) {
		TransactionApprovedHdDTO transactionApprovedHdDto=new TransactionApprovedHdDTO();
		transactionApprovedHdDto.setStatus(transactionApprovedHd.getActive());
		transactionApprovedHdDto.setStatus(transactionApprovedHd.getStatus());
		transactionApprovedHdDto.setFinancialYear(transactionApprovedHd.getFinancialYear());
		return transactionApprovedHdDto;
	}

}
