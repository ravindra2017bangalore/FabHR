  package com.csipl.hrms.service.adaptor;

import java.util.List;
    
public interface Adaptor<UI,DB> {
	
	
	public List<DB> uiDtoToDatabaseModelList(List<UI> uiobj);
	
	public List<UI> databaseModelToUiDtoList(List<DB> dbobj);
	
	
	public DB uiDtoToDatabaseModel(UI uiobj);
	
	public UI databaseModelToUiDto(DB dbobj);
	
	
}



