package com.TechLog.Test.Permissions;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	Long user_id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@OneToOne(cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@JoinColumn(name = "_domainPermission_id", referencedColumnName = "domainPermissions_id")
	private DomainPermissions domainPermissions;
	
	public Users() {
		super();
	}
	
	public Users(String firstname, String lastname, DomainPermissions d) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.domainPermissions = d;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public DomainPermissions getDomainPermissions() {
		return domainPermissions;
	}

	public void setDomainPermissions(DomainPermissions domainPermissions) {
		this.domainPermissions = domainPermissions;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}
