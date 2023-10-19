package com.itl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itl.dao.OtpDao;
import com.itl.dao.loginDao;
import com.itl.entities.OtpMst;
import com.itl.entities.LoginEntity;
import com.itl.service.OtpService;
@Service
public class OtpServiceImpl implements OtpService {

	@Autowired
	protected OtpDao otpDao;
	
//	@Override
//	public OtpMst getPrimaryKey(Integer Id) {
//		if (null == Id)
//			return null;
//		OtpMst masterObj = otpDao.getPrimaryKey(Id);
//		if (null == masterObj) {
//			return null;
//		} else {
//			return masterObj;
//		}
//	}

	
	@Override
	public OtpMst saveOrUpdate(OtpMst msg) {
		
				OtpMst rmfa = msg;
				return otpDao.save(rmfa);
			}

	@Override
	public OtpMst getByOtpsucces(String otp) {
		List<OtpMst> otpmst = otpDao.getByOtpSuccess(otp);
		if (null != otpmst && !otpmst.isEmpty()) {
			return otpmst.get(0);
		}

		return null;

	}




	
	
}
