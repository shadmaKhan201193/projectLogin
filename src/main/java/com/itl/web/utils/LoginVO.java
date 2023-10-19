package com.itl.web.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author shalu.shende
 *
 */
@Getter
@Setter
public class LoginVO {

	private String userName = "";
	private String password = "";
	private Integer enabled = 0;
	private String role = "";
	private String pwdSalt = "";
	private String HashPwd = "";
	private Integer tenantId = 0;
	private String employeeId = "";
	private String userDisplayName = "";
	private String isActive = "";
	private String OTP = "";
	private String branchCode;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPwdSalt() {
		return pwdSalt;
	}
	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}
	public String getHashPwd() {
		return HashPwd;
	}
	public void setHashPwd(String hashPwd) {
		HashPwd = hashPwd;
	}
	public Integer getTenantId() {
		return tenantId;
	}
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getUserDisplayName() {
		return userDisplayName;
	}
	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	
	
	
	
	
}
