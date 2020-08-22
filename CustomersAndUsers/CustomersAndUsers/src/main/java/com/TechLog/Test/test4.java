package com.TechLog.Test;

import com.TechLog.Entity.Permissions.CustomerDomainPermission;
import com.TechLog.Entity.Permissions.Permission;

public class test4 {

	public static void main(String[] args) {
		
		CustomerDomainPermission u = new CustomerDomainPermission();
		Permission role = u;
		
		System.out.println(role instanceof CustomerDomainPermission);
		
		}

}
