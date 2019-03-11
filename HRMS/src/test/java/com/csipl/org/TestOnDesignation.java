/*package com.csipl.org;
import com.csipl.hrms.service.organization.*;
import com.csipl.hrms.model.organisation.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.csipl.hrms.service.organization.DesignationService;
@RunWith(MockitoJUnitRunner.class)
public class TestOnDesignation {

	DesignationService designationService=Mockito.mock(DesignationService.class);
	TestDesignation sample2=null;
	List<Designation> designation=new ArrayList<Designation>();
	Designation designation1=new Designation();
	Designation designation2=new Designation();
	
	public TestOnDesignation() 
	{
		sample2=new TestDesignation(designationService);
	}
	 
	 @Before
	 public void setup()
	 {
		 designation1.setDesignationId(123l);
		 designation1.setDesignationName("senior software developer");
		 designation2.setDesignationId(125l);
		 designation2.setDesignationName("software developer");
		 designation.add(designation1);
		 designation.add(designation2);
		 
	 }
	@Test
	public void TestDesignationidNotNull() 
	{
		when(designationService.findAllDesignation(1l)).thenReturn(designation);
		assertNotNull(sample2.GetDesId(1l));
	}

}
*/