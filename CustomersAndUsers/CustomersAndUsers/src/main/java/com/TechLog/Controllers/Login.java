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
import com.TechLog.Services.Users.UserService;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			if (request.getSession().getAttribute("user") == null) {
				request.setAttribute("message", "Please sign in first!");
				RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getSession(true).getAttribute("user") != null) {
			response.sendRedirect("index.jsp");
		}
		
		else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Users user = new UserService().userLoginValidation(username, password);
			
			if(user != null) {
				
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(15*60);
				session.setAttribute("user", user);
				
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
			else {
				request.setAttribute("alert", "Your Username or Password is invalid!");
				RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
				rd.forward(request, response);	
			}
		}
	}

}
