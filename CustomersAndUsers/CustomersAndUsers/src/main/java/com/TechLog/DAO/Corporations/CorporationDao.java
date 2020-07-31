package com.TechLog.DAO.Corporations;

import java.util.List;

import com.TechLog.Entity.Corporations.Corporation;

public interface CorporationDao {
	
	Corporation addCorporation(Corporation corporation); // Create
	Corporation fetchCorporation(Long id); // Fetching a corp. lazily
	Corporation fullFetchCorporation(Long id); // Fetching a corp. eagerly
	List<Corporation> fetchAllCorporations(); // Fetch a list of all corporations (lazily)
	Corporation updateCorporation(Corporation corporation); // Update
	void deleteCorporation(Corporation corporation); // Delete
	Corporation validateCorporationName(String name); // For name originality 

}
