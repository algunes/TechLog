package com.TechLog.Entity.Corporations;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;

import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Entity.Users.Users;


@Entity
@Table(name="corporation")
@DynamicUpdate
public class Corporation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="corporation_id")
	private Long id;

	@Field
	@Column(name="corporation_name", nullable=false, unique=true)
	private String name;
	
	@Field
	@Column(name="sector")
	private String sector;
	
	@Column(name="isActive")
	private boolean isActive;
	
	@OneToMany(mappedBy="corporation", cascade=CascadeType.ALL, orphanRemoval=true)
	@Column(name="customers", unique=true)
	private List<Customer> customers = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="created_by", nullable = false)
	@ContainedIn
	private Users created_by;
	
	@ManyToOne
	@JoinColumn(name="updated_by")
	@ContainedIn
	private Users updated_by;
	
	@Column(name="last_update")
	private LocalDateTime last_update;
	
	@Column(name="creation_date")
	private LocalDateTime creation_date;
	
	
	
	public Corporation() {
		super();
	}

	public Corporation(String name, String sector, boolean isActive, List<Customer> customers, Users created_by) {
		super();
		this.name = name;
		this.sector = sector;
		this.isActive = isActive;
		this.customers = customers;
		this.created_by = created_by;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Users getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Users created_by) {
		this.created_by = created_by;
	}

	public Users getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Users updated_by) {
		this.updated_by = updated_by;
	}

	public LocalDateTime getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDateTime last_update) {
		this.last_update = last_update;
	}

	public LocalDateTime getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDateTime creation_date) {
		this.creation_date = creation_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result + ((creation_date == null) ? 0 : creation_date.hashCode());
		result = prime * result + ((customers == null) ? 0 : customers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((last_update == null) ? 0 : last_update.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sector == null) ? 0 : sector.hashCode());
		result = prime * result + ((updated_by == null) ? 0 : updated_by.hashCode());
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
		Corporation other = (Corporation) obj;
		if (created_by == null) {
			if (other.created_by != null)
				return false;
		} else if (!created_by.equals(other.created_by))
			return false;
		if (creation_date == null) {
			if (other.creation_date != null)
				return false;
		} else if (!creation_date.equals(other.creation_date))
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
		if (isActive != other.isActive)
			return false;
		if (last_update == null) {
			if (other.last_update != null)
				return false;
		} else if (!last_update.equals(other.last_update))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sector == null) {
			if (other.sector != null)
				return false;
		} else if (!sector.equals(other.sector))
			return false;
		if (updated_by == null) {
			if (other.updated_by != null)
				return false;
		} else if (!updated_by.equals(other.updated_by))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Corporation [id=" + id + ", name=" + name + ", sector=" + sector + ", isActive=" + isActive
				+ ", customers=" + customers + ", created_by=" + created_by + ", updated_by=" + updated_by
				+ ", last_update=" + last_update + ", creation_date=" + creation_date + "]";
	}

}
