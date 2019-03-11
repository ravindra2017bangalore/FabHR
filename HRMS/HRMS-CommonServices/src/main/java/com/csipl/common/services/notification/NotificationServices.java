package com.csipl.common.services.notification;


import java.util.List;

import com.csipl.common.dto.notification.NotificationDTO;
import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.model.Notification;



public interface NotificationServices {
	
	
	public List<Notification> notificationListByCommunicationType( long companyId, String communicationType);
	
	public List<Notification> notificationListByCompanyId( long companyId);
	
	public Notification addNotification(Notification notification);
	
	public Notification getNotification(long notificationId);
	
	public String  sendNotification(NotificationDTO notificationDTO);
	
	public String  sendNotification(NotificationMailSmsDto notificationDTO);
	
	public void  sendMail(Notification notification);

	public String  sendNotification(long notificationId);
	
	
}
