package com.csipl.hrms.common.enums;

public enum DropDownEnum {
	
	SelectIdType( 1, "SelectIdType" ),
	Category( 2, "Category" ),
	Qualification( 3, "Qualification" ),
	EmploymentType( 4, "EmploymentType" ),
	MaritalStatus( 5, "MaritalStatus" ),
	BloodGroup( 6, "BloodGroup" ),
	Relation( 7, "Relation" ),
	Captions( 8, "Captions" ),
	Status( 9, "Status" ),
	earningDeduction( 10, "EarningDeduction"),
	AccountType( 11, "AccountType" ),
	Statuary(12, "Statuary" ),
	ItemUnit(13, "ItemUnit" ),
	BankName(14, "BankName"),
	Occupation(15 , "Occupation"),
	RegularCorrespondence(17, "RegularCorrespondence"),
	LoanType(18, "LoanType"),
	Gender(19, "Gender"),
	ConfirmOptions(20, "ConfirmOptions"),
	incomeType(21, "IncomeType"),
	expense(22, "Expense"),
	processMonthFlag(23, "ProcessMonthFlag"),
	Degree(24,"Degree"),
    Categories(25, "Categories"),
	MandatoryInfo(27,"MandatoryInfo"),
	ReasonForChange(36,"ReasonForChange"),
	ResignationReason(26,"ResignationReason"),
	ARCategory(34,"ARCategory"),
	Title(31,"Title");
	public int drowpdownId;
	public String dropDownName;
	
	

	DropDownEnum ( int drowpdownId, String dropDownName  ) {
		this.drowpdownId = drowpdownId;
		this.dropDownName = dropDownName;
	}

	public int getDrowpdownId() {
		return drowpdownId;
	}
	
	public String getDropDownName() {
		return dropDownName;
	}

}
