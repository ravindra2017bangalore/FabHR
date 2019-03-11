package com.csipl.tms.leave.repository;

import java.util.List;
import com.csipl.tms.dto.leave.CompOffSearchDTO;

public interface CompensatoryOffPaginatonRepository {

	List<Object[]> findCompOffPagedAndFilterResult(Long companyId, CompOffSearchDTO compOffSearchDTO,boolean status);
	
}
