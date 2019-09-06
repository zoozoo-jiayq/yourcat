package com.yourcat.yourcat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.BackgroundPreinitializer;
import org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityRequestMatcherProviderAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer;
import org.springframework.boot.context.ContextIdApplicationContextInitializer;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.config.DelegatingApplicationContextInitializer;
import org.springframework.boot.context.config.DelegatingApplicationListener;
import org.springframework.boot.context.event.EventPublishingRunListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.yourcat.yourcat.app.user.User;
import com.yourcat.yourcat.app.user.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YourcatApplicationTests {

	@Resource
	private UserService userService;
	
	@Test
	public void contextLoads() {
		User u = new User();
		u.setName("lisi");
		PasswordEncoder bc = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		pc = new  SCryptPasswordEncoder();
		String pwd = bc.encode("123456");
		u.setPassword(pwd);
		u.setRole("ADMIN");
		userService.save(u);
		
		User u1 = new User();
		u1.setName("zhangsan");
		pwd = bc.encode("123456");
		u1.setPassword(pwd);
		u1.setRole("USER");
		userService.save(u1);
	}
	
	void test(){
		EventPublishingRunListener eventPublishingRunListener = null;
		
		//初始化applicationContext
//		SharedMetadataReaderFactoryContextInitializer sm = null;
		ConditionEvaluationReportLoggingListener crl = null;
		ConfigurationWarningsApplicationContextInitializer ca = null;
		ContextIdApplicationContextInitializer cida = null;
		DelegatingApplicationContextInitializer dac = null;
		ServerPortInfoApplicationContextInitializer sac = null;
		
		//监听ApplicationContextInitializedEvent
		BackgroundPreinitializer bp = null;
		DelegatingApplicationListener dal = null;
		
		//beanFactoryPostProcessor
//		SharedMetadataReaderFactoryContextInitializer src = null;
		ConfigurationWarningsApplicationContextInitializer cdci = null;
		ConfigFileApplicationListener cfal = null;
		ConfigurationClassPostProcessor ccpp = null;
		
		//security
		SecurityAutoConfiguration securityAutoConfiguration = null;
		SecurityRequestMatcherProviderAutoConfiguration securityRequestMatcheProviderAutoConfiguration = null;
		UserDetailsServiceAutoConfiguration UserDetailsServiceAutoConfiguration = null;
		SecurityFilterAutoConfiguration  securityFilterAutoConfiguration = null;
		ReactiveSecurityAutoConfiguration reactiveSecurityAutoConfiguration = null;
		ReactiveUserDetailsServiceAutoConfiguration reactiveUserDetailsServiceAutoConfiguration = null;
	}
	
}
