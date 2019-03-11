package com.csipl.hrms.service.payroll.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.csipl.hrms.model.payroll.TdsTransaction;

public interface TdsTransactionRepository extends CrudRepository<TdsTransaction, Long>{

String queryForTdsTransaction="select td.tdsGroupId,td.tdsSectionId,td.tdsSectionName,td.tdsDescription,tg.tdsGroupName,\r\n" + 
		"tt.investmentAmount,tt.tdsTransactionId,tt.approveStatus, tt.userId, tt.dateCreated, td.maxLimit,tt.employeeId,\r\n"+
		"tt.status, tt.financialYear, tt.city from TdsSection td join TdsGroup tg on tg.tdsGroupId=td.tdsGroupId and\r\n" + 
		"(tg.effectiveEndDate is null or tg.effectiveEndDate>CURRENT_DATE) and\r\n" + 
		"(tg.effectiveStartDate is NOT null and tg.effectiveStartDate<=CURRENT_DATE )\r\n" + 
		"left join TdsTransaction tt on tt.tdsSectionId=td.tdsSectionId  \r\n" + 
		"and tt.employeeId=?1 and tt.financialYear=?2 ORDER by td.tdsSectionName";

String queryForTdsSummary="select ts.tdsGroupId, ts.tdsSectionId, ts.tdsSectionName, ts.tdsDescription, ts.maxLimit, tt.financialYear,\r\n"
		+ "tt.investmentAmount, tt.dateCreated, tt.status, tt.approvedAmount from TdsSection ts JOIN TdsTransaction tt on \r\n"
		+ "ts.tdsSectionId=tt.tdsSectionId where tt.employeeId=?1 and tt.financialYear=?2 ORDER BY ts.tdsSectionName ASC";

String queryForStatusUPDATE = "UPDATE TdsTransaction SET status='Declared' WHERE employeeId=?1 and financialYear=?2";
			
	@Query(value=queryForTdsTransaction, nativeQuery=true)
    public List<Object[]> getTdsTransactionObjectList(Long employeeId, String financialYear);
    
    @Query(value=queryForTdsSummary, nativeQuery=true)
    public List<Object[]> getTdsSummaryObjectList(Long employeeId, String financialYear);
    
    @Query("from TdsTransaction where employeeId=?1 and financialYear=?2")
    public List<TdsTransaction> getTdsTransactionList(Long employeeId, String financialYear);
    
    @Query("SELECT SUM(investmentAmount) from TdsTransaction where employeeId=?1 and financialYear=?2")
    public BigDecimal getTotalInvestment(Long employeeId, String financialYear);
    
    @Modifying
    @Query(value=queryForStatusUPDATE, nativeQuery=true)
    public void updateStatus( Long employeeId,String financialYear);
}
