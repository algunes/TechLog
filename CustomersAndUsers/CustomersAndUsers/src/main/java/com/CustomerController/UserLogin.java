package com.CustomerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.Users;

@WebServlet("/userLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
		request.setAttribute("message", "You logged out successfully!");
		RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Users user = new UserServiceImp().userLoginValidation(username, password);
		
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);	
		}
		else {
			request.setAttribute("message", "Your Username or Password is invalid!");
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
			rd.forward(request, response);	
		}
		
		
	}

}
