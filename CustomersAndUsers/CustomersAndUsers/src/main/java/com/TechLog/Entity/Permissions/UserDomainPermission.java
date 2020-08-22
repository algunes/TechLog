package com.TechLog.Entity.Permissions;

import javax.persistence.Entity;

@Entity
public class UserDomainPermission extends Permission {

	public UserDomainPermission() {
		super();
	}

	public UserDomainPermission(boolean _create, boolean _read, boolean _update, boolean _delete) {
		super(_create, _read, _update, _delete);
	}

}
