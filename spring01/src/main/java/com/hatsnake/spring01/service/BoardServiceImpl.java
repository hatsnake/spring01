package com.hatsnake.spring01.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hatsnake.spring01.dao.BoardDAO;

//����Ͻ� ���� : ������� ������ ������ ������, ����ڰ� �ٶ�� ������� ���� �ڵ�
@Service //�����������̳ʰ� �ش� Ŭ���� ��ü ���� (����Ͻ� ���� ó���ϱ� ���� ������̼�)
public class BoardServiceImpl implements BoardService {

	@Inject //��ü�� Ÿ���� ��ġ�ϴ� ��ü �ڵ� ����
	private BoardDAO boardDAO;
	
}
