/*package com.csipl.hrms.org;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionCreatedEvent;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;


public class WebSessionListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent applicationEvent ) {
		if(applicationEvent instanceof HttpSessionCreatedEvent) { //If event is a session created event
			
			 HttpSession httpSession = ((HttpSessionCreatedEvent) applicationEvent).getSession(); 
		
		} else if(applicationEvent instanceof HttpSessionDestroyedEvent){ 
			
			 HttpSession httpSession = ((HttpSessionCreatedEvent) applicationEvent).getSession(); 
			 
			 if ( httpSession.getAttribute("User") == null ) { 
				 
			 }
		}
		
		
	}
	
}*/