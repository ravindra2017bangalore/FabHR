package com.csipl.hrms.service.organization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.common.MandatoryInfo;

public interface MandatoryInfoRepository extends CrudRepository<MandatoryInfo, Long> {

	@Query("  from MandatoryInfo WHERE companyId=?1 ") 
	List<MandatoryInfo> findMandatoryInfo(Long companyId);
	
	
}
