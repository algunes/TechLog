package com.TechLog.Services;

import java.util.List;

import com.TechLog.Users.UserAuthenticationInfo;
import com.TechLog.Users.Users;

public interface UserService {
	
	Users createUser(Users user); // Create
	Users removeUser(Long UserId); // Remove
	Users getUser(Long id, boolean isFull); // fetch an user
	List<Users> getAllUsersList();
	Users updateUser(Users user); // update an user
	UserAuthenticationInfo addUserAuthInfo(String userName, String password); // add new user login data
	byte[] validateUserName(String userName); // validate an username for login
	boolean validateUserPassword(String userName, byte[] password); // validate a password for login
	boolean userLoginValidation(String userName, String password); // user login validation
	byte[] passwordHashing(byte[] salt, String password); // hash a password for validation or persistence
	byte[] saltGenerator(); // a random salt generator for hashing the password

}
