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
class UserDomainUpdatePermissionServiceTest {
	
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
				.setUserDomain(true, true, false, true)
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
	@DisplayName("updateUsername() --> User with 'update permission' (SelfUpdate)")
	void updateUserNameTest1() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, masterUser);
		assertTrue(udups.updateUsername());
	}
	
	@Test
	@DisplayName("updateUsername() --> User without 'update permission' (SelfUpdate)")
	void updateUserNameTest2() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, masterUser2);
		assertTrue(udups.updateUsername());
	}
	
	@Test
	@DisplayName("updateUsername() --> User with 'update permission' updating another user")
	void updateUserNameTest3() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, targetUser);
		assertTrue(udups.updateUsername());
	}
	
	@Test
	@DisplayName("updateUsername() --> User with 'update permission' updating admin")
	void updateUserNameTest4() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, adminUser);
		assertFalse(udups.updateUsername());
	}
	
	@Test
	@DisplayName("updateUsername() --> User without 'update permission' updating admin")
	void updateUserNameTest5() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, adminUser);
		assertFalse(udups.updateUsername());
	}
	
	@Test
	@DisplayName("updateUsername() --> User without 'update permission' updating another user")
	void updateUserNameTest6() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, targetUser);
		assertFalse(udups.updateUsername());
	}
	
	@Test
	@DisplayName("updateUsername() --> Admin without 'update permission' (SelfUpdate)")
	void updateUserNameTest7() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, adminUser2);
		assertTrue(udups.updateUsername());
	}
	
	@Test
	@DisplayName("updateUsername() --> Admin with 'update permission' (SelfUpdate)")
	void updateUserNameTest8() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, adminUser);
		assertTrue(udups.updateUsername());
	}
	
	@Test
	@DisplayName("updateUsername() --> Admin with 'update permission' updating another user")
	void updateUserNameTest9() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, targetUser);
		assertTrue(udups.updateUsername());
	}
	
	@Test
	@DisplayName("updateUsername() --> Admin without 'update permission' updating another user")
	void updateUserNameTest10() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, targetUser);
		assertTrue(udups.updateUsername());
	}
	
	// --> updatePassword()
	
	@Test
	@DisplayName("updatePassword() --> User with 'update permission' updating another user")
	void updatePassword1() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, targetUser);
		assertFalse(udups.updatePassword());
	}
	
	@Test
	@DisplayName("updatePassword() --> User without 'update permission' updating another user")
	void updatePassword2() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, targetUser);
		assertFalse(udups.updatePassword());
	}
	
	@Test
	@DisplayName("updatePassword() --> User without 'update permission' (SelfUpdate)")
	void updatePassword3() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, masterUser2);
		assertTrue(udups.updatePassword());
	}
	
	@Test
	@DisplayName("updatePassword() --> User with 'update permission' (SelfUpdate)")
	void updatePassword4() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, masterUser);
		assertTrue(udups.updatePassword());
	}
	
	@Test
	@DisplayName("updatePassword() --> User with 'update permission' updating admin")
	void updatePassword5() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, adminUser);
		assertFalse(udups.updatePassword());
	}
	
	@Test
	@DisplayName("updatePassword() --> User without 'update permission' updating admin")
	void updatePassword6() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, adminUser);
		assertFalse(udups.updatePassword());
	}
	
	@Test
	@DisplayName("updatePassword() --> Admin with 'update permission' updating user")
	void updatePassword7() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, targetUser);
		assertFalse(udups.updatePassword());
	}
	
	@Test
	@DisplayName("updatePassword() --> Admin without 'update permission' updating user")
	void updatePassword8() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, targetUser);
		assertFalse(udups.updatePassword());
	}
	
	@Test
	@DisplayName("updatePassword() --> Admin with 'update permission' (SelfUpdate)")
	void updatePassword9() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, adminUser);
		assertTrue(udups.updatePassword());
	}
	
	@Test
	@DisplayName("updatePassword() --> Admin without 'update permission' (SelfUpdate)")
	void updatePassword10() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, adminUser2);
		assertTrue(udups.updatePassword());
	}
	
	// --> updateFirstname()
	
	@Test
	@DisplayName("updateFirstname() --> User with 'update permission' updating another user")
	void updateFirstname1() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, targetUser);
		assertTrue(udups.updateFirstname());
	}
	
	@Test
	@DisplayName("updateFirstname() --> User without 'update permission' updating another user")
	void updateFirstname2() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, targetUser);
		assertFalse(udups.updateFirstname());
	}
	
	@Test
	@DisplayName("updateFirstname() --> User with 'update permission' (SelfUpdate)")
	void updateFirstname3() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, masterUser);
		assertTrue(udups.updateFirstname());
	}
	
	@Test
	@DisplayName("updateFirstname() --> User without 'update permission' (SelfUpdate)")
	void updateFirstname4() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, masterUser2);
		assertFalse(udups.updateFirstname());
	}
	
	@Test
	@DisplayName("updateFirstname() --> User with 'update permission' updating admin")
	void updateFirstname5() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, adminUser);
		assertFalse(udups.updateFirstname());
	}
	
	@Test
	@DisplayName("updateFirstname() --> Admin with 'update permission' updating user")
	void updateFirstname6() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, targetUser);
		assertTrue(udups.updateFirstname());
	}
	
	@Test
	@DisplayName("updateFirstname() --> Admin without 'update permission' updating user")
	void updateFirstname7() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, targetUser);
		assertTrue(udups.updateFirstname());
	}
	
	@Test
	@DisplayName("updateFirstname() --> Admin with 'update permission' (SelfUpdate)")
	void updateFirstname8() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, adminUser);
		assertTrue(udups.updateFirstname());
	}
	
	@Test
	@DisplayName("updateFirstname() --> Admin without 'update permission' (SelfUpdate)")
	void updateFirstname9() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, adminUser2);
		assertTrue(udups.updateFirstname());
	}
	
	// --> updateLastname(), updateDepartment and updatePosition() functions not tested, because they have same pattern and response with updateFirstname()!

	
	// --> updatePermissions()
	
	@Test
	@DisplayName("updatePermissions() --> User with 'update permission' updating another user")
	void updatePermissions1() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, targetUser);
		assertTrue(udups.updatePermissions());
	}
	@Test
	@DisplayName("updatePermissions() --> User without 'update permission' updating another user")
	void updatePermissions2() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, targetUser);
		assertFalse(udups.updatePermissions());
	}
	
	@Test
	@DisplayName("updatePermissions() --> User with 'update permission' updating admin")
	void updatePermissions3() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, adminUser);
		assertFalse(udups.updatePermissions());
	}
	
	@Test
	@DisplayName("updatePermissions() --> User without 'update permission' updating admin")
	void updatePermissions4() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, adminUser);
		assertFalse(udups.updatePermissions());
	}
	
	@Test
	@DisplayName("updatePermissions() --> User with 'update permission' (SelfUpdate)")
	void updatePermissions5() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, masterUser);
		assertFalse(udups.updatePermissions());
	}
	
	@Test
	@DisplayName("updatePermissions() --> User without 'update permission' (SelfUpdate)")
	void updatePermissions6() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, masterUser2);
		assertFalse(udups.updatePermissions());
	}
	
	@Test
	@DisplayName("updatePermissions() --> Admin with 'update permission' updating another user")
	void updatePermissions7() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, targetUser);
		assertTrue(udups.updatePermissions());
	}
	
	@Test
	@DisplayName("updatePermissions() --> Admin without 'update permission' updating another user")
	void updatePermissions8() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, targetUser);
		assertTrue(udups.updatePermissions());
	}
	
	@Test
	@DisplayName("updatePermissions() --> Admin with 'update permission' (SelfUpdate")
	void updatePermissions9() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, adminUser);
		assertTrue(udups.updatePermissions());
	}
	
	@Test
	@DisplayName("updatePermissions() --> Admin without 'update permission' (SelfUpdate")
	void updatePermissions10() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, adminUser2);
		assertTrue(udups.updatePermissions());
	}
	
	// --> updateEmail()
	
	@Test
	@DisplayName("updateEmail() --> User with 'update permission' updating another user")
	void updateEmail1() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, targetUser);
		assertTrue(udups.updateEmail());
	}
	
	@Test
	@DisplayName("updateEmail() --> User without 'update permission' updating another user")
	void updateEmail2() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, targetUser);
		assertFalse(udups.updateEmail());
	}
	@Test
	@DisplayName("updateEmail() --> User with 'update permission' (SelfUpdate)")
	void updateEmail3() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, masterUser);
		assertTrue(udups.updateEmail());
	}
	@Test
	@DisplayName("updateEmail() --> User without 'update permission' (SelfUpdate)")
	void updateEmail4() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, masterUser2);
		assertTrue(udups.updateEmail());
	}
	@Test
	@DisplayName("updateEmail() --> User with 'update permission' updating admin")
	void updateEmail5() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, adminUser);
		assertFalse(udups.updateEmail());
	}
	@Test
	@DisplayName("updateEmail() --> User without 'update permission' updating admin")
	void updateEmail6() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser2, adminUser);
		assertFalse(udups.updateEmail());
	}
	@Test
	@DisplayName("updateEmail() --> Admin with 'update permission' updating user")
	void updateEmail7() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, targetUser);
		assertTrue(udups.updateEmail());
	}
	@Test
	@DisplayName("updateEmail() --> Admin without 'update permission' updating user")
	void updateEmail8() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, targetUser);
		assertTrue(udups.updateEmail());
	}
	@Test
	@DisplayName("updateEmail() --> Admin with 'update permission' (SelfUpdate)")
	void updateEmail9() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser, adminUser);
		assertTrue(udups.updateEmail());
	}
	@Test
	@DisplayName("updateEmail() --> Admin without 'update permission' (SelfUpdate)")
	void updateEmail10() {
		UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(adminUser2, adminUser2);
		assertTrue(udups.updateEmail());
	}
	
	// --> updateTelNumber() and updateAddress() functions not tested, because they have same pattern and response with updateEmail()!

}
