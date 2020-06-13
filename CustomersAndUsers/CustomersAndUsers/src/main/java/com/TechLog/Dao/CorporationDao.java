package com.TechLog.Dao;

import com.TechLog.Customers.Corporation;

public interface CorporationDao {
	
	Long addCorporation(Corporation corporation);
	Corporation fetchCorporation(Long id);
	Corporation fullFetchCorporation(Long id);
	void updateCorporation(Corporation corporation);
	void deleteCorporation(Corporation corporation);

}
