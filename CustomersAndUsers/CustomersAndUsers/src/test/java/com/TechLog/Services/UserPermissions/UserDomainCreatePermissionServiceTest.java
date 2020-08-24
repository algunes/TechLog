package com.TechLog.Services.UserPermissions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.TechLog.Entity.Permissions.DomainPermissions;
import com.TechLog.Entity.Permissions.DomainPermissionsBuilder;
import com.TechLog.Entity.Users.UserAuthenticationInfo;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserDomainCreatePermissionServiceTest {

	Users masterUser;
	Users adminUser;
	
	Users masterUser2;
	Users adminUser2;
	
	@BeforeAll
	void createAUser() {
		
		DomainPermissions dpTrue = new DomainPermissionsBuilder()
				.setCustomerDomain(true, true, true, true)
				.setProductDomain(true, true, true, true)
				.setStockDomain(true, true, true, true)
				.setUserDomain(true, true, true, true)
				.build();
		
		DomainPermissions dpFalse = new DomainPermissionsBuilder()
				.setCustomerDomain(true, true, true, true)
				.setProductDomain(true, true, true, true)
				.setStockDomain(true, true, true, true)
				.setUserDomain(false, true, true, true)
				.build();
		
		byte[] user = new UserService().usernameToByte("walter");
		byte[] admin = new UserService().usernameToByte("admin");
		
		UserAuthenticationInfo uaUser = new UserAuthenticationInfo();
		uaUser.setUserName(user);
		
		masterUser = new Users();
		masterUser.setFirstname("Walter");
		masterUser.setLastname("White");
		masterUser.setUserAuth(uaUser);
		masterUser.setDomainPermissions(dpTrue);
		
		UserAuthenticationInfo uaAdmin = new UserAuthenticationInfo();
		uaAdmin.setUserName(admin);
		
		adminUser = new Users();
		adminUser.setFirstname("Bob");
		adminUser.setLastname("Dylan");
		adminUser.setUserAuth(uaAdmin);
		adminUser.setDomainPermissions(dpTrue);

		
		masterUser2 = new Users();
		masterUser2.setFirstname("Bob");
		masterUser2.setLastname("Marley");
		masterUser2.setUserAuth(uaUser);
		masterUser2.setDomainPermissions(dpFalse);
		
		adminUser2 = new Users();
		adminUser2.setFirstname("Bob");
		adminUser2.setLastname("Dylan");
		adminUser2.setUserAuth(uaAdmin);
		adminUser2.setDomainPermissions(dpFalse);
	}
	
	@Test
	@DisplayName("User with create permission test")
	void plainUserCreatePermissionTest() {
		UserDomainCreatePermissionService udcpp = new UserDomainCreatePermissionService(masterUser);
		assertTrue(udcpp.createUser());
	}
	
	@Test
	@DisplayName("Admin User with create permission test")
	void adminUserCreatePermissionTest() {
		UserDomainCreatePermissionService udcpp = new UserDomainCreatePermissionService(adminUser);
		assertTrue(udcpp.createUser());
	}
	
	@Test
	@DisplayName("User without create permission test")
	void plainUserCreatePermissionTest2() {
		UserDomainCreatePermissionService udcpp = new UserDomainCreatePermissionService(masterUser2);
		assertFalse(udcpp.createUser());
	}
	
	@Test
	@DisplayName("Admin User without create permission test")
	void adminUserCreatePermissionTest2() {
		UserDomainCreatePermissionService udcpp = new UserDomainCreatePermissionService(adminUser2);
		assertTrue(udcpp.createUser());
	}

}
