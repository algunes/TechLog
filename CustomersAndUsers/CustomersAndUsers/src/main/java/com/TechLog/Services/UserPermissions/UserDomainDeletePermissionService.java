package com.TechLog.Services.UserPermissions;

import java.util.Arrays;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

public class UserDomainDeletePermissionService {
	
	private Boolean masterUserHasDelete;
	private Boolean masterUserIsDeletingSelf;
	private Boolean targetUserIsAdmin;
	private Boolean masterUserIsAdmin;
	
	public UserDomainDeletePermissionService(Users masterUser, Users targetUser) {
		super();
		UserService us = new UserService();
		this.targetUserIsAdmin = "admin".equals(us.byteToUsername(targetUser.getUserAuth().getUserName()));
		this.masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));
		this.masterUserHasDelete = masterUser.getDomainPermissions().getUserDomain().is_delete();
		this.masterUserIsDeletingSelf = Arrays.equals(masterUser.getUserAuth().getUserName(),	targetUser.getUserAuth().getUserName());
	}
	
	public Boolean deleteUser() {
		// --> The users who have delete permission can delete other users, except admin
		// --> Users and admin can not delete themselves
		// --> Admin can delete other users
		
		if(masterUserHasDelete && !masterUserIsDeletingSelf && !targetUserIsAdmin) {
			return true;
		}
		else if(masterUserIsAdmin && !masterUserIsDeletingSelf) {
			return true;
		}
		else {
			return false;
		}
		
	}


}
