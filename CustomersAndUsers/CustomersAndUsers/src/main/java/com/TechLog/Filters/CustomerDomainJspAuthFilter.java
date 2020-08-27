package com.TechLog.Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.TechLog.Entity.Users.Users;
import com.Techlog.Services.CustomerPermissions.CustomerDomainCreatePermissionService;


public class CustomerDomainJspAuthFilter implements Filter {


    public CustomerDomainJspAuthFilter() {
    }


	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		Users masterUser = (Users)req.getSession(false).getAttribute("user");
		
		CustomerDomainCreatePermissionService cdcps = new CustomerDomainCreatePermissionService(masterUser);
		
		if(cdcps.createCustomer()) {
			chain.doFilter(request, response);
		}
		else {
			req.setAttribute("alert", "You have no permission to add corporation!");
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
