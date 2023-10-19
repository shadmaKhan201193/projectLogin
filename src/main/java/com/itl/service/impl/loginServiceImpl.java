package com.itl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itl.dao.loginDao;
import com.itl.entities.LoginEntity;
import com.itl.service.LoginService;

@Repository
public class loginServiceImpl implements LoginService {

	@Autowired
	protected loginDao loginDao;
	
	@Override
	public LoginEntity getPrimaryKey(Long Id) {
		if (null == Id)
			return null;
		LoginEntity masterObj = loginDao.getPrimaryKey(Id);
		if (null == masterObj) {
			return null;
		} else {
			return masterObj;
		}
	}

	
	@Override
	public LoginEntity saveOrUpdate(String loginId, LoginEntity entity) {
		LoginEntity rMaaz = getPrimaryKey(entity.getId());
		try {
			if (null == rMaaz) {
				return loginDao.save(entity);
			} else {
				LoginEntity rmfa = rMaaz;
				return loginDao.save(rmfa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	@Override
	public LoginEntity getByUsername(String username) {
		
		List<LoginEntity> loginList = loginDao.getByUserName(username);
		if (null != loginList && !loginList.isEmpty()) {
			return loginList.get(0);
		}

		return null;
	}

	@Override
	public LoginEntity getByUserId(String userId) {
		
		List<LoginEntity> Idvalue = loginDao.getByUserName(userId);
		if (null != Idvalue && !Idvalue.isEmpty()) {
			return Idvalue.get(0);
		}
		return null;
	}

}
