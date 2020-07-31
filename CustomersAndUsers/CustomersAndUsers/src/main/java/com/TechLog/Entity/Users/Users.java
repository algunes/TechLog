package com.TechLog.Entity.Users;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import javax.persistence.*;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Entity.Customers.Customer;

@Entity
@Table(name="Users")
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="department")
	private String department;
	
	@Column(name="position")
	private String position;
	
	@ManyToOne
	@JoinColumn(name="role")
	private UserRoles role;
	
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
	private LocalDate lastLogin;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
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

	public UserRoles getRole() {
		return role;
	}

	public void setRole(UserRoles role) {
		this.role = role;
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

	public LocalDate getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDate lastLogin) {
		this.lastLogin = lastLogin;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
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

public Users(Long id, String firstname, String lastname, String department, String position, UserRoles role,
		List<Customer> created_customers, List<Customer> updated_customers, List<Corporation> created_corporations,
		List<Corporation> updated_corporations, String email, String telNumber, String address, BigDecimal totalSales,
		LocalDate lastLogin, LocalDate startDate, UserAuthenticationInfo userAuth) {
	super();
	this.id = id;
	this.firstname = firstname;
	this.lastname = lastname;
	this.department = department;
	this.position = position;
	this.role = role;
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

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((created_corporations == null) ? 0 : created_corporations.hashCode());
	result = prime * result + ((created_customers == null) ? 0 : created_customers.hashCode());
	result = prime * result + ((department == null) ? 0 : department.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((lastLogin == null) ? 0 : lastLogin.hashCode());
	result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
	result = prime * result + ((position == null) ? 0 : position.hashCode());
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
	result = prime * result + ((telNumber == null) ? 0 : telNumber.hashCode());
	result = prime * result + ((totalSales == null) ? 0 : totalSales.hashCode());
	result = prime * result + ((updated_corporations == null) ? 0 : updated_corporations.hashCode());
	result = prime * result + ((updated_customers == null) ? 0 : updated_customers.hashCode());
	result = prime * result + ((userAuth == null) ? 0 : userAuth.hashCode());
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
	Users other = (Users) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (created_corporations == null) {
		if (other.created_corporations != null)
			return false;
	} else if (!created_corporations.equals(other.created_corporations))
		return false;
	if (created_customers == null) {
		if (other.created_customers != null)
			return false;
	} else if (!created_customers.equals(other.created_customers))
		return false;
	if (department == null) {
		if (other.department != null)
			return false;
	} else if (!department.equals(other.department))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (firstname == null) {
		if (other.firstname != null)
			return false;
	} else if (!firstname.equals(other.firstname))
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	if (lastLogin == null) {
		if (other.lastLogin != null)
			return false;
	} else if (!lastLogin.equals(other.lastLogin))
		return false;
	if (lastname == null) {
		if (other.lastname != null)
			return false;
	} else if (!lastname.equals(other.lastname))
		return false;
	if (position == null) {
		if (other.position != null)
			return false;
	} else if (!position.equals(other.position))
		return false;
	if (role == null) {
		if (other.role != null)
			return false;
	} else if (!role.equals(other.role))
		return false;
	if (startDate == null) {
		if (other.startDate != null)
			return false;
	} else if (!startDate.equals(other.startDate))
		return false;
	if (telNumber == null) {
		if (other.telNumber != null)
			return false;
	} else if (!telNumber.equals(other.telNumber))
		return false;
	if (totalSales == null) {
		if (other.totalSales != null)
			return false;
	} else if (!totalSales.equals(other.totalSales))
		return false;
	if (updated_corporations == null) {
		if (other.updated_corporations != null)
			return false;
	} else if (!updated_corporations.equals(other.updated_corporations))
		return false;
	if (updated_customers == null) {
		if (other.updated_customers != null)
			return false;
	} else if (!updated_customers.equals(other.updated_customers))
		return false;
	if (userAuth == null) {
		if (other.userAuth != null)
			return false;
	} else if (!userAuth.equals(other.userAuth))
		return false;
	return true;
}

@Override
public String toString() {
	return "Users [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", department=" + department
			+ ", position=" + position + ", role=" + role + ", created_customers=" + created_customers
			+ ", updated_customers=" + updated_customers + ", created_corporations=" + created_corporations
			+ ", updated_corporations=" + updated_corporations + ", email=" + email + ", telNumber=" + telNumber
			+ ", address=" + address + ", totalSales=" + totalSales + ", lastLogin=" + lastLogin + ", startDate="
			+ startDate + ", userAuth=" + userAuth + "]";
}

}

