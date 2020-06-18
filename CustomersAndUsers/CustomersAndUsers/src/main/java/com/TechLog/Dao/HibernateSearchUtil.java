package com.TechLog.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

import com.TechLog.Customers.Customer;

public class HibernateSearchUtil {
	
	public Customer searchByCustomerName(String key) {
		
		Session session = null;
		Long result = null;
		Customer customer = new Customer();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
			
			session.getTransaction().commit();			
		}
		catch (HibernateException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (session != null)
			session.close();
		}
		
		return customer;
		
	}

}
