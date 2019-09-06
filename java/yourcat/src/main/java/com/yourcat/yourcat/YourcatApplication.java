package com.yourcat.yourcat;

import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.yourcat.yourcat.app.user.UserController;

@SpringBootApplication
public class YourcatApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourcatApplication.class, args);
		
		BeanFactory bf = null;
		ApplicationContext context = null;
		UserController UC = context.getBean(UserController.class);
	}

}
