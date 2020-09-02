package com.TechLog.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.UserPermissions.UserDomainUpdatePermissionService;
import com.TechLog.Services.Users.UserService;

@WebFilter(urlPatterns = {"/updateUser", "/UpdateUser"})
public class UserDomainUpdatePermissionFilter implements Filter {

    public UserDomainUpdatePermissionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		Long id = req.getParameter("id") != null ? Long.parseLong(req.getParameter("id")) : null;
		String job = req.getParameter("job");
		
		if(id != null && job != null) {
			Users targetUser = (Users)new UserService().getUser(id, true);
			Users masterUser = (Users)req.getSession(false).getAttribute("user");
			UserDomainUpdatePermissionService udups = new UserDomainUpdatePermissionService(masterUser, targetUser);
			
			switch(job) {
			
			case "updateFirstname" : {
				if(udups.updateFirstname()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the firstname!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "updateLastname" : {
				if(udups.updateLastname()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the lastname!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "updateDepartment" : {
				if(udups.updateDepartment()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the department!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "updatePosition" : {
				if(udups.updatePosition()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the position!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "updateUserPermissions" : {
				if(udups.updatePermissions()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the permissions!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "updateEmail" : {
				if(udups.updateEmail()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the email!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "updateTelNumber" : {
				if(udups.updateTelNumber()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the tel num!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "updateAddress" : {
				if(udups.updateAddress()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the address!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "updateUsername" : {
				if(udups.updateUsername()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the username!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "updatePassword" : {
				if(udups.updatePassword()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to update the password!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "resetPassword" : {
				if(udups.resetPassword()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to reset the password!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			default : {
				req.setAttribute("alert", "Bad Request!");
				RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			}
		}
		else {
			req.setAttribute("alert", "Bad Request!");
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
