package com.hatsnake.spring01.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository //스프링컨테이너가 해당 클래스의 객체 생성 (데이터베이스 연동 처리
public class BoardDAOImpl implements BoardDAO {
	// 의존성 주입
	// @Autowired : 객체의 타입이 일치하는 객체 자동 주입
	// @Inject : 객체의 타입이 일치하는 객체 자동 주입
	// @Resource : 객체의 이름
	// @Qualifier : 객체의 타입이 일치하는 객체가 두개일때 선택
	@Inject //객체의 타입이 일치하는 객체 자동 주입
	private SqlSession sqlSession;
	private static final String namespace = "com.hatsnake.spring01.mappers.BoardMapper";
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	@Override
	public int test1() {
		logger.info("dao test1");
		return sqlSession.insert(namespace+".test1");
	}
}
