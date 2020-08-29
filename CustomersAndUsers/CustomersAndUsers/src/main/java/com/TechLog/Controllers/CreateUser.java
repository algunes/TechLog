package com.TechLog.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Entity.Permissions.DomainPermissions;
import com.TechLog.Entity.Permissions.DomainPermissionsBuilder;
import com.TechLog.Entity.Users.UserBuilder;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Users.UserService;

@WebServlet("/createUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("AddUser.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String department = request.getParameter("department");
		String position = request.getParameter("position");
		String email = request.getParameter("email");
		String telNum = request.getParameter("telNumber");
		String address = request.getParameter("address");
		String username = request.getParameter("username");
		String password = request.getParameter("up");

		Boolean cdCreate = Boolean.parseBoolean(request.getParameter("customerDomainCreate"));
		Boolean cdRead = Boolean.parseBoolean(request.getParameter("customerDomainRead"));
		Boolean cdUpdate = Boolean.parseBoolean(request.getParameter("customerDomainUpdate"));
		Boolean cdDelete = Boolean.parseBoolean(request.getParameter("customerDomainDelete"));

		Boolean pdCreate = Boolean.parseBoolean(request.getParameter("productDomainCreate"));
		Boolean pdRead = Boolean.parseBoolean(request.getParameter("productDomainRead"));
		Boolean pdUpdate = Boolean.parseBoolean(request.getParameter("productDomainUpdate"));
		Boolean pdDelete = Boolean.parseBoolean(request.getParameter("productDomainDelete"));

		Boolean sdCreate = Boolean.parseBoolean(request.getParameter("stockDomainCreate"));
		Boolean sdRead = Boolean.parseBoolean(request.getParameter("stockDomainRead"));
		Boolean sdUpdate = Boolean.parseBoolean(request.getParameter("stockDomainUpdate"));
		Boolean sdDelete = Boolean.parseBoolean(request.getParameter("stockDomainDelete"));

		DomainPermissions dp = new DomainPermissionsBuilder().setCustomerDomain(cdCreate, cdRead, cdUpdate, cdDelete)
				.setProductDomain(pdCreate, pdRead, pdUpdate, pdDelete)
				.setStockDomain(sdCreate, sdRead, sdUpdate, sdDelete).build();

		Users user = new UserBuilder().setFirstname(firstname).setLastname(lastname).setDepartment(department)
				.setPosition(position).setDomainPermissions(dp).setEmail(email).setTelNum(telNum).setAddress(address)
				.setTotalSales(null).setUserName(username).setPassword(password).build();
		if (user != null) {
			request.setAttribute("user", user);
			request.setAttribute("username", new UserService().byteToUsername(user.getUserAuth().getUserName()));
			request.setAttribute("message", "User created!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("alert", "User Creation is failed! Maybe you need to choose another username!");
			RequestDispatcher rd = request.getRequestDispatcher("AddUser.jsp");
			rd.forward(request, response);
		}

	}

}
