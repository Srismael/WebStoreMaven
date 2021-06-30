package com.web.store;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Show_Article {
	private static SessionFactory factory;
	public static void list_Articles( ){
		try {
			factory  = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Article.class).buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	    try {
	         tx = session.beginTransaction();
	         List<Article> theArticles = session.createQuery("from Article").getResultList();
	         for(Article unArticle:theArticles) {
	 			System.out.println(unArticle);
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
