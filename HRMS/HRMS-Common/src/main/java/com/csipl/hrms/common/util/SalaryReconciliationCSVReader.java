package com.csipl.hrms.common.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.aop.ThrowsAdvice;

import com.csipl.hrms.common.exception.PayRollProcessException;
import com.csipl.hrms.model.payrollprocess.ReportPayOut;
import com.csipl.hrms.model.payrollprocess.ReportPayOutPK;

public class SalaryReconciliationCSVReader {

	
	
	/* * Method to read CSV file using CSVParser from Apache Commons CSV */ 
	//Name,Employee Code,Account Number,Net Amount,Transaction No

	public static  void parseCSV(File file , List<ReportPayOut> report,List<ReportPayOut> reportSave,HashMap<String,ReportPayOut> mapEmpWithReport,List<String>listempwithAccountCSV,List<String>listEmpCode,List<String> listNotTransCode,Long userIdUpdate) throws FileNotFoundException, IOException{
	
		try {
		CSVParser parser = new CSVParser(new FileReader(file), CSVFormat.DEFAULT.withHeader()); 
	
		for (CSVRecord record : parser)  { 
			    System.out.printf("%s\t%s\t%s\n",record.get("Employee Code").trim(),record.get("Name").trim(), record.get("Net Amount").trim(), record.get("Transaction No").trim(), record.get("Account Number").trim()); //
				
				if(record.get("Employee Code")!=null ||!("").equals(record.get("Employee Code")))
					listEmpCode.add(record.get("Employee Code").trim());
				else
					throw new PayRollProcessException("Employee Code should not be empty");
				
				if(record.get("Transaction No")==null || record.get("Transaction No").equals("")) {
                	System.out.println("ashish");
                	listNotTransCode.add(record.get("Employee Code").trim()+"#"+record.get("Transaction No").trim());
                }
				
				if(record.get("Account Number")==null || record.get("Account Number").equals("")) {
					throw new PayRollProcessException("Bank Account Number should not be empty");
                }
				else
                	listempwithAccountCSV.add(record.get("Employee Code").trim()+"#"+record.get("Account Number").trim());
			    
			    if(record.get("Employee Code").trim().equals(mapEmpWithReport.get(record.get("Employee Code")).getEmployeeCode())) {
			    	
			    	mapEmpWithReport.get(record.get("Employee Code")).setUserIdUpdate(userIdUpdate);
			    	mapEmpWithReport.get(record.get("Employee Code")).setDateUpdate(new DateUtils().getCurrentDate());
			    	mapEmpWithReport.get(record.get("Employee Code")).setTransactionNo(record.get("Transaction No").trim());
			    	reportSave.add(mapEmpWithReport.get(record.get("Employee Code")));
				         
			    }
			   
			
				} 
		       
	        	parser.close();
		
			
	}catch( Exception ex) {
		ex.printStackTrace();
	}

}

	
}
