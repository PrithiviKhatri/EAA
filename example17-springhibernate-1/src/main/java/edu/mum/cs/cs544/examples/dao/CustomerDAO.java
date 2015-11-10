package edu.mum.cs.cs544.examples.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.cs.cs544.examples.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Long> {

	List<Customer> findByAddress_City_Country_name(String name);

}
