package com.CustomerController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.Users;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String job = null;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 job = request.getParameter("job");
		
		switch(job) {
		
		case "logout" : {
			new UserServiceImp().updateUser((Users)request.getSession().getAttribute("user"));
			request.getSession().invalidate();
			response.sendRedirect("UserLogin.jsp");
			break;
		}
		
		case "showUserList" : {
			List<Users> users = new UserServiceImp().getAllUsersList();
			
			request.setAttribute("users", users);
			RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "details" : {
			Long id = Long.parseLong(request.getParameter("id"));
			
			Users user = new UserServiceImp().getUser(id, true);
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateFirstname" : {
			
		}
		
		}
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		job = request.getParameter("job");
		
		switch(job) {
		
		case "login" : {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Users user = new UserServiceImp().userLoginValidation(username, password);
			
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);

				response.sendRedirect("index.jsp");

			}
			else {
				request.setAttribute("message", "Your Username or Password is invalid!");
				RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
				rd.forward(request, response);	
			}
			break;
		}
		
		}
		
	}

}
