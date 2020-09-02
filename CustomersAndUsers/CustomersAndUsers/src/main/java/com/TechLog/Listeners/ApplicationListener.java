package com.TechLog.Listeners;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.TechLog.DAO.Initialization.PermissionDao;
import com.TechLog.Entity.Permissions.DomainPermissions;
import com.TechLog.Entity.Permissions.DomainPermissionsBuilder;
import com.TechLog.Entity.Permissions.Permission;
import com.TechLog.Entity.Users.UserBuilder;
import com.TechLog.Services.Corporation.CorporationPostService;
import com.TechLog.Services.Customer.CustomerPostService;
import com.TechLog.Services.Users.UserService;


@WebListener
public class ApplicationListener implements ServletContextListener {
	
	private Logger log = LogManager.getLogger(ApplicationListener.class);
	
    public ApplicationListener() {
      
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
    	      System.out.println("shutdown code");
    	    } catch (Exception e) {
    	      log.error("contextDestroy Error!", e);
    	    }
    	    log.info("webapp stopped");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	try {

    		log.info("webapp started");
    		
    		sce.getServletContext().setAttribute("lastUpdatedCustomers", 
    				new CustomerPostService().getLastUpdatedCustomers());
    		
    		sce.getServletContext().setAttribute("lastAddedCustomers", 
    				new CustomerPostService().getLastAddedCustomers());
    		
    		sce.getServletContext().setAttribute("lastAddedCorporations", 
    				new CorporationPostService().getLastAddedCorporations());
    		
    		sce.getServletContext().setAttribute("lastLoggedInUsers", 
    				new UserService().getLastLoggedInUsers());
    		
    		PermissionDao pdao = new PermissionDao();
    		
    		if(pdao.fetchUser(1L) == null) {
    			Permission p = new Permission();
        		log.info("False responsed Permission object instantiated!");
        		
        		PermissionDao pd = new PermissionDao();
        		pd.addPermission(p);
        		log.info("False responsed Permission object persisted!");
    		}
    		
    		if(new UserService().isUsernameUnique("admin")) {
    			
    			DomainPermissions dp = new DomainPermissionsBuilder()
    		    		.setCustomerDomain(true, true, true, true)
    		    		.setUserDomain(true, true, true, true)
    		    		.setProductDomain(true, true, true, true)
    		    		.setStockDomain(true, true, true, true)
    		    		.build();
    		    		log.info("Admin User's DomainPermissions object instantiated!");
    		    		
    		    		new UserBuilder()
    		    		.setUserName("admin")
    		    		.setPassword("1234")
    		    		.setFirstname("Aliyar")
    		    		.setLastname("Güneş")
    		    		.setDomainPermissions(dp)
    		    		.build();
    		    		log.info("Admin User and Its DomainPermissions Persisted!");

    			
    		}
    		
    		log.info("--> Everything is OK! Now you can login with admin user role!");

    	    } catch (Exception e) {
    	      log.error("Initialization Error!", e);
    	    }
    	    log.info("webapp started");
    	  }
	
}
