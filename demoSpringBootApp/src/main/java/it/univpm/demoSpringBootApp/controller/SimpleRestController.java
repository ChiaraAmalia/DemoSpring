package it.univpm.demoSpringBootApp.controller;

import org.springframework.web.bind.annotation.*;

import it.univpm.demoSpringBootApp.model.HelloWorldClass;


@RestController
public class SimpleRestController {
	
	@GetMapping("/hello")
	public HelloWorldClass exampleMethod(@RequestParam(name="param1", defaultValue="World") String param1) {
		
		return new HelloWorldClass("Giuseppe", "Garibaldi");
	}
	
	@PostMapping("/hello") 
	public HelloWorldClass exampleMethod2(@RequestBody HelloWorldClass body){
		return body;
	}
}
