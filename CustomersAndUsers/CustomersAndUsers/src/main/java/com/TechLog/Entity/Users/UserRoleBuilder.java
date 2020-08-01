package com.TechLog.Entity.Users;

import java.util.ArrayList;
import java.util.List;

public class UserRoleBuilder {
	
	private String name;
	private boolean create;
	private boolean read;
	private boolean update;
	private boolean delete;
	private List<Users> users = new ArrayList<>();
	
	public UserRoleBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserRoleBuilder setCreate(boolean create) {
		this.create = create;
		return this;
	}
	
	public UserRoleBuilder setRead(boolean read) {
		this.read = read;
		return this;
	}
	
	public UserRoleBuilder setUpdate(boolean update) {
		this.update = update;
		return this;
	}
	
	public UserRoleBuilder setDelete(boolean delete) {
		this.delete = delete;
		return this;
	}
	
	public UserRoleBuilder addUser(Users user) {
		this.users.add(user);
		return this;
	}
	
	public UserRoles build() {
		return new UserRoles(name, create, read, update, delete, users);
	}
	
	
}
