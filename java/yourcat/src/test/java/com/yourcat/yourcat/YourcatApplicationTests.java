package com.yourcat.yourcat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.yourcat.yourcat.admin.user.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Service
public class YourcatApplicationTests {

	@Resource
	private UserService userService;
	
	@Test
	public void contextLoads() {
		
	}
	
	void test(){
		ConfigurationClassPostProcessor configurationClassPostProcessor = null;
		AbstractApplicationContext aac = null;
//		ObjectPostProcessorConfiguration objectPostProcessorConfiguration = null;
		
		SecurityAutoConfiguration securityAutoConfiguration = null;
//		org.springframework.boot.autoconfigure.security.servlet.SecurityRequestMatcherProviderAutoConfiguration,\
//		org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration,\
//		org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,\
//		org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration,\
//		org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration,\
	}
	
}
