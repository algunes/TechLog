package com.TechLog.Services.User.Roles;

import com.TechLog.Entity.Users.UserRoles;

public interface IUserRolesPreService {

	UserRoles createUserRole(String name, 
			boolean create, 
			boolean read, 
			boolean update, 
			boolean delete);
	UserRoles updateUserRoleName(Long id, 
			String oldName, 
			String newName);
	UserRoles updateUserRolePowers(Long id, 
			boolean create, 
			boolean read,
			boolean update, 
			boolean delete);
}
