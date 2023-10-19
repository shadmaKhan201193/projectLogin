package com.itl.dao;

import java.util.List;

import com.itl.entities.LoginEntity;

public interface loginDao {

	public LoginEntity getPrimaryKey(Long id);
	
	public List<LoginEntity> getByUserName(String userName);
	
	public LoginEntity save(LoginEntity loginEntity);
}
