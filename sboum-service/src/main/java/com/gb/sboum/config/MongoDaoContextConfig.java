package com.gb.sboum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gb.sboum.mongodao.UserDao;

@Configuration
public class MongoDaoContextConfig {

	// No need to instantiate Jersey Resources, it's already done through Jersey

	@Bean
	public UserDao userDao() {
		return new UserDao();
	}

}
