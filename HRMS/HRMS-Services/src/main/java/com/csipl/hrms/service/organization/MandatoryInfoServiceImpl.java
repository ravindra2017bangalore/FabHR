package com.csipl.hrms.service.organization;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.common.MandatoryInfo;
import com.csipl.hrms.service.organization.repository.MandatoryInfoRepository;

@Transactional
@Service("mandatoryInfoService")
public class MandatoryInfoServiceImpl implements MandatoryInfoService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(MandatoryInfoServiceImpl.class);

	@Autowired
	private MandatoryInfoRepository mandatoryInfoRepository;

	/**
	 * Method performed save operation ,save List of MandatoryInfo Object into Database
 	 */
	@Override
	public void saveAll(List<MandatoryInfo> mandatoryInfoList) {
		mandatoryInfoRepository.save(mandatoryInfoList);
	}
	/**
	 * Method performed fetch operation ,find  List of MandatoryInfo Object from Database based on companyId
 	 */
	@Override
	public List<MandatoryInfo> find(long companyId) {

		return mandatoryInfoRepository.findMandatoryInfo(companyId);
	}
	/**
	 * Method performed fetch operation ,find  List of MandatoryInfo Object from Database based on companyId
	 * after that delete all the record from database based on manInfoId (Primary key)
 	 */
	@Override
	public List<MandatoryInfo> findInfoAndDelete(long companyId) {

		List<MandatoryInfo> mandatoryInfoList = mandatoryInfoRepository.findMandatoryInfo(companyId);
				
		for (MandatoryInfo mandatoryInfo : mandatoryInfoList) {
			Long manInfoId = mandatoryInfo.getMandatoryInfoId();
			mandatoryInfoRepository.delete(manInfoId);
		}
		return null;

	}

}
