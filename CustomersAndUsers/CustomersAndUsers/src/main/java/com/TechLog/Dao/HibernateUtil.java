package com.TechLog.Dao;

import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

	
public class HibernateUtil {
	private static StandardServiceRegistry standardServiceRegistry;
	private static SessionFactory sessionFactory;
	
	static {

    StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
    
    Map<String, String> dbSettings = new HashMap<>();
    dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernatetest");
    dbSettings.put(Environment.USER, "root");
    dbSettings.put(Environment.PASS, "123456");
    dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
    dbSettings.put(Environment.SHOW_SQL, "true");
    dbSettings.put(Environment.HBM2DDL_AUTO, "create-only");
    dbSettings.put(Environment.POOL_SIZE, "20");
    dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
    
    registryBuilder.applySettings(dbSettings);
    standardServiceRegistry = registryBuilder.build();
    
    MetadataSources sources = new MetadataSources(standardServiceRegistry);
    Metadata metadata = sources.getMetadataBuilder().build();
    
    sessionFactory = metadata.getSessionFactoryBuilder().build();
    
	}
    public static SessionFactory getSessionFactory() {
    	return sessionFactory;
    }

}
