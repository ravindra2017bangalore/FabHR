package com.csipl.hrms.service.employee;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.TicketType;
import com.csipl.hrms.service.employee.repository.TicketTypeRepository;

@Service("TicketTypeService")
public class TicketTypeServiceImpl implements TicketTypeService{
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(TicketTypeServiceImpl.class);

	@Autowired
	TicketTypeRepository ticketTypeRepoitory;
	/**
	 * Method performed save OR update operation
	 */
	@Override
	public TicketType save(TicketType ticketType) {
 		return ticketTypeRepoitory.save(ticketType);
	}
	/**
	 * to get List of TicketType from database based on companyId
	 */
	@Override
	public List<TicketType> findAllTicketType(Long companyId) {
 		return ticketTypeRepoitory.findAllticketType(companyId);
	}
	/**
	 * to get TicketType Object from database based on ticketTypeId (Primary Key)
	 */
	@Override
	public TicketType findTicketType(Long ticketTypeId) {
 		return ticketTypeRepoitory.findOne(ticketTypeId);
	}
 
}
