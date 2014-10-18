package com.gb.sboum.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.gb.sboom.model.User;
import com.gb.sboum.mongodao.UserDao;
import com.gb.sboum.utils.log.Loggable;

public class FirstBusiness {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(FirstBusiness.class);

	@Autowired
	private UserDao userDao;

	@Loggable
	public String sayPlainTextHi() {
		return "Hi folks !!!";
	}

	public User getUser(String id) {
		return userDao.findUser(id);
	}

}
