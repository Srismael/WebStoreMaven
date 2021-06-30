package com.web.store;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Show_delivery_address {
	
	private static SessionFactory factory;
	public static void list_Delivery_address( ){
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
	         List Delivery_Address = session.createQuery("FROM Delivery_Address").list(); 
	         for (Iterator iterator = Delivery_Address.iterator(); iterator.hasNext();){
	        	 Delivery_Address SDA = (Delivery_Address) iterator.next(); 
		           System.out.print("id_delivery: "); 
		           System.out.print(SDA.getId_delivery() + " ");
		           System.out.print("street:" );
		           System.out.print(SDA.getStreet() + " ");
		           System.out.print("number_delivery: ");
		           System.out.print( SDA.getNumber_delivery() + " ");
		           Client_ add2 = SDA.getTheClient_();
		           System.out.print("Client ");
		           System.out.print( add2.getId_client()+ " ");
		           Country add1 = SDA.getTheCountry();
		           System.out.print("Country ");
		           System.out.print( add1.getId_country()+ " ");
		           State add3 = SDA.getTheState();
		           System.out.print("State ");
		           System.out.print( add1.getId_country()+ " ");
		           City add4 = SDA.getTheCity();
		           System.out.print("City ");
		           System.out.print( add1.getId_country()+ " ");
		           
		           
		           System.out.println();
		            
	         }
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	    }
 }

}

