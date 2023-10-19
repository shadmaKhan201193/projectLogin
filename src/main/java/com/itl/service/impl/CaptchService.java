package com.itl.service.impl;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itl.entities.CaptchUserLogin;
import com.itl.login.Repository.CaptchaRepository;

@Service
public class CaptchService {

	@Autowired
	protected CaptchaRepository captchaRepository;

	private Set<CaptchUserLogin> captchUserLogin = new HashSet<CaptchUserLogin>();

	public CaptchUserLogin saveOrUpdate(CaptchUserLogin entity, UUID captchaId) {

		return captchaRepository.save(entity);
	}

	
	
	public Boolean validate(String captcha, String captchaId) {
		
		//CaptchUserLogin caplogin = captchaRepository.findByCaptcha(captcha);
		CaptchUserLogin caplogin = captchaRepository.findByCaptchaAndCaptchaId(captcha, captchaId);

		if (null != caplogin && caplogin.getCaptcha().equals(captcha)) {
			return true;
		}
		return false;
	}
	
	
//	public String validate(String id) {
//		CaptchUserLogin caplogin = captchaRepository.findByCaptchaId(id);
//
//		if (null != caplogin && caplogin.getCaptcha().equals(caplogin.getCaptcha())) {
//			return true;
//		}
//		return false;
//	}

	public void createUser(CaptchUserLogin userLogin) {

		captchaRepository.save(userLogin);
	}

	public void add(CaptchUserLogin userLogin) {
		captchUserLogin.add(userLogin);

	}

}
