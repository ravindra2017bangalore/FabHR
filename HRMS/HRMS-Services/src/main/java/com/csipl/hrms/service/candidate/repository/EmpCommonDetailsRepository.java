package com.csipl.hrms.service.candidate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csipl.hrms.model.employee.EmpCommonDetail;

@Repository
public interface EmpCommonDetailsRepository extends CrudRepository<EmpCommonDetail, Long>{

}
