package com.csipl.hrms.service.organization;

import java.util.List;

import com.csipl.hrms.model.organisation.Item;

public interface ItemService {

	public List<Item> findAllItems(Long companyId);

	public List<Item> saveAll(List<Item> item);

	public void delete(Item item);

 }
