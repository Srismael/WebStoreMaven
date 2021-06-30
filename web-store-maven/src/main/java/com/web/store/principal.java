package com.web.store;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class principal {
	
	private static SessionFactory factory; 
	

	public static void main(String[] args) {
		
		
		principal P = new principal();
		P.SingleSession();
		P.list_CC();
		P.list_Delivery_address();	
		P.list_Articles();
		P.list_Client_();
		P.list_Purchase_Order();
		
	}	
	
	
	
	
	public static void SingleSession() {
		
		try {
			factory  = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Delivery_Address.class)
					.addAnnotatedClass(Purchases_Good.class)
					.addAnnotatedClass(Country.class)
					.addAnnotatedClass(Client_.class)
					.addAnnotatedClass(State.class)
					.addAnnotatedClass(City.class)
					.addAnnotatedClass(Credit_Card.class)
					.addAnnotatedClass(Type_.class)
					.addAnnotatedClass(Purchase_Order.class)
					.addAnnotatedClass(Delivery_packagues.class)
					.addAnnotatedClass(delivery_company.class)
					.addAnnotatedClass(Article.class)
					.buildSessionFactory();
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }	
		
	}
	
	
	public static void list_CC( ){
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

	public static void list_Delivery_address( ){
		
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
	
	public static void list_Articles( ){

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
	
	public static void list_Client_( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	    try {
	         tx = session.beginTransaction();
	         List<Client_> theClient_ = session.createQuery("from Client_ ").getResultList();
	         for(Client_ unClient_:theClient_) {
	 			System.out.println(unClient_);
	 		}
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	    }
	 }

	public static void list_Purchase_Order(){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	    try {
	         tx = session.beginTransaction();
	         List Purchase_Order = session.createQuery("FROM Purchase_Order").list(); 
	         for (Iterator iterator = Purchase_Order.iterator(); iterator.hasNext();){
	        	 Purchase_Order PO = (Purchase_Order) iterator.next(); 
		           System.out.print("id_delivery: "); 
		           System.out.print(PO.getId_purchase_order() + " ");
		           System.out.print("street:" );
		           System.out.print(PO.getDate_order() + " ");
		           Delivery_Address add2 = PO.getDAPO();
		           System.out.print("Delivery_Address ");
		           System.out.print( add2.getId_delivery()+ " ");
		           Delivery_packagues add1 = PO.getDPO();
		           System.out.print("Delivery_packagues ");
		           System.out.print( add1.getId_delivery_packagues()+ " ");
		           
		           
		           
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
