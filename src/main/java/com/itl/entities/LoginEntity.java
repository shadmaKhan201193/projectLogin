package com.itl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.itl.entities.base.Base;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class LoginEntity extends Base {

	private static final long serialVersionUID = 1L;

	@Column(length = 48, nullable = false)
	private String userName;
	
	@Column(length = 48, nullable = true)
	private String captcha;
	
	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 48, nullable = true)
	private Integer enabled = 0;

	@Column(length = 48, nullable = false)
	private String role;

	@Column(length = 100, nullable = false)
	private String pwdSalt;

	@Column(length = 100, nullable = false)
	private String HashPwd;
	
	@Column(length = 48, nullable = false)
	private Integer tenantId;
	
	@Column(length = 48, nullable = true)
	private String employeeId = "";
	
	@Column(length = 48, nullable = false)
	private String userDisplayName;
	
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

	@Column(length = 10, nullable = false)
	private String isActive = "0";

	@Column(length = 6, nullable = true)
	private String OTP = "";
	
	@Column(length = 10, nullable = false)
	private String branchCode;
	
	

}
