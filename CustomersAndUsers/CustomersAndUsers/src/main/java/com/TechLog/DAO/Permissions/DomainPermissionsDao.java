package com.TechLog.DAO.Permissions;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Entity.Permissions.DomainPermissions;
import com.TechLog.Hibernate.HibernateUtil;


public class DomainPermissionsDao {

public void addDomainPermissions(DomainPermissions p) {
		
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			session.save(p);
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

public void deleteDomainPermissions(DomainPermissions d) {

	Session session = null;
	try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(d);
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
