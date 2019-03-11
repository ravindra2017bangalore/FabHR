package com.csipl.tms.shift.service;

import java.util.List;
/*
import com.csipl.tms.dto.shift.RecordCountDTO;
import com.csipl.tms.dto.shift.ShiftSearchDTO;*/
import com.csipl.tms.model.shift.Shift;

public interface ShiftService {
	public Shift save(Shift shift);
	public List<Shift> findAllShift(Long companyId);
	//public List<Object[]> findShiftPagingAndFilter(Long companyId,ShiftSearchDTO shiftSearchDto );
	public Shift findShift( Long shiftId);
	//public void getEmployeeCount(Long longCompanyId, RecordCountDTO recordCountDto);
}