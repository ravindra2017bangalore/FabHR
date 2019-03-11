package com.csipl.hrms.common.util;

import java.util.Comparator;

import com.csipl.hrms.model.employee.Employee;

class EmpCodeSortUtil implements Comparator {
	public int compare(Object o1, Object o2) {
		Employee s1 = (Employee) o1;
		Employee s2 = (Employee) o2;
		return s1.getEmployeeCode().compareTo(s2.getEmployeeCode());
	}
}