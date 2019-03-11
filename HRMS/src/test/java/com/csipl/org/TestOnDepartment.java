/*package com.csipl.org;
import com.csipl.hrms.service.organization.*;
import com.csipl.hrms.model.organisation.*;
import static org.junit.Assert.*;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;
import java.util.*;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class TestOnDepartment {
	
		 DepartmentService service=Mockito.mock(DepartmentService.class);
		 TestDepartment sample1=null;
		 List<Department> deptList=new ArrayList<Department>();
		 Department department1=new Department();
		 Department department2=new Department();
		 public TestOnDepartment() 
		 {
			sample1=new TestDepartment(service);
		 }
		 
		@org.junit.Before
		 public void setup()
		 {
			department1.setDepartmentId(786l);
			department1.setDepartmentName("operations");
			deptList.add(department1);
			
			department2.setDepartmentId(787l);
			department2.setDepartmentName(" it operations");
			deptList.add(department2);
		 }
		
	@Test
	public void test() {
		
		
		 when(service.findAllDepartment(1l)).thenReturn(deptList);
		 assertEquals(sample1.FindAllDepartmentSize(1l),2);
	}
	
	@Test
	public void TestDeptidNotNull()
	{
		when(service.findAllDepartment(1l)).thenReturn(deptList);
		assertNotNull(sample1.GetDeptId(1l));
	}
	
	

}
*/