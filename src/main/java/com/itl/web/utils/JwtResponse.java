package com.itl.web.utils;

public class JwtResponse {

	private final String jwttoken;
	private final String loginTime;
	private final String userName;
	private final String role;

	public JwtResponse(String jwttoken, String loginTime,String userName, String role) {
		super();
		this.jwttoken = jwttoken;
		this.loginTime = loginTime;
		this.userName = userName;
		this.role = role;
	}

	public String getJwttoken() {
		return jwttoken;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public String getUserName() {
		return userName;
	}

	public String getRole() {
		return role;
	}
	
}
