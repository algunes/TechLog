package com.TechLog.Dao.CustomerImp;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(Customer customer) {
		
	}

}
