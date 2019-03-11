package com.csipl.hrms.service.payroll;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.dto.payroll.ProvisionDTO;
import com.csipl.hrms.model.payroll.Provision;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.service.payroll.repository.ProvisionRepository;
import com.csipl.hrms.service.payroll.repository.ReportPayOutRepository;

@Service("provisionService")
public class ProvisionServiceImpl  implements ProvisionService {
	@Autowired
	private ProvisionRepository provisionRepository;
	@Autowired
	private ReportPayOutRepository reportPayOutRepository;
	
	@PersistenceContext(unitName = "mySQL")
	@Autowired
	private EntityManager em;
	private static final Logger logger = LoggerFactory.getLogger(ProvisionServiceImpl.class);

	@Override
	public Provision save(Provision provision) {
		
		return	provisionRepository.save(provision);
	}

	@Override
	public  List<Object[]> findAllProvision(Long companyId) {
		// TODO Auto-generated method stub
		return provisionRepository.findAllProvision(companyId);
	}

	@Override
	public Provision findProvision(Long provisionId) {
		// TODO Auto-generated method stub
		return provisionRepository.findProvision(provisionId);
	}
	
	@Override
	public List<Object[]> findAllProvisionforFNF(Long companyId ,List<ProvisionDTO> provisionDtoList) {
		List<Object[]> objectList= new ArrayList<>();
		for (ProvisionDTO provisionDTO : provisionDtoList) {
		
		objectList.addAll(provisionRepository.findAllProvisionForFNF(provisionDTO.getEmployeeId(),provisionDTO.getProcessMonth() ));
		
		}
		
		return objectList;
	}
	@Override
	public void saveProvisionSeletment(Provision provision, ReportPayOut reportPayOut) {
		// TODO Auto-generated method stub
		provisionRepository.save(provision);
		
		 reportPayOutRepository.save(reportPayOut);
	}


}
