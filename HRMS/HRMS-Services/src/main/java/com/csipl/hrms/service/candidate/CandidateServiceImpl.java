package com.csipl.hrms.service.candidate;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.apache.commons.io.FilenameUtils;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.multipart.MultipartFile;
import com.csipl.common.model.Mail;
import com.csipl.common.model.Notification;
import com.csipl.common.services.notification.NotificationServices;
import com.csipl.hrms.common.util.AppUtils;
import com.csipl.hrms.dto.candidate.CandidateDTO;
import com.csipl.hrms.model.candidate.Candidate;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.service.candidate.repository.CandidateRepository;
import com.csipl.hrms.service.common.MailService;
import com.csipl.hrms.service.employee.repository.MasterBookRepository;
import com.csipl.hrms.service.organization.StorageService;

@Transactional
@Service("candidateService")
public class CandidateServiceImpl implements CandidateService {
	@Autowired
	public CandidateRepository candidateRepository;

	@Autowired
	public NotificationServices notificationServices;

	@Autowired
	private MasterBookRepository masterBookRepository;

	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;
	@Autowired
	StorageService storageService;
	
	@Autowired
	private VelocityEngine velocityEngine;

	@Autowired
	MailService mailService;

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	private org.springframework.core.env.Environment env;
	

	@SuppressWarnings("unchecked")
	public Candidate save(Candidate candidate) throws Exception {
		Notification notification = new Notification();
		Mail mail = new Mail();
		Candidate candidate1 = candidateRepository.save(candidate);
		String bookCode = "EMPNO";
		MasterBook masterBook = masterBookRepository.findMasterBook(candidate1.getCompanyId(), bookCode);
		String prefix = masterBook.getPrefixBook();
		String add = "0";
		String strCandidateId = String.valueOf(candidate1.getCandidateId());
		String candidateCode = prefix + "C"
				+ Integer.valueOf(String.valueOf(candidate1.getCompanyId()) + strCandidateId);
		if (strCandidateId.length() == 1) {
			strCandidateId = add.concat(strCandidateId);
		}
		candidate1.setCandidateCode(candidateCode);
		System.out.println(" checkapproach in service impl===========================" + candidate.getCheckApproach());
		if (candidate1.getCandidateId() != null && candidate.getCheckApproach() == 1) {
			System.out.println("in sede if");
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			String emailLink= AppUtils.url + candidate1.getCandidateId()+"&companyId="+candidate1.getCompanyId();
			Map model = new HashMap();
			model.put("firstName", candidate1.getFirstName());
			model.put("lastName", candidate1.getLastName());
			model.put("link",emailLink);

			String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
					"templates/InviteTemplate.vm", "UTF-8", model);
			mimeMessageHelper.setFrom("amit.jaiswal@computronics.in");
			mimeMessageHelper.setSubject("Invite Mail");
			mimeMessageHelper.setTo(candidate.getEmailId());
			mimeMessageHelper.setText(text, true);
			mailSender.send(mimeMessageHelper.getMimeMessage());
//			mail.setFromMail("amit.jaiswal@computronics.in");
//			mail.setToMail(candidate.getEmailId());
//			mail.setMailBody("http://localhost:4200/people/directory");
//			mail.setSubject("Invite Mail");
//			notification.setMail(mail);
//			notification.setNotificationText("Dear " + candidate1.getFirstName() + " " + candidate1.getLastName()
//					+ ",\n\nGreeting from Computronics!\n\nWe welcome you, Please join us at HR portal for completing your onboarding formalities. \n"
//					+ AppUtils.url + candidate1.getCandidateId() + "\nCode= " + candidateCode
//					+ "\nFor any further queries,Please do let us know.\nRegards,\n HR");
//			System.out.println("Email Link-------" + notification.getNotificationText());
//			notificationServices.sendMail(notification);
			candidate1.setCheckApproach(candidate.getCheckApproach());
		}
		Candidate newCandidate = candidateRepository.save(candidate1);
		newCandidate.setCheckApproach(candidate.getCheckApproach());
		System.out.println("newCandidate.getCheckApproach()>>>> " + newCandidate.getCheckApproach());
		return newCandidate;
	}

	@Override
	public Candidate findCandidate(Long candidateId) {
		Candidate candidate = candidateRepository.findOne(candidateId);
		CandidateDTO candidateDto = new CandidateDTO();
		return candidate;
	}

	@Override
	public CandidateDTO findCandidatebyId(Long candidateId) {
		Candidate candidate = candidateRepository.findOne(candidateId);
		CandidateDTO candidateDto = new CandidateDTO();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT shiftFName FROM `TMSShift` WHERE shiftId= :shiftId");

		String query = sb.toString();
		System.out.println("Query=----" + query);
		Query nativeQuery = em.createNativeQuery(query);
		nativeQuery.setParameter("shiftId", candidate.getShiftId());
		final List<Object[]> resultList = nativeQuery.getResultList();
		Object[] result = resultList.get(0);

		return candidateDto;
	}

	@Override
	public Candidate findCandidateByCode(String candidatecode) {
		// TODO Auto-generated method stub
		return candidateRepository.findCandidateByCode(candidatecode);
	}

	@Override
	public void saveCandidateImage(Long candidateId, MultipartFile file) {
		String fileName = "";

		fileName = "Candidate" + candidateId.toString();
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		fileName = fileName + "." + extension;
		System.out.println(" File with extension " + fileName);

		String path = File.separator + "images" + File.separator + "employeeImages";
		String dbPath = path + File.separator + fileName;
		storageService.store(file, path, fileName);
		candidateRepository.saveCandidateImage(dbPath, candidateId);

	}

	@Override

	public void changeCandidateStatus(String candidateStatus, Long candidateId, String reason) {
		candidateRepository.changeCandidateStatus(candidateStatus, candidateId, reason);
	}

	public List<Object[]> progressBar(Long progressBar) {
		return candidateRepository.getProcessBar(progressBar);

	}

	@Override
	public List<Object[]> tabSubmitValidation(Long candidateId) {
		return candidateRepository.tabSubmitValidation(candidateId);
	}

	@Override
	public void resendMail(Candidate candidate, String comment) {
		Mail mail = new Mail();
		Notification notification = new Notification();
		System.out.println("candidateId===============================" + candidate.getCandidateId());
		System.out.println("CheckApproach===============================" + candidate.getCheckApproach());
		if (candidate.getCandidateId() != null && !candidate.getCandidateStatus().equals("RE")) {
			System.out.println("in sede if");
//			mail.setFromMail("amit.jaiswal@computronics.in");
//			mail.setToMail(candidate.getEmailId());
//			mail.setMailBody("http://localhost:4200/people/directory");
//			mail.setSubject("Invite Mail");
//			notification.setMail(mail);
//			notification.setNotificationText("Dear " + candidate.getFirstName() + " " + candidate.getLastName()
//					+ "\nThis is to inform you that there is certain information which is still pending in the form filled by you, here are the pending\n"
//					+ "details: Which needs to be filled by you again.\n" + comment + " \n" + AppUtils.url
//					+ candidate.getCandidateId() + "\nFor any further queries,Please do let us know.\n Regards,\n HR");
//			System.out.println("Email Link-------" + notification.getNotificationText());
//			notificationServices.sendMail(notification);
			// candidate1.setCheckApproach(candidate.getCheckApproach());
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper mimeMessageHelper;
			try {
				mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
				String emailLink= AppUtils.url + candidate.getCandidateId();
				Map model = new HashMap();
				model.put("firstName", candidate.getFirstName());
				model.put("lastName", candidate.getLastName());
				model.put("link",emailLink);
				model.put("comment",comment);
				
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"templates/resend.vm", "UTF-8", model);
				mimeMessageHelper.setFrom("amit.jaiswal@computronics.in");
				mimeMessageHelper.setSubject("Invite Mail");
				mimeMessageHelper.setTo(candidate.getEmailId());
				mimeMessageHelper.setText(text, true);
				mailSender.send(mimeMessageHelper.getMimeMessage());
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public String findShiftName(Long shiftId) {
		List<Object[]> objList = candidateRepository.findShiftName(shiftId);
		String shiftName = "";
 		for (Object[] objects : objList) {
			shiftName = objects[0] != null ? (String) objects[0] : "";
  		}
      		return shiftName;
	}

	@Override
	public String findWeekOffPatternName(Long patternId) {
		List<Object[]> objList = candidateRepository.findPatternName(patternId);
		String patternName = "";
 		for (Object[] objects : objList) {
  			patternName = objects[0] != null ? (String) objects[0] : "";
  		}
 		return patternName;
	}

	

}
