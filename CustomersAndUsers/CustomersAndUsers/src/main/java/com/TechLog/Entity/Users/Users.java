package com.TechLog.Entity.Users;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import javax.persistence.*;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Entity.Permissions.DomainPermissions;

@Entity
@Table(name="Users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userId")
	private Long id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="department")
	private String department;
	
	@Column(name="position")
	private String position;
	
	@OneToOne(cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@JoinColumn(name = "_domainPermission_id", referencedColumnName = "domainPermissions_id")
	private DomainPermissions domainPermissions;
	
	@Column(name="created_customers")
	@OneToMany(mappedBy="created_by", orphanRemoval=false)
	private List<Customer> created_customers = new ArrayList<>();
	
	@Column(name="updated_customers")
	@OneToMany(mappedBy="updated_by", orphanRemoval=false)
	private List<Customer> updated_customers = new ArrayList<>();
	
	@Column(name="created_corporations")
	@OneToMany(mappedBy="created_by", orphanRemoval=false)
	private List<Corporation> created_corporations = new ArrayList<>();
	
	@Column(name="updated_corporations")
	@OneToMany(mappedBy="updated_by", orphanRemoval=false)
	private List<Corporation> updated_corporations = new ArrayList<>();
	
	@Column(name="email")
	private String email;
	
	@Column(name="tel_number")
	private String telNumber;
	
	@Column(name="address")
	private String address;
	
	@Column(name="total_sales")
	private BigDecimal totalSales;
	
	@Column(name="last_login")
	private LocalDateTime lastLogin;
	
	@Column(name="start_date")
	private LocalDateTime startDate;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserAuthenticationInfo userAuth;
	
	public Long getId() {
		return id;
	}

	public void setId(Long userId) {
		this.id = userId;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public DomainPermissions getDomainPermissions() {
		return domainPermissions;
	}

	public void setDomainPermissions(DomainPermissions domainPermissions) {
		this.domainPermissions = domainPermissions;
	}

	public List<Customer> getCreated_customers() {
		return created_customers;
	}

	public void setCreated_customers(List<Customer> created_customers) {
		this.created_customers = created_customers;
	}

	public List<Customer> getUpdated_customers() {
		return updated_customers;
	}

	public void setUpdated_customers(List<Customer> updated_customers) {
		this.updated_customers = updated_customers;
	}

	public List<Corporation> getCreated_corporations() {
		return created_corporations;
	}

	public void setCreated_corporations(List<Corporation> created_corporations) {
		this.created_corporations = created_corporations;
	}

	public List<Corporation> getUpdated_corporations() {
		return updated_corporations;
	}

	public void setUpdated_corporations(List<Corporation> updated_corporations) {
		this.updated_corporations = updated_corporations;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(BigDecimal totalSales) {
		this.totalSales = totalSales;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	
	public UserAuthenticationInfo getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(UserAuthenticationInfo userAuth) {
		this.userAuth = userAuth;
	}

	public Users() {
		super();
	}

public Users(Long id, String firstname, String lastname, String department, String position, DomainPermissions domainPermissions,
		List<Customer> created_customers, List<Customer> updated_customers, List<Corporation> created_corporations,
		List<Corporation> updated_corporations, String email, String telNumber, String address, BigDecimal totalSales,
		LocalDateTime lastLogin, LocalDateTime startDate, UserAuthenticationInfo userAuth) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.department = department;
	this.position = position;
	this.domainPermissions = domainPermissions;
	this.created_customers = created_customers;
	this.updated_customers = updated_customers;
	this.created_corporations = created_corporations;
	this.updated_corporations = updated_corporations;
	this.email = email;
	this.telNumber = telNumber;
	this.address = address;
	this.totalSales = totalSales;
	this.lastLogin = lastLogin;
	this.startDate = startDate;
	this.userAuth = userAuth;
}



}

