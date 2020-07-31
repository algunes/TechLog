package com.TechLog.DAO.Search;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.search.FullTextSession;

import com.TechLog.Hibernate.HibernateUtil;

public class SearchDAO {

	private static FullTextSession fullTextSession = null;
	private static Session session = null;

	public static FullTextSession getFullTextSession() {
		if (fullTextSession == null) {
			try {
				session = HibernateUtil.getSessionFactory().openSession();
				fullTextSession = org.hibernate.search.Search.getFullTextSession(session);
				try {
					fullTextSession.createIndexer().startAndWait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			} finally {
				if (fullTextSession == null)
					session.close();
			}
		}
		return fullTextSession;
	}

}
