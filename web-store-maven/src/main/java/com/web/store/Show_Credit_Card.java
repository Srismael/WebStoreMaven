package com.web.store;

import java.util.List;


import java.util.Iterator;


import javax.persistence.TypedQuery;  

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Show_Credit_Card {
	private static SessionFactory factory;
	public static void list_Articles( ){
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
	         
	         List Credit = session.createQuery("FROM Credit_Card").list(); 
	         for (Iterator iterator = Credit.iterator(); iterator.hasNext();){
	        	 Credit_Card CC = (Credit_Card) iterator.next(); 
		           System.out.print("id: "); 
		           System.out.print(CC.getId_credit_card() + " ");
		           System.out.print("cardholder:" );
		           System.out.print(CC.getCardholder() + " ");
		           System.out.print("card_number: ");
		           System.out.print(CC.getCard_number() + " ");
		           System.out.print("cvv: ");
		           System.out.print( CC.getCvv() + " ");
		           Type_ add = CC.getTp();
		           System.out.print("Type_ ");
		           System.out.print( add.getId_type_()+ " ");
		           Client_ add2 = CC.getClient_();
		           System.out.print("Client ");
		           System.out.print( add2.getId_client()+ " ");
		           System.out.println();
		            
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
