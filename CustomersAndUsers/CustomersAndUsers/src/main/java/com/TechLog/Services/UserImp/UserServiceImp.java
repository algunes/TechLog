package com.TechLog.Services.UserImp;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.TechLog.Dao.UserImp.UserDaoImp;
import com.TechLog.Services.UserService;
import com.TechLog.Users.UserAuthenticationInfo;
import com.TechLog.Users.Users;

public class UserServiceImp implements UserService {

	@Override
	public Users createUser(Users user) {
		return new UserDaoImp().addUser(user);
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
	public List<Users> getAllUsersList() {
		return new UserDaoImp().fetchAllUsers();
	}

	@Override
	public Users updateUser(Users user) {
		new UserDaoImp().updateUser(user);
		return getUser(user.getUserId(), true);
	}
	
	@Override
	public byte[] validateUserName(String userName) {
		return new UserDaoImp().validateUserName(userName);
	}
	
	@Override
	public boolean validateUserPassword(String userName, byte[] password) {
		return new UserDaoImp().validateUserPassword(userName, password);
		
	}
	
	@Override
	public UserAuthenticationInfo addUserAuthInfo(String userName, String password) {
		
		UserAuthenticationInfo uai = new UserAuthenticationInfo();
		byte[] salt = saltGenerator();
		uai.setSalt(salt);
		uai.setPassword(passwordHashing(salt, password));
		uai.setUserName(userName);
		
		new UserDaoImp().addUserAuthInfo(uai);
		return uai;
	}
	
	@Override
	public boolean userLoginValidation(String userName, String password) {
		boolean result = false;
		byte[] salt = validateUserName(userName);
		
		if(salt != null) {
			result = validateUserPassword(userName, passwordHashing(salt, password));
		}
		return result;
	}
	
	@Override
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
	
	@Override
	public byte[] saltGenerator() {
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);	
		return salt;		
	}
	

}
