package com.hatsnake.spring01.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hatsnake.spring01.service.LoginService;

@Controller
public class LoginController {
	@Inject
	private LoginService loginService;
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login/loginPage")
	public String loginPage() {
		return "login/loginPage";
	}
	
	@RequestMapping(value="/login/accessDenied")
	public String accessDeniedPage() throws Exception {
		return "login/accessDenied";
	}
}
