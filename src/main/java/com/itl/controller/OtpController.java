package com.itl.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itl.entities.OtpMst;
import com.itl.service.EmailService;
import com.itl.service.OtpService;
import com.itl.web.utils.OtpVO;

import net.bytebuddy.utility.RandomString;

@RestController
public class OtpController {

	@Autowired
	private EmailService emailService;

	@Autowired
	private OtpService otpService;

	@GetMapping("/generateOtp")
	public String generateOTP() throws MessagingException {

		// Random rd = new Random();
		// int OTPint =rd.nextInt();

		String OTP = RandomString.make(8);

		emailService.sendOtpMessage("shalu.shende@kiya.ai", "OTP -SpringBoot", OTP);

		return "otp send successfuly";
	}

	@PostMapping(value = "/validateOtp", consumes = "application/json", produces = "application/json")
	public String ValidateOTP(@RequestBody OtpVO otp) {
		OtpMst OtpMst = otpService.getByOtpsucces(otp.getOtpsucces());
		if (null != OtpMst) {
			// if(otp.equals(OtpMst.getOtpsucces())) {
			if (otp.getOtpsucces().equals(OtpMst.getOtpsucces())) {
				return "OTP is valid";

			} else {
				return "otp is not valid";
			}
		}
		return "succuses";

	}

}
