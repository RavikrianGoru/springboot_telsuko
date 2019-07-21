package com.javabrains.springboot.app.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabrains.springboot.app.topic.Topic;

@Service
public class TopicService1 {
	
	@Autowired
	TopicRepository topicRepo;
	
	public List<Topic> getTopics() {
		List<Topic> topics=new ArrayList<>();
		topicRepo.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id)
	{
		try
		{
			return topicRepo.findById(id).get();
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
	}
	
	public Topic addTopic(Topic topic)
	{
		topicRepo.save(topic);
		return getTopic(topic.getId());
	}

	public Topic updateTopic(String id, Topic topic) {
		Topic old=null;
		try
		{
			topicRepo.save(topic);//save can be used for save and update
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
			topicRepo.deleteById(id);
		}
		catch(NoSuchElementException e)
		{
			return null;
		}
		return old;
	}
}
