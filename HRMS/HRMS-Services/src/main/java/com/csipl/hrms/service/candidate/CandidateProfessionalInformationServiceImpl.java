package com.csipl.hrms.service.candidate;

import java.io.File;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

import com.csipl.hrms.model.candidate.CandidateProfessionalInformation;
import com.csipl.hrms.model.candidate.CandidateSkill;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.service.candidate.repository.CandidateProfessionalInformationRepository;
import com.csipl.hrms.service.employee.repository.MasterBookRepository;
import com.csipl.hrms.service.organization.StorageService;




@Transactional
@Service("candidateProfessionalInformation")
public class CandidateProfessionalInformationServiceImpl implements CandidateProfessionalInformationService {

	@Autowired
	CandidateProfessionalInformationRepository candidateProfessionalInformationRepository;
	@Autowired
	CandidateSkillService candidateSkillService;
	@Autowired
	StorageService storageService;
	@Autowired
	private MasterBookRepository masterBookRepository;
	
	@Override
	public List<CandidateProfessionalInformation> saveCandidateProfessionalInfo(
			List<CandidateProfessionalInformation> candidateProfessionalInformationList,
			List<CandidateSkill> candidateSkillList) {
		List<CandidateProfessionalInformation> candidateProfessionalInformationLists = (List<CandidateProfessionalInformation>) candidateProfessionalInformationRepository
				.save(candidateProfessionalInformationList);
		candidateSkillService.save(candidateSkillList);
		return candidateProfessionalInformationLists;
	}
	

	@Override
	public List<CandidateProfessionalInformation> getAllCandidateProfessionalInformation(Long candidateId) {
		return candidateProfessionalInformationRepository.getAllCandidateProfessionalInformation(candidateId);
	}
	
	

	@Override
	public List<CandidateProfessionalInformation> save(List<CandidateProfessionalInformation> candidateProfessionalInfoList, HttpServletRequest req) {

		MultipartHttpServletRequest multiPartRequest = new DefaultMultipartHttpServletRequest(req);
		multiPartRequest = (MultipartHttpServletRequest) req;
		String bookCode = "EMPNO";
		//
		int index = 0;
		for (CandidateProfessionalInformation candidateProfessionalInformation : candidateProfessionalInfoList) {
			Iterator<String> itr = multiPartRequest.getFileNames();
			System.out.println("----designDocument.getDesignName() :::;::" + candidateProfessionalInformation.getDocumentName());
			if (candidateProfessionalInformation.getDocumentName() != null && !("").equals(candidateProfessionalInformation.getDocumentName())) {
				System.out.println("----inner for loop ");
				int fileIndex = 0;
				while (itr.hasNext()) {
					MultipartFile mFile = multiPartRequest.getFile(itr.next());
					System.out.println("fileIndex  " + fileIndex);
					System.out.println("Index  " + index);
					if (fileIndex == index) {
						MasterBook masterBook = masterBookRepository.findMasterBook(1l, bookCode);
						BigDecimal lastNumberValue;
						lastNumberValue = masterBook.getLastNo();
						long longValue;
						longValue = lastNumberValue.longValue() + 1;
						BigDecimal newDecimalValue = new BigDecimal(longValue);
						String fileName = masterBook.getPrefixBook() + newDecimalValue;
						String extension = FilenameUtils.getExtension(mFile.getOriginalFilename());
						fileName = fileName + "." + extension;
						// logger.info(" File with extension " + fileName);

						String path = File.separator + "Document" + File.separator + "Candidate"+File.separator+"CandidateProfessionalDoc";
						String dbPath = path + File.separator + fileName;
						storageService.store(mFile, path, fileName);
						masterBook.setLastNo(newDecimalValue);
						masterBookRepository.save(masterBook);

						System.out.println("FileName is " + mFile.getOriginalFilename());
						candidateProfessionalInformation.setProfessionalDoc(dbPath);
						candidateProfessionalInformation.setDocumentName(fileName);
						System.out.println("store  end ()");

					}
					fileIndex++;
					System.out.println(".while end ()");
				}

				index++;
			}

		}

		List<CandidateProfessionalInformation> candidateProfessionalInformationLists = (List<CandidateProfessionalInformation>) candidateProfessionalInformationRepository.save(candidateProfessionalInfoList);
		return candidateProfessionalInformationLists;
	}
	
}
