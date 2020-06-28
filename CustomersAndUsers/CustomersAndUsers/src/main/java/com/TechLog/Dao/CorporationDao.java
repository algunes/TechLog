package com.TechLog.Dao;

import java.util.List;

import com.TechLog.Customers.Corporation;

public interface CorporationDao {
	
	Long addCorporation(Corporation corporation); // Create
	Corporation fetchCorporation(Long id); // Fetching a corp. lazily
	Corporation fullFetchCorporation(Long id); // Fetching a corp. eagerly
	List<Corporation> fetchAllCorporations(); // Fetch a list of all corporations (lazily)
	void updateCorporation(Corporation corporation); // Update
	void deleteCorporation(Corporation corporation); // Delete

}
