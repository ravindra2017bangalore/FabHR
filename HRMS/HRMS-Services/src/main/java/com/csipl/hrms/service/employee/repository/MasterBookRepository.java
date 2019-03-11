package com.csipl.hrms.service.employee.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.employee.MasterBook;

public interface MasterBookRepository extends CrudRepository<MasterBook, Long> {
 

	@Query(" from MasterBook where companyId=?1 And bookCode=?2")
	public MasterBook findMasterBook(Long companyId, String bookCode);

	@Query(" from MasterBook where companyId=?1 And bookCode=?2 And bookType=?3")
	public MasterBook getMasterBook(Long companyId, String bookCode, String bookType);

}
