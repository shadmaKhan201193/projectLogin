package com.itl;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class TestBCrypt {

	public void main(String[] args) {
		String originalPassword = "password";
	    String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
	    System.out.println(generatedSecuredPasswordHash);
	    String passdb = "$2a$12$uQWnNuu2V1OYtjX2tBQKquX4vEN8UozQ.YeMEU.bnbWY9TC.z4ZYC";
	    String newPassword = "password";
	    
	    boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
	    System.out.println(matched);
	    
	    //String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
	    //System.out.println(generatedSecuredPasswordHash);
	    
	    boolean matched1 = BCrypt.checkpw(passdb, generatedSecuredPasswordHash);
	    System.out.println(matched1);
	}

}
