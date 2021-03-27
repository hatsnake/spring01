package com.hatsnake.spring01.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hatsnake.spring01.domain.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.hatsnake.spring01.mappers.LoginMapper";
	
	@Override
	public LoginVO getInfo() {
		return sqlSession.selectOne(namespace+".getInfo");
	}

}
