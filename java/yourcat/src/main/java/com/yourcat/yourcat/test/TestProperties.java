package com.yourcat.yourcat.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(name="test",value= {"classpath:test.properties"})
public class TestProperties {

	@Value("${a}")
	private String a;

	@Value("${b}")
	private String b;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
	
	
}
