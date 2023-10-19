package com.itl.login.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itl.entities.LoginEntity;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

	public List<LoginEntity> findByUserName(String userName);
	public List<LoginEntity> findByPassword(String password);

}
