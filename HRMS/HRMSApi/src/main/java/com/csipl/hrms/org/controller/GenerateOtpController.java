package com.csipl.hrms.org.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.csipl.hrms.common.util.AppUtils;
import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.common.util.OTPService;
import com.csipl.hrms.dto.organisation.UserDTO;
import com.csipl.hrms.model.common.Address;
import com.csipl.hrms.model.common.User;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.service.adaptor.UserAdaptor;
import com.csipl.hrms.service.authorization.LoginService;
import com.csipl.hrms.service.authorization.repository.LoginRepository;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.employee.repository.UserRepository;
import com.csipl.hrms.service.users.UserService;

@RequestMapping("/forgetPassword")
@RestController
public class GenerateOtpController {
	private static final Logger logger = LoggerFactory.getLogger(GenerateOtpController.class);
	boolean status = false;
	UserAdaptor usersAdaptor = new UserAdaptor();
	Address address = null;
	Employee employee = null;//test
	int otp = 1234;

	@Autowired
	EmployeePersonalInformationService employeeService;

	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;
	
 
	@Autowired
	JavaMailSender mailSender;

	@Autowired
	OTPService otpService;

	//@Autowired
	//LoginRepository loginRepository;

	@RequestMapping(path = "/generateOtp", method = RequestMethod.POST)
	public @ResponseBody UserDTO generateOtp(@RequestBody UserDTO userDto, HttpServletRequest req) throws ErrorHandling {
		logger.info("generateOtp is calling : UserDTO " + userDto +""+userDto.getLoginName());

		UserDTO userDtoDb = new UserDTO();
	 
			
			User userBean = loginService.findUserByUserName(userDto.getLoginName());
		logger.info("userBean is : "+userBean);	
			if(userBean!=null) {
			employee = employeeService.findEmployees(userBean.getNameOfUser(), userBean.getCompany().getCompanyId() );

			logger.info("employee" + employee);
			address = employee.getAddress2();

			StringBuilder sbMobile = new StringBuilder();
			char[] buff = employee.getAddress2().getMobile().toCharArray();
			sbMobile.append(buff, 0, 2).append("*****");
			sbMobile.append(buff, 7, buff.length - 7);

			StringBuilder sbEmail = new StringBuilder();
			char[] buffEmail = userBean.getEmailOfUser().toCharArray();
			sbEmail.append(buffEmail, 0, 3).append("******");
			String strEmail = new String(buffEmail);
			String str1[] = strEmail.split("\\@");
			sbEmail.append(str1[0].substring(str1[0].length() - 2));
			sbEmail.append("@" + str1[1]);

			int otp = otpService.getOtp(userDto.getLoginName());
			
			if (otp > 0) {
				Integer value = otpService.getOtp(userDto.getLoginName());
				logger.info("old OTP :================ "+ value);
				if (value > 0) {
					userDtoDb = sendOtp(value, sbEmail, sbMobile, userBean);
					userDtoDb.setLoginName(userBean.getLoginName());
					userDtoDb.setNameOfUser(userBean.getNameOfUser());
				}
			} else {
				if (employee.getAddress2().getMobile() != null) {
					Integer value = otpService.generateOtp(userDto.getLoginName());
					logger.info("new OTP :================ "+ value);
					if (value > 0) {
						userDtoDb = sendOtp(value, sbEmail, sbMobile, userBean);
 						userDtoDb.setNameOfUser(userBean.getNameOfUser());
						userDtoDb.setLoginName(userBean.getLoginName());
						
						
					}

				}
			}
			
			}
			else {
				logger.info("Please enter correct employee code");
				throw new ErrorHandling("Error! Please enter correct employee code");
			
			}
		return userDtoDb;
	}

	private UserDTO sendOtp(Integer value, StringBuilder sbEmail, StringBuilder sbMobile, User userBean) {

		UserDTO u = new UserDTO();
		new AppUtils().sendOtpBySms("Hi Your Otp Number is :- " + value, employee.getAddress2().getMobile());
		triggerEmail(userBean.getEmailOfUser(), userBean, employee, value);
		//u.setNameOfUser(employee.getEmployeeCode());
		u.setEmailOfUser(sbEmail.toString());
		u.setMobile(sbMobile.toString());
		u.setEmployeeId(employee.getEmployeeId());
		u.setCompanyId(employee.getCompany().getCompanyId());
		System.out.println("u.getCompanyId()>>> "+u.getCompanyId());
		return u;
	}

	@RequestMapping(path = "/verifyOtp", method = RequestMethod.POST)
	public @ResponseBody UserDTO varifyOtp(@RequestBody UserDTO userDto, HttpServletRequest req) {
		logger.info("varifyOtp is calling : UserDTO " + userDto);
		
		String username = userDto.getLoginName();
 		logger.info("session otp value: "+username+"" + otpService.getOtp(username));

		if (otpService.getOtp(username) == (Integer.parseInt(userDto.getOtp()))) {
			otpService.clearOTP(username);
		//	User user = loginRepository.findUserByUserName(username);
			User user = loginService.findUserByUserName(username);

			employee = employeeService.findEmployees(user.getNameOfUser(),user.getCompany().getCompanyId());
			String mobile = employee.getAddress2().getMobile();
			UserDTO u = new UserDTO();
  			u.setEmailOfUser(user.getEmailOfUser());
  			u.setNameOfUser(user.getNameOfUser());
			u.setLoginName(user.getLoginName());
			u.setMobile(mobile);
			return u;
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Boolean forgetPassword(@RequestBody UserDTO userDto, HttpServletRequest req) {
		logger.info("forgetPassword is calling : UserDTO " + userDto);
		String userName = userDto.getLoginName();
		String userPassword = userDto.getUserPassword();
		logger.info("=======user======" + userName + "==========" + userPassword);
		User userBean = loginService.findUserByUserName(userName);
		userBean.setUserPassword(AppUtils.SHA1(userPassword));
		logger.info("=======userBean======" + userBean);
		userBean = userService.save(userBean);
		if (userBean.getUserId() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method Performed email sending logic
	 */
	private void triggerEmail(String email, User userBean, Employee employee, Integer otp) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		logger.info("To email is :" + email);
		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(HrmsGlobalConstantUtil.MAIL_SUBJECT_FOR_OTP);
			mimeMessageHelper.setTo(email);
			mimeMessageHelper.setFrom(HrmsGlobalConstantUtil.FROM_MAIL);
			mimeMessageHelper.setCc(HrmsGlobalConstantUtil.MAIL_CC);

			mimeMessageHelper.setText(createOPTMailMessage(otp, employee));

			mailSender.send(mimeMessageHelper.getMimeMessage());
			logger.info("mail send succesfully :" + email);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String createOPTMailMessage(Integer otp, Employee employee) {
		StringBuilder sb = new StringBuilder();
		sb.append(" Dear  " + employee.getFirstName() + " \n ");
		sb.append(
				" 	This is a system generated mail that is being sent out to you with regard to your account at Fabhr.in/hrms. \n ");
		sb.append(" 	Please use" + otp + "as the one time password for secure login in your account ( "
				+ employee.getEmployeeCode() + " ).  \n ");
		sb.append(" 	This password is valid for 30 minutes.   \n \n ");
		sb.append(
				" 	For any further queries, please feel free to write us at hrd@computronics.in or call us (+91-731) 2550001/ 2570001. \n  \n ");
		sb.append(" Regards, \n" + "	Team Computronics\r\n" + " \n  ");

		return sb.toString();
	}
}
