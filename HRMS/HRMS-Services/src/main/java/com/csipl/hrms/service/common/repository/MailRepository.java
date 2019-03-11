package com.csipl.hrms.service.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.common.model.Mail;




public interface MailRepository  extends CrudRepository<Mail,Long >{
	@Query(" from Mail where functionName=?1 and companyId=?2 ") 
 	public Mail findAllMails(String functionName, long companyId );
	
	@Query(" from Mail where functionName=?1") 
 	public List<Mail> getEmailDetailForSchedular(String functionName);
	
	@Query(" from Mail where  companyId=?1 ") 
 	public List<Mail> findAllMailConfigList( long companyId );
	
	@Query(" from Mail where  companyId=?1 and title=?2 ") 
 	public List<Mail> findAllMailConfigList( String title,long companyId );
}
