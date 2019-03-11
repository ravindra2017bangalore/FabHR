package com.csipl.org;
import java.util.List;
import java.util.TreeSet;
import com.csipl.hrms.service.organization.*;
import com.csipl.hrms.model.organisation.*;

public class TestDesignation {
	DesignationService designationService;
	TreeSet<Long> designationids=new TreeSet<Long>();
	
	TestDesignation(DesignationService designationService) 
	{
		this.designationService=designationService;
	}

	public TreeSet<Long> GetDesId(long j)
	{
		
		List<Designation> des=designationService.findAllDesignation(j);
		for(Designation ds:des)
		{
			System.out.println("designation id"+ds.getDesignationId());
			designationids.add(ds.getDesignationId());
		}
		return designationids;
	}
	
}
