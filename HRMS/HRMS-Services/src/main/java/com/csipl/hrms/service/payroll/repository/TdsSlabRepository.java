package com.csipl.hrms.service.payroll.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
 import com.csipl.hrms.model.payroll.TdsSlabHd;

public interface TdsSlabRepository extends CrudRepository<TdsSlabHd, Long> {
 	 @Query(" from TdsSlabHd where companyId=?1  ORDER BY  tdsSLabHdId  DESC")
    public List<TdsSlabHd> findAllTdsSlabList( Long companyId ); 
 	 
 	 @Query(" from TdsSlabHd where companyId=?1 AND tdsCategory=?2 ORDER BY  tdsSLabHdId  DESC")
     public TdsSlabHd finddsSlab(Long companyId,String tdsCategory); 
 }
