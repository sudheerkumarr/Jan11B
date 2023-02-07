package com.example.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Customer;

public class CustomerRepositoryImpl {

	// Insert/Add Customer into db
	public Customer addCustomer(Customer customer) {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Customer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// begin transaction
		Transaction tx = session.beginTransaction();

		// create customer obj and update values
		Customer c1 = new Customer();
		c1.setCustName("Sam");
		c1.setEmail("Sam@example.com");
		c1.setPassword("abc.123");

		// Save emp to db
		session.save(c1);

		// commit changes
		tx.commit();

		System.out.println("Customer added successfully!");

		// Close factory & session
		factory.close();
		session.close();

		return customer;
	}

	// Delete customer by id
	public void deleteCustomerById(int custId) {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Customer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// begin transaction
		Transaction tx = session.beginTransaction();

		// Create query
		Query query = session.createQuery("delete from Customer where custId=:cId");
		query.setParameter("cId", custId);

		// Execute query
		int i = query.executeUpdate();

		// commit changes
		tx.commit();

		System.out.println("Customer deleted successfully!");

		// Close factory & session
		factory.close();
		session.close();
	}

	// Get customer by id
	public Customer getCustomerById(int custId) {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Customer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// Get customer by id
		Customer customer = session.get(Customer.class, custId);

		session.close();
		factory.close();

		return customer;
	}

	// Get all customers
	public List<Customer> getAllCustomers() {
		// Create SessionFactory Obj from Configuration Obj
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(com.example.entity.Customer.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		// Get session obj from session factory
		Session session = factory.openSession();

		// Get all customers
		Query query = session.createQuery("from Customer");
		List<Customer> customerList = query.getResultList();

		session.close();
		factory.close();

		return customerList;
	}
}
