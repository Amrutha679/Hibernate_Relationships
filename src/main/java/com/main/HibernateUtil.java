package com.main;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
        	
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/college");
                settings.put(Environment.USER, "Amrutha");
                settings.put(Environment.PASS, "Amrutha@890");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "create");   
                configuration.setProperties(settings);

                configuration.addAnnotatedClass(com.onetomany.Customers.class);
                configuration.addAnnotatedClass(com.onetomany.Vendor.class);

                configuration.addAnnotatedClass(onetoone.Person.class);
                configuration.addAnnotatedClass(onetoone.PanCard.class);
                
                configuration.addAnnotatedClass(com.manytomany.Student.class);
                configuration.addAnnotatedClass(com.manytomany.Course.class);
                
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
