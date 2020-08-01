package com.TechLog.Services.User.Roles;

import com.TechLog.Entity.Users.UserRoleBuilder;
import com.TechLog.Entity.Users.UserRoles;

public class UserRolesPreService implements IUserRolesPreService {

	@Override
	public UserRoles createUserRole(
			String name, 
			boolean create, 
			boolean read, 
			boolean update, 
			boolean delete) {
		
		return new UserRoleBuilder()
				.setName(name)
				.setCreate(create)
				.setRead(read)
				.setUpdate(update)
				.setDelete(delete)
				.build();
	}

	@Override
	public UserRoles updateUserRoleName(
			Long id, 
			String oldName, 
			String newName) {
		
		UserRolesPostService urps = new UserRolesPostService();
		UserRoles ur = urps.readUserRole(id, false);
		
		if(ur != null && 
			urps.validateUserRoleName(newName) == null && 
			ur.getName().equals(oldName)) {
			ur.setName(newName);
			return urps.updateUserRole(ur);
		}
		else {
			return null;
		}
	}

	@Override
	public UserRoles updateUserRolePowers(
			Long id, 
			boolean create, 
			boolean read, 
			boolean update, 
			boolean delete) {
		
		UserRolesPostService urps = new UserRolesPostService();
		UserRoles ur = urps.readUserRole(id, false);
		ur.setCreate(create);
		ur.setRead(read);
		ur.setUpdate(update);
		ur.setDelete(delete);
		
		return urps.updateUserRole(ur);
	}

}
