package com.TechLog.Test;

import java.time.LocalDate;

import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.UserAuthenticationInfo;
import com.TechLog.Users.UserBuilder;
import com.TechLog.Users.Users;

public class test2 {

	public static void main(String[] args) {
		
		
		
		Users user = new UserBuilder()
				.setUserAuthenticationInfo(new UserAuthenticationInfo("admin", "1234"))
				.build();
		
		user = new UserServiceImp().createUser(user);
		
		Users user = new UserServiceImp().validateUserName("admin");
		
		System.out.println("username is: " + user.getUserName());

	}

}
