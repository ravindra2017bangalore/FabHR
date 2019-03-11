package com.csipl.hrms.employee.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csipl.hrms.dto.candidate.CandidateIdProofDTO;
import com.csipl.hrms.dto.employee.EmployeeIdProofDTO;
import com.csipl.hrms.model.candidate.CandidateIdProof;
import com.csipl.hrms.model.employee.EmployeeIdProof;
import com.csipl.hrms.service.adaptor.EmpIdProofAdaptor;
import com.csipl.hrms.service.employee.EmployeeIdProofService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/employeeIdProof")
public class EmpIdAddresaProofController {
	/**
	 * Logger declaration for knowing the flow of execution for debugging
	 */
	private static final Logger logger = LoggerFactory.getLogger(EmpEducationController.class);
	@Autowired
	EmployeeIdProofService employeeIdProofService;
	
	EmpIdProofAdaptor empIdProofAdaptor = new EmpIdProofAdaptor();
	
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved CandidateIdAddress"),
			@ApiResponse(code = 401, message = "You are not authorized to save or update CandidateIdAddress"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	/**
	 * @param candidateIdProofDto
	 *            This is the first parameter for getting shift Object from UI
	 */
	@ApiOperation(value = "Save or Update CandidateIdAddress")
	@PostMapping(value = "/file/{employeeId}")
	public List<CandidateIdProofDTO> saveEmployeeIdProof(@PathVariable("employeeId") String employeeId,HttpServletRequest req) throws Exception{
		
		logger.info("saveCandidateIdProof is calling : " + "canId : " + employeeId + " : List<CandidateIdProofDTO>  "
				+ req.getParameter("fileInfo"));
		
		Long empId = Long.parseLong(employeeId);
		System.out.println("hitting uploadFiles");
		List documentList = new ArrayList<>();
		List<CandidateIdProofDTO> idProoflist = new ArrayList<>();
		JSONArray jsonArray = new JSONArray(req.getParameter("fileInfo"));
		Set<Integer> index = new HashSet<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < jsonArray.length(); i++) {
			CandidateIdProofDTO candidateIdDto = new CandidateIdProofDTO();
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			candidateIdDto.setIdNumber(jsonObj.getString("idNumber"));
			candidateIdDto.setIdTypeId(jsonObj.getString("idTypeId"));
			candidateIdDto.setUserId(jsonObj.getLong("userId"));
			candidateIdDto.setCompanyId(jsonObj.getLong("companyId"));
			//candidateIdDto.setCompanyId(jsonObj.getLong("companyId"));
			if(jsonObj.getString("dateFrom").contains("T"))
			candidateIdDto.setDateFrom(sdf.parse(jsonObj.getString("dateFrom")));
			else
				candidateIdDto.setDateFrom(dateformat.parse(jsonObj.getString("dateFrom")));	
			System.out.println(jsonObj.getString("toDate"));
			if ( !(("").equals(jsonObj.getString("toDate")))&&jsonObj.getString("toDate") != null) {
				String dateTo = jsonObj.getString("toDate");
				if(dateTo.contains("T"))
					candidateIdDto.setDateTo(sdf.parse(dateTo));
					else
						candidateIdDto.setDateTo(dateformat.parse(dateTo));	
			}
			if (jsonObj.has("candidateIdProofsId")) {
			
				candidateIdDto.setCandidateIdProofsId(Long.valueOf(jsonObj.optInt("candidateIdProofsId")));
			}

		
			if (jsonObj.has("documentFile")) {
				String s1 = jsonObj.getString("documentFile");
				System.out.println(s1 + "=====");
				// if (s1.isEmpty() && s1.length() == 0) {
				// docIndexArray[i] = i;
				// } else {
				candidateIdDto.setDocumentName(s1);
				candidateIdDto.setDocIndex(i);

				// }
	}else if(jsonObj.has("idProofDoc") && jsonObj.has("documentName")) {
        
		candidateIdDto.setIdProofDoc(jsonObj.getString("idProofDoc"));
		candidateIdDto.setDocumentName(jsonObj.getString("documentName"));

}
			// logger.info("=============================================Len " +
			// Arrays.toString(docIndexArray));
			logger.info(
					"=============================================Length of set   " + Arrays.toString(index.toArray()));
			idProoflist.add(candidateIdDto);

			// dto.setDocumentFile(jsonObj.getJSONObject("documentFile").get(name));

			// documentListDto.add((DesignDocumentDTO) documentList.get(i));
			logger.info("DocumentName " + candidateIdDto.getDocumentName());
		}
		
		List<EmployeeIdProof> candidateIdProofList =empIdProofAdaptor
		.candidateIdProofDtoToDatabaseModelList(idProoflist, empId);
		
		
		List<EmployeeIdProof> candidateIdProofListResult = employeeIdProofService.save(candidateIdProofList,req);
		logger.info("saveCandidateIdProof is end  :" + "candidateIdProofListResult" + candidateIdProofListResult);
		return empIdProofAdaptor.databaseModelToUiDtoList(candidateIdProofListResult);
	}
	
	/**
	 * to get List of EmployeeIdProof from database based on employeeId
	 */
	@RequestMapping(value="/{employeeId}", method = RequestMethod.GET)
	public @ResponseBody List<CandidateIdProofDTO> findEmpIdProofs(@PathVariable("employeeId") String employeeId,
			HttpServletRequest req) {
		logger.info("findEmpIdProofs is calling :" + "employeeId" + employeeId);
		Long empIdProofId = Long.parseLong(employeeId);
		return empIdProofAdaptor
				.databaseModelToUiDtoList(employeeIdProofService.findAllemployeeIdProofs(empIdProofId));

	}
}
