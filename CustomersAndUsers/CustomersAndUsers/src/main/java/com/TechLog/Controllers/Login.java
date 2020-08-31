package com.TechLog.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.DomainViewService.DomainViewService;
import com.TechLog.Services.Users.UserService;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Users user = new UserService().userLoginValidation(username, password);
			
			if(user != null) {				
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(15*60);
				session.setAttribute("user", user);
				session.setAttribute("id", session.getId());
				session.setAttribute("domainPermissions", new DomainViewService(user, user));
				request.getServletContext().setAttribute("lastLoggedInUsers", new UserService().getLastLoggedInUsers());
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
		}
			else {
				request.setAttribute("alert", "Invalid username or password!");
				RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
				rd.forward(request, response);
			}
	}

}
