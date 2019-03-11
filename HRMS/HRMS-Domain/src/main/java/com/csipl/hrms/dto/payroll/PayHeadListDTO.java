package com.csipl.hrms.dto.payroll;

import java.util.List;







public class PayHeadListDTO {
	private List<PayHeadDTO> earningPayHead;
	private List<PayHeadDTO> deductionPayHead;
	/*private ErrorHandling errorHandling;
	
	
	public ErrorHandling getErrorHandling() {
		return errorHandling;
	}
	public void setErrorHandling(ErrorHandling errorHandling) {
		this.errorHandling = errorHandling;
	}*/
	public List<PayHeadDTO> getEarningPayHead() {
		return earningPayHead;
	}
	public void setEarningPayHead(List<PayHeadDTO> earningPayHead) {
		this.earningPayHead = earningPayHead;
	}
	public List<PayHeadDTO> getDeductionPayHead() {
		return deductionPayHead;
	}
	public void setDeductionPayHead(List<PayHeadDTO> deductionPayHead) {
		this.deductionPayHead = deductionPayHead;
	}

}
