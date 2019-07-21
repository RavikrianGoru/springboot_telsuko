package com.javabrains.springboot.app.course;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> 
{
	// public List<Course> findByProperty(String ---);
	public List<Course> findByName(String name);
	
	public List<Course> findByTopicId(String topicId); //here Topic in not wrapper TopicId
}
