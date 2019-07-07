package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class IDE {
	private String name;
	private boolean isFree;

	public IDE() {
		super();
		System.out.println("IDE object created.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFree() {
		return isFree;
	}

	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}

	@Override
	public String toString() {
		return "IDE [name=" + name + ", isFree=" + isFree + "]";
	}

	public void show() {
		System.out.println("This is IDE:" + this);
	}

}
