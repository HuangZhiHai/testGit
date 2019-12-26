package com.hm.rms.service;

import java.util.Date;
import java.util.List;

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
	 * @param tableName 表面
	 * @param token 唯一标识
	 * @param createtime 创建时间
	 * @param date 签到日期
	 * @param nickName 昵称
	 * @param city 城市
	 * @param country 国家
	 * @param province 省份
	 * @param gender 性别
	 * @param avatarUrl 头像
	 */
	void scoresign(String tableName,String token,String createtime,String date,String nickName,String city,String country,String province,String gender,String avatarUrl);

	/**
	 * 查询签到次数
	 * @param tableName
	 * @param token
	 * @return
	 */
	int checkscoresign(String tableName,String token);
	/**
	 * 新建反馈表
	 * @param tableName
	 */
	void createFeedBackTable(String tableName);

	/**
	 * @param tableName 表名
	 * @param token 微信唯一表示
	 * @param fbType 返回类型
	 * @param textareaTxt 文本域内容
	 * @param inputTxt 电话号内容
	 * @param creattime 当前时间
	 */
	void feedBack(String tableName,String token,String creattime,String fbType,String textareaTxt,String inputTxt);
	/**
	 * 获取所有签到日期（当年，当月）
	 * @param token 微信唯一标识
	 * @param curyear 当前年
	 * @param curmonth 当前月
	 * @return
	 */
	List<String> findAllScoresignDays(String tableName,String token,String curyear,String curmonth);
}
