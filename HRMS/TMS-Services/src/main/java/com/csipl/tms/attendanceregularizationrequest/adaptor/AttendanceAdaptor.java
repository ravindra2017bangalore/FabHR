package com.csipl.tms.attendanceregularizationrequest.adaptor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.csipl.tms.dto.attendancelog.AttendanceLogDTO;
import com.csipl.tms.dto.attendanceregularizationrequest.PunchTimeDetailDTO;
import com.csipl.tms.dto.attendanceregularizationrequest.SystemAttendanceDTO;
import com.csipl.tms.model.attendanceregularizationrequest.PunchTimeDetail;
import com.csipl.tms.service.Adaptor;

public class AttendanceAdaptor implements Adaptor<PunchTimeDetailDTO,PunchTimeDetail>{

	@Override
	public List<PunchTimeDetail> uiDtoToDatabaseModelList(List<PunchTimeDetailDTO> uiobj) {
		return null;
	}

	@Override
	public List<PunchTimeDetailDTO> databaseModelToUiDtoList(List<PunchTimeDetail> dbobj) {
		return null;
	}

	
	public PunchTimeDetail uiDtoTopunchTimeDetailModel(PunchTimeDetailDTO punchTimeDetailDto,Long count) {
		PunchTimeDetail punchTimeDetail = new PunchTimeDetail();
		Date date = new Date();
	    System.out.println("Date..."+date);

		punchTimeDetail.setDate(date);
		punchTimeDetail.setFlag("System");
		punchTimeDetail.setTime((new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())));
		punchTimeDetail.setIn_out(punchTimeDetailDto.getIn_out());
		punchTimeDetail.setSNo(count+1);
		punchTimeDetail.setTktNo(punchTimeDetailDto.getTktNo());
		String tkt=punchTimeDetailDto.getTktNo();
		 String[] arrOfStr = tkt.split("-");
		for (String string : arrOfStr) {
			System.out.println(string);
		}
		
		
		
		punchTimeDetail.setCompanyId(punchTimeDetailDto.getCompanyId());
		punchTimeDetail.setHhMm(1l);
		return punchTimeDetail;
	}

	@Override
	public PunchTimeDetailDTO databaseModelToUiDto(PunchTimeDetail dbobj) {
		return null;
	}

	@Override
	public PunchTimeDetail uiDtoToDatabaseModel(PunchTimeDetailDTO uiobj) {
		return null;
	}
	
	
	public List<SystemAttendanceDTO> objectListToUImodel(List<Object[]> attendancObjList) {
		List<SystemAttendanceDTO> punchTimeDtoList =new ArrayList<SystemAttendanceDTO>();
		for (Object[] attendanceObj : attendancObjList) {
			System.out.println("attendanceObj"+attendanceObj);
			SystemAttendanceDTO systemAttendanceDto =new SystemAttendanceDTO();
			Long minSno=attendanceObj[0]!=null?Long.parseLong(attendanceObj[0].toString()):null;
			Long maxSno=attendanceObj[1]!=null?Long.parseLong(attendanceObj[1].toString()):null;
			String minTime=attendanceObj[2]!=null?(String)attendanceObj[2]:null;
			String maxTime=attendanceObj[3]!=null?(String)attendanceObj[3]:null;
			String tktNo=attendanceObj[4]!=null?(String)attendanceObj[4]:null;
			
			Date date = attendanceObj[5] != null ? (Date) attendanceObj[5] : null;
			Long companyId=attendanceObj[6]!=null?Long.parseLong(attendanceObj[6].toString()):null;

			systemAttendanceDto.setDate(date);
			systemAttendanceDto.setIntime(minTime);
			systemAttendanceDto.setOuttime(maxTime);
			systemAttendanceDto.setMaxSNo(maxSno);
			systemAttendanceDto.setMinSNo(minSno);
			systemAttendanceDto.setTktNo(tktNo);
			systemAttendanceDto.setCompanyId(companyId);
			punchTimeDtoList.add(systemAttendanceDto);
   		}
		System.out.println("punchTimeDtoList..."+punchTimeDtoList);
		return punchTimeDtoList;
	}

	public List<AttendanceLogDTO> objArraytoDtoList(List<Object[]> attendanceLogList) {
		List<AttendanceLogDTO> attendanceDtoList = new ArrayList<AttendanceLogDTO>();
		for (Object[] attendanceLog : attendanceLogList) {
			AttendanceLogDTO attendanceLogDto = new AttendanceLogDTO();
			Date attendanceDate = attendanceLog[1] != null ? (Date) (attendanceLog[1]) : null;
			Long employeeId = attendanceLog[2] != null ? Long.parseLong(attendanceLog[2].toString()) : null;
			String employeeCode = attendanceLog[3] != null ? (String) attendanceLog[3] : null;
			String inTime = attendanceLog[4] != null ? (String) attendanceLog[4] : null;
			String outTime = attendanceLog[5] != null ? (String) attendanceLog[5] : null;
			Long inDeviceId = attendanceLog[6] != null ? Long.parseLong(attendanceLog[6].toString()) : null;
			Long outDeviceId = attendanceLog[7] != null ? Long.parseLong(attendanceLog[7].toString()) : null;
			//Long companyId = attendanceLog[8] != null ? Long.parseLong(attendanceLog[8].toString()) : null;
			String mode = attendanceLog[9] != null ? (String) attendanceLog[9] : null;
			attendanceLogDto.setAttendanceDate(attendanceDate);
			attendanceLogDto.setEmployeeId(employeeId);
			attendanceLogDto.setEmployeeCode(employeeCode);
			attendanceLogDto.setInTime(inTime);
			attendanceLogDto.setOutTime(outTime);
			attendanceLogDto.setInDeviceId(inDeviceId);
			attendanceLogDto.setOutDeviceId(outDeviceId);
			attendanceLogDto.setMode(mode);
			//attendanceLogDto.setCompanyId(companyId);
			attendanceDtoList.add(attendanceLogDto);
		}
		return attendanceDtoList;
	}
	
	
}
