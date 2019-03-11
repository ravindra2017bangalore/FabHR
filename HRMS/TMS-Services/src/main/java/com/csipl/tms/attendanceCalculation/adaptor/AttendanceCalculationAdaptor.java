package com.csipl.tms.attendanceCalculation.adaptor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.csipl.tms.dto.attendancelog.AttendanceLogDTO;
import com.csipl.tms.dto.employee.EmployeeDTO;
import com.csipl.tms.model.attendancelog.AttendanceLog;
/*import com.csipl.tms.model.common.Company;
import com.csipl.tms.model.common.Employee;*/
import com.csipl.tms.service.Adaptor;

public class AttendanceCalculationAdaptor implements Adaptor<AttendanceLogDTO, AttendanceLog> {

	@Override
	public List<AttendanceLog> uiDtoToDatabaseModelList(List<AttendanceLogDTO> attendanceLogDtoList) {
		List<AttendanceLog> attendanceLogList = new ArrayList<AttendanceLog>();
		attendanceLogDtoList.forEach(attendanceLogDto -> {
			attendanceLogList.add(uiDtoToDatabaseModel(attendanceLogDto));
		});
		return attendanceLogList;
	}

	@Override
	public List<AttendanceLogDTO> databaseModelToUiDtoList(List<AttendanceLog> dbobj) {
		return null;
	}

	@Override
	public AttendanceLog uiDtoToDatabaseModel(AttendanceLogDTO attendanceLogDto) {
		AttendanceLog attendanceLog = new AttendanceLog();
		/*
		 * Employee employee = new Employee(); Company company = new Company();
		 * company.setCompanyId(attendanceLogDto.getCompanyId()); if
		 * (attendanceLogDto.getEmployeeId() != null)
		 * //employee.setEmployeeId(attendanceLogDto.getEmployeeId());
		 */
		if (attendanceLogDto.getEmployeeId() != null)
			attendanceLog.setAttendanceDate(attendanceLogDto.getAttendanceDate());

		attendanceLog.setInTime(attendanceLogDto.getInTime());
		attendanceLog.setOutTime(attendanceLogDto.getOutTime());
		if(attendanceLogDto.getInDeviceId()!=null)
		attendanceLog.setInDeviceId(attendanceLogDto.getInDeviceId());
		else
			attendanceLog.setInDeviceId(1l);
		if(attendanceLogDto.getOutDeviceId()!=null)
		attendanceLog.setOutDeviceId(attendanceLogDto.getOutDeviceId());
		else
			attendanceLog.setOutDeviceId(1l);
		attendanceLog.setCompanyId(attendanceLogDto.getCompanyId());
		/*
		 * attendanceLog.setCreatedBy(123l); attendanceLog.setUpdatedBy(123l);
		 */
		attendanceLog.setCreatedDate(new Date());
		attendanceLog.setUpdatedDate(new Date());
		attendanceLog.setAttendanceDate(attendanceLogDto.getAttendanceDate());
		attendanceLog.setEmployeeId(attendanceLogDto.getEmployeeId());
		attendanceLog.setEmployeeCode(attendanceLogDto.getEmployeeCode());

		return attendanceLog;
	}

	@Override
	public AttendanceLogDTO databaseModelToUiDto(AttendanceLog attendanceLog) {
		return null;
	}

	/*
	 * Commented by Ravindra Singh previous Code without resttemplate
	 * 
	 */

	/*
	 * public List<AttendanceLogDTO> objListToDto(List<Object[]> objectList, String
	 * prefix, Long companyId, List<Object[]> objCodeList, Map<String, Long>
	 * mapEmpIdAndEmpCode) throws ParseException { // DateFormat dateFormat = new
	 * SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); // DateFormat onlyDate = new
	 * SimpleDateFormat("yyyy-MM-dd"); DateFormat onlyTime = new
	 * SimpleDateFormat("hh:mm:ss"); List<AttendanceLogDTO> attendanceLogDtoList =
	 * new ArrayList<AttendanceLogDTO>();
	 * 
	 * for (Object[] obj : objCodeList) { Long employeeId = obj[0] != null ?
	 * Long.parseLong(obj[0].toString()) : null; String employeeCode = obj[1] !=
	 * null ? (String) obj[1] : null; mapEmpIdAndEmpCode.put(employeeCode,
	 * employeeId); }
	 * 
	 * for (Object[] arrOfAttendanceDto : objectList) { AttendanceLogDTO
	 * attendanceLogDto = new AttendanceLogDTO();
	 * attendanceLogDto.setCompanyId(companyId); // Double minSno =
	 * arrOfAttendanceDto[0] != null ? //
	 * Double.parseDouble(arrOfAttendanceDto[0].toString()) : null; Date mindate =
	 * arrOfAttendanceDto[1] != null ? (Date) (arrOfAttendanceDto[1]) : null; //
	 * Double maxSno = arrOfAttendanceDto[2] != null ? //
	 * Double.parseDouble(arrOfAttendanceDto[2].toString()) : null; Date maxdate =
	 * arrOfAttendanceDto[3] != null ? (Date) (arrOfAttendanceDto[3]) : null; Long
	 * tktno = arrOfAttendanceDto[5] != null ?
	 * Long.parseLong(arrOfAttendanceDto[5].toString()) : null; // String deviceName
	 * = arrOfAttendanceDto[6] != null ? (String) // arrOfAttendanceDto[6] : null;
	 * Long deviceId = arrOfAttendanceDto[7] != null ?
	 * Long.parseLong(arrOfAttendanceDto[7].toString()) : null;
	 * attendanceLogDto.setEmployeeCode(prefix + tktno); if
	 * (mapEmpIdAndEmpCode.containsKey(attendanceLogDto.getEmployeeCode())) { Long
	 * employeeId = (Long)
	 * mapEmpIdAndEmpCode.get(attendanceLogDto.getEmployeeCode());
	 * attendanceLogDto.setEmployeeId(employeeId); }
	 * 
	 * if (mindate != null) { attendanceLogDto.setAttendanceDate(mindate); } if
	 * (mindate != null) { String minDate = onlyTime.format(mindate);
	 * attendanceLogDto.setInTime(minDate); } if (maxdate != null) { String maxDate
	 * = onlyTime.format(maxdate); attendanceLogDto.setOutTime(maxDate); }
	 * 
	 * attendanceLogDto.setInDeviceId(deviceId);
	 * attendanceLogDto.setOutDeviceId(1L);
	 * attendanceLogDtoList.add(attendanceLogDto); }
	 * 
	 * return attendanceLogDtoList;
	 * 
	 * }
	 */

	/*
	 * Ravindra Singh With RestTemplate
	 * 
	 */
	public List<AttendanceLogDTO> objListToDto(List<Object[]> objectList, String prefix, Long companyId,
			List<EmployeeDTO> employeeDtoList, Map<String, Long> mapEmpIdAndEmpCode) throws ParseException {
		// DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		// DateFormat onlyDate = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat onlyTime = new SimpleDateFormat("hh:mm:ss");
		List<AttendanceLogDTO> attendanceLogDtoList = new ArrayList<AttendanceLogDTO>();

		for (EmployeeDTO employeeDto : employeeDtoList) {
			Long employeeId = employeeDto.getEmployeeId();
			String employeeCode = employeeDto.getEmployeeCode();
			mapEmpIdAndEmpCode.put(employeeCode, employeeId);
		}

		for (Object[] arrOfAttendanceDto : objectList) {
			AttendanceLogDTO attendanceLogDto = new AttendanceLogDTO();
			attendanceLogDto.setCompanyId(companyId);
			// Double minSno = arrOfAttendanceDto[0] != null ?
			// Double.parseDouble(arrOfAttendanceDto[0].toString()) : null;
			Date mindate = arrOfAttendanceDto[1] != null ? (Date) (arrOfAttendanceDto[1]) : null;
			// Double maxSno = arrOfAttendanceDto[2] != null ?
			// Double.parseDouble(arrOfAttendanceDto[2].toString()) : null;
			Date maxdate = arrOfAttendanceDto[3] != null ? (Date) (arrOfAttendanceDto[3]) : null;
			Long tktno = arrOfAttendanceDto[5] != null ? Long.parseLong(arrOfAttendanceDto[5].toString()) : null;
			// String deviceName = arrOfAttendanceDto[6] != null ? (String)
			// arrOfAttendanceDto[6] : null;
			Long deviceId = arrOfAttendanceDto[7] != null ? Long.parseLong(arrOfAttendanceDto[7].toString()) : null;
			attendanceLogDto.setEmployeeCode(prefix + tktno);
			if (mapEmpIdAndEmpCode.containsKey(attendanceLogDto.getEmployeeCode())) {
				Long employeeId = (Long) mapEmpIdAndEmpCode.get(attendanceLogDto.getEmployeeCode());
				attendanceLogDto.setEmployeeId(employeeId);
			}

			if (mindate != null) {
				attendanceLogDto.setAttendanceDate(mindate);
			}
			if (mindate != null) {
				String minDate = onlyTime.format(mindate);
				attendanceLogDto.setInTime(minDate);
			}
			if (maxdate != null) {
				String maxDate = onlyTime.format(maxdate);
				attendanceLogDto.setOutTime(maxDate);
			}

			attendanceLogDto.setInDeviceId(deviceId);
			attendanceLogDto.setOutDeviceId(1L);
			attendanceLogDtoList.add(attendanceLogDto);
		}

		return attendanceLogDtoList;

	}
	
	public List<AttendanceLogDTO> objectListToUImodel(List<Object[]> attendancObjList) {
		List<AttendanceLogDTO> punchTimeDtoList =new ArrayList<AttendanceLogDTO>();
		for (Object[] attendanceObj : attendancObjList) {
			System.out.println("attendanceObj"+attendanceObj);
			AttendanceLogDTO attendanceLogDto =new AttendanceLogDTO();
			Long minSno=attendanceObj[0]!=null?Long.parseLong(attendanceObj[0].toString()):null;
			Long maxSno=attendanceObj[1]!=null?Long.parseLong(attendanceObj[1].toString()):null;
			String minTime=attendanceObj[2]!=null?(String)attendanceObj[2]:null;
			String maxTime=attendanceObj[3]!=null?(String)attendanceObj[3]:null;
			String tktNo=attendanceObj[4]!=null?(String)attendanceObj[4]:null;
			
			Date date = attendanceObj[5] != null ? (Date) attendanceObj[5] : null;
			Long companyId=attendanceObj[6]!=null?Long.parseLong(attendanceObj[6].toString()):null;

			attendanceLogDto.setAttendanceDate(date);
			attendanceLogDto.setInTime(minTime);
			attendanceLogDto.setOutTime(maxTime);
			attendanceLogDto.setMaxSno(maxSno);
			attendanceLogDto.setMinSno(minSno);
			attendanceLogDto.setEmployeeCode(tktNo);
			attendanceLogDto.setCompanyId(companyId);
			punchTimeDtoList.add(attendanceLogDto);
   		}
		System.out.println("punchTimeDtoList..."+punchTimeDtoList);
		return punchTimeDtoList;
	}

	public List<AttendanceLogDTO>  attendanceCalculation(List<AttendanceLogDTO> attendanceLogDtoList,List<AttendanceLogDTO> systemAttendanceLogList, Map<String, Long> mapEmpIdAndEmpCode){
		 Collections.sort(attendanceLogDtoList);
		 Collections.sort(systemAttendanceLogList);
		List<AttendanceLogDTO> attendanceLogList= new ArrayList<AttendanceLogDTO>();
		
		 for (AttendanceLogDTO systemAttendanceLogDTO : systemAttendanceLogList) {
			 int iStringSearch = Collections.binarySearch(attendanceLogDtoList, systemAttendanceLogDTO);
			 if(iStringSearch>=0) {
				
				// List<AttendanceLogDTO> att =  attendanceLogDtoList.stream(). filter(p -> p.getEmployeeCode() .equals(systemAttendanceLogDTO.getEmployeeCode())). collect(Collectors.toCollection(() -> new ArrayList<AttendanceLogDTO>()));
				// System.out.println("att..."+att);
				AttendanceLogDTO attendanceLogDto = attendanceLogDtoList.get(iStringSearch);
				 if(systemAttendanceLogDTO.getInTime().compareTo(attendanceLogDto.getInTime())<=0) {
					 systemAttendanceLogDTO.setInTime(systemAttendanceLogDTO.getInTime()); 
				 }
				 else
					 systemAttendanceLogDTO.setInTime(attendanceLogDto.getInTime());  
				 
				 if(systemAttendanceLogDTO.getInTime().compareTo(attendanceLogDto.getInTime())<=0) {
					 systemAttendanceLogDTO.setOutTime(attendanceLogDto.getInTime());
				 }
				 else
					 systemAttendanceLogDTO.setOutTime(systemAttendanceLogDTO.getInTime());
				 
				 
				 if (mapEmpIdAndEmpCode.containsKey(attendanceLogDto.getEmployeeCode())) {
						Long employeeId = (Long) mapEmpIdAndEmpCode.get(attendanceLogDto.getEmployeeCode());
						systemAttendanceLogDTO.setEmployeeId(employeeId);
					}
				 System.out.println("systemAttendanceLogDTO.setEmployeeId..."+systemAttendanceLogDTO.getEmployeeId());
				 
				 attendanceLogList.add(systemAttendanceLogDTO);
				 boolean flg= attendanceLogDtoList.removeIf(obj -> obj.getEmployeeCode().equals(systemAttendanceLogDTO.getEmployeeCode()));
					System.out.println("flg...."+flg);
				
			 }
			 else
				 attendanceLogList.add(systemAttendanceLogDTO) ;
			
			 
		}
		 attendanceLogList.addAll(attendanceLogDtoList);
		 System.out.println("----*** FINAL LIST FOR  SAVE***-----"+attendanceLogList);
	   

		return attendanceLogList;
	}
}
