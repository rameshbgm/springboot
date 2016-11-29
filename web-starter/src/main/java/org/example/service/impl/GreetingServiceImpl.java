package org.example.service.impl;

import org.example.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
