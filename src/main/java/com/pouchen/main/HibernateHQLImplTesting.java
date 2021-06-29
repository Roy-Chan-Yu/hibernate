package com.pouchen.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;

import com.pouchen.dto.UserDetails2;

import java.util.*;

public class HibernateHQLImplTesting {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		List<String> query = session.createNamedQuery("UserDetails2.byName")
							.setParameter("userName", "upd-Roy")
							.getResultList();
		
		List<UserDetails2> userLists = session.createNamedQuery("UserDetails2.byId")
							.setParameter("userId", 170)
							.getResultList();
		
		int i = 0; 
		for (UserDetails2 userList : userLists) {
			System.out.print("UserId: " + userList.getUserId() + " | Name: "+userList.getUserName());
			if (0 == i%5) {
				System.out.println();
			}
			i++;
		}
		
		for (String object : query) {
			System.out.println(object);
		}
		
	}

}
