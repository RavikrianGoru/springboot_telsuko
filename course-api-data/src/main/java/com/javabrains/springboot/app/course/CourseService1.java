package com.javabrains.springboot.app.course;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService1 {
	
	@Autowired
	CourseRepository courseRepo;
	
	public List<Course> getCourses(String id) {
		List<Course> courses=new ArrayList<>();
		courseRepo.findByTopicId(id).forEach(courses::add);
		return courses;
	}

	public Course getCourse(String id)
	{
		try
		{
			return courseRepo.findById(id).get();
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
	
	public Course addCourse(Course course)
	{
		courseRepo.save(course);
		return getCourse(course.getId());
	}

	public Course updateCourse(Course course) {
		Course old=null;
		try
		{
			courseRepo.save(course);//save can be used for save and update
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
		return course;
	}

	public Course deleteCourse(String id) {
		Course old=null;
		try
		{
			courseRepo.deleteById(id);
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
		return old;
	}
}
