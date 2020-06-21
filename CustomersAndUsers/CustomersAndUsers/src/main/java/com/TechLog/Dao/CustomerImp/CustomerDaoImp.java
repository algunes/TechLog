package com.TechLog.Dao.CustomerImp;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Customers.Customer;
import com.TechLog.Dao.CustomerDao;
import com.TechLog.Dao.HibernateUtil;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public void addCustomer(Customer customer) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			session.save(customer);
			session.getTransaction().commit();			
		}
		catch (HibernateException e) {
			if(session.getTransaction() != null)
				session.beginTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null)
			session.close();
		}
	}

	@Override
	public void deleteCustomer(Customer customer) {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(customer);
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			if(session.getTransaction() != null)
				session.beginTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Customer fetchCustomer(Long id) {
		Session session = null;
		Customer customer = new Customer();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();			
			customer = session.get(Customer.class, id);	
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return customer;
	}
	
	@Override
	public Customer fullFetchCustomer(Long id) {
		
		Session session = null;
		Customer customer = new Customer();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			customer = session.get(Customer.class, id);
			Hibernate.initialize(customer.getEmails());
			Hibernate.initialize(customer.getPhones());
			Hibernate.initialize(customer.getAddresses());
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(customer);		
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			if(session.getTransaction() != null)
				session.beginTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		
	}

}
