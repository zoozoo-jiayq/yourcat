package com.yourcat.yourcat.publicevent;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.yourcat.yourcat._util.ApplicationContextHolder;
import com.yourcat.yourcat.test.Person;
import com.yourcat.yourcat.test.PersonAddEvent;
import com.yourcat.yourcat.test.PersonAddListener;
import com.yourcat.yourcat.test.PersonAddListener2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringEventPublishTest {

	@Test
	public void test() {
		List<Person> persons = new ArrayList<>();
		
		Person p1 = new Person(1,24);
		persons.add(p1);
		
		Person p2 = new Person(0,24);
		Person p3 = new Person(1,24);
		persons.add(p2);
		persons.add(p3);
		
		ApplicationContextHolder.getContext().publishEvent(new PersonAddEvent(p1));
		ApplicationContextHolder.getContext().publishEvent(new PersonAddEvent(p2));
		ApplicationContextHolder.getContext().publishEvent(new PersonAddEvent(p3));
		
		System.out.println(PersonAddListener.users);
		System.out.println(PersonAddListener2.men+":"+PersonAddListener2.women);
		
		AbstractApplicationContext abstractApplicationContext = null;
		
		System.out.println(Thread.currentThread().getId()+"---"+Thread.currentThread().getName());
	}
	
}
