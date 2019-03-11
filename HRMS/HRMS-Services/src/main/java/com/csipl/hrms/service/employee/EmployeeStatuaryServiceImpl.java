package com.csipl.hrms.service.employee;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.common.MandatoryInfoCheck;
import com.csipl.hrms.model.employee.EmployeeStatuary;
import com.csipl.hrms.service.employee.repository.EmployeeStatuaryRepository;
import com.csipl.hrms.service.organization.repository.MandatoryInfoCheckRepository;

@Transactional
@Service("employeeStatuaryService")
public class EmployeeStatuaryServiceImpl implements EmployeeStatuaryService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeStatuaryServiceImpl.class);

	@Autowired
	private EmployeeStatuaryRepository employeeStatuaryRepository;

	@Autowired
	MandatoryInfoCheckRepository mandatoryInfoCheckRepository;

	/**
	 * Method performed save OR update operation
	 */
	@Override
	public List<EmployeeStatuary> save(List<EmployeeStatuary> employeeStatuaryList, Long employeeId) {
		logger.info("EmployeeStatuaryList is ===== " + employeeId);
		List<EmployeeStatuary> employeeStatuaryInfos = (List<EmployeeStatuary>) employeeStatuaryRepository
				.save(employeeStatuaryList);
		for (EmployeeStatuary employeeStatuary : employeeStatuaryInfos) {
			System.out.println(employeeStatuary.getDateFrom());
		}
		MandatoryInfoCheck mandatoryInfoCheck = new MandatoryInfoCheck();
		mandatoryInfoCheck = mandatoryInfoCheckRepository.getMandatoryInfoCheck(employeeId);
		logger.info("mandatoryInfoCheck : " + mandatoryInfoCheck.getUserId());

		if (mandatoryInfoCheck.getUserId() == null && mandatoryInfoCheck.getDateCreated() == null) {

			mandatoryInfoCheck.setUserId(mandatoryInfoCheck.getUserId());
			mandatoryInfoCheck.setDateCreated(mandatoryInfoCheck.getDateCreated());
		}
		mandatoryInfoCheck.setDateUpdate(new Date());
		mandatoryInfoCheck.setUserIdUpdate(mandatoryInfoCheck.getUserId());
		for (EmployeeStatuary employeeStatuary : employeeStatuaryList) {
			// employeeStatuaryList.forEach(employeeStatuary -> {
			logger.info("employeeStatuary.getStatuaryType()" + employeeStatuary.getStatuaryType());

			if (("ES").equals(employeeStatuary.getStatuaryType()))
				mandatoryInfoCheck.setEs("YES");

			if (employeeStatuary.getStatuaryType().equals("ME")) {
				mandatoryInfoCheck.setMi("YES");
				mandatoryInfoCheck.setNm("YES");
			}

			if (employeeStatuary.getStatuaryType().equals("AC")) {
				mandatoryInfoCheck.setAi("YES");
				mandatoryInfoCheck.setNa("YES");
			}

			if (employeeStatuary.getStatuaryType().equals("UA")) {
				mandatoryInfoCheck.setUa("YES");
				mandatoryInfoCheck.setNu("YES");
			}

			if (employeeStatuary.getStatuaryType().equals("PF"))
				mandatoryInfoCheck.setPF("YES");

		}
		logger.info("mandatoryInfoCheck.getPF()" + mandatoryInfoCheck.getPF());
		mandatoryInfoCheckRepository.save(mandatoryInfoCheck);

		return employeeStatuaryInfos;
	}

	/**
	 * to get List of EmployeeStatuary from database based on employeeId
	 */
	@Override
	public List<EmployeeStatuary> findAllEmployeeStatuary(Long employeeId) {
		logger.info("findAllEmployeeStatuary is ===== " + employeeId);
		List<EmployeeStatuary> empStaturyList = employeeStatuaryRepository.findAllEmployeeStatuarys(employeeId);
		System.out.println("empStaturyList....");
		for (EmployeeStatuary employeeStatuary : empStaturyList) {
			System.out.println(employeeStatuary.getDateFrom());
		}
		return empStaturyList;
	}

	/**
	 * delete EmployeeStatuary object from database based on staturyId (Primary Key)
	 */
	@Override
	public void delete(Long statuaryId) {
		employeeStatuaryRepository.delete(statuaryId);
	}
}
