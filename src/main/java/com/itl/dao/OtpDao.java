package com.itl.dao;

import java.util.List;

import com.itl.entities.OtpMst;


public interface OtpDao {
//	public OtpMst getPrimaryKey(Integer id);
//	
public List<OtpMst> getByOtpSuccess(String otp);
	public OtpMst save(OtpMst otp);
	
}
