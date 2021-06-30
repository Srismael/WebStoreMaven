package com.web.store;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Show_Country {
	private static SessionFactory factory;
	public static void list_Country( ){
		try {
			factory  = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Country.class).buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	    try {
	         tx = session.beginTransaction();
	         List<Country> theCountry = session.createQuery("from Country").getResultList();
	         for(Country unCountry:theCountry) {
	 			System.out.println(unCountry);
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
