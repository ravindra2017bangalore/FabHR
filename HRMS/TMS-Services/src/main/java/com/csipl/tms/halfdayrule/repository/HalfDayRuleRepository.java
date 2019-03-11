package com.csipl.tms.halfdayrule.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.halfdayrule.HalfDayRule;

public interface HalfDayRuleRepository extends CrudRepository<HalfDayRule, Long> {

	@Query("from HalfDayRule where companyId=?1")
	public HalfDayRule getHalfDayRule(Long companyId);

}
