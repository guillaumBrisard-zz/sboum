package com.gb.sboum.config;

import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gb.sboum.utils.log.LoggableAspect;
import com.gb.sboum.utils.log.LoggableAspectHelper;
import com.gb.sboum.utils.log.LoggableHelper;

@Configuration
public class UtilsContextConfig {

	@Bean
	public LoggableHelper loggableHelper() {
		return new LoggableHelper();
	}

	@Bean
	public LoggableAspectHelper loggableAspectHelper() {
		return new LoggableAspectHelper();
	}

	@Bean
	public LoggableAspect loggableAspect() {
		return Aspects.aspectOf(LoggableAspect.class);
	}

}
