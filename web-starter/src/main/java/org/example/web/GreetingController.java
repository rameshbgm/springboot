package org.example.web;

import org.example.model.Greeting;
import org.example.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService GreetingService;

	@RequestMapping(value = "/welcome/{name}", 
			method = {RequestMethod.GET,RequestMethod.POST}, 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE })
	public ResponseEntity<Greeting> welcome(@PathVariable(value = "name") String name, @RequestParam(value = "greeting", defaultValue = "Good Morning", required=false) String greeting) {
		Greeting g = new Greeting(name, greeting);
		return new ResponseEntity<Greeting>(g, HttpStatus.OK);
	}

	
	
	@RequestMapping(value = "/hello", 
			method = RequestMethod.POST, 
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Greeting> hello(@RequestBody Greeting g) {
		return new ResponseEntity<Greeting>(g, HttpStatus.OK);
	}

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>(GreetingService.sayHello("Ramesh"), HttpStatus.OK);
	}
	
	

	/*
	 * 
	 * {"name":"ramesh","greeting":"Good Evening"}
	 * 
	 * <greeting> <greeting>Good Evening</greeting>
	 * <name>ramesh</name></greeting>
	 * 
	 */

}
