package com.csipl.tms.holiday.adaptor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.tms.dto.holiday.HolidayDTO;
import com.csipl.tms.model.holiday.TMSHolidays;
import com.csipl.tms.model.leave.TMSLeavePeriod;
import com.csipl.tms.model.leave.TMSLeaveTypeMaster;
import com.csipl.tms.service.Adaptor;

public class HolidayAdaptor implements Adaptor<HolidayDTO, TMSHolidays> {

	@Override
	public List<TMSHolidays> uiDtoToDatabaseModelList(List<HolidayDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HolidayDTO> databaseModelToUiDtoList(List<TMSHolidays> holidayList) {
		List<HolidayDTO> holidayDtoList = new ArrayList<HolidayDTO>();
		for (TMSHolidays holiday : holidayList) {
			holidayDtoList.add(databaseModelToUiDto(holiday));
		}
		return holidayDtoList;

	}

	
	public TMSHolidays holidayuiDtoToDatabaseModel(HolidayDTO holidayDto,Long leavePeriodId) {
		TMSHolidays holiday = new TMSHolidays();

		holiday.setHolidayId(holidayDto.getHolidayId());
		holiday.setYear(holidayDto.getYear());
		holiday.setFromDate(holidayDto.getFromDate());
		holiday.setToDate(holidayDto.getToDate());
		holiday.setHolidayName(holidayDto.getHolidayName());
		holiday.setIsMandatory(holidayDto.getIsMandatory());
		holiday.setUserId(holidayDto.getUserId());
		if (holidayDto.getHolidayId() == null)
			holiday.setCreatedDate(new Date());
		else
			holiday.setCreatedDate(holidayDto.getCreatedDate());

		holiday.setDay(holidayDto.getDay());
		holiday.setUpdatedDate(new Date());
		holiday.setUpdateUserId(holidayDto.getUpdateUserId());
		holiday.setCompanyId(holidayDto.getCompanyId());
		holiday.setActiveStatus(holidayDto.getActiveStatus());
		TMSLeavePeriod leavePeriod=new TMSLeavePeriod();
		leavePeriod.setLeavePeriodId(leavePeriodId);
		holiday.setLeavePeriodId(leavePeriodId);;
		return holiday;
	}

	@Override
	public HolidayDTO databaseModelToUiDto(TMSHolidays holiday) {
		HolidayDTO holidayDto = new HolidayDTO();
		System.out.println("===========getHolidayId========="+holiday.getHolidayId());
		holidayDto.setHolidayId(holiday.getHolidayId());
		holidayDto.setYear(holiday.getYear());
		holidayDto.setFromDate(holiday.getFromDate());
		holidayDto.setToDate(holiday.getToDate());
		holidayDto.setHolidayName(holiday.getHolidayName());
		holidayDto.setIsMandatory(holiday.getIsMandatory());
		holidayDto.setLeavePeriodId(holiday.getLeavePeriodId());
		holidayDto.setActiveStatus(holiday.getActiveStatus());
		if (holiday.getIsMandatory() == 1)
			holidayDto.setIsMandatoryValue("Mandatory");
		else
			holidayDto.setIsMandatoryValue("Optional");
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
		String parameter;
		if (holiday.getDay() > 1) {
			String delim = "";
			parameter = "";

			Calendar c = Calendar.getInstance();
			c.setTime(holiday.getFromDate());
			Date date = holiday.getFromDate();

			for (int i = 0; i < holiday.getDay(); i++) {

				parameter = parameter.concat(delim);
				delim = ",";
				parameter = parameter.concat(simpleDateformat.format(date));
			
				c.add(Calendar.DATE, 1);
				date = c.getTime();
			}

		} else
		parameter = simpleDateformat.format(holiday.getFromDate());
		holidayDto.setDaysName(parameter);
		holidayDto.setUserId(holiday.getUserId());
		holidayDto.setDay(holiday.getDay());
		holidayDto.setCompanyId(holiday.getCompanyId());
		holidayDto.setCreatedDate(holiday.getCreatedDate());
		return holidayDto;
	}

	public List<HolidayDTO> databaseModelObjToUiDtoList(List<Object[]> tmsHolidays) {
		List<HolidayDTO> arRequestDtoList = new ArrayList<HolidayDTO>();
		for (Object[] tmsHolidaysObj : tmsHolidays) {
			HolidayDTO holidayDto = new HolidayDTO();
			String holiDayName = tmsHolidaysObj[2] != null ? (String) tmsHolidaysObj[2] : null;
			Long companyId = tmsHolidaysObj[3] != null ? Long.parseLong(tmsHolidaysObj[3].toString()) : null;
			Date fromDate = tmsHolidaysObj[4] != null ? (Date) (tmsHolidaysObj[4]) : null;
			Date toDate = tmsHolidaysObj[5] != null ? (Date) (tmsHolidaysObj[5]) : null;
			Long day = tmsHolidaysObj[6] != null ? Long.parseLong(tmsHolidaysObj[6].toString()) : null;
			holidayDto.setHolidayName(holiDayName);
			holidayDto.setCompanyId(companyId);
			holidayDto.setFromDate(fromDate);
			holidayDto.setToDate(toDate);
			holidayDto.setDay(day);
			arRequestDtoList.add(holidayDto);
		}

		return arRequestDtoList;
	}
	
	public List<HolidayDTO> holidayModelToholidayDtoList(List<TMSHolidays> holidayList) {
		List<HolidayDTO> holidayDtoList = new ArrayList<HolidayDTO>();
		for (TMSHolidays holiday : holidayList) {
			holidayDtoList.add(holidayModelToholidayDto(holiday));
		}
		return holidayDtoList;

	}
	
	public HolidayDTO holidayModelToholidayDto(TMSHolidays holiday) {
		HolidayDTO holidayDto = new HolidayDTO();
		System.out.println("===========getHolidayId========="+holiday.getHolidayId());
		holidayDto.setHolidayId(holiday.getHolidayId());
		holidayDto.setYear(holiday.getYear());
		holidayDto.setHolidayName(holiday.getHolidayName());
		holidayDto.setUserId(holiday.getUserId());
		holidayDto.setDay(holiday.getDay());
		holidayDto.setCompanyId(holiday.getCompanyId());
		holidayDto.setFromDate(holiday.getFromDate());
		holidayDto.setToDate(holiday.getToDate());
		Calendar c = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(holiday.getFromDate());
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(holiday.getToDate());
		
		if(cal.get(Calendar.MONTH)==Calendar.getInstance().get(Calendar.MONTH)-1)
		{
			c.set(Calendar.DAY_OF_MONTH, 1);
			holidayDto.setFromDate(c.getTime());
		}
		else
		{
			if(cal1.get(Calendar.MONTH)>Calendar.getInstance().get(Calendar.MONTH))
			{
				c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
				String strDate = dateFormat.format(c.getTime());  
				holidayDto.setToDate(c.getTime());
				System.out.println(holidayDto.getToDate());
			}
			
		}
		return holidayDto;
	}

	@Override
	public TMSHolidays uiDtoToDatabaseModel(HolidayDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}


}