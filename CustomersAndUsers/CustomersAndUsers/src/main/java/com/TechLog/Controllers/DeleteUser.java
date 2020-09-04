package com.TechLog.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		UserService us = new UserService();
		Users user = us.removeUser(id);
		
		request.setAttribute("users", us.getAllUsersList());
		request.setAttribute("message", user.getFirstname() + " " + user.getLastname() + " removed!");
		request.getServletContext().setAttribute("lastLoggedInUsers", new UserService().getLastLoggedInUsers());
		
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
