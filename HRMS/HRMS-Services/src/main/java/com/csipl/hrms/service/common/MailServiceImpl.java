package com.csipl.hrms.service.common;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.common.model.Mail;



import com.csipl.hrms.service.common.repository.MailRepository;

@Service("mailService")
public class MailServiceImpl implements MailService {
	
	   private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Autowired
	MailRepository mailRepository;

	@Override
	public Mail getEmailDetail(String functionName, long companyId) {
		
		return mailRepository.findAllMails(functionName, companyId );
	}
	
	@Override
	public  List<Mail> getEmailDetailForSchedular(String functionName) {
		
		logger.info(" functionName  "+ functionName );
		return mailRepository.getEmailDetailForSchedular(functionName);
	}

	@Override
	public Mail save(Mail mail) {
		
		return mailRepository.save(mail);
	}

	@Override
	public List<Mail> findAllMailConfigList(long companyId) {
		
		return mailRepository.findAllMailConfigList(companyId);
	}

	@Override
	public void delete(Long mailId) {
		
		mailRepository.delete(mailId);
	}
	

	
	
}
