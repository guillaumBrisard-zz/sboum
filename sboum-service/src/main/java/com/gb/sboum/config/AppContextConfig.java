package com.gb.sboum.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ ServiceContextConfig.class, BusinessContextConfig.class, MongoDaoContextConfig.class,
		UtilsContextConfig.class })
public class AppContextConfig {

}
