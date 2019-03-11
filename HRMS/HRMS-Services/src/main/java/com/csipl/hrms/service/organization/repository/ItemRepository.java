package com.csipl.hrms.service.organization.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.csipl.hrms.model.organisation.Item;


public interface ItemRepository extends CrudRepository<Item, Long>{
	@Query(" from Item where companyId=?1 ORDER BY  itemId  DESC")
    public List<Item> findAllItems(Long companyId);
}
