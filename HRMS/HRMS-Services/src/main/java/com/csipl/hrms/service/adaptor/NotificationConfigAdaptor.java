package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.dto.notification.NotificationDTO;
import com.csipl.common.model.Notification;


public class NotificationConfigAdaptor implements Adaptor<NotificationDTO, Notification>{

	@Override
	public List<Notification> uiDtoToDatabaseModelList(List<NotificationDTO> notificationDTOList) {
		List<Notification> notificationList = new ArrayList<Notification>();
		for (NotificationDTO notificationDTO : notificationDTOList) {

			notificationList.add(uiDtoToDatabaseModel(notificationDTO));
		}
		return notificationList;
	}

	@Override
	public List<NotificationDTO> databaseModelToUiDtoList(List<Notification> notificationList) {
		
		List<NotificationDTO> notificationDTOList = new ArrayList<NotificationDTO>();
		for (Notification notification : notificationList) {

			notificationDTOList.add(databaseModelToUiDto(notification));
		}
		return notificationDTOList;
	
	}

	@Override
	public Notification uiDtoToDatabaseModel(NotificationDTO notificationDTO) {
		Notification notification=new Notification();
		
		System.out.println("=======user id upadte======="+notificationDTO.getUpdatedBy());
		notification.setNotificationId(notificationDTO.getNotificationId());
		notification.setNotificationText(notificationDTO.getNotificationText());
		notification.setUserId(notificationDTO.getUserId());
		notification.setUserIdUpdate(notificationDTO.getUpdatedBy());
		notification.setCompanyId(notificationDTO.getCompanyId());
		notification.setNotificationType(notificationDTO.getNotificationType());
		notification.setDateUpdate(new Date());
		if(notification.getNotificationId()==null)
			notification.setDateCreated(new Date());
		else
			notification.setDateCreated(notificationDTO.getCreatedDate());
		notification.setIsMail(notificationDTO.getMail());
		notification.setUi(notificationDTO.getUi());
		notification.setSms(notificationDTO.getSms());
		
	
		return notification;
	}

	@Override
	public NotificationDTO databaseModelToUiDto(Notification notification) {
		
		NotificationDTO notificationDTO=new NotificationDTO();
		notificationDTO.setUserId(notification.getUserId());
		notificationDTO.setCompanyId(notification.getCompanyId());
		notificationDTO.setNotificationText(notification.getNotificationText());
		notificationDTO.setCreatedDate(notification.getDateCreated());
		notificationDTO.setUpdatedBy(notification.getUserIdUpdate());
		if(notification.getIsMail()==1)
			notificationDTO.setMailValue("Yes");
		else
			notificationDTO.setMailValue("No");
		if(notification.getUi()==1)
			notificationDTO.setUiValue("Yes");
		else
			notificationDTO.setUiValue("No");
		if(notification.getSms()==1)
			notificationDTO.setSmsValue("Yes");
		else
			notificationDTO.setSmsValue("No");
		if(notification.getNotificationType().equals("AR"))
			notificationDTO.setNotificationTypeValue("Attendance Regularization");
		if(notification.getNotificationType().equals("LA"))
			notificationDTO.setNotificationTypeValue("Leave Apply");
		notificationDTO.setMail(notification.getIsMail());
		notificationDTO.setSms(notification.getSms());
		notificationDTO.setUi(notification.getUi());
		notificationDTO.setNotificationId(notification.getNotificationId());
		
		notificationDTO.setNotificationType(notification.getNotificationType());
		return notificationDTO;
	}

}
