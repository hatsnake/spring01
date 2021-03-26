package com.hatsnake.spring01.dao;

import java.util.List;

import com.hatsnake.spring01.domain.BoardVO;
import com.hatsnake.spring01.domain.CommentsVO;
import com.hatsnake.spring01.domain.PageDTO;

public interface BoardDAO {

	List<BoardVO> list(PageDTO page);

	BoardVO view(int no);	
	
	int write(BoardVO boardVO);
	
	void replyShape(BoardVO boardVO);

	int replyWrite(BoardVO boardVO);

	int count();

	int writeComments(CommentsVO commentsVO);

	List<CommentsVO> listComments(int bNo);



}
