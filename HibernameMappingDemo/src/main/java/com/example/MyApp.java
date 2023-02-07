package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Customer;
import com.example.repository.CustomerRepositoryImpl;

public class MyApp {

	public static void main(String[] args) {

		CustomerRepositoryImpl custRepo = new CustomerRepositoryImpl();

		Customer customer = new Customer();
		customer.setCustName("Ram");
		customer.setEmail("ram@example.com");
		customer.setPassword("abc.123");
		// Add/Insert customer into db
		//custRepo.addCustomer(customer);

		// Delete customer by id
		// custRepo.deleteCustomerById(7);

		// Get customer by id
		// Customer customer = custRepo.getCustomerById(8);
		// System.out.println(customer);

		// Get all customers
//		List<Customer> customerList = custRepo.getAllCustomers();
//		for(Customer cust : customerList) {
//			System.out.println(cust);
//		}

	}

}
