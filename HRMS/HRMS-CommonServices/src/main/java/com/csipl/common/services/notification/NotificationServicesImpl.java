package com.csipl.common.services.notification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.csipl.common.dto.notification.NotificationDTO;
import com.csipl.common.dto.notification.NotificationMailSmsDto;
import com.csipl.common.message.utils.Message;
import com.csipl.common.message.utils.SendMail;
import com.csipl.common.message.utils.SmsService;
import com.csipl.common.model.Notification;
import com.csipl.common.services.notification.repository.NotificationRepository;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("notificationServices")
public class NotificationServicesImpl implements NotificationServices {

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;


	@Autowired
	SmsService smsService;

	@Override
	public List<Notification> notificationListByCommunicationType(long companyId, String communicationType) {

		return notificationRepository.notificationListByCommunicationType(companyId, communicationType);

	}

	@Override
	public List<Notification> notificationListByCompanyId(long companyId) {
		return null;
	}

	@Override
	public Notification addNotification(Notification notification) {

		return notificationRepository.save(notification);

	}

	@Override
	public Notification getNotification(long notificationId) {

		return notificationRepository.getNotification(notificationId);

	}

	@Override
	public String sendNotification(NotificationDTO notificationDTO) {

		Notification notification = notificationRepository.getNotification(notificationDTO.getNotificationId());

		String notificationText = notification.getNotificationText();

		System.out.println("=====before======" + notificationText);
		/*
		 * 
		 * System.out.println("========before======="+notificationText); for(
		 * Map.Entry<String, String> entry :
		 * notificationDTO.getArrayMap().get(j).entrySet()) {
		 * 
		 * String key = entry.getKey(); String value = entry.getValue();
		 * notificationText=notificationText.replace(key, value);
		 * System.out.println("====key===="+key+"===value==="+value); j++; }
		 * 
		 */
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("notificationDTO.getMessageValues()" + notificationDTO.getMessageValues());
		String[] valueArr = notificationDTO.getMessageValues();
		for (int i = 0; i < notificationDTO.getMessageValues().length; i++) {
			map.put("VAR" + i, valueArr[i]);
		}

		for (Map.Entry<String, String> entry : map.entrySet()) {
			notificationText = notificationText.replace("<" + entry.getKey() + ">", entry.getValue());
		}
		System.out.println("=====after======" + notificationText);
		notification.setNotificationText(notificationText);

		if (notification.getIsMail() > 0) {
			
			
			
			Message msg = new Message(new SendMail());
			msg.executeMessage(notification, mailSender);
		}
		if (notification.getSms() > 0) {
 			smsService.sendNotificationBySms(notification, notificationDTO.getMobileNo());
 		}
		if (notification.getUi() > 0) {
			return notificationText;

		}
		return notificationText;
	}

	@Override
	public String sendNotification(NotificationMailSmsDto notificationDTO) {
		// TODO Auto-generated method stub
		System.out.println("=========================in method============================");
		Notification notification = notificationRepository.getNotification(notificationDTO.getNotificationType());
		notificationDTO.setSubject(notification.getMail().getSubject());
		notificationDTO.setMessage(notification.getNotificationText());
		notificationDTO.setFrom(notification.getMail().getFromMail());
		List<String> to= notificationDTO.getTo();
		to.add(notification.getMail().getToMail());
		notificationDTO.setTo(to);
		List<String> cc=notificationDTO.getCc();
		cc.add(notification.getMail().getCc());
		notificationDTO.setCc(cc);
		
    	if (notification.getIsMail() > 0) {
			 
    		System.out.println("in in block of method");
			
			Message msg = new Message(new SendMail());
			msg.executeMessage(notificationDTO, mailSender,velocityEngine);
		}
		if (notification.getSms() > 0) {
 			smsService.sendNotificationBySms(notification, notificationDTO.getMobileNo());
 		}
		if (notification.getUi() > 0) {
			return notification.getNotificationText();

		}
		return notification.getNotificationText();
	}
	
	
	@Override
	public String sendNotification(long notificationId) {

		Notification notification = notificationRepository.getNotification(notificationId);

		return notification.getNotificationText();
	}

	@Override
	public void sendMail(Notification notification) {
   	   Message msg = new Message(new SendMail());
	   msg.executeMessage(notification, mailSender);

	}

	

}