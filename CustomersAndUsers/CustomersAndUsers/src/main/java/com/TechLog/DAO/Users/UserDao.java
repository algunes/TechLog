package com.TechLog.DAO.Users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Entity.Users.UserAuthenticationInfo;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Hibernate.HibernateUtil;

public class UserDao {

	public Users addUser(Users user) {
					
		Session session = null;
		Long result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			result = (Long)session.save(user);
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
		return fullFetchUser(result);
		
	}

	public Users fetchUser(Long id) {
		Session session = null;
		Users user = new Users();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			user = session.get(Users.class, id);		
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
		return user;
	}

	public Users fullFetchUser(Long id) {
		Session session = null;
		Users user = new Users();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			user = session.get(Users.class, id);	
			Hibernate.initialize(user.getCreated_customers());
			Hibernate.initialize(user.getUpdated_customers());
			Hibernate.initialize(user.getCreated_corporations());
			Hibernate.initialize(user.getUpdated_corporations());
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
		return user;
	}

	public List<Users> fetchAllUsers() {
		Session session = null;
		List<Users> users = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
				
			CriteriaQuery<Users> criteriaQuery = session.getCriteriaBuilder().createQuery(Users.class);
	        criteriaQuery.from(Users.class);

	        users = session.createQuery(criteriaQuery).getResultList();
			
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
		return users;
	}

	public Users updateUser(Users user) {
		
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(user);		
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
		return fullFetchUser(user.getId());
	}

	public void deleteUser(Users user) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(user);
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
	
	public boolean addUserAuthInfo(UserAuthenticationInfo userAuthInf) {
		Session session = null;
		
		if(validateUserName(userAuthInf.getUserName()) == null) {
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			session.save(userAuthInf);
			session.getTransaction().commit();			
		}
		catch (HibernateException e) {
			if(session.getTransaction() != null)
				session.beginTransaction().rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			if (session != null)
			session.close();
		}
		return true;
		}
		else {
			return false;
		}
	}
	
	public UserAuthenticationInfo validateUserName(byte[] userName) {
		Session session = null;
		UserAuthenticationInfo result = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<UserAuthenticationInfo> cr = cb.createQuery(UserAuthenticationInfo.class);
			Root<UserAuthenticationInfo> root = cr.from(UserAuthenticationInfo.class);
			
			cr.select(root).where(cb.equal(root.get("userName"), userName));
			 
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
	
	public List<Users> lastLoginUsers () {
		Session session = null;
		List<Users> result = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Users> cr = cb.createQuery(Users.class);
			Root<Users> root = cr.from(Users.class);
			
			cr.select(root).where(cb.isNotNull(root.get("lastLogin")));
			cr.orderBy(cb.desc(root.get("lastLogin")));
								 
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
