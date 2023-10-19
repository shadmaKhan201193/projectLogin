package com.itl.service;


import com.itl.entities.LoginEntity;

public interface LoginService {

	public LoginEntity getPrimaryKey(Long Id);
	
	public LoginEntity saveOrUpdate(String loginId, LoginEntity entity);
	
	public LoginEntity getByUsername(String username);
	
	public LoginEntity getByUserId(String userId);;
	

	
}
