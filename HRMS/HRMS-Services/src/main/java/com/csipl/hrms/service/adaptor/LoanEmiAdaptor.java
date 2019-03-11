package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.dto.payroll.LoanEMIDTO;
import com.csipl.hrms.model.payroll.LoanEMI;
import com.csipl.hrms.model.payroll.LoanIssue;

public class LoanEmiAdaptor   {

 	public List<LoanEMI> uiDtoToDatabaseModelListSettlement(List<LoanEMIDTO> loanEMIDtoList,LoanIssue loanIssue) {
		 List<LoanEMI> loanEMIList=new ArrayList<LoanEMI>();
		
		for (LoanEMIDTO loanEMIDto : loanEMIDtoList) {
			loanEMIList.add(uiDtoToDatabaseModelListSettlement(loanEMIDto, loanIssue));
		}
  		return loanEMIList;
	}

 	public List<LoanEMIDTO> databaseModelToUiDtoList(List<LoanEMI> loanEMIList) {
 		return null;
	}

 	public LoanEMI uiDtoToDatabaseModelListSettlement(LoanEMIDTO loanEMIDto,LoanIssue loanIssue) {
		LoanEMI loanEMI=new LoanEMI();
 		loanEMI.setEmiDate(loanEMIDto.getEmiDate());
  		if(!loanIssue.getPaymentMode().equals("SA")) {
  		loanEMI.setEmiAmount(loanIssue.getSettlementAmount());
  		loanEMI.setEmiDate(loanEMIDto.getEmiDate());
 		loanEMI.setRemarks(loanIssue.getRemark());
 		loanEMI.setLoanIssue(loanIssue);
 		}
 		return loanEMI;
	}

 	public LoanEMIDTO databaseModelToUiDto(LoanEMI loanEMI) {
 		return null;
	}

}
