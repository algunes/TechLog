package com.TechLog.Listeners;


import javax.servlet.ServletContext;
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


@WebListener
public class ApplicationListener implements ServletContextListener {

	private ServletContext sc = null;
	
	private Logger log = LogManager.getLogger(ApplicationListener.class);
	
    public ApplicationListener() {
      
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	try {
    	      System.out.println("shutdown code");
    	    } catch (Exception e) {
    	      log.error("contextDestroy Error!", e);
    	    }
    	    this.sc = null;
    	    log.info("webapp stopped");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	this.sc = sce.getServletContext();
    	
    	try {

    		log.info("webapp started");
    		
    		new PermissionDao().addPermission(new Permission());
    		
    		log.info(" 1/3 Permission initialized");
    		
    		DomainPermissions dp = new DomainPermissionsBuilder()
    		.setCustomerDomain(true, true, true, true)
    		.setUserDomain(true, true, true, true)
    		.setProductDomain(true, true, true, true)
    		.setStockDomain(true, true, true, true)
    		.build();
    		
    		log.info("2/3 DomainPermission initialized");
    		
    		new UserBuilder()
    		.setUserName("admin")
    		.setPassword("1234")
    		.setFirstname("Aliyar")
    		.setLastname("Güneş")
    		.setDomainPermissions(dp)
    		.build();
    		
    		log.info("3/3 Admin User Initialized");
    		log.info("Everything is OK! Now you can login to the app!");

    	    } catch (Exception e) {
    	      log.error("Initialization Error!", e);
    	    }
    	    log.info("webapp started");
    	  }
	
}
