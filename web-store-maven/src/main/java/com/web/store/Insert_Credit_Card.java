package com.web.store;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert_Credit_Card {
	
	private static SessionFactory factory;
	public static void Credit_Card_I(){
		
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
	             Credit_Card CC= new Credit_Card();
	             CC.setCardholder("Ismael MTZ");
	             CC.setCard_number(124235425);
	             CC.setCvv(123);
	             Type_ Tp = session.get(Type_.class, 1);
	             Client_ ClienTT = session.get(Client_.class, 1);
	             CC.setClient_(ClienTT);
	             CC.setTp(Tp);
	             
	             session.save(CC);
	             session.getTransaction().commit();
	             session.close();
	             System.out.print("los datos fueron agregados en la tablas Tarjeta de Credito ");
	            
	          } catch (HibernateException e) {
	             if (tx!=null) tx.rollback();
	             e.printStackTrace(); 
	          } finally {
	             session.close(); 
	          }
	          
	}

}
