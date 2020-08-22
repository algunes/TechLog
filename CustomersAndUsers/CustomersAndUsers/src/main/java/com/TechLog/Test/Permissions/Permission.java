package com.TechLog.Test.Permissions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Permission {
	
	@Id
	@GeneratedValue
	Long permission_id;
	
	@Column(name = "_create")
	private boolean _create;
	
	@Column(name = "_read")
	private boolean _read;
	
	@Column(name = "_update")
	private boolean _update;
	
	@Column(name = "_delete")
	private boolean _delete;
			
	public Permission() {
		super();
		this._create = false;
		this._read = false;
		this._update = false;
		this._delete = false;
	}

	public Permission(boolean _create, boolean _read, boolean _update, boolean _delete) {
		super();
		this._create = _create;
		this._read = _read;
		this._update = _update;
		this._delete = _delete;
	}
	
	public Long getId() {
		return permission_id;
	}
	public void setId(Long id) {
		this.permission_id = id;
	}
	public boolean is_create() {
		return _create;
	}
	public void set_create(boolean _create) {
		this._create = _create;
	}
	public boolean is_read() {
		return _read;
	}
	public void set_read(boolean _read) {
		this._read = _read;
	}
	public boolean is_update() {
		return _update;
	}
	public void set_update(boolean _update) {
		this._update = _update;
	}
	public boolean is_delete() {
		return _delete;
	}
	public void set_delete(boolean _delete) {
		this._delete = _delete;
	}
	@Override
	public String toString() {
		return "Permission [id=" + permission_id + ", _create=" + _create + ", _read="
				+ _read + ", _update=" + _update + ", _delete=" + _delete + "]";
	}		
}
