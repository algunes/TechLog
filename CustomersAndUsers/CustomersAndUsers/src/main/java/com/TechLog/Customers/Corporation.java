package com.TechLog.Customers;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.TechLog.Users.Users;

@Entity
@Table(name="corporation")
public class Corporation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="corporation_id")
	private Long id;

	@Column(name="corporation_name", unique=true, nullable=false)
	private String name;
	
	@Column(name="activity")
	private boolean activity;
	
	@OneToMany(mappedBy="corporation", cascade=CascadeType.ALL, orphanRemoval=true)
	@Column(name="customers", unique=true)
	private List<Customer> customers = new ArrayList<>();

	@Column(name="user_id")
	private Users createdBy = new Users();
	
	@Column(name="last_update")
	private Date lastUpdate;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
		customer.setCorporation(this);
	}
	
	public void removeCustomer(Customer customer) {
		customers.remove(customer);
		customer.setCorporation(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActivity() {
		return activity;
	}

	public void setActivity(boolean activity) {
		this.activity = activity;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
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
		result = prime * result + (activity ? 1231 : 1237);
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Corporation))
			return false;
		Corporation other = (Corporation) obj;
		if (activity != other.activity)
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
		if (customers == null) {
			if (other.customers != null)
				return false;
		} else if (!customers.equals(other.customers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Corporation [id=" + id + ", name=" + name + ", activity=" + activity + ", customers=" + customers
				+ ", createdBy=" + createdBy + ", lastUpdate=" + lastUpdate + ", creationDate=" + creationDate + "]";
	}
	
}
