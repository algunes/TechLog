package com.TechLog.Dao;

import java.util.List;

import com.TechLog.Users.UserAuthenticationInfo;
import com.TechLog.Users.Users;

public interface UsersDao {
	
	Users addUser(Users user); // Create
	Users fetchUser(Long id); // Fetching an user lazily
	Users fullFetchUser(Long id); // Fetching a user eagerly
	List<Users> fetchAllUsers(); // Fetch a list of all users (lazily)
	void updateUser(Users user); // Update
	void deleteUser(Users user); // Delete
	void addUserAuthInfo(UserAuthenticationInfo userAuthInf); // persist new user login data
	byte[] validateUserName(String userName); // validate username for login
	boolean validateUserPassword(String userName, byte[] password); // validate user password for login

}
