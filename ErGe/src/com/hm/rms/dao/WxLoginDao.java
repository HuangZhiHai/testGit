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

	boolean getTokenStatus(@Param("tableName") String tableName,@Param("token") String token,@Param("times") long times);
	/**
	 * 新建签到表
	 * @param tableName
	 */
	void createSignTable(@Param("tableName") String tableName);

	/**
	 * 是否存在签到记录
	 * @param tableName
	 * @param date
	 * @return
	 */
	boolean existsSignRecord(@Param("tableName") String tableName,@Param("token") String token,@Param("date") String date);
	/**
	 * 签到
	 * @param tableName
	 * @param token
	 * @return
	 */
	void scoresign(@Param("tableName") String tableName,@Param("token") String token,@Param("createtime") String createtime,@Param("date") String date);

	/**
	 * 查询签到次数
	 * @param tableName
	 * @param token
	 * @return
	 */
	int checkscoresign(@Param("tableName") String tableName,@Param("token") String token);

}
