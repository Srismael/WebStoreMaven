package com.web.store;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert_Client_ {
	
	private static SessionFactory factory;
	public static void Insert_Clients(){
		
		try {
			factory  = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Delivery_Address.class)
					.addAnnotatedClass(Country.class)
					.addAnnotatedClass(Client_.class)
					.addAnnotatedClass(State.class)
					.addAnnotatedClass(City.class)
					.addAnnotatedClass(Credit_Card.class)
					.addAnnotatedClass(Type_.class)
					.addAnnotatedClass(Purchase_Order.class)
					.addAnnotatedClass(Delivery_packagues.class)
					.addAnnotatedClass(delivery_company.class)
					.buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      
	      try {
	             tx = session.beginTransaction();
	             Client_ Clien = new Client_();
	             Clien.setName_client("Juanjo");
	             Clien.setLast_name("Hernandez Trejo");
	             Clien.setUsername("Pyke");
	             Clien.setPass("elchan");
	             Clien.setEmail("yosoyjuan34@gmail.com");
	             
	             session.save(Clien);
	             session.getTransaction().commit();
	             session.close();
	             System.out.print("los datos fueron agregados en la tablas Clientes");
	            
	          } catch (HibernateException e) {
	             if (tx!=null) tx.rollback();
	             e.printStackTrace(); 
	          } finally {
	             session.close(); 
	          }
	          
	}
	

}
