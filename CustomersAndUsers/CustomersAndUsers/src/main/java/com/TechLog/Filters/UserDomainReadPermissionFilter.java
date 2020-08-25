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
import com.TechLog.Services.UserPermissions.UserDomainReadPermissionService;
import com.TechLog.Services.Users.UserService;

@WebFilter(urlPatterns = {"/readUser", "/ReadUser"})
public class UserDomainReadPermissionFilter implements Filter {

    public UserDomainReadPermissionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		Long id = req.getParameter("id") != null ? Long.parseLong(req.getParameter("id")) : null;
		String job = req.getParameter("job");
		
		if(job != null) {
			Users targetUser = id != null ? (Users)new UserService().getUser(id, true) : null;
			Users masterUser = (Users)req.getSession().getAttribute("user");
			UserDomainReadPermissionService udrps = targetUser != null 
					? new UserDomainReadPermissionService(masterUser, targetUser)
							: new UserDomainReadPermissionService(masterUser, masterUser);
			
			switch(job) {
			
			case "showUserList" : {
				if(udrps.showUserList()) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to list users!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "details" : {
				if(udrps.details() && id != null) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to see the user details!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "getCreatedCorporations" : {
				if(udrps.getCreatedCorporations() && id != null) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to see the corporations which created by the user!");
					RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
					rd.forward(request, response);
				}
				break;
			}
			case "getCreatedCustomers" : {
				if(udrps.getCreatedCustomers() && id != null) {
					chain.doFilter(request, response);
				}
				else {
					req.setAttribute("alert", "You have no permission to see the customers which created by the user!");
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
