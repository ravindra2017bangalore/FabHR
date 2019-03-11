package com.csipl.tms.tmsempshift.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.tmsempshift.TMSEmpShift;

public interface TMSEmpShiftRepository extends CrudRepository<TMSEmpShift, Long> {

	String empShiftOnEmpId = "SELECT ts.shiftFName FROM TMSEmpShift es JOIN TMSShift ts on ts.shiftId = es.shiftId where employeeId =?1";

	@Query(value = empShiftOnEmpId, nativeQuery = true)
	Object[] getEmpShiftOnemployeeId(Long employeeId);

}
