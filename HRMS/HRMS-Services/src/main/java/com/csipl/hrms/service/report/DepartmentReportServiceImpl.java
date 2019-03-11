package com.csipl.hrms.service.report;



import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.csipl.hrms.dto.report.DepartmentReportDTO;
import com.csipl.hrms.service.report.repository.DepartmentReportRepository;
import com.csipl.hrms.service.util.ConverterUtil;

@Service("departmentReportService")
public class DepartmentReportServiceImpl implements DepartmentReportService {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentReportServiceImpl.class);

	@Autowired
	private DepartmentReportRepository departmentReportRepository;
	@Override
	public List<DepartmentReportDTO> departmentWiseCTC(Long companyId,Long p_process_month) {
		// TODO Auto-generated method stub
		List<Object[]>  empReportList  = departmentReportRepository.fetchDepartmentWiseCTCList(companyId,p_process_month);
		List<DepartmentReportDTO> departmentReportDTO = new ArrayList<DepartmentReportDTO>();
	
					
				 for ( Object[] report : empReportList ) { 
					DepartmentReportDTO deptDto = new DepartmentReportDTO();
					if(ConverterUtil.getString( report[0])!=null) {
						deptDto.setDeptNAME(ConverterUtil.getString( report[0]));
					}
                    if(ConverterUtil.getString( report[1])!=null) {
                    	 deptDto.setDeptCTC(ConverterUtil.getString( report[1]));
					}
					 
					 
					 System.out.println("========deptDto.getDeptCTC()==================="+deptDto.getDeptCTC()   );
					 System.out.println("==========deptDto.getDeptNAME() ================="+ deptDto.getDeptNAME() );
					 
					 departmentReportDTO.add(deptDto);
					
					
					
				}	
		
		return departmentReportDTO ;
		
	
	}
	
	
	@Override
	public String processmonthbyLastmonth(Long companyId,Long p_process_month) {
		// TODO Auto-generated method stub
	
		Object  empReportList  = departmentReportRepository.processmonthbyLastmonth(companyId,p_process_month);
		       if((String)empReportList!=null) {
		    	   String processMonth=(String)empReportList;
		    	   System.out.println("======service======="+processMonth);
		    	   return processMonth;
		       }
			
		
		return null ;
		
	
	}
	
	@Override
	public List<DepartmentReportDTO> LastSixMonthCTC(Long companyId ,Long p_process_month) {
		// TODO Auto-generated method stub
		List<Object[]>  dptReportList  = departmentReportRepository.fetchLastSixMonthCTC(companyId,p_process_month);
		List<DepartmentReportDTO> departmentReportDTO = new ArrayList<DepartmentReportDTO>();
	
					
				 for ( Object[] report : dptReportList ) { 
					DepartmentReportDTO deptDto = new DepartmentReportDTO();
					if(ConverterUtil.getString( report[0])!=null) {
						 deptDto.setLastMonth(ConverterUtil.getString( report[0]));	
					}
					if(ConverterUtil.getString( report[1])!=null) {
						 deptDto.setDeptCTC(ConverterUtil.getString( report[1]));
					}
					
					
					 departmentReportDTO.add(deptDto);
					 System.out.println("========strored==================="+ConverterUtil.getString( report[0]));
					 System.out.println("==========strored================="+ConverterUtil.getString( report[1]));
					
					
				}	
		
		return departmentReportDTO ;
	}

}
