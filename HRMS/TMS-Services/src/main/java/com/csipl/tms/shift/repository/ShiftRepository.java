package com.csipl.tms.shift.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.shift.Shift;

public interface ShiftRepository extends CrudRepository <Shift, Long> {
	@Query(" from Shift where companyId =?1 ORDER BY  shiftId  DESC ")
    public List<Shift> findAllShift(Long companyId);
	
	@Query(" from Shift where shiftId=?1 ORDER BY  shiftId  DESC ")
    public Shift findShift( Long shiftId);

	@Query(" SELECT count(*) from Shift  where companyId=?1 ")
	public int getShiftCount(Long longCompanyId);
}