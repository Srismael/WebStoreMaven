package com.web.store;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert_P_O {
	
	private static SessionFactory factory;
	public static void P_O_I(){
		
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
	             Purchase_Order PO= new Purchase_Order();
	             PO.setDate_order(null);
	             Delivery_Address DA = session.get(Delivery_Address.class, 1);
	             Delivery_packagues DP = session.get(Delivery_packagues.class, 1);
	             PO.setDAPO(DA);
	             PO.setDPO(DP);
	             
	             session.save(PO);
	             session.getTransaction().commit();
	             session.close();
	             System.out.print("los datos fueron agregados en la tablas Tarjeta de Venta ");
	            
	          } catch (HibernateException e) {
	             if (tx!=null) tx.rollback();
	             e.printStackTrace(); 
	          } finally {
	             session.close(); 
	          }
	          
	}

}
