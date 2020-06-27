package com.TechLog.Services;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.search.Query;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.TechLog.Customers.Customer;
import com.TechLog.Dao.Search.SearchDao;

public class SearchService {

	@SuppressWarnings("unchecked")
	public List<Customer> searchByCustomerName(String key) {
		List<Customer> results = new ArrayList<>();

		FullTextSession fullTextSession = SearchDao.getFullTextSession();
		Transaction tx = fullTextSession.beginTransaction();
		
		try {
			
			QueryBuilder qb = fullTextSession.getSearchFactory().
					buildQueryBuilder().
					forEntity(Customer.class).get();

			Query query = qb.keyword().
					fuzzy().
					withEditDistanceUpTo(2).
					withPrefixLength(0).
					onFields("firstname", "lastname", "emails.email", "phones.number").
					matching(key).createQuery();

			// wrap Lucene query in a org.hibernate.Query
			org.hibernate.search.jpa.FullTextQuery hibQuery = fullTextSession.createFullTextQuery(query, Customer.class);

			// hibQuery.setProjection("firstname", "lastname", "emails.email");

			// execute search
			if (!hibQuery.getResultList().isEmpty()) 
				results = hibQuery.getResultList();

			tx.commit();				
		}
		
		catch (Exception e) {			
			e.printStackTrace();			
		}

		return results;

	}
}
