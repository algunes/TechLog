package com.TechLog.Dao;

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

				Map<String, String> dbSettings = new HashMap<>();
				dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatetest");
				dbSettings.put(Environment.USER, "root");
				dbSettings.put(Environment.PASS, "1234");
				dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				dbSettings.put(Environment.SHOW_SQL, "true");
				dbSettings.put(Environment.FORMAT_SQL, "true");
				dbSettings.put(Environment.HBM2DDL_AUTO, "update");
				dbSettings.put(Environment.POOL_SIZE, "20");
				dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				dbSettings.put(Environment.POOL_SIZE, "20");

				registryBuilder.applySettings(dbSettings);
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
