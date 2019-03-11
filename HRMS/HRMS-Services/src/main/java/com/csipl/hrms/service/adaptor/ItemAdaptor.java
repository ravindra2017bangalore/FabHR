package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.hrms.dto.organisation.ItemDTO;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.organisation.Item;

public class ItemAdaptor  implements Adaptor<ItemDTO, Item> {

	
	@Override
	public List<Item> uiDtoToDatabaseModelList(List<ItemDTO> itemDtoList) {
		List<Item> itemList=new ArrayList<Item>();
		for (ItemDTO itemDto : itemDtoList) {
			itemList.add(uiDtoToDatabaseModel(itemDto));
		}
		return itemList;
	}


	
	@Override
	public List<ItemDTO> databaseModelToUiDtoList(List<Item> itemList) {
		List<ItemDTO> itemDtoList=new ArrayList<ItemDTO>();
		for (Item item : itemList) {
			itemDtoList.add(databaseModelToUiDto(item));
		}
		return itemDtoList;
	}

	
	
	@Override
	public Item uiDtoToDatabaseModel(ItemDTO itemDto) {
		Item item=new Item();
		Groupg group=new Groupg();
		Company company=new Company();
		item.setItemId(itemDto.getItemId());
		item.setItemName(itemDto.getItemName());
		item.setHsnCode(itemDto.getHsnCode());
 		item.setGstRate(itemDto.getGstRate());
		item.setItemUnit(itemDto.getItemUnit());
		item.setActiveStatus(itemDto.getActiveStatus());
		item.setUserId(itemDto.getUserId());
		item.setDateCreated(itemDto.getDateCreated());
		company.setCompanyId(itemDto.getCompanyId());
		item.setCompany(company);
  		
  		
  		if(item.getItemId()==null)
  			item.setDateCreated(new Date());
   		else
   			item.setDateCreated(itemDto.getDateCreated());

  		 
  		item.setDateUpdate(new Date());
  		item.setUserIdUpdate(itemDto.getUserIdUpdate());
  		group.setGroupId(1l);
  		item.setGroupg(group);
		return item;
	}
	@Override
	public ItemDTO databaseModelToUiDto(Item item) {
		ItemDTO itemDto=new ItemDTO();
		
		itemDto.setItemId(item.getItemId());
		itemDto.setItemName(item.getItemName());;
		itemDto.setHsnCode(item.getHsnCode());
		itemDto.setGstRate(item.getGstRate());
		itemDto.setItemUnit(item.getItemUnit());
		itemDto.setActiveStatus(item.getActiveStatus());
		itemDto.setUserId(item.getUserId());
		itemDto.setDateCreated(item.getDateCreated());
		return itemDto;
	}

}
