package com.TechLog.Services.User;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.TechLog.DAO.Users.UserDaoImp;
import com.TechLog.Entity.Users.UserAuthenticationInfo;
import com.TechLog.Entity.Users.Users;

public class UserService {

	public Users createUser(Users user) {
		return new UserDaoImp().addUser(user);
	}

	public Users removeUser(Long UserId) {
		Users user = getUser(UserId, false);
		new UserDaoImp().deleteUser(user);
		return user;
	}

	public Users getUser(Long id, boolean isFull) {
		if (isFull)
			return new UserDaoImp().fullFetchUser(id);
		else
			return new UserDaoImp().fetchUser(id);
	}
	
	public List<Users> getAllUsersList() {
		return new UserDaoImp().fetchAllUsers();
	}

	public Users updateUser(Users user) {
		return new UserDaoImp().updateUser(user);
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
	
	public Users updateRole(Long  id, String role) {
		Users user = getUser(id, false);
		user.setRole(role);
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
		UserAuthenticationInfo uai = new UserDaoImp().validateUserName(uname);
		
		if(uai != null && Arrays.equals(passwordHashing(uai.getSalt(), password), uai.getPassword()) == true) {
			user = uai.getUser();
			user.setLastLogin(LocalDate.now());
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
		byte[] uname = usernameToByte(username);
		Users user = getUser(id, true);
		user.getUserAuth().setUserName(uname);
		return updateUser(user);
	}
	
	public Users userBuild(String firstname, String lastname, String department,
			String position, String role, String email, String telNumber,
			String address, BigDecimal totalSales, String userName, String password) {
		
		Users user = new Users();
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setDepartment(department);
		user.setPosition(position);
		user.setRole(role);
		user.setEmail(email);
		user.setTelNumber(telNumber);
		user.setAddress(address);
		user.setTotalSales(totalSales);
		user.setStartDate(LocalDate.now());
		
		UserAuthenticationInfo uai = userAuthInfoBuild(userName, password);
		uai.setUser(user);
		user.setUserAuth(uai);
		
		return createUser(user);
		
	}
	
public UserAuthenticationInfo userAuthInfoBuild(String userName, String password) {
		
		UserAuthenticationInfo uai = new UserAuthenticationInfo();
		byte[] salt = saltGenerator();
		byte[] uname = usernameToByte(userName);
		uai.setSalt(salt);
		uai.setPassword(passwordHashing(salt, password));
		uai.setUserName(uname);
		
		return uai;
	}

}
