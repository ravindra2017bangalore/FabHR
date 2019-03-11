package com.csipl.hrms.dto.payrollprocess;

import java.math.BigDecimal;
import java.util.List;

public class PayOutListDTO {
	private List<PayOutDTO> earningPayHead;
	private List<PayOutDTO> deductionPayHead;

	public final List<PayOutDTO> getEarningPayHead() {
		return earningPayHead;
	}

	public final void setEarningPayHead(List<PayOutDTO> earningPayHead) {
		this.earningPayHead = earningPayHead;
	}

	public final List<PayOutDTO> getDeductionPayHead() {
		return deductionPayHead;
	}

	public final void setDeductionPayHead(List<PayOutDTO> deductionPayHead) {
		this.deductionPayHead = deductionPayHead;
	}

}
