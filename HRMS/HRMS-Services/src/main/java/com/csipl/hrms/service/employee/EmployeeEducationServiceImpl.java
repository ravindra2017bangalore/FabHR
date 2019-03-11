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

import com.csipl.hrms.model.employee.EmployeeEducation;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.model.payroll.Gratuaty;
import com.csipl.hrms.service.employee.repository.EmployeeEducationRepository;
import com.csipl.hrms.service.employee.repository.MasterBookRepository;
import com.csipl.hrms.service.organization.StorageService;

@Service("eduInformationService")
public class EmployeeEducationServiceImpl implements EmployeeEducationService {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeEducationServiceImpl.class);

	@Autowired
	  private EmployeeEducationRepository eduInformationRepository;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	private MasterBookRepository masterBookRepository;
	/**
	 * Method performed save OR update operation  
 	 */
 	@Override
	public List<EmployeeEducation> save(List<EmployeeEducation> employeeEducationList,HttpServletRequest request) {
 		
 		System.out.println("CnadidateEducationServiceImpl.save()"+employeeEducationList.size());
		MultipartHttpServletRequest multiPartRequest = new DefaultMultipartHttpServletRequest(request);
		
		multiPartRequest = (MultipartHttpServletRequest) request;
		multiPartRequest.getParameterMap();

		String bookCode = "EMPNO";
		//
		int index = 0;
		int count = 0;
		for (EmployeeEducation employeeEdu : employeeEducationList) {
			Iterator<String> itr = multiPartRequest.getFileNames();
			System.out.println("----employeeEdu.getDesignName() :::;::" + employeeEdu.getDocumentName());
			if (employeeEdu.getDocumentName() != null && !("").equals(employeeEdu.getDocumentName())) {
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
						employeeEdu.setEmployeeEducationDoc(dbPath);
						employeeEdu.setDocumentName(fileName);
						System.out.println("store  end ()");
						
					}
					fileIndex++;
					System.out.println(".while end ()");
				}
				
				index++;
			} 			
		}	
 		logger.info("employeeEducationList is ===== "+employeeEducationList);
 		List<EmployeeEducation> employeeEducationInfos = (List<EmployeeEducation>) eduInformationRepository.save(employeeEducationList); 
		return employeeEducationInfos;
 	
	}
 	/**
	 * to get List of EmployeeEducation from database based on employeeId
	 */
 	@Override
	public List<EmployeeEducation> findAllEduInformation(Long empId) {
 		logger.info("findAllEduInformation is ===== "+empId);
  		return  eduInformationRepository.findAllEmployeeEducations(empId);
  }
 	/**
	 * delete EmployeeEducation object from database based on educationId (Primary Key)
	 */
	@Override
	public void delete(Long eduId) {
		eduInformationRepository.delete(eduId);
		
	}
	@Override
	public List<EmployeeEducation> saveEducation(List<EmployeeEducation> employeeEducationList) {
		logger.info("employeeEducationList is ===== "+employeeEducationList);
 		List<EmployeeEducation> employeeEducationInfos = (List<EmployeeEducation>) eduInformationRepository.save(employeeEducationList); 
		return employeeEducationInfos;
	}
}
