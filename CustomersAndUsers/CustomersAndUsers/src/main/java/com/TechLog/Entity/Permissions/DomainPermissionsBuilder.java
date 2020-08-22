package com.TechLog.Entity.Permissions;

public class DomainPermissionsBuilder {
	
	private Permission userDomain;
	private Permission customerDomain;
	private Permission productDomain;
	private Permission stockDomain;
	
	public DomainPermissionsBuilder setUserDomain(Boolean c, Boolean r, Boolean u, Boolean d) {
		this.userDomain = new UserDomainPermission(c, r, u, d);
		return this;
	}

	public DomainPermissionsBuilder setCustomerDomain(Boolean c, Boolean r, Boolean u, Boolean d) {
		this.customerDomain = new CustomerDomainPermission(c, r, u ,d);
		return this;
	}
	
	public DomainPermissionsBuilder setProductDomain(Boolean c, Boolean r, Boolean u, Boolean d) {
		this.productDomain = new ProductDomainPermission(c, r, u, d);
		return this;
	}
	
	public DomainPermissionsBuilder setStockDomain(Boolean c, Boolean r, Boolean u, Boolean d) {
		this.stockDomain = new StockDomainPermission(c, r, u, d);
		return this;
	}
	
	public DomainPermissions build() {
		if (this.userDomain == null)
			this.userDomain = new UserDomainPermission();
		if (this.customerDomain == null)
			this.customerDomain = new CustomerDomainPermission();
		if (this.productDomain == null)
			this.productDomain = new ProductDomainPermission();
		if (this.stockDomain == null)
			this.stockDomain = new StockDomainPermission();
		return new DomainPermissions(userDomain, customerDomain, productDomain, stockDomain);
	}
	
}
