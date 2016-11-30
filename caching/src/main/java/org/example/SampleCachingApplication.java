package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class SampleCachingApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleCachingApplication.class, args);
	}
}
