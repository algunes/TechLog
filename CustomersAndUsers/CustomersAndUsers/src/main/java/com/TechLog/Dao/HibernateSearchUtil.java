package com.TechLog.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.TechLog.Customers.Customer;

public class HibernateSearchUtil {
	private static FullTextSession fullTextSession = null;
	private static Session session = null;
	
	static {
		if(fullTextSession == null) {
			session = HibernateUtil.getSessionFactory().openSession();
			fullTextSession = org.hibernate.search.Search.getFullTextSession(session);
			try {
				fullTextSession.createIndexer().startAndWait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Customer searchByCustomerName(String key) {
			Session session = null;
			Customer customer = new Customer();
			
			Transaction tx = fullTextSession.beginTransaction();
			
			// create native Lucene query using the query DSL
			// alternatively you can write the Lucene query using the Lucene query parser
			// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
			QueryBuilder qb = fullTextSession.getSearchFactory()
			  .buildQueryBuilder().forEntity(Customer.class).get();
			org.apache.lucene.search.Query query = qb
			  .keyword()
			  .onFields("title", "subtitle", "emails.email")
			  .matching(key)
			  .createQuery();

			// wrap Lucene query in a org.hibernate.Query
			org.hibernate.search.jpa.FullTextQuery hibQuery =
			    fullTextSession.createFullTextQuery(query, Customer.class);

			// execute search
			List<Customer> result = hibQuery.getResultList();

			tx.commit();
			session.close();
			
			return customer;		
		
	}

}
