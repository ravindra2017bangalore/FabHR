
 package com.csipl.tms.attendanceCalculation.adaptor;



import java.util.ArrayList;

import java.util.Date;

import java.util.List;



import com.csipl.tms.dto.attendancelog.AttendanceLogDTO;

import com.csipl.tms.dto.attendancelog.AttendanceLogDetailsDTO;

import com.csipl.tms.model.attendancelog.AttendanceLog;

import com.csipl.tms.model.empcommondetails.EmpCommonDetail;

import com.csipl.tms.model.halfdayrule.HalfDayRule;



public class AttendanceLogAdaptor { // implements Adaptor<AttendanceLogDetailsDTO, AttendanceLog> {



	public List<AttendanceLogDetailsDTO> objectListToAttendanceLogDetailsDto(

			List<AttendanceLog> attendanceLogDetailsList, List<EmpCommonDetail> empCommonDetailList,

			HalfDayRule halfDayRule) {

		return null;

	}



	public List<AttendanceLogDetailsDTO> modeltoDTOList(List<Object[]> attendanceLogDetails) {



		List<AttendanceLogDetailsDTO> attendanceLogDetailsDtoList = new ArrayList<AttendanceLogDetailsDTO>();



		for (Object[] attendanceLogDetailsObj : attendanceLogDetails) {

			String firstName = null, lastName;

			String inTimre = null, outTime;

			AttendanceLogDetailsDTO attendanceLogDetailsDto = new AttendanceLogDetailsDTO();



			if (attendanceLogDetailsObj[0] != null) {

				firstName = attendanceLogDetailsObj[0].toString();

				attendanceLogDetailsDto.setCharFirstName(Character.toString(firstName.charAt(0)).toUpperCase());

			}



			if (attendanceLogDetailsObj[1] != null) {

				lastName = attendanceLogDetailsObj[1].toString();

				attendanceLogDetailsDto.setCharLastName(Character.toString(lastName.charAt(0)).toUpperCase());

				attendanceLogDetailsDto.setName(firstName + " " + lastName);

			}

			

			if (attendanceLogDetailsObj[2] != null) {

				attendanceLogDetailsDto.setDesignationName(attendanceLogDetailsObj[2].toString());

			}



			if (attendanceLogDetailsObj[3] != null) {

				inTimre = attendanceLogDetailsObj[4].toString();

			}



			if (attendanceLogDetailsObj[4] != null) {

				// inTimre=attendanceLogDetailsObj[4].toString();

				outTime = attendanceLogDetailsObj[4].toString();

				attendanceLogDetailsDto.setPunchRecord(inTimre + ", " + outTime);

			}



			if (attendanceLogDetailsObj[5] != null) {

				attendanceLogDetailsDto.setLocation(attendanceLogDetailsObj[5].toString());

			}



			if (attendanceLogDetailsObj[6] != null) {

				attendanceLogDetailsDto.setMode(attendanceLogDetailsObj[6].toString());

			}



			if (attendanceLogDetailsObj[7] != null) {

				attendanceLogDetailsDto.setDelayedTime(attendanceLogDetailsObj[7].toString());

			}



		/*	if (attendanceLogDetailsObj[8] != null) {

				attendanceLogDetailsDto.setEmployeeId(

						(attendanceLogDetailsObj[8] != null ? Long.parseLong(attendanceLogDetailsObj[8].toString())

								: null));

			}*/



			if (attendanceLogDetailsObj[9] != null) {

				attendanceLogDetailsDto.setStatus(attendanceLogDetailsObj[9].toString());

			}



			if (attendanceLogDetailsObj[10] != null) {

				attendanceLogDetailsDto.setStatus(attendanceLogDetailsObj[10].toString());

			}



			attendanceLogDetailsDtoList.add(attendanceLogDetailsDto);



		}



		return attendanceLogDetailsDtoList;

	}



	public List<AttendanceLogDTO> databaseObjModelToUiDtoList(List<Object[]> objAttendanceLogList) {
		String statusValue="";



		List<AttendanceLogDTO> attendanceLogDtoList = new ArrayList<AttendanceLogDTO>();



		for (Object[] attendanceObj : objAttendanceLogList) {



			AttendanceLogDTO attendanceLogDto = new AttendanceLogDTO();

			if (attendanceObj[0] != null) {

				attendanceLogDto

						.setEmployeeId(attendanceObj[0] != null ? Long.parseLong(attendanceObj[0].toString()) : null);



			}

			if (attendanceObj[1] != null) {

				attendanceLogDto.setFirstName(attendanceObj[1].toString());

			}

			if (attendanceObj[2] != null) {

				attendanceLogDto.setLastName(attendanceObj[2].toString());

			}



			if (attendanceObj[3] != null) {

				attendanceLogDto.setAttendanceLogId(

						attendanceObj[3] != null ? Long.parseLong(attendanceObj[3].toString()) : null);

			} else {

			}



			if (attendanceObj[4] != null) {

				attendanceLogDto.setAttendanceDate((Date) attendanceObj[4]);

			}

			if (attendanceObj[5] != null) {

				attendanceLogDto.setEmployeeCode(attendanceObj[5].toString());

			}

			if (attendanceObj[6] != null) {

				attendanceLogDto

						.setCompanyId(attendanceObj[6] != null ? Long.parseLong(attendanceObj[6].toString()) : null);

			}

			if (attendanceObj[7] != null) {

				attendanceLogDto.setInTime(attendanceObj[7].toString());

			}



			if (attendanceObj[8] != null) {

				attendanceLogDto.setOutTime(attendanceObj[8].toString());

			}

			if (attendanceObj[9] != null) {

				attendanceLogDto

						.setInDeviceId(attendanceObj[9] != null ? Long.parseLong(attendanceObj[9].toString()) : null);

			}

			if (attendanceObj[10] != null) {

				attendanceLogDto.setOutDeviceId(

						attendanceObj[10] != null ? Long.parseLong(attendanceObj[10].toString()) : null);

			}

			if (attendanceObj[11] != null) {

				attendanceLogDto.setLocation(attendanceObj[11].toString());

			}

			if (attendanceObj[12] != null) {

				attendanceLogDto.setMode(attendanceObj[12].toString());

			}

			if (attendanceObj[13] != null) {

				attendanceLogDto

						.setCreatedBy(attendanceObj[13] != null ? Long.parseLong(attendanceObj[13].toString()) : null);

			}

			if (attendanceObj[14] != null) {

				attendanceLogDto.setCreatedDate((Date) attendanceObj[14]);

			}



			if (attendanceObj[15] != null) {

				attendanceLogDto

						.setUpdatedBy(attendanceObj[15] != null ? Long.parseLong(attendanceObj[15].toString()) : null);

			}

			if (attendanceObj[16] != null) {

				attendanceLogDto.setDelayedTime(attendanceObj[16].toString());

			}
			if (attendanceObj[19] != null) {
				statusValue=attendanceObj[19].toString();
 			} 
			if (attendanceObj[18] != null) {

				attendanceLogDto.setStatus(attendanceObj[18].toString());

				if (attendanceLogDto.getStatus().equals("P"))

					attendanceLogDto.setStatusValue("Present");

				else if (attendanceLogDto.getStatus().equals("A"))

					attendanceLogDto.setStatusValue("Absent");
 			

			} else {
				if(statusValue!=null)  
					attendanceLogDto.setStatusValue(statusValue);
				else {
				attendanceLogDto.setStatusValue("Absent");

				}
  				attendanceLogDto.setStatus("");
				attendanceLogDto.setStatusValue("Absent");

			}
			attendanceLogDtoList.add(attendanceLogDto);

		}

		return attendanceLogDtoList;



	}



	public List<AttendanceLog> uiDtoToDatabaseModelList(List<AttendanceLogDTO> attendanceLogDtoList,

			Date attendanceDate, String attendanceStatus) {

		List<AttendanceLog> attendanceLogList = new ArrayList<AttendanceLog>();



		for (AttendanceLogDTO attendanceLogDto : attendanceLogDtoList) {

			attendanceLogList.add(uiDtoToDatabaseModel(attendanceLogDto, attendanceDate, attendanceStatus));

		}



		return attendanceLogList;

	}



	public AttendanceLog uiDtoToDatabaseModel(AttendanceLogDTO attendanceLogDto, Date attendanceDate,

			String attendanceStatus) {

		AttendanceLog attendanceLog = new AttendanceLog();



		if (!attendanceLogDto.getStatus().equals("L")) {

			attendanceLog.setAttendanceLogId(attendanceLogDto.getAttendanceLogId());

			attendanceLog.setAttendanceDate(attendanceDate);

			attendanceLog.setEmployeeId(attendanceLogDto.getEmployeeId());

			attendanceLog.setEmployeeCode(attendanceLogDto.getEmployeeCode());

			attendanceLog.setCompanyId(attendanceLogDto.getCompanyId());

			attendanceLog.setStatus(attendanceStatus);

			attendanceLog.setUpdatedDate(new Date());

			attendanceLog.setInTime(attendanceLogDto.getInTime());

			attendanceLog.setOutTime(attendanceLogDto.getOutTime());

			attendanceLog.setInDeviceId(attendanceLogDto.getInDeviceId());

			attendanceLog.setOutDeviceId(attendanceLogDto.getOutDeviceId());

			attendanceLog.setLocation(attendanceLogDto.getLocation());

			attendanceLog.setMode(attendanceLogDto.getMode());

			attendanceLog.setCreatedBy(attendanceLogDto.getCreatedBy());

			attendanceLog.setUpdatedBy(attendanceLogDto.getUpdatedBy());

			attendanceLog.setDelayedTime(attendanceLogDto.getDelayedTime());



			if (attendanceLogDto.getCreatedDate() != null)

				attendanceLog.setCreatedDate(attendanceLogDto.getCreatedDate());

			else

				attendanceLog.setCreatedDate(new Date());

		}

		return attendanceLog;

	}



	public List<AttendanceLogDTO> databaseModelToUiDtoList(List<AttendanceLog> attendanceLogList1) {

		List<AttendanceLogDTO> attendanceLogDtoList = new ArrayList<AttendanceLogDTO>();

		for (AttendanceLog attendanceLog : attendanceLogList1) {

			attendanceLogDtoList.add(databaseModelToUiDto(attendanceLog));

		}

		return attendanceLogDtoList;

	}



	private AttendanceLogDTO databaseModelToUiDto(AttendanceLog attendanceLog) {

		AttendanceLogDTO attendanceLogDto = new AttendanceLogDTO();

		attendanceLogDto.setAttendanceLogId(attendanceLog.getAttendanceLogId());

		attendanceLogDto.setEmployeeId(attendanceLog.getEmployeeId());

		attendanceLogDto.setEmployeeCode(attendanceLog.getEmployeeCode());

		attendanceLogDto.setInTime(attendanceLog.getInTime());

		attendanceLogDto.setOutTime(attendanceLog.getOutTime());

		attendanceLogDto.setInDeviceId(attendanceLog.getOutDeviceId());

		attendanceLogDto.setLocation(attendanceLog.getLocation());

		attendanceLogDto.setCompanyId(attendanceLog.getCompanyId());

		attendanceLogDto.setAttendanceDate(attendanceLog.getAttendanceDate());

		attendanceLogDto.setStatus(attendanceLog.getStatus());

		attendanceLogDto.setCreatedDate(attendanceLog.getCreatedDate());

		attendanceLogDto.setOutDeviceId(attendanceLog.getOutDeviceId());

		attendanceLogDto.setLocation(attendanceLog.getLocation());

		attendanceLogDto.setMode(attendanceLog.getMode());

		attendanceLogDto.setCreatedBy(attendanceLog.getCreatedBy());

		attendanceLogDto.setUpdatedBy(attendanceLog.getUpdatedBy());

		attendanceLogDto.setDelayedTime(attendanceLog.getDelayedTime());



		return attendanceLogDto;

	}



}

