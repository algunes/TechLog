package com.TechLog.Services.UserImp;

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

import com.TechLog.Dao.UserImp.UserDaoImp;
import com.TechLog.Users.UserAuthenticationInfo;
import com.TechLog.Users.Users;

public class UserServiceImp {

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
		new UserDaoImp().updateUser(user);
		return getUser(user.getId(), true);
	}
	
	public Users userLoginValidation(String userName, String password) {
		Users result = null;
		UserAuthenticationInfo uai = new UserDaoImp().validateUserName(userName);
		
		if(uai != null) {
			result = (Arrays.equals(passwordHashing(uai.getSalt(), password), uai.getPassword()) ? uai.getUser(): null);
		}
		return result;
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
	
	public byte[] saltGenerator() {
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);	
		return salt;		
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
		uai.setSalt(salt);
		uai.setPassword(passwordHashing(salt, password));
		uai.setUserName(userName);
		
		return uai;
	}

}
