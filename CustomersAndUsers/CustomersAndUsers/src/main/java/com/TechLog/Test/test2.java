package com.TechLog.Test;

import java.time.LocalDate;
import java.util.Arrays;

import com.TechLog.Model.Users.UserAuthenticationInfo;
import com.TechLog.Model.Users.Users;
import com.TechLog.Services.UserImp.UserServiceImp;

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
		
		UserServiceImp us = new UserServiceImp();
		
		
		
		Users user = new Users();
		user.setFirstname("Aliyar2");
		user.setLastname("Güneş2");
		user.setEmail("aliyargunes2@gmail.com");
		user.setRole("Admin");
		user.setStartDate(LocalDate.now());
		
		UserAuthenticationInfo uai = us.userAuthInfoBuild("admin", "Driver8...?");
		uai.setUser(user);
		user.setUserAuth(uai);
		
		
		
		Users user2 = us.createUser(user);
		
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
