package com.itl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class LoginTable {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	protected Long id;

	@Version
	protected Integer version = 0;

	@Column(length = 48, nullable = true)
	private Integer enabled = 0;

	@Column(length = 48, nullable = false)
	private String role = "";

	@Column(length = 48, nullable = false)
	private String pwdSalt = "";

	@Column(length = 48, nullable = false)
	private String HashPwd = "";

	@Column(length = 48, nullable = false)
	private String loginId = "";

	@Column(length = 48, nullable = false)
	private Integer tenantId = 0;

	@Column(length = 48, nullable = false)
	private String employeeId = "";
	
	@Column(length = 48, nullable = true)
	private String userDisplayName = "";

	@Column(length = 10, nullable = true)
	private String isActive = "";

	@Column(length = 10, nullable = true)
	private String createdBy = "";

	@Column(nullable = true)
	private Date createdDateTime;

	@Column(length = 10, nullable = true)
	private String lastModifiedBy = "";

	@Column(nullable = true)
	private Date lastModifiedDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}

	public void setLastModifiedDateTime(Date lastModifiedDateTime) {
		this.lastModifiedDateTime = lastModifiedDateTime;
	}

	
}
