package com.javabrains.springboot.app1.model;

public class Topic {

	private String id;
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Topic(String id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	public Topic() {
		super();
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", description=" + description + "]";
	}

}
