package com.csipl.hrms.service.common.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csipl.common.model.Notification;
import com.csipl.hrms.model.organisation.Designation;

@Repository
public interface NotificationConfigRepository extends CrudRepository<Notification, Long> {
	
	@Query("from Notification where companyId=?1 ") 
 	public List<Notification> findAllNotification(Long companyId);
	
	
}
