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

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
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
			Long id = Long.parseLong(request.getParameter("id"));
			String userFirstname = new UserServiceImp().getUser(id, false).getFirstname();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userFirstname);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateLastname" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userLastname = new UserServiceImp().getUser(id, false).getLastname();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userLastname);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateDepartment" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userDepartment = new UserServiceImp().getUser(id, false).getDepartment();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userDepartment);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updatePosition" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userPosition = new UserServiceImp().getUser(id, false).getPosition();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userPosition);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateRole" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userRole = new UserServiceImp().getUser(id, false).getRole();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userRole);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateEmail" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userEmail = new UserServiceImp().getUser(id, false).getEmail();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userEmail);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateTelNumber" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userTelNumber = new UserServiceImp().getUser(id, false).getTelNumber();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userTelNumber);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateAddress" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userAddress = new UserServiceImp().getUser(id, false).getAddress();
			
			request.setAttribute("id", id);
			request.setAttribute("value", userAddress);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "removeUser" : {
			Long id = Long.parseLong(request.getParameter("id"));
			
			if(((Users)request.getSession().getAttribute("user")).getRole().equals("Admin")) {
			new UserServiceImp().removeUser(id);
			
			request.setAttribute("message", "User removed!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			}
			else {
				request.setAttribute("user", new UserServiceImp().getUser(id, true));
				request.setAttribute("alert", "You are not authorized to delete this!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}
			break;	
			
		}
		
		case "getCreatedCorporations" : {
			Long id = Long.parseLong(request.getParameter("id"));
			Users user = new UserServiceImp().getUser(id, true);
			List<Corporation> corporations = user.getCreated_corporations();
			
			
			request.setAttribute("corporations", corporations);
			request.setAttribute("message", "Corporations which created by " + user.getFirstname() + " " + user.getLastname());
			
			RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
			rd.forward(request, response);
			break;
			
		}
		
		case "getCreatedCustomers" : {
			Long id = Long.parseLong(request.getParameter("id"));
			Users user = new UserServiceImp().getUser(id, true);
			List<Customer> customers = user.getCreated_customers();
			
			request.setAttribute("customers", customers);
			request.setAttribute("message", "Customers which created by " + user.getFirstname() + " " + user.getLastname());
			
			RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request, response);
			break;
			
		}
		
		case "updateUsername" : {
			Long id = Long.parseLong(request.getParameter("id"));
			UserServiceImp us = new UserServiceImp();
			String username = us.byteToUsername(us.getUser(id, true).getUserAuth().getUserName());
			
			request.setAttribute("id", id);
			request.setAttribute("value", username);
			request.setAttribute("job", job);
			request.setAttribute("formAction", "user");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "addUser" : {
			if(((Users)(request.getSession().getAttribute("user"))).getRole().equals("Admin")) {
			RequestDispatcher rd = request.getRequestDispatcher("AddUser.jsp");
			rd.forward(request, response);
			}
			else {
				request.setAttribute("alert", "You are not authorized to create an user!");
				request.setAttribute("users", new UserServiceImp().getAllUsersList());
				RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
				rd.forward(request, response);
			}
			
			break;	
			
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
		
		case "updateFirstname" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userFirstname = request.getParameter("output");
			
			Users user = new UserServiceImp().updateFirstname(id, userFirstname);
			request.setAttribute("message", "User firstname updated to '" + userFirstname + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		
		}
		
		case "updateLastname" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userLastname = request.getParameter("output");
			
			Users user = new UserServiceImp().updateLastname(id, userLastname);
					
			request.setAttribute("message", "User lastname updated to '" + userLastname + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		
		}
		
		case "updateDepartment" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userDepartment = request.getParameter("output");
			
			Users user = new UserServiceImp().updateDepartment(id, userDepartment);
						
			request.setAttribute("message", "User department updated to '" + userDepartment + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updatePosition" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userPosition = request.getParameter("output");
			
			Users user = new UserServiceImp().updatePosition(id, userPosition);
						
			request.setAttribute("message", "User position updated to '" + userPosition + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateRole" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userRole = request.getParameter("output");
			
			Users user = new UserServiceImp().updateRole(id, userRole);
						
			request.setAttribute("message", "User role updated to '" + userRole + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateEmail" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userEmail = request.getParameter("output");
			
			Users user = new UserServiceImp().updateEmail(id, userEmail);
						
			request.setAttribute("message", "User email updated to '" + userEmail + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateTelNumber" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userTelNumber = request.getParameter("output");
			
			Users user = new UserServiceImp().updateTelNumber(id, userTelNumber);
						
			request.setAttribute("message", "User tel. number updated to '" + userTelNumber + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateAddress" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String userAddress = request.getParameter("output");
		
			Users user = new UserServiceImp().updateAddress(id, userAddress);
						
			request.setAttribute("message", "User address updated to '" + userAddress + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "updateUsername" : {
			Long id = Long.parseLong(request.getParameter("id"));
			String username = request.getParameter("output");
			
			Users user = new UserServiceImp().updateUsername(id, username);
						
			request.setAttribute("message", "Username updated to '" + username + "' !");
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;	
			
		}
		
		case "addUser" : {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String department = request.getParameter("department");
			String position = request.getParameter("position");
			String role = request.getParameter("role");
			String email = request.getParameter("email");
			String telNumber = request.getParameter("telNumber");
			String address = request.getParameter("address");
			String username = request.getParameter("username");
			String password = request.getParameter("up");
			
			Users user = new UserServiceImp().userBuild(firstname, lastname, department, 
					position, role, email, telNumber, address, null, 
					username, password);
			
			request.setAttribute("user", user);
			request.setAttribute("message", "User created!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			
			break;
			
		}
		
	}

}
}
