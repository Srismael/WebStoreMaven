package com.web.store;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert_Delivery_Address {
	
	private static SessionFactory factory;
	public static void Delivery_Address_I(){
		
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
	             Delivery_Address DA= new Delivery_Address();
	             DA.setStreet("Calle San tadeo ");
	             DA.setNumber_delivery(23);
	             
	             Client_ ClienTT = session.get(Client_.class, 1);
	             DA.setTheClient_(ClienTT);
	             Country CC = session.get(Country.class, 1);
	             DA.setTheCountry(CC);
	             State S = session.get(State.class, 9);
	             DA.setTheState(S);
	             City CI = session.get(City.class, 10);
	             DA.setTheCity(CI);
	             
	             
	             session.save(DA);
	             session.getTransaction().commit();
	             session.close();
	             System.out.print("los datos fueron agregados en la tablas Dirección");
	            
	          } catch (HibernateException e) {
	             if (tx!=null) tx.rollback();
	             e.printStackTrace(); 
	          } finally {
	             session.close(); 
	          }
	          
	}

}
