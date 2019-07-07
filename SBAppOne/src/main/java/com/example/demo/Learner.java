package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component makes this as spring bean can be available for DI.
//Default scope is singleton


@Component//Default name learner
@Scope(value = "singleton")
public class Learner {
	public Learner() {
		super();
		System.out.println("Learner object created.");
	}

	private int id;
	private String name;
	private String pLanguage;
	@Autowired//Default by type
	private IDE ide;
	@Autowired
	@Qualifier("laptopBean")
	private Laptop laptop;
	

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public IDE getIde() {
		return ide;
	}

	public void setIde(IDE ide) {
		this.ide = ide;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpLanguage() {
		return pLanguage;
	}

	public void setpLanguage(String pLanguage) {
		this.pLanguage = pLanguage;
	}

	@Override
	public String toString() {
		return "Learner [id=" + id + ", name=" + name + ", pLanguage=" + pLanguage + ", ide=" + ide + ", laptop="
				+ laptop + "]";
	}

	public void show()
	{
		System.out.println("This is Learner:"+this);
		this.getIde().show();
		this.getLaptop().show();
	}
}
