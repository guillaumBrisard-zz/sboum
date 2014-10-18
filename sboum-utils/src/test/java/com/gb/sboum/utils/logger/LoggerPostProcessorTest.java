package com.gb.sboum.utils.logger;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

import com.gb.sboum.utils.logger.InjectLogger;
import com.gb.sboum.utils.logger.LoggerPostProcessor;

public class LoggerPostProcessorTest {

	DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

	@Before
	public void setupFactory() {
		BeanDefinition beanDef = new RootBeanDefinition(Bean.class /* , RootBeanDefinition.AUTOWIRE_BY_TYPE, true */);
		factory.addBeanPostProcessor(new LoggerPostProcessor());
		factory.registerBeanDefinition("bean", beanDef);
	}

	@Test
	public void injectLogger() {
		Bean bean = factory.getBean("bean", Bean.class);
		assertNotNull(bean);
		assertNotNull(bean.logger);
		bean.doSomething();
	}
}

class Bean {

	@InjectLogger
	Logger logger;

	void doSomething() {
		logger.debug("message");
	}
}
