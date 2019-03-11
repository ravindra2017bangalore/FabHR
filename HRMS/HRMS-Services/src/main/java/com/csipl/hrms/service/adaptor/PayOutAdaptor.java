 package com.csipl.hrms.service.adaptor;

 import java.util.ArrayList;
import java.util.List;

 import com.csipl.hrms.dto.payrollprocess.PayOutDTO;
import com.csipl.hrms.dto.payrollprocess.PayOutListDTO;
import com.csipl.hrms.model.payrollprocess.PayOut;


public class PayOutAdaptor {
  	public PayOutListDTO databaseModelToUiDtoList(List<PayOut> payOutList) {
		 //List<PayOutDTO> payOutDtoList=new ArrayList<PayOutDTO>();
		 PayOutListDTO payOutListDto=new PayOutListDTO();
		 
		  List<PayOutDTO> earningPayHeads = new ArrayList<PayOutDTO>();
		  List<PayOutDTO> deductionPayHeads = new ArrayList<PayOutDTO>();
		 
		for (PayOut payOut : payOutList) {
			 if(payOut.getEarningDeduction()!=null) {
				 if ( payOut.getEarningDeduction().equals("EA") ) {
					 earningPayHeads.add(databaseModelToUiDto(payOut)); 
				 } else {
					 deductionPayHeads.add(databaseModelToUiDto(payOut)); 
				 }
			 }
		} 
		payOutListDto.setDeductionPayHead(deductionPayHeads);
		payOutListDto.setEarningPayHead(earningPayHeads);
 		return payOutListDto;
	}
 
	public PayOutDTO databaseModelToUiDto(PayOut payOut) {
		PayOutDTO payOutDto=new PayOutDTO();
		if(payOut.getId()!=null) {
		payOutDto.setPayHeadId(payOut.getId().getPayHeadId());
		payOutDto.setProcessMonth(payOut.getId().getProcessMonth());
		}
			payOutDto.setAmount(payOut.getAmount());
			payOutDto.setPayHeadName(payOut.getPayHeadName());
			if(payOut.getEmployee()!=null)
			payOutDto.setEmployeeId(payOut.getEmployee().getEmployeeId());
			
  		return payOutDto;
	}

}
