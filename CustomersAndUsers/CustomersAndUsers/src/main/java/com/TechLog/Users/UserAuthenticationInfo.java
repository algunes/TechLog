package com.TechLog.Users;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Embeddable;

import org.hibernate.annotations.Parent;

@Embeddable
public class UserAuthenticationInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private byte[] password;
	private byte[] salt;
	
	@Parent
	private Users user;
	
	public UserAuthenticationInfo(String userName, byte[] password, byte[] salt) {
		super();
		this.userName = userName;
		this.password = password;
		this.salt = salt;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(password);
		result = prime * result + Arrays.hashCode(salt);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAuthenticationInfo other = (UserAuthenticationInfo) obj;
		if (!Arrays.equals(password, other.password))
			return false;
		if (!Arrays.equals(salt, other.salt))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
}
