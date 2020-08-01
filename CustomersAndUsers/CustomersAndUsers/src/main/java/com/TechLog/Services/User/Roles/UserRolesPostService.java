package com.TechLog.Services.User.Roles;

import java.util.List;

import com.TechLog.DAO.Role.Users.UserRolesDAO;
import com.TechLog.Entity.Users.UserRoles;

public class UserRolesPostService implements IUserPostService {

	@Override
	public UserRoles createUserRole(UserRoles ur) {
		return new UserRolesDAO().create(ur);
	}

	@Override
	public UserRoles readUserRole(Long id, boolean isFull) {
		if (isFull)
			return new UserRolesDAO().fullRead(id);
			else
				return new UserRolesDAO().read(id);
	}

	@Override
	public List<UserRoles> readAllUserRoles() {
		return new UserRolesDAO().readAll();
	}

	@Override
	public UserRoles updateUserRole(UserRoles ur) {
		return new UserRolesDAO().update(ur);
	}

	@Override
	public void deleteUserRole(UserRoles ur) {
		new UserRolesDAO().delete(ur);
	}

	@Override
	public UserRoles validateUserRoleName(String name) {
		return new UserRolesDAO().validateName(name);
	}

}
