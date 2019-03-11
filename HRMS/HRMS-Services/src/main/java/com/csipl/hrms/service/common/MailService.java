package com.csipl.hrms.service.common;

import java.util.List;

import com.csipl.common.model.Mail;


public interface MailService {
	Mail getEmailDetail(String functionName, long companyId);
	public  List<Mail> getEmailDetailForSchedular(String functionName);
	public Mail save(Mail mail);
	public List<Mail> findAllMailConfigList(long companyId);
	public void delete(Long mailId);
	
}

