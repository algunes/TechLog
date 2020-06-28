package com.CustomerController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Corporation;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;

@WebServlet("/getCorporation")
public class GetCorporation extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") == null) {
		List<Corporation> corporations = new CustomerServiceImp().getAllCorporations();
		request.setAttribute("corporations", corporations);
		RequestDispatcher rd = request.getRequestDispatcher("CorporationList.jsp");
		rd.forward(request, response);
		}
		else {
			Long id = Long.parseLong(request.getParameter("id"));
			Corporation corporation = new Corporation();
			
			corporation = new CustomerServiceImp().getCorporation(id, true);
			request.setAttribute("corporation", corporation);
			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
			rd.forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
	}

}
