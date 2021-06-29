package com.pouchen.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.pouchen.dto.UserDetails2;
import com.pouchen.dto.Vehicle;

public class HibernateTest3 {
	
	public static void main(String[] args) {
		
		UserDetails2 userDetails2 = new UserDetails2();
		userDetails2.setUserName("FirstUser");
		/**
		 * OneToOne Mapping association
		 */
//		Vehicle vehicle = new Vehicle();
//		vehicle.setVecleName("RoyBike");
//		userDetails2.setVehicle(vehicle);
		
		/**
		 * OneToMany Mapping Association
		 * 
		 */
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Roy2-Bike");
		Vehicle vehicle2 = new Vehicle();
		vehicle.setVehicleName("Roy-Bike2");
		userDetails2.getVehicles().add(vehicle);
		userDetails2.getVehicles().add(vehicle2);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(userDetails2);
//		session.persist(vehicle);
//		session.persist(object);
//		session.save(userDetails2);
//		session.save(vehicle);
		session.getTransaction().commit();
		session.clear();
//		session.close();
		/**
		 * throw Exception
		 * org.hibernate.PersistentObjectException: Detached entity passed to persist
		 * Does not save the changes to the database outside of the transaction;
		 * Return void
		 */
//		session.persist(userDetails2);
//		session.persist(vehicle);
		/**
		 * Saves the changes to the database outside of the transaction;
		 * Return Serializable
		 * 
		 */
//		session.save(userDetails2);
//		session.save(vehicle);
//		session.beginTransaction().commit();	
	}

}
