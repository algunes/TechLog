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
class UserDomainDeletePermissionServiceTest {

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
				.setUserDomain(true, true, true, false)
				.build();
		
		byte[] user = new UserService().usernameToByte("walter");
		byte[] admin = new UserService().usernameToByte("admin");
		byte[] target = new UserService().usernameToByte("woody");
		
		UserAuthenticationInfo uaUser = new UserAuthenticationInfo();
		uaUser.setUserName(user);
		
		UserAuthenticationInfo uaAdmin = new UserAuthenticationInfo();
		uaAdmin.setUserName(admin);
		
		UserAuthenticationInfo uaTarget = new UserAuthenticationInfo();
		uaTarget.setUserName(target);
		
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
		masterUser2.setLastname("White");
		masterUser2.setUserAuth(uaUser);
		masterUser2.setDomainPermissions(dpFalse);
		
		adminUser2 = new Users();
		adminUser2.setFirstname("Charlie");
		adminUser2.setLastname("Parker");
		adminUser2.setUserAuth(uaAdmin);
		adminUser2.setDomainPermissions(dpFalse);
		
		targetUser = new Users();
		targetUser.setFirstname("Woody");
		targetUser.setLastname("Allen");
		targetUser.setUserAuth(uaTarget);
		targetUser.setDomainPermissions(dpFalse);
	}
	
	@Test
	@DisplayName("deleteUser() --> User with 'delete permission' deleting another user")
	void deleteUser1() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(masterUser, targetUser);
		assertTrue(uddps.deleteUser());
	}
	
	@Test
	@DisplayName("deleteUser() --> User without 'delete permission' deleting another user")
	void deleteUser2() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(masterUser2, targetUser);
		assertFalse(uddps.deleteUser());
	}
	@Test
	@DisplayName("deleteUser() --> User with 'delete permission' deleting admin")
	void deleteUser3() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(masterUser, adminUser);
		assertFalse(uddps.deleteUser());
	}
	@Test
	@DisplayName("deleteUser() --> User with 'delete permission' (SelfDelete)")
	void deleteUser4() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(masterUser, masterUser);
		assertFalse(uddps.deleteUser());
	}
	@Test
	@DisplayName("deleteUser() --> User without 'delete permission' deleting admin")
	void deleteUser5() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(masterUser2, adminUser);
		assertFalse(uddps.deleteUser());
	}
	@Test
	@DisplayName("deleteUser() --> User without 'delete permission' (SelfDelete)")
	void deleteUser6() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(masterUser2, masterUser2);
		assertFalse(uddps.deleteUser());
	}
	@Test
	@DisplayName("deleteUser() --> Admin with 'delete permission' deleting another user")
	void deleteUser7() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(adminUser, targetUser);
		assertTrue(uddps.deleteUser());
	}
	@Test
	@DisplayName("deleteUser() --> Admin without 'delete permission' deleting another user")
	void deleteUser8() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(adminUser2, targetUser);
		assertTrue(uddps.deleteUser());
	}
	@Test
	@DisplayName("deleteUser() --> Admin with 'delete permission' (SelfDelete)")
	void deleteUser9() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(adminUser, adminUser);
		assertFalse(uddps.deleteUser());
	}
	@Test
	@DisplayName("deleteUser() --> Admin without 'delete permission' (SelfDelete)")
	void deleteUser10() {
		UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(adminUser2, adminUser2);
		assertFalse(uddps.deleteUser());
	}

}
