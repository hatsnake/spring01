package com.hatsnake.spring01.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hatsnake.spring01.domain.LoginVO;
import com.hatsnake.spring01.service.LoginService;

@Controller
public class IndexController {
	
	@Inject
	private LoginService loginService;
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	//초기 화면
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index(Model model) {
		logger.info("run index");
		
		LoginVO loginVO = new LoginVO();
		loginVO = loginService.getInfo();
		
		model.addAttribute("cpcode", loginVO.getCpcode());
		model.addAttribute("cdstf", loginVO.getCdstf());
		model.addAttribute("username", loginVO.getUsername());
		
		return "board/index";
	}
	
}
