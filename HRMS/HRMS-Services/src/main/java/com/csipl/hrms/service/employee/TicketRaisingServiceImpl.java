package com.csipl.hrms.service.employee;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csipl.hrms.common.util.DateUtils;
import com.csipl.hrms.common.util.HrmsGlobalConstantUtil;
import com.csipl.hrms.model.employee.MasterBook;
import com.csipl.hrms.model.employee.TicketDesc;
import com.csipl.hrms.model.employee.TicketRaisingHD;
import com.csipl.hrms.service.employee.repository.MasterBookRepository;
import com.csipl.hrms.service.employee.repository.TicketRaisingRepository;
import com.csipl.hrms.service.organization.StorageService;


@Service("ticketRaisingService")
public class TicketRaisingServiceImpl implements TicketRaisingService{
	private static final Logger logger = LoggerFactory.getLogger(TicketRaisingServiceImpl.class);
	DateUtils dateUtils=new DateUtils();
	String currentDate=dateUtils.getCurrentDateTime();
	Date currentDate1=dateUtils.getCurrentDate();

	@Autowired
	private TicketRaisingRepository ticketRaisingRepository;
	
	@Autowired
	private MasterBookRepository masterBookRepository;
	
	@Autowired
	StorageService storageService;
	/**
	 * Method performed save OR update operation
	 */
	@Override
	public TicketRaisingHD save(TicketRaisingHD ticketRaisingHD1, MultipartFile file, boolean fileFlag, Long companyId) {
		String bookCode = "TICNO";
		String fileName = "";
	if(ticketRaisingHD1.getTicketNo()==null) {
		System.out.println("ticketRaisingHD1.getTicketNo()"+ticketRaisingHD1.getTicketNo());
		MasterBook masterBook = masterBookRepository.findMasterBook(companyId, bookCode);
		BigDecimal lastNumberValue;
		lastNumberValue = masterBook.getLastNo();
		long longValue;
		longValue = lastNumberValue.longValue() + 1;
		BigDecimal newDecimalValue = new BigDecimal(longValue);
		ticketRaisingHD1.setTicketNo(masterBook.getPrefixBook() + newDecimalValue);
		masterBook.setLastNo(newDecimalValue);
		
	}
		System.out.println("----"+ticketRaisingHD1.getCompany().getCompanyId());
		TicketRaisingHD ticketRaisingHD= ticketRaisingRepository.save(ticketRaisingHD1);
		
		//file saving code
		if(ticketRaisingHD.getTicketDescs()!=null && ticketRaisingHD.getTicketDescs().size()>0 && fileFlag) {
		TicketDesc ticketDesc =ticketRaisingHD.getTicketDescs().get(ticketRaisingHD.getTicketDescs().size()-1);
	    String ticketNum = ticketRaisingHD.getTicketNo();
	   
		fileName = ticketNum.substring(1) +"_"+ticketDesc.getTicketDescId();
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		fileName = fileName + "." + extension;
		System.out.println("File with extension : " + fileName);	
		String path = File.separator + "images" + File.separator + "myServiceImages";
		String dbPath = path + File.separator + fileName;
		System.out.println("dbPath " +dbPath);
		ticketDesc.setFileLocation(dbPath);
		ticketDesc.setFileExtension(extension);
		TicketRaisingHD ticketRaisingHd= ticketRaisingRepository.save(ticketRaisingHD);
		storageService.store(file, path, fileName);
		return ticketRaisingHd;
		}
		
		return ticketRaisingHD;
		
	}
	/**
	 * to get List of TicketRaisingHds from database based on companyId
	 */
	@Override
	public List<TicketRaisingHD> findAllTicketRaising(Long companyId) {
 		return ticketRaisingRepository.findAllTicketRaising(companyId);
	}
	
	/**
	 * to get TicketRaisingHd Object from database based on ticketRaisingHdId (Primary Key)
	 */
	@Override
	public TicketRaisingHD findTicketRaising( Long ticketRaisingHDId) {
 		return ticketRaisingRepository.findTicketRaising(ticketRaisingHDId);
	}
	/**
	 * to get List of TicketRaisingHds from database based on employeeId
	 */
	@Override
	public List<TicketRaisingHD> findAllEmpTicketRaising(Long employeeId) {
 		return ticketRaisingRepository.findAllEmpTicketRaising(employeeId);
	}
	@Override
	public List<TicketRaisingHD> findAllTicketRaisingOpen(Long companyId) {
		Timestamp ts= dateUtils.getCurrentDateWithTimestamp(currentDate);
 		return ticketRaisingRepository.findAllTicketRaisingOpen(companyId,HrmsGlobalConstantUtil.TICKET_STATUS_OPEN,ts);
	}
	
}
