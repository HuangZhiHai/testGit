package com.hm.rms.dao;

import org.apache.ibatis.annotations.Param;

import com.hm.rms.entity.UserInfo;
public interface LoginDao {
	UserInfo login(
		@Param("userName") String userName,
		@Param("password") String password
		);
	UserInfo registration(
			@Param("userName") String userName
			);
	void  regInsert(
			@Param("realName") String realName,
			@Param("userName") String userName,
			@Param("userPwd")  String userPwd,
			@Param("eamilP") String eamilP,
			@Param("roleId") int roleId
			);

}
