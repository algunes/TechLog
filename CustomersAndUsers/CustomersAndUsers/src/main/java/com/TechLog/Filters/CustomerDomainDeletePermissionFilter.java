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
import com.Techlog.Services.CustomerPermissions.CustomerDomainDeletePermissionService;

@WebFilter(urlPatterns = {"/deleteCustomer", "/DeleteCustomer"})
public class CustomerDomainDeletePermissionFilter implements Filter {
	
    public CustomerDomainDeletePermissionFilter() {
    }

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		Users masterUser = (Users)req.getSession(false).getAttribute("user");
		
		CustomerDomainDeletePermissionService cddps = new CustomerDomainDeletePermissionService(masterUser);
		if(cddps.deleteCustomer() && req.getParameter("job") != null && req.getParameter("id") != null) {
			chain.doFilter(request, response);
		}
		else {
			req.setAttribute("alert", "You have no permission to do this!");
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
