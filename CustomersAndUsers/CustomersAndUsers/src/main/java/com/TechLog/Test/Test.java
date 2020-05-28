package com.TechLog.Test;

import java.time.LocalDate;

import org.hibernate.Session;

import com.TechLog.Customers.Address;
import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Customers.Customers2;
import com.TechLog.Customers.Email;
import com.TechLog.Customers.Emails2;
import com.TechLog.Customers.Phone;
import com.TechLog.Dao.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Session session = null;
		
		try {
			
			session = HibernateUtil.getSessionFactory().openSession();
			
			/*
			 * String sql = "select version()"; String result = (String)
			 * session.createNativeQuery(sql).getSingleResult(); System.out.println(result);
			 */
			
//			Users user = new Users();
//			user.setFirstname("Aliyar");
//			user.setLastname("Güneþ");
//			user.setDepartment("Administration");
//			user.setEmail("aliyargunes@gmail.com");
			
//			Corporation corporation = new Corporation();
//			corporation.setName("Mocon Ametek Dansensor");
//			corporation.setCreation_date(LocalDate.now());
//			
//			Email email = new Email();
//			email.setEmail("map@cohen.com");
//			
//			Address address = new Address();
//			address.setAddress("Ataþehirde bir yer");
//			
//			Phone phone = new Phone();
//			phone.setNumber("+90568356734");
//						
//			Customer customer = new Customer();
//			customer.setFirstname("Jesse");
//			customer.setLastname("James");
//			
//			customer.addEmail(email);
//			customer.addAddress(address);
//			customer.addPhone(phone);
//			
//			corporation.addCustomer(customer);
//							
//			session.beginTransaction();
			
//			session.persist(user);
//			session.persist(corporation); //its enough to only persist this object
//			session.persist(customer);
			
//			Emails2 email = new Emails2();
//			email.setEmail("aliyarguness@gmail.com");
//			Emails2 email2 = new Emails2();
//			email2.setEmail("aliyarguness2@gmail.com");
//			
//			Customers2 customer = new Customers2();
//			customer.setFirstname("Bilal");
//			customer.setLastname("Adýsüper");
//			// customer.setCorporation(session.get(Corporation.class, 1L));
//			customer.addEmails(email);
//			customer.addEmails(email2);
						
			Corporation corporation = new Corporation();
			corporation.setName("ACME");
			
			Customer customer = new Customer();
			customer.setFirstname("Mircae");
			customer.setLastname("Ealiade");
			
			Email email1 = new Email();
			email1.setEmail("eliade@mircae.com");
			
			Email email2 = new Email();
			email2.setEmail("eliade2@gmail.com");
			
			Phone phone1 = new Phone();
			phone1.setNumber("123456789");
			
			Phone phone2 = new Phone();
			phone2.setNumber("1234567891011");
			
			Address address1 = new Address();
			address1.setAddress("Falanca Sokak filanca cadde no:1");
			
			Address address2 = new Address();
			address2.setAddress("Orada bir de þurada filanca adres");
			
			customer.addEmail(email1);
			customer.addEmail(email2);
			customer.addPhone(phone1);
			customer.addPhone(phone2);
			customer.addAddress(address1);
			customer.addAddress(address1);
			customer.addAddress(address2);
			
			corporation.addCustomer(customer);
			
			session.beginTransaction();
			
			session.persist(corporation);
			
			session.getTransaction().commit();
			
			Customer customer2 = session.get(Customer.class, 1L);
			System.out.println("Added Customer is " + 
					customer2.getFirstname() + " "
					+ customer2.getLastname() + " "
					+ customer2. getCorporation().getName());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (session != null)
			session.close();
		}

	}

}
