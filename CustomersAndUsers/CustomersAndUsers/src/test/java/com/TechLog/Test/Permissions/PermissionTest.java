package com.TechLog.Test.Permissions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PermissionTest {
	
	Users user;
	Permission cd;
	Permission pd;
	DomainPermissions d;
	
	@BeforeAll
	void createUser() {
		cd = new CustomerDomainPermission();
		cd.set_read(true);
		cd.set_create(false);
		cd.set_delete(false);
		cd.set_update(true);
		
		pd = new ProductDomainPermission();
				
		d = new DomainPermissionsBuilder()
				.setCustomerDomain(cd)
				.setProductDomain(pd)
				.build();
		
		user = new Users();
		user.setFirstname("Alfred");
		user.setLastname("Hitchcock");
		user.setDomainPermissions(d);

		new PermissionDao().addPermission(new Permission());
	}
	
	@Test
	@DisplayName("When creating Customer Domain Permissions")
	void customerDomainPermissionsTest() {
		assertAll(
				() -> assertEquals(false, user.getDomainPermissions().getCustomerDomain().is_create()),
				() -> assertEquals(true, user.getDomainPermissions().getCustomerDomain().is_read()),
				() -> assertEquals(true, user.getDomainPermissions().getCustomerDomain().is_update()),
				() -> assertEquals(false, user.getDomainPermissions().getCustomerDomain().is_delete())				
				);
	}
	
	@Test
	@DisplayName("When creating Product Domain Permissions")
	void productDomainPermissionsTest() {
		assertAll(
				() -> assertEquals(false, user.getDomainPermissions().getProductDomain().is_create()),
				() -> assertEquals(false, user.getDomainPermissions().getProductDomain().is_read()),
				() -> assertEquals(false, user.getDomainPermissions().getProductDomain().is_update()),
				() -> assertEquals(false, user.getDomainPermissions().getProductDomain().is_delete())				
				);
	}
	
	@Test
	@DisplayName("Is CustomerDomainPermission an instance of correct sub class")
	void customerDomainPermissionInstantiationCheck() {
		assertTrue(cd instanceof CustomerDomainPermission);
	}
	
	@Test
	@DisplayName("Is ProductDomainPermission an instance of correct sub class")
	void productDomainPermissionInstantiationCheck() {
		assertTrue(pd instanceof ProductDomainPermission);
	}
	
	@Test
	@DisplayName("Does DomainPermissions Type Include CustomerDomainPermission")
	void domainPermissionsTypeCustomerDomainPermissionContentTest() {
		assertEquals(cd, d.getCustomerDomain());
	}
	
	@Test
	@DisplayName("Does DomainPermissions Type Include ProductDomainPermission")
	void domainPermissionTypeProductDomainPermissionContentTest() {
		assertEquals(pd, d.getProductDomain());
	}
	
	@Test
	@DisplayName("Does the User have correct DomainPermissions")
	void userDomainPermissionsTest() {
		assertEquals(d, user.getDomainPermissions());
	}
	
	@Test
	@DisplayName("When persisting the User")
	void userPersistenceTest() {
		new UserDao().addUser(user);
	}

}
