package com.pouchen.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pouchen.dto.UserDetails2;

public class HibernateCacheImpling {

	public static void main(String[] args) {
		
		/**
		 * Hibernate Second Level Cache
		 * SessionFactory 下產生
		 * 
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails2 user = session.get(UserDetails2.class, 151);
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		
		UserDetails2 user2 = session2.get(UserDetails2.class, 151);
		
		/**
		 * use_query_cache
		 * Session.setCacheable(true);
		 */
		
		System.out.println("---------------------------------");
		
		List<UserDetails2> userList = session2.createQuery("FROM UserDetails2 user where user.userId > 170").setCacheable(true).list();
		
		List<UserDetails2> detailList = session2.createQuery("FROM UserDetails2 user where user.userId > 170").setCacheable(true).list();
		session2.getTransaction().commit();
		session2.close();
		
	}

}
