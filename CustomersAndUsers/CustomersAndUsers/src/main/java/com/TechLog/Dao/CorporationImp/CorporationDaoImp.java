package com.TechLog.Dao.CorporationImp;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Customers.Corporation;
import com.TechLog.Dao.CorporationDao;
import com.TechLog.Dao.HibernateUtil;

public class CorporationDaoImp implements CorporationDao {

	@Override
	public Long addCorporation(Corporation corporation) {
		Session session = null;
		Long result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			result = (Long)session.save(corporation);
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
		return result;
	}

	@Override
	public Corporation fetchCorporation(Long id) {

		Session session = null;
		Corporation corporation = new Corporation();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			corporation = session.get(Corporation.class, id);		
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
		return corporation;
	}
	
	@Override
	public Corporation fullFetchCorporation(Long id) {

		Session session = null;
		Corporation corporation = new Corporation();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			corporation = session.get(Corporation.class, id);	
			Hibernate.initialize(corporation.getCustomers());
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
		return corporation;
	}

	@Override
	public void updateCorporation(Corporation corporation) {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(corporation);		
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
	public void deleteCorporation(Corporation corporation) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(corporation);
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
