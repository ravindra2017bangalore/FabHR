package com.csipl.hrms.service.adaptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csipl.common.services.dropdown.DropDownCache;
import com.csipl.hrms.common.enums.DropDownEnum;
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.dto.organisation.AddressDTO;

public class EmployeeReportAdaptor {

	public List<EmployeeDTO> databaseModelToObjectArray(List<Object[]> objectEmployeeList) {
		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();

		for (Object[] report : objectEmployeeList) {
			EmployeeDTO employeeDto = new EmployeeDTO();
			AddressDTO addressDto = new AddressDTO();
			String employeeCode = report[0] != null ? (String) report[0] : null;
			String firstName = report[1] != null ? (String) report[1] : null;
			String middleName = report[2] != null ? (String) report[2] : null;
			String lastName = report[3] != null ? (String) report[3] : null;
			Date dob = report[4] != null ? (Date) report[4] : null;
			String gender = report[5] != null ? (String) report[5] : null;
			String maritalStatus = report[6] != null ? (String) report[6] : null;
			String addressText = report[7] != null ? (String) report[7] : null;
			String landmark = report[8] != null ? (String) report[8] : null;
			String empAddrsCountryName = report[9] != null ? (String) report[9] : null;
			String empAddrsStateName = report[10] != null ? (String) report[10] : null;
			String empAddrsCityName = report[11] != null ? (String) report[11] : null;
			String pincode = report[12] != null ? (String) report[12] : null;
			String mobile = report[13] != null ? (String) report[13] : null;
			String telephone = report[14] != null ? (String) report[14] : null;
			String emailId = report[15] != null ? (String) report[15] : null;
			String empStateName = report[16] != null ? (String) (report[16]) : null;
			String empCityName = report[17] != null ? (String) (report[17]) : null;
			String bloodGroup = report[18] != null ? (String) report[18] : null;
			Long probationDays = report[19] != null ? Long.parseLong(report[19].toString()) : null;
			String empType = report[20] != null ? (String) report[20] : null;
			String departmentName = report[21] != null ? (String) report[21] : null;
			String designationName = report[22] != null ? (String) report[22] : null;
			Date contractOverDate = report[23] != null ? (Date) report[23] : null;
			String referenceName = report[24] != null ? (String) report[24] : null;
			Date dateOfJoining = report[25] != null ? (Date) report[25] : null;
 			String accountType = report[26] != null ? (String) report[26] : null;
			String bankId = report[27] != null ? (String) report[27] : null;
			String accountNumber = report[28] != null ? (String) report[28] : null;
			String ifscCode = report[29] != null ? (String) report[29] : null;
 			String idType = report[30] != null ? (String) report[30] : null;
			String idNumber = report[31] != null ? (String) report[31] : null;
			String statuaryType = report[32] != null ? (String) report[32] : null;
			String statuaryNumber = report[33] != null ? (String) report[33] : null;
 			String payHeadId = report[34] != null ? (String) report[34] : null;
			String payHeadAmount = report[35] != null ? (String) report[35] : null;
   			String[] idTypeParts = null, idNumberParts = null, statuaryTypeParts = null, statuaryNumberParts = null,
					payHeadIdParts = null, payHeadAmountParts = null;

			if (idType != null)
				idTypeParts = idType.split(",");
			if (idNumber != null)
				idNumberParts = idNumber.split(",");
			if (statuaryType != null)
				statuaryTypeParts = statuaryType.split(",");
			if (statuaryNumber != null)
				statuaryNumberParts = statuaryNumber.split(",");
			if (payHeadId != null)
				payHeadIdParts = payHeadId.split(",");
			if (payHeadAmount != null)
				payHeadAmountParts = payHeadAmount.split(",");

			String typePart1 = null;
			String typePart2 = null;
			String typePart3 = null;
			String typePart4 = null;
			String typePart5 = null;
			String numberPart1 = null;
			String numberPart2 = null;
			String numberPart3 = null;
			String numberPart4 = null;
			String numberPart5 = null;

			String statuaryTypePart1 = null;
			String statuaryTypePart2 = null;
			String statuaryTypePart3 = null;
			String statuaryTypePart4 = null;
			String statuaryTypePart5 = null;
			String statuaryNumberPart1 = null;
			String statuaryNumberPart2 = null;
			String statuaryNumberPart3 = null;
			String statuaryNumberPart4 = null;
			String statuaryNumberPart5 = null;

			String payHeadIdPart1 = null;
			String payHeadIdPart2 = null;
			String payHeadIdPart3 = null;
			String payHeadIdPart4 = null;
			String payHeadIdPart5 = null;
			String payHeadIdPart6 = null;
			String payHeadIdPart7 = null;
			String payHeadIdPart8 = null;
			String payHeadIdPart9 = null;
			String payHeadIdPart10 = null;
			String payHeadIdPart11 = null;

			String payHeadNumberPart1 = null;
			String payHeadNumberPart2 = null;
			String payHeadNumberPart3 = null;
			String payHeadNumberPart4 = null;
			String payHeadNumberPart5 = null;
			String payHeadNumberPart6 = null;
			String payHeadNumberPart7 = null;
			String payHeadNumberPart8 = null;
			String payHeadNumberPart9 = null;
			String payHeadNumberPart10 = null;
			String payHeadNumberPart11 = null;

			try {
				if (idTypeParts[0] != null)
					typePart1 = idTypeParts[0];
				if (idTypeParts[1] != null)
					typePart2 = idTypeParts[1];
				if (idTypeParts[2] != null)
					typePart3 = idTypeParts[2];
				if (idTypeParts[3] != null)
					typePart4 = idTypeParts[3];
				if (idTypeParts[4] != null)
					typePart5 = idTypeParts[4];
			} catch (ArrayIndexOutOfBoundsException e) {
			} catch (NullPointerException mpe) {
			}
			try {
				numberPart1 = idNumberParts[0];
				numberPart2 = idNumberParts[1];
				numberPart3 = idNumberParts[2];
				numberPart4 = idNumberParts[3];
				numberPart5 = idNumberParts[4];

			} catch (ArrayIndexOutOfBoundsException e) {
			} catch (NullPointerException mpe) {
			}
			try {
				if (statuaryTypeParts[0] != null)
					statuaryTypePart1 = statuaryTypeParts[0];
				if (statuaryTypeParts[1] != null)
					statuaryTypePart2 = statuaryTypeParts[1];
				if (statuaryTypeParts[2] != null)
					statuaryTypePart3 = statuaryTypeParts[2];
				if (statuaryTypeParts[3] != null)
					statuaryTypePart4 = statuaryTypeParts[3];
				if (statuaryTypeParts[4] != null)
					statuaryTypePart5 = statuaryTypeParts[4];

			} catch (ArrayIndexOutOfBoundsException e) {
			} catch (NullPointerException mpe) {
			}

			try {
				if (statuaryNumberParts[0] != null)
					statuaryNumberPart1 = statuaryNumberParts[0];
				if (statuaryNumberParts[1] != null)
					statuaryNumberPart2 = statuaryNumberParts[1];
				if (statuaryNumberParts[2] != null)
					statuaryNumberPart3 = statuaryNumberParts[2];
				if (statuaryNumberParts[3] != null)
					statuaryNumberPart4 = statuaryNumberParts[3];
				if (statuaryNumberParts[4] != null)
					statuaryNumberPart5 = statuaryNumberParts[4];

			} catch (ArrayIndexOutOfBoundsException e) {
			} catch (NullPointerException mpe) {
			}

			try {
				if (payHeadIdParts[0] != null)
					payHeadIdPart1 = payHeadIdParts[0];
				if (payHeadIdParts[1] != null)
					payHeadIdPart2 = payHeadIdParts[1];
				if (payHeadIdParts[2] != null)
					payHeadIdPart3 = payHeadIdParts[2];
				if (payHeadIdParts[3] != null)
					payHeadIdPart4 = payHeadIdParts[3];
				if (payHeadIdParts[4] != null)
					payHeadIdPart5 = payHeadIdParts[4];
				if (payHeadIdParts[5] != null)
					payHeadIdPart6 = payHeadIdParts[5];
				if (payHeadIdParts[6] != null)
					payHeadIdPart7 = payHeadIdParts[6];
				if (payHeadIdParts[7] != null)
					payHeadIdPart8 = payHeadIdParts[7];
				if (payHeadIdParts[8] != null)
					payHeadIdPart9 = payHeadIdParts[8];
				if (payHeadIdParts[9] != null)
					payHeadIdPart10 = payHeadIdParts[9];
				if (payHeadIdParts[10] != null)
					payHeadIdPart11 = payHeadIdParts[10];
			} catch (ArrayIndexOutOfBoundsException e) {
			} catch (NullPointerException mpe) {
			}
			try {
				if (payHeadAmountParts[0] != null)
					payHeadNumberPart1 = payHeadAmountParts[0];
				if (payHeadAmountParts[1] != null)
					payHeadNumberPart2 = payHeadAmountParts[1];
				if (payHeadAmountParts[2] != null)
					payHeadNumberPart3 = payHeadAmountParts[2];
				if (payHeadAmountParts[3] != null)
					payHeadNumberPart4 = payHeadAmountParts[3];
				if (payHeadAmountParts[4] != null)
					payHeadNumberPart5 = payHeadAmountParts[4];
				if (payHeadAmountParts[5] != null)
					payHeadNumberPart6 = payHeadAmountParts[5];
				if (payHeadAmountParts[6] != null)
					payHeadNumberPart7 = payHeadAmountParts[6];
				if (payHeadAmountParts[7] != null)
					payHeadNumberPart8 = payHeadAmountParts[7];
				if (payHeadAmountParts[8] != null)
					payHeadNumberPart9 = payHeadAmountParts[8];
				if (payHeadAmountParts[9] != null)
					payHeadNumberPart10 = payHeadAmountParts[9];
				if (payHeadAmountParts[10] != null)
					payHeadNumberPart11 = payHeadAmountParts[10];
			} catch (ArrayIndexOutOfBoundsException e) {
			} catch (NullPointerException mpe) {
			}

			String aadhar = null;
			String pan = null;

			if (typePart1 != null && typePart1.equals("AA")) {
				aadhar = numberPart1;

			} else if (typePart2 != null && typePart2.equals("AA")) {
				aadhar = numberPart2;

			} else if (typePart3 != null && typePart3.equals("AA")) {
				aadhar = numberPart3;

			} else if (typePart4 != null && typePart4.equals("AA")) {
				aadhar = numberPart4;

			} else if (typePart5 != null && typePart5.equals("AA")) {
				aadhar = numberPart5;

			}
			if (typePart2 != null && typePart1.equals("PA")) {
				pan = numberPart1;
			} else if (typePart2 != null && typePart2.equals("PA")) {
				pan = numberPart2;

			} else if (typePart3 != null && typePart3.equals("PA")) {
				pan = numberPart3;

			} else if (typePart4 != null && typePart4.equals("PA")) {
				pan = numberPart4;

			} else if (typePart5 != null && typePart5.equals("PA")) {
				pan = numberPart5;

			}
			if (aadhar != null) {
				employeeDto.setAadharNumber(aadhar);

			}
			if (pan != null) {
				employeeDto.setPan(pan);
			}
			String empPFNumber = null;
			String empUANumber = null;
			String empESINumber = null;

			if (statuaryTypePart1 != null && statuaryTypePart1.equals("PF")) {
				empPFNumber = statuaryNumberPart1;
			} else if (statuaryTypePart2 != null && statuaryTypePart2.equals("PF")) {
				empPFNumber = statuaryNumberPart2;
			} else if (statuaryTypePart3 != null && statuaryTypePart3.equals("PF")) {
				empPFNumber = statuaryNumberPart3;
			} else if (statuaryTypePart4 != null && statuaryTypePart4.equals("PF")) {
				empPFNumber = statuaryNumberPart4;
			} else if (statuaryTypePart5 != null && statuaryTypePart5.equals("PF")) {
				empPFNumber = statuaryNumberPart5;
			}

			if (statuaryTypePart1 != null && statuaryTypePart1.equals("UA")) {
				empUANumber = statuaryNumberPart1;

			} else if (statuaryTypePart2 != null && statuaryTypePart2.equals("UA")) {
				empUANumber = statuaryNumberPart2;

			} else if (statuaryTypePart3 != null && statuaryTypePart3.equals("UA")) {
				empUANumber = statuaryNumberPart3;

			} else if (statuaryTypePart4 != null && statuaryTypePart4.equals("UA")) {
				empUANumber = statuaryNumberPart4;

			} else if (statuaryTypePart5 != null && statuaryTypePart5.equals("UA")) {
				empUANumber = statuaryNumberPart5;
			}
			if (statuaryTypePart1 != null && statuaryTypePart1.equals("ES")) {
				empESINumber = statuaryNumberPart1;

			} else if (statuaryTypePart2 != null && statuaryTypePart2.equals("ES")) {
				empESINumber = statuaryNumberPart2;

			} else if (statuaryTypePart3 != null && statuaryTypePart3.equals("ES")) {
				empESINumber = statuaryNumberPart3;

			} else if (statuaryTypePart4 != null && statuaryTypePart4.equals("ES")) {
				empESINumber = statuaryNumberPart4;

			} else if (statuaryTypePart5 != null && statuaryTypePart5.equals("ES")) {
				empESINumber = statuaryNumberPart5;
			}

			if (empPFNumber != null) {
				employeeDto.setEmpPFNumber(empPFNumber);
			}
			if (empUANumber != null) {
				employeeDto.setUanNumber(empUANumber);
			}
			if (empESINumber != null) {
				employeeDto.setEmpESINumber(empESINumber);
			}
			String basicSalary = null;
			String dearnessAllowance = null;
			String houseRentAllowance = null;
			String conveyanceAllowance = null;
			String specialAllowance = null;
			String medicalAllowance = null;
			String advanceBonus = null;
			String performanceLinkedIncome = null;
			String companyBenefits = null;
			String leaveTravelAllowance = null;
			String uniformAllowance = null;

			if (payHeadIdPart1 != null && payHeadIdPart1.equals("1")) {
				basicSalary = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("1")) {
				basicSalary = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("1")) {
				basicSalary = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("1")) {
				basicSalary = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("1")) {
				basicSalary = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("1")) {
				basicSalary = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("1")) {
				basicSalary = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("1")) {
				basicSalary = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("1")) {
				basicSalary = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("1")) {
				basicSalary = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("1")) {
				basicSalary = payHeadNumberPart11;
			}

			if (payHeadIdPart1 != null && payHeadIdPart1.equals("2")) {
				dearnessAllowance = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("2")) {
				dearnessAllowance = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("2")) {
				dearnessAllowance = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("2")) {
				dearnessAllowance = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("2")) {
				dearnessAllowance = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("2")) {
				dearnessAllowance = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("2")) {
				dearnessAllowance = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("2")) {
				dearnessAllowance = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("2")) {
				dearnessAllowance = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("2")) {
				dearnessAllowance = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("2")) {
				dearnessAllowance = payHeadNumberPart11;
			}

			if (payHeadIdPart1 != null && payHeadIdPart1.equals("3")) {
				houseRentAllowance = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("3")) {
				houseRentAllowance = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("3")) {
				houseRentAllowance = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("3")) {
				houseRentAllowance = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("3")) {
				houseRentAllowance = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("3")) {
				houseRentAllowance = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("3")) {
				houseRentAllowance = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("3")) {
				houseRentAllowance = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("3")) {
				houseRentAllowance = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("3")) {
				houseRentAllowance = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("3")) {
				houseRentAllowance = payHeadNumberPart11;
			}

			if (payHeadIdPart1 != null && payHeadIdPart1.equals("4")) {
				conveyanceAllowance = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("4")) {
				conveyanceAllowance = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("4")) {
				conveyanceAllowance = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("4")) {
				conveyanceAllowance = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("4")) {
				conveyanceAllowance = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("4")) {
				conveyanceAllowance = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("4")) {
				conveyanceAllowance = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("4")) {
				conveyanceAllowance = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("4")) {
				conveyanceAllowance = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("4")) {
				conveyanceAllowance = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("4")) {
				conveyanceAllowance = payHeadNumberPart11;
			}

			if (payHeadIdPart1 != null && payHeadIdPart1.equals("5")) {
				specialAllowance = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("5")) {
				specialAllowance = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("5")) {
				specialAllowance = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("5")) {
				specialAllowance = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("5")) {
				specialAllowance = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("5")) {
				specialAllowance = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("5")) {
				specialAllowance = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("5")) {
				specialAllowance = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("5")) {
				specialAllowance = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("5")) {
				specialAllowance = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("5")) {
				specialAllowance = payHeadNumberPart11;
			}
			if (payHeadIdPart1 != null && payHeadIdPart1.equals("6")) {
				medicalAllowance = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("6")) {
				medicalAllowance = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("6")) {
				medicalAllowance = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("6")) {
				medicalAllowance = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("6")) {
				medicalAllowance = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("6")) {
				medicalAllowance = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("6")) {
				medicalAllowance = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("6")) {
				medicalAllowance = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("6")) {
				medicalAllowance = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("6")) {
				medicalAllowance = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("6")) {
				medicalAllowance = payHeadNumberPart11;
			}
			if (payHeadIdPart1 != null && payHeadIdPart1.equals("7")) {
				advanceBonus = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("7")) {
				advanceBonus = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("7")) {
				advanceBonus = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("7")) {
				advanceBonus = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("7")) {
				advanceBonus = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("7")) {
				advanceBonus = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("7")) {
				advanceBonus = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("7")) {
				advanceBonus = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("7")) {
				advanceBonus = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("7")) {
				advanceBonus = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("7")) {
				advanceBonus = payHeadNumberPart11;
			}

			if (payHeadIdPart1 != null && payHeadIdPart1.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("8")) {
				performanceLinkedIncome = payHeadNumberPart11;
			}
			if (payHeadIdPart1 != null && payHeadIdPart1.equals("9")) {
				companyBenefits = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("9")) {
				companyBenefits = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("9")) {
				companyBenefits = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("9")) {
				companyBenefits = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("9")) {
				companyBenefits = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("9")) {
				companyBenefits = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("9")) {
				companyBenefits = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("9")) {
				companyBenefits = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("9")) {
				companyBenefits = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("9")) {
				companyBenefits = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("9")) {
				companyBenefits = payHeadNumberPart11;
			}

			if (payHeadIdPart1 != null && payHeadIdPart1.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("10")) {
				leaveTravelAllowance = payHeadNumberPart11;
			}
			if (payHeadIdPart1 != null && payHeadIdPart1.equals("11")) {
				uniformAllowance = payHeadNumberPart1;
			} else if (payHeadIdPart2 != null && payHeadIdPart2.equals("11")) {
				uniformAllowance = payHeadNumberPart2;
			} else if (payHeadIdPart3 != null && payHeadIdPart3.equals("11")) {
				uniformAllowance = payHeadNumberPart3;
			} else if (payHeadIdPart4 != null && payHeadIdPart4.equals("11")) {
				uniformAllowance = payHeadNumberPart4;
			} else if (payHeadIdPart5 != null && payHeadIdPart5.equals("11")) {
				uniformAllowance = payHeadNumberPart5;
			} else if (payHeadIdPart6 != null && payHeadIdPart6.equals("11")) {
				uniformAllowance = payHeadNumberPart6;
			} else if (payHeadIdPart7 != null && payHeadIdPart7.equals("11")) {
				uniformAllowance = payHeadNumberPart7;
			} else if (payHeadIdPart8 != null && payHeadIdPart8.equals("11")) {
				uniformAllowance = payHeadNumberPart8;
			} else if (payHeadIdPart9 != null && payHeadIdPart9.equals("11")) {
				uniformAllowance = payHeadNumberPart9;
			} else if (payHeadIdPart10 != null && payHeadIdPart10.equals("11")) {
				uniformAllowance = payHeadNumberPart10;
			} else if (payHeadIdPart11 != null && payHeadIdPart11.equals("11")) {
				uniformAllowance = payHeadNumberPart11;
			}
			employeeDto.setEmployeeCode(employeeCode);
			employeeDto.setFirstName(firstName);
			employeeDto.setMiddleName(middleName);
			employeeDto.setLastName(lastName);
			employeeDto.setDateOfBirth(dob);
			//employeeDto.setGender(gender);
 			employeeDto.setGender(DropDownCache.getInstance().getDropDownValue(DropDownEnum.Gender.getDropDownName(),gender));

			employeeDto.setDateOfJoining(dateOfJoining);
			employeeDto.setMaritalStatus(maritalStatus);
 			employeeDto.setMaritalStatus(DropDownCache.getInstance().getDropDownValue(DropDownEnum.MaritalStatus.getDropDownName(),maritalStatus));

			employeeDto.setStateName(empStateName);
			employeeDto.setCityName(empCityName);
			employeeDto.setBloodGroup(bloodGroup);
			employeeDto.setProbationDays(probationDays);
			
		//	employeeDto.setEmpType(empType);
 			employeeDto.setEmpType(DropDownCache.getInstance().getDropDownValue(DropDownEnum.EmploymentType.getDropDownName(),empType));

			employeeDto.setDepartmentName(departmentName);
			employeeDto.setDesignationName(designationName);
			employeeDto.setContractOverDate(contractOverDate);
			employeeDto.setReferenceName(referenceName);
			employeeDto.setDateOfJoining(dateOfJoining);
			addressDto.setAddressText(addressText);
			addressDto.setLandmark(landmark);
			addressDto.setCountryName(empAddrsCountryName);
			addressDto.setStateName(empAddrsStateName);
			addressDto.setCityName(empAddrsCityName);
			addressDto.setPincode(pincode);
			addressDto.setMobile(mobile);
			addressDto.setTelephone(telephone);
			addressDto.setEmailId(emailId);
			employeeDto.setAddress1(addressDto);
			employeeDto.setAccountNumber(accountNumber);
			//employeeDto.setBankId(bankId);
 			employeeDto.setBankId(DropDownCache.getInstance().getDropDownValue(DropDownEnum.BankName.getDropDownName(),bankId));

			employeeDto.setIfscCode(ifscCode);
			//employeeDto.setAccountType(accountType);
			employeeDto.setAccountType(DropDownCache.getInstance().getDropDownValue(DropDownEnum.AccountType.getDropDownName(), accountType));

			employeeDto.setBasicSalary(basicSalary);
			employeeDto.setDearnessAllowance(dearnessAllowance);
			employeeDto.setHouseRentAllowance(houseRentAllowance);
			employeeDto.setConveyanceAllowance(conveyanceAllowance);
			employeeDto.setSpecialAllowance(specialAllowance);
			employeeDto.setMedicalAllowance(medicalAllowance);
			employeeDto.setAdvanceBonus(advanceBonus);
			employeeDto.setPerformanceLinkedIncome(performanceLinkedIncome);
			employeeDto.setCompanyBenefits(companyBenefits);
			employeeDto.setLeaveTravelAllowance(leaveTravelAllowance);
			employeeDto.setUniformAllowance(uniformAllowance);
			employeeDtoList.add(employeeDto);

		}

		return employeeDtoList;
	}
}
