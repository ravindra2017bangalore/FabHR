package com.csipl.hrms.service.payroll.repository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.payroll.Esi;
import com.csipl.hrms.model.payroll.LoanEMI;
import com.csipl.hrms.model.payroll.LoanIssue;


 
public interface LoanIssueRepository extends CrudRepository<LoanIssue, Long> {
	
	
	//String queryForMyLoan="SELECT * FROM LoanEMI le WHERE (le.transactionNo=(SELECT li.transactionNo from LoanIssue li LEFT JOIN Employee e on e.employeeId=li.employeeId where e.employeeCode=?1 ))";
	//String queryForMyLoan=" FROM LoanIssue loanIssue where loanIssue.employee.employeeId=?1";
	
	String findAllLoanIssue = " SELECT loan.employeeId, emp.firstName, emp.lastName , sum(loan.loanAmount),dep.departmentName , des.designationName , emp.employeeCode FROM LoanIssue loan JOIN Employee emp ON emp.employeeId = loan.employeeId and loan.companyId=?1 JOIN Department dep ON dep.departmentId = emp.departmentId JOIN Designation des ON des.designationId = emp.designationId GROUP by loan.employeeId ";

	@Query(value = findAllLoanIssue, nativeQuery = true)
	public List<Object[]> findAllLoanIssue(Long companyId);
	
	@Query(" from LoanIssue loanIssue where loanIssue.emiStartDate <= ?2 and loanIssue.employee.employeeId = ?1 and  activeStatus='AC' ") 
    public List<LoanIssue> getLoanIssueDetails( long employeeId, Date today );
	
	@Query(" from LoanIssue loanIssue where  loanIssue.transactionNo = ?1  ") 
    public LoanIssue getLoanIssue( long transactionNo);
	
	@Query(" from LoanIssue loanIssue where  loanIssue.employee.employeeId = ?1 and  activeStatus='AC' ") 
	public List<LoanIssue>  getLoanIssueDetailsList( long employeeId);
	
	@Query(" from LoanIssue loanIssue where  loanIssue.loanType = ?1 and  activeStatus='AC' ") 
	  public List<LoanIssue>  getLoanTypeIssueDetailsList( String loanType);
	
	@Query(" from LoanIssue loanIssue where  loanIssue.transactionNo=?1  ") 
    public LoanIssue  getLoanEmiDetailsList( long transactionNo);
	
	@Query("from LoanIssue loanIssue where loanIssue.employee.employeeId=?1") 
    public List<LoanIssue>  getMyLoanList( long employeeId);
	
	
	@Query("SELECT SUM(emiAmount) FROM LoanEMI where transactionNo=?1")
	public BigDecimal getTotalEmiAmount( long transactionNo );
	
	String updatePendingAmount = "UPDATE LoanIssue loanIssue SET loanIssue.loanPendingAmount =?1 HERE loanIssue.transactionNo =?2";
	@Query(value = updatePendingAmount ,  nativeQuery = true ) 
	public void setPendingAmount(BigDecimal loanPendingAmount , long transactionNo);
}
