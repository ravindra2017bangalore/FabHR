package com.csipl.tms.leave.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.leave.repository.LeaveTypeRepository;
import com.csipl.tms.model.leave.TMSLeaveType;



@Transactional
@Service("leaveTypeService")
public class LeaveTypeServiceImpl implements LeaveTypeService {
	
	private static final Logger log = LoggerFactory.getLogger(LeaveTypeServiceImpl.class);

	@Autowired
	LeaveTypeRepository leaveTypeRepository;
	
	
	@Override
	public TMSLeaveType save(TMSLeaveType leavePeriod) {
	
		return leaveTypeRepository.save(leavePeriod);
	}

	@Override
	public List<TMSLeaveType> findAllLeaveType(Long companyId) {
	
		return leaveTypeRepository.findAllLeaveType(companyId);
	}

	/* (non-Javadoc)
	 * @see com.csipl.tms.leave.service.LeaveTypeService#getLeaveTypeById(java.lang.Long)
	 */
	@Override
	public TMSLeaveType getLeaveTypeById(Long leaveTypeId) {
		// TODO Auto-generated method stub
		return leaveTypeRepository. getLeaveTypeById(leaveTypeId);
	}

	/* (non-Javadoc)
	 * @see com.csipl.tms.leave.service.LeaveTypeService#findAllLeavePeriod(java.lang.Long)
	 */
	@Override
	public List<TMSLeaveType> findAllLeavePeriod(Long leavePeriodId) {
		log.info("LeaveTypeServiceImpl.findAllLeavePeriod()");
		return leaveTypeRepository.findAllPeriod(leavePeriodId);
	}


	

	

}
