package com.csipl.hrms.common.enums;

public enum PFlageEnum {
	
	BirthDay("data_birhtday" ),
	Anniversary( "data_anniversary" ),
	Joinig( "data_work" ),
	Notification("noti_list");
	
	public String pFlageEnum ;
	
	

	PFlageEnum (String pFlageEnum  ) {
		
		this.pFlageEnum = pFlageEnum;
	}



	public String getpFlageEnum() {
		return pFlageEnum;
	}



	public void setpFlageEnum(String pFlageEnum) {
		this.pFlageEnum = pFlageEnum;
	}


}
