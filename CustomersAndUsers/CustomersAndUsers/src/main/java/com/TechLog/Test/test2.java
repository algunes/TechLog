package com.TechLog.Test;

import java.time.LocalDate;

import com.TechLog.Entity.Permissions.CustomerDomainPermission;
import com.TechLog.Entity.Permissions.Permission;
import com.TechLog.Entity.Permissions.UserRolesOnCustomersBuilder;
import com.TechLog.Entity.Users.UserAuthenticationInfo;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.User.UserService;
import com.TechLog.Services.User.Permissions.UserRolesOnCustomersPostService;

public class test2 {

	public static void main(String[] args) {
		
//		String str1 = "hello";
//		String str2 = "Hello";
//		
//		byte[] b1 = str1.getBytes();
//		byte[] b2 = str2.getBytes();
//		
//		System.out.println(Arrays.toString(b1));
//		System.out.println(Arrays.toString(b2));
//		
//		System.out.println(new String(b1));
//		System.out.println(new String(b2));
		
		
		
		UserService us = new UserService();
		
		
		
		
		
		Users user = new Users();
		user.setFirstname("Aliyar2");
		user.setLastname("Güneş2");
		user.setEmail("aliyargunes2@gmail.com");
		// user.getRoles().add(ur);
		user.setStartDate(LocalDate.now());
		
		UserAuthenticationInfo uai = us.userAuthInfoBuild("admin46", "1234");
		uai.setUser(user);
		user.setUserAuth(uai);
		
		
		
		Users user2 = us.createUser(user);
		
		CustomerDomainPermission ur = new UserRolesOnCustomersBuilder().
				setName("admino")
				.addUser(user2)
				.setCreate(true)
				.setRead(true)
				.setUpdate(true)
				.setDelete(true)
				.build();
		
		Permission role = ur;
		
		new UserRolesOnCustomersPostService().createUserRole(role);
		
		us.addRole(user2.getId(), ur);
		us.updateUser(user2);
		
		
		
		
		if (user2 != null) {
			System.out.println("user created");
		}
		else {
			System.out.println("user not created");
		}
//		
		
		
//		Users user2 = us.userLoginValidation("admin1", "Driver8...?");
//		
//				if(user2 != null) {
//		System.out.println("You logged in and username is: " + user2.getFirstname());
//				}
//				else {
//					System.out.println("Wrong username or password!");
//				}

	}

}
