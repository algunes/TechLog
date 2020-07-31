package com.TechLog.Test;

import com.TechLog.Entity.Users.UserRoles;
import com.TechLog.Services.User.UserService;

public class test5 {
	
	public static void main(String[] args) {
	
	UserRoles ur = new UserRoles();
	ur.setCreate(true);
	ur.setDelete(true);
	ur.setRead(true);
	ur.setUpdate(true);
	ur.setName("Admin");
	ur.addUser(new UserService().getUser(1L, true));
	
	

		
	}
	

}
