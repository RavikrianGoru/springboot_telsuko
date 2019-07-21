package com.javabrains.springboot.app.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String sayHi(@RequestParam(name="name", required=false, defaultValue="Stranger") String name)
	{
		return "Hello World: Hi "+name;
	}
}
