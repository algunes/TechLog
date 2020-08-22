package com.TechLog.Test.Permissions;

public class DomainPermissionsBuilder {
	
	private Permission customerDomain;
	private Permission productDomain;
	private Permission stockDomain;

	public DomainPermissionsBuilder setCustomerDomain(Permission c) {
		this.customerDomain = c != null ? c : new CustomerDomainPermission();
		return this;
	}
	
	public DomainPermissionsBuilder setProductDomain(Permission p) {
		this.productDomain = p != null ? p : new ProductDomainPermission();
		return this;
	}
	
	public DomainPermissionsBuilder setStockDomain(Permission s) {
		this.stockDomain = s != null ? s : new StockDomainPermission();
		return this;
	}
	
	public DomainPermissions build() {
		if (this.customerDomain == null)
			this.customerDomain = new CustomerDomainPermission();
		if (this.productDomain == null)
			this.productDomain = new ProductDomainPermission();
		if (this.stockDomain == null)
			this.stockDomain = new StockDomainPermission();
		return new DomainPermissions(customerDomain, productDomain, stockDomain);
	}
	
}
