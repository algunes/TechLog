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
import com.Techlog.Services.CustomerPermissions.CustomerDomainUpdatePermissionService;

@WebFilter(urlPatterns = {"/customerUpdate", "/UpdateCustomer"})
public class CustomerDomainUpdatePermissionFilter implements Filter {

    public CustomerDomainUpdatePermissionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		Users masterUser = (Users)req.getSession().getAttribute("user");
		
		CustomerDomainUpdatePermissionService cdups = new CustomerDomainUpdatePermissionService(masterUser);
		if(cdups.updateCustomer() && req.getParameter("job") != null && req.getParameter("id") != null) {
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
