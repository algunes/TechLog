package com.TechLog.Entity.Users;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.TechLog.Entity.Permissions.DomainPermissions;
import com.TechLog.Services.Users.UserService;

public class UserBuilder {
	
	private String firstname; 
	private String lastname;
	private String department;
	private String position; 
	private DomainPermissions dp; 
	private String email; 
	private String telNumber;
	private String address; 
	private BigDecimal totalSales; 
	private String userName; 
	private String password;
	
	public UserBuilder setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public UserBuilder setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public UserBuilder setDepartment(String department) {
		this.department = department;
		return this;
	}
	
	public UserBuilder setPosition(String position) {
		this.position = position;
		return this;
	}
	
	public UserBuilder setDomainPermissions(DomainPermissions dp) {
		this.dp = dp;
		return this;
	}
	
	public UserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}
	
	public UserBuilder setTelNum(String telNum) {
		this.telNumber = telNum;
		return this;
	}

	public UserBuilder setAddress(String address) {
		this.address = address;
		return this;
	}
	
	public UserBuilder setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
		return this;
	}
	
	public UserBuilder setUserName(String username) {
		this.userName = username;
		return this;
	}
	
	public UserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}
	
	public Users build() {
		Users user = new Users();
		UserService us = new UserService();
		UserAuthenticationInfo uai = us.userAuthInfoBuild(userName, password);
		
		if(uai == null) {
			return null;
		}
		else {
			uai.setUser(user);
			user.setUserAuth(uai);

			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setDepartment(department);
			user.setPosition(position);
			user.setDomainPermissions(dp);
			user.setEmail(email);
			user.setTelNumber(telNumber);
			user.setAddress(address);
			user.setTotalSales(totalSales);
			user.setStartDate(LocalDate.now());
			
			return us.createUser(user);
		}
	}
}
