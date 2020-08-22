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
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/UpdateCustomer" , "/customerUpdate" 
		,"/GetCustomer" ,"/getCustomer" 
		,"/DeleteCustomer" , "/deleteCustomer"
		,"/createCustomer", "/CreateCustomer"
		,"/user", "/UserController"
		,"/searchCustomer", "/SearchCustomer"})
public class PublicRestrictedServletsFilter implements Filter {

    public PublicRestrictedServletsFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession(true);
		
		if (session.getAttribute("user") != null) {
			chain.doFilter(request, response);
		}
		else {
			req.setAttribute("alert", "Please Sign in first!");
			RequestDispatcher rd = req.getRequestDispatcher("UserLogin.jsp");
			rd.forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
