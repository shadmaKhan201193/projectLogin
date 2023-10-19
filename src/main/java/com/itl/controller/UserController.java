package com.itl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itl.entities.CaptchUserLogin;
import com.itl.entities.LoginEntity;
import com.itl.service.LoginService;
import com.itl.service.impl.CaptchService;
import com.itl.web.utils.UserVO;

@RestController
public class UserController {

	

	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/UserDetails1", produces = "application/json")
	public String getByUserNamePwd(@RequestBody UserVO user) {
		LoginEntity loginMst = loginService.getByUsername(user.getUserName());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (null != loginMst) {
			boolean s = encoder.matches(user.getPassword(), loginMst.getPassword());
			if (s == true) {
				return "login successfull";
			} else {
				return "login fail";
			}
		}
		return "succusess";

	}


}
