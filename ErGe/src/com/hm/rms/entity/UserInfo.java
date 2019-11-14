package com.hm.rms.entity;

import org.apache.ibatis.type.Alias;

@Alias("UserInfo")
public class UserInfo {
	private int id;
	private String realName;
	private String realNameSpell;
	private String userName;
	private String userPwd;
	private int roleId;
	private boolean deleted;
	private String eamilP;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getRealNameSpell() {
		return realNameSpell;
	}
	public void setRealNameSpell(String realNameSpell) {
		this.realNameSpell = realNameSpell;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public String getEamilP() {
		return eamilP;
	}
	public void setEamilP(String eamilP) {
		this.eamilP = eamilP;
	}
	
}
