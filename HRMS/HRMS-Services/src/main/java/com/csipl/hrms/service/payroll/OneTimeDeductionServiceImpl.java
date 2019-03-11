package com.csipl.hrms.service.payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.model.payroll.OneTimeDeduction;
import com.csipl.hrms.service.payroll.repository.OneTimeDeductionRepository;

@Service("oneTimeDeductionService")
public class OneTimeDeductionServiceImpl implements OneTimeDeductionService {

	@Autowired
	private OneTimeDeductionRepository oneTimeDeductionRepository;

	@Override
	public void save(OneTimeDeduction oneTimeDeduction) {
		oneTimeDeduction.setIsDeduction("N");
 		oneTimeDeductionRepository.save(oneTimeDeduction);
	}

	@Override
	public List<Object[]> getAllOneTimeDeduction(Long companyId) {
		return oneTimeDeductionRepository.findAllOneTimeDeductionList(companyId);
	}

	@Override
	public void saveOneTimeDeductionBulk(List<OneTimeDeduction> oneTimeDeductionList) {
		oneTimeDeductionList.forEach(oneTimeDeduction->{
			oneTimeDeduction.setIsDeduction("N");
		});
		oneTimeDeductionRepository.save(oneTimeDeductionList);
	}

	@Override
	public List<OneTimeDeduction> findOneTimeDeductionForEmployee(Long employeeId, String deductionMonth) {
		return oneTimeDeductionRepository.findOneTimeDeductionForEmployee(employeeId, deductionMonth);
	}
}
