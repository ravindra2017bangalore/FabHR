package com.csipl.tms.attendanceregularizationrequest.service;

import java.util.List;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.tms.dto.attendanceregularizationrequest.AttendanceRegularizationRequestDTO;
import com.csipl.tms.dto.common.EntityCountDTO;
import com.csipl.tms.model.attendanceregularizationrequest.AttendanceRegularizationRequest;

public interface AttendanceRegularizationRequestService {

	public void save(AttendanceRegularizationRequest attendanceRegularizationRequest) throws ErrorHandling;

	public List<Object[]> getAllARRequest(Long companyId);

	public AttendanceRegularizationRequest getARRequest(Long arId);

	public List<AttendanceRegularizationRequest> getEmployeePendingARRequest(Long employeeId);

	public List<AttendanceRegularizationRequest> getEmployeeARRequest(Long employeeId);

	public List<Object[]> getARRequestforMonth(Long companyId, Long employeeId, String fromDate, String toDate);

	public AttendanceRegularizationRequestDTO arCount(Long companyId, Long employeeId);

	public List<Object[]> getAllPendingARRequest(Long companyId);

	public void getPendingARCount(Long longCompanyId, EntityCountDTO employeeCountDto);

	public void getNonPendingARCount(Long longCompanyId, EntityCountDTO entityCountDto);
}
