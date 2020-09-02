package com.TechLog.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

@WebServlet("/readUser")
public class ReadUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String job = request.getParameter("job");

		switch(job) {
		
		case "showUserList" : {
			List<Users> users = new UserService().getAllUsersList();
			
			request.setAttribute("users", users);
			RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "details" : {
			Long id = Long.parseLong(request.getParameter("id"));
			
			Users user = new UserService().getUser(id, true);
			request.setAttribute("user", user);
			request.setAttribute("username", new UserService().byteToUsername(user.getUserAuth().getUserName()));
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "getCreatedCorporations" : {
			Long id = Long.parseLong(request.getParameter("id"));
			Users user = new UserService().getUser(id, true);
			List<Corporation> corporations = user.getCreated_corporations();
			
			request.setAttribute("corporations", corporations);
			request.setAttribute("caption", "Corporations which created by " + user.getFirstname() + " " + user.getLastname());
			
			RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
			rd.forward(request, response);
			break;
			
		}
		
		case "getCreatedCustomers" : {
			Long id = Long.parseLong(request.getParameter("id"));
			Users user = new UserService().getUser(id, true);
			List<Customer> customers = user.getCreated_customers();
			
			request.setAttribute("customers", customers);
			request.setAttribute("caption", "Customers which created by " + user.getFirstname() + " " + user.getLastname());
			
			RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request, response);
			break;
			
		}
	}
		
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
