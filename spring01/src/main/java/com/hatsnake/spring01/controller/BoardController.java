package com.hatsnake.spring01.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hatsnake.spring01.service.BoardService;

@Controller //�����������̳ʰ� �ش� Ŭ���� ��ü(��) ���� (������� ��û �����ϱ� ���� ������̼�)
@RequestMapping(value="/board") //URL�� ��Ʈ�ѷ��� �޼ҵ�� �����ϱ� ���� ������̼�
public class BoardController {

	@Inject //��ü�� Ÿ���� ��ġ�ϴ� ��ü �ڵ� ����
	private BoardService boardService;
	//logger�� ���� ���� - System.out.println()���� ����¸��ҽ��� ���� ���, ���� ���Ϸ� �����ؼ� �м��� �� ����
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@RequestMapping(value="/test1", method=RequestMethod.GET)
	public String test1() {
		logger.info("controller test1");
		int result = boardService.test1();
		return "";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET) //URL�� ��Ʈ�ѷ��� �޼ҵ忡 �����ϱ� ���� ������̼�
	public String moveList() {
		logger.info("move list");
		return "board/list";
	}

	@RequestMapping(value="/write", method=RequestMethod.GET) //URL�� ��Ʈ�ѷ��� �޼ҵ忡 �����ϱ� ���� ������̼�
	public String moveWrite() {
		logger.info("move write");
		return "board/write";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET) //URL�� ��Ʈ�ѷ��� �޼ҵ忡 �����ϱ� ���� ������̼�
	public String moveView() {
		logger.info("move view");
		return "board/view";
	}
}
