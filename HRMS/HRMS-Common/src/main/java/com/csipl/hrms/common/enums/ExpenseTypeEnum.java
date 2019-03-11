package com.csipl.hrms.common.enums;

public enum ExpenseTypeEnum {
	Direct("D"), Indirect("I");

	private String expenseType;

	ExpenseTypeEnum(String expenseType) {
		this.expenseType = expenseType;
		
	}

	public String getExpenseType() {
		return expenseType;
	}

	public static ExpenseTypeEnum parse(String expenseType) {

		for (ExpenseTypeEnum type : ExpenseTypeEnum.values()) {
			if (type.getExpenseType().equals(expenseType)) {
				return type;
			}
		}
		throw new IllegalArgumentException("The ExpenseTypeEnum is unknown");
	}

}
