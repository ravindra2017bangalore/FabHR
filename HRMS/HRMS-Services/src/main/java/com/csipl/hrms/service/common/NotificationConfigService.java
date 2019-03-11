package com.csipl.hrms.service.common;
import java.util.List;
import com.csipl.common.model.Notification;

public interface NotificationConfigService {
	public Notification save(Notification notification);
	public List<Notification> findAllNotificationConfigList(long companyId);
}
