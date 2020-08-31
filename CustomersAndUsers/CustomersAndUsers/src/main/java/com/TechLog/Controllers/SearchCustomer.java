package com.TechLog.Controllers;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Services.Pagination.Pagination;
import com.TechLog.Services.Search.SearchDTO;
import com.TechLog.Services.Search.SearchService;

@WebServlet("/searchCustomer")
public class SearchCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("SearchCustomer.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String keyword = request.getParameter("keyword");
		
		Pattern regex = Pattern.compile("[^A-Za-z0-9ğüşöçİĞÜŞÖÇ]");
		Matcher matcher = regex.matcher(keyword);
		
		if(matcher.find()) {
			request.setAttribute("alert", keyword + " - Your keyword contains invalid characters, please use only alphanumericals!");
			RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp"); 
			rd.forward(request, response);
		}
		else {
			Integer first = request.getParameter("first") != null ? 
					Integer.parseInt(request.getParameter("first")) : 0;
			Integer max = 10;
			SearchDTO sdto = new SearchService().searchByCustomerName(keyword, first, max);
			Pagination pagination = new Pagination(first, max, sdto.getNumberOfResult().longValue());
			
			request.setAttribute("pagination", pagination);
			request.setAttribute("customers", sdto.getCustomers());
			request.setAttribute("keyword", keyword);
			RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp"); 
			rd.forward(request, response); 
		}
	}

}
