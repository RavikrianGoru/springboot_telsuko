package com.javabrains.springboot.app.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javabrains.springboot.app.topic.Topic;

@RestController
public class TopicController {

	@Autowired
	private TopicService1 topicService;

	@RequestMapping(path = "/topics", method = RequestMethod.GET)
	public List<Topic> getTopics() {
		return topicService.getTopics();
	}

	@RequestMapping(path="/topics/{id}", method = RequestMethod.GET)
	public Topic getTopic(@PathVariable("id") String id)
	{
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public Topic addTopic(@RequestBody Topic topic)
	{
		return topicService.addTopic(topic);
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public Topic updateTopic(@RequestBody Topic topic, @PathVariable("id") String id)
	{
		return topicService.updateTopic(id, topic);
	}
	
	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public Topic deleteTopic(@PathVariable("id") String id)
	{
		return topicService.deleteTopic(id);
	}

}
