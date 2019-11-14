package com.hm.rms.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

public interface WxLoginDao {
	/**
	 * 微信登录 
	 * @param openid
	 * @param session_key
	 * @param date
	 */
	void wxLoginInsert(@Param("tableName") String tableName,@Param("openid") String openid,
			@Param("session_key") String session_key,
			@Param("date") String date);
	Integer existTable(@Param("tableName") String tableName);
	/**
	 * 新建表
	 * @param tableName
	 */
	void createNewTable(@Param("tableName") String tableName);
	
}
