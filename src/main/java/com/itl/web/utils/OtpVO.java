package com.itl.web.utils;

import javax.persistence.Column;

public class OtpVO {

	@Column(name = "OTP")
	private String otpsucces="";

	public String getOtpsucces() {
		return otpsucces;
	}

	public void setOtpsucces(String otpsucces) {
		this.otpsucces = otpsucces;
	}
	
	
	
}
