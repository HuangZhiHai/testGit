package com.hm.rms.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.rms.dao.LoginDao;
import com.hm.rms.entity.UserInfo;

//事务注解，加在Service上最科学
@Transactional
@Service
public class LoginServiceImpl implements LoginService {

	@Resource
	private LoginDao loginDao;
	
	@Override
	public UserInfo login(String userName, String password) {
		return loginDao.login(userName, password);
	}
	public UserInfo registration(String userName) {
		return loginDao.registration(userName);
	}
	@Override
	public void regInsert(String realName, String userName, String userPwd, String eamilP, int roleId) {
		 loginDao.regInsert(realName, userName, userPwd, eamilP, roleId);
	}
}
