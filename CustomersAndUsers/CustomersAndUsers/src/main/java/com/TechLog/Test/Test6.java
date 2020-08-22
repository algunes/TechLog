package com.TechLog.Test;

import java.util.*;

public class Test6 {
	
public static void main(String[] args) {
	
		Privilege cd = new CustomerDomain();
		cd.setRead(true);
		cd.setWrite(true);
		
		Privilege pd = new ProductDomain();
		pd.setRead(false);
		pd.setWrite(true);
		
		Users user = new UserBuilder()
				.setFirstname("Aliyar")
				.setLastname("Gunes")
				.build();
				
		UserService us = new UserService();
		us.addPrivilege(pd, user);

				
		System.out.println("User Name: " + user.getFirstname() + " " + user.getLastname());
		System.out.println("Privilege name: ");
		
		System.out.println("Check User Write Privilege: " + new UserService().checkUserWritePrivilege(new CustomerDomain(), user));

	}

}

class Privilege {
	
	private boolean read = false;
	private boolean write = false;
	
	Privilege() {
	
	}
	
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isWrite() {
		return write;
	}
	public void setWrite(boolean write) {
		this.write = write;
	}
	
	
	
}

class CustomerDomain extends Privilege {
	
	public CustomerDomain() {
		super();
	}


	
}

class ProductDomain extends Privilege {

	public ProductDomain() {
		super();
		
	}	
}

class StockDomain extends Privilege {

	public StockDomain() {
		super();
		
	}	
}

class Users {
	
	private String firstname;
	private String lastname;
	private List<Privilege> roles = new ArrayList<>();
	
	public Users() {
		super();
	}
	
	public Users(String firstname, String lastname, List<Privilege> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.roles = roles;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Privilege> getRoles() {
		return roles;
	}

	public void setRoles(List<Privilege> roles) {
		this.roles = roles;
	}
	
}

class UserBuilder {
	
	String firstname;
	String lastname;
	List<Privilege> privileges = new ArrayList<>();
	
	public UserBuilder setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public UserBuilder setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public UserBuilder setPrivileges(List<Privilege> p) {
		this.privileges = p;
		return this;
	}
	
	public Users build() {
		return new Users(firstname, lastname, privileges);
	}
	
}

class UserService {
	
	
	public boolean checkUserWritePrivilege(Privilege privilege, Users user) {
		return user.getRoles().contains(privilege);
	}
	

	
	// ...
	
	public void addPrivilege(Privilege privilege, Users user) {
		user.getRoles().add(privilege);
	}
	

		
}
