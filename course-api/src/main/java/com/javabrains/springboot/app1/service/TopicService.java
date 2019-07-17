package com.javabrains.springboot.app1.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.javabrains.springboot.app1.model.Topic;

@Service
public class TopicService {
	
	List<Topic> topics= new ArrayList<>(Arrays.asList(new Topic("Java", "Java is platform"), new Topic(".Net", ".Net is platform"),new Topic("Unix", "Unix is platform")));
	
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
	
	public Topic addTopic(Topic topic)
	{
		topics.add(topic);
		return getTopic(topic.getId());
	}

	public Topic updateTopic(String id, Topic topic) {
		Topic old=null;
		try
		{
			old=topics.stream().filter((t)->{return t.getId().equalsIgnoreCase(id);}).findFirst().get();
			topics.remove(old);
			topics.add(topic);
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
		return topic;
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
