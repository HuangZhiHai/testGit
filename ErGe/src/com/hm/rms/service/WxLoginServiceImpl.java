package com.hm.rms.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hm.rms.dao.WxLoginDao;
@Transactional
@Service
public class WxLoginServiceImpl implements WxLoginService{
	@Resource
	private WxLoginDao wxloginDao;
	/**
	 * 微信登录
	 */
	@Override
	public void wxLoginInsert(String tableName,String openid, String session_key, String date) {
		wxloginDao.wxLoginInsert(tableName,openid,session_key,date);
	}
	/**
	 * 判断数据库表名是否存在
	 * @param tableName
	 * @return
	 */
	public Integer existTable(String tableName){
		return wxloginDao.existTable(tableName);
	}
	@Override
	public void createNewTable(String tableName) {
		wxloginDao.createNewTable(tableName);
	}

	/**
	 * 判断此token是否失效
	 * @param tableName
	 * @param token
	 * @param times
	 * @return
	 */
	public boolean getTokenStatus(String tableName,String token,long times){
		return wxloginDao.getTokenStatus(tableName,token,times);
	}

	/**
	 * 新建签到表
	 * @param tableName
	 */
	@Override
	public void createSignTable(String tableName) {
		wxloginDao.createSignTable(tableName);
	}

	/**
	 * 是否存在签到记录
	 * @param tableName
	 * @param date
	 * @return
	 */
	public boolean existsSignRecord(String tableName,String token,String date){
		return wxloginDao.existsSignRecord(tableName,token,date);
	}
	/**
	 * 签到
	 * @param tableName
	 * @param token
	 * @return
	 */
	public void scoresign(String tableName,String token,String createtime,String date,String nickName,String city,String country,String province,String gender,String avatarUrl){
		 wxloginDao.scoresign(tableName,token,createtime,date,nickName,city,country,province,gender,avatarUrl);
	}

	/**
	 * 查询签到次数
	 * @param tableName
	 * @param token
	 * @return
	 */
	public int checkscoresign(String tableName,String token){
		return wxloginDao.checkscoresign(tableName,token);
	}
	/**
	 * 新建反馈表
	 * @param tableName
	 */
	@Override
	public void createFeedBackTable(String tableName) {
		wxloginDao.createFeedBackTable(tableName);
	}

	/**
	 * @param tableName 表名
	 * @param token 微信唯一表示
	 * @param fbType 返回类型
	 * @param textareaTxt 文本域内容
	 * @param inputTxt 电话号内容
	 * @param creattime 当前时间
	 */
	public void feedBack(String tableName,String token,String creattime,String fbType,String textareaTxt,String inputTxt){
		wxloginDao.feedBack(tableName,token,creattime,fbType,textareaTxt,inputTxt);
	}
	/**
	 * 获取所有签到日期（当年，当月）
	 * @param token 微信唯一标识
	 * @param curyear 当前年
	 * @param curmonth 当前月
	 * @return
	 */
	public List<String> findAllScoresignDays(String tableName, String token, String curyear, String curmonth){
		return wxloginDao.findAllScoresignDays(tableName, token, curyear, curmonth);
	}
}
