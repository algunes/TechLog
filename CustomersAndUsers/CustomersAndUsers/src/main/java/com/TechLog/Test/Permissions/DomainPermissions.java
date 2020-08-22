package com.TechLog.Test.Permissions;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DomainPermissions {
	
	@Id
	@GeneratedValue
	private Long domainPermissions_id;
	
	@OneToOne(cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@JoinColumn(name="customerDomain_permission_id", columnDefinition = "bigint default 1")
	private Permission customerDomain;
	
	@OneToOne(cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@JoinColumn(name="productDomain_permission_id", columnDefinition = "bigint default 1")
	private Permission productDomain;
	
	@OneToOne(cascade = CascadeType.ALL, 
			orphanRemoval = true)
	@JoinColumn(name="stockDomain_permission_id", columnDefinition = "bigint default 1")
	private Permission stockDomain;
	
	@OneToOne(mappedBy = "domainPermissions")
	private Users user;
		
	public DomainPermissions(Permission customerDomain, Permission productDomain, Permission stockDomain) {
		super();
		this.customerDomain = customerDomain;
		this.productDomain = productDomain;
		this.stockDomain = stockDomain;
	}
	
	public Long getDomainPermissions_id() {
		return domainPermissions_id;
	}
	public void setDomainPermissions_id(Long domainPermissions_id) {
		this.domainPermissions_id = domainPermissions_id;
	}
	public Permission getCustomerDomain() {
		return customerDomain;
	}
	public void setCustomerDomain(Permission customerDomain) {
		this.customerDomain = customerDomain;
	}
	public Permission getProductDomain() {
		return productDomain;
	}
	public void setProductDomain(Permission productDomain) {
		this.productDomain = productDomain;
	}
	
	public Permission getStockDomain() {
		return stockDomain;
	}
	public void setStockDomain(Permission stockDomain) {
		this.stockDomain = stockDomain;
	}
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "DomainPermissions [domainPermissions_id=" + domainPermissions_id + ", customerDomain=" + customerDomain
				+ ", productDomain=" + productDomain + ", stockDomain=" + stockDomain + ", user=" + user + "]";
	}

}
