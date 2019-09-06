package com.yourcat.yourcat.app.proxy;

public class AnimalProxy implements Animal {

	private Animal cat;
	
	public AnimalProxy(Animal cat) {
		super();
		this.cat = cat;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		cat.eat();
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		cat.walk();
	}

}
