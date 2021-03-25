package com.hatsnake.spring01.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hatsnake.spring01.dao.BoardDAO;
import com.hatsnake.spring01.domain.BoardVO;
import com.hatsnake.spring01.domain.PageDTO;

@Service //스프링컨테이너가 해당 클래스의 객체 생성 (비즈니스로직 처리)
public class BoardServiceImpl implements BoardService {

	@Inject //객체의 타입이 일치하는 객체 자동 주입
	private BoardDAO boardDAO;
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Override
	public int test1() {
		logger.info("service test1");
		return boardDAO.test1();
	}

	@Override
	public List<BoardVO> list(PageDTO page) {
		page.setStartRow((page.getPageNum() - 1) * page.getPageSize() + 1);
		page.setEndRow(page.getStartRow() + page.getPageSize() - 1);
		return boardDAO.list(page);
	}
	
	@Override
	public BoardVO view(int no) {
		return boardDAO.view(no);
	}
	
	@Override
	public int write(BoardVO boardVO) {
		if(boardVO.getgNo() == 0) {
			return boardDAO.write(boardVO);
		} else {
			boardDAO.replyShape(boardVO);
			return boardDAO.replyWrite(boardVO);
		}
	}

	@Override
	public int count() {
		return boardDAO.count();
	}
	
}
