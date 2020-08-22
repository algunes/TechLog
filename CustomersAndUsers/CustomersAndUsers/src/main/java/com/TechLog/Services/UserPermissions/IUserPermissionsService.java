package com.TechLog.Services.UserPermissions;

import com.TechLog.Entity.Users.Users;

public interface IUserPermissionsService {

	public void updateCustomerDomainPermission(Users user, Boolean c,
			Boolean r, Boolean u, Boolean d);
	public void updateUserDomainPermission(Users user, Boolean c,
			Boolean r, Boolean u, Boolean d);
	public void updateProductDomainPermission(Users user, Boolean c,
			Boolean r, Boolean u, Boolean d);
	public void updateStockDomainPermission(Users user, Boolean c,
			Boolean r, Boolean u, Boolean d);
	
}
