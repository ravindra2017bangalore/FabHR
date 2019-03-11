package com.csipl.hrms.service.adaptor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.csipl.common.model.Mail;
import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.common.MailDTO;
import com.csipl.hrms.model.common.Company;


public class MailConfigAdaptor implements Adaptor<MailDTO,Mail> {

	@Override
	public List uiDtoToDatabaseModelList(List uiobj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MailDTO> databaseModelToUiDtoList(List<Mail> mailList) {
		List<MailDTO> mailDTOList =new ArrayList<MailDTO>();
		for (Mail mail : mailList) {
			mailDTOList.add(databaseModelToUiDto(mail));
		}
  		return mailDTOList;
	}

	@Override
	public Mail uiDtoToDatabaseModel(MailDTO mailDTO) {
		
		Mail mail=new Mail();
		mail.setMailId(mailDTO.getMailId());
		mail.setBcc(mailDTO.getBcc());
		mail.setCc(mailDTO.getCc());
		mail.setTitle(mailDTO.getTitle());
		mail.setFunctionName(mailDTO.getTitle());
		mail.setSubject(mailDTO.getSubject());
		mail.setFromMail(mailDTO.getFromMail());
		mail.setToMail(mailDTO.getToMail());
		mail.setMailBody(mailDTO.getMailBody());
		mail.setHeaderBody(mailDTO.getHeaderBody());
		mail.setFooterBody(mailDTO.getFooterBody());
		mail.setTitle(mailDTO.getTitle());
		mail.setCompanyId(mailDTO.getCompanyId());
		mail.setUserId(mailDTO.getUserId());
		if(mailDTO.getDateCreated()==null)
			mail.setDateCreated(new java.util.Date()); 
		else
			mail.setDateCreated(mailDTO.getDateCreated());
        mail.setDateUpdate(new java.util.Date());	
        mail.setUserIdUpdate(mailDTO.getUserIdUpdate());
		return mail;
	}

	@Override
	public MailDTO databaseModelToUiDto(Mail mail) {
		MailDTO mailDTO=new MailDTO();
		mailDTO.setMailId(mail.getMailId());
		mailDTO.setToMail(mail.getToMail());
		mailDTO.setUserId(mail.getUserId());
		mailDTO.setToMail(mail.getToMail());
		mailDTO.setTitle(mail.getTitle());
		mailDTO.setFromMail(mail.getFromMail());
		mailDTO.setCc(mail.getCc());
		mailDTO.setBcc(mail.getBcc());
		mailDTO.setSubject(mail.getSubject());
		mailDTO.setMailBody(mail.getMailBody());
		mailDTO.setHeaderBody(mail.getHeaderBody());
		mailDTO.setFooterBody(mail.getFooterBody());
		mailDTO.setTitleName(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Title.getDropDownName(),mail.getTitle()));
  		return mailDTO;	}

}
