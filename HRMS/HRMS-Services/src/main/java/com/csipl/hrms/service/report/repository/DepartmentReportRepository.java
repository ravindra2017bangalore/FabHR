package com.csipl.hrms.service.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.csipl.hrms.model.organisation.Department;


public interface DepartmentReportRepository extends CrudRepository<Department, Long>{

	
	String fetchDepartmentWiseCTCList ="CALL  pro_department_wise_ctc( :p_comp_id,:p_process_month)" ;
	//pro_lastsixmonth_ctc
	String fetchLastSixMonthCTC ="CALL  pro_lastsixmonth_ctc( :p_comp_id,:p_process_month)" ;
	
	String processmonthbyLastmonth ="CALL  pro_str_processmonth_byLastmonth( :p_comp_id,:p_process_month)" ;

	@Query(value=fetchDepartmentWiseCTCList,nativeQuery = true)
	public List<Object[]> fetchDepartmentWiseCTCList(@Param(value = "p_comp_id") Long p_comp_id ,@Param(value = "p_process_month") Long p_process_month);
		
	@Query(value=processmonthbyLastmonth,nativeQuery = true)
	public Object processmonthbyLastmonth(@Param(value = "p_comp_id") Long p_comp_id ,@Param(value = "p_process_month") Long p_process_month);
	
	
	@Query(value=fetchLastSixMonthCTC,nativeQuery = true)
	public List<Object[]> fetchLastSixMonthCTC(@Param(value = "p_comp_id") Long p_comp_id ,@Param(value = "p_process_month") Long p_process_month); 

}