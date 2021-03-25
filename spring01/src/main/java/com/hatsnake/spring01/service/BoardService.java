package com.hatsnake.spring01.service;

import java.util.List;

import com.hatsnake.spring01.domain.BoardVO;
import com.hatsnake.spring01.domain.PageDTO;

public interface BoardService {

	int test1();

	List<BoardVO> list(PageDTO page);
	
	BoardVO view(int no);
	
	int write(BoardVO boardVO);

	int count();
	
}
