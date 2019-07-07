package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("laptopBean")//Default name laptop
@Scope(value = "prototype")
public class Laptop {
	private String name;

	public Laptop() {
		super();
		System.out.println("Laptop object created");
	}

	@Override
	public String toString() {
		return "Laptop [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void show() {
		System.out.println("This is Laptop:" + this);
	}

}
