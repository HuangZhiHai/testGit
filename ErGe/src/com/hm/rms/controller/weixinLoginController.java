package com.hm.rms.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hm.rms.service.WxLoginService;

import WxCommonUtils.WxTableName;
@Controller
@RequestMapping("/api")
public class weixinLoginController {
	@Resource
	WxLoginService wxlogin;//微信登录service
	private final static long times = 60L;
	private final static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 获取openId
     * @param code
     * @return
     */
    @ResponseBody
   	@RequestMapping(value = "/getOpenid", method = RequestMethod.GET)
    public  Map<String,Object> getOpenid(String code,HttpServletResponse response) {//接收用户传过来的code，required=false表明如果这个参数没有传过来也可以。
    	
    	Map<String,Object> maps = new HashMap<>();
        if ("undefined".equals(code) || code == null || "".equals(code)) {
            return null;
        }
        try{
  	  		//接收从客户端获取的code
	  	   	WxUnifiedOrder wx = new WxUnifiedOrder();
			Map<String, String> map = wx.getAccess_tokenByCode(code,response);
			String openid=	map.get("openid");
			String sessionkey= map.get("access_token");//定义两个变量存储得到的openid和session_key.
			maps.put("code",200);
			maps.put("openid", openid);
			maps.put("sessionkey",sessionkey);
			if(openid != null && sessionkey != null && !"".equals(sessionkey) && !"".equals(openid)){
				 String tableName = WxTableName.WX_LOGIN_TABLENAME;
				 //判断表是否存在
				 int counts = wxlogin.existTable(tableName);
				 if(counts != 1){
					 //不存在就新增
					 wxlogin.createNewTable(tableName);
				 }
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 //新增登录 记录
				 wxlogin.wxLoginInsert(tableName,openid,sessionkey,sdf.format(new Date()).toString());
			 }
        }catch(Exception e){
			maps.put("code",400);
        	maps.put("openid", "");
            maps.put("sessionkey","");
            e.printStackTrace();
        }
         return maps;//返回openid
   }
	/**
	 * 查询token 是否失效
	 * @param token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getTokenStatus", method = RequestMethod.GET)
	public  Map<String,Object> getTokenStatus(String token,HttpServletResponse response) {//接收用户传过来的token，required=false表明如果这个参数没有传过来也可以。

		Map<String,Object> maps = new HashMap<>();
		if ("undefined".equals(token) || token == null || "".equals(token)) {
			return null;
		}
		try{
			String tableName = WxTableName.WX_LOGIN_TABLENAME;
			//判断表是否存在
			int counts = wxlogin.existTable(tableName);
			if(counts != 1){
				maps.put("code",400);
				return maps;//返回openid
			}
			//新增登录 记录
			boolean b = wxlogin.getTokenStatus(tableName,token,times);
			if(b){
				maps.put("code",200);
			}
		}catch(Exception e){
			maps.put("code",400);
			e.printStackTrace();
		}
		return maps;//返回openid
	}
    //发起get请求的方法。
   	public  String GET(String url) {
   		String result = "";
   		BufferedReader in = null;
   		InputStream is = null;
   		InputStreamReader isr = null;
   		try {
   			URL realUrl = new URL(url);
   			URLConnection conn = realUrl.openConnection();
   			conn.connect();
   			Map<String, List<String>> map = conn.getHeaderFields();
   			is = conn.getInputStream();
   			isr = new InputStreamReader(is);
   			in = new BufferedReader(isr);
   			String line;
   			while ((line = in.readLine()) != null) {
   				result += line;
   			}
   		} catch (Exception e) {
   			// 异常记录
   		} finally {
   			try {
   				if (in != null) {
   					in.close();
   				}
   				if (is != null) {
   					is.close();
   				}
   				if (isr != null) {
   					isr.close();
   				}
   			} catch (Exception e2) {
   				// 异常记录
   			}
   		}
   		return result;
   	}

	/**
	 * 签到
	 * @param token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/scoresign", method = RequestMethod.GET)
	public  Map<String,Object> scoresign(String token,HttpServletResponse response) {//接收用户传过来的token，required=false表明如果这个参数没有传过来也可以。

		Map<String,Object> maps = new HashMap<>();
		if ("undefined".equals(token) || token == null || "".equals(token)) {
			return null;
		}
		try{
			String tableName = WxTableName.WX_SCORESIGN_TABLENAME;
			//判断表是否存在
			int counts = wxlogin.existTable(tableName);
			if(counts != 1){
				wxlogin.createSignTable(tableName);
			}
			//当天是否存在签到记录
			boolean b = wxlogin.existsSignRecord(tableName,token,sdfDate.format(new Date()).toString());
			if(!b){
				//新增签到记录
				wxlogin.scoresign(tableName,token,sdfTime.format(new Date()).toString(),sdfDate.format(new Date()).toString());
			}
			maps.put("code",200);
		}catch(Exception e){
			maps.put("code",400);
			e.printStackTrace();
		}
		return maps;//返回openid
	}

	/**
	 * 查询签到次数
	 * @param token
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/checkscoresign", method = RequestMethod.GET)
	public  Map<String,Object> checkscoresign(String token,HttpServletResponse response) {//接收用户传过来的token，required=false表明如果这个参数没有传过来也可以。

		Map<String,Object> maps = new HashMap<>();
		if ("undefined".equals(token) || token == null || "".equals(token)) {
			return null;
		}
		try{
			String tableName = WxTableName.WX_SCORESIGN_TABLENAME;
			//判断表是否存在
			int counts = wxlogin.checkscoresign(tableName,token);
			boolean b = wxlogin.existsSignRecord(tableName,token,sdfDate.format(new Date()).toString());
			maps.put("code",200);
			maps.put("data",counts);
			maps.put("score_sign_t",b?1:0);
		}catch(Exception e){
			maps.put("code",400);
			maps.put("data",null);
			e.printStackTrace();
		}
		return maps;//返回openid
	}
}
