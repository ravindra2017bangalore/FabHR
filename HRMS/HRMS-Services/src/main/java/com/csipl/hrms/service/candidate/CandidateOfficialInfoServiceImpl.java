package com.csipl.hrms.service.candidate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csipl.hrms.common.util.ErrorHandling;
import com.csipl.hrms.model.candidate.Candidate;
import com.csipl.hrms.model.candidate.CandidateEducation;
import com.csipl.hrms.model.candidate.CandidateFamily;
import com.csipl.hrms.model.candidate.CandidateIdProof;
import com.csipl.hrms.model.candidate.CandidateOfficialInformation;
import com.csipl.hrms.model.candidate.CandidatePersonal;
import com.csipl.hrms.model.candidate.CandidateProfessionalInformation;
import com.csipl.hrms.model.candidate.CandidateSkill;
import com.csipl.hrms.model.candidate.CandidateStatuary;
import com.csipl.hrms.model.employee.EmpCommonDetail;
import com.csipl.hrms.model.employee.Employee;
import com.csipl.hrms.model.employee.EmployeeBank;
import com.csipl.hrms.model.employee.EmployeeEducation;
import com.csipl.hrms.model.employee.EmployeeFamily;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.model.employee.EmployeeSkill;
import com.csipl.hrms.model.employee.EmployeeStatuary;
import com.csipl.hrms.model.employee.ProfessionalInformation;
import com.csipl.hrms.service.candidate.adaptor.CandidateToEmployeeConversionAdaptor;
import com.csipl.hrms.service.candidate.adaptor.EmpCommonDetailsAdaptor;
import com.csipl.hrms.service.candidate.repository.CandidateOfficialInfoRepository;
import com.csipl.hrms.service.candidate.repository.CandidatePersonalRepository;
import com.csipl.hrms.service.candidate.repository.CandidateRepository;
import com.csipl.hrms.service.employee.BankDetailsService;
import com.csipl.hrms.service.employee.EmployeeEducationService;
import com.csipl.hrms.service.employee.EmployeeIdProofService;
import com.csipl.hrms.service.employee.EmployeePersonalInformationService;
import com.csipl.hrms.service.employee.EmployeeSkillService;
import com.csipl.hrms.service.employee.EmployeeStatuaryService;
import com.csipl.hrms.service.employee.FamilyService;
import com.csipl.hrms.service.employee.ProfessionalInformationService;



@Transactional
@Service("officialInfoService")
public class CandidateOfficialInfoServiceImpl implements CandidateOfficialInfoService {

	@Autowired
	CandidateRepository candidateRepository;
	@Autowired
	CandidateOfficialInfoRepository candidateOfficialInfoRepository;
	@Autowired
	CandidatePersonalRepository candidatePersonalRepository;
	@Autowired
	EmployeePersonalInformationService employeePersonalInformationService;
	@Autowired
	EmployeeIdProofService employeeIdProofService;
	@Autowired
	CandidateIdAddressService candidateIdAddressService;
	@Autowired
	CandidateProfessionalInformationService candidateProfessionalInformationService;
	@Autowired
	ProfessionalInformationService professionalInformationService;
	@Autowired
	CandidateEducationService candidateEducationService;
	@Autowired
	EmployeeEducationService employeeEducationService;
	@Autowired
	CandidateFamilyService candidateFamilyService;
	@Autowired
	FamilyService familyService;
	@Autowired
	CandidateSkillService candidateSkillService;
	@Autowired
	EmployeeSkillService employeeSkillService;
	@Autowired
	EmployeeStatuaryService employeeStatuaryService;
	@Autowired
	CandidateStatuaryService candidateStatuaryService;
	@Autowired
	BankDetailsService bankDetailsService;
	@Autowired
	EmpCommonDetailsService empCommonDetailService;

	@Override
	public CandidateOfficialInformation save(CandidateOfficialInformation candidateOfficialInformation,
			HttpServletRequest request) throws ErrorHandling {
		
		Long employeeId = 0l;
		// HttpServletRequest request = null;
		CandidateOfficialInformation candidateOfficialInfo = candidateOfficialInfoRepository
				.save(candidateOfficialInformation);
		if (candidateOfficialInfo != null) {
			Long userId = candidateOfficialInfo.getUserId();
			Long candidateId = candidateOfficialInfo.getCandidate().getCandidateId();
			CandidateToEmployeeConversionAdaptor candidateToEmployeeConversionAdaptor = new CandidateToEmployeeConversionAdaptor();
			Candidate candidate = candidateRepository.findOne(candidateId);
			candidate.setCandidateStatus("OB");
			candidateRepository.save(candidate);

			/*
			 * CandidatePersonal To Employee convert
			 * 
			 */

			CandidatePersonal candidatePersonal = candidatePersonalRepository.findCandidatePersonal(candidateId);
			// List<CandidateSkill> candidateSkillList =
			// candidateSkillService.getCandidateSkill(candidateId);
			Employee employee = candidateToEmployeeConversionAdaptor.candidateInfoToEmployeeInfoConversion(candidate,
					candidateOfficialInfo, candidatePersonal);
			Employee employeeObj = employeePersonalInformationService.save(employee, null, false);
			
			/*
			 * Employee common detail transform
			 * 
			 */
			EmpCommonDetailsAdaptor empCommonDetailAdaptor = new EmpCommonDetailsAdaptor();
			EmpCommonDetail empCommonDetail = empCommonDetailAdaptor.employeeToEmpCommonDetail(employeeObj);
			empCommonDetailService.save(empCommonDetail);

			/*
			 * 
			 * CandidateIdProof To EmployeeIdProof convert
			 * 
			 */

			employeeId = employeeObj.getEmployeeId();
			List<CandidateIdProof> candidateIdProofList = candidateIdAddressService
					.findAllCandidateIdProofs(candidateId);
			List<EmployeeIdProof> employeeIdProofList = candidateToEmployeeConversionAdaptor
					.candidateIdProofToEmployeeIdProofConversion(candidateIdProofList, candidateOfficialInfo,
							employeeId, userId);
			employeeIdProofService.saveEmployeeIdProof(employeeIdProofList);

			/*
			 * CandidateProfessionalInformation To ProfessionalInformation convert
			 * 
			 */

			List<CandidateProfessionalInformation> candidateProfessionalInformationList = candidateProfessionalInformationService
					.getAllCandidateProfessionalInformation(candidateId);
			List<ProfessionalInformation> employeeProfessionalInformation = candidateToEmployeeConversionAdaptor
					.candidateProfessionalInfoToEmployeeProfessionalInfoConversion(candidateProfessionalInformationList,
							candidateOfficialInfo, employeeId, userId);
			professionalInformationService.saveAll(employeeProfessionalInformation);

			/*
			 * CandidateEducation To EmployeeEducation convert
			 * 
			 */

			List<CandidateEducation> candidateEducationList = candidateEducationService
					.findAllEduInformation(candidateId);
			List<EmployeeEducation> employeeEducationList = candidateToEmployeeConversionAdaptor
					.candidateEducationToEmployeeEducationConversion(candidateEducationList, candidateOfficialInfo,
							employeeId, userId);
			employeeEducationService.saveEducation(employeeEducationList);

			/*
			 * CandidateFamily To EmployeeFamily convert
			 * 
			 */

			List<CandidateFamily> candidateFamilyList = candidateFamilyService.findAllFamilyList(candidateId);
			List<EmployeeFamily> employeeFamilyList = candidateToEmployeeConversionAdaptor
					.candidateFamilyToEmployeeFamilyConversion(candidateFamilyList, candidateOfficialInfo, employeeId,
							userId);
			familyService.saveAll(employeeFamilyList);

			/*
			 * CandidateSkill To EmployeeSkill convert
			 * 
			 */

			List<CandidateSkill> candidateSkillList = candidateSkillService.getCandidateSkill(candidateId);
			List<EmployeeSkill> employeeSkillList = candidateToEmployeeConversionAdaptor
					.candidateSkillToEmployeeSkillconversion(candidateSkillList, candidateOfficialInfo, employeeId,
							userId);
			System.out.println("Skill Size -" + employeeSkillList.size() + "------" + employeeSkillList.toString());
			employeeSkillService.save(employeeSkillList);

			/*
			 * CandidateStatuary To EmployeeStatuary convert
			 * 
			 */

			List<EmployeeStatuary> employeeStatuaryList = candidateToEmployeeConversionAdaptor
					.candidateStatouryToEmployeeStatuory(candidateOfficialInfo, employeeId);
			employeeStatuaryService.save(employeeStatuaryList, employeeId);

			/*
			 * CandidateStatuary To EmployeeBank convert
			 * 
			 */
			CandidateStatuary candidateStatuary = candidateStatuaryService.findCandidateStatuary(candidateId);
			EmployeeBank employeeBank = candidateToEmployeeConversionAdaptor
					.candidateBankToEmployeeBankConversion(candidateStatuary, employeeId, userId);
			bankDetailsService.save(employeeBank);
		}
		candidateOfficialInfo.setEmployeeId(employeeId);
		return candidateOfficialInfo;
	}

	@Override
	public CandidateOfficialInformation findCandidateOfficialInformation(Long candidateId) {

		return candidateOfficialInfoRepository.findCandidateOfficialInformation(candidateId);
	}

}
