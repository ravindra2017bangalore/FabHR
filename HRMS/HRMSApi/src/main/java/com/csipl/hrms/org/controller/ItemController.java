package com.csipl.hrms.org.controller;

 
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.dto.organisation.ItemDTO;

import com.csipl.hrms.model.organisation.Item;
import com.csipl.hrms.service.adaptor.ItemAdaptor;

import com.csipl.hrms.service.organization.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	ItemAdaptor itemAdaptor = new ItemAdaptor();

	@Autowired
	ItemService itemService;
	/**
	 * Method performed save operation 
	 * @param itemDtoList
	 *            This is the first parameter for getting List of items Object from UI
	 * @param req
	 *            This is the second parameter to maintain user session
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody List<ItemDTO> saveItems(@RequestBody List<ItemDTO> itemDtoList, HttpServletRequest req) {
		logger.info("saveItems is calling");
		List<Item> itemList = itemAdaptor.uiDtoToDatabaseModelList(itemDtoList);
		return itemAdaptor.databaseModelToUiDtoList(itemService.saveAll(itemList));
	}

	/**
	 * to get List of Items  from database based on companyId 
	 * @throws PayRollProcessException 
	 */
	@RequestMapping(value="/{companyId}",method = RequestMethod.GET)
	public @ResponseBody List<ItemDTO> findAllItems(@PathVariable("companyId") String companyId , HttpServletRequest req) throws ErrorHandling, PayRollProcessException {
		logger.info("findAllItems is calling : ");
		Long longCompanyId=Long.parseLong(companyId);
		List<Item> itemList = itemService.findAllItems(longCompanyId);
		logger.info("findAllItems is end :itemList "+itemList);
		if (itemList != null && itemList.size() > 0)
			return itemAdaptor.databaseModelToUiDtoList(itemList);
		else
			throw new ErrorHandling("Item Data not present");
	}
	/**
	 * delete Item Object from database  
	 */
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public void deleteProfessional(@RequestBody ItemDTO itemDto, HttpServletRequest req) {
		logger.info("deleteItem is calling : ItemDTO");
		Item item = itemAdaptor.uiDtoToDatabaseModel(itemDto);
		itemService.delete(item);
	}
}
