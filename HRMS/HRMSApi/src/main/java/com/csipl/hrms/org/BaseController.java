package com.csipl.hrms.org;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.BaseModelWithoutGroup;
import com.csipl.hrms.model.authoriztion.UserRole;
import com.csipl.hrms.model.common.Company;
import com.csipl.hrms.model.common.Groupg;
import com.csipl.hrms.model.common.User;

public class BaseController<DB> {

	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	// set user profile with company and group
	public void setUserProfile(BaseModel model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		Company company = new Company();
		company.setCompanyId(user.getCompany().getCompanyId());
		model.setCompany(company);
		model.setUserId(user.getUserId());
		model.setUserIdUpdate(user.getUserId());
		// model.setDateUpdate(dateUpdate);
		if (user.getGroupg() == null) {
			Groupg groupg = new Groupg();
			groupg.setGroupId(1l);
			model.setGroupg(groupg);
		} else {
			model.setGroupg(user.getGroupg());
		}
	}

	// editLogInfo replacement of setUserProfile
	public void editLogInfo(BaseModel model, boolean newFlag, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		Company company = new Company();

	
logger.info("editLogInfo companyid is  :"+user.getCompany().getCompanyId()+"newFlag is :"+newFlag);
		company.setCompanyId(user.getCompany().getCompanyId());
		model.setCompany(company);

		// model.setDateUpdate(dateUpdate);
		if (user.getGroupg() == null) {
			Groupg groupg = new Groupg();
			groupg.setGroupId(1l);
			model.setGroupg(groupg);
		} else {
			model.setGroupg(user.getGroupg());
		}

		model.setDateUpdate(new Date());
		model.setUserIdUpdate(user.getUserId());
		if (newFlag) {
			model.setDateCreated(new Date());
			model.setUserId(user.getUserId());
			model.setEffectiveStartDate(new Date());
			model.setActiveStatus("AC");
		}
		/*else {

			model.setEffectiveEndDate(new Date());
			model.setActiveStatus("DE");
		}
*/	}
	
	
	public void editLogInfoWithoutGroup(BaseModelWithoutGroup model, boolean newFlag, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		Company company = new Company();
		logger.info("editLogInfoWithoutGroup companyid is  :"+user.getCompany().getCompanyId()+"newFlag is :"+newFlag);
		company.setCompanyId(user.getCompany().getCompanyId());
		model.setCompany(company);
		model.setDateUpdate(new Date());
		model.setUserIdUpdate(user.getUserId());
	/*	if (newFlag) {
			model.setDateCreated(new Date());
			model.setUserId(user.getUserId());
		}*/
		if (newFlag) {
			model.setDateCreated(new Date());
			model.setUserId(user.getUserId());
			model.setEffectiveStartDate(new Date()); 
			model.setActiveStatus("AC");
		}
		/*else {

			model.setEffectiveEndDate(new Date());
			model.setActiveStatus("DE");
		}
*/	}

	// editLogInfoWithoutCG replace of setUserProfileWithoutCG

	public void editLogInfoWithoutCG(BaseModelWithoutCG model, boolean newFlag, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		logger.info("editLogInfoWithoutCG companyid is  :"+user.getCompany().getCompanyId()+"newFlag is :"+newFlag);
		
		model.setDateUpdate(new Date());
		model.setUserIdUpdate(user.getUserId());
		if (newFlag) {
			model.setDateCreated(new Date());
			model.setUserId(user.getUserId());
		}
	}

	// set user profile without company and group
	public void setUserProfileWithoutCG(BaseModelWithoutCG model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("User");
		logger.info("setUserProfileWithoutCG companyid is  :"+user.getUserId());
			model.setUserId(user.getUserId());
		model.setUserIdUpdate(user.getUserId());
	}

	// set user profile without company and group without session
	public void setUserProfileWithoutCG1(BaseModelWithoutCG model, HttpServletRequest req) {
		logger.info("setUserProfileWithoutCG1 companyid is  :");
		model.setUserId(1l);
		model.setUserIdUpdate(1l);
	}

	// set user profile List without company and group
	public void setUserProfileWithoutCGList(List<BaseModelWithoutCG> modelList, HttpServletRequest req) {
		logger.info("setUserProfileWithoutCGList companyid is  :");
		for (BaseModelWithoutCG model : modelList) {
			setUserProfileWithoutCG(model, req);
		}
	}

	// set user profile List with company and group
	public void setUserProfileListWithCG(List<BaseModel> modelList, HttpServletRequest req) {
		logger.info("setUserProfileListWithCG companyid is  :");
		for (BaseModel model : modelList) {
			setUserProfile(model, req);
		}
	}

	// set user profile with company and group without session
	public void setUserProfileWithoutSession(BaseModel model, HttpServletRequest req) {
		logger.info("setUserProfileWithoutSession  is  calling:");
		Company company = new Company();
		company.setCompanyId(1l);
		model.setCompany(company);
		model.setUserId(1l);
		model.setUserIdUpdate(1l);
		Groupg groupg = new Groupg();
		groupg.setGroupId(1l);
		model.setGroupg(groupg);
		// model.setDateUpdate(dateUpdate);

	}

	// set user profile with out company and group without session
	public void setUserProfileWithoutSession1(BaseModel model, HttpServletRequest req) {
		logger.info("setUserProfileWithoutSession1  is  calling:");
		model.setUserId(1l);
		model.setUserIdUpdate(1l);
		// model.setDateUpdate(dateUpdate);
	}


public Long getCompanyId(HttpServletRequest req) throws PayRollProcessException {
	
	
	 HttpSession session = req.getSession();
	 if ( session.getAttribute("User") == null ) {
		 System.out.println( " User is null ");
		 throw new PayRollProcessException("Server session expired ");
	 }
	 User user = (User) session.getAttribute("User"); 
	 
	 
	 logger.info("getCompanyId"+user.getCompany().getCompanyId());
	 return user.getCompany().getCompanyId();
	

	}


public Long getUserId(HttpServletRequest req) throws PayRollProcessException {
	
	
	 HttpSession session = req.getSession();
	 if ( session.getAttribute("User") == null ) {
		 System.out.println( " User is null ");
		 throw new PayRollProcessException("Server session expired ");
	 }
	 User user = (User) session.getAttribute("User"); 
	
	 return user.getUserId().longValue();
	

	}


public String getUserRoleName(HttpServletRequest req) throws PayRollProcessException {
	
	
	 HttpSession session = req.getSession();
	 if ( session.getAttribute("User") == null ) {
		 System.out.println( " User is null ");
		 throw new PayRollProcessException("Server session expired ");
	 }
	 User user = (User) session.getAttribute("User"); 
	 List<UserRole> userRoles= user.getUserRoles();
 
	 return userRoles.get(0).getRoleMaster().getRoleDescription();
	

	}
}
