package com.TechLog.DAO.Initialization;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Entity.Permissions.Permission;
import com.TechLog.Hibernate.HibernateUtil;


public class PermissionDao {
	
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
			e.printStackTrace();
		}
		finally {
			if (session != null)
			session.close();
		}
}

}
