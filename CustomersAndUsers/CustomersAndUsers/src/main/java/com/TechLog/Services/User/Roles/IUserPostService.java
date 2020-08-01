package com.TechLog.Services.User.Roles;

import java.util.List;

import com.TechLog.Entity.Users.UserRoles;

public interface IUserPostService {
	
	UserRoles createUserRole(UserRoles ur);
	UserRoles readUserRole(Long id, boolean isFull);
	List<UserRoles> readAllUserRoles();
	UserRoles updateUserRole(UserRoles ur);
	void deleteUserRole(UserRoles ur);
	UserRoles validateUserRoleName(String name);

}
