package com.csipl.hrms.service.common;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.common.model.Notification;
import com.csipl.hrms.service.common.repository.NotificationConfigRepository;

@Service
public class NotificationConfigServiceImpl implements NotificationConfigService {

	
	private static final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	
	@Autowired
	NotificationConfigRepository notificationConfigRepository;
	
	
	@Override
	public Notification save(Notification notification) {
		
		return notificationConfigRepository.save(notification);
	}


	@Override
	public List<Notification> findAllNotificationConfigList(long companyId) {
		
		return notificationConfigRepository.findAllNotification(companyId);
	}

}
