package com.csipl.common.services.notification.repository;

import org.springframework.data.repository.CrudRepository;

import com.csipl.common.model.Notification;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

public interface NotificationRepository extends CrudRepository<Notification, Long>{
	
	@Query(" from Notification where companyId =?1 and communicationType=?2 ORDER BY  notificationId  DESC ")
    public List<Notification> notificationListByCommunicationType(Long companyId,String communicationType);
	
	@Query(" from Notification where notificationId =?1 ")
	public Notification getNotification(Long notificationId);
	
	
	@Query(" from Notification where notificationType =?1 ")
	public Notification getNotification(String notificationType);
	//@Query(" from Notification where notificationId =?1 ")
	//public Notification sendNotification(Long notificationId);
	
	
	
	


}
