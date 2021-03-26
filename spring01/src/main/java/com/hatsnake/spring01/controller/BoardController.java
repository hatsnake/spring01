package com.hatsnake.spring01.controller;

import java.util.List;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hatsnake.spring01.domain.BoardVO;
import com.hatsnake.spring01.domain.CommentsVO;
import com.hatsnake.spring01.domain.PageDTO;
import com.hatsnake.spring01.service.BoardService;

@Controller //스프링컨테이너가 해당 클래스 객체 생성 (사용자 요청 제어)
@RequestMapping(value="/board") //URL을 컨트롤러의 메소드와 매핑
public class BoardController {

	@Inject //객체의 타입과 일치하는 객체 자동 주입
	private BoardService boardService;
	//logger을 쓰는 이유 - System.out.println()보다 입출력리소스가 적게 들고, 따로 파일을 만들어 분석 가능
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	//게시판 리스트 페이지 이동
	@RequestMapping(value="/list", method=RequestMethod.GET) 
	public String moveList(Model model, @RequestParam(value="pageNum", defaultValue="1") int pageNum) {
		logger.info("move list");
		
		PageDTO page = new PageDTO();
		page.setPageNum(pageNum);
		page.setPageBlock(5);
		page.setPageSize(30);
		page.setCount(boardService.count());
		
		List<BoardVO> list = boardService.list(page);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		
		return "board/list";
	}
	
	//게시글 보기 페이지 이동
	//@RequestParam : 단일 파라미터를 전달받을 때 사용
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String moveView(Model model, @RequestParam int no) {
		logger.info("move view");
		BoardVO board = boardService.view(no);
		List<CommentsVO> comments = boardService.listComments(no);
		model.addAttribute("board", board);
		model.addAttribute("comments", comments);
		
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
	
	/* AJAX방식으로 댓글 작성 */
	@ResponseBody //리턴값으로 뷰를 출력하지 않고 값이 출력
	@RequestMapping(value="/writeComments", method=RequestMethod.POST)
	public String writeReply(CommentsVO commentsVO) {
		int result = boardService.writeComments(commentsVO);
		return Integer.toString(result);
	}
	
	/* AJAX방식으로 댓글 리스트 출력 */
	//produces : 명시한 MediaType과 같을때에 해당 type으로 응답을 보내준다.
	@ResponseBody
	@RequestMapping(value="/listComments", method= {RequestMethod.POST}, produces="application/json; charset=UTF-8")
	public String listComments(@RequestParam int bNo) {
		List<CommentsVO> list = boardService.listComments(bNo);
		
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			JSONObject value = new JSONObject();
			value.put("no", list.get(i).getNo());
			value.put("bNo", list.get(i).getbNo());
			value.put("id", list.get(i).getId());
			value.put("content", list.get(i).getContent());
			value.put("cDate", list.get(i).getcDate());
			array.add(value);
		}
		obj.put("result", array);
		System.out.println(obj.toString());
		return obj.toString();
	}
	
}
