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
		if (name != null && surname != null && !surname.isEmpty() && !name.isEmpty()) {
			MusteriDAO mDao = new MusteriDAO();
			musteri searchReturning = mDao.getMusteri(name, surname);
			
			request.setAttribute("musteri", searchReturning);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomers.jsp");
			rd.forward(request, response);
		}
		else {
			String warning = "You have to enter both name and surname!";
			request.setAttribute("warning", warning);
			RequestDispatcher rd = request.getRequestDispatcher("Warning.jsp");
			rd.forward(request, response);
		}
		

	}

}
