package com.Techlog.Services.CustomerPermissions;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

public class CustomerDomainReadPermissionService {

	private Boolean masterUserHasRead;
	private Boolean masterUserIsAdmin;
	
	public CustomerDomainReadPermissionService(Users masterUser) {
		super();
		UserService us = new UserService();
		this.masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));
		this.masterUserHasRead = masterUser.getDomainPermissions().getCustomerDomain().is_read();
	}
	
	public Boolean readCustomer() {
		// --> Only the users have 'create permission' and admin can read customer or corporation fields
		if(masterUserHasRead) {
			return true;
		}
		else if(masterUserIsAdmin) {
			return true;
		}
		else {
			return false;
		}
	}	
}
