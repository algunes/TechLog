package com.TechLog.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Entity.Permissions.DomainPermissions;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.UserPermissions.UserPermissionsService;
import com.TechLog.Services.Users.UserService;

@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String job;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		job = request.getParameter("job");
		Long id = Long.parseLong(request.getParameter("id"));

		switch(job) {
		
		case "updateFirstname" : {
			
			String userFirstname = new UserService().getUser(id, false).getFirstname();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userFirstname);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateLastname" : {
			String userLastname = new UserService().getUser(id, false).getLastname();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userLastname);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateDepartment" : {
			String userDepartment = new UserService().getUser(id, false).getDepartment();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userDepartment);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updatePosition" : {
			String userPosition = new UserService().getUser(id, false).getPosition();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userPosition);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateUserPermissions" : {
			DomainPermissions domainPermissions = new UserService().getUser(id, true).getDomainPermissions();
			
			request.setAttribute("id", id);
			request.setAttribute("domainPermissions", domainPermissions);
			request.setAttribute("job", job);
			
			RequestDispatcher rd = request.getRequestDispatcher("UserPermissionsCheckboxes.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateEmail" : {
			String userEmail = new UserService().getUser(id, false).getEmail();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userEmail);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateTelNumber" : {
			String userTelNumber = new UserService().getUser(id, false).getTelNumber();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userTelNumber);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateAddress" : {
			String userAddress = new UserService().getUser(id, false).getAddress();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userAddress);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateUsername" : {
			UserService us = new UserService();
			String username = us.byteToUsername(us.getUser(id, true).getUserAuth().getUserName());
			
			request.setAttribute("id", id);
			request.setAttribute("value", username);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updatePassword" : {
			request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("PasswordChange.jsp");
			rd.forward(request, response);
			break;
		}		
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		job = request.getParameter("job") != null ? request.getParameter("job") : "";
		Long id = Long.parseLong(request.getParameter("id"));


		switch(job) {
		
		case "updateFirstname" : {
			String userFirstname = request.getParameter("output");
			
			Users user = new UserService().updateFirstname(id, userFirstname);
			request.setAttribute("message", "User firstname updated to '" + userFirstname + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
		
		}
		
		case "updateLastname" : {
			String userLastname = request.getParameter("output");
			
			Users user = new UserService().updateLastname(id, userLastname);
					
			request.setAttribute("message", "User lastname updated to '" + userLastname + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateDepartment" : {
			String userDepartment = request.getParameter("output");
			
			Users user = new UserService().updateDepartment(id, userDepartment);
						
			request.setAttribute("message", "User department updated to '" + userDepartment + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updatePosition" : {
			String userPosition = request.getParameter("output");
			
			Users user = new UserService().updatePosition(id, userPosition);
						
			request.setAttribute("message", "User position updated to '" + userPosition + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateUserPermissions" : {
			
			Boolean cdCreate = Boolean.parseBoolean(request.getParameter("customerDomainCreate"));
			Boolean cdRead = Boolean.parseBoolean(request.getParameter("customerDomainRead"));
			Boolean cdUpdate = Boolean.parseBoolean(request.getParameter("customerDomainUpdate"));
			Boolean cdDelete = Boolean.parseBoolean(request.getParameter("customerDomainDelete"));
			
			Boolean udCreate = Boolean.parseBoolean(request.getParameter("userDomainCreate"));
			Boolean udRead = Boolean.parseBoolean(request.getParameter("userDomainRead"));
			Boolean udUpdate = Boolean.parseBoolean(request.getParameter("userDomainUpdate"));
			Boolean udDelete = Boolean.parseBoolean(request.getParameter("userDomainDelete"));
			
			Boolean pdCreate = Boolean.parseBoolean(request.getParameter("productDomainCreate"));
			Boolean pdRead = Boolean.parseBoolean(request.getParameter("productDomainRead"));
			Boolean pdUpdate = Boolean.parseBoolean(request.getParameter("productDomainUpdate"));
			Boolean pdDelete = Boolean.parseBoolean(request.getParameter("productDomainDelete"));
			
			Boolean sdCreate = Boolean.parseBoolean(request.getParameter("stockDomainCreate"));
			Boolean sdRead = Boolean.parseBoolean(request.getParameter("stockDomainRead"));
			Boolean sdUpdate = Boolean.parseBoolean(request.getParameter("stockDomainUpdate"));
			Boolean sdDelete = Boolean.parseBoolean(request.getParameter("stockDomainDelete"));
			
			Users user = new UserService().getUser(id, true);
			
			UserPermissionsService ups = new UserPermissionsService();
			ups.updateCustomerDomainPermission(user, cdCreate, cdRead, cdUpdate, cdDelete);
			ups.updateUserDomainPermission(user, udCreate, udRead, udUpdate, udDelete);
			ups.updateProductDomainPermission(user, pdCreate, pdRead, pdUpdate, pdDelete);
			ups.updateStockDomainPermission(user, sdCreate, sdRead, sdUpdate, sdDelete);
			
			request.setAttribute("message", "User permissions Updated!");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateEmail" : {
			String userEmail = request.getParameter("output");
			
			Users user = new UserService().updateEmail(id, userEmail);
						
			request.setAttribute("message", "User email updated to '" + userEmail + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateTelNumber" : {
			String userTelNumber = request.getParameter("output");
			
			Users user = new UserService().updateTelNumber(id, userTelNumber);
						
			request.setAttribute("message", "User tel. number updated to '" + userTelNumber + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateAddress" : {
			String userAddress = request.getParameter("output");
		
			Users user = new UserService().updateAddress(id, userAddress);
						
			request.setAttribute("message", "User address updated to '" + userAddress + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateUsername" : {
			String username = request.getParameter("output");
			
			Users user = new UserService().updateUsername(id, username);
			if(user != null) {		
				request.setAttribute("message", "Username updated to '" + username + "' !");
				request.setAttribute("user", user);
				
				RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "This username is used by someone else!");
				request.setAttribute("user", new UserService().getUser(id, true));
				
				RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}
			break;	
			
		}
		
		case "updatePassword" : {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("up");
			
			UserService us = new UserService();
			Users user = us.updatePassword(id, oldPassword, newPassword);
			if(user == null) {
				request.setAttribute("user", user);
				request.setAttribute("alert", "Your username or password is invalid!");
				RequestDispatcher rd = request.getRequestDispatcher("PasswordChange.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("message", "Password changed!");
				request.setAttribute("user", user);
				
				RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}
			break;
		}
		
		default : {
			request.setAttribute("alert", "Bad Post Request!");
			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
			break;
		}
		
		}
	}

}
