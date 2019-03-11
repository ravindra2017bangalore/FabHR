package com.csipl.hrms.common.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

import com.csipl.hrms.common.enums.StandardEarningEnum;

import com.csipl.hrms.dto.employee.BankDetailsDTO;
import com.csipl.hrms.dto.employee.EmployeeDTO;
import com.csipl.hrms.dto.employee.EmployeeIdProofDTO;
import com.csipl.hrms.dto.employee.EmployeeStatuaryDTO;
import com.csipl.hrms.dto.employee.PayStructureDTO;
import com.csipl.hrms.dto.employee.PayStructureHdDTO;
import com.csipl.hrms.dto.organisation.AddressDTO;
import com.csipl.hrms.model.common.City;

import com.csipl.hrms.model.organisation.Designation;

public class EmpUploadUtil {

	public EmpUploadUtil() {
	}

	public static final BigDecimal Min_Gross_Salary_G1 = new BigDecimal(5000);
	public static final BigDecimal Max_Gross_Salary_G1 = new BigDecimal(35000);
	public static final BigDecimal Min_Gross_Salary_G2 = new BigDecimal(35001);
	public static final BigDecimal Max_Gross_Salary_G2 = new BigDecimal(80000);
	public static final BigDecimal Min_Gross_Salary_G3 = new BigDecimal(80001);

	public static final int Employee_Code = 0;
	public static final int First_Name = 1;
	public static final int Middle_Name = 2;
	public static final int Last_Name = 3;
	public static final int DOB = 4;
	public static final int Gender = 5;
	public static final int Gender_ID = 6;
	public static final int Marital_Status = 7;
	public static final int Marital_ID = 8;

	public static final int Present_Address_AddressText = 9;
	public static final int Present_Address_Landmark = 10;
	public static final int Present_Address_Country = 11;
	public static final int Present_Address_State = 12;
	public static final int Present_Address_State_ID = 13;
	public static final int Present_Address_City = 14;
	public static final int Present_Address_City_ID = 15;
	public static final int Present_Address_Pin_Code = 16;
	public static final int Present_Address_Mobile_No = 17;
	public static final int Present_Address_Telephone = 18;
	public static final int Present_Address_Email = 19;

	public static final int Permanent_Address_AddressText = 20;
	public static final int Permanent_Address_Landmark = 21;
	public static final int Permanent_Address_Country = 22;
	public static final int Permanent_Address_State = 23;
	public static final int Permanent_Address_State_ID = 24;
	public static final int Permanent_Address_City = 25;
	public static final int Permanent_Address_City_ID = 26;
	public static final int Permanent_Address_Pin_Code = 27;
	public static final int Permanent_Address_Mobile_No = 28;
	public static final int Permanent_Address_Telephone = 29;
	public static final int Permanent_Address_Email = 30;

	public static final int JobState = 31;
	public static final int JobStateID = 32;

	public static final int JobLocation = 33;
	public static final int JobLocationID = 34;
	public static final int BloodGroup = 35;
	public static final int BloodGroup_ID = 36;

	public static final int ProbationDays = 37;
	public static final int EmployeeType = 38;
	public static final int EmployeeType_ID = 39;
	public static final int DepartmentName = 40;
	public static final int DepartmentName_ID = 41;

	public static final int DesignationName = 42;
	public static final int DesignationName_ID = 43;

	public static final int ContractOverDate = 44;
	public static final int ReferenceName = 45;
	public static final int DateOfJoining = 46;

	public static final int AadharCardNo = 47;
	public static final int PanCardNo = 48;

	public static final int PfNo = 49;
	public static final int Uan = 50;
	public static final int EsiNo = 51;

	public static final int AccountType = 52;
	public static final int AccountType_ID = 53;
	public static final int BankName = 54;
	public static final int BankId = 55;
	public static final int AccountNumber = 56;
	public static final int IfscCode = 57;
	public static final int EffectiveDate = 58;
	public static final int BasicSalary = 59;
	public static final int DearnessAllowance = 60;
	public static final int HouseRentAllowance = 61;
	public static final int ConveyanceAllowance = 62;
	public static final int SpecialAllowance = 63;
	public static final int MedicalAllowance = 64;
	public static final int AdvanceBonus = 65;
	public static final int PerformanceLinkedIncome = 66;
	public static final int CompanyBenefits = 67;
	public static final int LeaveTravelAllowance = 68;
	public static final int UniformAllowance = 69;

	public void buildEmployee(EmployeeDTO employee, Cell cell, int index, FormulaEvaluator evaluator,
			StringBuilder stringBuilder, Map<Long, City> cityMap, Map<Long, Designation> designationMap)
			throws ParseException {

		if (index == Employee_Code) {
			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Employee Code, ");
			} else {
				employee.setEmployeeCode(cell.getStringCellValue());
			}

		} else if (index == First_Name) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("First Name, ");
			} else {
				employee.setFirstName(cell.getStringCellValue().trim());
			}

		} else if (index == Middle_Name) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals(""))
				employee.setMiddleName(cell.getStringCellValue());

		} else if (index == Last_Name) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Last Name, ");
			} else {
				employee.setLastName(cell.getStringCellValue().trim());
			}

		} else if (index == DOB) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Date of Birth, ");
			} else {

				DataFormatter dataFormatter = new DataFormatter();
				String cellStringValue = dataFormatter.formatCellValue(cell);
				Date dob = new SimpleDateFormat("dd/MM/yyyy").parse(cellStringValue);
				employee.setDateOfBirth(dob);

			}

		} else if (index == Gender_ID) {
			CellValue cellValue = evaluator.evaluate(cell);
			if (cellValue != null)
				employee.setGender(cellValue.getStringValue());

		} else if (index == Marital_ID) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Marital Status, ");
			} else {
				CellValue cellValue = evaluator.evaluate(cell);
				if (cellValue != null)
					employee.setMaritalStatus(cellValue.getStringValue());
			}

		} else if (index == BloodGroup_ID) {

			CellValue cellValue = evaluator.evaluate(cell);

			if (cellValue != null)
				employee.setBloodGroup(cellValue.getStringValue());

		} else if (index == ProbationDays) {

			String cellStringValue = dataConverter(cell);

			if (!cellStringValue.equals("")) {
				Long days = Long.valueOf(cellStringValue);
				employee.setProbationDays(days);
			}
		} else if (index == EmployeeType_ID) {

			CellValue cellValue = evaluator.evaluate(cell);
			if (cellValue != null)
				employee.setEmpType(cellValue.getStringValue());

		} else if (index == ContractOverDate) {

			Date contractOverDate = new SimpleDateFormat("dd/MM/yyyy").parse(cell.getStringCellValue());
			employee.setDateOfBirth(contractOverDate);

		} else if (index == ReferenceName) {

			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				employee.setReferenceName(cellStringValue);
			}

		} else if (index == DateOfJoining) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Date of Joining, ");
			} else {

				String cellStringValue = dataConverter(cell);
				Date doj = new SimpleDateFormat("dd/MM/yyyy").parse(cellStringValue);
				employee.setDateOfJoining(doj);

			}

		} else if (index == DepartmentName_ID) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Department, ");
			} else {

				CellValue cellValue = evaluator.evaluate(cell);
				Long departmentd = Math.round(cellValue.getNumberValue());
				employee.setDepartmentId(departmentd);

			}

		} else if (index == DesignationName_ID) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Designation, ");
			} else {

				CellValue cellValue = evaluator.evaluate(cell);
				Long designationId = Math.round(cellValue.getNumberValue());

				Designation designation = getDesignationId(designationMap, designationId);
				if (designation == null) {
					stringBuilder.append("Designation Id  , ");
				} else {
					employee.setDesignationId(designationId);
				}

			}

		} else if (index == JobStateID) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Job State, ");
			} else {

				CellValue cellValue = evaluator.evaluate(cell);
				Long jobStateLocationId = Math.round(cellValue.getNumberValue());

				// String cellStringValue = dataConverter(cell);
				// City city = getCityId(cityMap, cellStringValue);
				employee.setStateId(jobStateLocationId);

			}

		} else if (index == JobLocationID) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Job Location, ");
			} else {

				CellValue cellValue = evaluator.evaluate(cell);
				Long jobLocationId = Math.round(cellValue.getNumberValue());

				// String cellStringValue = dataConverter(cell);
				// City city = getCityId(cityMap, cellStringValue);
				employee.setCityId(jobLocationId);

			}

		} else if (index == AadharCardNo) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append(" Aadhar Card No, ");
			} else {
				String cellStringValue = dataConverter(cell);

				employee.setAadharNumber(cellStringValue);

			}

		}

	}

	public void buildPresentAddress(AddressDTO address, Cell cell, int index, FormulaEvaluator evaluator,
			StringBuilder stringBuilder, Map<Long, City> cityMap, int rowIndex) {

		if (index == Present_Address_AddressText) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setAddressText(cellStringValue);
			}

		} else if (index == Present_Address_Landmark) {
			address.setLandmark(cell.getStringCellValue());
		} else if (index == Present_Address_State_ID) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("State, ");
			} else {

				CellValue cellValue = evaluator.evaluate(cell);
				Long stateId = Math.round(cellValue.getNumberValue());
				address.setStateId(stateId);

			}

		} /*
			 * else if (index == Present_Address_City_ID) {
			 * 
			 * if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			 * stringBuilder.append("City, "); } else { CellValue cellValue =
			 * evaluator.evaluate(cell); Long cityId =
			 * Math.round(cellValue.getNumberValue()); address.setCityId(cityId); }
			 * 
			 * }
			 */
		else if (index == Present_Address_City_ID) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("City, ");
			} else {
				CellValue cellValue = evaluator.evaluate(cell);
				Long cityId = Math.round(cellValue.getNumberValue());
				City city = getCityId(cityMap, cityId);
				if (city == null) {
					stringBuilder.append("present City ID is " + cityId + ",");
				} else {
					address.setCityId(cityId);
				}
			}

		} else if (index == Present_Address_Pin_Code) {

			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setPincode(cellStringValue);
			}

		} else if (index == Present_Address_Mobile_No) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setMobile(cellStringValue);
			}

		} else if (index == Present_Address_Telephone) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setTelephone(cellStringValue);
			}

		} else if (index == Present_Address_Email) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setEmailId(cellStringValue);
			}
		}
	}

	public void builPermanentdAddress(AddressDTO address, Cell cell, int index, FormulaEvaluator evaluator,
			StringBuilder stringBuilder, Map<Long, City> cityMap) {

		if (index == Permanent_Address_AddressText) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setAddressText(cell.getStringCellValue());
			}

		} else if (index == Permanent_Address_Landmark) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setLandmark(cellStringValue);
			}

		} else if (index == Permanent_Address_State_ID) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("State, ");
			} else {
				CellValue cellValue = evaluator.evaluate(cell);
				Long stateId = Math.round(cellValue.getNumberValue());
				address.setStateId(stateId);
			}

		} /*
			 * else if (index == Permanent_Address_City_ID) {
			 * 
			 * if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			 * stringBuilder.append("City, "); } else { CellValue cellValue =
			 * evaluator.evaluate(cell); Long cityId =
			 * Math.round(cellValue.getNumberValue()); address.setCityId(cityId); }
			 * 
			 * }
			 */
		else if (index == Permanent_Address_City_ID) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("City, ");
			} else {
				CellValue cellValue = evaluator.evaluate(cell);
				Long cityId = Math.round(cellValue.getNumberValue());

				City city = getCityId(cityMap, cityId);

				if (city == null) {
					stringBuilder.append("permanent City ID is " + cityId + ",");
				} else {
					address.setCityId(cityId);
				}

			}

		} else if (index == Permanent_Address_Pin_Code) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setPincode(cellStringValue);
			}

		} else if (index == Permanent_Address_Mobile_No) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setMobile(cellStringValue);
			}

		} else if (index == Permanent_Address_Telephone) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setTelephone(cellStringValue);
			}

		} else if (index == Permanent_Address_Email) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				address.setEmailId(cellStringValue);
			}
		}
	}

	public void buildBankDetails(BankDetailsDTO bankDetailsDto, Cell cell, int index, FormulaEvaluator evaluator,
			StringBuilder stringBuilder) throws ParseException {

		/*
		 * if (index == AccountType_ID ) {
		 * 
		 * //CellValue cellValue = evaluator.evaluate(cell); //String accountType =
		 * cellValue.getStringValue();
		 * //System.out.println("AccountType!> "+accountType);
		 * bankDetailsDto.setAccountType("SA"); //hard code } else
		 */ if (index == AccountNumber) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("Account Number, ");
			} else {
				String cellStringValue = dataConverter(cell);
				bankDetailsDto.setAccountNumber(cellStringValue);
			}

		} else if (index == BankId) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				bankDetailsDto.setBankId(cellStringValue);
			}

		} else if (index == IfscCode) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append("IfscCode, ");
			} else {
				String cellStringValue = dataConverter(cell);
				bankDetailsDto.setIfscCode(cellStringValue);
			}
		} else if (index == EffectiveDate) {
			/*
			 * System.out.println("cell date value " + cell.getDateCellValue()); Date
			 * effectiveDate = cell.getDateCellValue();
			 * bankDetailsDto.setEffectiveDate(effectiveDate);
			 * System.out.println(" getEffectiveDate() >> " +
			 * bankDetailsDto.getEffectiveDate());
			 */

			DataFormatter dataFormatter = new DataFormatter();
			String cellStringValue = dataFormatter.formatCellValue(cell);

			Date effectiveDate = new SimpleDateFormat("dd/MM/yyyy").parse(cellStringValue);

			bankDetailsDto.setEffectiveDate(effectiveDate);

		}

	}

	public void buildIdAndAddressProof(List<EmployeeIdProofDTO> employeeIdProofDtoList, Cell cell, int index,
			FormulaEvaluator evaluator, StringBuilder stringBuilder) {

		if (index == AadharCardNo) {

			if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				stringBuilder.append(" Aadhar Card No, ");
			} else {
				String cellStringValue = dataConverter(cell);
				EmployeeIdProofDTO employeeIdProofDto = new EmployeeIdProofDTO();
				employeeIdProofDto.setIdTypeId("AA");
				employeeIdProofDto.setIdNumber(cellStringValue);
				employeeIdProofDtoList.add(employeeIdProofDto);

			}

		} else if (index == PanCardNo) {
			EmployeeIdProofDTO employeeIdProofDto = new EmployeeIdProofDTO();
			String cellStringValue = dataConverter(cell);
			employeeIdProofDto.setIdTypeId("PA");
			employeeIdProofDto.setIdNumber(cellStringValue);
			employeeIdProofDtoList.add(employeeIdProofDto);

		}
	}

	public void buildStatoryInfo(List<EmployeeStatuaryDTO> employeeStatuaryDtoList, Cell cell, int index,
			FormulaEvaluator evaluator, StringBuilder stringBuilder) {

		if (index == PfNo) {
			EmployeeStatuaryDTO employeeStatuaryDto = new EmployeeStatuaryDTO();
			String cellStringValue = dataConverter(cell);
			employeeStatuaryDto.setStatuaryType("PF");
			employeeStatuaryDto.setStatuaryNumber(cellStringValue);
			employeeStatuaryDtoList.add(employeeStatuaryDto);
		}
		if (index == Uan) {

			String cellStringValue = dataConverter(cell);
			EmployeeStatuaryDTO employeeStatuaryDto = new EmployeeStatuaryDTO();
			employeeStatuaryDto.setStatuaryType("UA");
			employeeStatuaryDto.setStatuaryNumber(cellStringValue);
			employeeStatuaryDtoList.add(employeeStatuaryDto);

		}
		if (index == EsiNo) {

			String cellStringValue = dataConverter(cell);
			EmployeeStatuaryDTO employeeStatuaryDto = new EmployeeStatuaryDTO();

			employeeStatuaryDto.setStatuaryType("ES");
			employeeStatuaryDto.setStatuaryNumber(cellStringValue);
			employeeStatuaryDtoList.add(employeeStatuaryDto);

		}

	}

	public BigDecimal payheads(PayStructureHdDTO payStructureHdDTO, Cell cell, int index, FormulaEvaluator evaluator,
			StringBuilder stringBuilder) {
		BigDecimal amount = new BigDecimal(0);

		if (index == BasicSalary) {

			String cellStringValue = dataConverter(cell);

			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal basic = new BigDecimal(cellStringValue);
				payStructure.setAmount(basic);
				payStructure.setPayHeadId(StandardEarningEnum.BasicSalary.getStandardEarning());

				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
				amount = basic;
			}

		} else if (index == DearnessAllowance) {

			String cellStringValue = dataConverter(cell);

			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal da = new BigDecimal(cellStringValue);
				payStructure.setAmount(da);
				payStructure.setPayHeadId(StandardEarningEnum.DearnessAllowance.getStandardEarning());
				amount = da;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		} else if (index == HouseRentAllowance) {
			String cellStringValue = dataConverter(cell);

			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal hra = new BigDecimal(cellStringValue);
				payStructure.setAmount(hra);
				payStructure.setPayHeadId(StandardEarningEnum.HouseRentAllowance.getStandardEarning());
				amount = hra;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		} else if (index == ConveyanceAllowance) {

			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal ca = new BigDecimal(cellStringValue);
				payStructure.setAmount(ca);
				payStructure.setPayHeadId(StandardEarningEnum.ConveyanceAllowance.getStandardEarning());
				amount = ca;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		} else if (index == SpecialAllowance) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal sa = new BigDecimal(cellStringValue);
				payStructure.setAmount(sa);
				payStructure.setPayHeadId(StandardEarningEnum.SpecialAllowance.getStandardEarning());
				amount = sa;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		} else if (index == MedicalAllowance) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal ma = new BigDecimal(cellStringValue);
				payStructure.setAmount(ma);
				payStructure.setPayHeadId(StandardEarningEnum.MedicalAllowance.getStandardEarning());
				amount = ma;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		} else if (index == AdvanceBonus) {
			String cellStringValue = dataConverter(cell);

			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal ab = new BigDecimal(cellStringValue);
				payStructure.setAmount(ab);
				payStructure.setPayHeadId(StandardEarningEnum.AdvanceBonus.getStandardEarning());
				amount = ab;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		} else if (index == PerformanceLinkedIncome) {

			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal pi = new BigDecimal(cellStringValue);
				payStructure.setAmount(pi);
				payStructure.setPayHeadId(StandardEarningEnum.PerformanceLinkedIncome.getStandardEarning());
				amount = pi;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		} else if (index == CompanyBenefits) {

			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal cb = new BigDecimal(cellStringValue);
				payStructure.setAmount(cb);
				payStructure.setPayHeadId(StandardEarningEnum.CompanyBenefits.getStandardEarning());
				amount = cb;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		} else if (index == LeaveTravelAllowance) {

			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal lta = new BigDecimal(cellStringValue);
				payStructure.setAmount(lta);
				payStructure.setPayHeadId(StandardEarningEnum.LeaveTravelAllowance.getStandardEarning());
				amount = lta;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		} else if (index == UniformAllowance) {
			String cellStringValue = dataConverter(cell);
			if (!cellStringValue.equals("")) {
				PayStructureDTO payStructure = new PayStructureDTO();
				BigDecimal ua = new BigDecimal(cellStringValue);
				payStructure.setAmount(ua);
				payStructure.setPayHeadId(StandardEarningEnum.UniformAllowance.getStandardEarning());
				amount = ua;
				payStructureHdDTO.getPayStructureDtoList().add(payStructure);
			}

		}

		return amount;
	}

	private String dataConverter(Cell cell) {
		DataFormatter dataFormatter = new DataFormatter();
		String cellStringValue = dataFormatter.formatCellValue(cell);
		return cellStringValue;
	}// dataConverter

	private City getCityId(Map<Long, City> cityMap, Long cityId) {

		return cityMap.get(cityId);
	}

	private Designation getDesignationId(Map<Long, Designation> designationMap, Long designationId) {

		return designationMap.get(designationId);
	}
}
