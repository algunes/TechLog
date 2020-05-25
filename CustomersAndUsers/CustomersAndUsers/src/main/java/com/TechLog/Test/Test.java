package com.TechLog.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Users.Users;
import com.TechLog.Dao.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Users user = new Users();
		user.setFirstname("Aliyar");
		user.setLastname("Güneþ");
		user.setDepartment("Administration");
		user.setEmail("aliyargunes@gmail.com");
		
		Corporation corporation = new Corporation();
		corporation.setName("Acme");
		corporation.setCreatedBy(user);
		
		Customer customer = new Customer();
		customer.setFname("Marianne");
		customer.setLname("Faithful");
		customer.setCreatedBy(user);
		
		
		corporation.addCustomer(customer);
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			String sql = "select version()";
			String result = (String) session.createNativeQuery(sql).getSingleResult();
			System.out.println(result);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * StandardServiceRegistry standardRegistry = new
		 * StandardServiceRegistryBuilder() .configure(
		 * "CustomersAndUsers/src/main/java/hibernate.cfg.xml" ) .build();
		 * 
		 * Metadata metadata = new MetadataSources( standardRegistry )
		 * .addAnnotatedClass( Users.class ) .addAnnotatedClassName(
		 * "com.TechLog.Users.Users" ) .getMetadataBuilder()
		 * .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE
		 * ) .build();
		 * 
		 * SessionFactory sessionFactory = metadata.getSessionFactoryBuilder() .build();
		 */
			
			

	}

}
