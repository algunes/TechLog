package com.TechLog.Entity.Users;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.TechLog.Roles.Roles;

@Entity(name = "UserRoles")
@DiscriminatorValue("User_Roles")
public class UserRoles extends Roles {
	
	@OneToMany(mappedBy="user")
	@Column(name="role")
	private List<Users> users = new ArrayList<>();

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
