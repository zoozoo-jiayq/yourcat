package com.yourcat.yourcat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.security.config.annotation.configuration.ObjectPostProcessorConfiguration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.yourcat.yourcat.app.user.User;
import com.yourcat.yourcat.app.user.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Service
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
		ConfigurationClassPostProcessor configurationClassPostProcessor = null;
		AbstractApplicationContext aac = null;
		ObjectPostProcessorConfiguration objectPostProcessorConfiguration = null;
		
		SecurityAutoConfiguration securityAutoConfiguration = null;
//		org.springframework.boot.autoconfigure.security.servlet.SecurityRequestMatcherProviderAutoConfiguration,\
//		org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration,\
//		org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration,\
//		org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration,\
//		org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration,\
	}
	
}
