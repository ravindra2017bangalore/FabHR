package com.csipl.tms.rules.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.tms.model.rules.SandWichRule;
 
public interface RulesRepository extends CrudRepository<SandWichRule, Long> {
	@Query("from SandWichRule where companyId=?1")
	public List<SandWichRule> getSandwichRules(Long companyId);
}
