package com.TechLog.Services.Corporation;

import java.util.List;

import com.TechLog.Entity.Corporations.Corporation;

public interface ICorporationPostService {
	
	Corporation createCorporation(Corporation corporation);
	Corporation removeCorporation(Long id);
	Corporation getCorporation(Long id, boolean isFull);
	List<Corporation> getAllCorporations();
	Corporation updateCorporation(Corporation corporation);
	Corporation validateCorporationName(String name);

}
