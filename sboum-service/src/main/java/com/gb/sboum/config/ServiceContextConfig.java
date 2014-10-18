package com.gb.sboum.config;

import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gb.sboum.service.aspect.LoggableEndpointAspect;
import com.gb.sboum.service.mapper.UserMapper;

import fr.xebia.extras.selma.Selma;

@Configuration
public class ServiceContextConfig {

	// No need to instantiate Jersey Resources, it's already done through Jersey

	@Bean
	public LoggableEndpointAspect loggableEndpointAspect() {
		return Aspects.aspectOf(LoggableEndpointAspect.class);
	}

	@Bean
	UserMapper mapperUser() {
		return Selma.builder(UserMapper.class).disableCache().build();
	}

}
