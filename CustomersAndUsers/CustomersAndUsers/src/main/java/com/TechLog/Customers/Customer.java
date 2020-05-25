package com.TechLog.Customers;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.TechLog.Users.Users;

@Entity
@Table(name="customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customer_id;
	
	@Column(name="firstname", nullable = false)
	private String fname;
	
	@Column(name="lastname", nullable = false)
	private String lname;
	
	@ManyToOne
	@JoinColumn(name="corporation", nullable = false)
	private Corporation corporation;
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true)
	@Column(name="email")
	private List<Email> emails = new ArrayList<>();
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true)
	@Column(name="phone")
	private List<Phone> phones = new ArrayList<>();
	
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true)
	@Column(name="address")
	private List<Address> addresses = new ArrayList<>();
	
	@Column(name="user_id")
	private Users createdBy = new Users();
	
	@Column(name="last_update")
	private Date lastUpdate;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	public void addEmail(Email email) {
		emails.add(email);
		email.setCustomer(this);
	}
	
	public void addPhone(Phone phone) {
		phones.add(phone);
		phone.setCustomer(this);
	}
	
	public void addAddress(Address address) {
		addresses.add(address);
		address.setCustomer(this);
	}
	
	public void removeEmail(Email email) {
		emails.remove(email);
		email.setCustomer(null);
	}
	
	public void removePhone(Phone phone) {
		phones.remove(phone);
		phone.setCustomer(null);
	}
	
	public void removeAddress(Address address) {
		addresses.remove(address);
		address.setCustomer(null);
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Corporation getCorporation() {
		return corporation;
	}

	public void setCorporation(Corporation corporation) {
		this.corporation = corporation;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Users getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((corporation == null) ? 0 : corporation.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((phones == null) ? 0 : phones.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer other = (Customer) obj;
		if (addresses == null) {
			if (other.addresses != null)
				return false;
		} else if (!addresses.equals(other.addresses))
			return false;
		if (corporation == null) {
			if (other.corporation != null)
				return false;
		} else if (!corporation.equals(other.corporation))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (emails == null) {
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (phones == null) {
			if (other.phones != null)
				return false;
		} else if (!phones.equals(other.phones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", fname=" + fname + ", lname=" + lname + ", corporation="
				+ corporation + ", emails=" + emails + ", phones=" + phones + ", addresses=" + addresses
				+ ", createdBy=" + createdBy + ", lastUpdate=" + lastUpdate + ", creationDate=" + creationDate + "]";
	}
	
	
	
}

