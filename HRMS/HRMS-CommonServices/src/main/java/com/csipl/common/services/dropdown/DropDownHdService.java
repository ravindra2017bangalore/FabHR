package com.csipl.common.services.dropdown;

import java.util.List;

import com.csipl.common.model.DrowpdownHd;





public interface DropDownHdService {
	public List<DrowpdownHd> getAllDropDowns();
	
	 public DrowpdownHd findDropDownById( long dropDownId );
}
