package com.techlog.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techlog.web.dao.MusteriDAO;
import com.techlog.web.model.musteri;

@WebServlet("/searchCustomer")
public class SearchCustomerNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("ad");
		String surname = request.getParameter("soyad");
		String company = request.getParameter("company");
		String telNumber = request.getParameter("tel");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		int searchType = Integer.parseInt(request.getParameter("searchType"));
		
		switch (searchType) {
		  case 1:
			  MusteriDAO mDao = new MusteriDAO();
			  musteri searchReturning = mDao.getMusteri(name, surname);
			  request.setAttribute("musteri", searchReturning);
			  RequestDispatcher rd = request.getRequestDispatcher("ShowCustomers.jsp");
			  rd.forward(request, response);
		    break;
		  case 2:
		    System.out.println("Tuesday");
		    break;
		  case 3:
		    System.out.println("Wednesday");
		    break;
		  case 4:
		    System.out.println("Thursday");
		    break;
		}
		
		if (name != null && surname != null && !surname.isEmpty() && !name.isEmpty()) {
			
			
			if (searchReturning.getKisiNo() != 0) {
				
			}
			else {
				request.setAttribute("warning", "No Customer Found!!");
				RequestDispatcher rd = request.getRequestDispatcher("Warning.jsp");
				rd.forward(request, response);
			}
			
		}
		
		else if (company != null) {
			request.setAttribute("warning", searchType);
			RequestDispatcher rd2 = request.getRequestDispatcher("Warning.jsp");
			rd2.forward(request, response);
		}
		else {
			request.setAttribute("warning", "You have to enter both name and surname!");
			RequestDispatcher rd2 = request.getRequestDispatcher("Warning.jsp");
			rd2.forward(request, response);
		}		

	}

}
