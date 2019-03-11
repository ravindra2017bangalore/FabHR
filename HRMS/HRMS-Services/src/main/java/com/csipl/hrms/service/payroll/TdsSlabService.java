package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.payroll.TdsSlabHd;

public interface TdsSlabService {
	public List<TdsSlabHd> getAllTdsSlabHd(Long companyId);
 	public TdsSlabHd save(TdsSlabHd tdsSlabHd);
	public TdsSlabHd getTdsSlabHd(Long tdsSlabHdId);


}
