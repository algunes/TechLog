package com.TechLog.Entity.Permissions;

import javax.persistence.Entity;

@Entity
public class CustomerDomainPermission extends Permission {
	
	public CustomerDomainPermission() {
		super();
	}

	public CustomerDomainPermission(boolean _create, boolean _read, boolean _update, boolean _delete) {
		super(_create, _read, _update, _delete);
	}
	
	
	
}
