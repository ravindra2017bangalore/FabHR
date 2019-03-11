package com.csipl.hrms.service.payroll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.common.enums.RelationEnum;
import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payrollprocess.Attendance;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.model.payrollprocess.ReportPayOutPK;
import com.csipl.hrms.service.payroll.repository.AttendanceRepository;
import com.csipl.hrms.service.util.ConverterUtil;

@Transactional
@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
	private static final Logger logger = LoggerFactory.getLogger(AttendanceServiceImpl.class);
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Override
	public List<ReportPayOut> fetchEmployeeForSalary(long companyId, long departmentId, String payMonth ) {	
		logger.info("fetchEmployeeForSalary is calling : "+" : companyId "+ companyId +"departmentId " +departmentId +"payMonth"+payMonth);
		List<Object[]>  attendanceList  = attendanceRepository.fetchEmployeeForSalary( companyId, departmentId, payMonth  );
		//List< Attendance > attendanceDTOList = new ArrayList <Attendance>();	
		List<ReportPayOut> reportPayOuts = new ArrayList<ReportPayOut>();
		String relation;
		
		Long tempDepartmentId = null;
		for ( Object[] attendanceObj : attendanceList ) { 
			//Attendance attendance = new Attendance();
			tempDepartmentId = ConverterUtil.getLong( attendanceObj[8]    ) ;
			
			if ( tempDepartmentId != null && (tempDepartmentId == departmentId) ) {
			
			ReportPayOut reportPayOut = new ReportPayOut();
			
			reportPayOut.setDepartmentId( ConverterUtil.getLong( attendanceObj[8]    ) );	
			
			ReportPayOutPK pk = new ReportPayOutPK();
			pk.setProcessMonth( payMonth );
			pk.setEmployeeId( ConverterUtil.getLong( attendanceObj[7])   );
			reportPayOut.setId( pk );
			
			reportPayOut.setPresense(  ConverterUtil.getBigDecimal( attendanceObj[0] )  );
			reportPayOut.setWeekoff(  ConverterUtil.getBigDecimal( attendanceObj[1] ) );
			reportPayOut.setSeekleave( ConverterUtil.getBigDecimal( attendanceObj[2] )  );
			reportPayOut.setPaidleave( ConverterUtil.getBigDecimal( attendanceObj[3] ) );
			//reportPayOut.setPayDays( ConverterUtil.getBigDecimal( attendanceObj[4] ) );
			reportPayOut.setPublicholidays( ConverterUtil.getBigDecimal( attendanceObj[5] )  );
			reportPayOut.setAbsense( ConverterUtil.getBigDecimal( attendanceObj[6] )  );
			
			//reportPayOut.setEmployeeId(   ConverterUtil.getLong( attendanceObj[7]    ) );	
			
			reportPayOut.setCityId( ConverterUtil.getLong( attendanceObj[9]    ) );
			
			reportPayOut.setName( attendanceObj[ 10 ].toString() +"  " +attendanceObj [11].toString()  );
			reportPayOut.setEmployeeCode( attendanceObj[ 12 ].toString() );
			reportPayOut.setAccountNumber( attendanceObj[ 13 ].toString() );
			
			if ( attendanceObj[ 14 ] != null) {
				Date doj = (Date)( attendanceObj[ 14 ] );
				reportPayOut.setDateOfJoining( doj  );
				reportPayOut.setEpfJoining( doj );
			}
			
			
			reportPayOut.setBankShortName( attendanceObj[ 15 ].toString() );   
			
			reportPayOut.setCompanyId( ConverterUtil.getLong( attendanceObj[16] ) );
			
			relation = attendanceObj[ 17 ].toString();
			if ( relation.equals( RelationEnum.Father.getRelation())) {
				if ( attendanceObj[ 18 ] != null) 
					reportPayOut.setFatherName(  attendanceObj[ 18 ].toString() );
			}
			
			if ( relation.equals( RelationEnum.Husband.getRelation())) {
				if ( attendanceObj[ 18 ] != null) 
					reportPayOut.setHusbandName(  attendanceObj[ 18 ].toString() );
			}
			
			if ( attendanceObj[ 19 ] != null) 
				reportPayOut.setMaritalStatus(  attendanceObj[ 19 ].toString() );
			
			if ( attendanceObj[ 20 ] != null) 
					reportPayOut.setEmail(  attendanceObj[ 20 ].toString() );
			
			if ( attendanceObj[ 21 ] != null) 
				reportPayOut.setMobileNo(  attendanceObj[ 21 ].toString() );
			
			if ( attendanceObj[ 22 ] != null) 
				reportPayOut.setIFSCCode(  attendanceObj[ 22 ].toString() );
			
			if ( attendanceObj[ 23 ] != null) 
				reportPayOut.setGender(  attendanceObj[ 23 ].toString() );
			
			
			
			if ( attendanceObj[ 24 ] != null) 
				reportPayOut.setDob( (Date) attendanceObj[ 24 ] );
			
			reportPayOut.setStateId( ConverterUtil.getLong( attendanceObj[ 25 ]  ) );
			
			if ( attendanceObj[ 26 ] != null) 
				reportPayOut.setAadharNo(  attendanceObj[ 26 ].toString() );
			
			if ( attendanceObj[ 27 ] != null) 
				reportPayOut.setIsNoPFDeduction(  attendanceObj[ 26 ].toString() );
			
			reportPayOuts.add( reportPayOut );
			}
			
		}	
	
		return reportPayOuts;
	}
  
	@Override
	public List<EmployeeDTO> fetchEmployeeForValidation(long departmentId ,long companyId, String payMonth ) {
		
		Date processMonth = DateUtils.getPayMonth( payMonth );
		List<Object[]>  employeeList  = attendanceRepository.fetchEmployeeForValidation( departmentId , companyId, processMonth );
		List<EmployeeDTO> employee = new ArrayList<EmployeeDTO>();

		
		for ( Object[] empObj : employeeList ) { 
			EmployeeDTO empValidation = new EmployeeDTO();
			empValidation.setEmployeeId(ConverterUtil.getLong( empObj[0]) );
			empValidation.setEmployeeCode(empObj[1].toString());
			empValidation.setDepartmentId(ConverterUtil.getLong( empObj[2] ));
			empValidation.setBankId(ConverterUtil.getString(empObj[3]));
			empValidation.setPayStructureHdId(ConverterUtil.getLong( empObj[4]));
			//empValidation.setUanNumber(ConverterUtil.getString( empObj[5]));
			empValidation.setAadharNumber(ConverterUtil.getString( empObj[5]));
			employee.add( empValidation );
		}	
		return employee;
	}

	@Override
	public List<Attendance> fetchEmployeeForSalary(long companyId, long departmentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public List<String> validateAttendanceBeforeUpload( long companyId, long departmentId, String processMonth ) {
		//boolean flag = false;
		
		List<String> deptList =new ArrayList<String>();
		if ( departmentId > 0 ) {
			 deptList=  attendanceRepository.isAttendanceUploadedForMonthAndDepartment(departmentId, processMonth);
			
		} else {
			 deptList =  attendanceRepository.isAttendanceUploadedForMonthAndCompany(companyId, processMonth);
			
		}
		
		return deptList;
	}

	@Override
	public void  upload( List<Attendance> attendances) {
		
		
		attendanceRepository.save(attendances);
	}

	@Override
	public List<EmployeeDTO> fetchEmployeeForValidation( long companyId, String payMonth ) {
		
		Date processMonth = DateUtils.getPayMonth( payMonth );
		List<Object[]>  employeeList  = attendanceRepository.fetchEmployeeForValidation( companyId, processMonth );
		List<EmployeeDTO> employee = new ArrayList<EmployeeDTO>();

		
		for ( Object[] empObj : employeeList ) { 
			EmployeeDTO empValidation = new EmployeeDTO();
			empValidation.setEmployeeId(ConverterUtil.getLong( empObj[0]) );
			empValidation.setEmployeeCode(empObj[1].toString());
			empValidation.setDepartmentId(ConverterUtil.getLong( empObj[2] ));
			empValidation.setBankId(ConverterUtil.getString(empObj[3]));
			empValidation.setPayStructureHdId(ConverterUtil.getLong( empObj[4]));
			//empValidation.setUanNumber(ConverterUtil.getString( empObj[5]));
			empValidation.setAadharNumber(ConverterUtil.getString( empObj[5]));
			employee.add( empValidation );
		}	
		return employee;
	}
	
	@Override
	public List<String> findDepartmentForProcessing(  long companyId,  String processMonth  ) {
		return attendanceRepository.findDepartmentForProcessing( companyId, processMonth );
	}

}
