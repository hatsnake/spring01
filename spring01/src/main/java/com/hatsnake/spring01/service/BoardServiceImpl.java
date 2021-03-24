package com.hatsnake.spring01.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hatsnake.spring01.dao.BoardDAO;

//비즈니스 로직 : 사용자의 눈에는 보이지 않지만, 사용자가 바라는 결과물을 위한 코드
@Service //스프링컨테이너가 해당 클래스 객체 생성 (비즈니스 로직 처리하기 위한 어노테이션)
public class BoardServiceImpl implements BoardService {

	@Inject //객체의 타입이 일치하는 객체 자동 주입
	private BoardDAO boardDAO;
	
}
