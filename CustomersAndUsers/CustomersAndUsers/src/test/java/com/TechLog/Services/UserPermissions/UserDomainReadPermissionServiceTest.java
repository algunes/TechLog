package com.TechLog.Services.UserPermissions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
class UserDomainReadPermissionServiceTest {

	Users masterUser;
	Users adminUser;
	
	Users masterUser2;
	Users adminUser2;
	
	Users targetUser;
	
	@BeforeAll
	void createAUser() {
		
		DomainPermissions dpTrue = new DomainPermissionsBuilder()
				.setUserDomain(true, true, true, true)
				.build();
		
		DomainPermissions dpFalse = new DomainPermissionsBuilder()
				.setUserDomain(true, false, true, true)
				.build();
		
		byte[] user = new UserService().usernameToByte("walter");
		byte[] admin = new UserService().usernameToByte("admin");
		byte[] target = new UserService().usernameToByte("target");
		
		UserAuthenticationInfo uaUser = new UserAuthenticationInfo();
		uaUser.setUserName(user);
		
		UserAuthenticationInfo uaAdmin = new UserAuthenticationInfo();
		uaAdmin.setUserName(admin);
		
		UserAuthenticationInfo uaTarget = new UserAuthenticationInfo();
		uaUser.setUserName(target);
		
		masterUser = new Users();
		masterUser.setFirstname("Walter");
		masterUser.setLastname("White");
		masterUser.setUserAuth(uaUser);
		masterUser.setDomainPermissions(dpTrue);
		
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
		adminUser2.setFirstname("Charlie");
		adminUser2.setLastname("Parker");
		adminUser2.setUserAuth(uaAdmin);
		adminUser2.setDomainPermissions(dpFalse);
		
		masterUser2 = new Users();
		masterUser2.setFirstname("Gustav");
		masterUser2.setLastname("Mahler");
		masterUser2.setUserAuth(uaUser);
		masterUser2.setDomainPermissions(dpFalse);
		
		targetUser = new Users();
		targetUser.setFirstname("Janis");
		targetUser.setLastname("Joplin");
		targetUser.setUserAuth(uaTarget);
		targetUser.setDomainPermissions(dpFalse);
	}
	
	@Test
	@DisplayName("showUserList() --> User with read permission test")
	void plainUserReadPermissionTest() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(masterUser, targetUser);
		assertTrue(udrpp.showUserList());
	}
	
	@Test
	@DisplayName("showUserList() --> User without read permission test")
	void plainUserReadPermissionTest2() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(masterUser2, targetUser);
		assertFalse(udrpp.showUserList());
	}
	
	@Test
	@DisplayName("showUserList() --> Admin User with read permission test")
	void adminUserReadPermissionTest() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser, targetUser);
		assertTrue(udrpp.showUserList());
	}
	
	@Test
	@DisplayName("showUserList() --> Admin User without read permission test")
	void adminUserReadPermissionTest2() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser2, targetUser);
		assertTrue(udrpp.showUserList());
	}
	
	@Test
	@DisplayName("details() --> User with read permission test")
	void plainUserReadPermissionTest3() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(masterUser, targetUser);
		assertTrue(udrpp.details());
	}
	
	@Test
	@DisplayName("details() --> User without read permission test (SelfRead)")
	void plainUserReadPermissionTest4() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(masterUser2, masterUser2);
		assertTrue(udrpp.details());
	}
	
	@Test
	@DisplayName("details() --> Admin User with read permission test")
	void adminUserReadPermissionTest3() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser, targetUser);
		assertTrue(udrpp.details());
	}
	
	@Test
	@DisplayName("details() --> Admin User without read permission test")
	void adminUserReadPermissionTest4() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser2, targetUser);
		assertTrue(udrpp.details());
	}
	
	@Test
	@DisplayName("details() --> Admin User with read permission test (SelfRead)")
	void adminUserReadPermissionTest5() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser, adminUser);
		assertTrue(udrpp.details());
	}
	
	@Test
	@DisplayName("details() --> Admin User without read permission test (SelfRead)")
	void adminUserReadPermissionTest6() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser2, adminUser2);
		assertTrue(udrpp.details());
	}
	
	@Test
	@DisplayName("getCreatedCorporations() --> User with read permission test")
	void plainUserReadPermissionTest5() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(masterUser, targetUser);
		assertTrue(udrpp.getCreatedCorporations());
	}
	@Test
	@DisplayName("getCreatedCorporations() --> User without read permission test")
	void plainUserReadPermissionTest6() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(masterUser2, targetUser);
		assertFalse(udrpp.getCreatedCorporations());
	}
	@Test
	@DisplayName("getCreatedCorporations() --> User without read permission test (SelfRead)")
	void plainUserReadPermissionTest7() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(masterUser2, masterUser2);
		assertTrue(udrpp.getCreatedCorporations());
	}
	@Test
	@DisplayName("getCreatedCorporations() --> Admin User with read permission test")
	void adminUserReadPermissionTest7() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser, targetUser);
		assertTrue(udrpp.getCreatedCorporations());
	}
	@Test
	@DisplayName("getCreatedCorporations() --> Admin User without read permission test")
	void adminUserReadPermissionTest8() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser2, targetUser);
		assertTrue(udrpp.getCreatedCorporations());
	}
	@Test
	@DisplayName("getCreatedCorporations() --> Admin User without read permission test (SelfRead)")
	void adminUserReadPermissionTest9() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser2, adminUser2);
		assertTrue(udrpp.getCreatedCorporations());
	}
	@Test
	@DisplayName("getCreatedCorporations() --> Admin User with read permission test (SelfRead)")
	void adminUserReadPermissionTest10() {
		UserDomainReadPermissionService udrpp = new UserDomainReadPermissionService(adminUser, adminUser);
		assertTrue(udrpp.getCreatedCorporations());
	}
}
