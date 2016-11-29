package org.example.repository;

import org.example.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Iterable<Customer> findByFirstName(String lastName);
	Iterable<Customer> findAllByOrderByFirstNameAsc();
	
	@Query("delete from Customer c where c.id = :id")
	 void deleteCustomer(Long id);
}