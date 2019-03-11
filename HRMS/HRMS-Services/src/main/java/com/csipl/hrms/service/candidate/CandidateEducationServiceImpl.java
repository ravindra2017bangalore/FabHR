package com.csipl.hrms.service.candidate;

import java.io.File;
import java.math.BigDecimal;
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

import com.csipl.hrms.model.candidate.CandidateEducation;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.service.candidate.repository.CandidateEducationRepository;
import com.csipl.hrms.service.employee.repository.MasterBookRepository;
import com.csipl.hrms.service.organization.StorageService;

@Service("candidateEducationService")
public class CandidateEducationServiceImpl implements CandidateEducationService{
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateEducationServiceImpl.class);
	
	@Autowired
	private CandidateEducationRepository candidateEducationRepository;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	private MasterBookRepository masterBookRepository;
	/**
	 * Method performed save OR update operation  
 	 */
	@Override
	public List<CandidateEducation> save(List<CandidateEducation> candidateEducationList,HttpServletRequest request) 
	{
		System.out.println("CnadidateEducationServiceImpl.save()"+candidateEducationList.size());
		MultipartHttpServletRequest multiPartRequest = new DefaultMultipartHttpServletRequest(request);
		
		multiPartRequest = (MultipartHttpServletRequest) request;
		multiPartRequest.getParameterMap();

		String bookCode = "EMPNO";
		//
		int index = 0;
		int count = 0;
		for (CandidateEducation candidateEdu : candidateEducationList) {
			Iterator<String> itr = multiPartRequest.getFileNames();
			System.out.println("----candidateEdu.getDesignName() :::;::" + candidateEdu.getDocumentName());
			if (candidateEdu.getDocumentName() != null && !("").equals(candidateEdu.getDocumentName())) {
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
						String fileName=masterBook.getPrefixBook() + newDecimalValue;
						String extension = FilenameUtils.getExtension(mFile.getOriginalFilename());
						fileName = fileName + "." + extension;
						//logger.info(" File with extension " + fileName);

						String path = File.separator + "assets" + File.separator + "ProjectDoc";
						String dbPath = path + File.separator + fileName;
					   storageService.store(mFile, path, fileName);
					   masterBook.setLastNo(newDecimalValue);
					  masterBookRepository.save(masterBook);
						
						System.out.println("FileName is " + mFile.getOriginalFilename());
						candidateEdu.setCandidateEducationDoc(dbPath);
						candidateEdu.setDocumentName(fileName);
						System.out.println("store  end ()");
						
					}
					fileIndex++;
					System.out.println(".while end ()");
				}
				
				index++;
			} 
			
			
		
		}
		
		logger.info("candidateEducationList is ===== "+candidateEducationList);
		List<CandidateEducation> candidateEducation = (List<CandidateEducation>) candidateEducationRepository.save(candidateEducationList);
		// TODO Auto-generated method stub
		return candidateEducation;
	}

	@Override
	public List<CandidateEducation> findAllEduInformation(Long candidateId) {
		logger.info("findAllEduInformation is ===== "+candidateId);
		 List<CandidateEducation> canList= candidateEducationRepository.findAllCanEdu(candidateId);
		 System.out.println(canList.toString());
		return canList;
	}
	
}
