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
import com.csipl.hrms.model.candidate.CandidateProfessionalInformation;

public class CandidateProfessionalInformationAdaptor implements Adaptor<CandidateProfessionalInformationDTO, CandidateProfessionalInformation> {
	private static final Logger logger = LoggerFactory.getLogger(CandidateProfessionalInformationAdaptor.class);
	@Override
	public List<CandidateProfessionalInformationDTO> databaseModelToUiDtoList(
			List<CandidateProfessionalInformation> candidateProfessionalInformationList) {
		// SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		List<CandidateProfessionalInformationDTO> candidateProfessionalInformationDtoList = new ArrayList<CandidateProfessionalInformationDTO>();
		for (CandidateProfessionalInformation candidateProfessionalInformation : candidateProfessionalInformationList) {
			CandidateProfessionalInformationDTO candidateProfessionalInformationDto = new CandidateProfessionalInformationDTO();
			candidateProfessionalInformationDto.setCandidateProfessionalInfoId(
					candidateProfessionalInformation.getCandidateProfessionalInformationId());
			candidateProfessionalInformationDto.setCandidateId(candidateProfessionalInformation.getCandidateId());
			candidateProfessionalInformationDto
					.setOrganizationName(candidateProfessionalInformation.getOrganizationName());
			candidateProfessionalInformationDto.setDateFrom(candidateProfessionalInformation.getDateFrom());
			candidateProfessionalInformationDto.setDateTo(candidateProfessionalInformation.getDateTo());
			candidateProfessionalInformationDto.setDesignation(candidateProfessionalInformation.getDesignation());
			candidateProfessionalInformationDto.setReportingTo(candidateProfessionalInformation.getReportingTo());
			candidateProfessionalInformationDto
					.setReportingContact(candidateProfessionalInformation.getReportingContact());
			candidateProfessionalInformationDto.setReasonForChangeValue(
					DropDownCache.getInstance().getDropDownValue(DropDownEnum.ReasonForChange.getDropDownName(),
							candidateProfessionalInformation.getReasonForChange()));
			if (candidateProfessionalInformation.getAnnualSalary() != null) {
				candidateProfessionalInformationDto
						.setAnnualSalary(candidateProfessionalInformation.getAnnualSalary().toString());
			}
			candidateProfessionalInformationDto
					.setReasonForChange(candidateProfessionalInformation.getReasonForChange());
			candidateProfessionalInformationDto.setCompanyId(candidateProfessionalInformation.getCompanyId());
			candidateProfessionalInformationDto.setDocumentName(candidateProfessionalInformation.getDocumentName());
			candidateProfessionalInformationDto
					.setDocumentFileLocation(candidateProfessionalInformation.getProfessionalDoc());
			candidateProfessionalInformationDtoList.add(candidateProfessionalInformationDto);
		}

		return candidateProfessionalInformationDtoList;
	}

	@Override
	public CandidateProfessionalInformationDTO databaseModelToUiDto(CandidateProfessionalInformation dbobj) {
		return null;
	}

	public List<CandidateProfessionalInformation> uiDtoToDatabaseModelList(
			List<CandidateProfessionalInformationDTO> candidateProfessionalInformationDtoList, Long candidateId)
			throws ParseException {
		List<CandidateProfessionalInformation> candidateProfessionalInformationList = new ArrayList<CandidateProfessionalInformation>();
		for (CandidateProfessionalInformationDTO candidateProfInfoDto : candidateProfessionalInformationDtoList) {
			CandidateProfessionalInformation candidateProfInfo = new CandidateProfessionalInformation();
			// System.out.println("candidateProfInfoDto in adaptor :----" +
			// candidateProfInfoDto.toString());
			if (candidateProfInfoDto.getCandidateProfessionalInfoId() != null) {
				candidateProfInfo
						.setCandidateProfessionalInformationId(candidateProfInfoDto.getCandidateProfessionalInfoId());
			}

			candidateProfInfo.setCandidateId(candidateId);

			candidateProfInfo.setOrganizationName(candidateProfInfoDto.getOrganizationName());
			if (candidateProfInfoDto.getDateFrom() != null) {
				// System.out.println("ui date From" + candidateProfInfoDto.getDateFrom());
				candidateProfInfo.setDateFrom(candidateProfInfoDto.getDateFrom());
			}
			if (candidateProfInfoDto.getDateTo() != null) {
				System.out.println("ui date to" + candidateProfInfoDto.getDateTo());
				candidateProfInfo.setDateTo(candidateProfInfoDto.getDateTo());
			}

			candidateProfInfo.setDesignation(candidateProfInfoDto.getDesignation());
			candidateProfInfo.setReportingTo(candidateProfInfoDto.getReportingTo());
			candidateProfInfo.setReportingContact(candidateProfInfoDto.getReportingContact());
			if (candidateProfInfoDto.getAnnualSalary() != null) {
				candidateProfInfo.setAnnualSalary(new BigDecimal(candidateProfInfoDto.getAnnualSalary()));
			}
			candidateProfInfo.setReasonForChange(candidateProfInfoDto.getReasonForChange());
			candidateProfInfo.setCompanyId(candidateProfInfoDto.getCompanyId());
			candidateProfInfo.setUserId(candidateProfInfoDto.getCandidateId());
			candidateProfInfo.setDocumentName(candidateProfInfoDto.getDocumentName());
			candidateProfInfo.setProfessionalDoc(candidateProfInfoDto.getDocumentFileLocation());
			if (candidateProfInfoDto.getCandidateProfessionalInfoId() == null) {
				candidateProfInfo.setDateCreated(new Date());
				candidateProfInfo.setDateUpdate(new Date());
			}
			candidateProfInfo.setUserIdUpdate(candidateProfInfoDto.getCandidateId());
			candidateProfessionalInformationList.add(candidateProfInfo);
		}

		return candidateProfessionalInformationList;
	}

	@Override
	public CandidateProfessionalInformation uiDtoToDatabaseModel(CandidateProfessionalInformationDTO uiobj) {
		return null;
	}

	@Override
	public List<CandidateProfessionalInformation> uiDtoToDatabaseModelList(
			List<CandidateProfessionalInformationDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<CandidateProfessionalInformationDTO> jsonArrayToCandidateProfessionalInfoDto(JSONArray jsonArray) throws JSONException, ParseException {
		Set<Integer> index = new HashSet<>();
		List<CandidateProfessionalInformationDTO> candidateProfessionalInformationDtoList = new ArrayList<CandidateProfessionalInformationDTO>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
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

			if (!(("").equals(jsonObj.getString("annualSalary"))) && jsonObj.getString("annualSalary") != null) {
				BigDecimal annualSalary = new BigDecimal(jsonObj.getString("annualSalary"));
				candidateProfessionalInformationDto.setAnnualSalary(annualSalary.toString());
			}

			if (jsonObj.has("candidateProfessionalInfoId")) {
				candidateProfessionalInformationDto
						.setCandidateProfessionalInfoId(Long.valueOf(jsonObj.optInt("candidateProfessionalInfoId")));
			}
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
