package com.yourcat.yourcat;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class Test1 {

	@Test
	public void test() {
		Deque<String> deque = new ArrayDeque<>();
		deque.add("a");
		deque.add("b");
		deque.add("c");
		System.out.println(deque.poll());
		System.out.println(deque.poll());
		System.out.println(deque.poll());
	}
}
