package com.hatsnake.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hatsnake.spring01.domain.BoardVO;
import com.hatsnake.spring01.service.BoardService;

@Controller //스프링컨테이너가 해당 클래스 객체 생성 (사용자 요청 제어)
@RequestMapping(value="/board") //URL을 컨트롤러의 메소드와 매핑
public class BoardController {

	@Inject //객체의 타입과 일치하는 객체 자동 주입
	private BoardService boardService;
	//logger을 쓰는 이유 - System.out.println()보다 입출력리소스가 적게 들고, 따로 파일을 만들어 분석 가능
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	//테스트 메소드 (사용X)
	@RequestMapping(value="/test1", method=RequestMethod.GET) //URL을 컨트롤러의 메소드와 매핑
	public String test1() {
		logger.info("controller test1");
		int result = boardService.test1();
		return "";
	}
	
	//게시판 리스트 페이지 이동
	@RequestMapping(value="/list", method=RequestMethod.GET) 
	public String moveList(Model model, @RequestParam(value="pageNum", defaultValue="1") int pageNum) {
		logger.info("move list");
		List<BoardVO> list = boardService.list();
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	//게시글 보기 페이지 이동
	//@RequestParam : 단일 파라미터를 전달받을 때 사용
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String moveView(Model model, @RequestParam int no) {
		logger.info("move view");
		BoardVO board = boardService.view(no);
		model.addAttribute("board", board);
		
		return "board/view";
	}
	
	//게시글 등록 페이지 이동
	@RequestMapping(value="/write", method=RequestMethod.GET) 
	public String moveWrite(Model model, BoardVO boardVO) {
		logger.info("move write");
		model.addAttribute("board", boardVO);
		
		return "board/write";
	}

	//게시글 등록 처리 
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String writePro(BoardVO boardVO) {
		logger.info("writePro");
		logger.info(boardVO.toString());
		int result = boardService.write(boardVO);
		
		
		return "redirect:/board/list";
	}
	
}
