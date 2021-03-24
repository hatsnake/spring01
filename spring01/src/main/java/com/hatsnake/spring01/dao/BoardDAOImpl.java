package com.hatsnake.spring01.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository //�����������̳ʰ� �ش� Ŭ���� ��ü ���� (�����ͺ��̽� ���� ó���ϱ� ���� ������̼�)
public class BoardDAOImpl implements BoardDAO {
	// ������ ���� ������̼�
	// @Autowired : ��ü�� Ÿ���� ��ġ�ϴ� ��ü �ڵ� ����
	// @Inject : ��ü�� Ÿ���� ��ġ�ϴ� ��ü �ڵ� ����
	// @Resource : ��ü�� �̸��� ��ġ�ϴ� ��ü �ڵ� ����
	// @Qualifier : ����� ���� ��ü�� �������� �� �����Ͽ� ��ü �ڵ� ����
	@Inject //��ü�� Ÿ���� ��ġ�ϴ� ��ü �ڵ� ����
	private SqlSession sqlSession;
	private static final String namespace = "com.hatsnake.spring01.mappers.BoardMapper";
}
