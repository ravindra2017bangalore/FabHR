package com.csipl.tms.leave.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.services.notification.NotificationServices;
import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.tms.leave.repository.CompensatoryOffRepository;
import com.csipl.tms.model.leave.CompensatoryOff;

@Service("compensatoryOffService")
public class CompensatoryOffServiceImpl implements CompensatoryOffService{
	@Autowired
	 CompensatoryOffRepository compensatoryOffRepository;
	
	@Autowired
	private  NotificationServices notificationServices;
	
	@Autowired
	private EmployeePersonalInformationService employeePersonalInformationService;
	
	
	NotificationMailSmsDto notificationMailSmsDto=new NotificationMailSmsDto();
	@Override
	public CompensatoryOff saveAll(CompensatoryOff compensatoryOff) {
		// TODO Auto-generated method stub
		System.out.println("model"+compensatoryOff.getEmployeeId());
		CompensatoryOff compensatoryOffNew = compensatoryOffRepository.save(compensatoryOff);
		System.out.println("compensatoryOffNew.getEmployeeId()=============================================="+compensatoryOffNew.getEmployeeId());
		notificationMailSmsDto.setNotificationType("LA");
		List<Object[]> reportingTo=employeePersonalInformationService.getEmpReportingToEmail(compensatoryOffNew.getEmployeeId());
		System.out.println("object length==================================================="+reportingTo.size());
		List<String> to=new ArrayList<String>();
		if(reportingTo.size()>0)
		{
			for(Object obj[]:reportingTo)
			{
				System.out.println("reporting to email id"+obj[2].toString());
				to.add(obj[2].toString());
			}
		}
		Employee emp=employeePersonalInformationService.findEmployeesById(compensatoryOffNew.getEmployeeId());
		to.add(emp.getOfficialEmail());
		
		notificationMailSmsDto.setTo(to);
//		List<String> cc=new ArrayList<String>();
//		cc.add("pragya@computronics.in");
//		notificationMailSmsDto.setCc(cc);
		notificationMailSmsDto.setHtml(true);
		Map model = new HashMap();
		//notificationMailSmsDto.setMobileNo("8817999957");
		model.put("firstName", "Harsha");
		model.put("lastName", "Ahuja");
		notificationMailSmsDto.setMapAttribute(model);
		if(compensatoryOffNew.getApprovalId()!=null)
		notificationMailSmsDto.setTempLateName("templates/InviteTemplate.vm");
		else
		notificationMailSmsDto.setTempLateName("templates/InviteTemplate.vm");	
		notificationServices.sendNotification(notificationMailSmsDto);
		System.out.println(compensatoryOffNew);
		return compensatoryOffNew;
	}

	@Override
	public List<CompensatoryOff> findAllCompensatoryOff(Long companyId) {
	
		return compensatoryOffRepository.findAllCompensatoryOff(companyId);
	}

	@Override
	public List<CompensatoryOff> findMyCompOffPendingReqList(Long employeeId) {
		String status=StatusMessage.PENDING_CODE;
		return compensatoryOffRepository.findMyCompOffPendingReqList(employeeId, status);
	}

	@Override
	public List<CompensatoryOff> findMyCompOffExcludedPendingReqList(Long employeeId) {
		String status=StatusMessage.PENDING_CODE;
		return compensatoryOffRepository.findMyCompOffExcludedPendingReqList(employeeId, status);
	}

	@Override
	public CompensatoryOff getCompensatoryOff(Long tmsCompensantoryOffId) {
		
		return compensatoryOffRepository.findOne(tmsCompensantoryOffId);
	}

	@Override
	public List<CompensatoryOff> findAllCompOffPendingReqList(Long companyId) {
		String status=StatusMessage.PENDING_CODE;
		return compensatoryOffRepository.findAllCompOffPendingReqList(companyId, status);
	}

	@Override
	public List<CompensatoryOff> findAllCompOffExcludedPendingReqList(Long companyId) {
		String status=StatusMessage.PENDING_CODE;
		return compensatoryOffRepository.findAllCompOffExcludedPendingReqList(companyId, status);
	}

}
