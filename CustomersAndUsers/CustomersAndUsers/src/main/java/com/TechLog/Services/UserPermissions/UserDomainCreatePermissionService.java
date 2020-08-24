package com.TechLog.Services.UserPermissions;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

public class UserDomainCreatePermissionService {

	private Boolean masterUserHasCreate;
	private Boolean masterUserIsAdmin;
	
	public UserDomainCreatePermissionService(Users masterUser) {
		super();
		UserService us = new UserService();
		this.masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));
		this.masterUserHasCreate = masterUser.getDomainPermissions().getUserDomain().is_create();
	}
	
	public Boolean createUser() {
		// --> Only the users have create permission and admin can create a user
		if(masterUserHasCreate) {
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
