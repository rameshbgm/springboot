package org.example.web;

import java.util.Random;

import org.example.domain.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@RequestMapping(value = "/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save() {
		Random r = new Random();
		for (int i = 0; i < 10000; i++) {
			customerRepository.save(new Customer(r.nextInt(10000) + "", r.nextInt(10000) + ""));
		}
		return new ResponseEntity<String>("100000 Customer Details saved", HttpStatus.OK);
	}
	
	
	
	@Cacheable(key="#firstName", value="findByFirstName")
	@RequestMapping(value = "/findByFirstName/{firstName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Customer>> findByFirstName(@PathVariable(value = "firstName") String firstName) {
		Iterable<Customer> customers = customerRepository.findByFirstName(firstName);
		return new ResponseEntity<Iterable<Customer>>(customers, HttpStatus.OK);
	}

	//@Cacheable(key="AllCustomers", value="AllCustomers")
	@RequestMapping(value = "/display", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Customer>> display() {
		long start = System.currentTimeMillis();
		Iterable<Customer> customer = getCustomer();
		long end = System.currentTimeMillis();
		System.out.println("Tme taken to read the customers " + (end - start));
		return new ResponseEntity<Iterable<Customer>>(customer, HttpStatus.OK);
	}

	private Iterable<Customer> getCustomer() {
		return customerRepository.findAll();
	}

}
