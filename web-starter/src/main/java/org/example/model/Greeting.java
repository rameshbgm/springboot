package org.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Greeting {

	private String name;
    private String greeting;

    public Greeting() {

    }
    
    public Greeting(String name, String greeting) {
    	this.setName(name);
    	this.setGreeting(greeting);
    }
    

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}


}
