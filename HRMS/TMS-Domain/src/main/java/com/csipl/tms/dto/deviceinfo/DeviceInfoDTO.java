package com.csipl.tms.dto.deviceinfo;

import java.util.Date;
import java.math.BigInteger;

public class DeviceInfoDTO {

	private int deviceId;
	private int companyId;
	private Date dateCreated;
	private Date dateUpdate;
	private String deviceName;
	private String machineIP;
	private String prefix;
	private BigInteger serialNumber;
	private int userId;
	private int userIdUpdate;

	public DeviceInfoDTO() {
	}

	public int getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdate() {
		return this.dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getMachineIP() {
		return this.machineIP;
	}

	public void setMachineIP(String machineIP) {
		this.machineIP = machineIP;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public BigInteger getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(BigInteger serialNumber) {
		this.serialNumber = serialNumber;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserIdUpdate() {
		return this.userIdUpdate;
	}

	public void setUserIdUpdate(int userIdUpdate) {
		this.userIdUpdate = userIdUpdate;
	}

}