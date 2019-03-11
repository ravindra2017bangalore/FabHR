package com.csipl.tms.deviceinfo.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.tms.deviceinfo.repository.DeviceInfoRepository;
import com.csipl.tms.model.deviceinfo.DeviceInfo;

@Transactional
@Service("deviceInfoService")
public class DeviceInfoServiceImpl implements DeviceInfoService {

	@Autowired
	DeviceInfoRepository deviceInfoRepository;

	@Override
	public List<DeviceInfo> findDeviceInfo(Long companyId) {

		return deviceInfoRepository.findAllDeviceInfo(companyId);

	}

}
