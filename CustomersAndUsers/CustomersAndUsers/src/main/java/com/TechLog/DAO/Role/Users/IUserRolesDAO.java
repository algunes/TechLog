package com.TechLog.DAO.Role.Users;

import java.util.List;

import com.TechLog.Entity.Users.UserRoles;

public interface IUserRolesDAO {
	
	UserRoles create(UserRoles ur);
	UserRoles read(Long id);
	UserRoles fullRead(Long id);
	List<UserRoles> readAll();
	UserRoles update(UserRoles ur);
	void delete(UserRoles ur);
	UserRoles validateName(String name);

}
