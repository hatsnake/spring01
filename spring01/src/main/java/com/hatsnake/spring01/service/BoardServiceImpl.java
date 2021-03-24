package com.hatsnake.spring01.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hatsnake.spring01.dao.BoardDAO;

//����Ͻ� ���� : ������� ������ ������ ������, ����ڰ� �ٶ�� ������� ���� �ڵ�
@Service //�����������̳ʰ� �ش� Ŭ���� ��ü ���� (����Ͻ� ���� ó���ϱ� ���� ������̼�)
public class BoardServiceImpl implements BoardService {

	@Inject //��ü�� Ÿ���� ��ġ�ϴ� ��ü �ڵ� ����
	private BoardDAO boardDAO;
	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);

	@Override
	public int test1() {
		logger.info("service test1");
		return boardDAO.test1();
	}
	
}
