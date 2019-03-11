package com.csipl.hrms.service.payroll.repository;





import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.csipl.hrms.model.payroll.Overtime;



public interface OvertimeRepository extends CrudRepository<Overtime, Long> {
 	@Query(" from Overtime where companyId=?1 ORDER BY  overtimeId  DESC ")
    public List<Overtime> findAllOvertimeMethods(Long companyId);
  }