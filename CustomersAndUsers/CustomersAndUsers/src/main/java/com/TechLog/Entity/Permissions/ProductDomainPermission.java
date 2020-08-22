package com.TechLog.Entity.Permissions;

import javax.persistence.Entity;

@Entity
public class ProductDomainPermission extends Permission {
	
	public ProductDomainPermission() {
		super();
	}

	public ProductDomainPermission(boolean _create, boolean _read, boolean _update, boolean _delete) {
		super(_create, _read, _update, _delete);
	}
	
}
