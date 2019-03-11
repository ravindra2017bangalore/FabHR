package com.csipl.hrms.service.payroll.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payroll.TdsGroup;

public interface InvestmentRepository extends CrudRepository<TdsGroup, Long> {
	
	@Query(" from TdsGroup where  (effectiveEndDate is null or effectiveEndDate>?1) and (effectiveStartDate is NOT null and effectiveStartDate<=?1) and companyId =?2")
    public List<TdsGroup> findAllInvestment(Date today, Long companyId);
	
	@Query(" from TdsGroup where tdsGroupId=?1")
	public TdsGroup findInvestment(long tdsGroupId);	
}
