package com.Techlog.Services.CustomerPermissions;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

public class CustomerDomainCreatePermissionService {
	
	private Boolean masterUserHasCreate;
	private Boolean masterUserIsAdmin;
	
	public CustomerDomainCreatePermissionService(Users masterUser) {
		super();
		UserService us = new UserService();
		this.masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));
		this.masterUserHasCreate = masterUser.getDomainPermissions().getCustomerDomain().is_create();
	}
	
	public Boolean createCustomer() {
		// --> Only the users have 'create permission' and admin can create customer or corporation fields
		if(masterUserHasCreate || masterUserIsAdmin) {
			return true;
		}
		else {
			return false;
		}
	}

}
