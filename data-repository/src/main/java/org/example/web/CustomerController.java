package org.example.web;

import org.example.domain.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class CustomerController {


	@Autowired
	CustomerRepository customerRepository;
	
	@Transactional //optional if you are decleared at class level
	@RequestMapping(value = "/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save() {
		customerRepository.save(new Customer("Ramesh", "M"));
		customerRepository.save(new Customer("Krishna", "M"));
		customerRepository.save(new Customer("Ramesh", "C"));
		customerRepository.save(new Customer("Bibhu", "S"));
		customerRepository.save(new Customer("Kissan", "N"));
		return new ResponseEntity<String>("Customer Details saved", HttpStatus.OK);
	}
	

	@RequestMapping(value = "/display", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Customer>> display() {
		Iterable<Customer> customers = customerRepository.findAll();
		return new ResponseEntity<Iterable<Customer>>(customers, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/findByFirstName/{firstName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Customer>> findByFirstName(@PathVariable(value = "firstName") String firstName) {
		Iterable<Customer> customers = customerRepository.findByFirstName(firstName);
		return new ResponseEntity<Iterable<Customer>>(customers, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/oderByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Customer>> oderByName() {
		Iterable<Customer> customers = customerRepository.findAllByOrderByFirstNameAsc();
		return new ResponseEntity<Iterable<Customer>>(customers, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Long id) {
		customerRepository.delete(id);
		return new ResponseEntity<String>("Customer Dedeted", HttpStatus.OK);
	}
	
	

	
}
