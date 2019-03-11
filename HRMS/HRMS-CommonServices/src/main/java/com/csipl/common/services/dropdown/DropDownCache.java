package com.csipl.common.services.dropdown;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.common.model.DrowpdownList;
import com.csipl.common.util.EnumUtil;
import com.google.common.collect.ImmutableMap;

public class DropDownCache {
	 private static DropDownCache dropDownCache;
	 static ImmutableMap<String, List<DrowpdownList> > map = null;
	 private DropDownCache() { }
	 
	 public static DropDownCache getInstance() {
	        if (null == dropDownCache) {
	        	dropDownCache = new DropDownCache();
	        	 
	        }
	        return dropDownCache;
	    }
	 
	 public void  initializeDrpDown(   List<DrowpdownHd> dropDownHdList ) {
		 Map<String, List<DrowpdownList> > dropDowns = new HashMap< String, List<DrowpdownList> >();
		 createDropDown( dropDownHdList, dropDowns );
		  map = ImmutableMap.copyOf( dropDowns );
		  System.out.println(" DropDownCache map size ===== "+map.size());
	 }
	 
	 public String getDropDownValue( String dropDownName , String enumCode ) {
		 
		 List<DrowpdownList> dropDownList =  map.get( dropDownName );
		 String value =  EnumUtil.getEnumValue( dropDownList, enumCode);
		 return value;
	 }
	 
	 private void  createDropDown( List<DrowpdownHd> dropDownHdList,  Map<String, List<DrowpdownList> > dropDowns ) {
		 dropDownHdList.forEach( dropDownHD -> {
			 
			 dropDowns.put( dropDownHD.getDrowpdownName()  , dropDownHD.getDrowpdownLists() );
		 } );
	 }
}
	 
	 
