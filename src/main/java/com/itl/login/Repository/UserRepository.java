package com.itl.login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itl.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsername(String userName);
}
