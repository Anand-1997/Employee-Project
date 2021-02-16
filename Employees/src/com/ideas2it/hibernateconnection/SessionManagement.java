package com.ideas2it.hibernateconnection;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Session management is used to configure session factory
 */
public class SessionManagement {
	private static SessionFactory sessionFactory = null;
    public static SessionFactory getSessionFactory(){
    	try {
    		if (sessionFactory == null) {	
    			Configuration configuration = new Configuration();
                configuration.configure("resource/properties/Hibernate.cfg.xml");
                SessionFactory sessionFactory = configuration.buildSessionFactory();
                return sessionFactory;
    		}
    	}
    	catch( Exception e ) {
            System.out.println(e);
            e.printStackTrace();
    	}
        return sessionFactory;
    }
    public static void closeSessionFactory() {
        sessionFactory.close();
        System.out.println("SESSION FACTORY CLOSED SUCCESSFULLY");
    }
}



