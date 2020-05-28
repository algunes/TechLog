package com.TechLog.Customers;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;


@Entity
@Table(name="customer")
@DynamicUpdate
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customer_id;
	
	@Column(name="firstname", nullable = false)
	private String firstname;
	
	@Column(name="lastname", nullable = false)
	private String lastname;
	
	@ManyToOne
	@JoinColumn(name="corporation", unique=true, nullable = false)
	private Corporation corporation;
	
	@ElementCollection
	@Column(name="emails")
	private List<Email> emails = new ArrayList<>();
	
	@ElementCollection
	@Column(name="phones")
	private List<Phone> phones = new ArrayList<>();
	
	@ElementCollection
	@Column(name="addresses")
	private List<Address> addresses = new ArrayList<>();
	
	@Column(name="created_by")
	private Long created_by;
	
	@Column(name="updated_by")
	private Long updated_by;
	
	@Column(name="last_update")
	private LocalDate last_update;
	
	@Column(name="creation_date")
	private LocalDate creation_date;
	
	public void addEmail(Email email) {
		this.getEmails().add(email);
	}
	
	public void removeEmail(Email email) {
		this.getEmails().remove(email);
	}
	
	public void addPhone(Phone phone) {
		this.getPhones().add(phone);
	}
	
	public void removePhone(Phone phone) {
		this.getPhones().remove(phone);
	}
	
	public void addAddress(Address address) {
		this.getAddresses().add(address);
	}
	
	public void removeAddress(Address address) {
		this.getAddresses().remove(address);
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

	public Long getCreated_by() {
		return created_by;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public Long getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(Long updated_by) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		result = prime * result + ((emails == null) ? 0 : emails.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((last_update == null) ? 0 : last_update.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((phones == null) ? 0 : phones.hashCode());
		result = prime * result + ((updated_by == null) ? 0 : updated_by.hashCode());
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
		if (phones == null) {
			if (other.phones != null)
				return false;
		} else if (!phones.equals(other.phones))
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
				+ ", corporation=" + corporation + ", emails=" + emails + ", phones=" + phones + ", addresses="
				+ addresses + ", created_by=" + created_by + ", updated_by=" + updated_by + ", last_update="
				+ last_update + ", creation_date=" + creation_date + "]";
	}

}

