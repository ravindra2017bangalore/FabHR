package com.csipl.hrms.service.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.employee.Skill;
import com.csipl.hrms.model.employee.TicketType;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {
	@Query(" from TicketType where companyId=?1 And activeStatus='AC' ORDER BY ticketTypeId DESC ") 
 	public List<TicketType> findAllticketType(Long companyId);
 }
