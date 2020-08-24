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

@WebFilter(urlPatterns = { "/deleteUser", "/DeleteUser" })
public class UserDomainDeletePermissionFilter implements Filter {

	public UserDomainDeletePermissionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		Users masterUser = (Users)req.getSession().getAttribute("user");

		Boolean isDelete = ((Users) req.getSession().getAttribute("user")).getDomainPermissions().getUserDomain()
				.is_delete();
		
		UserService us = new UserService();

		Users targetUser = req.getParameter("id") != null ? us.getUser(Long.parseLong(req.getParameter("id")), true)
				: null;
		Boolean isDeletingHimerself = targetUser != null
				? Arrays.equals(masterUser.getUserAuth().getUserName(), targetUser.getUserAuth().getUserName())
				: null;

		Boolean targetUserIsAdmin = "admin".equals(us.byteToUsername(targetUser.getUserAuth().getUserName()));
		Boolean masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));

		if(isDelete) {
			if(!masterUserIsAdmin && isDeletingHimerself) {
				req.setAttribute("alert", "You're not authorized to delete yourself!");
				req.setAttribute("user", targetUser);
				RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}
			else if(!masterUserIsAdmin && targetUserIsAdmin) {
				req.setAttribute("alert", "You can't delete the top admin!");
				req.setAttribute("user", targetUser);
				RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}
			else if(masterUserIsAdmin && targetUserIsAdmin) {
				req.setAttribute("alert", "You are top level admin, you can't delete yourself!");
				req.setAttribute("user", targetUser);
				RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}
			else {
				chain.doFilter(request, response);
			}
		}
		else {
			req.setAttribute("alert", "You have no permission to delete user!");
			req.setAttribute("user", targetUser);
			RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
