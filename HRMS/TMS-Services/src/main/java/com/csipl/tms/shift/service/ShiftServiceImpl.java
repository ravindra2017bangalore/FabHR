package com.csipl.tms.shift.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*import com.csipl.tms.dto.shift.RecordCountDTO;
import com.csipl.tms.dto.shift.ShiftSearchDTO;*/
import com.csipl.tms.model.shift.Shift;
//import com.csipl.tms.shift.repository.ShiftPagingAndFilterRepository;
import com.csipl.tms.shift.repository.ShiftRepository;

@Service("shiftService")
public class ShiftServiceImpl implements ShiftService {
	@Autowired
	private ShiftRepository shiftRepository;

	/*
	 * @Autowired private ShiftPagingAndFilterRepository
	 * shiftPagingAndFilterRepository;
	 */

	@Override
	public Shift save(Shift shift) {
		return shiftRepository.save(shift);
	}

	@Override
	public List<Shift> findAllShift(Long companyId) {
		return shiftRepository.findAllShift(companyId);
	}

	@Override
	public Shift findShift(Long shiftId) {
		return shiftRepository.findShift(shiftId);
	}
	/*
	 * @Override public List<Object[]> findShiftPagingAndFilter(Long
	 * companyId,ShiftSearchDTO shiftSearchDto ) {
	 * 
	 * return shiftPagingAndFilterRepository.getShiftPagingAndFilter(companyId,
	 * shiftSearchDto); }
	 * 
	 * @Override public void getEmployeeCount(Long longCompanyId, RecordCountDTO
	 * recordCountDto) {
	 * recordCountDto.setCount(shiftRepository.getShiftCount(longCompanyId));
	 */

}
