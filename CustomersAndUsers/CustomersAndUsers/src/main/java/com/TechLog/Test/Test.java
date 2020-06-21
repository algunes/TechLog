package com.TechLog.Test;

import java.util.List;
import java.util.ListIterator;

import com.TechLog.Customers.Address;
import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Customers.Email;
import com.TechLog.Customers.Phone;
import com.TechLog.Services.SearchService;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;

public class Test {

	public static void main(String[] args) {
		
//		Session session = null;
//		
//		try {
//			
//			session = HibernateUtil.getSessionFactory().openSession();
//			
			/*
			 * String sql = "select version()"; String result = (String)
			 * session.createNativeQuery(sql).getSingleResult(); System.out.println(result);
			 */
			
//			Users user = new Users();
//			user.setFirstname("Aliyar");
//			user.setLastname("G�ne�");
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
//			address.setAddress("Ata�ehirde bir yer");
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
//			customer.setLastname("Ad�s�per");
//			// customer.setCorporation(session.get(Corporation.class, 1L));
//			customer.addEmails(email);
//			customer.addEmails(email2);
		// -----------------------------------------------				
			
			// createCustomer();
		
//		Session session = null;
//		Customer customer = new Customer();
		
//		List<Email> emails = new ArrayList<>();
//		List<Phone> phones = new ArrayList<>();
//		List<Address> addresses = new ArrayList<>();
		
//		try {
//			session = HibernateUtil.getSessionFactory().openSession();
//			session.beginTransaction();
//			customer = session.get(Customer.class, 1L);	
//			Hibernate.initialize(customer.getEmails());
//			Hibernate.initialize(customer.getPhones());
//			Hibernate.initialize(customer.getAddresses());
////			emails = session.get(Customer.class, 1L).getEmails();
////			phones = session.get(Customer.class, 1L).getPhones();
////			addresses = session.get(Customer.class, 1L).getAddresses();
//			session.getTransaction().commit();
//		}
//		catch (HibernateException e) {
//			e.printStackTrace();
//		}
//		finally {
//			if (session != null) {
//				session.close();
//			}
//		}
		// createCorporation();
		// createFullCustomer();
		// createCustomer(1L);
			
			

//			session.beginTransaction();
//			
//			session.persist(corporation);
//			
//			Customer customer2 = session.get(Customer.class, 1L);
//			customer2.removeEmail(email1);
//			
//			session.getTransaction().commit();
//			
			
//			
//			
//			System.out.println("Added Customer is " + 
//					customer2.getFirstname() + " "
//					+ customer2.getLastname() + " v"
//					+ customer2. getCorporation().getName());
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally {
//			if (session != null)
//			session.close();
//		}
		
		SearchService search = new SearchService();
		
		List<Customer> list = search.searchByCustomerName("vladimir");
		
		System.out.println("Number of Customers: " + list.size());
		
		if (!list.isEmpty()) {
		ListIterator<Customer> iteratorC = list.listIterator();
		
		System.out.println("Customers: ");
		while (iteratorC.hasNext()) {
			
			Customer customer = iteratorC.next();
			System.out.println(customer.getFirstname());
			System.out.println(customer.getLastname());
			System.out.println(customer.getCorporation().getName());
			System.out.println("Number of emails:" + new CustomerServiceImp().getCustomer(customer.getCustomer_id(), true).getEmails().size());
			// System.out.println("Number of Emails: " + customer.getEmails().size());
			
		}
		}
		else {
			System.out.println("No results!");
		}

			
			
	}
	
	public static void justChecked() {
		
		CustomerServiceImp cservice = new CustomerServiceImp();
		Customer customer = cservice.getCustomer(1L, true);
		
		List<Email> emails = customer.getEmails();
		List<Phone> phones = customer.getPhones();
		List<Address> addresses = customer.getAddresses();
		
		System.out.println("Size of the Email List is: " + emails.size());
		System.out.println("Size of the Phone List is: " + phones.size());
		System.out.println("Size of the Address List is: " + addresses.size());
		
		System.out.println("----------------------");
		
		ListIterator<Email> iteratorE = emails.listIterator();
		ListIterator<Phone> iteratorP = phones.listIterator();
		ListIterator<Address> iteratorA = addresses.listIterator();
		
		System.out.println("Mails:");
		while (iteratorE.hasNext()) {
		System.out.println(iteratorE.next().getEmail());
		}
		
		System.out.println("----------------------");
		
		System.out.println("Phones:");
		while (iteratorP.hasNext()) {
			System.out.println(iteratorP.next().getNumber());
			}
		
		System.out.println("----------------------");
		
		System.out.println("Addresses:");
		while (iteratorA.hasNext()) {
			System.out.println(iteratorA.next().getAddress());
			}
		
	}
	
	public static void createFullCustomer() {
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
		address2.setAddress("Orada bir de �urada filanca adres");
		
		customer.addEmail(email1);
		customer.addEmail(email2);
		customer.addPhone(phone1);
		customer.addPhone(phone2);
		customer.addAddress(address1);
		customer.addAddress(address2);
		
		corporation.addCustomer(customer);
		
		CustomerServiceImp cservice = new CustomerServiceImp();
		cservice.createCorporation(corporation);
		// cservice.createCustomer(customer);
	}
	
	public static void createCustomer(Long corpId) {
		
		Customer customer = new Customer();
		customer.setFirstname("Vladimir");
		customer.setLastname("Nabokov");
		
		Email email1 = new Email();
		email1.setEmail("vlad1@nabokov.com");
		
		Email email2 = new Email();
		email2.setEmail("vlad2@nabokov.com");
		
		Phone phone1 = new Phone();
		phone1.setNumber("555555");
		
		Phone phone2 = new Phone();
		phone2.setNumber("77777777");
		
		Address address1 = new Address();
		address1.setAddress("Rua Dam Vale Cad. Lolita Sokak No:7/6 Bostanc�/�STANBUL");
		
		Address address2 = new Address();
		address2.setAddress("Pnin Caddesi, Saydam �eyler Sokak No:90/65 Suadiye/�stanbul");
		
		customer.addEmail(email1);
		customer.addEmail(email2);
		customer.addPhone(phone1);
		customer.addPhone(phone2);
		customer.addAddress(address1);
		customer.addAddress(address2);
		
		CustomerServiceImp cservice = new CustomerServiceImp();
		Corporation corporation = cservice.getCorporation(corpId, true);
		corporation.addCustomer(customer);
		cservice.createCustomer(customer);
	}
	
	public static void createCorporation () {
		Long corpId = null;
		Corporation corporation = new Corporation();
		corporation.setName("Alice Wonderland LLC");
		
		CustomerServiceImp cservice = new CustomerServiceImp();
		corpId = cservice.createCorporation(corporation);
		System.out.println("Your corporation ID is: " + corpId);
		
		Corporation corporation2 = cservice.getCorporation(corpId, true);
		System.out.println("Corporation name is: " + corporation2.getName());
	}

}
