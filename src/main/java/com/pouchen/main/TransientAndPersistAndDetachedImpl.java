package com.pouchen.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pouchen.dto.UserDetails2;

public class TransientAndPersistAndDetachedImpl {

	public static void main(String[] args) {
		/**
		 * Transient Range
		 */
		UserDetails2 userDetails2 = new UserDetails2();
		userDetails2.setUserName("Transient");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/**
		 * Persistent Objects
		 * 
		 */
		
		session.save(userDetails2);
		
		userDetails2.setUserName("UPDATED User");
		userDetails2.setUserName("Updated User Again");
		
		session.getTransaction().commit();
		session.close();
		
		/**
		 * Detached Object
		 * 
		 */
		
		userDetails2.setUserName("Detached Object");
		session.saveOrUpdate(userDetails2);
	}

}
