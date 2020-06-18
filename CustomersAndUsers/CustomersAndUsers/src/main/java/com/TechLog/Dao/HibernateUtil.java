package com.TechLog.Dao;

import static org.hibernate.search.cfg.Environment.INDEX_BASE_PROP_NAME;

import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;

	static {

		if (sessionFactory == null) {

			try {

				StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				Map<Object, Object> settings = new HashMap<>();
				
				// DB Configuration
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatetest");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "Driver8...?");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.FORMAT_SQL, "true");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				settings.put(Environment.POOL_SIZE, "20");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				
				// c3p0 Configuration
			    settings.put(Environment.C3P0_MIN_SIZE, 5);         //Minimum size of pool
			    settings.put(Environment.C3P0_MAX_SIZE, 20);        //Maximum size of pool
			    settings.put(Environment.C3P0_ACQUIRE_INCREMENT, 1);//Number of connections acquired at a time when pool is exhausted
			    settings.put(Environment.C3P0_TIMEOUT, 1800);       //Connection idle time
				
			    // Search Configuration 
				settings.put(INDEX_BASE_PROP_NAME, "/var/lucene/indexes");

				registryBuilder.applySettings(settings);
				standardServiceRegistry = registryBuilder.build();

				MetadataSources sources = new MetadataSources(standardServiceRegistry)
						.addAnnotatedClass(com.TechLog.Users.Users.class)
						.addAnnotatedClass(com.TechLog.Customers.Corporation.class)
						.addAnnotatedClass(com.TechLog.Customers.Customer.class)
						.addAnnotatedClass(com.TechLog.Customers.Email.class)
						.addAnnotatedClass(com.TechLog.Customers.Phone.class)
						.addAnnotatedClass(com.TechLog.Customers.Address.class);
				Metadata metadata = sources.getMetadataBuilder().build();

				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}

			catch (Exception e) {
				e.printStackTrace();
				if (standardServiceRegistry != null) {
					StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
				}
			}
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
