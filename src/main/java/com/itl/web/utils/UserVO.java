package com.itl.web.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {

	private String userName;
	private String loginId;
	private String password;
	private String role;
	private String userDisplayName;
	private Integer tenantId;
	private String branchCode;
	private String captcha;
	private String captchaId;
	private String dateFormat;
	
	
	/**
	 * @return the captchaId
	 */
	public String getCaptchaId() {
		return captchaId;
	}
	/**
	 * @param captchaId the captchaId to set
	 */
	public void setCaptchaId(String captchaId) {
		this.captchaId = captchaId;
	}
	/**
	 * @return the captcha
	 */
	public String getCaptcha() {
		return captcha;
	}
	/**
	 * @param captcha the captcha to set
	 */
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserDisplayName() {
		return userDisplayName;
	}
	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}
	public Integer getTenantId() {
		return tenantId;
	}
	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	
	
}
