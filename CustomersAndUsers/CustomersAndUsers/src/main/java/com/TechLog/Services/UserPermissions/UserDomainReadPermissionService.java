package com.TechLog.Services.UserPermissions;


import java.util.Arrays;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

public class UserDomainReadPermissionService {
	
	private Boolean masterUserHasRead;
	private Boolean masterUserIsReadingSelf;
	private Boolean masterUserIsAdmin;
	
	public UserDomainReadPermissionService(Users masterUser, Users targetUser) {
		super();
		UserService us = new UserService();
		this.masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));
		this.masterUserHasRead = masterUser.getDomainPermissions().getUserDomain().is_read();
		this.masterUserIsReadingSelf = Arrays.equals(masterUser.getUserAuth().getUserName(),
				targetUser.getUserAuth().getUserName());
	}
	
	public Boolean showUserList() {
		// --> Only the users who have read permission and admin can get the user list
		return masterUserIsAdmin || masterUserHasRead ? true : false;
	}
	public Boolean details() {
		// --> Users can read their own user details
		// --> Only the users who have read permission and admin can reach the other user's details
		return masterUserIsAdmin || masterUserIsReadingSelf || masterUserHasRead
				? true : false;		
	}
	public Boolean getCreatedCorporations() {
		// --> Users can get their own created corporations
		// --> Only the users who have read permission and admin can reach the other user's created corporations
		return masterUserIsAdmin || masterUserHasRead || masterUserHasRead || masterUserIsReadingSelf ? true : false;
	}
	public Boolean getCreatedCustomers() {
		// --> Users can get their own created customers
		// --> Only the users who have read permission and admin can reach the other user's created customers
		return masterUserIsAdmin || masterUserHasRead || masterUserHasRead ? true : false;
	}

}
