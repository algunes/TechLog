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

@WebFilter(urlPatterns = {"/readUser", "/ReadUser"})
public class UserDomainReadPermissionFilter implements Filter {

    public UserDomainReadPermissionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
				
			Boolean isRead = ((Users)req.getSession().getAttribute("user")).getDomainPermissions().getUserDomain().is_read();
			Users masterUser = (Users)req.getSession().getAttribute("user");
			
				Users targetUser = req.getParameter("id") != null 
						? new UserService().getUser(Long.parseLong(req.getParameter("id")), true)
								: null;
				Boolean isReadingHimerself = targetUser != null
						? Arrays.equals(masterUser.getUserAuth().getUserName(),
						targetUser.getUserAuth().getUserName())
								: null;

			if(isRead) {
				chain.doFilter(request, response);
				}

			else if(!isRead && isReadingHimerself) {
				chain.doFilter(request, response);
			}
			
			else {
				req.setAttribute("alert", "You can't reach other users!");
				RequestDispatcher rd = req.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
		}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
