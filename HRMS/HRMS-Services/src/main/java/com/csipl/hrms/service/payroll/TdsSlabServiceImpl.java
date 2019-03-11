package com.csipl.hrms.service.payroll;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.csipl.hrms.common.enums.ActiveStatusEnum;
import com.csipl.hrms.model.payroll.TdsSlabHd;
 import com.csipl.hrms.service.payroll.repository.TdsSlabRepository;

@Service("tdsSlabService")
public class TdsSlabServiceImpl implements TdsSlabService {

	@Autowired
	private TdsSlabRepository tdsSlabRepository;
 
	/**
	 * Save OR update tdsSlabHd data into database
	 */
	@Override
	public TdsSlabHd save(TdsSlabHd tdsSlabHd) {
  		return tdsSlabRepository.save(tdsSlabHd);
	}
	/**
	 * to get List of TdsSlabHd objects from database based on companyId
	 */
	@Override
	public List<TdsSlabHd> getAllTdsSlabHd(Long companyId) {
 		return tdsSlabRepository.findAllTdsSlabList(companyId  );
	}
	/**
	 * to get TdsSlabHd object from database based on tdsSlabHdId(Primary Key)
	 */

	@Override
	public TdsSlabHd getTdsSlabHd(Long tdsSlabHdId) {
		return tdsSlabRepository.findOne(tdsSlabHdId);
 	}
  }
