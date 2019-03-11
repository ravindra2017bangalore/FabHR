package com.csipl.tms.deviceinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.tms.model.deviceinfo.DeviceInfo;

public interface DeviceInfoRepository extends CrudRepository<DeviceInfo, Long>{

	@Query("from DeviceInfo where companyId=?1")
	List<DeviceInfo> findAllDeviceInfo(long companyId);

}
