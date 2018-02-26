package poe.spring.api;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.domain.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/hello")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	
	@RequestMapping("/hello/{name}/{surname}")
	public Greeting hi(@PathVariable(value="name") String name, @PathVariable(value="surname") String surname) {
		return new Greeting(1, "hello " + name + " " + surname);
	}
}