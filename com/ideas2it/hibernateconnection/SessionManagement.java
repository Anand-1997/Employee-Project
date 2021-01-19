package com.ideas2it.hibernateconnection;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

/**
 * Session management is used to configure session factory
 */
public class SessionManagement {
    public static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("resource/properties/Hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}



