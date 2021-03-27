package com.hatsnake.spring01.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hatsnake.spring01.dao.LoginDAO;
import com.hatsnake.spring01.domain.LoginVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO loginDAO;
	
	@Override
	public LoginVO getInfo() {
		return loginDAO.getInfo();
	}

}
