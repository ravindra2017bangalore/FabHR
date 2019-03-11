package com.csipl.hrms.service.organization.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.organisation.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

	@Query(" from Client where companyId=?1 ORDER BY  clientId  DESC ")
    public List<Client> findAllClient(Long companyId);
}
