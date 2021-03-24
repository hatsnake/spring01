package com.hatsnake.spring01.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository //스프링컨테이너가 해당 클래스 객체 생성 (데이터베이스 연동 처리하기 위한 어노테이션)
public class BoardDAOImpl implements BoardDAO {
	// 의존성 주입 어노테이션
	// @Autowired : 객체의 타입이 일치하는 객체 자동 주입
	// @Inject : 객체의 타입이 일치하는 객체 자동 주입
	// @Resource : 객체의 이름이 일치하는 객체 자동 주입
	// @Qualifier : 사용할 의존 객체가 여러개일 때 선택하여 객체 자동 주입
	@Inject //객체의 타입이 일치하는 객체 자동 주입
	private SqlSession sqlSession;
	private static final String namespace = "com.hatsnake.spring01.mappers.BoardMapper";
}
