package com.hrms.org.payrollprocess.tds;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.payroll.TdsApproved;
import com.csipl.hrms.model.payroll.TdsSlab;
import com.csipl.hrms.model.payroll.TdsSlabHd;

public class InvestmentTest {

	public static void main(String[] args) {
		InvestmentTax investment = new InvestmentTax();
		
		PayStructureHd payStructureHd = new PayStructureHd();
		BigDecimal gross = new BigDecimal(15000000);	
		payStructureHd.setGrossPay(gross);
		
		TdsSlabHd tdsSlabHd = new TdsSlabHd();
		
		
		List< TdsSlab > tdsSlabs = new ArrayList< TdsSlab >();
		
		TdsSlab slab = new TdsSlab();
		slab.setLimitFrom( new BigDecimal(0));
		slab.setLimitTo( new BigDecimal( 2500000));
		slab.setTdsPercentage( null);
		tdsSlabs.add( slab );
		
		
		TdsSlab slab2 = new TdsSlab();
		slab2.setLimitFrom( new BigDecimal( 2500000 ));
		slab2.setLimitTo( new BigDecimal( 5000000));
		slab2.setTdsPercentage(  new BigDecimal( 5) );
		tdsSlabs.add( slab2 );
		
		
		TdsSlab slab3 = new TdsSlab();
		slab3.setLimitFrom( new BigDecimal( 5000000 ));
		slab3.setLimitTo( new BigDecimal( 10000000));
		slab3.setTdsPercentage(  new BigDecimal( 20 ) );
		tdsSlabs.add( slab3 );
		
		
		
		
		TdsSlab slab4 = new TdsSlab();
		slab4.setLimitFrom( new BigDecimal( 10000000 ));
		//slab4.setLimitTo( new BigDecimal( 10000000));
		slab4.setTdsPercentage(  new BigDecimal( 30 ) );
		tdsSlabs.add( slab4 );
		tdsSlabHd.setTdsSlabs(tdsSlabs);
		
		
		List<TdsApproved>   tdsApprovedList = new ArrayList<TdsApproved>();
		TdsApproved tdsApproved = new TdsApproved();
		tdsApproved.setApprovedAmount( new BigDecimal( 1500000 ) );
		tdsApprovedList.add( tdsApproved );
		
		TdsApproved tdsApproved2 = new TdsApproved();
		tdsApproved2.setApprovedAmount( new BigDecimal( 2500000 ) );
		tdsApprovedList.add( tdsApproved2 );
		
	//	investment.calculateEmployeeIvestment(payStructureHd, tdsSlabHd, tdsApprovedList, 1L, "");
	}
}
