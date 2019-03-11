package com.csipl.hrms.service.employee;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.model.employee.TicketRaisingHD;
import com.csipl.hrms.model.employee.TicketType;

public interface TicketRaisingService {
	 public TicketRaisingHD save(TicketRaisingHD ticketRaisingHD, MultipartFile file , boolean fileFlag , Long companyId);
	  public List<TicketRaisingHD> findAllTicketRaising(Long companyId);
	  public List<TicketRaisingHD> findAllEmpTicketRaising(Long employeeId);
	  public TicketRaisingHD findTicketRaising(Long ticketRaisingHDId);
	  public List<TicketRaisingHD> findAllTicketRaisingOpen(Long companyId);
}
