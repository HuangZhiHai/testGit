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

	/**
	 * 判断此token是否诗失效
	 * @param tableName
	 * @param token
	 * @param times
	 * @return
	 */
	boolean getTokenStatus(String tableName,String token,long times);
	/**
	 * 新建签到表
	 * @param tableName
	 */
	void createSignTable(String tableName);
	/**
	 * 是否存在签到记录
	 * @param tableName
	 * @param date
	 * @return
	 */
	boolean existsSignRecord(String tableName,String token,String date);
	/**
	 * 签到
	 * @param tableName
	 * @param token
	 * @return
	 */
	void scoresign(String tableName,String token,String createtime,String date);

	/**
	 * 查询签到次数
	 * @param tableName
	 * @param token
	 * @return
	 */
	int checkscoresign(String tableName,String token);


}
