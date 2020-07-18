package com.CustomerController;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Corporation;
import com.TechLog.Customers.Customer;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;
import com.TechLog.Users.Users;

@WebServlet("/addCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String job = request.getParameter("job");
		
		
		switch(job) {
		
		case "addCustomer": {
			
			List<Corporation> corporations = new CustomerServiceImp().getAllCorporations();
			request.setAttribute("corporations", corporations);
			RequestDispatcher rd = request.getRequestDispatcher("AddCustomer.jsp");
			rd.forward(request, response);	
			break;
		}
		
		case "addCorporation": {
			response.sendRedirect("AddCorporation.jsp");
			break;
		}
		
	case "addCustomerEmail": {
		Long id = Long.parseLong(request.getParameter("id"));
		
		request.setAttribute("id", id);
		request.setAttribute("job", job);
		request.setAttribute("formAction", "addCustomer");
		request.setAttribute("placeholder", "Enter an Email");

		RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
		rd.forward(request, response);
		break;
	}

	case "addCustomerTelNum": {
		Long id = Long.parseLong(request.getParameter("id"));

		request.setAttribute("id", id);
		request.setAttribute("job", job);
		request.setAttribute("formAction", "addCustomer");
		request.setAttribute("placeholder", "Enter a Phone Number");

		RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
		rd.forward(request, response);
		break;
	}

	case "addCustomerAddress": {
		Long id = Long.parseLong(request.getParameter("id"));

		request.setAttribute("id", id);
		request.setAttribute("job", job);
		request.setAttribute("formAction", "addCustomer");
		request.setAttribute("placeholder", "Enter an Address");

		RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
		rd.forward(request, response);
		break;
	}
	
	case "addCustomerIntoACorporation": {
		Corporation corporation = new CustomerServiceImp().getCorporation(Long.parseLong(request.getParameter("id")), false);
		request.setAttribute("job", job);
		request.setAttribute("corporation", corporation);
		
		RequestDispatcher rd = request.getRequestDispatcher("AddCustomer.jsp");
		rd.forward(request, response);
		break;
	}
		}
		
			
	}
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		String job = request.getParameter("job");
    		Users user = (Users)request.getSession().getAttribute("user") ;
    		
    		
    		switch(job) {
    		
    		case "addCustomer": {
   			
    			String firstname = request.getParameter("firstname");
    			String lastname =request.getParameter("lastname");
    			String department = request.getParameter("department");
    			String position = request.getParameter("position");
    			String email = request.getParameter("email");
    			String telNum = request.getParameter("telNum");
    			String address = request.getParameter("address");
    			Long corpId = Long.parseLong(request.getParameter("corporation"));
    			
    			CustomerServiceImp cs = new CustomerServiceImp();
    			Customer customer = cs.createCustomer(firstname, lastname, corpId, department, position, email, telNum, address, user);
   			
    			request.setAttribute("customer", customer); 
    			request.setAttribute("message", customer.getFirstname() + " " + customer.getLastname() + " created succesfully!");
    			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp"); 
    			rd.forward(request, response);
    			break;
    		
    		}
    		
    		case "addCorporation" : {
    			
    			String name = request.getParameter("name");
    			String sector = request.getParameter("sector");
    			Boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));
    			
    			Corporation corporation = new CustomerServiceImp().createCorporation(name, sector, isActive, null, user);
    			
    			request.setAttribute("corporation", corporation); 
    			request.setAttribute("message", corporation.getName() + " is created succesfully!");
    			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp"); 
    			rd.forward(request, response);
    			break;
    		}
    		
    	case "addCustomerEmail": {
    		Long id = Long.parseLong(request.getParameter("id"));
    		String email = request.getParameter("output");

			Customer customer = new CustomerServiceImp().addEmail(id, email, user);
			
			request.setAttribute("customer", customer);
			request.setAttribute("message", email + " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}

		case "addCustomerTelNum": {
			Long id = Long.parseLong(request.getParameter("id"));
			String telNum = request.getParameter("output");

			Customer customer = new CustomerServiceImp().addTelNum(id, telNum, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", telNum + " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case "addCustomerAddress": {
			Long id = Long.parseLong(request.getParameter("id"));
			String address = request.getParameter("output");

			Customer customer = new CustomerServiceImp().addAddress(id, address, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", address + " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}
    		 	
	}

}
}
