package com.CustomerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Corporation;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;

@WebServlet("/addCorporation")
public class AddCorporation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("AddCorporation.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String corporationName = request.getParameter("corporationName");
		
		Corporation corporation = new Corporation();
		corporation.setName(corporationName);
		CustomerServiceImp cs = new CustomerServiceImp();
		Long id = cs.createCorporation(corporation);
		
		corporation = cs.getCorporation(id, false);
		request.setAttribute("corporation", corporation); 
		RequestDispatcher rd = request.getRequestDispatcher("SuccessScreen.jsp"); 
		rd.forward(request, response);
	}

}
