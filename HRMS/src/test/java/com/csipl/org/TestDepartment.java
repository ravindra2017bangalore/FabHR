package com.csipl.org;
import java.util.*;
import com.csipl.hrms.model.organisation.*;
import com.csipl.hrms.service.organization.*;

public class TestDepartment 
{
	
	DepartmentService service;
	
	 TreeSet<Long> departmentids=new TreeSet<Long>();
	 
	TestDepartment(DepartmentService service) 
	{
		this.service=service;
	}
	public int FindAllDepartmentSize(long i)
	{
		return service.findAllDepartment(i).size();
	}
	
	public TreeSet<Long> GetDeptId(long i)
	{
		List<Department> d=service.findAllDepartment(i);
		//List<Department> h=new ArrayList<Department>();
				for(Department dr:d)
				{
					System.out.println("getting department id");
					System.out.println("department id is "+dr.getDepartmentId());
					departmentids.add(dr.getDepartmentId());
				}
			return departmentids;
	}
	
	
}
