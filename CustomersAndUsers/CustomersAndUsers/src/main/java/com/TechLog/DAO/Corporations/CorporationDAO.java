package com.TechLog.DAO.Corporations;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Hibernate.HibernateUtil;

public class CorporationDAO implements CorporationDao {

	@Override
	public Corporation addCorporation(Corporation corporation) {
		
		if(validateCorporationName(corporation.getName()) == null) {
			Long id = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			id = (Long)session.save(corporation);
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
		return fullFetchCorporation(id);
		}
		else {
			return null;
		}
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
				
			CriteriaQuery<Corporation> criteriaQuery = session
					.getCriteriaBuilder()
					.createQuery(Corporation.class);
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
	public Corporation updateCorporation(Corporation corporation) {

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
			return null;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return fullFetchCorporation(corporation.getId());
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
	
	@Override
	public Corporation validateCorporationName(String name) {
		Session session = null;
		Corporation result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Corporation> cr = cb.createQuery(Corporation.class);
			Root<Corporation> root = cr.from(Corporation.class);
			
			cr.select(root).where(cb.equal(root.get("name"), name));
			 
			result = (session.createQuery(cr).getResultList().isEmpty() ? 
					null : session.createQuery(cr).getSingleResult());
			
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
