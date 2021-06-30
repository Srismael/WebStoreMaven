package com.web.store;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Show_delivery_company {
	private static SessionFactory factory;
	public static void list_delivery_company( ){
		try {
			factory  = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(delivery_company.class).buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	    try {
	         tx = session.beginTransaction();
	         List<delivery_company> thedelivery_company = session.createQuery("from delivery_company").getResultList();
	         for(delivery_company undelivery_company:thedelivery_company) {
	 			System.out.println(undelivery_company);
	 		}
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	    }

	}
}
