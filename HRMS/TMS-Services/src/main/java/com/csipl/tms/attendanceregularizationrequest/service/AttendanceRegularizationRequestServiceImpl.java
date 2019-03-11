package com.csipl.tms.attendanceregularizationrequest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.services.notification.NotificationServices;
import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.tms.attendanceregularizationrequest.repository.AttendanceRegularizationRequestRepository;
import com.csipl.tms.dto.attendanceregularizationrequest.AttendanceRegularizationRequestDTO;
import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.model.attendanceregularizationrequest.AttendanceRegularizationRequest;

@Service("attendanceRegularizationRequestService")
public class AttendanceRegularizationRequestServiceImpl implements AttendanceRegularizationRequestService {

	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private NotificationServices notificationServices;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;

	@Autowired
	private AttendanceRegularizationRequestRepository attendanceRegularizationRequestRepository;

	private static final Logger logger = LoggerFactory.getLogger(AttendanceRegularizationRequestServiceImpl.class);

	@Override
	public void save(AttendanceRegularizationRequest attendanceRegularizationRequest) throws ErrorHandling {

		NotificationMailSmsDto notificationMailSmsDto = new NotificationMailSmsDto();

		logger.info("approval id===" + attendanceRegularizationRequest.getApprovalId());

		if (attendanceRegularizationRequest.getApprovalId() != null) {
			AttendanceRegularizationRequest arRequest = attendanceRegularizationRequestRepository
					.save(attendanceRegularizationRequest);
			Employee employee = employeePersonalInformationService
					.getEmployeeInfo(attendanceRegularizationRequest.getApprovalId());
			notificationMailSmsDto.setNotificationType(StatusMessage.AR_CODE);

			String status;
			if (arRequest.getStatus().equals(StatusMessage.APPROVED_CODE)) {
				status = StatusMessage.APPROVED_VALUE;

			} else {
				status = StatusMessage.REJECTED_VALUE;
			}

			List<Object[]> reportingTo = employeePersonalInformationService
					.getEmpReportingToEmail(attendanceRegularizationRequest.getEmployeeId());
			List<String> to = new ArrayList<String>();
			if (reportingTo.size() > 0) {
				for (Object obj[] : reportingTo) {
					logger.info("reporting to email id" + obj[2].toString());
					to.add(obj[2].toString());
				}
			}
			to.add(employee.getOfficialEmail());
			//notificationMailSmsDto.setMobileNo(employee.getContactNo());
			notificationMailSmsDto.setTo(to);
			// List<String> cc = new ArrayList<String>();
			notificationMailSmsDto.setHtml(true);
			Map<String, String> model = new HashMap<String, String>();
			model.put("firstName", employee.getFirstName());
			model.put("lastName", employee.getLastName());
			model.put("status", status);
			notificationMailSmsDto.setMapAttribute(model);
			notificationMailSmsDto.setTempLateName("templates/InviteTemplate.vm");
			notificationServices.sendNotification(notificationMailSmsDto);

		} else {

			int count = 0;
			if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.PENDING_CODE)
					&& attendanceRegularizationRequest.getArID() != null) {
				//System.out.println("first case--");
				count = attendanceRegularizationRequestRepository.checkDateValidationOfAR(
						attendanceRegularizationRequest.getEmployeeId(), attendanceRegularizationRequest.getFromDate(),
						attendanceRegularizationRequest.getToDate(), attendanceRegularizationRequest.getArID());
				logger.info("AR  Count for update on same date--- " + count);
			}

			if (attendanceRegularizationRequest.getStatus().equals(StatusMessage.PENDING_CODE)
					&& attendanceRegularizationRequest.getArID() == null) {
				//System.out.println("second case--");
				count = attendanceRegularizationRequestRepository.checkDateValidationOfAROnSameDate(
						attendanceRegularizationRequest.getEmployeeId(), attendanceRegularizationRequest.getFromDate(),
						attendanceRegularizationRequest.getToDate());
				logger.info("AR  Count for new on same date and diff date--- " + count);
			}

			if (count < 1) {
				attendanceRegularizationRequestRepository.save(attendanceRegularizationRequest);
				Employee employee = employeePersonalInformationService
						.getEmployeeInfo(attendanceRegularizationRequest.getEmployeeId());

				notificationMailSmsDto.setNotificationType(StatusMessage.AR_CODE);
				List<Object[]> reportingTo = employeePersonalInformationService
						.getEmpReportingToEmail(attendanceRegularizationRequest.getEmployeeId());
				List<String> to = new ArrayList<String>();
				if (reportingTo.size() > 0) {
					for (Object obj[] : reportingTo) {
						logger.info("reporting to email id" + obj[2].toString());
						to.add(obj[2].toString());
					}
				}
				to.add(employee.getOfficialEmail());
			//	notificationMailSmsDto.setMobileNo(employee.getContactNo());
				notificationMailSmsDto.setTo(to);
				// List<String> cc = new ArrayList<String>();
				notificationMailSmsDto.setHtml(true);
				Map<String, String> model = new HashMap<String, String>();
				model.put("firstName", employee.getFirstName());
				model.put("lastName", employee.getLastName());
				notificationMailSmsDto.setMapAttribute(model);
				notificationMailSmsDto.setTempLateName("templates/InviteTemplate.vm");
				notificationServices.sendNotification(notificationMailSmsDto);

			} else {
				logger.info("You have already applied AR in the given duration.");
				throw new ErrorHandling("You have already applied AR in the given duration.");
			}
		}
	}

	@Override
	public List<Object[]> getAllARRequest(Long companyId) {

		String query = "SELECT ecd.employeeCode,ecd.firstName,ecd.lastName,ecd.departmentName,ar.arID,ar.dateCreated,ar.arCategory,ar.actionableDate,ar.fromDate,ar.toDate,ar.days,ar.status,ar.employeeId,ar.employeeRemark,ar.userId ,ecd.designationName FROM TMSARRequest ar JOIN EmpCommonDetails ecd on ecd.employeeId=ar.employeeId where ar.companyId=?1 and status  !='P'";
		Query nativeQuery = entityManager.createNativeQuery(query);
		nativeQuery.setParameter(1, companyId);
		@SuppressWarnings("unchecked")
		final List<Object[]> arResultList = nativeQuery.getResultList();
		return arResultList;
	}

	@Override
	public AttendanceRegularizationRequest getARRequest(Long arId) {
		return attendanceRegularizationRequestRepository.getARRequest(arId);
	}

	@Override
	public List<AttendanceRegularizationRequest> getEmployeeARRequest(Long employeeId) {
		return attendanceRegularizationRequestRepository.getEmployeeARRequest(employeeId);
	}

	@Override
	public List<Object[]> getARRequestforMonth(Long companyId, Long employeeId, String fromDate, String toDate) {

		String query = "SELECT * FROM TMSARRequest where companyId=?1 and employeeId=?2 and fromDate >=?3  and toDate <=?4 ORDER by fromDate ASC";
		Query nativeQuery = entityManager.createNativeQuery(query);
		nativeQuery.setParameter(1, companyId).setParameter(2, employeeId).setParameter(3, fromDate).setParameter(4,
				toDate);
		@SuppressWarnings("unchecked")
		final List<Object[]> resultList = nativeQuery.getResultList();
		System.out.println("AttendanceRegularizationRequest resultList size------>" + resultList.size());
		return resultList;
		/*
		 * return
		 * attendanceRegularizationRequestRepository.getAttendanceRegularizationRequest(
		 * companyId,employeeId,fromDate,toDate);
		 */
	}

	@Override
	public AttendanceRegularizationRequestDTO arCount(Long companyId, Long employeeId) {
		int arCount = attendanceRegularizationRequestRepository.arCount(companyId, employeeId);
		AttendanceRegularizationRequestDTO attendanceRegularizationRequestDTO = new AttendanceRegularizationRequestDTO();
		attendanceRegularizationRequestDTO.setArCount(arCount);
		return attendanceRegularizationRequestDTO;
	}

	@Override
	public List<AttendanceRegularizationRequest> getEmployeePendingARRequest(Long employeeId) {
		return attendanceRegularizationRequestRepository.getEmployeePendingARRequest(employeeId);
	}

	@Override
	public List<Object[]> getAllPendingARRequest(Long companyId) {
		String query = "SELECT ecd.employeeCode,ecd.firstName,ecd.lastName,ecd.departmentName,ar.arID,ar.dateCreated,ar.arCategory,ar.actionableDate,ar.fromDate,ar.toDate,ar.days,ar.status,ar.employeeId,ar.employeeRemark,ar.userId  ,ecd.designationName  FROM TMSARRequest ar JOIN EmpCommonDetails ecd on ecd.employeeId=ar.employeeId where ar.companyId=?1 and status ='PEN'";
		Query nativeQuery = entityManager.createNativeQuery(query);
		nativeQuery.setParameter(1, companyId);
		@SuppressWarnings("unchecked")
		final List<Object[]> arResultList = nativeQuery.getResultList();
		return arResultList;
	}

	@Override
	public void getPendingARCount(Long longCompanyId, EntityCountDTO searchDto) {
		searchDto.setCount(attendanceRegularizationRequestRepository.getPendingARCount(longCompanyId));
	}

	@Override
	public void getNonPendingARCount(Long longCompanyId, EntityCountDTO searchDto) {
		searchDto.setCount(attendanceRegularizationRequestRepository.getNonPendingARCount(longCompanyId));

	}

}
