package com.TechLog.Services.Users;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.TechLog.DAO.Users.UserDao;
import com.TechLog.Entity.Users.UserAuthenticationInfo;
import com.TechLog.Entity.Users.Users;

public class UserService {

	public Users createUser(Users user) {
		user.setStartDate(LocalDateTime.now());
		return new UserDao().addUser(user);
	}

	public Users removeUser(Long UserId) {
		Users user = getUser(UserId, false);
		new UserDao().deleteUser(user);
		return user;
	}

	public Users getUser(Long id, boolean isFull) {
		if (isFull)
			return new UserDao().fullFetchUser(id);
		else
			return new UserDao().fetchUser(id);
	}
	
	public List<Users> getAllUsersList() {
		return new UserDao().fetchAllUsers();
	}

	public Users updateUser(Users user) {
		return new UserDao().updateUser(user);
	}
	
	public Users updateFirstname(Long  id, String firstname) {
		Users user = getUser(id, false);
		user.setFirstname(firstname);
		return updateUser(user);	
	}
	
	public Users updateLastname(Long  id, String lastname) {
		Users user = getUser(id, false);
		user.setLastname(lastname);
		return updateUser(user);	
	}
	
	public Users updateDepartment(Long  id, String department) {
		Users user = getUser(id, false);
		user.setDepartment(department);
		return updateUser(user);	
	}
	
	public Users updatePosition(Long  id, String position) {
		Users user = getUser(id, false);
		user.setPosition(position);
		return updateUser(user);	
	}
	
	public Users updateEmail(Long  id, String email) {
		Users user = getUser(id, false);
		user.setEmail(email);
		return updateUser(user);	
	}
	
	public Users updateTelNumber(Long  id, String telNumber) {
		Users user = getUser(id, false);
		user.setTelNumber(telNumber);
		return updateUser(user);	
	}
	
	public Users updateAddress(Long  id, String address) {
		Users user = getUser(id, false);
		user.setAddress(address);
		return updateUser(user);	
	}
	
	public Users updatePassword(Long id, String oldPassword, String newPassword) {
		
		Users user = userLoginValidation(byteToUsername(getUser(id, true).getUserAuth().getUserName()), oldPassword);
		if(user != null) {
			user.getUserAuth().setPassword(passwordHashing(user.getUserAuth().getSalt(), newPassword));
			user = updateUser(user);
		}
		return user;
	}
	
	public Users userLoginValidation(String userName, String password) {
		Users user = null;
		byte[] uname = usernameToByte(userName);
		UserAuthenticationInfo uai = new UserDao().validateUserName(uname);
		
		if(uai != null && Arrays.equals(passwordHashing(uai.getSalt(), password), uai.getPassword()) == true) {
			user = uai.getUser();
			user.setLastLogin(LocalDateTime.now());
			updateUser(user);
		}
		return user;
	}
	
	public byte[] passwordHashing(byte[] salt, String password) {
		
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		
		SecretKeyFactory factory = null;
		byte[] hash = null;
		
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		try {
			hash = factory.generateSecret(spec).getEncoded();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return hash;	
	}
	
	public byte[] usernameToByte(String username) {
		return username.getBytes();
	}
	
	public String byteToUsername(byte[] username) {
		return new String(username);
	}
	
	public byte[] saltGenerator() {
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);	
		return salt;		
	}
	
	public Users updateUsername(Long id, String username) {
		if(isUsernameUnique(username)) {
			byte[] uname = usernameToByte(username);
			Users user = getUser(id, true);
			user.getUserAuth().setUserName(uname);
			return updateUser(user);
		}
		else {
			return null;
		}
	}
	
public UserAuthenticationInfo userAuthInfoBuild(String userName, String password) {
	
	if(isUsernameUnique(userName)) {
		UserAuthenticationInfo uai = new UserAuthenticationInfo();
		byte[] salt = saltGenerator();
		byte[] uname = usernameToByte(userName);
		uai.setSalt(salt);
		uai.setPassword(passwordHashing(salt, password));
		uai.setUserName(uname);
		
		return uai;
	}
	else {
		return null;
	}
}

public Boolean isUsernameUnique(String username) {
	return new UserDao().validateUserName(usernameToByte(username)) == null ?
			true : false;
	}

public List<Users> getLastLoginUsers() {
	return new UserDao().lastLoginUsers();
}
}
