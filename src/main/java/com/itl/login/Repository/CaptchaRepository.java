package com.itl.login.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itl.entities.CaptchUserLogin;

@Repository
public interface CaptchaRepository extends JpaRepository<CaptchUserLogin, Integer> {
	
	public CaptchUserLogin findByCaptchaId(String capId);
	
	
	public CaptchUserLogin findByCaptchaAndCaptchaId(String captcha,String capId);
	
	public CaptchUserLogin findByCaptcha(String captcha);

}
