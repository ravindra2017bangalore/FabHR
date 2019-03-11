package com.csipl.hrms.service.candidate;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.csipl.hrms.model.candidate.CandidateIdProof;
import com.csipl.hrms.model.common.MandatoryInfoCheck;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.service.candidate.repository.CandidateIdAddressRepository;
import com.csipl.hrms.service.employee.repository.MasterBookRepository;
import com.csipl.hrms.service.organization.StorageService;
import com.csipl.hrms.service.organization.repository.MandatoryInfoCheckRepository;


@Service("candidateIdProofService")

public class CandidateIdAddressServiceImpl implements CandidateIdAddressService{

	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(CandidateIdAddressServiceImpl.class);
	
	@Autowired
	private CandidateIdAddressRepository candidateIdAddressRepository;
	
	@Autowired
	MandatoryInfoCheckRepository mandatoryInfoCheckRepository;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	private MasterBookRepository masterBookRepository;

	
	@Override
	public List<CandidateIdProof> save(List<CandidateIdProof> candidateIdProofList,HttpServletRequest request) {
		
		logger.info("CandidateIdProofList is ===== " + candidateIdProofList);
	/*	MandatoryInfoCheck mandatoryInfoCheck = new MandatoryInfoCheck();
		logger.info(" mandatoryInfoCheck is : " + mandatoryInfoCheck);
		Long canId = 0l;
		Long userIdUpdate = 0l;
		String idType;
		boolean flag = false;
		for (CandidateIdProof candidateIdProof : candidateIdProofList) {
			canId = candidateIdProof.getCandidate().getCandidateId();
			logger.info("empId for mandatoryInfoCheck is  : " + canId);
			userIdUpdate = candidateIdProof.getUserIdUpdate();
			logger.info("userIdUpdate for mandatoryInfoCheck is  : " + userIdUpdate);
			idType = candidateIdProof.getIdTypeId();
			logger.info("idType for mandatoryInfoCheck is  : " + idType);
			if (candidateIdProof.getIdTypeId().equals("PA")) {
				flag = true;
				logger.info("flag for mandatoryInfoCheck is  : " + flag);
				break;
			}
		}
		
		if (flag) {
			mandatoryInfoCheck = mandatoryInfoCheckRepository.getMandatoryInfoCheck(canId);
			if (mandatoryInfoCheck != null && mandatoryInfoCheck.getUserId() != null
					&& mandatoryInfoCheck.getDateCreated() != null) {
				mandatoryInfoCheck.setUserId(mandatoryInfoCheck.getUserId());
				mandatoryInfoCheck.setDateCreated(mandatoryInfoCheck.getDateCreated());
			}
			mandatoryInfoCheck.setPA("YES");
			mandatoryInfoCheck.setDateUpdate(new Date());
			mandatoryInfoCheck.setUserIdUpdate(userIdUpdate);
			mandatoryInfoCheckRepository.save(mandatoryInfoCheck);

		} else {
			mandatoryInfoCheck = mandatoryInfoCheckRepository.getMandatoryInfoCheck(canId);
			if (mandatoryInfoCheck != null && mandatoryInfoCheck.getUserId() != null
					&& mandatoryInfoCheck.getDateCreated() != null) {
				mandatoryInfoCheck.setUserId(mandatoryInfoCheck.getUserId());
				mandatoryInfoCheck.setDateCreated(mandatoryInfoCheck.getDateCreated());
			}
			mandatoryInfoCheck.setPA("");
			mandatoryInfoCheck.setDateUpdate(new Date());
			mandatoryInfoCheck.setUserIdUpdate(userIdUpdate);
			mandatoryInfoCheckRepository.save(mandatoryInfoCheck);
		}
*/      
		
		MultipartHttpServletRequest multiPartRequest = new DefaultMultipartHttpServletRequest(request);

		multiPartRequest = (MultipartHttpServletRequest) request;
		multiPartRequest.getParameterMap();

		String bookCode = "EMPNO";
		//
		int index = 0;
		int count = 0;
		for (CandidateIdProof candidateIdProof : candidateIdProofList) {
			Iterator<String> itr = multiPartRequest.getFileNames();
			System.out.println("----designDocument.getDesignName() :::;::" + candidateIdProof.getDocumentName());
			if (candidateIdProof.getDocumentName() != null && !("").equals(candidateIdProof.getDocumentName())) {
				System.out.println("----inner for loop ");
				int fileIndex = 0;
				while (itr.hasNext()) {
					MultipartFile mFile = multiPartRequest.getFile(itr.next());
					System.out.println("fileIndex  "+fileIndex);
					System.out.println("Index  "+index);
					if (fileIndex == index) {
						MasterBook masterBook = masterBookRepository.findMasterBook(1l, bookCode);
						BigDecimal lastNumberValue;
						lastNumberValue = masterBook.getLastNo();
						long longValue;
						longValue = lastNumberValue.longValue() + 1;
						BigDecimal newDecimalValue = new BigDecimal(longValue);
						String fileName=masterBook.getPrefixBook() +'C'+ newDecimalValue;
						String extension = FilenameUtils.getExtension(mFile.getOriginalFilename());
						fileName = fileName + "." + extension;
						//logger.info(" File with extension " + fileName);

						String path = File.separator + "Document" + File.separator + "Candidate"+ File.separator + "CandidateIdproofDoc";
						String dbPath = path + File.separator + fileName;
					   storageService.store(mFile, path, fileName);
					   masterBook.setLastNo(newDecimalValue);
					  masterBookRepository.save(masterBook);
						
						System.out.println("FileName is " + mFile.getOriginalFilename());
						candidateIdProof.setIdProofDoc(dbPath);
						candidateIdProof.setDocumentName(fileName);
						System.out.println("store  end ()");
						
					}
					fileIndex++;
					System.out.println(".while end ()");
				}
				
				index++;
			} 
			
			
		
		}

		

		
		
		
		List<CandidateIdProof> CandidateIdProofInfos = (List<CandidateIdProof>) candidateIdAddressRepository
				.save(candidateIdProofList);
		
		
		return CandidateIdProofInfos;
	}

	@Override
	public List<CandidateIdProof> findAllCandidateIdProofs(Long candidateId) {
		// TODO Auto-generated method stub
		return candidateIdAddressRepository.findAllCanIDProof(candidateId);
	}

	

}
