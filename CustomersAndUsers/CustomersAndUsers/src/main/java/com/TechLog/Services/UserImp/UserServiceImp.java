package com.TechLog.Services.UserImp;

import java.time.LocalDate;

import com.TechLog.Customers.Customer;
import com.TechLog.Dao.CustomerImp.CustomerDaoImp;
import com.TechLog.Dao.UserImp.UserDaoImp;
import com.TechLog.Services.UserService;
import com.TechLog.Users.Users;

public class UserServiceImp implements UserService {

	@Override
	public Users createUser(String firstname, String lastname, Long corporationId, String department,
			String position, String role, String email, String telNumber, String address, LocalDate startdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users removeUser(Long UserId) {
		Users user = getUser(UserId, false);
		new UserDaoImp().deleteUser(user);
		return user;
	}

	@Override
	public Users getUser(Long id, boolean isFull) {
		if (isFull)
			return new UserDaoImp().fullFetchUser(id);
		else
			return new UserDaoImp().fetchUser(id);
	}

	@Override
	public Users updateUser(Users user) {
		new UserDaoImp().updateUser(user);
		return getUser(user.getUserId(), true);
	}

}
