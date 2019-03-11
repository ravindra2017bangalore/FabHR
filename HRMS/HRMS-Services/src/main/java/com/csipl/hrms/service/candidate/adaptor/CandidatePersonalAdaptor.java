package com.csipl.hrms.service.candidate.adaptor;
import java.util.ArrayList;
import java.util.List;
import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.candidate.CandidateLanguageDTO;
import com.csipl.hrms.dto.candidate.CandidatePersonalDTO;
import com.csipl.hrms.model.candidate.Candidate;
import com.csipl.hrms.model.candidate.CandidateLanguage;
import com.csipl.hrms.model.candidate.CandidatePersonal;
import com.csipl.hrms.model.common.Language;
import com.csipl.hrms.service.adaptor.Adaptor;
import com.csipl.hrms.service.adaptor.AddressAdaptor;



public class CandidatePersonalAdaptor implements Adaptor<CandidatePersonalDTO, CandidatePersonal> {
	AddressAdaptor addressAdaptor = new AddressAdaptor();
	@Override
	public List<CandidatePersonal> uiDtoToDatabaseModelList(List<CandidatePersonalDTO> uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidatePersonalDTO> databaseModelToUiDtoList(List<CandidatePersonal> dbobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CandidatePersonal uiDtoToDatabaseModel(CandidatePersonalDTO candidatePersonalDto) {
		CandidatePersonal candidatePersonal = new CandidatePersonal();
		candidatePersonal.setCandidatePersonalId(candidatePersonalDto.getCandidatePersonalId());
		candidatePersonal.setBloodGroup(candidatePersonalDto.getBloodGroup());
		candidatePersonal.setAnniversaryDate(candidatePersonalDto.getAnniversaryDate());
		candidatePersonal.setGender(candidatePersonalDto.getGender());
		candidatePersonal.setMaritalStatus(candidatePersonalDto.getMaritalStatus());
		candidatePersonal.setReferenceName(candidatePersonalDto.getReferenceName());
		candidatePersonal.setAlternateNumber(candidatePersonalDto.getAlternateNumber());
		candidatePersonal.setDateOfBirth(candidatePersonalDto.getDateOfBirth());
        Candidate candidate = new Candidate();
        candidate.setCandidateId(candidatePersonalDto.getCandidateId());
		candidatePersonal.setCandidate(candidate);
	
		if (candidatePersonalDto.getPermanentAddressDto() != null && candidatePersonalDto.getPermanentAddressDto().getCityId() != null) {
			//addressAdaptor.uiDtoToDatabaseModels(candidatePersonalDto.getPermanentAddressDto());
			candidatePersonal.setCandidateAddress1(addressAdaptor.uiDtoToDatabaseModels(candidatePersonalDto.getPermanentAddressDto()));
			//candidatePersonal.setPermanentAddressId(addressAdaptor.uiDtoToDatabaseModel(candidatePersonalDto.getPermanentAddressDto()));
		}
       
		if (candidatePersonalDto.getPresentAddressDto() != null && candidatePersonalDto.getPresentAddressDto().getCityId() != null) {
			candidatePersonal.setCandidateAddress2(addressAdaptor.uiDtoToDatabaseModels(candidatePersonalDto.getPresentAddressDto()));
		}
		
		if (candidatePersonalDto.getReferenceAddressDto() != null && candidatePersonalDto.getReferenceAddressDto().getCityId() != null
				&& candidatePersonalDto.getReferenceAddressDto().getEmailId() != null) {
			candidatePersonal.setCandidateAddress3(addressAdaptor.uiDtoToDatabaseModels(candidatePersonalDto.getReferenceAddressDto()));
		}
		//System.out.println("candidatePersonal"+candidatePersonal.getReferenceAddressId());
		
		if(candidatePersonalDto.getCandidateLanguageDto()!=null)
		{
			System.out.println("================================in if block======================================"+candidatePersonalDto.getCandidateLanguageDto().size());
			candidatePersonal.setCandidateLanguages(languageDtoListToDatabaseModelList(candidatePersonalDto.getCandidateLanguageDto(),candidatePersonal));
		}
		return candidatePersonal;
	}

	@Override
	public CandidatePersonalDTO databaseModelToUiDto(CandidatePersonal candidatePersonal) {
		CandidatePersonalDTO candidatePersonalDto = new CandidatePersonalDTO();
		System.out.println(candidatePersonal);
	candidatePersonalDto.setCandidatePersonalId(candidatePersonal.getCandidatePersonalId());
	candidatePersonalDto.setCandidateId(candidatePersonal.getCandidate().getCandidateId());
	candidatePersonalDto.setDateOfBirth(candidatePersonal.getDateOfBirth());
	candidatePersonalDto.setAnniversaryDate(candidatePersonal.getAnniversaryDate());
	candidatePersonalDto.setAlternateNumber(candidatePersonal.getAlternateNumber());
	candidatePersonalDto.setBloodGroup(candidatePersonal.getBloodGroup());
	candidatePersonalDto.setGender(candidatePersonal.getGender());
	candidatePersonalDto.setGenderValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Gender.getDropDownName(), candidatePersonal.getGender()));

	candidatePersonalDto.setMaritalStatus(candidatePersonal.getMaritalStatus());
	candidatePersonalDto.setMaritalStatusValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.MaritalStatus.getDropDownName(), candidatePersonal.getMaritalStatus()));
	candidatePersonalDto.setBloodGroupValue(DropDownCache.getInstance().getDropDownValue(DropDownEnum.BloodGroup.getDropDownName(), candidatePersonal.getBloodGroup()));
	
	candidatePersonalDto.setReferenceName(candidatePersonal.getReferenceName());
	if (candidatePersonal.getCandidateAddress1() != null) {
		candidatePersonalDto.setPermanentAddressDto(addressAdaptor.databaseModelToUiDto(candidatePersonal.getCandidateAddress1()));
		candidatePersonalDto.setPermanentAddressValue(candidatePersonal.getCandidateAddress1().getAddressText()+","+candidatePersonal.getCandidateAddress1().getCity().getCityName()+","+candidatePersonal.getCandidateAddress1().getState().getStateName());

	}
	if (candidatePersonal.getCandidateAddress2() != null) {
		candidatePersonalDto.setPresentAddressDto(addressAdaptor.databaseModelToUiDto(candidatePersonal.getCandidateAddress2() ));
		candidatePersonalDto.setPresentAddressValue(candidatePersonal.getCandidateAddress2() .getAddressText()+","+candidatePersonal.getCandidateAddress2() .getCity().getCityName()+","+candidatePersonal.getCandidateAddress2().getState().getStateName());

	}
	if (candidatePersonal.getCandidateAddress3() != null) {
		candidatePersonalDto.setReferenceAddressDto(addressAdaptor.databaseModelToUiDto(candidatePersonal.getCandidateAddress3()));
		candidatePersonalDto.setReferenceAddressValue(candidatePersonal.getCandidateAddress3().getAddressText()+","+candidatePersonal.getCandidateAddress3().getCity().getCityName()+","+candidatePersonal.getCandidateAddress3().getState().getStateName());
	}
	if(candidatePersonal.getCandidateLanguages()!=null)
		candidatePersonalDto.setCandidateLanguageDto(languageModelListToUiDtoList(candidatePersonal.getCandidateLanguages()));
	
		return candidatePersonalDto;
	}

	
	public CandidateLanguage languageDtoToDbModel(CandidateLanguageDTO candidateLanguageDTO,CandidatePersonal candidatePersonal)
	{
		Language language=new Language();
		CandidateLanguage candidateLanguage=new CandidateLanguage();
		candidateLanguage.setCandidateLanguageId(candidateLanguageDTO.getCandidateLanguageId());
		
		candidateLanguage.setCandidatePersonal(candidatePersonal);
		candidateLanguage.setLangRead(candidateLanguageDTO.getLangRead());
		candidateLanguage.setLangSpeak(candidateLanguageDTO.getLangSpeak());
		candidateLanguage.setLangWrite(candidateLanguageDTO.getLangWrite());
		language.setLanguageId(candidateLanguageDTO.getLanguageId());
		candidateLanguage.setLanguage(language);
		return candidateLanguage;
	}
	
	public List<CandidateLanguage> languageDtoListToDatabaseModelList(List<CandidateLanguageDTO> candidateLanguageDTOList,CandidatePersonal candidatePersonal) {
		
		List<CandidateLanguage> candidateLanguageList=new ArrayList<CandidateLanguage>();
		for(CandidateLanguageDTO candidateLanguageDTO:candidateLanguageDTOList)
		{
			candidateLanguageList.add(languageDtoToDbModel(candidateLanguageDTO,candidatePersonal));
		}
		return candidateLanguageList;
	}
	public CandidateLanguageDTO languageModelToUiDto (CandidateLanguage candidateLanguage)
	{
		CandidateLanguageDTO candidateLanguageDTO=new CandidateLanguageDTO();
		candidateLanguageDTO.setCandidateLanguageId(candidateLanguage.getCandidateLanguageId());
		candidateLanguageDTO.setCandidatePersonalId(candidateLanguage.getCandidatePersonal().getCandidatePersonalId());
		candidateLanguageDTO.setLanguageName(candidateLanguage.getLanguage().getName());
		candidateLanguageDTO.setLanguageId(candidateLanguage.getLanguage().getLanguageId());
		candidateLanguageDTO.setLangRead(candidateLanguage.getLangRead());
		candidateLanguageDTO.setLangWrite(candidateLanguage.getLangWrite());
		candidateLanguageDTO.setLangSpeak(candidateLanguage.getLangSpeak());
		
		return candidateLanguageDTO;
	}
	public List<CandidateLanguageDTO> languageModelListToUiDtoList(List<CandidateLanguage> candidateLanguageList) {
		
		List<CandidateLanguageDTO> candidateLanguageDTOList=new ArrayList<CandidateLanguageDTO>();
		for(CandidateLanguage candidateLanguage: candidateLanguageList)
		{
			candidateLanguageDTOList.add(languageModelToUiDto(candidateLanguage));
		}
		
		return candidateLanguageDTOList;
	}
}