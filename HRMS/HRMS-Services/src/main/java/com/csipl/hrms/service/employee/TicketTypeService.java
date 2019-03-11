package com.csipl.hrms.service.employee;

import java.util.List;

import com.csipl.hrms.model.employee.Skill;
import com.csipl.hrms.model.employee.TicketType;

public interface TicketTypeService {
	public TicketType save(TicketType ticketType);
    public List<TicketType> findAllTicketType(Long companyId);
    public TicketType findTicketType(Long ticketTypeId);
 
    
}
