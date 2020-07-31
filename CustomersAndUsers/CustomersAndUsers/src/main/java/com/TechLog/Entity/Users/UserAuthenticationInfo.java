package com.TechLog.Entity.Users;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.*;



@Entity
@Table(name="UserAuthenticationInfo")
public class UserAuthenticationInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
	private Long id;
	
	@Column(name="userName")
	private byte[] userName;
	
	@Column(name="password")
	private byte[] password;
	
	@Column(name="salt")
	private byte[] salt;
	
	@OneToOne
    @MapsId
    private Users user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getUserName() {
		return userName;
	}

	public void setUserName(byte[] userName) {
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
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
