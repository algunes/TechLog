package com.Filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.Users;

@WebFilter(urlPatterns = { "/user","/UserController"})
public class UserAuthorizationFilter implements Filter {


    public UserAuthorizationFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		HttpSession session = req.getSession(false);
		
		
		String job = (req.getParameter("job") != null ? req.getParameter("job") : null);
		Long id = (req.getParameter("id") != null ? Long.parseLong(req.getParameter("id")) : null);
		
		Users user = (id != null ? new UserServiceImp().getUser(id, true) : null);
		Users sessionUser = ((Users)session.getAttribute("user"));
		
		boolean isAdmin = (sessionUser != null ? sessionUser.getRole().equals("Admin") : false);
		boolean isSelfSubject = (user != null ? Arrays.equals(user.getUserAuth().getUserName(),
				sessionUser.getUserAuth().getUserName()) : false); 
		
		switch (job) {
		
		case "updateUsername" : {
			
			if (!isAdmin && !isSelfSubject) {
				req.setAttribute("alert", "You are not Authorized to change the Username!");
				req.setAttribute("user", user);
				RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}

			else {
				chain.doFilter(request, response);
			}
			break;
		}
		
case "updateFirstname" : {
			
			if (!isAdmin && !isSelfSubject) {
				req.setAttribute("alert", "You are not Authorized to change the Firstname!");
				req.setAttribute("user", user);
				RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
				rd.forward(request, response);
			}

			else {
				chain.doFilter(request, response);
			}
			break;
		}

case "updateLastname" : {
	
	if (!isAdmin && !isSelfSubject) {
		req.setAttribute("alert", "You are not Authorized to change the Lastname!");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
		rd.forward(request, response);
	}

	else {
		chain.doFilter(request, response);
	}
	break;
}

case "updateDepartment" : {
	
	if (!isAdmin && !isSelfSubject) {
		req.setAttribute("alert", "You are not Authorized to change the Department!");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
		rd.forward(request, response);
	}

	else {
		chain.doFilter(request, response);
	}
	break;
}

case "updatePosition" : {
	
	if (!isAdmin && !isSelfSubject) {
		req.setAttribute("alert", "You are not Authorized to change the Position!");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
		rd.forward(request, response);
	}

	else {
		chain.doFilter(request, response);
	}
	break;
}

case "updateRole" : {
	
	if (!isAdmin) {
		req.setAttribute("alert", "You are not Authorized to change the Role!");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
		rd.forward(request, response);
	}

	else {
		chain.doFilter(request, response);
	}
	break;
}

case "updateEmail" : {
	
	if (!isAdmin && !isSelfSubject) {
		req.setAttribute("alert", "You are not Authorized to change the Email!");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
		rd.forward(request, response);
	}

	else {
		chain.doFilter(request, response);
	}
	break;
}

case "updateTelNumber" : {
	
	if (!isAdmin && !isSelfSubject) {
		req.setAttribute("alert", "You are not Authorized to change the Tel. Number!");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
		rd.forward(request, response);
	}

	else {
		chain.doFilter(request, response);
	}
	break;
}

case "updateAddress" : {
	
	if (!isAdmin && !isSelfSubject) {
		req.setAttribute("alert", "You are not Authorized to change the Address!");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
		rd.forward(request, response);
	}

	else {
		chain.doFilter(request, response);
	}
	break;
}

case "removeUser" : {
	
	if (isAdmin) {
		if (!(isAdmin && isSelfSubject)) {
			chain.doFilter(request, response);
			break;
		}
		else {
			req.setAttribute("alert", "You are not Authorized to delete yourself!");
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;
		}
	}

	else {
		if (isAdmin && isSelfSubject) {
			chain.doFilter(request, response);
			break;
		}
		else {
			req.setAttribute("alert", "You are not Authorized to delete yourself or other users!");
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
			break;
		}
	}
	
}

case "addUser" : {
	
	if (!isAdmin) {
		List<Users> users = new UserServiceImp().getAllUsersList();
		req.setAttribute("alert", "You are not Authorized to create an user!");
		req.setAttribute("users", users);
		RequestDispatcher rd = req.getRequestDispatcher("UserList.jsp");
		rd.forward(request, response);
	}

	else {
		chain.doFilter(request, response);
	}
	break;
}

case "updatePassword" : {
	
	if (!isAdmin && !isSelfSubject) {
		req.setAttribute("alert", "You are not authorized to change this password!");
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("ShowUser.jsp");
		rd.forward(request, response);
	}

	else {
		chain.doFilter(request, response);
	}
	break;
	
}

		
		default :
			chain.doFilter(request, response);
		}
		
					
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
