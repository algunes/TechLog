package com.TechLog.DAO.Customers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Hibernate.HibernateUtil;

public class CustomerDAO implements ICustomerDao {

	@Override
	public Long addCustomer(Customer customer) {
		Session session = null;
		Long id = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			id = (Long)session.save(customer);
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
		return id;
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
			Hibernate.initialize(customer.getTelNums());
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
	@Override
	public List<Customer> lastAddedCustomers () {
		Session session = null;
		List<Customer> result = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Customer> cr = cb.createQuery(Customer.class);
			Root<Customer> root = cr.from(Customer.class);
			
			cr.orderBy(cb.desc(root.get("creation_date")));
						 
			result = (session.createQuery(cr).getResultList().isEmpty() ? 
					null : session.createQuery(cr).setMaxResults(6).list());
			
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
		return result;
	}
	
	@Override
	public List<Customer> lastUpdatedCustomers () {
		Session session = null;
		List<Customer> result = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Customer> cr = cb.createQuery(Customer.class);
			Root<Customer> root = cr.from(Customer.class);
			
			cr.select(root).where(cb.isNotNull(root.get("last_update")));
			cr.orderBy(cb.desc(root.get("last_update")));
								 
			result = session.createQuery(cr).setMaxResults(6).list();
			
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
		return result;
	}

}
