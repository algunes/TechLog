package com.TechLog.Filters;

import java.io.IOException;
import java.util.Arrays;

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

@WebFilter(urlPatterns = {"/updateUser", "/UpdateUser"})
public class UserDomainUpdatePermissionFilter implements Filter {

    public UserDomainUpdatePermissionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		Users masterUser = (Users)req.getSession().getAttribute("user");
		
		Boolean isUpdate = ((Users)req.getSession().getAttribute("user")).getDomainPermissions().getUserDomain().is_update();
		UserService us = new UserService();
		
			Users targetUser = req.getParameter("id") != null 
					? us.getUser(Long.parseLong(req.getParameter("id")), true)
							: null;
			Boolean isUpdatingHimerself = targetUser != null
					? Arrays.equals(masterUser.getUserAuth().getUserName(),
					targetUser.getUserAuth().getUserName())
							: null;
					
			Boolean targetUserIsAdmin = "admin".equals(us.byteToUsername(targetUser.getUserAuth().getUserName()));			
			Boolean masterUserIsAdmin = "admin".equals(us.byteToUsername(masterUser.getUserAuth().getUserName()));
			
			String job = req.getParameter("job") != null 
					? (String)req.getParameter("job")
							: "";
					
					if(isUpdate) {
						if(!masterUserIsAdmin && isUpdatingHimerself && "updateUserPermissions".equals(job)) {
							req.setAttribute("alert", "You're not authorized to update your own permissions!");
							req.setAttribute("user", targetUser);
							RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
							rd.forward(request, response);
						}
						else if(!masterUserIsAdmin && targetUserIsAdmin) {
							req.setAttribute("alert", "You can't update the top admin permissions!");
							req.setAttribute("user", targetUser);
							RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
							rd.forward(request, response);
						}
						else {
							chain.doFilter(request, response);
						}
					}

					else if(!isUpdate && isUpdatingHimerself) {
						
						switch(job) {
						case "updateEmail" : {
							chain.doFilter(request, response);
							break;
						}
						case "updateTelNumber" : {
							chain.doFilter(request, response);
							break;
						}
						case "updateAddress" : {
							chain.doFilter(request, response);
							break;
						}
						case "updateUsername" : {
							chain.doFilter(request, response);
							break;
						}
						case "updatePassword" : {
							chain.doFilter(request, response);
							break;
						}
						case "updateUserPermissions" : {
							if(masterUserIsAdmin)
								chain.doFilter(request, response);
							break;
						}
						
						default : {
							req.setAttribute("alert", "You are not authorized to update this field!");
							req.setAttribute("user", targetUser);
							RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
							rd.forward(request, response);
						}
				
						}
					}
					
					else {
						req.setAttribute("alert", "You can't update other users!");
						RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
						rd.forward(request, response);
					}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
