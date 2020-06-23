package com.TechLog.Dao;

import java.util.List;

import com.TechLog.Customers.Corporation;

public interface CorporationDao {
	
	Long addCorporation(Corporation corporation);
	Corporation fetchCorporation(Long id);
	Corporation fullFetchCorporation(Long id);
	List<Corporation> fetchAllCorporations();
	void updateCorporation(Corporation corporation);
	void deleteCorporation(Corporation corporation);

}
