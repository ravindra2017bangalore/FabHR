package com.csipl.hrms.service.organization;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.employee.ProfessionalInformation;
import com.csipl.hrms.model.organisation.Item;
import com.csipl.hrms.service.employee.repository.ProfessionalInformationRepository;
import com.csipl.hrms.service.organization.repository.ItemRepository;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemRepository itemRepository;

	/**
	 * Method performed delete operation,delete item object from  Database
 	 */
	@Override
	public void delete(Item item) {
		itemRepository.delete(item);
	}

	/**
	 * Method performed save operation, to save List of items into Database
 	 */
	@Override
	public List<Item> saveAll(List<Item> itemList) {
		List<Item> itemListInfos= (List<Item>) itemRepository.save(itemList);
		return itemListInfos;
	}
	/**
	 * Method performed fetch  operation, get  List of items from  Database based on companyId
 	 */
	@Override
	public List<Item> findAllItems(Long companyId) {
		return itemRepository.findAllItems(companyId);
	}
}
