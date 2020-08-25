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
import com.TechLog.Services.UserPermissions.UserDomainDeletePermissionService;
import com.TechLog.Services.Users.UserService;

@WebFilter(urlPatterns = {"/deleteCustomer", "/DeleteCustomer"})
public class CustomerDomainDeletePermissionFilter implements Filter {
	
    public CustomerDomainDeletePermissionFilter() {
    }

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		Long id = req.getParameter("id") != null ? Long.parseLong(req.getParameter("id")) : null;
		
		if(id != null) {
			Users masterUser = (Users)req.getSession().getAttribute("user");
			Users targetUser = new UserService().getUser(id, true);
			UserDomainDeletePermissionService uddps = new UserDomainDeletePermissionService(masterUser, targetUser);
			
			if(uddps.deleteUser())
				chain.doFilter(request, response);
			req.setAttribute("alert", "You have no permission to delete this user!");
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
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
