package com.pouchen.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pouchen.dto.UserDetails2;

/**
 * CRUD (CREATE, READ, UPDATE, DELETE)
 * 
 * @author Roy.Chan
 *
 */

public class HibernateCRUDImplingTest {

	public static void main(String[] args) {
				
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		/**
		 * CREATE
		 * 
		 */
		for(int i=0; i<10; i++) {
			UserDetails2 createDetails = new UserDetails2();	
			createDetails.setUserName("User: " +i);
			session.persist(createDetails);
		}
		
		/**
		 * READ
		 */
		
		UserDetails2 readDetails = session.get(UserDetails2.class, 169);
		System.out.println("UserId pulled up is："+ readDetails.getUserId()
						+" UserName is: "+readDetails.getUserName());
		
		/**
		 * DELETE
		 * 
		 */
		
//		session.delete(readDetails);
		
		/**
		 * UPDATE
		 * 
		 */
		
		readDetails.setUserName("upd-Roy");
		session.update(readDetails);
		
		session.getTransaction().commit();
		session.close();
	}

}
