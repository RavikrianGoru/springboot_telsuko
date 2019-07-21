package com.javabrains.springboot.app.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.javabrains.springboot.app.topic.Topic;

@Entity
public class Course {

	@Id
	private String id;
	private String description;
	private String name;
	@ManyToOne
	private Topic topic;
	
	public Course(String id, String description, String name, String topic) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.topic=new Topic(topic, "", "");
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
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", description=" + description + ", name=" + name + ", topic=" + topic + "]";
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
