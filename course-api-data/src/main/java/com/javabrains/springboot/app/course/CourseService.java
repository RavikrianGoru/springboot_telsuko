package com.javabrains.springboot.app.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.javabrains.springboot.app.course.Course;

@Service
public class CourseService {
	
	List<Course> courses= new ArrayList<>(Arrays.asList(new Course("1", "Java", "Java is platform","t1"), new Course("2",".Net", ".Net is platform", "t2"),new Course("3","Unix", "Unix is platform","t3")));
	
	public List<Course> getCourses() {
		return courses;
	}

	public Course getCourse(String id)
	{
		try
		{
			return courses.stream().filter((t)->{return t.getId().equalsIgnoreCase(id);}).findFirst().get();
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
	
	public Course addCourse(Course course)
	{
		courses.add(course);
		return getCourse(course.getId());
	}

	public Course updateCourse(String id, Course course) {
		Course old=null;
		try
		{
			old=courses.stream().filter((t)->{return t.getId().equalsIgnoreCase(id);}).findFirst().get();
			courses.remove(old);
			courses.add(course);
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
			old=courses.stream().filter((t)->{return t.getId().equalsIgnoreCase(id);}).findFirst().get();
			courses.remove(old);
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
		return old;
	}
}
