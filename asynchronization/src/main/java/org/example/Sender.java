package org.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	
	@Async
	public void sendMail(String thredName) throws InterruptedException {
		System.out.println("sending mail.." + thredName);
		Thread.sleep(1000 * 10);
		System.out.println("sending mail completed.."+thredName);
	}
	
	@Async
	public void sendSms(String thredName) throws InterruptedException {
		System.out.println("sending SMS.." + thredName);
		Thread.sleep(1000 * 10);
		System.out.println("sending SMS completed.."+thredName);
	}
	
	
	@Async
	public void sendSms() throws InterruptedException {
		System.out.println("sending SMS.." );
		Thread.sleep(1000 * 10);
		System.out.println(1/0);
		System.out.println("sending SMS completed..");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 @Async
	public Future<Boolean> sendMail(String thredName) throws InterruptedException {
		System.out.println("sending mail.." + thredName);
		Thread.sleep(1000 * 10);
		System.out.println("sending mail completed.."+thredName);
		return new AsyncResult<Boolean>(true);
	} 
	 
	 */
}