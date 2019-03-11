package com.csipl.hrms.service.adaptor;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.candidate.CandidateProfessionalInformationDTO;
import com.csipl.hrms.model.employee.ProfessionalInformation;

public class EmpProfessionalAdaptor implements Adaptor<CandidateProfessionalInformationDTO, ProfessionalInformation> {
	private static final Logger logger = LoggerFactory.getLogger(EmpProfessionalAdaptor.class);

	@Override
	public List<ProfessionalInformation> uiDtoToDatabaseModelList(
			List<CandidateProfessionalInformationDTO> candidateProfessionalInformationDTOList) {

		List<ProfessionalInformation> professionalInformationList = new ArrayList<ProfessionalInformation>();
		for (CandidateProfessionalInformationDTO candidateProfessionalInformationDto : candidateProfessionalInformationDTOList) {
			ProfessionalInformation professionalInformation = new ProfessionalInformation();

			professionalInformation.setOrganizationName(candidateProfessionalInformationDto.getOrganizationName());
			if (candidateProfessionalInformationDto.getDateFrom() != null) {

				professionalInformation.setDateFrom(candidateProfessionalInformationDto.getDateFrom());
			}
			if (candidateProfessionalInformationDto.getDateTo() != null) {

				professionalInformation.setDateTo(candidateProfessionalInformationDto.getDateTo());
			}
			professionalInformation.setDesignation(candidateProfessionalInformationDto.getDesignation());
			professionalInformation.setReportingTo(candidateProfessionalInformationDto.getReportingTo());
			professionalInformation.setReportingContact(candidateProfessionalInformationDto.getReportingContact());
			if (candidateProfessionalInformationDto.getAnnualSalary() != null) {
				professionalInformation
						.setAnnualSalary(new BigDecimal(candidateProfessionalInformationDto.getAnnualSalary()));
			}
			professionalInformation.setReasonForChange(candidateProfessionalInformationDto.getReasonForChange());
			professionalInformation.setEmployeeId(candidateProfessionalInformationDto.getCandidateId());

			if (candidateProfessionalInformationDto.getCandidateProfessionalInfoId() != null) {
				professionalInformation
						.setHistoryId(candidateProfessionalInformationDto.getCandidateProfessionalInfoId());
				professionalInformation.setDateCreated(candidateProfessionalInformationDto.getDateCreated());
			} else {
				professionalInformation.setDateCreated(new Date());
			}
			professionalInformation.setDocumentName(candidateProfessionalInformationDto.getDocumentName());
			professionalInformation.setProfessionalDoc(candidateProfessionalInformationDto.getDocumentFileLocation());
			professionalInformation.setUserId(candidateProfessionalInformationDto.getUserId());
			professionalInformation.setUserIdUpdate(candidateProfessionalInformationDto.getUserIdUpdate());

			professionalInformation.setDateUpdate(new Date());
			professionalInformationList.add(professionalInformation);
		}
		return professionalInformationList;
	}

	@Override
	public List<CandidateProfessionalInformationDTO> databaseModelToUiDtoList(
			List<ProfessionalInformation> empProfessionalList) {
		List<CandidateProfessionalInformationDTO> professionalInformationDtoList = new ArrayList<CandidateProfessionalInformationDTO>();
		for (ProfessionalInformation professionalInformation : empProfessionalList) {
			professionalInformationDtoList.add(databaseModelToUiDto(professionalInformation));
		}
		return professionalInformationDtoList;
	}

	@Override
	public ProfessionalInformation uiDtoToDatabaseModel(CandidateProfessionalInformationDTO uiobj) {
		return null;
	}

	@Override
	public CandidateProfessionalInformationDTO databaseModelToUiDto(ProfessionalInformation empProfessional) {
		CandidateProfessionalInformationDTO candidateProfessionalInformationDto = new CandidateProfessionalInformationDTO();
		candidateProfessionalInformationDto.setCandidateProfessionalInfoId(empProfessional.getHistoryId());
		candidateProfessionalInformationDto.setCandidateId(empProfessional.getEmployeeId());
		candidateProfessionalInformationDto.setOrganizationName(empProfessional.getOrganizationName());
		candidateProfessionalInformationDto.setDateFrom(empProfessional.getDateFrom());
		candidateProfessionalInformationDto.setDateTo(empProfessional.getDateTo());
		candidateProfessionalInformationDto.setDesignation(empProfessional.getDesignation());
		candidateProfessionalInformationDto.setReportingTo(empProfessional.getReportingTo());
		candidateProfessionalInformationDto.setReportingContact(empProfessional.getReportingContact());
		candidateProfessionalInformationDto.setReasonForChangeValue(DropDownCache.getInstance().getDropDownValue(
				DropDownEnum.ReasonForChange.getDropDownName(), empProfessional.getReasonForChange()));
		
		if (empProfessional.getAnnualSalary() != null) {
			candidateProfessionalInformationDto.setAnnualSalary(empProfessional.getAnnualSalary().toString());
		}
		
		candidateProfessionalInformationDto.setReasonForChange(empProfessional.getReasonForChange());
		candidateProfessionalInformationDto.setUserId(empProfessional.getUserId());
		candidateProfessionalInformationDto.setUserIdUpdate(empProfessional.getUserIdUpdate());
		candidateProfessionalInformationDto.setDateCreated(empProfessional.getDateCreated());
		candidateProfessionalInformationDto.setDateUpdate(empProfessional.getDateUpdate());
		candidateProfessionalInformationDto.setDocumentName(empProfessional.getDocumentName());
		candidateProfessionalInformationDto.setDocumentFileLocation(empProfessional.getProfessionalDoc());
		// candidateProfessionalInformationDto.setCompanyId(empProfessional.getCompanyId());
		return candidateProfessionalInformationDto;
	}

	public List<CandidateProfessionalInformationDTO> jsonArrayToEmployeeProfessionalInfoDto(JSONArray jsonArray)
			throws JSONException, ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Set<Integer> index = new HashSet<>();
		List<CandidateProfessionalInformationDTO> candidateProfessionalInformationDtoList = new ArrayList<CandidateProfessionalInformationDTO>();
		for (int i = 0; i < jsonArray.length(); i++) {
			CandidateProfessionalInformationDTO candidateProfessionalInformationDto = new CandidateProfessionalInformationDTO();
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			candidateProfessionalInformationDto.setOrganizationName((jsonObj.getString("organizationName")));
			candidateProfessionalInformationDto.setDesignation((jsonObj.getString("designation")));
			candidateProfessionalInformationDto.setReasonForChange((jsonObj.getString("reasonForChange")));

			if (jsonObj.getString("dateFrom").contains("T"))
				candidateProfessionalInformationDto.setDateFrom(sdf.parse(jsonObj.getString("dateFrom")));
			else
				candidateProfessionalInformationDto.setDateFrom(dateformat.parse(jsonObj.getString("dateFrom")));

			if (jsonObj.getString("dateTo").contains("T"))
				candidateProfessionalInformationDto.setDateTo(sdf.parse(jsonObj.getString("dateTo")));
			else
				candidateProfessionalInformationDto.setDateTo(dateformat.parse(jsonObj.getString("dateTo")));

			candidateProfessionalInformationDto.setReportingTo((jsonObj.getString("reportingTo")));
			candidateProfessionalInformationDto.setReportingContact((jsonObj.getString("reportingContact")));
			candidateProfessionalInformationDto.setUserId(jsonObj.getLong("userId"));

			candidateProfessionalInformationDto.setCompanyId(jsonObj.getLong("companyId"));
			candidateProfessionalInformationDto.setCandidateId((jsonObj.getLong("employeeId")));
			if (!(("").equals(jsonObj.getString("annualSalary"))) && jsonObj.getString("annualSalary") != null) {
				BigDecimal annualSalary = new BigDecimal(jsonObj.getString("annualSalary"));
				candidateProfessionalInformationDto.setAnnualSalary(annualSalary.toString());
			}

			if (jsonObj.has("candidateProfessionalInfoId")) {
				candidateProfessionalInformationDto
						.setCandidateProfessionalInfoId(Long.valueOf(jsonObj.optInt("candidateProfessionalInfoId")));
				//candidateProfessionalInformationDto.setDateCreated(dateformat.parse(jsonObj.getString("dateCreated")));
			}
			
			//candidateProfessionalInformationDto.setDateUpdate(new Date());
			if (jsonObj.has("documentFile")) {
				String documentName = jsonObj.getString("documentFile");
				logger.info(documentName + "=====");
				candidateProfessionalInformationDto.setDocumentName(documentName);
				candidateProfessionalInformationDto.setDocIndex(i);
			} else if (jsonObj.has("documentFileLocation") && jsonObj.has("documentName")) {

				candidateProfessionalInformationDto
						.setDocumentFileLocation((jsonObj.getString("documentFileLocation")));
				candidateProfessionalInformationDto.setDocumentName(jsonObj.getString("documentName"));

			}
			logger.info("Length of set----   " + Arrays.toString(index.toArray()));
			candidateProfessionalInformationDtoList.add(candidateProfessionalInformationDto);

		}
		return candidateProfessionalInformationDtoList;
	}

}
