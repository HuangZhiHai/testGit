package com.hm.rms.controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hm.rms.entity.ProductionTask;
import com.hm.rms.service.MainService;
import com.hm.rms.util.EncryptUtil;
import org.apache.catalina.session.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hm.rms.entity.UserInfo;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
	@Resource
	private MainService mainService;
	@RequestMapping("/toMain1")
	public String toMain1(HttpServletRequest request){
//		String nickname = request.getParameter("nickname")==null?"":request.getParameter("nickname");
//		request.setAttribute("nickname", nickname);
		HttpSession session=request.getSession();
		UserInfo user=(UserInfo)
				session.getAttribute("user");
		request.setAttribute("nickname", user.getRealName());
		return "main";
	}
	@RequestMapping("/toMain")
	public String toMain(HttpServletRequest request){
//		String nickname = request.getParameter("nickname")==null?"":request.getParameter("nickname");
//		request.setAttribute("nickname", nickname);
		HttpSession session=request.getSession();
		UserInfo user=(UserInfo)
				session.getAttribute("user");
		request.setAttribute("nickname", user.getRealName());
		return "main";
	}
}
