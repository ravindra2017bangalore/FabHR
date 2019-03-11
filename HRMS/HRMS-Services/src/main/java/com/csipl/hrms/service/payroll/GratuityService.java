package com.csipl.hrms.service.payroll;

import java.util.List;
import com.csipl.hrms.model.payroll.Gratuaty;

public interface GratuityService {
 	public List<Gratuaty> getAllGratuity(Long companyId);
 	public Gratuaty save(Gratuaty gratuity);
  }
