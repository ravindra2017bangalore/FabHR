package com.csipl.hrms.service.employee.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.csipl.hrms.model.employee.TicketRaisingHD;

public interface TicketRaisingRepository  extends CrudRepository<TicketRaisingHD,Long>{
	@Query(" from TicketRaisingHD where companyId=?1 ORDER BY  ticketRaisingHDId  DESC ") 
 	public List<TicketRaisingHD> findAllTicketRaising(Long companyId);
	
	@Query(" from TicketRaisingHD where employeeId=?1 ORDER BY  ticketRaisingHDId  DESC ") 
 	public List<TicketRaisingHD> findAllEmpTicketRaising(Long employeeId);
	
	@Query(" from TicketRaisingHD where  ticketRaisingHDId=?1 ORDER BY  ticketRaisingHDId  DESC ") 
 	public TicketRaisingHD findTicketRaising( Long ticketRaisingHDId);
	
	@Query(" from TicketRaisingHD where companyId=?1 AND status=?2 And dateCreated>=?3 ORDER BY  ticketRaisingHDId  DESC ") 
	public List<TicketRaisingHD> findAllTicketRaisingOpen(Long companyId, String ticketStatusOpen, Timestamp currentDate);
}
