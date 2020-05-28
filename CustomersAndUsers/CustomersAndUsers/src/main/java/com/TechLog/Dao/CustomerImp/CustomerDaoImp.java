package com.TechLog.Dao.CustomerImp;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Customers.Customer;
import com.TechLog.Dao.CustomerDao;
import com.TechLog.Dao.HibernateUtil;

public class CustomerDaoImp implements CustomerDao {

	@Override
	public boolean addCustomer(Customer customer) {
		Session session = null;
		boolean result = false;
		Long id = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			id = (Long) session.save(customer);
			session.getTransaction().commit();			
		}
		catch (HibernateException e) {
			e.printStackTrace();
		}
		finally {
			if (session != null)
			session.close();
			if (id != null)
				result = true;
		}
		return result;
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer fetchCustomer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

}
