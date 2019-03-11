package com.csipl.tms.leave.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.services.notification.NotificationServices;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.adaptor.EmployeePersonalInformationAdaptor;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.employee.repository.EmployeePersonalInformationRepository;
import com.csipl.tms.dto.leave.LeaveBalanceDTO;
import com.csipl.tms.dto.leave.LeaveBalanceSummryDTO;
import com.csipl.tms.dto.leave.LeaveEntryDTO;
import com.csipl.tms.dto.leave.TeamLeaveOnCalenderDTO;
import com.csipl.tms.empcommondetail.service.EmpCommonDetailService;
import com.csipl.tms.holiday.repository.HolidayRepository;
import com.csipl.tms.leave.adaptor.LeaveEntryAdaptor;
import com.csipl.tms.leave.repository.EmployeeLeaveEarnRepository;
import com.csipl.tms.leave.repository.LeaveEntryRepository;
import com.csipl.tms.leave.repository.TMSLeaveRulesRepository;
import com.csipl.tms.model.holiday.TMSHolidays;
import com.csipl.tms.model.leave.TMSLeaveEntry;
import com.csipl.tms.model.leave.TMSLeaveRules;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;
import com.csipl.tms.rules.repository.SandWichRuleRepository;

@Service("employeeLeaveService")
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeLeaveServiceImpl.class);
	static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager eManager;

	@Autowired
	private NotificationServices notificationServices;
	
	@Autowired
	LeaveRulesHdService leaveRulesHdService;

	@Autowired
	LeaveEntryRepository leaveEntryRepository;

	@Autowired
	TMSLeaveRulesRepository tmsLeaveTypeRepository;

	@Autowired
	EmployeeLeaveEarnRepository employeeLeaveEarnRepository;

	@Autowired
	SandWichRuleRepository sandWichRuleRepository;

	@Autowired
	HolidayRepository holidayRepository;

	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;
	@Autowired
	EmployeePersonalInformationRepository employeePersonalInformationRepository;
	
	@Autowired
	private EmpCommonDetailService empCommonDetailService;
	
	NotificationMailSmsDto notificationMailSmsDto=new NotificationMailSmsDto();
	LeaveEntryAdaptor leaveEntryAdaptor = new LeaveEntryAdaptor();
	EmployeePersonalInformationAdaptor employeePersonalInformationAdaptor = new EmployeePersonalInformationAdaptor();
	@Override
	public boolean validateLeaveEntry(LeaveBalanceSummryDTO leaveBalanceSummryDto) throws ParseException, ErrorHandling {
		int appliedLeaveCount=0;
		//validate leave entry is already present in database or not 
		if (leaveBalanceSummryDto.getLeaveId()!=null)
		 appliedLeaveCount = leaveEntryRepository.checkDateValidation(leaveBalanceSummryDto.getEmployeeId(), leaveBalanceSummryDto.getFromDate(),
				leaveBalanceSummryDto.getToDate(),leaveBalanceSummryDto.getLeaveId());
		else
		 appliedLeaveCount = leaveEntryRepository.checkDateValidation1(leaveBalanceSummryDto.getEmployeeId(), leaveBalanceSummryDto.getFromDate(),
				leaveBalanceSummryDto.getToDate());
		System.out.println("appliedLeaveCount.."+appliedLeaveCount);
		Employee employee = employeePersonalInformationService.getEmployeeInfo(leaveBalanceSummryDto.getEmployeeId());
		logger.info("appliedLeaveCount :"+appliedLeaveCount );
		if (appliedLeaveCount < 1) {

			
		String leaveFromDateInString = getDateStringWirhYYYYMMDD(leaveBalanceSummryDto.getFromDate());
		String leaveToDateInString = getDateStringWirhYYYYMMDD(leaveBalanceSummryDto.getToDate());
			
		Date leavefromDate = new SimpleDateFormat("yyyy-MM-dd").parse(leaveFromDateInString);
		Date leavetoDate = new SimpleDateFormat("yyyy-MM-dd").parse(leaveToDateInString);

		//returning count number of month between leave applied days
		BigDecimal noOfMonths = checkNumberOfMonths(leavefromDate, leavetoDate);

		
		//returining first date of month 
		LocalDate leaveMonthStartLocalDate = leavefromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		leaveMonthStartLocalDate = leaveMonthStartLocalDate.withDayOfMonth(1);
		
		//returining last date of month 
		LocalDate leaveMonthEndLocalDate = leavetoDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        leaveMonthEndLocalDate = leaveMonthEndLocalDate.withDayOfMonth(leaveMonthEndLocalDate.lengthOfMonth());
		
		 
		Date leaveMonthStartDate = Date.from(leaveMonthStartLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			
	    Date leaveMonthEndDate = Date.from(leaveMonthEndLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			
	   // check how many leave applied between leave applied month
	    BigDecimal approvedPendingDaysCount =(BigDecimal) leaveEntryRepository.getEmployeeApprovedLeaveInDuration(
					leaveMonthStartDate, leaveMonthEndDate, leaveBalanceSummryDto.getEmployeeId(),
					leaveBalanceSummryDto.getLeaveTypeId());
	    
		//BigDecimal approvedPendingDays = leaveEntryAdaptor.objectArrayToLongDays(approvedPendingDaysList);

	 // check how many times leave apply between leave applied month
		int frequencyCount = leaveEntryRepository.getEmployeeMonthlyFrequencyCount(leaveMonthStartDate,
				leaveMonthEndDate, leaveBalanceSummryDto.getEmployeeId(), leaveBalanceSummryDto.getLeaveTypeId());
        BigDecimal frequencyCountOfEmployee=new BigDecimal(frequencyCount);
		
        BigDecimal leavePendingBalanceCount = new BigDecimal("0");
        BigDecimal maxLeaveInMonthly = new BigDecimal("0.0");
        BigDecimal leaveFrequencyMonthly = new BigDecimal("0.0");
        BigDecimal leaveAppliedDaysCount=new BigDecimal("0.0");
        
        
	    Long probationDays = 0l;

		if(leaveBalanceSummryDto.getDays()!=null)
			leaveAppliedDaysCount = leaveBalanceSummryDto.getDays();
		
		
			if(leaveBalanceSummryDto.getLeaveBalancedCount()!=null)
				leavePendingBalanceCount = leaveBalanceSummryDto.getLeaveBalancedCount();
			
			
			if(leaveBalanceSummryDto.getMaxLeaveInMonth()!=null) {
				maxLeaveInMonthly = new BigDecimal(noOfMonths.longValue() * leaveBalanceSummryDto.getMaxLeaveInMonth());
				maxLeaveInMonthly = maxLeaveInMonthly.subtract(approvedPendingDaysCount);  //.add(employeePndingLeaveInDurationBasedOnPKDays);
               }
			
			if (leaveBalanceSummryDto.getLeaveFrequencyInMonth() != null)
				leaveFrequencyMonthly = new BigDecimal(leaveBalanceSummryDto.getLeaveFrequencyInMonth());

			
			if (employee.getProbationDays() != null)//get provision days from employee table 
				probationDays = employee.getProbationDays();
				
				//  provision condition check 
				if (leaveBalanceSummryDto.getIsLeaveInProbation().equals("Y")
					|| probationDays < getDifferenceDays(getFormatedDate(employee.getDateOfJoining()),//employee.getDateOfJoining() pass from employee table
							new Date())) {
              
					//
				if (leaveAppliedDaysCount.compareTo(leavePendingBalanceCount) > 0) {
					System.out.println("You can't apply leave, due to insufficient balance.");
					throw new ErrorHandling("You can't apply leave, due to insufficient balance.");
				} else {
					
							if (leaveAppliedDaysCount.compareTo(maxLeaveInMonthly) > 0) {
								throw new ErrorHandling("You can't apply  " + leaveAppliedDaysCount+ " day(s) " + leaveBalanceSummryDto.getLeaveType() + " leave in a month, limit exceeded");
							} else {
								
								//BigDecimal bigLeaveFrequencyMonthly = new BigDecimal(leaveFrequencyMonthly);
								//BigDecimal bigFrequencyCount = new BigDecimal(frequencyCount);
								if (frequencyCountOfEmployee.compareTo(leaveFrequencyMonthly) < 0) {
									//System.out.println("in if leaveEntryRepository.save(leaveEntry);"+leaveEntryRepository.save(leaveEntry));
									
									return true;
									
								} else {
									System.out.println("You can't apply leave, monthly limit quota exceeded.");
									throw new ErrorHandling("You can't apply leave, monthly limit quota exceeded.");
								}
							}
						
					}
			} else {
				System.out.println("Can't apply leave in probation period");

				throw new ErrorHandling("Can't apply leave in probation period");
			}

		
			
		}
		else {
			System.out.println("You have already applied leave in the given duration.");
			throw new ErrorHandling("You have already applied leave in the given duration.");

		}
		//return true;
	}
	
	
	@Override
	public TMSLeaveEntry saveLeaveEntry(TMSLeaveEntry leaveEntry)  {
		TMSLeaveEntry tmsLeaveEntry=	leaveEntryRepository.save(leaveEntry);
		String firstName = null;
		String lastName = null;
		notificationMailSmsDto.setNotificationType("LA");
		List<Object[]> reportingTo=employeePersonalInformationService.getEmpReportingToEmail(tmsLeaveEntry.getEmployeeId());
		System.out.println("object length==================================================="+reportingTo.size());
		Employee employee=employeePersonalInformationService.getEmployeeInfo(tmsLeaveEntry.getEmployeeId());	
		
		String query = "SELECT emp.officialEmail  FROM Employee emp  WHERE  emp.companyId=?1  AND emp.employeeId IN ("+ tmsLeaveEntry.getNotifyEmployee() + ") AND emp.activeStatus='AC' ";
		Query nativeQuery = eManager.createNativeQuery(query);
		nativeQuery.setParameter(1, tmsLeaveEntry.getCompanyId());
		 
		List<String> resultList = nativeQuery.getResultList();
		logger.info("resultList size------>" + resultList.size());
		List<String> to=new ArrayList<String>();
		if(reportingTo.size()>0)
		{
			for(Object obj[]:reportingTo)
			{
				System.out.println("reporting to email id"+obj[2].toString());
				firstName=obj[4].toString();
				//lastName=obj[4].toString();
				to.add(obj[2].toString());
			}
		}
		to.add(employee.getOfficialEmail());
		List<String> cc=new ArrayList<String>();
		if(resultList.size()>0)
		{
			for(String obj:resultList)
			{
				System.out.println("notify to email id"+obj);
				cc.add(obj);
			}
		}
		
		notificationMailSmsDto.setTo(to);
		
		//cc.add("pragya@computronics.in");
		notificationMailSmsDto.setCc(cc);
		notificationMailSmsDto.setHtml(true);
		Map model = new HashMap();
		//notificationMailSmsDto.setMobileNo("8817999957");
		model.put("firstName",firstName);
		model.put("lastName", "");
		notificationMailSmsDto.setMapAttribute(model);
		notificationMailSmsDto.setTempLateName("templates/InviteTemplate.vm");
		notificationServices.sendNotification(notificationMailSmsDto);
		return tmsLeaveEntry;
	}

	/*@Override
	public TMSLeaveEntry saveLeaveEntry(TMSLeaveEntry leaveEntry)  {
		NotificationDTO notificationDto = new NotificationDTO();
		logger.info(" saveLeaveEntry in service  is calling leaveEntry obj>>:" + leaveEntry.toString());
		if (leaveEntry.getApprovalId() != null) {
			logger.info(" saveLeaveEntry in service leave request case  leaveEntry.getApprovalId()>>:"
					+ leaveEntry.getApprovalId());
			leaveEntryRepository.save(leaveEntry);
			
			//Employee employee = employeePersonalInformationService.getEmployeeInfo(leaveEntry.getApprovalId());
			String status;
			if (leaveEntry.getStatus().equals("A")) {
				status = "Approved";
			} else {
				status = "Reject";
			}
			notificationDto.setNotificationId(2l);
			//notificationDto.setMobileNo(employee.getMobile());
			notificationDto.setMobileNo("");
 			//String messageValues[] = { "", " Leave ", status, employee.getEmployeeCode() };
			notificationDto.setMessageValues(messageValues);
			notificationDto.setNotificationText("hello");
			//notificationServices.sendNotification(notificationDto);

		} else {
		 int count = leaveEntryRepository.checkDateValidation(leaveBalanceSummryDto.getEmployeeId(), leaveBalanceSummryDto.getFromDate(),
					leaveBalanceSummryDto.getToDate());
			if (count < 1) {
				//logger.info(" saveLeaveEntry in service leave apply case   " + leaveEntry.toString());
				
			
				List<Object[]> leaveBalanceObjectDtoList = leaveEntryRepository.getEmployeeLeaveLogic(
						leaveEntry.getEmployeeId(), leaveEntry.getTmsleaveType().getLeaveTypeId());
				LeaveBalanceDTO leaveBalanceDto = leaveEntryAdaptor.objectArrayToUiDto(leaveBalanceObjectDtoList,
						leaveEntry.getEmployeeId());
				List<Object[]> leavePendingBalanceObjectDtoList = leaveEntryRepository.getEmployeePendingLeave(
						leaveEntry.getEmployeeId(), leaveEntry.getTmsleaveType().getLeaveTypeId());
				LeaveBalanceDTO leavePendingBalanceDto = leaveEntryAdaptor
						.objectArrayToUiDto(leavePendingBalanceObjectDtoList, leaveEntry.getEmployeeId());
				TMSLeaveType tmsLeaveType = tmsLeaveTypeRepository
						.findOne(leaveEntry.getTmsleaveType().getLeaveTypeId());

				
				String strFromDate = getDateStringWirhYYYYMMDD(leaveBalanceSummryDto.getFromDate());
				String strToDate = getDateStringWirhYYYYMMDD(leaveBalanceSummryDto.getToDate());
				Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(strFromDate);
				Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(strToDate);

				BigDecimal noOfMonths = checkNumberOfMonths(fromDate, toDate);

				LocalDate fromLocalDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate toLocalDate = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				fromLocalDate = fromLocalDate.withDayOfMonth(1);
				
				toLocalDate = toLocalDate.withDayOfMonth(toLocalDate.lengthOfMonth());
				
				Date convertefromDate = Date.from(fromLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				Date converteToDate = Date.from(toLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				List<Object[]> approvedPendingDaysList = leaveEntryRepository.getEmployeeApprovedLeaveInDuration(
						convertefromDate, converteToDate, leaveEntry.getEmployeeId(),
						leaveEntry.getTmsleaveType().getLeaveTypeId());

				int frequencyCount = leaveEntryRepository.getEmployeeMonthlyFrequencyCount(convertefromDate,
						converteToDate, leaveEntry.getEmployeeId(), leaveEntry.getTmsleaveType().getLeaveTypeId());

				List<Object[]> employeePndingLeaveInDurationBasedOnPK = leaveEntryRepository
						.getEmployeePndingLeaveInDurationBasedOnPK(convertefromDate, converteToDate,
								leaveEntry.getEmployeeId(), leaveEntry.getTmsleaveType().getLeaveTypeId(),
								leaveEntry.getLeaveId());

				BigDecimal approvedPendingDays = leaveEntryAdaptor.objectArrayToLongDays(approvedPendingDaysList);
				
				BigDecimal employeePndingLeaveInDurationBasedOnPKDays = leaveEntryAdaptor
						.objectArrayToLongDays(employeePndingLeaveInDurationBasedOnPK);

				BigDecimal leavePendingBalance = new BigDecimal("0");

				Long maxLeaveMonthly = null;
				BigDecimal maxLeaveMonthlyNew = new BigDecimal("-1");

				Long leaveFrequencyMonthly = null;
				BigDecimal bigMaxLeaveMonthly = new BigDecimal("0.0");

				if (leavePendingBalanceDto.getLeaveTaken() != null)
					leavePendingBalance = leavePendingBalanceDto.getLeaveTaken();
			
				if(leaveBalanceSummryDto.getLeaveConsumedCount()!=null)
					leavePendingBalance = new BigDecimal(leaveBalanceSummryDto.getLeaveConsumedCount());
				
				if (tmsLeaveType.getMaxLeaveInMonth() != null) {
				maxLeaveMonthly = noOfMonths.longValue() * tmsLeaveType.getMaxLeaveInMonth();
				bigMaxLeaveMonthly = new BigDecimal(maxLeaveMonthly);
				bigMaxLeaveMonthly = bigMaxLeaveMonthly.subtract(approvedPendingDays).add(employeePndingLeaveInDurationBasedOnPKDays);

			}
				
				if(leaveBalanceSummryDto.getMaxLeaveInMonth()!=null) {
					maxLeaveMonthly = noOfMonths.longValue() * leaveBalanceSummryDto.getMaxLeaveInMonth();
					bigMaxLeaveMonthly = new BigDecimal(maxLeaveMonthly);
					bigMaxLeaveMonthly = bigMaxLeaveMonthly.subtract(approvedPendingDays);  //.add(employeePndingLeaveInDurationBasedOnPKDays);
	               }
				
				if (leaveBalanceSummryDto.getLeaveFrequencyInMonth() != null)
					leaveFrequencyMonthly = leaveBalanceSummryDto.getLeaveFrequencyInMonth();

				Long probationDays = 0l;
			//	if (leaveBalanceDto.getProbationDays() != null)//get provision days from employee table 
					probationDays = 90l;//leaveBalanceDto.getProbationDays();
					
 				if (leaveBalanceSummryDto.getIsLeaveInProbation().equals("Y")
						|| probationDays < getDifferenceDays(getFormatedDate(new Date()),//leaveBalanceDto.getDateOfJoining() pass from employee table
								new Date())) {

					if (leaveBalanceSummryDto.getDays().compareTo(new BigDecimal(leaveBalanceSummryDto.getLeaveBalancedCount())) > 0) {
						System.out.println("You can't apply leave, due to insufficient balance.");
						throw new ErrorHandling("You can't apply leave, due to insufficient balance.");
					} else {
						if (leaveBalanceSummryDto.getDays()
								.compareTo(new BigDecimal(leaveBalanceSummryDto.getLeaveBalancedCount()).subtract(leavePendingBalance)) > 0) {
							System.out.println("You Can't take more than " + leaveEntry.getDays()
							+ "  leave(s), you have taken  " + leavePendingBalance + "leave(s) ");
							throw new ErrorHandling("You Can't take more than " + leaveEntry.getDays()
									+ "  leave(s), you have taken  " + leavePendingBalance + "leave(s) ");
 						} else {
 							//if (!bigMaxLeaveMonthly.equals(maxLeaveMonthlyNew)) { 
						
								if (leaveBalanceSummryDto.getDays().compareTo(bigMaxLeaveMonthly) > 0) {
									throw new ErrorHandling("You can't apply  " + leaveEntry.getDays() + " day(s) " + leaveBalanceSummryDto.getLeaveType() + " leave in a month, limit exceeded");
								} else {
									
									BigDecimal bigLeaveFrequencyMonthly = new BigDecimal(leaveFrequencyMonthly);
									BigDecimal bigFrequencyCount = new BigDecimal(frequencyCount);
									if (bigFrequencyCount.compareTo(bigLeaveFrequencyMonthly) < 0) {
										//System.out.println("in if leaveEntryRepository.save(leaveEntry);"+leaveEntryRepository.save(leaveEntry));
										
										
										leaveEntryRepository.save(leaveEntry);
										EmpCommonDetail empCommonDetail = empCommonDetailService.getEmployeeCommonDetails(leaveEntry.getEmployeeId());
										notificationDto.setNotificationId(21l);
										String messageValues[] = { "", empCommonDetail.getEmployeeCode(), "Leave " };
										notificationDto.setMobileNo(empCommonDetail.getMobile());
										notificationDto.setMessageValues(messageValues);
										if (notificationDto != null)
											notificationServices.sendNotification(notificationDto);
									} else {
										System.out.println("You can't apply leave, monthly limit quota exceeded.");
										throw new ErrorHandling("You can't apply leave, monthly limit quota exceeded.");
									}
								}
								 }else {
								System.out.println("in else leaveEntryRepository.save(leaveEntry);");

 								leaveEntryRepository.save(leaveEntry);
							}
					//	}
 					}
				} else {
					System.out.println("Can't apply leave in probation period");

					throw new ErrorHandling("Can't apply leave in probation period");
				}

			} else {
				System.out.println("You have already applied leave in the given duration.");
				throw new ErrorHandling("You have already applied leave in the given duration.");
 			}
 		}
 	}
*/
	@Override
	public List<Object[]> leaveEntryList(Long companyId) {
		return leaveEntryRepository.leaveEntryList(companyId);
	}

	@Override
	public LeaveEntryDTO getLeaveEntry(Long leaveId) {
		Employee approvalEmp = null;
		Employee employeeEmp = null;

		TMSLeaveEntry tmsLeaveEntry = leaveEntryRepository.findOne(leaveId);
		if (tmsLeaveEntry.getEmployeeId() != null) {
			Long employeeId = tmsLeaveEntry.getEmployeeId();
			employeeEmp = employeePersonalInformationService.getEmployeeInfo(employeeId);
		}
		if (tmsLeaveEntry.getApprovalId() != null) {
			Long approvalId = tmsLeaveEntry.getApprovalId();
			approvalEmp =employeePersonalInformationService.getEmployeeInfo(approvalId);
		}
       
		logger.info("employeeDto---->" + tmsLeaveEntry.getNotifyEmployee());
		String query = "SELECT emp.employeeId,emp.firstName,emp.lastName,emp.employeeCode,emp.employeeLogoPath  FROM Employee emp  WHERE  emp.companyId=?1  AND emp.employeeId IN ("+ tmsLeaveEntry.getNotifyEmployee() + ") AND emp.activeStatus='AC' ";
		Query nativeQuery = eManager.createNativeQuery(query);
		nativeQuery.setParameter(1, tmsLeaveEntry.getCompanyId());
		final List<Object[]> resultList = nativeQuery.getResultList();
		logger.info("resultList size------>" + resultList.size());
		List<EmployeeDTO> employeeDtoList	=employeePersonalInformationAdaptor.databaseObjModelToUiDtoList(resultList);
		LeaveEntryDTO leaveEntryDto = leaveEntryAdaptor.databaseModelToUiDto(tmsLeaveEntry, employeeEmp, approvalEmp,employeeDtoList);

		return leaveEntryDto;
	}

	@Override
	public List<TMSLeaveEntry> getEmployeeLeaveEntry(Long employeeId) {
		return leaveEntryRepository.getEmployeeLeaveEntry(employeeId);
	}

	@Override
	public List<LeaveBalanceDTO> getEmployeeLeaveBalance(Long employeeId) {
		List<Object[]> leaveBalanceObjectDtoList = leaveEntryRepository.getEmployeeLeaveBalance(employeeId);
		List<Object[]> employeeDetailsList = leaveEntryRepository.getEmployeeDetails(employeeId);
		return leaveEntryAdaptor.objectArrayToUiDtoList(leaveBalanceObjectDtoList, employeeDetailsList, employeeId);
	}

	@Override
	public BigDecimal appliedLeaveDays(LeaveEntryDTO leaveEntryDto) throws ParseException {
		
		LeaveValidationResult leaveValidationResult = new LeaveValidationResult();
		
		//SandWichRule sandWichRule = sandWichRuleRepository.getSandwichRules(leaveEntryDto.getCompanyId());
		TMSLeaveRulesHd tmsLeaveRuleHd  = leaveRulesHdService.findLeaveRulesHd(leaveEntryDto.getCompanyId());
		System.out.println("tmsLeaveRuleHdList...."+tmsLeaveRuleHd);
		
		List<TMSHolidays> holidayList = holidayRepository.findAllHoliday(leaveEntryDto.getCompanyId());//leaveEntryDto.getCompanyId()
		System.out.println("holidayList...."+holidayList);
		
		List<Object[]> weekOffPattenList = leaveEntryRepository.getWeekOffPattern(leaveEntryDto.getEmployeeId());
		LeaveBalanceDTO leaveBalanceDto = leaveEntryAdaptor.weekOffPattenObjToUiDto(weekOffPattenList);
		System.out.println("leaveBalanceDto...."+leaveBalanceDto);
		String strFromDate = getDateStringWirhYYYYMMDD(leaveEntryDto.getFromDate());
		String strToDate = getDateStringWirhYYYYMMDD(leaveEntryDto.getToDate());

		Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(strFromDate);
		Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(strToDate);

		long timeDiff = Math.abs(toDate.getTime() - fromDate.getTime());
		double diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)) + 1;
		System.out.println("diffDays...."+diffDays);
			leaveValidationResult.setTotalLeaveApplyDays(new BigDecimal(diffDays));
		leaveValidationResult.setHolidaysOffCount(new BigDecimal(0.0));
		leaveValidationResult.setWeekllyOffCount(new BigDecimal(0.0));
		leaveValidationResult.setWeekholidaysOffCount(new BigDecimal(0.0));
		List<String> patternDayList = new ArrayList<>();
		if (leaveBalanceDto.getPatternDays() != null) {
			String patternDays = leaveBalanceDto.getPatternDays();
			patternDayList = Arrays.asList(patternDays.split(","));
		}
		weeklyOfPetternCount(fromDate, toDate, patternDayList, leaveValidationResult);
		holidayOfPetternCount(fromDate, toDate, holidayList, leaveValidationResult);
		
		BigDecimal actualLeaveAppliedDays = actualLeaveAppliedDaysCount(leaveValidationResult, tmsLeaveRuleHd.getTmsleaveRules());

		//BigDecimal actualLeaveAppliedDays = new BigDecimal(10);
		return actualLeaveAppliedDays;
	}

	public static String getDateStringWirhYYYYMMDD(Date date) {
		String dateStr = df.format(date);

		return dateStr;
	}

	public void weeklyOfPetternCount(Date fromDate, Date toDate, List<String> patternDayList,
			LeaveValidationResult leaveValidationResult) {

		Calendar start = Calendar.getInstance();
		start.setTime(fromDate);

		Calendar end = Calendar.getInstance();

		end.setTime(toDate);
		end.add(Calendar.DATE, 1);

		int matchedCount = 0;
		List<Date> applyHolidays = new ArrayList();
		for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
			// Do your job here with `date`.
			System.out.println(date);
			// applyDays.add(new
			// SimpleDateFormat("E").format(date).toUpperCase());

			for (String patternDay : patternDayList) {
				System.out.println("applay Days is " + patternDay);
				if (patternDay.equalsIgnoreCase(new SimpleDateFormat("E").format(date).toUpperCase())) {
					matchedCount++;
					applyHolidays.add(date);
				}
			}

		}

		leaveValidationResult.setApplyHolidays(applyHolidays);
		leaveValidationResult.setWeekllyOffCount(new BigDecimal(matchedCount));

	}

	public void holidayOfPetternCount(Date fromDate, Date toDate, List<TMSHolidays> holidayList,
			LeaveValidationResult leaveValidationResult) {
		Calendar start1 = Calendar.getInstance();
		start1.setTime(fromDate);

		Calendar end1 = Calendar.getInstance();

		end1.setTime(toDate);
		end1.add(Calendar.DATE, 1);

		int holidayMatchedCount = 0;
		int holidayWeeklyMatchedCount = 0;

		System.out.println("start1.getTime()" + start1.getTime() + "end1.getTime() " + start1.getTime());

		for (Date date = start1.getTime(); start1.before(end1); start1.add(Calendar.DATE, 1), date = start1.getTime()) {
			// Do your job here with `date`.
			System.out.println("testing holiday for " + date);

			for (TMSHolidays holiday : holidayList) {

				System.out.println("testing holiday form " + holiday.getFromDate() + " -----" + holiday.getToDate());

				Calendar startHolidayDate = Calendar.getInstance();
				startHolidayDate.setTime(holiday.getFromDate());

				Calendar endHolidayDate = Calendar.getInstance();

				endHolidayDate.setTime(holiday.getToDate());
				endHolidayDate.add(Calendar.DATE, 1);

				for (Date holidayDate = startHolidayDate.getTime(); startHolidayDate
						.before(endHolidayDate); startHolidayDate.add(Calendar.DATE,
								1), holidayDate = startHolidayDate.getTime()) {
					System.out.println("testing holiday form  inside sate : " + holidayDate + " date : " + date);
					if (date.compareTo(holidayDate) == 0) {
						holidayMatchedCount++;
						for (Date appliedHolidayDate : leaveValidationResult.getApplyHolidays()) {
							if (date.compareTo(appliedHolidayDate) == 0)
								holidayWeeklyMatchedCount++;
						}
						System.out.println("holiday matched date is " + date);

					}

				}

			}

		}

		leaveValidationResult.setHolidaysOffCount(new BigDecimal(holidayMatchedCount));
		leaveValidationResult.setWeekholidaysOffCount(new BigDecimal(holidayWeeklyMatchedCount));
		System.out.println("holidayMatchedCount is :" + holidayMatchedCount + " holidayWeeklyMatchedCount : "
				+ holidayWeeklyMatchedCount);

	}

	public BigDecimal actualLeaveAppliedDaysCount(LeaveValidationResult leaveValidationResult,
			List<TMSLeaveRules> tMSLeaveRuleList) {
		
		boolean weekOffBetweenTwoAbsent=false;
		boolean holidayBetweenTwoAbsent=false;
		for(TMSLeaveRules tmsLeaveRule:tMSLeaveRuleList) {
			if(("WOA").equals(tmsLeaveRule.getTmsleaveRuleMaster().getRuleCode()) && ("AC").equals(tmsLeaveRule.getActiveStatus()))
				weekOffBetweenTwoAbsent=true;
			if(("HOA").equals(tmsLeaveRule.getTmsleaveRuleMaster().getRuleCode()) && ("AC").equals(tmsLeaveRule.getActiveStatus()))
				holidayBetweenTwoAbsent=true;
		}
		

		BigDecimal actualLeaveApplied = new BigDecimal(0.0);
		boolean weekOffFlag = true;
		actualLeaveApplied = actualLeaveApplied.add(leaveValidationResult.getTotalLeaveApplyDays());

		if (weekOffBetweenTwoAbsent==false) {
			weekOffFlag = false;
			actualLeaveApplied = leaveValidationResult.getTotalLeaveApplyDays()
					.subtract(leaveValidationResult.getWeekllyOffCount());
		}

		if (holidayBetweenTwoAbsent==false) {

			if (weekOffFlag)
				actualLeaveApplied = actualLeaveApplied.subtract(leaveValidationResult.getHolidaysOffCount());
			else
				actualLeaveApplied = actualLeaveApplied.subtract(leaveValidationResult.getHolidaysOffCount()
						.subtract(leaveValidationResult.getWeekholidaysOffCount()));

		}

		return actualLeaveApplied;
	}

	public BigDecimal checkNumberOfMonths(Date start, Date end) {
		Calendar start1 = Calendar.getInstance();
		start1.setTime(start);
		Calendar end1 = Calendar.getInstance();
		end1.setTime(end);

		return new BigDecimal(((end1.get(Calendar.YEAR) - start1.get(Calendar.YEAR)) * 12) + 1
				+ (end1.get(Calendar.MONTH) - start1.get(Calendar.MONTH)));

	}

	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();

		long result = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return result;
	}

	public Date getFormatedDate(Date date) {

		String dateObj = df.format(date);
		Date formatedDate = null;
		try {
			formatedDate = df.parse(dateObj);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatedDate;

	}

	@Override
	public List<Object[]> getMonthEmployeeLeaveEntry(long companyId, long employeeId, String fromDate, String toDate) {

		String query = "SELECT * FROM TMSLeaveEntries WHERE companyId=?1 and employeeId=?2 and fromDate >=?3 and toDate <=?4 ORDER BY fromDate ASC";
		Query nativeQuery = eManager.createNativeQuery(query);
		nativeQuery.setParameter(1, companyId).setParameter(2, employeeId).setParameter(3, fromDate).setParameter(4,
				toDate);
		final List<Object[]> resultList = nativeQuery.getResultList();
		System.out.println("resultList size------>" + resultList.size());
		return resultList;
	}

	@Override
	public List<TMSLeaveEntry> getEmployeeApprovedLeaveEntry(Long employeeId) {
		return leaveEntryRepository.getEmployeeApprovedLeaveEntry(employeeId);
	}

	@Override
	public List<TMSLeaveEntry> getEmployeeLeaveEntryListByDate(Date date) {
		return leaveEntryRepository.getEmployeeLeaveEntryListByDate(date);
	}

	@Override
	public LeaveEntryDTO leaveCount(Long companyId,Long employeeId) {
		int leaveCount=leaveEntryRepository.leaveCount(companyId,employeeId);
		LeaveEntryDTO leaveEntryDto=new LeaveEntryDTO();
		leaveEntryDto.setLeaveCount(leaveCount);
		return leaveEntryDto;
	}

	@Override
	public List<TMSLeaveEntry> getEmployeePendingLeaveEntry(Long employeeId) {
		// TODO Auto-generated method stub
		return leaveEntryRepository.getEmployeePendingLeaveEntry(employeeId);
	}

	@Override
	public List<TMSLeaveEntry> getAllEmployeeApprovedLeaveEntry(Long companyId) {
		// TODO Auto-generated method stub
		return leaveEntryRepository.getAllEmployeeApprovedLeaveEntry(companyId);
	}

	@Override
	public List<LeaveBalanceSummryDTO> getEmployeeLeaveBalanceSummry(Long employeeId,Long companyId) {
		// TODO Auto-generated method stub
		List<Object[]> leaveBalanceSummryObjectList=leaveEntryRepository.getEmployeeLeaveBalanceSummry(employeeId, companyId);
		List<LeaveBalanceSummryDTO> leaveBalanceDtoList = leaveEntryAdaptor.leaveBalanceSummryObjToUiDto(leaveBalanceSummryObjectList);
		System.out.println("===size of list===="+leaveBalanceDtoList.size());
		
		return leaveBalanceDtoList;
	}
	

    @Override
    public List<TeamLeaveOnCalenderDTO> getTeamLeaveOnCalender(String employeeId ,String currentDate) {
	// TODO Auto-generated method stub
	List<Object[]> teamLeaveOnCalenderObjectList=leaveEntryRepository.getTeamLeaveOnCalender(employeeId,currentDate);
	List<TeamLeaveOnCalenderDTO> leaveBalanceDtoList = leaveEntryAdaptor.teamLeaveOnCalenderObjToUiDto(teamLeaveOnCalenderObjectList);
	System.out.println("===size of list===="+leaveBalanceDtoList.size());
	
	return leaveBalanceDtoList;
}
	
}
