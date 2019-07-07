package com.example.webapp.model;

public class Student {
	private int id;
	private String name;
	private double avg;

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

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", avg=" + avg + "]";
	}

	public Student(int id, String name, double avg) {
		super();
		this.id = id;
		this.name = name;
		this.avg = avg;
	}

}
