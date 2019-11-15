package com.hm.rms.service;

import java.util.Date;

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
}