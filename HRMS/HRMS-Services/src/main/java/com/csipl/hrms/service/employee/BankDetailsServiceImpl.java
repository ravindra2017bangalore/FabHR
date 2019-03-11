package com.csipl.hrms.service.employee;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csipl.hrms.model.common.MandatoryInfoCheck;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.service.employee.repository.BankDetailsRepository;
import com.csipl.hrms.service.organization.repository.MandatoryInfoCheckRepository;

@Transactional
@Service("bankDetailsService")
public class BankDetailsServiceImpl implements BankDetailsService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(BankDetailsServiceImpl.class);

	@Autowired
	private BankDetailsRepository bankDetailsRepository;

	@Autowired
	MandatoryInfoCheckRepository mandatoryInfoCheckRepository;

	/**
	 * Save OR update EmployeeBank object into Database
	 */
	// @Override
	public EmployeeBank save(EmployeeBank employeeBank) {
		logger.info(" EmployeeBank save mandatoryInfoCheck employee id :" + employeeBank.getEmployee().getEmployeeId());

		MandatoryInfoCheck mandatoryInfoCheck = new MandatoryInfoCheck();
		mandatoryInfoCheck = mandatoryInfoCheckRepository
				.getMandatoryInfoCheck(employeeBank.getEmployee().getEmployeeId());
		logger.info(" mandatoryInfoCheck is : " + mandatoryInfoCheck);

		// if first time
		if (mandatoryInfoCheck.getUserId() != null && mandatoryInfoCheck.getDateCreated() != null) {
			mandatoryInfoCheck.setUserId(mandatoryInfoCheck.getUserId());
			mandatoryInfoCheck.setDateCreated(mandatoryInfoCheck.getDateCreated());
		}
		mandatoryInfoCheck.setBa("YES");
		mandatoryInfoCheck.setDateUpdate(new Date());
		mandatoryInfoCheck.setUserIdUpdate(mandatoryInfoCheck.getUserId());
		mandatoryInfoCheckRepository.save(mandatoryInfoCheck);
		logger.info("saveBankDetails is end  :" + "mandatoryInfoCheck" + mandatoryInfoCheck);
		return bankDetailsRepository.save(employeeBank);
	}

	// @Override
	public EmployeeBank update(EmployeeBank employeeBank) {
		return null;
	}

	/**
	 * To get List of EmployeeBanks from Database based on employeeId
	 */
	@Override
	public List<EmployeeBank> findAllBankDetails(String empId) {
		Long employeeId = Long.parseLong(empId);
		return bankDetailsRepository.findAllBankDetails(employeeId);

	}

	/**
	 * delete Employee bank from database based on bankId (primary key)
	 */
	@Override
	public void delete(Long empBankId) {
		bankDetailsRepository.delete(empBankId);
	}

	/**
	 * Save OR update List of EmployeeBank object into Database
	 */
	@Override
	public List<EmployeeBank> saveAll(List<EmployeeBank> employeeBankList) {
		logger.info("employeeBankList is ===== " + employeeBankList);
		MandatoryInfoCheck mandatoryInfoCheck = new MandatoryInfoCheck();
		logger.info(" mandatoryInfoCheck is : " + mandatoryInfoCheck);
		Long empId = 0l;
		Long userIdUpdate = 0l;
		boolean flag = false;
		for (EmployeeBank employeeBank : employeeBankList) {
			empId = employeeBank.getEmployee().getEmployeeId();
			userIdUpdate = employeeBank.getUserIdUpdate();
			if (employeeBank.getAccountType().equals("SL") || employeeBank.getAccountType().equals("SA")) {
				flag = true;
				logger.info("flag for mandatoryInfoCheck is  : " + flag);
				break;
			}
		}
		if (flag) {
			mandatoryInfoCheck = mandatoryInfoCheckRepository.getMandatoryInfoCheck(empId);
			if (mandatoryInfoCheck!=null && mandatoryInfoCheck.getUserId() != null && mandatoryInfoCheck.getDateCreated() != null) {
				mandatoryInfoCheck.setUserId(mandatoryInfoCheck.getUserId());
				mandatoryInfoCheck.setDateCreated(mandatoryInfoCheck.getDateCreated());
			}
			mandatoryInfoCheck.setBa("YES");
			mandatoryInfoCheck.setDateUpdate(new Date());
			mandatoryInfoCheck.setUserIdUpdate(userIdUpdate);
			mandatoryInfoCheckRepository.save(mandatoryInfoCheck);

		} else {
			mandatoryInfoCheck = mandatoryInfoCheckRepository.getMandatoryInfoCheck(empId);
			if (mandatoryInfoCheck!=null && mandatoryInfoCheck.getUserId() != null && mandatoryInfoCheck.getDateCreated() != null) {
				mandatoryInfoCheck.setUserId(mandatoryInfoCheck.getUserId());
				mandatoryInfoCheck.setDateCreated(mandatoryInfoCheck.getDateCreated());
			}
			mandatoryInfoCheck.setBa("");
			mandatoryInfoCheck.setDateUpdate(new Date());
			mandatoryInfoCheck.setUserIdUpdate(userIdUpdate);
			mandatoryInfoCheckRepository.save(mandatoryInfoCheck);
		}
		List<EmployeeBank> employeeBankList1 = (List<EmployeeBank>) bankDetailsRepository.save(employeeBankList);
		return employeeBankList1;
	}

	@Override
	public EmployeeBank findBankDetails(Long employeeId) {
		List<EmployeeBank> bankList = bankDetailsRepository.findBankDetails(employeeId);
		for (EmployeeBank employeeBank : bankList) {
			return employeeBank;	
		}
		return null;
	}

}
