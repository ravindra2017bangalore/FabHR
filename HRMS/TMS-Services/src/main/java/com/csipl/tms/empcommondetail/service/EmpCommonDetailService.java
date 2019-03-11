package com.csipl.tms.empcommondetail.service;

import java.util.List;

import com.csipl.tms.model.empcommondetails.EmpCommonDetail;

public interface EmpCommonDetailService {

	EmpCommonDetail getEmployeeCommonDetails(Long employeeId);

	List<EmpCommonDetail> getEmployeeCommonDetailsList(Long companyId);

	Object[] getEmployeeJoiningDate(Long employeeId);

	void save(EmpCommonDetail empCommonDetail);
}
