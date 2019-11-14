package com.hm.rms.entity;

import java.util.Date;

import org.apache.ibatis.type.Alias;
/**
 * 微信登录 储存openid 和 sessoinKey的表
 * @author hzh
 *
 */
@Alias("WxLogin")
public class WxLogin {
	private int id;//主键ID
	private String openid;//openId
	private String session_key;//
	private String time;//时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
