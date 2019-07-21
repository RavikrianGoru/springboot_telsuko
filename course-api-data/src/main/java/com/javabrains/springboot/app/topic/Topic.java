package com.javabrains.springboot.app.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

	@Id
	private String id;
	private String description;
	private String name;
	
	public Topic(String id, String description, String name) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public Topic() {
		super();
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", description=" + description + ", name=" + name + "]";
	}

}
