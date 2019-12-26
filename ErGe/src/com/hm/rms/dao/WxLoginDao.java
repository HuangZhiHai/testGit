package com.hm.rms.dao;

import java.util.Date;
import java.util.List;

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
	 * @param tableName 表名
	 * @param token 唯一标识
	 * @param createtime 创建时间
	 * @param date 日期
	 * @param nickName 名称
	 * @param city 城市
	 * @param country 国家
	 * @param province 省份
	 * @param gender 性别
	 * @param avatarUrl 图片
	 */
	void scoresign(@Param("tableName") String tableName,@Param("token") String token,@Param("createtime") String createtime,@Param("date") String date,@Param("nickName") String nickName,@Param("city") String city,@Param("country") String country,@Param("province") String province,@Param("gender") String gender,@Param("avatarUrl") String avatarUrl);

	/**
	 * 查询签到次数
	 * @param tableName
	 * @param token
	 * @return
	 */
	int checkscoresign(@Param("tableName") String tableName,@Param("token") String token);
	/**
	 * 新建反馈表
	 * @param tableName
	 */
	void createFeedBackTable(@Param("tableName") String tableName);
	/**
	 * @param tableName 表名
	 * @param token 微信唯一表示
	 * @param fbType 返回类型
	 * @param textareaTxt 文本域内容
	 * @param inputTxt 电话号内容
	 * @param creattime 当前时间
	 */
	 void feedBack(@Param("tableName") String tableName,@Param("token") String token,@Param("creattime") String creattime,
				   @Param("fbType") String fbType,@Param("textareaTxt") String textareaTxt,@Param("inputTxt") String inputTxt);

	/**
	 * 获取所有签到日期（当年，当月）
	 * @param token 微信唯一标识
	 * @param curyear 当前年
	 * @param curmonth 当前月
	 * @return
	 */
	List<String> findAllScoresignDays(@Param("tableName") String tableName,@Param("token")  String token, @Param("curyear") String curyear, @Param("curmonth") String curmonth);
}
