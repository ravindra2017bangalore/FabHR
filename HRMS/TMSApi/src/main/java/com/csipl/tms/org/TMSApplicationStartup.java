package com.csipl.tms.org;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.csipl.common.model.DrowpdownHd;
import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.common.services.dropdown.DropDownHdService;

@Component
public class TMSApplicationStartup implements ApplicationListener<ApplicationReadyEvent>{
	@Autowired
	DropDownHdService dropDownHdService;

  /**
   * This event is executed as late as conceivably possible to indicate that 
   * the application is ready to service requests.
   */
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
 
	  List<DrowpdownHd> dropDownHdList =   dropDownHdService.getAllDropDowns();
	  
	 System.out.println(" TMSApplicationStartup dropDownHdList  ===== "+dropDownHdList.size());
	  
	 DropDownCache.getInstance().initializeDrpDown(dropDownHdList);;
 
    return;
  }
}
