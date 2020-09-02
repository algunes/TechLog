package com.TechLog.Services.UserPermissions;

import java.util.Arrays;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

public class UserDomainUpdatePermissionService {
	
	private Boolean masterUserHasUpdate;
	private Boolean masterUserIsUpdatingSelf;
	private Boolean targetUserIsAdmin;
	private Boolean masterUserIsAdmin;
	
	public UserDomainUpdatePermissionService(Users masterUser, Users targetUser) {
		super();
		UserService us = new UserService();
		this.targetUserIsAdmin = "admin".equals(us.byteToUsername(targetUser.getUserAuth().getUserName()));
		this.masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));
		this.masterUserHasUpdate = masterUser.getDomainPermissions().getUserDomain().is_update();
		this.masterUserIsUpdatingSelf = Arrays.equals(masterUser.getUserAuth().getUserName(),targetUser.getUserAuth().getUserName());
	}
	
	public Boolean updateUsername() {
		// --> Users can update their username 
		// --> The users who had update permission can update other user's usernames, except admin's
		// --> admin can update all usernames with or without update permission
		// --> admin can't change its username
		
		if(!masterUserIsAdmin && masterUserHasUpdate && !targetUserIsAdmin) {
			return true;
		}
		else if(masterUserIsAdmin && !masterUserIsUpdatingSelf) {
			return true;
		}
		else if(!masterUserIsAdmin && masterUserIsUpdatingSelf) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Boolean updatePassword() {
		// --> No user can update other user's password
		return masterUserIsUpdatingSelf ? true : false;
	}
	
	public Boolean resetPassword() {
		// --> Admin user can reset all passwords, except itself
		return masterUserIsAdmin && !masterUserIsUpdatingSelf ? true : false;
	}
	
	public Boolean updateFirstname() {
		// --> Only the users who have update permission can update firstnames, except admin's
		// --> admin can update all Firstnames with or without update permission
		return masterUserIsAdmin || (masterUserHasUpdate && !targetUserIsAdmin) ? true : false;
		}
	
	public Boolean updateLastname() {
		// --> Only the users who have update permission can update lastnames, except admin's
		return masterUserIsAdmin || (masterUserHasUpdate && !targetUserIsAdmin) ? true : false;
		}
	
	public Boolean updateDepartment() {
		// --> Only the users who have update permission can update departments, except admin's
		return masterUserIsAdmin || (masterUserHasUpdate && !targetUserIsAdmin) ? true : false;
	}
	
	public Boolean updatePosition() {
		// --> Only the users who have update permission can update departments, except admin's
		return masterUserIsAdmin || (masterUserHasUpdate && !targetUserIsAdmin) ? true : false;
	}
	
	public Boolean updatePermissions() {
		// --> No user can update their own permissions
		// --> Only the users who have update permission can update other's permissions
		// --> No user can update admin's permissions.
		// --> Admin can update all users permissions
		
		if(masterUserHasUpdate && !masterUserIsUpdatingSelf && !targetUserIsAdmin) {
			return true;
		}
		else if(masterUserIsAdmin && !masterUserIsUpdatingSelf) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public Boolean updateEmail() {
		// --> Users can update their own email
		// --> Users who have update permission can change other's email, except admin's
		// --> Admin can update its own and user's email
	
		if(masterUserHasUpdate && !targetUserIsAdmin) {
			return true;
		}
		else if(masterUserIsAdmin || masterUserIsUpdatingSelf) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public Boolean updateTelNumber() {
		// --> Users can update their own tel nums
		// --> Users who have update permission can change other's tel nums, except admin's
		// --> Admin can update its own and user's tel num
	
		if(masterUserHasUpdate && !targetUserIsAdmin) {
			return true;
		}
		else if(masterUserIsAdmin || masterUserIsUpdatingSelf) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public Boolean updateAddress() {
		// --> Users can update their own addresses
		// --> Users who have update permission can change other's addresses, except admin's
		// --> Admin can update its own and user's address
	
		if(masterUserHasUpdate && !targetUserIsAdmin) {
			return true;
		}
		else if(masterUserIsAdmin || masterUserIsUpdatingSelf) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	}

	
