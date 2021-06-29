package com.pouchen.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pouchen.dto.UserDetails2;

public class HibernateCriteriaTesting {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(UserDetails2.class);
		/** .equal **/
//		List<UserDetails2> userLists = criteria.add(Restrictions.eq("userName", "User: 0")).addOrder(Order.asc("userId"))
//										.list();
		/** .like	**/
//		List<UserDetails2> userLists = criteria.add(Restrictions.like("userName", "User: 1%")).list();
		
		/** greater or like **/
		List<UserDetails2> userLists = criteria.add(Restrictions.or(Restrictions.like("userName", "%1%")
										,Restrictions.ge("userId",221)))
										.list();
		
		for (UserDetails2 userList : userLists) {
//			System.out.println("UserId: " + userList.getUserId() + " userName: " +userList.getUserName());
		}
		
		/**
		 * setProject for columns
		 */
		
		List<Integer> prjLists = session.createCriteria(UserDetails2.class).setProjection(Projections.property("userId")).list();
		
		for (Integer prj : prjLists) {
//			System.out.println(prj);
		}
		
		UserDetails2 usersDetails2 = new UserDetails2();
		usersDetails2.setUserName("%Roy%");
		Example example = Example.create(usersDetails2).enableLike();
		List<UserDetails2> forExamples = session.createCriteria(UserDetails2.class)
										.add(example).list();
		System.out.println(forExamples.size());
		for(UserDetails2 forExample : forExamples) {
			System.out.println("------------------------");
			System.out.println(forExample.getUserId()+forExample.getUserName());
		}
		
		
		/**
		 * Hibernate 5.2 up
		 * 
		 */
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<UserDetails2> criteriaQuery = criteriaBuilder.createQuery(UserDetails2.class);
		Root<UserDetails2> root = criteriaQuery.from(UserDetails2.class);
		criteriaQuery.select(root);
		List<UserDetails2> criDetails2s = session.createQuery(criteriaQuery).list();
		
		int i =1;
		for(UserDetails2 userDetail : criDetails2s ) {
			if (0 == i%2)
				System.out.print(" "+userDetail.getUserId() + " " + userDetail.getUserName());
			else {
				System.out.println(" "+userDetail.getUserId() + " " + userDetail.getUserName());
			}
			i++;
		}
		
		session.getTransaction().commit();
		session.close();
		
	}

}
