package com.csipl.hrms.service.organization;

import java.util.List;

 import com.csipl.hrms.model.common.MandatoryInfo;



public interface MandatoryInfoService {
 	public void saveAll(List<MandatoryInfo> mandatoryInfoList);
 	
 	public List<MandatoryInfo> find( long companyId);
 	
 	public List<MandatoryInfo>findInfoAndDelete(long companyId);
 	
 
}
