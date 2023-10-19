package com.itl.login.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itl.entities.OtpMst;

@Repository
public interface OtpRepository extends JpaRepository<OtpMst, Integer> {
	
	public List<OtpMst> findByOtpsucces(String otp);
	
	

}
