package com.TechLog.Services.UserPermissions;

import com.TechLog.DAO.Users.UserDao;
import com.TechLog.Entity.Users.Users;

public class UserPermissionsService implements IUserPermissionsService {

	@Override
	public void updateCustomerDomainPermission(Users user, Boolean c, Boolean r, Boolean u, Boolean d) {
		user.getDomainPermissions().getCustomerDomain().set_create(c);
		user.getDomainPermissions().getCustomerDomain().set_read(r);
		user.getDomainPermissions().getCustomerDomain().set_update(u);
		user.getDomainPermissions().getCustomerDomain().set_delete(d);
		new UserDao().updateUser(user);
	}

	@Override
	public void updateProductDomainPermission(Users user, Boolean c, Boolean r, Boolean u, Boolean d) {
		user.getDomainPermissions().getProductDomain().set_create(c);
		user.getDomainPermissions().getProductDomain().set_read(r);
		user.getDomainPermissions().getProductDomain().set_update(u);
		user.getDomainPermissions().getProductDomain().set_delete(d);
		new UserDao().updateUser(user);
	}

	@Override
	public void updateStockDomainPermission(Users user, Boolean c, Boolean r, Boolean u, Boolean d) {
		user.getDomainPermissions().getStockDomain().set_create(c);
		user.getDomainPermissions().getStockDomain().set_read(r);
		user.getDomainPermissions().getStockDomain().set_update(u);
		user.getDomainPermissions().getStockDomain().set_delete(d);
		new UserDao().updateUser(user);
	}

	@Override
	public void updateUserDomainPermission(Users user, Boolean c, Boolean r, Boolean u, Boolean d) {
		user.getDomainPermissions().getUserDomain().set_create(c);
		user.getDomainPermissions().getUserDomain().set_read(r);
		user.getDomainPermissions().getUserDomain().set_update(u);
		user.getDomainPermissions().getUserDomain().set_delete(d);
		new UserDao().updateUser(user);
		
	}

}
