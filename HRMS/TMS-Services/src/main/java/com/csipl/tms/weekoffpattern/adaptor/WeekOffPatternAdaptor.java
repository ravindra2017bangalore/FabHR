package com.csipl.tms.weekoffpattern.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.csipl.tms.dto.weekofpattern.WeekOffPatternDTO;
import com.csipl.tms.model.weekofpattern.WeekOffPattern;
import com.csipl.tms.service.Adaptor;

public class WeekOffPatternAdaptor implements Adaptor<WeekOffPatternDTO, WeekOffPattern> {

	@Override
	public List<WeekOffPattern> uiDtoToDatabaseModelList(List<WeekOffPatternDTO> uiobj) {
		return null;
	}
	

	@Override
	public List<WeekOffPatternDTO> databaseModelToUiDtoList(List<WeekOffPattern> week_Off_PatternList) {

		List<WeekOffPatternDTO> week_Off_PatternDTOList = new ArrayList<WeekOffPatternDTO>();

		week_Off_PatternList.forEach(week_Off_Pattern -> {
			week_Off_PatternDTOList.add(databaseModelToUiDto(week_Off_Pattern));
		});
		return week_Off_PatternDTOList;

	}

	@Override
	public WeekOffPattern uiDtoToDatabaseModel(WeekOffPatternDTO week_Off_PatternDTO) {
		WeekOffPattern week_Off_Pattern = new WeekOffPattern();
		StringBuilder sb = new StringBuilder();
		for (String day : week_Off_PatternDTO.getDays()) {
			sb.append(day).append(",");
		}

		week_Off_Pattern.setDay(sb.substring(0, sb.length() - 1).toString());
		week_Off_Pattern.setPatternName(week_Off_PatternDTO.getPatternName());
		/*Company company = new Company();
		company.setCompanyId(week_Off_PatternDTO.getCompanyId());*/
		week_Off_Pattern.setCompanyId(week_Off_PatternDTO.getCompanyId());
		week_Off_Pattern.setUserId(week_Off_PatternDTO.getUserId());
		week_Off_Pattern.setActiveStatus(week_Off_PatternDTO.getActiveStatus());
		week_Off_Pattern.setUpdateUserId(week_Off_PatternDTO.getUpdateUserId());
		if (week_Off_PatternDTO.getPatternId() != null) {
			week_Off_Pattern.setPatternId(week_Off_PatternDTO.getPatternId());
			week_Off_Pattern.setCreatedDate(week_Off_PatternDTO.getCreatedDate());
		} else {
			week_Off_Pattern.setCreatedDate(new Date());
		}
		week_Off_Pattern.setUpdatedDate(new Date());
		return week_Off_Pattern;
	}

	@Override
	public WeekOffPatternDTO databaseModelToUiDto(WeekOffPattern week_Off_Pattern) {

		WeekOffPatternDTO week_Off_PatterDto = new WeekOffPatternDTO();
		week_Off_PatterDto.setPatternId(week_Off_Pattern.getPatternId());
		week_Off_PatterDto.setPatternName(week_Off_Pattern.getPatternName());
		String day = week_Off_Pattern.getDay();
		String[] days = day.split(",");
		week_Off_PatterDto.setDays(days);
		week_Off_PatterDto.setUserId(week_Off_Pattern.getUserId());
		week_Off_PatterDto.setCreatedDate(week_Off_Pattern.getCreatedDate());
		week_Off_PatterDto.setCompanyId(week_Off_Pattern.getCompanyId());
		week_Off_PatterDto.setActiveStatus(week_Off_Pattern.getActiveStatus());
		return week_Off_PatterDto;
	}
	
	public String[] databaseModeObjlToUiDto(String week_Off_Pattern) {
		String[] days = week_Off_Pattern.split(",");
		return days;
	}

}
