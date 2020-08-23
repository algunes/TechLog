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

		
			Users targetUser = req.getParameter("id") != null 
					? new UserService().getUser(Long.parseLong(req.getParameter("id")), true)
							: null;
			Boolean isUpdatingHimerself = targetUser != null
					? Arrays.equals(masterUser.getUserAuth().getUserName(),
					targetUser.getUserAuth().getUserName())
							: null;
			
			Boolean isAdmin = masterUser.getDomainPermissions().getUserDomain().is_create()
							&& masterUser.getDomainPermissions().getUserDomain().is_read()
							&& masterUser.getDomainPermissions().getUserDomain().is_update()
							&& masterUser.getDomainPermissions().getUserDomain().is_delete()
							== true ? true : false;
			
			String job = req.getParameter("job") != null 
					? (String)req.getParameter("job")
							: "";
					
					if(isUpdate) {
						if(isUpdatingHimerself && "updateUserPermissions".equals(job)) {
							req.setAttribute("alert", "You're not authorized to update your own permissions!");
							req.setAttribute("user", targetUser);
							RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
							rd.forward(request, response);
						}
						else if("admin".equals(new UserService().byteToUsername(targetUser.getUserAuth().getUserName()))) {
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
						}
						case "updateTelNumber" : {
							chain.doFilter(request, response);
						}
						case "updateAddress" : {
							chain.doFilter(request, response);
						}
						case "updateUsername" : {
							chain.doFilter(request, response);
						}
						case "updatePassword" : {
							chain.doFilter(request, response);
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
