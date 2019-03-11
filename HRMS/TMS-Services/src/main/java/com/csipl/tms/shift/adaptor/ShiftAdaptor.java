package com.csipl.tms.shift.adaptor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.employee.EmployeeDTO;
//import com.csipl.hrms.common.model.Company;
//import com.csipl.hrms.common.enums.DropDownEnum;
//import com.csipl.hrms.service.cache.DropDownCache;
import com.csipl.tms.dto.shift.ShiftDTO;
import com.csipl.tms.model.shift.Shift;
import com.csipl.tms.service.Adaptor;
import com.csipl.common.services.dropdown.DropDownCache;

public class ShiftAdaptor implements Adaptor<ShiftDTO, Shift> {

	@Override
	public List<Shift> uiDtoToDatabaseModelList(List<ShiftDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShiftDTO> databaseModelToUiDtoList(List<Shift> shiftList) {
		List<ShiftDTO> shiftDtoList = new ArrayList<ShiftDTO>();
		for (Shift shift : shiftList) {
			shiftDtoList.add(databaseModelToUiDto(shift));
		}
		return shiftDtoList;

	}

	@Override
	public Shift uiDtoToDatabaseModel(ShiftDTO shiftDto) {
		Shift shift = new Shift();
		// Company company = new Company();
		shift.setShiftId(shiftDto.getShiftId());
		shift.setShiftFName(shiftDto.getShiftFName());
		shift.setGraceTime(shiftDto.getGraceTime());
		shift.setGraceFrqInMonth(shiftDto.getGraceFrqInMonth());
		shift.setGraceTime(shiftDto.getGraceTime());
		shift.setStartTime(shiftDto.getStartTime());
		String fromtime = shiftDto.getStartTime().substring(0, 2);

		Long fromTime = Long.parseLong(fromtime);
		if (fromTime > 12) {
			shift.setFromTime(String.valueOf(fromTime - 12) + ":" + shiftDto.getStartTime().substring(3, 5));
			shift.setStartPeriod("PM");
		} else {
			shift.setStartPeriod("AM");
			shift.setFromTime(shiftDto.getStartTime());
		}

		String totime = shiftDto.getEndTime().substring(0, 2);
		String sbEnd = shiftDto.getEndTime().substring(3, 5);
		Long toTime = Long.parseLong(totime);
		if (toTime > 12) {
			shift.setToTime(String.valueOf((toTime - 12)) + ":" + sbEnd);
			shift.setEndPeriod("PM");
		} else {
			shift.setEndPeriod("AM");
			shift.setToTime(shiftDto.getEndTime());
		}
		String dateStart = "01/14/2012 " + shiftDto.getStartTime() + ":00";
		String dateEnd = "01/14/2012 " + shiftDto.getEndTime() + ":00";
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		try {
			Date d1 = format.parse(dateStart);
			Date d2 = format.parse(dateEnd);
			long diff = d2.getTime() - d1.getTime();
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			shift.setShiftDuration(diffHours + "." + diffMinutes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		shift.setEndTime(shiftDto.getEndTime());
		if (shiftDto.getShiftId() == null)
			shift.setCreatedDate(new Date());
		else
			shift.setCreatedDate(shiftDto.getCreatedDate());
		shift.setUserId(shiftDto.getUserId());
		shift.setUpdateUserId(shiftDto.getUpdateUserId());
		// company.setCompanyId(shiftDto.getCompanyId());
		// shift.setCompany(company);
		shift.setCompanyId(shiftDto.getCompanyId());
		shift.setActiveStatus(shiftDto.getActiveStatus());
		shift.setEffectiveDate(shiftDto.getEffectiveDate());
		return shift;
	}

	@Override
	public ShiftDTO databaseModelToUiDto(Shift shift) {
		ShiftDTO shiftDto = new ShiftDTO();
		shiftDto.setShiftId(shift.getShiftId());
		shiftDto.setShiftFName(shift.getShiftFName());
		shiftDto.setShiftDuration(shift.getShiftDuration());
		shiftDto.setStartPeriod(shift.getStartPeriod());
		shiftDto.setStartTime(shift.getStartTime());
		shiftDto.setEndPeriod(shift.getEndPeriod());
		shiftDto.setEndTime(shift.getEndTime());
		shiftDto.setGraceTime(shift.getGraceTime());
		shiftDto.setGraceFrqInMonth(shift.getGraceFrqInMonth());
		shiftDto.setCreatedDate(shift.getCreatedDate());
		shiftDto.setUserId(shift.getUserId());
		shiftDto.setEffectiveDate(shift.getEffectiveDate());
		shiftDto.setCompanyId(shift.getCompanyId());
		/*
		 * if (shift.getActiveStatus().equals("AC"))
		 * shiftDto.setActiveStatusValue("Active"); else
		 * shiftDto.setActiveStatusValue("Deactive");
		 */

		shiftDto.setActiveStatusValue(DropDownCache.getInstance()
				.getDropDownValue(DropDownEnum.Status.getDropDownName(), shift.getActiveStatus()));
		shiftDto.setActiveStatus(shift.getActiveStatus());
		return shiftDto;
	}

	/*public List<ShiftDTO> modeltoDTOList(List<Object[]> shiftList, ShiftSearchDTO shiftSearchDto) {
		List<ShiftDTO> shiftDTOList = new ArrayList<ShiftDTO>();
		for (Object[] shiftObj : shiftList) {
			ShiftDTO shiftDto = new ShiftDTO();
			Long shiftId = shiftObj[0] != null ? Long.parseLong(shiftObj[0].toString()) : null;
			String shiftName = shiftObj[1] != null ? (String) shiftObj[1] : null;
			String startTime = shiftObj[2] != null ? (String) (shiftObj[2]) : null;
			String endTime = shiftObj[3] != null ? (String) (shiftObj[3]) : null;
			String activeStatus = shiftObj[4] != null ? (String) shiftObj[4] : null;
			String graceTime = shiftObj[5] != null ? (String) (shiftObj[5]) : null;
			Long graceFreqInMonth = shiftObj[6] != null ? Long.parseLong(shiftObj[6].toString()) : null;
			Date effectiveDate = shiftObj[7] != null ? (Date) (shiftObj[7]) : null;
			shiftDto.setShiftId(shiftId);
			shiftDto.setShiftFName(shiftName);
			shiftDto.setStartTime(startTime);
			shiftDto.setEndTime(endTime);
			shiftDto.setActiveStatus(activeStatus);
			shiftDto.setGraceTime(graceTime);
			shiftDto.setGraceFrqInMonth(graceFreqInMonth);
			shiftDto.setEffectiveDate(effectiveDate);
			shiftDTOList.add(shiftDto);
		}
		return shiftDTOList;
	}
*/
}