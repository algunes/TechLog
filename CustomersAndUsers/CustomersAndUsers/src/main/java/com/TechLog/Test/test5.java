package com.TechLog.Test;

import com.TechLog.Entity.Users.UserRoleBuilder;
import com.TechLog.Entity.Users.UserRoles;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.User.UserService;
import com.TechLog.Services.User.Roles.UserRolesPostService;

public class test5 {
	
	public static void main(String[] args) {
		
		new UserService().createUser(user)
	
	UserRoles ur = new UserRoleBuilder().
			setName("admin")
			.setCreate(true)
			.setRead(true)
			.setUpdate(true)
			.setDelete(true)
			.addUser(new UserService().getUser(4L, true))
			.build();
	new UserRolesPostService().updateUserRole(ur);
	
	

		
	}
	

}
