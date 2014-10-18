package com.gb.sboum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gb.sboum.business.FirstBusiness;

@Configuration
public class BusinessContextConfig {

	@Bean
	public FirstBusiness firstBusiness() {
		return new FirstBusiness();
	}

}
