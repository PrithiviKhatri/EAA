package edu.mum.cs.cs544.examples.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.cs544.examples.dao.CustomerDAO;
import edu.mum.cs.cs544.examples.entity.Country;
import edu.mum.cs.cs544.examples.entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	public void init() {

	Customer cust1=new Customer();
		System.out.println("inside init of customerService");

	}

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Customer> getAllCustomers() {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		// Get a list of all customers
		List<Customer> customers = customerDAO.findAll();
		tx.commit();

		return customers;
	}

	public List<Customer> getCustomerList(Country country) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		// Get a list of all customers for a particular country
		System.out.println("country name is " + country.getName());
		List<Customer> customers = customerDAO.findByAddress_City_Country_name(country.getName());
		tx.commit();

		return customers;
	}

}
