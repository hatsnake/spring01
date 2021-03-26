package com.hatsnake.spring01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	//초기 화면
	@RequestMapping(value="", method=RequestMethod.GET)
	public String index() {
		return "board/index";
	}
	
}