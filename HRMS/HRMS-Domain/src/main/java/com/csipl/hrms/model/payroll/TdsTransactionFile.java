package com.csipl.hrms.model.payroll;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;
import com.csipl.hrms.model.employee.Employee;

import java.util.Date;


/**
 * The persistent class for the TdsTransactionFile database table.
 * 
 */
@Entity
@NamedQuery(name="TdsTransactionFile.findAll", query="SELECT t FROM TdsTransactionFile t")
public class TdsTransactionFile extends BaseModelWithoutCG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TdsTransactionFileId")
	private Long tdsTransactionFileId;

	private String fileName;

	private String filePath;

	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	public TdsTransactionFile() {
	}

	public Long getTdsTransactionFileId() {
		return tdsTransactionFileId;
	}

	public void setTdsTransactionFileId(Long tdsTransactionFileId) {
		this.tdsTransactionFileId = tdsTransactionFileId;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
