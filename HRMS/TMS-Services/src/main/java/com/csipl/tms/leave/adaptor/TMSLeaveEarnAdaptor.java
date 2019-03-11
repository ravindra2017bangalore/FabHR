package com.csipl.tms.leave.adaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.tms.dto.leave.TMSLeaveEarnDTO;
import com.csipl.tms.model.leave.EmployeeLeaveEarn;
import com.csipl.tms.model.leave.TMSLeaveType;
import com.csipl.tms.service.Adaptor;

public class TMSLeaveEarnAdaptor implements Adaptor<TMSLeaveEarnDTO, EmployeeLeaveEarn>  {

	@Override
	public List<EmployeeLeaveEarn> uiDtoToDatabaseModelList(List<TMSLeaveEarnDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<TMSLeaveEarnDTO> databaseModelToUiDtoList(List<EmployeeLeaveEarn> employeeLeaveEarnList) {
		List<TMSLeaveEarnDTO> tmsLeaveEarnDtoList = new ArrayList<TMSLeaveEarnDTO>();
		for (EmployeeLeaveEarn employeeLeaveEarn : employeeLeaveEarnList) {
			tmsLeaveEarnDtoList.add(databaseModelToUiDto(employeeLeaveEarn));
			
		}
		return tmsLeaveEarnDtoList;
	}

	@Override
	public EmployeeLeaveEarn uiDtoToDatabaseModel(TMSLeaveEarnDTO uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TMSLeaveEarnDTO databaseModelToUiDto(EmployeeLeaveEarn employeeLeaveEarn) {
		TMSLeaveEarnDTO tmsLeaveEarnDto = new TMSLeaveEarnDTO();
		//tmsLeaveEarnDto.setEmployee(employeeLeaveEarn.getEmployee());
		tmsLeaveEarnDto.setEmployeeLeaveEarnId(employeeLeaveEarn.getEmployeeLeaveEarnId());
		tmsLeaveEarnDto.setLeaveTaken(employeeLeaveEarn.getLeaveTaken());
		tmsLeaveEarnDto.setEmployeeId(employeeLeaveEarn.getEmployeeId());
		//tmsLeaveEarnDto.setLeaveType(employeeLeaveEarn.getTmsleaveType().getLeaveType());
		tmsLeaveEarnDto.setLeaveTypeId(employeeLeaveEarn.getTmsleaveType().getLeaveTypeId());
		tmsLeaveEarnDto.setUserId(employeeLeaveEarn.getUserId());
		tmsLeaveEarnDto.setTotalLeave(employeeLeaveEarn.getTotalLeave());
		tmsLeaveEarnDto.setLeaveBalance(employeeLeaveEarn.getTotalLeave()-employeeLeaveEarn.getLeaveTaken());
		tmsLeaveEarnDto.setLeaveBalance(employeeLeaveEarn.getLeaveBalance());
		tmsLeaveEarnDto.setDateCreated(employeeLeaveEarn.getDateCreated());
		return tmsLeaveEarnDto;
	}

	public List<EmployeeLeaveEarn> databaseModelObjectToUIDto(List<Object[]> leaveEarnObjectList,Long employeeId) {
		List<EmployeeLeaveEarn> tmsLeaveEarnList = new ArrayList<EmployeeLeaveEarn>();
		for (Object[] tmsLeaveEarnObj : leaveEarnObjectList) {
			EmployeeLeaveEarn TMSLeaveEarn = new EmployeeLeaveEarn();
			Long leaveTypeId=tmsLeaveEarnObj[0]!=null?Long.parseLong(tmsLeaveEarnObj[0].toString()):null;

			Long totaleDays=tmsLeaveEarnObj[1]!=null?Long.parseLong(tmsLeaveEarnObj[1].toString()):null;
			BigDecimal leaveIndex=tmsLeaveEarnObj[2]!=null?(BigDecimal)tmsLeaveEarnObj[2]:null;
			Date effectiveDate = tmsLeaveEarnObj[3] != null ? (Date) tmsLeaveEarnObj[3] : null;
			System.out.println("leaveType.."+leaveTypeId+"totaleDays.."+"..leaveIndex.."+leaveIndex+"..effectiveDate.."+effectiveDate+"..totaleDays.."+totaleDays);
			TMSLeaveType leaveType = new TMSLeaveType();
			leaveType.setLeaveTypeId(leaveTypeId);
			TMSLeaveEarn.setTmsleaveType(leaveType);
			TMSLeaveEarn.setTotalLeave(totaleDays);
			//Employee employee = new Employee(); 
			
			TMSLeaveEarn.setEmployeeId(employeeId);  
			TMSLeaveEarn.setDateCreated(new Date());
			TMSLeaveEarn.setLeaveTaken(0l);
			TMSLeaveEarn.setUserId(1l);
			tmsLeaveEarnList.add(TMSLeaveEarn);
		}
		return tmsLeaveEarnList;
	}
	
}
