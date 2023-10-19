package com.itl.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.itl.entities.OtpMst;
import com.itl.login.Repository.OtpRepository;

@Service
public class EmailService {
	
//	  @Autowired
//	    private JavaMailSender javaMailSender;

	@Autowired
	OtpRepository otpRepo;
	
	@Autowired
	 private OtpService otpService;

	    public void sendOtpMessage(String to, String subject, String message)
	            throws MessagingException, javax.mail.MessagingException {
	        String host = "smtp.office365.com";
	        String from = "shalu.shende@kiya.ai";
	        Properties properties = System.getProperties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");

	        Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("shalu.shende@kiya.ai", "Shalini@1234");
	            }
	        });
	        session.setDebug(true);
	        MimeMessage msg = new MimeMessage(session);
	        // MimeMessage msg = javaMailSender.createMimeMessage();
	        // MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        msg.setFrom(from);
	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	        msg.setSubject(subject);

	        msg.setText(message);

	        Transport.send(msg);
	       //otpRepo.save(message); 
	        OtpMst otpmst=new OtpMst();
	        otpmst.setOtpsucces(message);
	        
	        otpService.saveOrUpdate(otpmst);
	         //javaMailSender.send(msg);
	    }
	

}
