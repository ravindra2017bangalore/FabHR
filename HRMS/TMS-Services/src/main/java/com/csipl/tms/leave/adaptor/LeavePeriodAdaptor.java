package com.csipl.tms.leave.adaptor;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.csipl.hrms.common.constant.StatusMessage;
import com.csipl.tms.dto.leave.TMSLeavePeriodDTO;
import com.csipl.tms.model.leave.TMSLeavePeriod;
import com.csipl.tms.model.leave.TMSLeaveRuleMaster;
import com.csipl.tms.model.leave.TMSLeaveRules;
import com.csipl.tms.model.leave.TMSLeaveRulesHd;
import com.csipl.tms.service.Adaptor;
@Component
public class LeavePeriodAdaptor implements  Adaptor<TMSLeavePeriodDTO, TMSLeavePeriod> {
	String month_name1;
	String month_name2;
	@Override
	public List<TMSLeavePeriod> uiDtoToDatabaseModelList(List<TMSLeavePeriodDTO> uiobj) {
		
		return null;
	}

	@Override
	public List<TMSLeavePeriodDTO> databaseModelToUiDtoList(List<TMSLeavePeriod> leavePeriodList) {
	
		List<TMSLeavePeriodDTO> leavePeriodDtoList = new ArrayList<TMSLeavePeriodDTO>();
		for (TMSLeavePeriod leavePeriod : leavePeriodList) {
			leavePeriodDtoList.add(databaseModelToUiDto(leavePeriod));
		}
		return leavePeriodDtoList;
	}

	@Override
	public TMSLeavePeriod uiDtoToDatabaseModel(TMSLeavePeriodDTO leavePeriodDTO) {
		TMSLeavePeriod leavePeriod=new TMSLeavePeriod();
		leavePeriod.setLeavePeriodId(leavePeriodDTO.getLeavePeriodId());
		
//		leavePeriod.setDateCreated(leavePeriodDTO.getDateCreated());

		if (leavePeriodDTO.getLeavePeriodId() != null) {
			leavePeriod.setLeavePeriodId(leavePeriodDTO.getLeavePeriodId());
			leavePeriod.setDateCreated(leavePeriodDTO.getDateCreated());
		} else
			leavePeriod.setDateCreated(new Date());
		
		
		leavePeriod.setActiveStatus(leavePeriodDTO.getActiveStatus());

		leavePeriod.setDateUpdate(leavePeriodDTO.getDateUpdate());

		leavePeriod.setUserId(leavePeriodDTO.getUserId());
		
		leavePeriod.setUserIdUpdate(leavePeriodDTO.getUserIdUpdate());
		leavePeriod.setCompanyId(leavePeriodDTO.getCompanyId());
		
		leavePeriod.setEndDate(leavePeriodDTO.getEndDate());

		leavePeriod.setStartDate(leavePeriodDTO.getStartDate());
		
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        
        Date date=leavePeriodDTO.getStartDate();
      // String actualDate = dateFormat.format(leavePeriodDTO.getStartDate());
         
       System.out.println(date);
        SimpleDateFormat month_date = new SimpleDateFormat("MMMyyyy", Locale.ENGLISH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		
			month_name1 = month_date.format(date);
		

        
            System.out.println("Month :" + month_name1);
        
        
	    //   String actualDate1 = dateFormat.format(leavePeriodDTO.getEndDate());
	        Date date1=leavePeriodDTO.getEndDate();
	        System.out.println(date1);

				//date1 = sdf.parse(actualDate1);
		     month_name2 = month_date.format(date1);

	        System.out.println("Month :" + month_name2);
	        
			String leavePName= month_name1 +"-"+ month_name2;
		
		leavePeriod.setLeavePeriodName(leavePName);
		return leavePeriod;
	}

	@Override
	public TMSLeavePeriodDTO databaseModelToUiDto(TMSLeavePeriod leavePeriod) {
		TMSLeavePeriodDTO leavePeriodDTO=new TMSLeavePeriodDTO();
		
		leavePeriodDTO.setLeavePeriodId(leavePeriod.getLeavePeriodId());
		leavePeriodDTO.setDateCreated(leavePeriod.getDateCreated());
		leavePeriodDTO.setDateUpdate(leavePeriod.getDateUpdate());
		leavePeriodDTO.setActiveStatus(leavePeriod.getActiveStatus());
		leavePeriodDTO.setEndDate(leavePeriod.getEndDate());
		leavePeriodDTO.setStartDate(leavePeriod.getStartDate());
		leavePeriodDTO.setLeavePeriodName(leavePeriod.getLeavePeriodName());
		leavePeriodDTO.setUserId(leavePeriod.getUserId());
		leavePeriodDTO.setUserIdUpdate(leavePeriod.getUserIdUpdate());
		leavePeriodDTO.setCompanyId(leavePeriod.getCompanyId());

		
		
		return leavePeriodDTO;
	}

	
 
	public  TMSLeaveRules  tMSLeaveRuleMasterToTMSLeaveRule( TMSLeaveRuleMaster  tMSLeaveRuleMaster,TMSLeaveRulesHd tMSLeaveRulesHd) {
		TMSLeaveRules tMSLeaveRules = new TMSLeaveRules();
		tMSLeaveRules.setActiveStatus(StatusMessage.DEACTIVE_CODE);

	//	tMSLeaveRules.setRuleName(tMSLeaveRuleMaster.getRuleName());
	//	tMSLeaveRules.setRuleCode(tMSLeaveRuleMaster.getRuleCode());

		tMSLeaveRules.setDateCreated(new Date());
		tMSLeaveRules.setDateUpdate(new Date());
		//TMSLeaveRulesHd tMSleaveRulesHd=new TMSLeaveRulesHd();
		tMSLeaveRules.setTmsleaveRuleMaster(tMSLeaveRuleMaster);
		
		tMSLeaveRules.setTmsleaveRulesHd(tMSLeaveRulesHd);
	 
		return tMSLeaveRules;
	}

	
	
}
