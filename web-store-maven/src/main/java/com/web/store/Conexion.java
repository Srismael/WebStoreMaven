package com.web.store;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Conexion {
	
	
	private static final SessionFactory sessionFactory;
	static{
		try{
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
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
		}catch(Throwable th){
			System.err.println("Enitial SessionFactory creation failed"+th);
			throw new ExceptionInInitializerError(th);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	
	

}
