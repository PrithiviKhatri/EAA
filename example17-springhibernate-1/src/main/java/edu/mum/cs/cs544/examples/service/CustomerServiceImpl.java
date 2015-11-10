package edu.mum.cs.cs544.examples.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.examples.dao.CustomerDAO;
import edu.mum.cs.cs544.examples.entity.Address;
import edu.mum.cs.cs544.examples.entity.City;
import edu.mum.cs.cs544.examples.entity.Country;
import edu.mum.cs.cs544.examples.entity.Customer;

@Transactional
public class CustomerServiceImpl implements CustomerService {

	public void init() {
		System.out.println("inside init of customerService");

		Country country1 = new Country("Nepal");
		Country country2 = new Country("America");

		City city1 = new City("Kathmandu", country1);
		City city2 = new City("Pokhara", country1);

		City city3 = new City("NewYork", country2);

		Address address1 = new Address("nepaltar", "balaju", "bagmati", city1);
		Address address2 = new Address("lamachaur", "lake side", "kaski", city2);
		Address address3 = new Address("VERRIL street", "downtown subway", "tonton", city3);

		Customer customer1 = new Customer("saila", "saji", "saila@hotmai.com", address1);
		Customer customer2 = new Customer("maila", "maji", "maila@hotmai.com", address1);
		Customer customer3 = new Customer("kaila", "kaji", "kaila@hotmai.com", address2);
		Customer customer4 = new Customer("jetho", "jaji", "jetho@hotmai.com", address2);
		Customer customer5 = new Customer("tom", "carlson", "tom@hotmai.com", address3);

		customerDAO.save(customer1);
		customerDAO.save(customer2);
		customerDAO.save(customer3);
		customerDAO.save(customer4);
		customerDAO.save(customer5);

		System.out.println("end of init method");
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
		/*
		 * Transaction tx =
		 * sessionFactory.getCurrentSession().beginTransaction();
		 */ // Get a list of all customers
		List<Customer> customers = customerDAO.findAll();
		// tx.commit();

		return customers;
	}

	public List<Customer> getCustomerList(Country country) {
		// Transaction tx =
		// sessionFactory.getCurrentSession().beginTransaction();
		// Get a list of all customers for a particular country
		System.out.println("country name is " + country.getName());
		List<Customer> customers = customerDAO.findByAddress_City_Country_name(country.getName());
		// tx.commit();

		return customers;
	}

}
