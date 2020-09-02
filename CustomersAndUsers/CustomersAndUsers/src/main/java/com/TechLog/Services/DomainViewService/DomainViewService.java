package com.TechLog.Services.DomainViewService;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.CustomerPermissions.CustomerDomainCreatePermissionService;
import com.TechLog.Services.CustomerPermissions.CustomerDomainDeletePermissionService;
import com.TechLog.Services.CustomerPermissions.CustomerDomainReadPermissionService;
import com.TechLog.Services.CustomerPermissions.CustomerDomainUpdatePermissionService;
import com.TechLog.Services.UserPermissions.UserDomainCreatePermissionService;
import com.TechLog.Services.UserPermissions.UserDomainDeletePermissionService;
import com.TechLog.Services.UserPermissions.UserDomainReadPermissionService;
import com.TechLog.Services.UserPermissions.UserDomainUpdatePermissionService;

public class DomainViewService {
	
	private UserDomainCreatePermissionService udcps;
	private UserDomainReadPermissionService udrps;
	private UserDomainUpdatePermissionService udups;
	private UserDomainDeletePermissionService uddps;
	
	private CustomerDomainCreatePermissionService cdcps;
	private CustomerDomainReadPermissionService cdrps;
	private CustomerDomainUpdatePermissionService cdups;
	private CustomerDomainDeletePermissionService cddps;
	
	public DomainViewService(Users masterUser, Users targetUser) {
		
		super();
		this.udcps = new UserDomainCreatePermissionService(masterUser);
		this.udrps = new UserDomainReadPermissionService(masterUser, targetUser);
		this.udups = new UserDomainUpdatePermissionService(masterUser, targetUser);
		this.uddps = new UserDomainDeletePermissionService(masterUser, targetUser);
		
		this.cdcps = new CustomerDomainCreatePermissionService(masterUser);	
		this.cdrps = new CustomerDomainReadPermissionService(masterUser);
		this.cdups = new CustomerDomainUpdatePermissionService(masterUser);
		this.cddps =  new CustomerDomainDeletePermissionService(masterUser);
		
	}

	public UserDomainCreatePermissionService getUserDomainCreate() {
		return udcps;
	}

	public UserDomainReadPermissionService getUserDomainRead() {
		return udrps;
	}

	public UserDomainUpdatePermissionService getUserDomainUpdate() {
		return udups;
	}

	public UserDomainDeletePermissionService getUserDomainDelete() {
		return uddps;
	}

	public CustomerDomainCreatePermissionService getCustomerDomainCreate() {
		return cdcps;
	}

	public CustomerDomainReadPermissionService getCustomerDomainRead() {
		return cdrps;
	}

	public CustomerDomainUpdatePermissionService getCustomerDomainUpdate() {
		return cdups;
	}

	public CustomerDomainDeletePermissionService getCustomerDomainDelete() {
		return cddps;
	}

}
