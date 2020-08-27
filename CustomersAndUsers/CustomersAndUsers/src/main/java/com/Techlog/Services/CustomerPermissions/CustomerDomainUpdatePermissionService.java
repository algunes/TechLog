package com.Techlog.Services.CustomerPermissions;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

public class CustomerDomainUpdatePermissionService {
	private Boolean masterUserHasUpdate;
	private Boolean masterUserIsAdmin;
	
	public CustomerDomainUpdatePermissionService(Users masterUser) {
		super();
		UserService us = new UserService();
		this.masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));
		this.masterUserHasUpdate = masterUser.getDomainPermissions().getCustomerDomain().is_update();
	}
	
	public Boolean updateCustomer() {
		// --> Only the users have 'create permission' and admin can update customer or corporation fields
		if(masterUserHasUpdate || masterUserIsAdmin) {
			return true;
		}
		else {
			return false;
		}
	}
}
