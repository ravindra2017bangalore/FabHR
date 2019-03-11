package com.csipl.hrms.service.employee;

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

import com.csipl.hrms.model.candidate.CandidateProfessionalInformation;
import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.model.employee.ProfessionalInformation;
import com.csipl.hrms.service.employee.repository.MasterBookRepository;
import com.csipl.hrms.service.employee.repository.ProfessionalInformationRepository;
import com.csipl.hrms.service.organization.StorageService;

@Service("professionalInformationService")
public class ProfessionalInformationServiceImpl implements ProfessionalInformationService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProfessionalInformationServiceImpl.class);

	@Autowired
	private ProfessionalInformationRepository professionalInformationRepository;
	@Autowired
	EmployeeSkillService employeeSkillService;
	@Autowired
	StorageService storageService;
	@Autowired
	private MasterBookRepository masterBookRepository;

	/**
	 * to get List of ProfessionalInformation from database based on employeeId
	 */
	@Override
	public List<ProfessionalInformation> findAllProfessionalInformation(String EmployeeId) {
		Long employeeId = Long.parseLong(EmployeeId);
		return professionalInformationRepository.findAllProfessionalInformation(employeeId);
	}

	/**
	 * Method performed save OR update operation
	 */
	@Override
	public List<ProfessionalInformation> saveAll(List<ProfessionalInformation> professionalInformationList) {
		List<ProfessionalInformation> professionalInfos = (List<ProfessionalInformation>) professionalInformationRepository
				.save(professionalInformationList);
		return professionalInfos;
	}

	/**
	 * delete ProfessionalInformation object from database based on historyId
	 * (Primary Key)
	 */
	@Override
	public void delete(Long historyId) {
		professionalInformationRepository.delete(historyId);
	}

	@Override
	public List<ProfessionalInformation> saveCandidateProfessionalInfo(
			List<ProfessionalInformation> professionalInformationList, List<EmployeeSkill> employeeSkillList) {

		List<ProfessionalInformation> professionalInfoList = (List<ProfessionalInformation>) professionalInformationRepository
				.save(professionalInformationList);
		return professionalInfoList;

	}

	@Override
	public List<ProfessionalInformation> save(List<ProfessionalInformation> professionalInformationList,
			HttpServletRequest req) {

		MultipartHttpServletRequest multiPartRequest = new DefaultMultipartHttpServletRequest(req);
		multiPartRequest = (MultipartHttpServletRequest) req;
		String bookCode = "EMPNO";
		//
		int index = 0;
		for (ProfessionalInformation professionalInformation : professionalInformationList) {
			Iterator<String> itr = multiPartRequest.getFileNames();
			System.out.println("----designDocument.getDesignName() :::;::" + professionalInformation.getDocumentName());
			if (professionalInformation.getDocumentName() != null
					&& !("").equals(professionalInformation.getDocumentName())) {
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

						String path = File.separator + "Document" + File.separator + "Employee" + File.separator
								+ "EmployeeProfessionalDoc";
						String dbPath = path + File.separator + fileName;
						storageService.store(mFile, path, fileName);
						masterBook.setLastNo(newDecimalValue);
						masterBookRepository.save(masterBook);

						System.out.println("FileName is " + mFile.getOriginalFilename());
						professionalInformation.setProfessionalDoc(dbPath);
						professionalInformation.setDocumentName(fileName);
						System.out.println("store  end ()");

					}
					fileIndex++;
					System.out.println(".while end ()");
				}

				index++;
			}
		}
		List<ProfessionalInformation> empProfessionalInformationList = (List<ProfessionalInformation>) professionalInformationRepository
				.save(professionalInformationList);
		return empProfessionalInformationList;
	}

}
