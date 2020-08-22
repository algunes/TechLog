package com.TechLog.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.DAO.Initialization.PermissionDao;
import com.TechLog.Entity.Permissions.DomainPermissions;
import com.TechLog.Entity.Permissions.DomainPermissionsBuilder;
import com.TechLog.Entity.Permissions.Permission;
import com.TechLog.Entity.Users.UserBuilder;

public class Initialization extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		new PermissionDao().addPermission(new Permission());
		
		DomainPermissions dp = new DomainPermissionsBuilder()
		.setCustomerDomain(true, true, true, true)
		.setUserDomain(true, true, true, true)
		.setProductDomain(true, true, true, true)
		.setStockDomain(true, true, true, true)
		.build();
		
		new UserBuilder()
		.setUserName("admin")
		.setPassword("1234")
		.setFirstname("Aliyar")
		.setLastname("Güneş")
		.setDomainPermissions(dp)
		.build();
		
		request.setAttribute("message", "Admin User Created!");
		RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
