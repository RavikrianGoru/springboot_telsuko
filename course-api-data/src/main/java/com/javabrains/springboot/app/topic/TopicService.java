package com.javabrains.springboot.app.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.javabrains.springboot.app.topic.Topic;

@Service
public class TopicService {
	
	List<Topic> topics= new ArrayList<>(Arrays.asList(new Topic("1", "Java", "Java is platform"), new Topic("2",".Net", ".Net is platform"),new Topic("3","Unix", "Unix is platform")));
	
	public List<Topic> getTopics() {
		return topics;
	}

	public Topic getTopic(String id)
	{
		try
		{
			return topics.stream().filter((t)->{return t.getId().equalsIgnoreCase(id);}).findFirst().get();
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
	
	public Topic addTopic(Topic course)
	{
		topics.add(course);
		return getTopic(course.getId());
	}

	public Topic updateTopic(Topic course) {
		try
		{
			topics.add(course);
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
		return course;
	}

	public Topic deleteTopic(String id) {
		Topic old=null;
		try
		{
			old=topics.stream().filter((t)->{return t.getId().equalsIgnoreCase(id);}).findFirst().get();
			topics.remove(old);
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
		return old;
	}
}
