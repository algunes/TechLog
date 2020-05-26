package com.TechLog.Test;

import java.time.LocalDate;

import org.hibernate.Session;

import com.TechLog.Customers.Address;
import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Customers.Email;
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
			
			Corporation corporation = new Corporation();
			corporation.setName("Mocon Ametek Dansensor");
			corporation.setCreation_date(LocalDate.now());
			
			Email email = new Email();
			email.setEmail("map@cohen.com");
			
			Address address = new Address();
			address.setAddress("Ataþehirde bir yer");
			
			Phone phone = new Phone();
			phone.setNumber("+90568356734");
						
			Customer customer = new Customer();
			customer.setFirstname("Jesse");
			customer.setLastname("James");
			
			customer.addEmail(email);
			customer.addAddress(address);
			customer.addPhone(phone);
			
			corporation.addCustomer(customer);
							
			session.beginTransaction();
			
//			session.persist(user);
			session.persist(corporation);
//			session.persist(customer);
			
			session.getTransaction().commit();
			
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
