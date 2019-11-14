package com.hm.rms.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.hm.rms.entity.UserInfo;
import com.hm.rms.service.LoginService;
import com.hm.rms.util.EncryptUtil;
import com.hm.rms.util.getOpenIdUtils;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	LoginService loginService;
	
	@RequestMapping("/toLogin")
	public String toLogin(){
		return "login/login";
	}
	@RequestMapping("/toMain")
	public String toMain(){
		return "main/main";
	}
	@ResponseBody
	@RequestMapping("/login")
	public Map<String,Object> login(
			String userName,
			String password,
			HttpSession session,HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		EncryptUtil eu=new EncryptUtil();
		String pwd=eu.SHA256(userName+" "+password);
		UserInfo user=loginService.login(userName, pwd);
		if(user!=null){
			map.put("success",true);
			map.put("msg","登陆成功");
			request.setAttribute("nickname", user.getRealName());
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(300);
		}else{
			map.put("success",false);
			map.put("msg","账号或者密码不正确");
		}
		return map;
	}
	@RequestMapping("/toRegistration")
	public String toRegistration(){
		return "login/registration";
	}
	/**
	 * 注册
	 * @param username 用户名
	 * @param PWD 密码
	 * @param nickname 昵称
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/toSubmitData",produces = "application/json; charset=utf-8")
	public  String getSubmitDateRegistration(String username,String PWD,String nickname ,HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String email = request.getParameter("email");
		EncryptUtil eu=new EncryptUtil();
		String pwd=eu.SHA256(username+" "+PWD);
		UserInfo user = this.loginService.registration(username);
		String	result = "";
		if(user!=null){
			String str = "{\"data\":\"用户名已存在！\"}";
			result=str.toString();
		}else{
			loginService.regInsert(nickname, username, pwd, email, 1);
			result="{\"data\":\"success\"}";
		}
		return result;
		
	}
}
