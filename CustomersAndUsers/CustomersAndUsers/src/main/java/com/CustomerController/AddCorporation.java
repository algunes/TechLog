package com.CustomerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;
import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.Users;

@WebServlet("/addCorporation")
public class AddCorporation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AddCorporation.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String sector = request.getParameter("sector");
		Boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));
		
		
		
		Corporation corporation = new CustomerServiceImp().createCorporation(name, sector, isActive, null, new UserServiceImp().getUser(1L, false));
		
		request.setAttribute("corporation", corporation); 
		request.setAttribute("message", corporation.getName() + " is created succesfully!");
		RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp"); 
		rd.forward(request, response);
	}

}
