package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.payroll.Epf;

public interface EpfService {
	public Epf save(Epf epf );
// 	public List<Epf> findAllEpfs();
 	public Epf  getEPF( Long companyId );
	
}
