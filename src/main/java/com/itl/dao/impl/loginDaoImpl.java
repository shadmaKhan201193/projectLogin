package com.itl.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itl.dao.loginDao;
import com.itl.entities.LoginEntity;
import com.itl.login.Repository.LoginRepository;
@Service
public class loginDaoImpl implements loginDao {

	@Autowired
	LoginRepository loginRepo;

	@Override
	public LoginEntity getPrimaryKey(Long id) {
		Optional<LoginEntity> lookup = loginRepo.findById(id);
		if (lookup.isPresent()) {
			return lookup.get();
		} else {
			return null;
		}
	}

	@Override
	public List<LoginEntity> getByUserName(String userName) {
		List<LoginEntity> rMaaz = loginRepo.findByUserName(userName);
		if (null == rMaaz) {
			return null;
		} else if (rMaaz != null && rMaaz.size() == 0) {
			return null;
		}
		return rMaaz;
	}

	@Override
	public LoginEntity save(LoginEntity loginEntity) {
		LoginEntity newloginEntity = loginRepo.save(loginEntity);

		return newloginEntity;
	}

}