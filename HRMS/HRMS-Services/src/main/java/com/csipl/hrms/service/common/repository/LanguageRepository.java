package com.csipl.hrms.service.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

 import com.csipl.hrms.model.common.Language;




public interface LanguageRepository  extends CrudRepository<Language,Long >{
 	@Query(" from Language where  companyId=?1 ") 
 	public List<Language> getAllLanguages( long companyId );
	
 
}
