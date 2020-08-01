package com.TechLog.Entity.Users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.TechLog.Entity.Roles.Roles;

@Entity(name = "UserRoles")
@DiscriminatorValue("Customers")
public class UserRoles extends Roles {
	
	@OneToMany(mappedBy="role")
	@Column(name="users")
	private List<Users> users = new ArrayList<>();
	
	public UserRoles(String name, boolean create, boolean read, boolean update, boolean delete, List<Users> users) {
		super(name, create, read, update, delete);
		this.users = users;
	}
	
	public UserRoles() {
		super();
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	
	public void addUser(Users user) {
		this.users.add(user);
	}
	
}
