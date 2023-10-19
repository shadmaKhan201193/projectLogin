package com.itl.service;

import org.springframework.stereotype.Service;

import com.itl.entities.OtpMst;

public interface OtpService {
	
//	public OtpMst getPrimaryKey(Integer Id);
	public OtpMst getByOtpsucces(String otp);
	
	public OtpMst saveOrUpdate(OtpMst otpmst);
	
}
