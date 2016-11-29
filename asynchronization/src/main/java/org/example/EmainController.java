package org.example;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmainController {
	
	@Autowired
	private Sender sender;

	@RequestMapping(value = "/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String sendmail() throws InterruptedException, ExecutionException {

		System.out.println("Fire and Forget");

		sender.sendMail("Main Thread1");
		sender.sendSms("SMS Thread1");

		sender.sendMail("Main Thread2");
		sender.sendSms("SMS Thread2");

		System.out.println("Next Process");
		
		
		
		
		
		
		
		
		
		
		
		
		
		return "Check Console log";

	}

}
