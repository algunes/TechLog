package com.TechLog.Services.Corporation;

import java.time.LocalDateTime;
import java.util.List;

import com.TechLog.DAO.Corporations.CorporationDAO;
import com.TechLog.Entity.Corporations.Corporation;

public class CorporationPostService implements ICorporationPostService {

	@Override
	public Corporation createCorporation(Corporation corporation) {
		// create a corporation
		corporation.setCreation_date(LocalDateTime.now());
		return new CorporationDAO().addCorporation(corporation);
	}

	@Override
	public void removeCorporation(Long id) {
		// removes a specific corporation
		Corporation corporation = getCorporation(id, true);
		new CorporationDAO().deleteCorporation(corporation);
	}

	@Override
	public Corporation getCorporation(Long id, boolean isFull) {
		// get a corporation (isFull: lazy or eager)
		if (isFull)
			return new CorporationDAO().fullFetchCorporation(id);
		else
			return new CorporationDAO().fetchCorporation(id);
	}

	@Override
	public List<Corporation> getAllCorporations() {
		// retrieve all rows from db corporation table (just for corporation name listing)
		return new CorporationDAO().fetchAllCorporations();
	}

	@Override
	public Corporation updateCorporation(Corporation corporation) {
		// update a corporation
		corporation.setLast_update(LocalDateTime.now());
		return new CorporationDAO().updateCorporation(corporation);
	}

	@Override
	public Corporation validateCorporationName(String name) {
		// Validate Corporation Name for singularity
		return new CorporationDAO().validateCorporationName(name);
	}
	
	@Override
	public List<Corporation> getLastAddedCorporations() {
		return new CorporationDAO().lastAddedCorporations();
	}
	
	public Long getNumberOfCorporation() {
		return new CorporationDAO().countCorporation();
	}

}
