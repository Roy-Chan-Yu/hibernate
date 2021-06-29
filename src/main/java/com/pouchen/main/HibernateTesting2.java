package com.pouchen.main;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pouchen.dto.Address;
import com.pouchen.dto.UserDetails;

public class HibernateTesting2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName("Roy");
		Address address = new Address();
		address.setCityString("Changwa");
		address.setPincode("50t6");
		address.setState("Lukang");
		address.setStreet("vally");
		
		Address address2 = new Address();
		address2.setCityString("Changwa");
		address2.setPincode("50t6");
		address2.setState("Lukang");
		address2.setStreet("vally");
		
		Collection<Address> setAddresses = new ArrayList<>();
		setAddresses.add(address);setAddresses.add(address2);
		userDetails.setListOfAddresses(setAddresses);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
		
		
	}

}
