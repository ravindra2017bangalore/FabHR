package com.csipl.common.services.dropdown;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.common.services.dropdown.repository.DropDownHdRepository;





@Service("dropDownHdService")
public class DropDownHdServiceImpl implements DropDownHdService {
	private static final Logger logger = LoggerFactory.getLogger(DropDownHdServiceImpl.class);

	@Autowired
	private DropDownHdRepository dropDownHdRepository;

	@Override
	public List<DrowpdownHd> getAllDropDowns() {
		return dropDownHdRepository.findAllDropDown();
	}
	
	@Override
	 public DrowpdownHd findDropDownById( long dropDownId ) {
		
		return dropDownHdRepository.findDropDownById( dropDownId );
	 }
}
