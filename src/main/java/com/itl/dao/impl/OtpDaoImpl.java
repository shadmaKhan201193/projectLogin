package com.itl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itl.dao.OtpDao;
import com.itl.entities.OtpMst;
import com.itl.login.Repository.OtpRepository;
@Service
public class OtpDaoImpl implements OtpDao {

	@Autowired
	OtpRepository otpRepo;

//	
//	@Override
//	public OtpMst getPrimaryKey(Integer id) {
//		Optional<OtpMst> otpMst = otpRepo.findById(id);
//		if (otpMst.isPresent()) {
//			return otpMst.get();
//		} else {
//			return null;
//		}
//	}

	@Override
	public List<OtpMst> getByOtpSuccess(String otp) {
		 List<OtpMst> rMaaz = otpRepo.findByOtpsucces(otp);	
		return rMaaz;
	}

	@Override
	public OtpMst save(OtpMst otp) {
		OtpMst newOtpMst = otpRepo.save(otp);
		return newOtpMst;
	}

//	@Override
//	public OtpMst getByOtpSuccess(String otp) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
