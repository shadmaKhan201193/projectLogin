package com.itl.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itl.entities.CaptchUserLogin;
import com.itl.entities.LoginEntity;
import com.itl.service.LoginService;
import com.itl.service.impl.CaptchService;
import com.itl.web.utils.LoginVO;
import com.itl.web.utils.UserVO;

@RestController
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private final int logRounds = 10;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CaptchService captchaService;

	@Autowired
	private LoginService loginService;

	@PostMapping(value = "/usersRegister", consumes = "application/json", produces = "application/json")
	public String registerUser(@RequestBody LoginVO loginUser) {

		LoginEntity loginMst = loginService.getByUsername(loginUser.getUserName());
		if (null != loginMst) {
			return "Failure.. Record already exists";
		} else {
			loginMst = new LoginEntity();
			Date dt = new Date();
			loginMst.setCreatedBy("admin");
			loginMst.setCreatedDateTime(dt);
			loginMst.setLastModifiedBy("admin");
			loginMst.setLastModifiedDateTime(dt);
			loginMst.setEnabled(loginUser.getEnabled());
			loginMst.setUserName(loginUser.getUserName());
			loginMst.setEmployeeId(loginUser.getEmployeeId());
			loginMst.setUserDisplayName(loginUser.getUserDisplayName());
			loginMst.setPwdSalt(BCrypt.gensalt(logRounds));
			loginMst.setHashPwd(BCrypt.hashpw(loginUser.getPassword(), BCrypt.gensalt(logRounds)));
			loginMst.setPassword(passwordEncoder.encode(loginUser.getPassword()));
			loginMst.setRole(loginUser.getRole());
			loginMst.setTenantId(loginUser.getTenantId());
			loginMst.setBranchCode(loginUser.getBranchCode());

			LoginEntity loginMstNew = loginService.saveOrUpdate("admin", loginMst);

			if (null != loginMstNew) {

				return "Successfully saved record";
			} else {
				return "Failure while saving record";
			}
		}
	}

	/*
	 * @PostMapping(value = "/login", produces = "application/json") public
	 * ResponseEntity<?> getByUserNamePwd1(@RequestBody UserVO user) { LoginEntity
	 * loginMst = loginService.getByUsername(user.getUserName());
	 * BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	 * logger.info("Logging user login success..."); if (null != loginMst) { UserVO
	 * loggedIdUser = new UserVO(); boolean s = encoder.matches(user.getPassword(),
	 * loginMst.getPassword()); if (s == true) {
	 * loggedIdUser.setUserName(loginMst.getUserName());
	 * loggedIdUser.setRole(loginMst.getRole());
	 * loggedIdUser.setTenantId(loginMst.getTenantId());
	 * loggedIdUser.setBranchCode(loginMst.getBranchCode());
	 * loggedIdUser.setUserDisplayName(loginMst.getUserDisplayName());
	 * loggedIdUser.setLoginId(loginMst.getUserName());
	 * loggedIdUser.setCaptcha(loginMst.getCaptcha()); if
	 * (loggedIdUser.getUserName() != null &&
	 * loggedIdUser.getUserName().equals("infraadmin")) {
	 * loggedIdUser.setDateFormat("dd-MMM-yyyy"); } else {
	 * loggedIdUser.setDateFormat("yyyy-MM-dd"); } Boolean cap =
	 * captchaService.validate(user.getCaptcha(),user.getCaptchaId()); boolean ss =
	 * encoder.matches(user.getPassword(), loginMst.getPassword());
	 * if(cap==true&&ss==true) { return new ResponseEntity(new Success(),
	 * HttpStatus.OK);
	 * 
	 * }else { return new ResponseEntity(new Error(), HttpStatus.BAD_REQUEST); }
	 * return new ResponseEntity<UserVO>(loggedIdUser, HttpStatus.OK); } } return
	 * new ResponseEntity<UserVO>(HttpStatus.UNAUTHORIZED); }
	 */

	
	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<?> getByUserNamePwd1(@RequestBody UserVO user) {
		LoginEntity loginMst = loginService.getByUsername(user.getUserName());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		logger.info("Logging user login success...");
		if (null != loginMst) {
			UserVO loggedIdUser = new UserVO();
			boolean s = encoder.matches(user.getPassword(), loginMst.getPassword());
			if (s == true) {
				loggedIdUser.setUserName(loginMst.getUserName());
				loggedIdUser.setPassword(loginMst.getPassword());
				loggedIdUser.setRole(loginMst.getRole());
				loggedIdUser.setTenantId(loginMst.getTenantId());
				loggedIdUser.setBranchCode(loginMst.getBranchCode());
				loggedIdUser.setUserDisplayName(loginMst.getUserDisplayName());
				loggedIdUser.setLoginId(loginMst.getUserName());
				
				if (loggedIdUser.getUserName() != null && loggedIdUser.getUserName().equals("infraadmin")) {
					loggedIdUser.setDateFormat("dd-MMM-yyyy");
				} else {
					loggedIdUser.setDateFormat("yyyy-MM-dd");
				}
			}
			Boolean cap = captchaService.validate(user.getCaptcha(), user.getCaptchaId());			
			boolean ss = encoder.matches(user.getPassword(), loginMst.getPassword());
			if (cap == true && ss == true) {
				loggedIdUser.setCaptcha(user.getCaptcha());
				loggedIdUser.setCaptchaId(user.getCaptchaId());
				return new ResponseEntity<UserVO>(loggedIdUser, HttpStatus.OK);
				//return new ResponseEntity<>("login successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Invalid Captcha Or CaptchaId!",HttpStatus.UNAUTHORIZED);
			}

		}
		return new ResponseEntity<String>("Invalid Username Or Password!", HttpStatus.UNAUTHORIZED);
	}

	
	@GetMapping(value = "/UserId/{id}", produces = "application/json")
	public LoginVO getUserById(@PathVariable String id) {
		LoginEntity loginMst = loginService.getByUsername(id);
		LoginVO loginvo = null;
		if (null != loginMst) {
			loginvo = new LoginVO();
			loginvo.setUserName(loginMst.getUserName());
			loginvo.setEmployeeId(loginMst.getEmployeeId());
			loginvo.setEnabled(loginMst.getEnabled());
			loginvo.setUserDisplayName(loginMst.getUserDisplayName());

			loginvo.setPwdSalt(BCrypt.gensalt(logRounds));
			loginvo.setHashPwd(BCrypt.hashpw(loginMst.getPassword(), BCrypt.gensalt(logRounds)));
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			encoder.matches(loginMst.getPassword(), loginMst.getHashPwd());

		}
		return loginvo;
	}

	@GetMapping(value = "/user/{userName}/branch", produces = "application/json")
	public String getUserBranch(@PathVariable String userName) {
		if (userName != null) {
			LoginEntity user = loginService.getByUsername(userName);
			if (user != null) {
				return user.getBranchCode();
			}
		}
		return null;
	}

}
