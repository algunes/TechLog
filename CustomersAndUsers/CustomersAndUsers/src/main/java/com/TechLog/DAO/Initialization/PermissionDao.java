package com.TechLog.DAO.Initialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Entity.Permissions.Permission;
import com.TechLog.Hibernate.HibernateUtil;


public class PermissionDao {
	
	private Logger log = LogManager.getLogger(PermissionDao.class);

	
public void addPermission(Permission p) {
		
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
			log.error(e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (session != null)
			session.close();
		}
}

public Permission fetchUser(Long id) {
	Session session = null;
	Permission permission = null;
	try {
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		permission = session.get(Permission.class, id);		
		session.getTransaction().commit();
	}
	catch (HibernateException e) {
		e.printStackTrace();
		log.error(e.getMessage());
	}
	finally {
		if (session != null) {
			session.close();
		}
	}
	return permission;
}

}
