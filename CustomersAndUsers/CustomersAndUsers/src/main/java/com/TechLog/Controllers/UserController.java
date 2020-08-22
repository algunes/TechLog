package com.TechLog.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Entity.Permissions.DomainPermissions;
import com.TechLog.Entity.Permissions.DomainPermissionsBuilder;
import com.TechLog.Entity.Users.UserBuilder;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.UserPermissions.UserPermissionsService;
import com.TechLog.Services.Users.UserService;

//@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String job;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		job = request.getParameter("job") != null ? request.getParameter("job") : "";
		
		switch(job) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		case "removeUser" : {
			

			break;	
			
		}
		
		
		
		
		
		
		
		
		
		
		
		}
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		job = request.getParameter("job") != null ? request.getParameter("job") : "";
		
		switch(job) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		default : {
			response.sendRedirect("index.jsp");
			break;
		}
		
	}

}
}
