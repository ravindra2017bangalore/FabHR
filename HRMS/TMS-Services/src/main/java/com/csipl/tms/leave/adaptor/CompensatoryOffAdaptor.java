package com.csipl.tms.leave.adaptor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.candidate.CandidateDTO;
import com.csipl.hrms.dto.candidate.CandidateSearchDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.tms.dto.leave.CompOffSearchDTO;
import com.csipl.tms.dto.leave.CompensatoryOffDTO;
import com.csipl.tms.model.empcommondetails.EmpCommonDetail;
import com.csipl.tms.model.leave.CompensatoryOff;
import com.csipl.tms.service.Adaptor;

public class CompensatoryOffAdaptor  {

	
	public List<CompensatoryOff> uiDtoToDatabaseModelList(List<CompensatoryOffDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<CompensatoryOffDTO> databaseModelToUiDtoList(List<CompensatoryOff> CompensatoryOffList) {
		List<CompensatoryOffDTO> compensatoryOffDTOList = new ArrayList<CompensatoryOffDTO>();
		for (CompensatoryOff compensatoryOff : CompensatoryOffList) {
			compensatoryOffDTOList.add(databaseModelToUiDto(compensatoryOff,null,null));
		}
		return compensatoryOffDTOList;
	}


	public CompensatoryOff uiDtoToDatabaseModel(CompensatoryOffDTO CompensatoryOffdto) {
		CompensatoryOff compensatoryOff=new CompensatoryOff();
		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getCurrentDate();
		compensatoryOff.setFromDate(CompensatoryOffdto.getFromDate());
		compensatoryOff.setToDate(CompensatoryOffdto.getToDate());
		compensatoryOff.setRemark(CompensatoryOffdto.getRemark());
		
		compensatoryOff.setEmployeeId(CompensatoryOffdto.getEmployeeId());
		compensatoryOff.setApprovalRemark(CompensatoryOffdto.getApprovalRemark());
		compensatoryOff.setLeaveTypeId(CompensatoryOffdto.getLeaveTypeId());
		if(CompensatoryOffdto.getStatus()!=null)
			compensatoryOff.setStatus(CompensatoryOffdto.getStatus()); 
			else if(CompensatoryOffdto.getStatus()==null && CompensatoryOffdto.getApprovalId()!=null)
				compensatoryOff.setStatus(StatusMessage.APPROVED_CODE);
			else
				compensatoryOff.setStatus(StatusMessage.PENDING_CODE);
		compensatoryOff.setUserId(CompensatoryOffdto.getUserId());
//		compensatoryOff.setDateCreated(currentDate);
		compensatoryOff.setUserIdUpdate(CompensatoryOffdto.getUserIdUpdate());
		if(CompensatoryOffdto.getApprovalId()!=null)
		compensatoryOff.setDateUpdate(currentDate);
		compensatoryOff.setCompanyId(CompensatoryOffdto.getCompanyId());
		compensatoryOff.setApprovalId(CompensatoryOffdto.getApprovalId());
		compensatoryOff.setCancelRemark(CompensatoryOffdto.getCancelRemark());
		
		
		if (CompensatoryOffdto.getTmsCompensantoryOffId() != null) {
			compensatoryOff.setTmsCompensantoryOffId(CompensatoryOffdto.getTmsCompensantoryOffId());
			compensatoryOff.setDateCreated(CompensatoryOffdto.getDateCreated());
		} else
			compensatoryOff.setDateCreated(new Date());
		return compensatoryOff;
	}

	
	public CompensatoryOffDTO databaseModelToUiDto(CompensatoryOff compensatoryOff,Employee employeeEmp,Employee approvalEmp) {
		// TODO Auto-generated method stub
		CompensatoryOffDTO compensatoryOffDTO=new CompensatoryOffDTO();
		compensatoryOffDTO.setTmsCompensantoryOffId(compensatoryOff.getTmsCompensantoryOffId());
		
		compensatoryOffDTO.setTmsCompensantoryOffId(compensatoryOff.getTmsCompensantoryOffId());
		compensatoryOffDTO.setRemark(compensatoryOff.getRemark());
		compensatoryOffDTO.setApprovalId(compensatoryOff.getApprovalId());
		compensatoryOffDTO.setEmployeeId(compensatoryOff.getEmployeeId());
		compensatoryOffDTO.setApprovalRemark(compensatoryOff.getApprovalRemark());
		compensatoryOffDTO.setLeaveTypeId(compensatoryOff.getLeaveTypeId());
		compensatoryOffDTO.setUserId(compensatoryOff.getUserId());
		compensatoryOffDTO.setDateCreated(compensatoryOff.getDateCreated());
		compensatoryOffDTO.setUserIdUpdate(compensatoryOff.getUserIdUpdate());
		compensatoryOffDTO.setDateUpdate(compensatoryOff.getDateUpdate());
		compensatoryOffDTO.setCompanyId(compensatoryOff.getCompanyId());
		compensatoryOffDTO.setStatus(compensatoryOff.getStatus());
		compensatoryOffDTO.setCancelRemark(compensatoryOff.getCancelRemark());
		if (compensatoryOffDTO.getStatus().equals(StatusMessage.PENDING_CODE)) {
			compensatoryOffDTO.setStatusValue(StatusMessage.PENDING_VALUE);
		} else if (compensatoryOffDTO.getStatus().equals(StatusMessage.REJECTED_CODE)) {
			compensatoryOffDTO.setStatusValue(StatusMessage.REJECTED_VALUE);
		} else if (compensatoryOffDTO.getStatus().equals(StatusMessage.APPROVED_CODE)) {
			compensatoryOffDTO.setStatusValue(StatusMessage.APPROVED_VALUE);
		}else if (compensatoryOffDTO.getStatus().equals(StatusMessage.CANCEL_CODE)) {
			compensatoryOffDTO.setStatusValue(StatusMessage.CANCEL_VALUE);
		}
		
    	compensatoryOffDTO.setFromDate(compensatoryOff.getFromDate());
    	compensatoryOffDTO.setToDate(compensatoryOff.getToDate());
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
		 long difference = compensatoryOff.getToDate().getTime() - compensatoryOff.getFromDate().getTime();
		 long daysBetween= (difference / (1000*60*60*24)) + 1;
		 compensatoryOffDTO.setDays(daysBetween);
		 
		 if (employeeEmp != null) {
			 compensatoryOffDTO.setEmployeeName(employeeEmp.getFirstName() + " " + employeeEmp.getLastName());
			 compensatoryOffDTO.setDepartment(employeeEmp.getDepartment().getDepartmentName());
			 compensatoryOffDTO.setDesignation(employeeEmp.getDesignation().getDesignationName());
			 compensatoryOffDTO.setEmployeeCode(employeeEmp.getEmployeeCode());
			}
			if (approvalEmp != null) {
				compensatoryOffDTO.setApprovalId(approvalEmp.getEmployeeId());
				compensatoryOffDTO.setApprovalEmployeeName(approvalEmp.getFirstName() + " " + approvalEmp.getLastName());
				compensatoryOffDTO.setApprovalEmployeeDepartment(approvalEmp.getDepartment().getDepartmentName());
				compensatoryOffDTO.setApprovalEmployeeDesignation(approvalEmp.getDesignation().getDesignationName());
				compensatoryOffDTO.setApprovalEmployeeCode(approvalEmp.getEmployeeCode());
			}
		 	 
		 return compensatoryOffDTO;
	}
	
	public List<CompensatoryOffDTO> modeltoDTOList(List<Object[]> compOffList, CompOffSearchDTO compOffSearchDTO) {
		List<CompensatoryOffDTO> compensatoryOffDTOList = new ArrayList<CompensatoryOffDTO>();

		for (Object[] compOffbj : compOffList) {
			CompensatoryOffDTO compensatoryOffDTO = new CompensatoryOffDTO();

			if (compOffbj[0] != null) {
				compensatoryOffDTO.setEmployeeName(compOffbj[0].toString());
			}

			if (compOffbj[1] != null) {
				compensatoryOffDTO.setFromDate((Date)compOffbj[1]);
			}
			if (compOffbj[2] != null) {
				compensatoryOffDTO.setToDate((Date)compOffbj[2]);
			}

			if (compOffbj[3] != null) {
				compensatoryOffDTO.setLeaveTypeId(Long.parseLong(compOffbj[3].toString()));
			}

			if (compOffbj[4] != null) {
				compensatoryOffDTO.setStatus(compOffbj[4].toString());
		
				if (compensatoryOffDTO.getStatus().equals(StatusMessage.PENDING_CODE)) {
					compensatoryOffDTO.setStatusValue(StatusMessage.PENDING_VALUE);
				} else if (compensatoryOffDTO.getStatus().equals(StatusMessage.REJECTED_CODE)) {
					compensatoryOffDTO.setStatusValue(StatusMessage.REJECTED_VALUE);
				} else if (compensatoryOffDTO.getStatus().equals(StatusMessage.APPROVED_CODE)) {
					compensatoryOffDTO.setStatusValue(StatusMessage.APPROVED_VALUE);
				}else if (compensatoryOffDTO.getStatus().equals(StatusMessage.CANCEL_CODE)) {
					compensatoryOffDTO.setStatusValue(StatusMessage.CANCEL_VALUE);
				}
				
			}
			if (compOffbj[5] != null) {
				compensatoryOffDTO.setDateCreated((Date)compOffbj[5]);
			}
			if (compOffbj[6] != null) {
				compensatoryOffDTO.setTmsCompensantoryOffId(Long.parseLong(compOffbj[6].toString()));
			}
			if (compOffbj[7] != null) {
				compensatoryOffDTO.setEmployeeId(Long.parseLong(compOffbj[7].toString()));
			}
			if (compOffbj[8] != null) {
				compensatoryOffDTO.setApprovalRemark(compOffbj[8].toString());
			}
			if (compOffbj[9] != null) {
				compensatoryOffDTO.setCancelRemark(compOffbj[9].toString());
			}
			if (compOffbj[10] != null) {
				compensatoryOffDTO.setRemark(compOffbj[10].toString());
			}
			if (compOffbj[11] != null) {
				compensatoryOffDTO.setDesignation(compOffbj[11].toString());
			}
			//SimpleDateFormat myFormat = new SimpleDateFormat("yyyy MM dd");
			 long difference = compensatoryOffDTO.getToDate().getTime() - compensatoryOffDTO.getFromDate().getTime();
			 long daysBetween= (difference / (1000*60*60*24)) + 1;
			 compensatoryOffDTO.setDays(daysBetween);
			

			compensatoryOffDTOList.add(compensatoryOffDTO);

		}

		return compensatoryOffDTOList;
	}

	


}
