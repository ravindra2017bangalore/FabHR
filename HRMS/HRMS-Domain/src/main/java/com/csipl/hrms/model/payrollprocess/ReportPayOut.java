package com.csipl.hrms.model.payrollprocess;



import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.employee.Employee;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ReportPayOut database table.
 * 
 */
@Entity
@NamedQuery(name="ReportPayOut.findAll", query="SELECT r FROM ReportPayOut r")
public class ReportPayOut implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ReportPayOutPK id;

	private String aadharNo;

	private BigDecimal absense;

	private String accountNumber;

	private BigDecimal advanceBonus;

	private BigDecimal advanceBonusEarning;

	private String bankAccountNumber;

	private BigDecimal bankAmount;

	private String bankName;
	
	@Transient
	private String bankShortName;
	
	@Column(name="Basic")
	private BigDecimal basic;

	@Column(name="BasicEarning")
	private BigDecimal basicEarning;

	private BigDecimal casualleave;

	private Long cityId;

	@Column(name="CompanyBenefits")
	private BigDecimal companyBenefits;

	@Column(name="CompanyBenefitsEarning")
	private BigDecimal companyBenefitsEarning;

	private Long companyId;

	@Column(name="ConveyanceAllowance")
	private BigDecimal conveyanceAllowance;
	
	
	@Column(name="otherDeduction")
	private BigDecimal otherDeduction;

	@Column(name="ConveyanceAllowanceEarning")
	private BigDecimal conveyanceAllowanceEarning;

	@Temporal(TemporalType.DATE)
	private Date dateCreated;

	@Temporal(TemporalType.DATE)
	private Date dateOfJoining;

	@Temporal(TemporalType.DATE)
	private Date dateUpdate;

	private BigDecimal dearnessAllowance;

	private BigDecimal dearnessAllowanceEarning;

	private Long departmentId;

	@Temporal(TemporalType.DATE)
	@Column(name="DOB")
	private Date dob;

	private String email;

	private String employeeCode;

	@Temporal(TemporalType.DATE)
	private Date epfJoining;

	private BigDecimal ESI_Employee;

	private BigDecimal ESI_Employer;

	private String ESICNumber;

	private String fatherName;

	private String gender;

	@Column(name="GrossSalary")
	private BigDecimal grossSalary;

	@Column(name="HRA")
	private BigDecimal hra;

	private BigDecimal HRAEarning;

	private String husbandName;

	private String IFSCCode;

	private BigDecimal leaveTravelAllowance;

	private BigDecimal leaveTravelAllowanceEarning;

	@Column(name="Loan")
	private BigDecimal loan;

	private String maritalStatus;

	@Column(name="MedicalAllowance")
	private BigDecimal medicalAllowance;

	@Column(name="MedicalAllowanceEarning")
	private BigDecimal medicalAllowanceEarning;

	private String mobileNo;

	@Column(name="Name")
	private String name;

	@Column(name="NetPayableAmount")
	private BigDecimal netPayableAmount;

	private BigDecimal otherAllowance;

	private BigDecimal otherAllowanceEarning;

	private BigDecimal overtime;

	private BigDecimal paidleave;

	@Column(name="PANNO")
	private String panno;

	private BigDecimal payDays;
	
	private BigDecimal payableDays;

	private BigDecimal performanceLinkedIncome;

	private BigDecimal performanceLinkedIncomeEarning;

	private String PFNumber;

	private BigDecimal presense;
	
	@Column(name="ProvidentFundEmployee")
	private BigDecimal providentFundEmployee;

	@Column(name="PensionEarningSalary")
	private BigDecimal pensionEarningSalary;

	@Column(name="ProvidentFundEmployer")
	private BigDecimal providentFundEmployer;

	@Column(name="ProvidentFundEmployerPension")
	private BigDecimal providentFundEmployerPension;

	@Column(name="PT")
	private BigDecimal pt;

	private BigDecimal publicholidays;

	private BigDecimal seekleave;

	@Column(name="SpecialAllowance")
	private BigDecimal specialAllowance;

	@Column(name="SpecialAllowanceEarning")
	private BigDecimal specialAllowanceEarning;

	@Column(name="TDS")
	private BigDecimal tds;

	@Column(name="TotalDeduction")
	private BigDecimal totalDeduction;

	@Column(name="TotalEarning")
	private BigDecimal totalEarning;

	private String transactionNo;

	@Column(name="UANNO")
	private String uanno;

	private BigDecimal uniformAllowance;

	private BigDecimal uniformAllowanceEarning;

	private Long userId;

	private Long userIdUpdate;

	private BigDecimal weekoff;
	
	private String isNoPFDeduction;
	private String remarks;

	
	private String epfNominee;
	private String epfNomineeRelation;
	
	private String esicNominee;
	private String esicNomineeRelation;
	
	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId",  insertable=false, updatable=false)
	private Employee employee;
	
	@Transient
	private Long stateId;

	public ReportPayOut() {
	}

	public ReportPayOutPK getId() {
		return this.id;
	}

	public void setId(ReportPayOutPK id) {
		this.id = id;
	}

	public String getAadharNo() {
		return this.aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public BigDecimal getAbsense() {
		return this.absense;
	}

	public void setAbsense(BigDecimal absense) {
		this.absense = absense;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAdvanceBonus() {
		return this.advanceBonus;
	}

	public void setAdvanceBonus(BigDecimal advanceBonus) {
		this.advanceBonus = advanceBonus;
	}

	public BigDecimal getAdvanceBonusEarning() {
		return this.advanceBonusEarning;
	}

	public void setAdvanceBonusEarning(BigDecimal advanceBonusEarning) {
		this.advanceBonusEarning = advanceBonusEarning;
	}

	public String getBankAccountNumber() {
		return this.bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public BigDecimal getBankAmount() {
		return this.bankAmount;
	}

	public void setBankAmount(BigDecimal bankAmount) {
		this.bankAmount = bankAmount;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BigDecimal getBasic() {
		return this.basic;
	}

	public void setBasic(BigDecimal basic) {
		this.basic = basic;
	}

	public BigDecimal getBasicEarning() {
		return this.basicEarning;
	}

	public void setBasicEarning(BigDecimal basicEarning) {
		this.basicEarning = basicEarning;
	}

	public BigDecimal getCasualleave() {
		return this.casualleave;
	}

	public void setCasualleave(BigDecimal casualleave) {
		this.casualleave = casualleave;
	}

	public Long getCityId() {
		return this.cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public BigDecimal getCompanyBenefits() {
		return this.companyBenefits;
	}

	public void setCompanyBenefits(BigDecimal companyBenefits) {
		this.companyBenefits = companyBenefits;
	}

	public BigDecimal getCompanyBenefitsEarning() {
		return this.companyBenefitsEarning;
	}

	public void setCompanyBenefitsEarning(BigDecimal companyBenefitsEarning) {
		this.companyBenefitsEarning = companyBenefitsEarning;
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public BigDecimal getConveyanceAllowance() {
		return this.conveyanceAllowance;
	}

	public void setConveyanceAllowance(BigDecimal conveyanceAllowance) {
		this.conveyanceAllowance = conveyanceAllowance;
	}

	public BigDecimal getConveyanceAllowanceEarning() {
		return this.conveyanceAllowanceEarning;
	}

	public void setConveyanceAllowanceEarning(BigDecimal conveyanceAllowanceEarning) {
		this.conveyanceAllowanceEarning = conveyanceAllowanceEarning;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateOfJoining() {
		return this.dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public BigDecimal getDearnessAllowance() {
		return this.dearnessAllowance;
	}

	public void setDearnessAllowance(BigDecimal dearnessAllowance) {
		this.dearnessAllowance = dearnessAllowance;
	}

	public BigDecimal getDearnessAllowanceEarning() {
		return this.dearnessAllowanceEarning;
	}

	public void setDearnessAllowanceEarning(BigDecimal dearnessAllowanceEarning) {
		this.dearnessAllowanceEarning = dearnessAllowanceEarning;
	}

	public Long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getEpfJoining() {
		return this.epfJoining;
	}

	public void setEpfJoining(Date epfJoining) {
		this.epfJoining = epfJoining;
	}

	public BigDecimal getESI_Employee() {
		return this.ESI_Employee;
	}

	public void setESI_Employee(BigDecimal ESI_Employee) {
		this.ESI_Employee = ESI_Employee;
	}

	public BigDecimal getESI_Employer() {
		return this.ESI_Employer;
	}

	public void setESI_Employer(BigDecimal ESI_Employer) {
		this.ESI_Employer = ESI_Employer;
	}

	public String getESICNumber() {
		return this.ESICNumber;
	}

	public void setESICNumber(String ESICNumber) {
		this.ESICNumber = ESICNumber;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getGrossSalary() {
		return this.grossSalary;
	}

	public void setGrossSalary(BigDecimal grossSalary) {
		this.grossSalary = grossSalary;
	}

	public BigDecimal getHra() {
		return this.hra;
	}

	public void setHra(BigDecimal hra) {
		this.hra = hra;
	}

	public BigDecimal getHRAEarning() {
		return this.HRAEarning;
	}

	public void setHRAEarning(BigDecimal HRAEarning) {
		this.HRAEarning = HRAEarning;
	}

	public String getHusbandName() {
		return this.husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	public String getIFSCCode() {
		return this.IFSCCode;
	}

	public void setIFSCCode(String IFSCCode) {
		this.IFSCCode = IFSCCode;
	}

	public BigDecimal getLeaveTravelAllowance() {
		return this.leaveTravelAllowance;
	}

	public void setLeaveTravelAllowance(BigDecimal leaveTravelAllowance) {
		this.leaveTravelAllowance = leaveTravelAllowance;
	}

	public BigDecimal getLeaveTravelAllowanceEarning() {
		return this.leaveTravelAllowanceEarning;
	}

	public void setLeaveTravelAllowanceEarning(BigDecimal leaveTravelAllowanceEarning) {
		this.leaveTravelAllowanceEarning = leaveTravelAllowanceEarning;
	}

	public BigDecimal getLoan() {
		return this.loan;
	}

	public void setLoan(BigDecimal loan) {
		this.loan = loan;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public BigDecimal getMedicalAllowance() {
		return this.medicalAllowance;
	}

	public void setMedicalAllowance(BigDecimal medicalAllowance) {
		this.medicalAllowance = medicalAllowance;
	}

	public BigDecimal getMedicalAllowanceEarning() {
		return this.medicalAllowanceEarning;
	}

	public void setMedicalAllowanceEarning(BigDecimal medicalAllowanceEarning) {
		this.medicalAllowanceEarning = medicalAllowanceEarning;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getNetPayableAmount() {
		return this.netPayableAmount;
	}

	public void setNetPayableAmount(BigDecimal netPayableAmount) {
		this.netPayableAmount = netPayableAmount;
	}

	public BigDecimal getOtherAllowance() {
		return this.otherAllowance;
	}

	public void setOtherAllowance(BigDecimal otherAllowance) {
		this.otherAllowance = otherAllowance;
	}

	public BigDecimal getOtherAllowanceEarning() {
		return this.otherAllowanceEarning;
	}

	public void setOtherAllowanceEarning(BigDecimal otherAllowanceEarning) {
		this.otherAllowanceEarning = otherAllowanceEarning;
	}

	public BigDecimal getOvertime() {
		return this.overtime;
	}

	public void setOvertime(BigDecimal overtime) {
		this.overtime = overtime;
	}

	public BigDecimal getPaidleave() {
		return this.paidleave;
	}

	public void setPaidleave(BigDecimal paidleave) {
		this.paidleave = paidleave;
	}

	public String getPanno() {
		return this.panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public BigDecimal getPayDays() {
		return this.payDays;
	}

	public void setPayDays(BigDecimal payDays) {
		this.payDays = payDays;
	}

	public BigDecimal getPayableDays() {
		return payableDays;
	}

	public void setPayableDays(BigDecimal payableDays) {
		this.payableDays = payableDays;
	}

	public BigDecimal getPerformanceLinkedIncome() {
		return this.performanceLinkedIncome;
	}

	public void setPerformanceLinkedIncome(BigDecimal performanceLinkedIncome) {
		this.performanceLinkedIncome = performanceLinkedIncome;
	}

	public BigDecimal getPerformanceLinkedIncomeEarning() {
		return this.performanceLinkedIncomeEarning;
	}

	public void setPerformanceLinkedIncomeEarning(BigDecimal performanceLinkedIncomeEarning) {
		this.performanceLinkedIncomeEarning = performanceLinkedIncomeEarning;
	}

	public String getPFNumber() {
		return this.PFNumber;
	}

	public void setPFNumber(String PFNumber) {
		this.PFNumber = PFNumber;
	}

	public BigDecimal getPresense() {
		return this.presense;
	}

	public void setPresense(BigDecimal presense) {
		this.presense = presense;
	}

	public BigDecimal getProvidentFundEmployee() {
		return this.providentFundEmployee;
	}

	public void setProvidentFundEmployee(BigDecimal providentFundEmployee) {
		this.providentFundEmployee = providentFundEmployee;
	}

	public BigDecimal getProvidentFundEmployer() {
		return this.providentFundEmployer;
	}

	public void setProvidentFundEmployer(BigDecimal providentFundEmployer) {
		this.providentFundEmployer = providentFundEmployer;
	}

	public BigDecimal getProvidentFundEmployerPension() {
		return this.providentFundEmployerPension;
	}

	public void setProvidentFundEmployerPension(BigDecimal providentFundEmployerPension) {
		this.providentFundEmployerPension = providentFundEmployerPension;
	}

	public BigDecimal getPt() {
		return this.pt;
	}

	public void setPt(BigDecimal pt) {
		this.pt = pt;
	}

	public BigDecimal getPublicholidays() {
		return this.publicholidays;
	}

	public void setPublicholidays(BigDecimal publicholidays) {
		this.publicholidays = publicholidays;
	}

	public BigDecimal getSeekleave() {
		return this.seekleave;
	}

	public void setSeekleave(BigDecimal seekleave) {
		this.seekleave = seekleave;
	}

	public BigDecimal getSpecialAllowance() {
		return this.specialAllowance;
	}

	public void setSpecialAllowance(BigDecimal specialAllowance) {
		this.specialAllowance = specialAllowance;
	}

	public BigDecimal getSpecialAllowanceEarning() {
		return this.specialAllowanceEarning;
	}

	public void setSpecialAllowanceEarning(BigDecimal specialAllowanceEarning) {
		this.specialAllowanceEarning = specialAllowanceEarning;
	}

	public BigDecimal getTds() {
		return this.tds;
	}

	public void setTds(BigDecimal tds) {
		this.tds = tds;
	}

	public BigDecimal getTotalDeduction() {
		return this.totalDeduction;
	}

	public void setTotalDeduction(BigDecimal totalDeduction) {
		this.totalDeduction = totalDeduction;
	}

	public BigDecimal getTotalEarning() {
		return this.totalEarning;
	}

	public void setTotalEarning(BigDecimal totalEarning) {
		this.totalEarning = totalEarning;
	}

	public String getTransactionNo() {
		return this.transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getUanno() {
		return this.uanno;
	}

	public void setUanno(String uanno) {
		this.uanno = uanno;
	}

	public BigDecimal getUniformAllowance() {
		return this.uniformAllowance;
	}

	public void setUniformAllowance(BigDecimal uniformAllowance) {
		this.uniformAllowance = uniformAllowance;
	}

	public BigDecimal getUniformAllowanceEarning() {
		return this.uniformAllowanceEarning;
	}

	public void setUniformAllowanceEarning(BigDecimal uniformAllowanceEarning) {
		this.uniformAllowanceEarning = uniformAllowanceEarning;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(Long userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

	public BigDecimal getWeekoff() {
		return this.weekoff;
	}

	public void setWeekoff(BigDecimal weekoff) {
		this.weekoff = weekoff;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getBankShortName() {
		return bankShortName;
	}

	public void setBankShortName(String bankShortName) {
		this.bankShortName = bankShortName;
	}



	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public BigDecimal getPensionEarningSalary() {
		return pensionEarningSalary;
	}

	public void setPensionEarningSalary(BigDecimal pensionEarningSalary) {
		this.pensionEarningSalary = pensionEarningSalary;
	}

	public BigDecimal getOtherDeduction() {
		return otherDeduction;
	}

	public void setOtherDeduction(BigDecimal otherDeduction) {
		this.otherDeduction = otherDeduction;
	}

	public String getIsNoPFDeduction() {
		return isNoPFDeduction;
	}

	public void setIsNoPFDeduction(String isNoPFDeduction) {
		this.isNoPFDeduction = isNoPFDeduction;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getEpfNominee() {
		return epfNominee;
	}

	public void setEpfNominee(String epfNominee) {
		this.epfNominee = epfNominee;
	}

	public String getEpfNomineeRelation() {
		return epfNomineeRelation;
	}

	public void setEpfNomineeRelation(String epfNomineeRelation) {
		this.epfNomineeRelation = epfNomineeRelation;
	}

	public String getEsicNominee() {
		return esicNominee;
	}

	public void setEsicNominee(String esicNominee) {
		this.esicNominee = esicNominee;
	}

	public String getEsicNomineeRelation() {
		return esicNomineeRelation;
	}

	public void setEsicNomineeRelation(String esicNomineeRelation) {
		this.esicNomineeRelation = esicNomineeRelation;
	}

	

}