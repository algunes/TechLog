package com.TechLog.Services.Corporation;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Entity.Users.Users;

public interface ICorporationPreService {

	Corporation createCorporation(String name, String sector, boolean isActive, Users user);
	Corporation updateCorporationName(Long  id, String oldName, String newName, Users user);
	Corporation updateCorporationSector(Long  id, String oldSector, String newSector, Users user);

}
