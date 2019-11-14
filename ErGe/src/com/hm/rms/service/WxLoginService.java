package com.hm.rms.service;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

public interface WxLoginService {
	/**
	 * 微信登录时 储存sessionKey和openId
	 * @param openid
	 * @param session_key
	 * @param date
	 */
	void wxLoginInsert(String tableName,String openid,String session_key,String date);
	/**
	 * 判断数据库表名是否存在
	 * @param tableName
	 * @return
	 */
	Integer existTable(String tableName);
	/**
	 * 新建表
	 * @param tableName
	 */
	void createNewTable(String tableName);
}
