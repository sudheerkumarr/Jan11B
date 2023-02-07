package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.entity.Employee;

public class MyApp {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		// Create SessionFactory obj
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		
		// Get session obj from session factory
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		// create emp and update values
		Employee e1 = new Employee();
		//e1.setEmpId(1002);
		e1.setEmpName("Sam");
		e1.setEmail("sam@example.com");
		e1.setPassword("abc.123");
		
		// Save emp to db
		session.save(e1);  
		
		// commit changes
	    t.commit();  
	   
	    System.out.println("Employee added successfully!");    
	    factory.close();  
	    session.close();    
		
	}

}
