package com.yourcat.yourcat.app.proxy;

public class Zoozoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		AnimalProxy cp = new AnimalProxy(cat);
		cp.eat();
		cp.walk();
	}

}
