package com.yourcat.yourcat.test;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class PersonAddListener2 implements ApplicationListener<PersonAddEvent> {

	public static int men = 0;
	public static int women = 0;
	
	@Override
	public  void onApplicationEvent(PersonAddEvent event) {
		// TODO Auto-generated method stub
		System.out.println("男女比例报表执行...");
		Person p = (Person) event.getSource();
		if(p.getSex() == 0) {
			women++;
		}else {
			men++;
		}
	}

}
