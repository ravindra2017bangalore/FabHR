package com.csipl.hrms.service.employee;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.employee.SeparationDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.Separation;
import com.csipl.hrms.service.employee.repository.EmployeePersonalInformationRepository;
import com.csipl.hrms.service.employee.repository.SeparationRepository;

@Transactional
@Service("separationService")
public class SeparationServiceImpl implements SeparationService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(SeparationServiceImpl.class);

	@Autowired
	private SeparationRepository separationRepository;

	@Autowired
	private EmployeePersonalInformationRepository employeePersonalInformationRepository;

	/**
	 * Method performed save OR update operation
	 */
	@Override
	public Separation save(Separation separation) {
		if (separation.getStatus().equals(StatusMessage.APPROVED_CODE)) {
			logger.info("Employee Date End for Separation  Approval ");
			Employee employee = employeePersonalInformationRepository
					.findOne(separation.getEmployee1().getEmployeeId());
			employee.setEndDate(separation.getEndDate());
			employeePersonalInformationRepository.save(employee);
		} else if (separation.getStatus().equals(StatusMessage.REJECTED_CODE)) {
			logger.info("Employee Date End for Separation  Rejection ");
			Employee employee = employeePersonalInformationRepository
					.findOne(separation.getEmployee1().getEmployeeId());
			employee.setEndDate(null);
			employeePersonalInformationRepository.save(employee);
		}
		return separationRepository.save(separation);

	}

	/**
	 * to get List of Separation from database based on employeeId
	 */
	@Override
	public List<Separation> getSeparationList(Long employeeId, Long companyId) {
		return separationRepository.getSeparationList(employeeId, companyId);
	}

	/**
	 * to get List of Separation from database based on companyId
	 */
	@Override
	public List<Separation> getAllseparationList(Long companyId) {
		return separationRepository.getAllseparationList(companyId);
	}

	/**
	 * to get Separation Object from database based on separtionId(Primary Key)
	 */
	@Override
	public Separation getSeparation(Long separationId) {
		return separationRepository.findOne(separationId);
	}

	/**
	 * to check whether Separation request already process or pending or not based
	 * on employeeId and companyId
	 * 
	 */
	@Override
	public Long checkSeparationForRequest(Long employeeId) {
		String status = StatusMessage.PENDING_CODE, status2 = StatusMessage.APPROVED_CODE;
		return separationRepository.checkSeparationForRequest(employeeId, status, status2);
	}

	/**
	 * to get List of Separation from database based on companyId and status=pending
	 */
	@Override
	public List<Separation> getAllseparationPendingList(Long companyId) {
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		return separationRepository.getAllseparationPendingList(companyId, currentDate);
	}

	@Override
	public SeparationDTO getNoticePeriodCount(Long companyId) {
		SeparationDTO separationDTO = new SeparationDTO();
		Long inNoticePeriodCount = separationRepository.getNoticePeriodCount(companyId);
		separationDTO.setInNoticePeriod(inNoticePeriodCount);
		return separationDTO;
	}

	@Override
	public SeparationDTO seperationCount(Long companyId) {
		int separationCount = separationRepository.seperationCount(companyId);
		SeparationDTO separationDTO = new SeparationDTO();
		separationDTO.setSeparationCount(separationCount);
		return separationDTO;
	}

	@Override
	public List<Separation> employeeCancelledResignReqList(Long employeeId) {
		String status = StatusMessage.CANCEL_CODE, status2 = StatusMessage.REJECTED_CODE;
		return separationRepository.employeeCancelledResignReqList(employeeId, status, status2);
	}

	@Override
	public Separation employeePendingResignReq(Long employeeId) {
		String status = StatusMessage.PENDING_CODE;
		String approvedStatus2 = StatusMessage.APPROVED_CODE;
		return separationRepository.employeePendingResignReq(employeeId, status, approvedStatus2);
	}

	@Override
	public void updateRequestStatus(Long separationId, String status, String description) {
		separationRepository.updateRequestStatus(separationId, status, description);
	}

	@Override
	public List<Separation> findAllSeparationPendingReqList(Long companyId) {
		String status = StatusMessage.PENDING_CODE;
		return separationRepository.findAllSeparationPendingReqList(companyId, status);
	}

	@Override
	public List<Separation> findAllSeparationExcludedPendingReqList(Long companyId) {
		String status = StatusMessage.PENDING_CODE;
		return separationRepository.findAllSeparationExcludedPendingReqList(companyId, status);
	}

}
