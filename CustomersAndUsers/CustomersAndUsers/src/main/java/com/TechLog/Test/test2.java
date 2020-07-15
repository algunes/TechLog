package com.TechLog.Test;

import java.time.LocalDate;

import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.UserAuthenticationInfo;
import com.TechLog.Users.Users;

public class test2 {

	public static void main(String[] args) {
		
		UserServiceImp us = new UserServiceImp();
		
		
		
		Users user = new Users();
		user.setFirstname("Aliyar2");
		user.setLastname("Güneş2");
		user.setEmail("aliyargunes2@gmail.com");
		user.setStartDate(LocalDate.now());
		
		UserAuthenticationInfo uai = us.addUserAuthInfo("admin", "Driver8...?");
		uai.setUser(user);
		user.setUserAuth(uai);
		
		
		
		Users user2 = us.createUser(user);
		
		if (user2 != null) {
			System.out.println("user created");
		}
		else {
			System.out.println("user not created");
		}
		
		
		
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
