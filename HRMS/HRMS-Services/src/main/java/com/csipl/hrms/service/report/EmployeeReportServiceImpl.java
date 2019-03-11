package com.csipl.hrms.service.report;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.dto.report.EmployeeReportDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.report.repository.EmployeeReportRepository;
import com.csipl.hrms.service.util.ConverterUtil;

@Service("employeeReportService")
public class EmployeeReportServiceImpl implements EmployeeReportService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeReportServiceImpl.class);

	@Autowired
	private EmployeeReportRepository employeeReportRepository;

	@Override
	public EmployeeReportDTO countEMPIMPTODAYDATE(Long companyId, String value) {

		value = "";
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.countEMPIMPTODAYDATE(companyId, value);

		EmployeeReportDTO empDto = new EmployeeReportDTO();

		for (Object[] report : empReportList) {

			empDto.setAnniversarydateCount(ConverterUtil.getString(report[0]));
			empDto.setBirthdaydateCount(ConverterUtil.getString(report[1]));
			empDto.setWorkanniversarydateCount(ConverterUtil.getString(report[2]));
			empDto.setEmpCount(ConverterUtil.getString(report[3]));
			empDto.setDeptCount(ConverterUtil.getString(report[4]));
			System.out.println("========strored===================" + ConverterUtil.getString(report[0]));
			System.out.println("==========strored=================" + ConverterUtil.getString(report[1]));
			System.out.println("===========strored================" + ConverterUtil.getString(report[2]));

		}

		return empDto;
	}
	
	
	@Override
	public EmployeeReportDTO empTicketStatus(Long companyId,Long userId,String roleName) {

		
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.empTicketStatus(companyId,userId,roleName);

		EmployeeReportDTO empDto = new EmployeeReportDTO();

		for (Object[] report : empReportList) {

			empDto.setTicketLogged(ConverterUtil.getString(report[0]));
			empDto.setTicketResolved(ConverterUtil.getString(report[1]));
			empDto.setTicketPending(ConverterUtil.getString(report[2]));
		
		

		}

		return empDto;
	}
	
	
	
	@Override
	public EmployeeReportDTO empTicketStatuswithMonth(Long companyId,Long lastMonth) {

		
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.empTicketStatuswithMonth(companyId,lastMonth);

		EmployeeReportDTO empDto = new EmployeeReportDTO();

		for (Object[] report : empReportList) {

			empDto.setTicketLogged(ConverterUtil.getString(report[0]));
			empDto.setTicketResolved(ConverterUtil.getString(report[1]));
			empDto.setTicketPending(ConverterUtil.getString(report[2]));
			
		

		}

		return empDto;
	}
	
	
	
	@Override
	public List<EmployeeReportDTO> fetchBirthDayEmpList(Long companyId, String value) {
		// TODO Auto-generated method stub data_birhtday

		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.fetchBirthDayEmpList(companyId, value);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();
			empDto.setEmpName(ConverterUtil.getString(report[0]));
			empDto.setEmpCode(ConverterUtil.getString(report[1]));
			empDto.setEmpDetp(ConverterUtil.getString(report[2]));
			empDto.setEmpDesignation(ConverterUtil.getString(report[3]));
			empDto.setBirthdaydate(ConverterUtil.getString(report[4]));
			empDto.setEmployeeLogoPath(ConverterUtil.getString(report[5]));
			employeeReportDTO.add(empDto);

			System.out.println("========strored===================" + ConverterUtil.getString(report[0]));
			System.out.println("==========strored=================" + ConverterUtil.getString(report[1]));
			System.out.println("===========strored================" + empDto.getEmpDetp());

		}

		return employeeReportDTO;

	}

	@Override
	public List<EmployeeReportDTO> fetchAnniversaryDayEmpList(Long companyId, String value) {
		List<Object[]> empReportList = employeeReportRepository.fetchAnniversaryDayEmpList(companyId, value);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();
			empDto.setEmpName(ConverterUtil.getString(report[0]));
			empDto.setEmpCode(ConverterUtil.getString(report[1]));
			empDto.setEmpDetp(ConverterUtil.getString(report[2]));
			empDto.setEmpDesignation(ConverterUtil.getString(report[3]));
			empDto.setAnniversarydate(ConverterUtil.getString(report[4]));
			empDto.setEmployeeLogoPath(ConverterUtil.getString(report[5]));
			
			employeeReportDTO.add(empDto);

			System.out.println("========strored===================" + ConverterUtil.getString(report[0]));
			System.out.println("==========strored=================" + ConverterUtil.getString(report[1]));
			System.out.println("===========strored================" + ConverterUtil.getString(report[2]));

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> fetchWorkAnniversaryDayEmpList(Long companyId, String value) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.fetchWorkAnniversaryDayEmpList(companyId, value);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();
			empDto.setEmpName(ConverterUtil.getString(report[0]));
			empDto.setEmpCode(ConverterUtil.getString(report[1]));
			empDto.setEmpDetp(ConverterUtil.getString(report[2]));
			empDto.setEmpDesignation(ConverterUtil.getString(report[3]));
			empDto.setWorkanniversarydate(ConverterUtil.getString(report[4]));
			empDto.setEmployeeLogoPath(ConverterUtil.getString(report[5]));
			
			employeeReportDTO.add(empDto);

			System.out.println("========strored===================" + ConverterUtil.getString(report[0]));
			System.out.println("==========strored=================" + ConverterUtil.getString(report[1]));
			System.out.println("===========strored================" + ConverterUtil.getString(report[2]));

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> fetchEmployeeDocumentConfirmation(Long companyId) {
		// TODO Auto-generated method stub Name UI UA ES BA AI MI
		List<Object[]> empReportList = employeeReportRepository.fetchEmployeeDocumentConfirmation(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();
			if (ConverterUtil.getString(report[0]) != null) {
				empDto.setEmpName(ConverterUtil.getString(report[0]));
			}

			if (ConverterUtil.getString(report[1]) != null) {
				empDto.setEmpCode(ConverterUtil.getString(report[1]));
			}

			if (ConverterUtil.getString(report[2]) != null) {
				empDto.setEmployeeLogoPath(ConverterUtil.getString(report[2]));
			}
			
			if (ConverterUtil.getString(report[3]) != null) {
				empDto.setEmpDesignation(ConverterUtil.getString(report[3]));
			}

			if (ConverterUtil.getString(report[4]) != null) {
				empDto.setEmpDetp(ConverterUtil.getString(report[4]));
			}

			if (ConverterUtil.getString(report[5]) != null) {
				empDto.setuId(ConverterUtil.getString(report[5]));
			}

			if (ConverterUtil.getString(report[6]) != null) {
				empDto.setuA(ConverterUtil.getString(report[6]));
			}

			if (ConverterUtil.getString(report[7]) != null) {
				empDto.seteS(ConverterUtil.getString(report[7]));
			}

			if (ConverterUtil.getString(report[8]) != null) {
				empDto.setbA(ConverterUtil.getString(report[8]));
			}

			if (ConverterUtil.getString(report[9]) != null) {
				empDto.setaI(ConverterUtil.getString(report[9]));
			}

			if (ConverterUtil.getString(report[10]) != null) {
				empDto.setmI(ConverterUtil.getString(report[10]));
			}

			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> fetchDesignationWiseCTC(Long companyId, Long p_process_month) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.fetchDesignationWiseCTCList(companyId, p_process_month);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();
			empDto.setEmpDesignation(ConverterUtil.getString(report[0]));
			empDto.setEmpCtc(ConverterUtil.getString(report[1]));
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> fetchHeadCountByBankPay(Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.fetchHeadCountByBankPay(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();
			empDto.setBankPer(ConverterUtil.getString(report[0]));
			empDto.setEmpBankName(ConverterUtil.getString(report[1]));
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}
	
	@Override
	public List<EmployeeReportDTO> empPayrollstatusbyMonth(Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]>  empReportList  = employeeReportRepository.empPayrollstatusbyMonth(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();
		
		
		   for ( Object[] report : empReportList ) { 
				 EmployeeReportDTO empDto = new EmployeeReportDTO();
				 empDto.setProcessMonth(ConverterUtil.getString( report[0]));
				 empDto.setEmpDetp(ConverterUtil.getString( report[1]));
				if(ConverterUtil.getString( report[2])!=null) {
					 empDto.setGenStatus("Done"); 
				 }else {
					 empDto.setGenStatus("Pending");  
				 }
				 if(ConverterUtil.getString( report[3])!=null) {
					 empDto.setDisStatus("Done"); 
				 }else {
					 empDto.setDisStatus("Pending");  
				 }
				 employeeReportDTO.add( empDto );
					  
			}	

    return employeeReportDTO ;
	}


	@Override
	public List<EmployeeReportDTO> fetchEmpPfContribution(Long companyId, Long p_process_month) {
		// TODO Auto-generated method stub fetchEmpPfContribution
		List<Object[]> empReportList = employeeReportRepository.fetchEmpPfContribution(companyId, p_process_month);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();
			if(ConverterUtil.getString(report[0])!=null) {
				empDto.setAmtEmployee(ConverterUtil.getString(report[0]));
			}
			if(ConverterUtil.getString(report[1])!=null) {
				empDto.setAmtEmployer(ConverterUtil.getString(report[1]));
			}
			if(ConverterUtil.getString(report[2])!=null) {
				empDto.setAmtPension(ConverterUtil.getString(report[2]));
			}
		
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> fetchEmpESIContribution(Long companyId, Long p_process_month) {
		// TODO Auto-generated method stub fetchEmpPfContribution
		List<Object[]> empReportList = employeeReportRepository.fetchEmpESIContribution(companyId, p_process_month);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();
			if(ConverterUtil.getString(report[0])!=null) {
				empDto.setAmtEmployee(ConverterUtil.getString(report[0]));
				
			}
			if(ConverterUtil.getString(report[1])!=null) {
				empDto.setAmtEmployer(ConverterUtil.getString(report[1]));
				
			}
			
		
			
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public EmployeeReportDTO countNotification(Long companyId) {
		// TODO Auto-generated method stub
		String value = " ";
		List<Object> empReportList = employeeReportRepository.countNotification(companyId, value);
		EmployeeReportDTO empDto = new EmployeeReportDTO();
		if(ConverterUtil.getString(empReportList.get(0)).equals("0")) {
			empDto.setHeadcountNotification("");
		}else {
			empDto.setHeadcountNotification(ConverterUtil.getString(empReportList.get(0)));
	
		}
	
		System.out.println("=====ashish=======" + ConverterUtil.getString(empReportList.get(0)));

		return empDto;

	}

	@Override
	public List<EmployeeReportDTO> employeeNotification(Long companyId, String value) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.employeeNotification(companyId, value);
		List<EmployeeReportDTO> employeeReportList = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto0 = new EmployeeReportDTO();
			EmployeeReportDTO empDto1 = new EmployeeReportDTO();
			
				empDto0.setNotification(ConverterUtil.getString(report[0]));
				empDto0.setCountNotification(ConverterUtil.getString(report[1]));
				empDto0.setUrl("/empMaster/ticketManagament-list");
				if(Integer .parseInt(ConverterUtil.getString(report[1]))>0) {
					employeeReportList.add(empDto0);
				}
				
			
			
			
			
			empDto1.setNotification(ConverterUtil.getString(report[2]));
			empDto1.setCountNotification(ConverterUtil.getString(report[3]));
			empDto1.setUrl("/empMaster/resignationList");
			if(Integer .parseInt(ConverterUtil.getString(report[3]))>0) {
				employeeReportList.add(empDto1);
			}
			
			
		System.out.println("========notification============"+ConverterUtil.getString(report[1]));
		System.out.println("========notification============"+ConverterUtil.getString(report[3]));

		}

		return employeeReportList;
	}

	@Override
	public List<EmployeeReportDTO> fetchEmployeeSeprationInfo(Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.fetchEmployeeSeprationInfo(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();
			if (ConverterUtil.getString(report[0]) != null) {
				empDto.setEmpName(ConverterUtil.getString(report[0]));
			}

			if (ConverterUtil.getString(report[1]) != null) {
				empDto.setEmpCode(ConverterUtil.getString(report[1]));
			}

			if (ConverterUtil.getString(report[2]) != null) {
				empDto.setEmpDesignation(ConverterUtil.getString(report[2]));
			}

			if (ConverterUtil.getString(report[3]) != null) {
				empDto.setEmpDetp(ConverterUtil.getString(report[3]));
			}

			if (ConverterUtil.getString(report[4]) != null) {
				empDto.setDateCreated(ConverterUtil.getString(report[4]));
			}

			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> empGenderWiseRatio(Long companyId) {
		// TODO Auto-generated method stub

		List<Object[]> empReportList = employeeReportRepository.empGenderWiseRatio(companyId);

		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {

			EmployeeReportDTO empDto = new EmployeeReportDTO();

			empDto.setFemalePer(ConverterUtil.getString(report[0]));
			empDto.setMalePer(ConverterUtil.getString(report[1]));
			empDto.setOtherPer(ConverterUtil.getString(report[2]));
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;

	}

	@Override
	public List<EmployeeReportDTO> empAgeWiseRatio(Long companyId) {
		// TODO Auto-generated method stub

		List<Object[]> empReportList = employeeReportRepository.empAgeWiseRatio(companyId);

		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {

			EmployeeReportDTO e1 = new EmployeeReportDTO();
			EmployeeReportDTO e2 = new EmployeeReportDTO();
			EmployeeReportDTO e3 = new EmployeeReportDTO();
			EmployeeReportDTO e4 = new EmployeeReportDTO();
			EmployeeReportDTO e5 = new EmployeeReportDTO();

			e1.setEmpAge(ConverterUtil.getString(report[0]));
			e1.setEmpRange("Age: 15-20");
			e2.setEmpAge(ConverterUtil.getString(report[1]));
			e2.setEmpRange("Age: 20-30");
			e3.setEmpAge(ConverterUtil.getString(report[2]));
			e3.setEmpRange("Age: 30-40");
			e4.setEmpAge(ConverterUtil.getString(report[3]));
			e4.setEmpRange("Age: 40-50");
			e5.setEmpAge(ConverterUtil.getString(report[4]));
			e5.setEmpRange("Age: 50-60");

			employeeReportDTO.add(e1);
			employeeReportDTO.add(e2);
			employeeReportDTO.add(e3);
			employeeReportDTO.add(e4);
			employeeReportDTO.add(e5);
		}

		return employeeReportDTO;

	}

	@Override
	public List<EmployeeReportDTO> departmentWiseRatio(Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.departmentWiseRatio(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();

			empDto.setEmpDetp(ConverterUtil.getString(report[1]));
			empDto.setDeptCount(ConverterUtil.getString(report[2]));
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> EmpAttritionofResigned(Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.EmpAttritionofResigned(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();

			empDto.setEmpCount(ConverterUtil.getString(report[0]));
			empDto.setProcessMonth(ConverterUtil.getString(report[1]));
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> EmpAttritionofJoined(Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.EmpAttritionofJoined(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();

			empDto.setEmpCount(ConverterUtil.getString(report[0]));
			empDto.setProcessMonth(ConverterUtil.getString(report[1]));
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> empCompanyAnnouncement(Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.empCompanyAnnouncement(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();

			empDto.setTitle(ConverterUtil.getString(report[0]));
			empDto.setDesc(ConverterUtil.getString(report[1]));
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> empCountByDesignationWise(Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.empCountByDesignationWise(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();

			empDto.setEmpCount(ConverterUtil.getString(report[0]));
			empDto.setEmpDesignation(ConverterUtil.getString(report[1]));
			employeeReportDTO.add(empDto);

		}

		return employeeReportDTO;
	}

	@Override
	public List<EmployeeReportDTO> empCountByDepartmentWise(Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]> empReportList = employeeReportRepository.empCountByDepartmentWise(companyId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();

		for (Object[] report : empReportList) {
			EmployeeReportDTO empDto = new EmployeeReportDTO();

			empDto.setEmpCount(ConverterUtil.getString(report[0]));
			empDto.setEmpDetp(ConverterUtil.getString(report[1]));
			employeeReportDTO.add(empDto);
 		}

		return employeeReportDTO;
	}

	@Override
	public List<Employee> findEmployeesReportStatusBased(String status, Long companyId) {
		DateUtils dateUtils=new DateUtils();
		String currentDate=dateUtils.getCurrentDateTime();
 		Timestamp ts= dateUtils.getCurrentDateWithTimestamp(currentDate);
		
		return employeeReportRepository.findEmployeesReportStatusBased11(companyId, status);//ts
	}

	public List<Employee> findEmployeesReportDeptAndStatusBased(Long companyId, Date fromDate1, Date toDate1,
			Long departmentId, String status) {
		if(departmentId==0) {
 			if(status.equals("DE")) {
			return employeeReportRepository.findDeactivateEmployeesReportDurationBased(companyId, status,
					fromDate1, toDate1);
 			}
			else {
				return employeeReportRepository.findEmployeesReportStatusAndDurationBased(companyId, status,
						fromDate1, toDate1);
			}
			}
		else {
 			if(status.equals("DE")) {
	 		return employeeReportRepository.findDeactivateEmployeesReportDurationAndDeptBased(companyId, departmentId, status,
				fromDate1, toDate1);
 			}
 			else {
 		 		return employeeReportRepository.findEmployeesReportDeptAndStatusBased(companyId, departmentId, status,
 						fromDate1, toDate1);
 			}
	}
		}


	@Override
	public List<EmployeeReportDTO> empAttendanceRatio(Long companyId ,Long employeeId) {
		System.out.println("empAttendanceRatio..serviceIMPL");
		List<Object[]> empAttendanceReportList = employeeReportRepository.empAttendanceRatio(companyId,employeeId);
		List<EmployeeReportDTO> employeeReportDTO = new ArrayList<EmployeeReportDTO>();
		System.out.println("EmployeeReportServiceImpl.."+empAttendanceReportList);
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		 int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		 System.out.println("maxDay...in month.."+maxDay);
		for (Object[] report : empAttendanceReportList) {

			EmployeeReportDTO e1 = new EmployeeReportDTO();
			EmployeeReportDTO e2 = new EmployeeReportDTO();
		EmployeeReportDTO e3 = new EmployeeReportDTO();
		/*	EmployeeReportDTO e4 = new EmployeeReportDTO();
			EmployeeReportDTO e5 = new EmployeeReportDTO();*/

			e1.setEmpAttenance(ConverterUtil.getString(report[0]));
			e1.setEmpAttendanceeRange("presense");
			e2.setEmpAttenance(ConverterUtil.getString(report[1]));
			e2.setEmpAttendanceeRange("on leave");
			Long absent =Long.valueOf(maxDay)-(ConverterUtil.getLong(report[0])+ConverterUtil.getLong(report[1]));
			e3.setEmpAttenance(ConverterUtil.getString(absent));
			e3.setEmpAttendanceeRange("absent");
			employeeReportDTO.add(e1);
			employeeReportDTO.add(e2);
			employeeReportDTO.add(e3);
			//employeeReportDTO.add(e3);
			//employeeReportDTO.add(e4);
			//employeeReportDTO.add(e5);
		}

		return employeeReportDTO;
	}
}
