package com.rk.springboot.app2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App2Application {
	public static void main(String[] args) {
		SpringApplication.run(App2Application.class, args);

/*
1) Sample rest service and health check through actuator
2) Junit test for service and health check through actuator

$ curl localhost:8080
$ curl localhost:8080/hello-world
$ curl localhost:8080/hello-world
$ curl localhost:8080/hello-world?name=Ravi
$ curl localhost:8080/actuator/health

$ curl localhost:9000
$ curl localhost:9000/hello-world
$ curl localhost:9000/hello-world
$ curl localhost:9000/hello-world?name=Ravi
$ curl localhost:9001/actuator/health

*/
	}

}
