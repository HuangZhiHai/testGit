package com.hm.rms.service;

import com.hm.rms.entity.UserInfo;

public interface LoginService {
	UserInfo login(String userName,String password);
	UserInfo registration(String userName);
	void regInsert(String realName,String userName,String userPwd,String eamilP,int roleId);
}
