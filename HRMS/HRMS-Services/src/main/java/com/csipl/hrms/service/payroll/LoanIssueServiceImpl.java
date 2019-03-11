package com.csipl.hrms.service.payroll;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.model.payroll.LoanIssue;
import com.csipl.hrms.service.payroll.repository.LoanIssueRepository;

@Service("loanIssueService")
public class LoanIssueServiceImpl implements LoanIssueService {
	
	 private final Logger logger = LoggerFactory.getLogger(LoanIssueServiceImpl.class);

	@Autowired
	private LoanIssueRepository loanIssueRepository;

	/**
	 * to get List of Object  from database based on companyId
	 */
	@Override
	public List<Object[]> getAllLoanIssue(Long companyId) {
		return loanIssueRepository.findAllLoanIssue(companyId);
	}

	/**
	 * Method performed save operation , save LoanIssue object into database
	 */
	@Override
	public LoanIssue save(LoanIssue loanIssue) {
		return loanIssueRepository.save(loanIssue);
	}

	/**
	 * Method performed save operation , save List of LoanIssue objects into
	 * database
	 */
	@Override
	public void save(List<LoanIssue> loanIssues) {
		loanIssueRepository.save(loanIssues);
	}

	/**
	 * to get List of LoanIssue from database based on employeeId and currentDate
	 */
	@Override
	public List<LoanIssue> getLoanIssueDetails(long employeeId, String month) {

		DateUtils dateUtils = new DateUtils();
		Date currentDate = dateUtils.getDateForProcessMonth( month ); 
		
		
		

		logger.info("getLoanIssueDetails  date  === "+currentDate);
		
		return loanIssueRepository.getLoanIssueDetails(employeeId, currentDate);
	}

	/**
	 * to get LoanIssue from database based on transactionNo
	 */
	@Override
	public LoanIssue getLoanIssue(long transactionNo) {
		return loanIssueRepository.findOne(transactionNo);
	}

	/**
	 * to get List of LoanIssue from database based on employeeId
	 */
	@Override
	public List<LoanIssue> getLoanIssueDetailsList(long employeeId) {
		return loanIssueRepository.getLoanIssueDetailsList(employeeId);
	}

	/**
	 * to get List of LoanIssue from database based on loanType
	 */
	@Override
	public List<LoanIssue> getLoanTypeIssueDetailsList(String loanType) {

		return loanIssueRepository.getLoanTypeIssueDetailsList(loanType);
	}

	/**
	 * to get List of LoanEMI from database based on transactionNo(Primary Key)
	 */
	@Override
	public LoanIssue getLoanEmiDetailsList(long transactionNo) {
		return loanIssueRepository.getLoanEmiDetailsList(transactionNo);
	}

	/**
	 * to get List of LoanIssue from database based on empolyeeId
	 */
	@Override
	public List<LoanIssue> getMyLoanInfo(long employeeId) {
		return loanIssueRepository.getMyLoanList(employeeId);
	}

	@Override
	public BigDecimal getTotalEmiAmount(long transactionNo) {
		// TODO Auto-generated method stub
		return loanIssueRepository.getTotalEmiAmount(transactionNo);
	}

	@Override
	public void setPendingAmount(BigDecimal totalEmiAmounts , long txNo) {
		// TODO Auto-generated method stub
		loanIssueRepository.setPendingAmount( totalEmiAmounts , txNo);
	}

}
