package com.hatsnake.spring01.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hatsnake.spring01.service.BoardService;

@Controller //�����������̳ʰ� �ش� Ŭ���� ��ü(��) ���� (������� ��û �����ϱ� ���� ������̼�)
@RequestMapping(value="/board") //URL�� ��Ʈ�ѷ��� �޼ҵ�� �����ϱ� ���� ������̼�
public class BoardController {

	@Inject //��ü�� Ÿ���� ��ġ�ϴ� ��ü �ڵ� ����
	private BoardService boardService;
	//logger�� ���� ���� - println���� ����¸��ҽ��� ���� ���, ���� ���Ϸ� �����ؼ� �м��� �� ����
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
}
