package com.TechLog.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.TechLog.Corporations.Corporation;
import com.TechLog.Corporations.CorporationBuilder;
import com.TechLog.Customers.Customer;
import com.TechLog.Customers.CustomerBuilder;
import com.TechLog.Dao.CorporationImp.CorporationDaoImp;
import com.TechLog.Dao.UserImp.UserDaoImp;
import com.TechLog.Services.SearchService;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;
import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.UserBuilder;
import com.TechLog.Users.Users;

public class Test {

	public static void main(String[] args) {
		

//		Customer c = new CustomerBuilder()
//				.setFirstname("Kalamaeriğü")
//				.setLastname("çöşiüğ")
//				.setCorporation(new CustomerServiceImp().getCorporation(1L, false))
//				.setCreatedBy(new UserServiceImp().getUser(1L, false))
//				.build();
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		
		String password = "1234";
		
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		
		SecretKeyFactory factory = null;
		
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		byte[] hash = null;
		
		try {
			hash = factory.generateSecret(spec).getEncoded();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		System.out.println("original password: " + password);
		System.out.println("hashed password: " + Arrays.toString(hash));
		System.out.println("salt is: " + Arrays.toString(salt));
		System.out.println();
		
		spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		byte[] hash2 = null;
		
		try {
			hash2 = factory.generateSecret(spec).getEncoded();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		System.out.println("original password: " + password);
		System.out.println("hashed password: " + Arrays.toString(hash2));
		System.out.println("salt is: " + Arrays.toString(salt));	
		System.out.println();
		
		String password2 = "12345";
		
		spec = new PBEKeySpec(password2.toCharArray(), salt, 65536, 128);
		
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		byte[] hash3 = null;
		
		try {
			hash3 = factory.generateSecret(spec).getEncoded();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		HashMap<String, List<byte[]>> pass = new HashMap<>();
		
		List<byte[]> user1 = new ArrayList<>();
		user1.add(0, hash3);
		user1.add(1, salt);
		
		pass.put("admin", user1);
		
		
		System.out.println("original password: " + password2);
		System.out.println("hashed password: " + Arrays.toString(pass.get("admin").get(0)));
		System.out.println("salt is: " + Arrays.toString(pass.get("admin").get(1)));	
		System.out.println();
		System.out.println("Hash validation result is :" + pass.get("admin").get(0).equals(hash3));

		
				
	}
	
//	public static void justChecked() {
//		
//		CustomerServiceImp cservice = new CustomerServiceImp();
//		Customer customer = cservice.getCustomer(1L, true);
//		
//		List<Email> emails = customer.getEmails();
//		List<Phone> phones = customer.getPhones();
//		List<Address> addresses = customer.getAddresses();
//		
//		System.out.println("Size of the Email List is: " + emails.size());
//		System.out.println("Size of the Phone List is: " + phones.size());
//		System.out.println("Size of the Address List is: " + addresses.size()));
//		
//		System.out.println("----------------------");
//		
//		ListIterator<Email> iteratorE = emails.listIterator();
//		ListIterator<Phone> iteratorP = phones.listIterator();
//		ListIterator<Address> iteratorA = addresses.listIterator();
//		
//		System.out.println("Mails:");
//		while (iteratorE.hasNext()) {
//		System.out.println(iteratorE.next().getEmail());
//		}
//		
//		System.out.println("----------------------");
//		
//		System.out.println("Phones:");
//		while (iteratorP.hasNext()) {
//			System.out.println(iteratorP.next().getNumber());
//			}
//		
//		System.out.println("----------------------");
//		
//		System.out.println("Addresses:");
//		while (iteratorA.hasNext()) {
//			System.out.println(iteratorA.next().getAddress());
//			}
//		
//	}
	
//	public static void removeCorporation(Corporation corporation) {
//		new CustomerServiceImp().removeCorporation(corporation);
//	}
//	
//	public static void createFullCustomer() {
//		Corporation corporation = new Corporation();
//		corporation.setName("ACME");
//		
//		Customer customer = new Customer();
//		customer.setFirstname("Mircae");
//		customer.setLastname("Ealiade");
//		
//		Email email1 = new Email();
//		email1.setEmail("eliade@mircae.com");
//		
//		Email email2 = new Email();
//		email2.setEmail("eliade2@gmail.com");
//		
//		Phone phone1 = new Phone();
//		phone1.setNumber("123456789");
//		
//		Phone phone2 = new Phone();
//		phone2.setNumber("1234567891011");
//		
//		Address address1 = new Address();
//		address1.setAddress("üğüğüğüğüğşşişçöçö");
//		
//		Address address2 = new Address();
//		address2.setAddress("işişüğüğ.ç.ç");
//		
//		customer.addEmail(email1);
//		customer.addEmail(email2);
//		customer.addPhone(phone1);
//		customer.addPhone(phone2);
//		customer.addAddress(address1);
//		customer.addAddress(address2);
//		
//		corporation.addCustomer(customer);
//		
//		CustomerServiceImp cservice = new CustomerServiceImp();
//		cservice.createCorporation(corporation);
//		// cservice.createCustomer(customer);
//	}
//	
//	public static void createCustomer(Long corpId) {
//		
//		Customer customer = new Customer();
//		customer.setFirstname("Vladimir");
//		customer.setLastname("Nabokov");
//		
//		Email email1 = new Email();
//		email1.setEmail("vlad1@nabokov.com");
//		
//		Email email2 = new Email();
//		email2.setEmail("vlad2@nabokov.com");
//		
//		Phone phone1 = new Phone();
//		phone1.setNumber("555555");
//		
//		Phone phone2 = new Phone();
//		phone2.setNumber("77777777");
//		
//		Address address1 = new Address();
//		address1.setAddress("Rua Dam Vale Cad. Lolita Sokak No:7/6 Bostanc�/�STANBUL");
//		
//		Address address2 = new Address();
//		address2.setAddress("Pnin Caddesi, Saydam �eyler Sokak No:90/65 Suadiye/�stanbul");
//		
//		customer.addEmail(email1);
//		customer.addEmail(email2);
//		customer.addPhone(phone1);
//		customer.addPhone(phone2);
//		customer.addAddress(address1);
//		customer.addAddress(address2);
//		
//		CustomerServiceImp cservice = new CustomerServiceImp();
//		Corporation corporation = cservice.getCorporation(corpId, true);
//		corporation.addCustomer(customer);
//		cservice.createCustomer(customer);
//	}
//	
//	public static void createCorporation () {
//		Long corpId = null;
//		Corporation corporation = new Corporation();
//		corporation.setName("Alice Wonderland LLC");
//		
//		CustomerServiceImp cservice = new CustomerServiceImp();
//		corpId = cservice.createCorporation(corporation);
//		System.out.println("Your corporation ID is: " + corpId);
//		
//		Corporation corporation2 = cservice.getCorporation(corpId, true);
//		System.out.println("Corporation name is: " + corporation2.getName());
//	}

}
