package com.csipl.hrms.model.employee;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.common.Language;


/**
 * The persistent class for the EmployeeLanguage database table.
 * 
 */
@Entity
@NamedQuery(name="EmployeeLanguage.findAll", query="SELECT e FROM EmployeeLanguage e")
public class EmployeeLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeLanguageId;

	private String langRead;

	private String langSpeak;

	private String langWrite;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="languageId")
	private Language language;

	public EmployeeLanguage() {
	}

	public Long getEmployeeLanguageId() {
		return this.employeeLanguageId;
	}

	public void setEmployeeLanguageId(Long employeeLanguageId) {
		this.employeeLanguageId = employeeLanguageId;
	}

	public String getLangRead() {
		return this.langRead;
	}

	public void setLangRead(String langRead) {
		this.langRead = langRead;
	}

	public String getLangSpeak() {
		return this.langSpeak;
	}

	public void setLangSpeak(String langSpeak) {
		this.langSpeak = langSpeak;
	}

	public String getLangWrite() {
		return this.langWrite;
	}

	public void setLangWrite(String langWrite) {
		this.langWrite = langWrite;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}
