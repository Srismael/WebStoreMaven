package com.web.store;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Show_Purchase_Order {
	
	private static SessionFactory factory;
	public static void list_Purchase_Order(){
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
