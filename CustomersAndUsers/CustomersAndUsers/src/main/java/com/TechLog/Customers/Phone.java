package com.TechLog.Customers;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="phone_number", nullable=false)
	private String number;
	
	@Column(name="primary_flag")
	private boolean primary_flag;
	
	@Column(name="created_by")
	private Long created_by;
	
	@Column(name="updated_by")
	private Long updated_by;
	
	@Column(name="last_update")
	private LocalDate last_update;
	
	@Column(name="creation_date")
	private LocalDate creation_date;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isPrimary_flag() {
		return primary_flag;
	}

	public void setPrimary_flag(boolean primary_flag) {
		this.primary_flag = primary_flag;
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
		result = prime * result + ((created_by == null) ? 0 : created_by.hashCode());
		result = prime * result + ((creation_date == null) ? 0 : creation_date.hashCode());
		result = prime * result + ((last_update == null) ? 0 : last_update.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + (primary_flag ? 1231 : 1237);
		result = prime * result + ((updated_by == null) ? 0 : updated_by.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Phone))
			return false;
		Phone other = (Phone) obj;
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
		if (last_update == null) {
			if (other.last_update != null)
				return false;
		} else if (!last_update.equals(other.last_update))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (primary_flag != other.primary_flag)
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
		return "Phone [number=" + number + ", primary_flag=" + primary_flag + ", created_by=" + created_by
				+ ", updated_by=" + updated_by + ", last_update=" + last_update + ", creation_date=" + creation_date
				+ "]";
	}

}
