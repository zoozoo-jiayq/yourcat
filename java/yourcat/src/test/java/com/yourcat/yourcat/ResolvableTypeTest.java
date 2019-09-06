package com.yourcat.yourcat;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.core.ResolvableType;

public class ResolvableTypeTest {

	private ArrayList<String> arrays = new ArrayList<String>();
	
	@Test
	public void test() throws NoSuchFieldException, SecurityException {
		ResolvableType rt = ResolvableType.forField(this.getClass().getDeclaredField("arrays"));
		System.out.println(rt.getSuperType().getRawClass().getName());
		System.out.println(rt.getSuperType().getType().getTypeName());
		System.out.println(rt.getRawClass().getName());
		System.out.println(rt.getInterfaces());
		
		System.out.println(rt.asCollection().resolve().getName());
		
		System.out.println(rt.getGeneric(0));
		System.out.println(rt.getGeneric(0).resolve());
		
		System.out.println(rt.resolveGeneric(1));
	}
	
}
