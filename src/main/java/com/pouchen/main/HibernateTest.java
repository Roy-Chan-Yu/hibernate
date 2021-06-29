package com.pouchen.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.pouchen.dto.Customer;
import com.pouchen.dto.Orders;

public class HibernateTest {

	public static void main(String[] args) {
		Orders orders = new Orders();
		orders.setUserName("GenerateValue");
		orders.setJoinedDate(new Date());
		
		Customer customer = new Customer();
		customer.setCity("HHua");
		customer.setState("Golden");
		customer.setStreet("Hooly");
		orders.setCustomer(customer);

		Customer vipCustomer2 = new Customer();
		vipCustomer2.setCity("NO.2");
		vipCustomer2.setState("No.2");
		vipCustomer2.setStreet("no.2");
		orders.setVipCustomer(vipCustomer2);
		
		Session session = new Configuration().configure().buildSessionFactory()
						.openSession();
		session.beginTransaction();
		session.save(orders);
		session.getTransaction().commit();
		session.close();

		/**
		 * Session.get(CLASS<T> CLASSZ, Id);
		 */
//		orders = null;
//		
//		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//		Session session2 = sessionFactory.openSession();
//		session2.beginTransaction();
//		orders = (Orders) session2.get(Orders.class, 10);
//		System.out.println("id: " +orders.getUserId()+" name: "+orders.getUserName() + " Date " +orders.getJoinedDate());	
	}
}
