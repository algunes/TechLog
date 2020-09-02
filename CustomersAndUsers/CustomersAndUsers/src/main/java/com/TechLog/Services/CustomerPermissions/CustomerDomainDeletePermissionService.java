package com.TechLog.Services.CustomerPermissions;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

public class CustomerDomainDeletePermissionService {
	private Boolean masterUserHasDelete;
	private Boolean masterUserIsAdmin;
	
	public CustomerDomainDeletePermissionService(Users masterUser) {
		super();
		UserService us = new UserService();
		this.masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));
		this.masterUserHasDelete = masterUser.getDomainPermissions().getCustomerDomain().is_delete();
	}
	
	public Boolean deleteCustomer() {
		// --> Only the users have 'create permission' and admin can delete customer or corporation fields
		if(masterUserHasDelete || masterUserIsAdmin) {
			return true;
		}
		else {
			return false;
		}
	}
}
