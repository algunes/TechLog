package com.TechLog.Services.Search;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.search.Query;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.TechLog.DAO.Search.SearchDAO;
import com.TechLog.Entity.Customers.Customer;

public class SearchService {

	@SuppressWarnings("unchecked")
	public SearchDTO searchByCustomerName(String key, Integer first, Integer max) {
		SearchDTO sdto = new SearchDTO();
		FullTextSession fullTextSession = SearchDAO.getFullTextSession();
		Transaction tx = fullTextSession.beginTransaction();
		
		try {
			
			QueryBuilder qb = fullTextSession.getSearchFactory().
					buildQueryBuilder().
					forEntity(Customer.class).get();

			Query query = qb.keyword().
					fuzzy().
					withEditDistanceUpTo(2).
					withPrefixLength(0).
					onFields("firstname", "lastname", "corporation.name", "corporation.sector", "emails", "telNums", "addresses", "department", "position").
					matching(key).createQuery();
			
			

			// wrap Lucene query in a org.hibernate.Query
			org.hibernate.search.jpa.FullTextQuery hibQuery = fullTextSession.createFullTextQuery(query, Customer.class).setFirstResult(first).setMaxResults(max);
			
			// hibQuery.setProjection("firstname", "lastname", "emails.email");

			// execute search
			if (!hibQuery.getResultList().isEmpty()) 
				sdto.setCustomers(hibQuery.getResultList());
				sdto.setNumberOfResult(hibQuery.getResultSize());
			tx.commit();				
		}
		
		catch (Exception e) {			
			e.printStackTrace();			
		}

		return sdto;

	}
	
	public Boolean searchInputFilter(String keyword) {

		keyword = keyword.replaceAll("\\s+", " ");

		// can't start except these
		Pattern firstCharPattern = Pattern.compile("\\A[A-Za-z0-9ğüşöçıİĞÜŞÖÇ+]");
		Matcher firstCharMatcher = firstCharPattern.matcher(keyword);

		// rest of the keyword can consist of these (\\w means all alphanumericals)
		Pattern validPattern = Pattern.compile("[^\\w @üÜşŞğĞöÖçÇıİ.+-]");
		Matcher validMatcher = validPattern.matcher(keyword);

		Boolean firstCharTest = firstCharMatcher.find();
		Boolean validTest = validMatcher.find();
		
		return firstCharTest && !validTest && keyword.length()>2;
	}

}
