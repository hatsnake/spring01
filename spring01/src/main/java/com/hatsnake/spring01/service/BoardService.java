package com.hatsnake.spring01.service;

import java.util.List;

import com.hatsnake.spring01.domain.BoardVO;

public interface BoardService {

	int test1();

	List<BoardVO> list();
	
	BoardVO view(int no);
	
	int write(BoardVO boardVO);
	
}
