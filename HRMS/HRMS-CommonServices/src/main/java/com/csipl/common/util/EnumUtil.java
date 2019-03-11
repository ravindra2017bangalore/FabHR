package com.csipl.common.util;



import java.util.List;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.common.model.DrowpdownList;



public class EnumUtil {

	public static String getEnumValue( DrowpdownHd dropDownHd, String enumCode ) {
		
		String enumValue = null;
		for( DrowpdownList drowpdownList :  dropDownHd.getDrowpdownLists()) {
			if ( drowpdownList.getListCode().equals( enumCode )) {
				enumValue = drowpdownList.getListValue();
				break;
			}
		}
		return enumValue;
	}
	
    public static String getEnumValue( List<DrowpdownList> dropDownList, String enumCode ) {
		
		String enumValue = null;
		
		for( DrowpdownList drowpdownList :  dropDownList ) {
			if ( drowpdownList.getListCode().equals( enumCode )) {
				enumValue = drowpdownList.getListValue();
				break;
			}
		}
		return enumValue;
	}
	
	
   public static String getEnumKey( DrowpdownHd dropDownHd, String name ) {
		
		String enumValue = null;
		for( DrowpdownList drowpdownList :  dropDownHd.getDrowpdownLists()) {
 			if ( drowpdownList.getListValue().equals( name )) {
				enumValue = drowpdownList.getListCode();
				break;
			}
		}
		return enumValue;
	}
   
   
	
}
