/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SampleSchedulingJpaApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleSchedulingJpaApplication.class, args);
	}

	@Scheduled(fixedDelay = 1000)
	public void fixedDelay() throws InterruptedException {
		System.out.println("Fixed Delay after 1000");
	}

	@Scheduled(fixedRate = 100)
	public void fixedRate() throws InterruptedException {
		System.out.println("Fixed Rate after 1000");
		Thread.sleep(10000);
	}
	
	
	@Scheduled(fixedDelay = 100, initialDelay = 30000)
	public void initialDelay()  {
		System.out.println("InitialDelay ");
	}
	
	


}
