package com.hatsnake.spring01.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hatsnake.spring01.service.BoardService;

@Controller //스프링컨테이너가 해당 클래스 객체(빈) 생성 (사용자의 요청 제어하기 위한 어노테이션)
@RequestMapping(value="/board") //URL을 컨트롤러의 메소드와 매핑하기 위한 어노테이션
public class BoardController {

	@Inject //객체의 타입이 일치하는 객체 자동 주입
	private BoardService boardService;
	//logger을 쓰는 이유 - System.out.println()보다 입출력리소스가 적게 들고, 따로 파일로 저장해서 분석할 수 있음
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public String test1() {
		logger.info("controller test1");
		int result = boardService.test1();
		return "";
	}
}
