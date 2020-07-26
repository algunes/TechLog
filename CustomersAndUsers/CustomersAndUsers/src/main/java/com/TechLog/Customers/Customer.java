package com.TechLog.Customers;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

import com.TechLog.Corporations.Corporation;
import com.TechLog.Users.Users;


@Entity
@Indexed
@Table(name="customer")
@DynamicUpdate
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customer_id;
	
	@Column(name="firstname", nullable = false)
	@Field
	private String firstname;
	
	@Column(name="lastname", nullable = false)
	@Field
	private String lastname;
	
	@ManyToOne
	@JoinColumn(name="corporation", nullable = false)
	@ContainedIn
	@IndexedEmbedded
	private Corporation corporation;
	
	@Column(name="department")
	private String department;
	
	@Column(name="position")
	private String position;
	
	@ElementCollection
	@IndexedEmbedded
	@Field
	@Column(name="emails")
	private List<String> emails = new ArrayList<>();
	
	@ElementCollection
	@IndexedEmbedded
	@Field
	@Column(name="telNums")
	private List<String> telNums = new ArrayList<>();
	
	@ElementCollection
	@IndexedEmbedded
	@Field
	@Column(name="addresses")
	private List<String> addresses = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="created_by", nullable = false)
	@ContainedIn
	private Users created_by;
	
	@ManyToOne
	@JoinColumn(name="updated_by")
	@ContainedIn
	private Users updated_by;
	
	@Column(name="last_update")
	private LocalDate last_update;
	
	@Column(name="creation_date")
	private LocalDate creation_date;
	
	public Customer() {
		super();
	}

	public Customer(String firstname, String lastname, Corporation corporation, String department,
			String position, List<String> emails, List<String> telNums, List<String> addresses, Users created_by,
			Users updated_by, LocalDate last_update, LocalDate creation_date) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.corporation = corporation;
		this.department = department;
		this.position = position;
		this.emails = emails;
		this.telNums = telNums;
		this.addresses = addresses;
		this.created_by = created_by;
		this.updated_by = updated_by;
		this.last_update = last_update;
		this.creation_date = creation_date;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
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

	public Corporation getCorporation() {
		return corporation;
	}

	public void setCorporation(Corporation corporation) {
		this.corporation = corporation;
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

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<String> getTelNums() {
		return telNums;
	}

	public void setTelNums(List<String> telNums) {
		this.telNums = telNums;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
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

	public LocalDate getLast_update() {
		return last_update;
	}

	public void setLast_update(LocalDate last_update) {
		this.last_update = last_update;
	}

	public LocalDate getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
		result = prime * result + ((corporation == null) ? 0 : corporation.hashCode());
		result = prime * result + ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result + ((creation_date == null) ? 0 : creation_date.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((last_update == null) ? 0 : last_update.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((telNums == null) ? 0 : telNums.hashCode());
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
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (emails == null) {
			if (other.emails != null)
				return false;
		} else if (!emails.equals(other.emails))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (last_update == null) {
			if (other.last_update != null)
				return false;
		} else if (!last_update.equals(other.last_update))
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
		if (telNums == null) {
			if (other.telNums != null)
				return false;
		} else if (!telNums.equals(other.telNums))
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
		return "Customer [customer_id=" + customer_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", corporation=" + corporation + ", department=" + department + ", position=" + position + ", emails="
				+ emails + ", telNums=" + telNums + ", addresses=" + addresses + ", created_by=" + created_by
				+ ", updated_by=" + updated_by + ", last_update=" + last_update + ", creation_date=" + creation_date
				+ "]";
	}
	
}

