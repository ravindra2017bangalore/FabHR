package com.csipl.tms.deviceinfo.service;

import java.util.List;

import com.csipl.tms.model.deviceinfo.DeviceInfo;

public interface DeviceInfoService {

	public List<DeviceInfo> findDeviceInfo(Long companyId);

}
