package com.TechLog.DAO.Role.Users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Entity.Users.UserRoles;
import com.TechLog.Hibernate.HibernateUtil;

public class UserRolesDAO implements IUserRolesDAO {

	@Override
	public UserRoles create(UserRoles ur) {
		if(validateName(ur.getName()) == null) {
			Long id = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			id = (Long)session.save(ur);
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
		return fullRead(id);
		}
		else {
			return null;
		}
	}

	@Override
	public UserRoles read(Long id) {
		Session session = null;
		UserRoles ur = new UserRoles();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			ur = session.get(UserRoles.class, id);		
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
		return ur;
	}

	@Override
	public UserRoles fullRead(Long id) {
		Session session = null;
		UserRoles ur = new UserRoles();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			ur = session.get(UserRoles.class, id);	
			Hibernate.initialize(ur.getUsers());
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
		return ur;
	}

	@Override
	public List<UserRoles> readAll() {
		Session session = null;
		List<UserRoles> urs = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
				
			CriteriaQuery<UserRoles> criteriaQuery = session
					.getCriteriaBuilder()
					.createQuery(UserRoles.class);
	        criteriaQuery.from(UserRoles.class);

	        urs = session.createQuery(criteriaQuery).getResultList();
			
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
		return urs;
	}

	@Override
	public UserRoles update(UserRoles ur) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(ur);		
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
		return fullRead(ur.getId());
	}

	@Override
	public void delete(UserRoles ur) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(ur);
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
	public UserRoles validateName(String name) {
		Session session = null;
		UserRoles result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<UserRoles> cr = cb.createQuery(UserRoles.class);
			Root<UserRoles> root = cr.from(UserRoles.class);
			
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
