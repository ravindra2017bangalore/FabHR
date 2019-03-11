package com.csipl.hrms.service.payroll;

import java.util.List;

import com.csipl.hrms.model.payroll.Epf;
import com.csipl.hrms.model.payroll.Esi;

public interface EsicService {
  	 public Esi save(Esi esic);
 	 public Esi getESI( Long companyId );
}
