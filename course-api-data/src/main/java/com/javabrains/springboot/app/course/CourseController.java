package com.javabrains.springboot.app.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.springboot.app.course.Course;
import com.javabrains.springboot.app.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService1 courseService;

	@RequestMapping(path = "/topics/{topicId}/courses", method = RequestMethod.GET)
	public List<Course> getCourses(@PathVariable("topicId") String topicId) {
		return courseService.getCourses(topicId);
	}

	@RequestMapping(path="/topics/{topicId}/courses/{id}", method = RequestMethod.GET)
	public Course getCourse(@PathVariable("topicId") String topicId, @PathVariable("id") String id)
	{
		return courseService.getCourse(id);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
	public Course addCourse(@PathVariable("topicId") String topicId,@RequestBody Course course)
	{
		course.setTopic(new Topic(topicId, "", ""));
		return courseService.addCourse(course);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
	public Course updateCourse(@PathVariable("topicId") String topicId,@RequestBody Course course, @PathVariable("id") String id)
	{
		course.setTopic(new Topic(topicId, "", ""));
		return courseService.updateCourse(course);
	}
	
	@RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
	public Course deleteCourse(@PathVariable("topicId") String topicId,@PathVariable("id") String id)
	{
		return courseService.deleteCourse(id);
	}

}
