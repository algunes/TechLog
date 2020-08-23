package com.TechLog.Filters;

import java.io.IOException;
import java.util.*;

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
import com.TechLog.Services.Users.UserService;

@WebFilter(urlPatterns = {"/deleteUser", "/DeleteUser"})
public class UserDomainDeletePermissionFilter implements Filter {

    public UserDomainDeletePermissionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		Boolean isDelete = ((Users)req.getSession().getAttribute("user")).getDomainPermissions().getUserDomain().is_delete();
		
		if(isDelete && req.getParameter("id") != null) {
			
			Users targetUser = new UserService().getUser(Long.parseLong(req.getParameter("id")), true);
			Users masterUser = (Users)req.getSession().getAttribute("user");
			Boolean isRemovingHimerself = Arrays.equals(masterUser.getUserAuth().getUserName(),
					targetUser.getUserAuth().getUserName());

			if(!isRemovingHimerself) {
				chain.doFilter(request, response);
			}
			else {
				req.setAttribute("user", targetUser);
				req.setAttribute("alert", "Are you kidding? You can't remove yourself, go tell the other admin!");
				RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}
			
		}
		else {
			req.setAttribute("alert", "You can't delete user!");
			RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
			rd.forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
