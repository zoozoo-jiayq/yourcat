package com.yourcat.yourcat.test;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=2)
public class PersonAddListener implements ApplicationListener<PersonAddEvent> {

	public static int users = 0;
	
	@Override
	public void onApplicationEvent(PersonAddEvent event) {
		// TODO Auto-generated method stub
		System.out.println("注册用户数报表执行...");
		System.out.println(Thread.currentThread().getId()+"--------"+Thread.currentThread().getName());
		Person p = (Person) event.getSource();
		users++;
	}

}
