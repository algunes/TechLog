package com.TechLog.Services.Corporation;

import java.time.LocalDate;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Entity.Corporations.CorporationBuilder;
import com.TechLog.Entity.Users.Users;

public class CorporationPreService implements ICorporationPreService {

	@Override
	public Corporation createCorporation(String name, String sector, boolean isActive, Users user) {
		// create a corporation from scratch (there is one-to-many association between corporation and customer classes. Customer is a subclass of Corporation.)
		Corporation corporation = new CorporationBuilder()
				.setName(name)
				.setSector(sector)
				.setIsActive(isActive)
				.setCreated_by(user)
				.setCreationDate(LocalDate.now())
				.build();
		return new CorporationPostService().createCorporation(corporation);
	}

	@Override
	public Corporation updateCorporationName(Long id, String oldName, String newName, Users user) {
		// update corporation name	
		CorporationPostService cps = new CorporationPostService();
		Corporation corporation = cps.getCorporation(id, true);
		
		if(corporation != null && 
			cps.validateCorporationName(newName) == null && 
			corporation.getName().equals(oldName)) {
	
			corporation.setName(newName);
			corporation.setUpdated_by(user);
			corporation.setLast_update(LocalDate.now());
			return cps.updateCorporation(corporation);
		}
		else {
			return null;
		}
		
	}

	@Override
	public Corporation updateCorporationSector(Long id, String oldSector, String newSector, Users user) {
		// update corporation sector
		CorporationPostService cps = new CorporationPostService();
		Corporation corporation = cps.getCorporation(id, true);
		
		if(corporation != null && corporation.getSector().equals(oldSector)) {
			
			corporation.setSector(newSector);
			corporation.setUpdated_by(user);
			corporation.setLast_update(LocalDate.now());
			return cps.updateCorporation(corporation);
		}
		else {
			return null;
		}
	}

}
