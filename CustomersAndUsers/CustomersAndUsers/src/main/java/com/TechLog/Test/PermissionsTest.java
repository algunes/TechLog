package com.TechLog.Test;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.TechLog.Hibernate.HibernateUtil;

public class PermissionsTest {
	
public static void main(String[] args) {
	
		Permission cd = new CustomerDomainPermission();
		cd.setRead(true);
		cd.setCreate(true);
		
		Permission pd = new ProductDomainPermission();
		pd.setRead(false);
		pd.setCreate(true);
		
		User user = new UsersBuilder()
				.setFirstname("Aliyar")
				.setLastname("Gunes")
				.build();
				
		UserPermissionService us = new UserPermissionService();
		us.grantPermission(pd, user);
		us.grantPermission(cd, user);
		
		new UserDao().addUser(user);

				
		System.out.println("User Name: " + user.getFirstname() + " " + user.getLastname());
		System.out.println("App Domain Permission(s): ");
		
		for(String name : user.getRoles().keySet()) {
			System.out.println("--> " + name);		
			}
		
		System.out.println("Customer Domain Write Permission: " + new UserPermissionService().createPermissionProvider(new CustomerDomainPermission(), user));

	}

}

@MappedSuperclass
abstract class Permission {
	
	private boolean create;
	private boolean read;
	private boolean update;
	private boolean delete;
	
	public boolean isCreate() {
		return create;
	}
	public void setCreate(boolean create) {
		this.create = create;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isUpdate() {
		return update;
	}
	public void setUpdate(boolean update) {
		this.update = update;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	
	
	
}

@Entity
class CustomerDomainPermission extends Permission {
	
	public CustomerDomainPermission() {
		super();
	}

}

@Entity
class ProductDomainPermission extends Permission {

	public ProductDomainPermission() {
		super();
		
	}	
}

@Entity
class StockDomainPermission extends Permission {

	public StockDomainPermission() {
		super();
		
	}	
}

@Entity
class User {
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@ElementCollection
	@Column(name="permissions")
	private Map<String, Permission> roles = new HashMap<>();
	
	public User() {
		super();
	}
	
	public User(String firstname, String lastname, Map<String, Permission> roles) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.roles = roles;
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
	public Map<String, Permission> getRoles() {
		return roles;
	}
	public void setRoles(Map<String, Permission> roles) {
		this.roles = roles;
	}
	
}

class UsersBuilder {
	
	String firstname;
	String lastname;
	Map<String, Permission> Permissions = new HashMap<>();
	
	public UsersBuilder setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public UsersBuilder setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}
	
	public UsersBuilder setPermissions(Map<String, Permission> p) {
		this.Permissions = p;
		return this;
	}
	
	public User build() {
		return new User(firstname, lastname, Permissions);
	}
	
}

class UserPermissionService {
	
	
	public boolean createPermissionProvider(Permission p, User u) {
		return u.getRoles().get(p.getClass().getSimpleName()) != null
				? checkUserWritePermission(p, u)
				: false;
	}
	
	public boolean readPermissionProvider(Permission p, User u) {
		return u.getRoles().get(p.getClass().getSimpleName()) != null
				? checkUserReadPermission(p, u)
				: false;
	}
	
	public boolean updatePermissionProvider(Permission p, User u) {
		return u.getRoles().get(p.getClass().getSimpleName()) != null
				? checkUserUpdatePermission(p, u)
				: false;
	}
	
	public boolean deletePermissionProvider(Permission p, User u) {
		return u.getRoles().get(p.getClass().getSimpleName()) != null
				? checkUserDeletePermission(p, u)
				: false;
	}
	
	public boolean checkUserWritePermission(Permission p, User user) {
		return user.getRoles().get(p.getClass().getSimpleName()).isCreate();
	}
	
	public boolean checkUserReadPermission(Permission p, User user) {
		return user.getRoles().get(p.getClass().getSimpleName()).isRead();
	}
	
	public boolean checkUserUpdatePermission(Permission p, User user) {
		return user.getRoles().get(p.getClass().getSimpleName()).isUpdate();
	}
	
	public boolean checkUserDeletePermission(Permission p, User user) {
		return user.getRoles().get(p.getClass().getSimpleName()).isDelete();
	}
	
	// ...
	
	public boolean grantPermission(Permission p, User user) {
		return user.getRoles().put(p.getClass().getSimpleName(), p) != null
				? true : false;
	}
	
	public boolean removePermission(Permission p, User user) {
		return user.getRoles().remove(p.getClass().getSimpleName(), p);
	}
	
	public Permission findPermission(Permission p, User user) {
		return user.getRoles().get(p.getClass().getSimpleName());
	}
		
}

class UserDao {
	
public void addUser(User user) {
			
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();		
			session.save(user);
			session.getTransaction().commit();			
		}
		catch (HibernateException e) {
			if(session.getTransaction() != null)
				session.beginTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null)
			session.close();
		}
}
	
}
