package com.itl.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.itl.entities.CaptchUserLogin;
import com.itl.service.impl.CaptchService;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.FlatColorBackgroundProducer;

@RestController
@RequestMapping("/captcha")
public class CaptchaController {

	private static final Logger logger = LoggerFactory.getLogger(CaptchaController.class);

	
	
	@Autowired
	public CaptchService captchService;

	@GetMapping(value = "/generateCaptcha")
	public ResponseEntity<byte[]> generateCaptcha() throws IOException {

		CaptchUserLogin user = new CaptchUserLogin();

		Captcha cap = new Captcha.Builder(200, 80).addBackground(new FlatColorBackgroundProducer()).addText().addNoise()
				.build();
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(cap.getImage(), "png", os);
		byte[] data = os.toByteArray();
		System.out.println(cap.getAnswer());
	
		UUID captchaId = UUID.randomUUID();
	
		user.setCaptchaId(captchaId.toString());
		user.setCaptcha(cap.getAnswer());

		//HttpHeaders headers = new HttpHeaders();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	
		httpServletResponse.addHeader("UUID",captchaId.toString());

		CaptchUserLogin entity = captchService.saveOrUpdate(user, captchaId);
		
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(data);

	}

	
//	@PostMapping(value = "/validateCaptcha")
//	public String validatecaptcha(@RequestBody CaptchUserLogin CapUser) throws IOException {
//		Boolean entity = captchService.validate(CapUser.getCaptchaId());
//		if (null != entity && entity.getCaptcha().equals(CapUser.getCaptcha())) {
//			return "valid captcha";
//
//		}
//		return "Invalid captcha";
//
//	}

}
