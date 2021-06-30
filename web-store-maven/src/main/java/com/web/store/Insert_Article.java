package com.web.store;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert_Article {
	
	private static SessionFactory factory;
	public static void Insert_Articler(){
		
		try {
			factory  = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Article.class)
					.buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      
	      try {
	             tx = session.beginTransaction();
	             Article ART = new Article();
	             ART.setName_article("Tarjeta Grafica");
	             ART.setDescription_article("Poderosa Tarjeta grafica para jugar videojuegos ");
	             ART.setPrice_article(1000);
	             ART.setStock_article(3);
	             
	             session.save(ART);
	             session.getTransaction().commit();
	             session.close();
	             System.out.print("los datos fueron agregados en la tablas Articulo");
	            
	          } catch (HibernateException e) {
	             if (tx!=null) tx.rollback();
	             e.printStackTrace(); 
	          } finally {
	             session.close(); 
	          }
	          
	}
	      
		
}
		

