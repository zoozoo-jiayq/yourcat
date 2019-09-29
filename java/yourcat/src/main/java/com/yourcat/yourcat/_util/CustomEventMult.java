package com.yourcat.yourcat._util;

import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

@Component("applicationEventMulticaster")
public class CustomEventMult extends SimpleApplicationEventMulticaster{

	@PostConstruct
	public void init() {
		super.setTaskExecutor(Executors.newFixedThreadPool(10));
	}

	
}
