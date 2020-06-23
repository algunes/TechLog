package com.TechLog.Dao.CorporationImp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import javax.persistence.criteria.CriteriaQuery;

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
	public List<Corporation> fetchAllCorporations() {
		
		Session session = null;
		List<Corporation> corporations = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
				
			CriteriaQuery<Corporation> criteriaQuery = session.getCriteriaBuilder().createQuery(Corporation.class);
	        criteriaQuery.from(Corporation.class);

	        corporations = session.createQuery(criteriaQuery).getResultList();
			
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
		return corporations;
		
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
