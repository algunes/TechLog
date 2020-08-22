package com.TechLog.Test.Permissions;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

class UserDao {
	
public void addUser(Users user) {
			
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			session.save(user);
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

public void deleteUser(Users u) {

	Session session = null;
	try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(u);
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

public void updateUser(Users u) {
	
	Session session = null;
	try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(u);		
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

public Users fetchUser(Long id) {
	Session session = null;
	Users user = new Users();;
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
		Hibernate.initialize(user.getDomainPermissions());
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
	
}
