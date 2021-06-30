package com.web.store;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Show_Type_ {
	private static SessionFactory factory;
	public static void list_Type_( ){
		try {
			factory  = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Type_.class).buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	    try {
	         tx = session.beginTransaction();
	         List<Type_> theType_ = session.createQuery("from Type_").getResultList();
	         for(Type_ unType_:theType_) {
	 			System.out.println(unType_);
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
