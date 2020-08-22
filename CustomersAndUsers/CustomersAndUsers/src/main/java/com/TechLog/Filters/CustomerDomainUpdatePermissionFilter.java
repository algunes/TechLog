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

@WebFilter(urlPatterns = {"/updateCustomer", "/UpdateCustomer"})
public class CustomerDomainUpdatePermissionFilter implements Filter {

    public CustomerDomainUpdatePermissionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		if(((Users)req.getSession().getAttribute("user")).getDomainPermissions().getCustomerDomain().is_update())
			chain.doFilter(request, response);
		req.setAttribute("alert", "You shouldn't be there!");
		RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
		rd.forward(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
