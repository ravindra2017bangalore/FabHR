package com.csipl.tms.deviceinfo.adaptor;

import java.util.List;

import com.csipl.tms.dto.deviceinfo.DeviceInfoDTO;
import com.csipl.tms.model.deviceinfo.DeviceInfo;
import com.csipl.tms.service.Adaptor;

public class DeviceInfoAdaptor implements Adaptor<DeviceInfoDTO, DeviceInfo> {

	String prefix;
	Long companyId;
	String deviceNames;
	String deviceIds;

	@Override
	public List<DeviceInfo> uiDtoToDatabaseModelList(List<DeviceInfoDTO> uiobj) {
		return null;
	}

	@Override
	public List<DeviceInfoDTO> databaseModelToUiDtoList(List<DeviceInfo> dbobj) {
		return null;
	}

	@Override
	public DeviceInfo uiDtoToDatabaseModel(DeviceInfoDTO uiobj) {
		return null;
	}

	@Override
	public DeviceInfoDTO databaseModelToUiDto(DeviceInfo dbobj) {
		return null;
	}

	public Object[] getDeviceInfo(List<DeviceInfo> deviceInfoList) {
		Object object[] = new Object[3];
		StringBuffer deviceNameSb = new StringBuffer();
		StringBuffer deviceIdSb = new StringBuffer();
		for (DeviceInfo deviceInfo : deviceInfoList) {
			prefix = deviceInfo.getPrefix();
			companyId = deviceInfo.getCompanyId();
			String deviceName = deviceInfo.getDeviceName();
			deviceNameSb.append("'").append(deviceName).append("'").append(",");
			/*Long deviceId = deviceInfo.getDeviceId();
			deviceIdSb.append(deviceId).append(",");*/
		}
		deviceNames = deviceNameSb.substring(0, deviceNameSb.length() - 1).toString();
		//deviceIds = deviceIdSb.substring(0, deviceIdSb.length() - 1).toString();
		object[0] = prefix;
		object[1] = companyId;
		object[2] = deviceNames;
		//object[3] = deviceIds;
		return object;
	}

}
