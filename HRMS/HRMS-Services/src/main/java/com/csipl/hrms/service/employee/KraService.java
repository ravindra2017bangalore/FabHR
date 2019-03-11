package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.model.employee.Kra;

public interface KraService {

	public Kra save(Kra kra);
	public List<Kra> findAllKra(Long companyId);
	public Kra findKra(Long kraId);
}
