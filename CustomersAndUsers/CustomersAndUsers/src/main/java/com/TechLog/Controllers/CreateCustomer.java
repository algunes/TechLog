package com.TechLog.Controllers;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Entity.Corporations.Corporation;
import com.TechLog.Entity.Customers.Customer;
import com.TechLog.Entity.Users.Users;
import com.TechLog.Services.Corporation.CorporationPostService;
import com.TechLog.Services.Corporation.CorporationPreService;
import com.TechLog.Services.Customer.CustomerPreService;

@WebServlet("/createCustomer")
public class CreateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String job = request.getParameter("job") != null ? request.getParameter("job") : "";
		
		
		switch(job) {
		
		case "addCustomer": {
			
			List<Corporation> corporations = new CorporationPostService().getAllCorporations();
			request.setAttribute("corporations", corporations);
			RequestDispatcher rd = request.getRequestDispatcher("AddCustomer.jsp");
			rd.forward(request, response);	
			break;
		}
		
		case "addCorporation": {
			RequestDispatcher rd = request.getRequestDispatcher("AddCorporation.jsp");
			rd.forward(request, response);	
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
		Corporation corporation = new CorporationPostService().getCorporation(Long.parseLong(request.getParameter("id")), false);
		request.setAttribute("job", job);
		request.setAttribute("corporation", corporation);
		
		RequestDispatcher rd = request.getRequestDispatcher("AddCustomer.jsp");
		rd.forward(request, response);
		break;
	}
	
	default : {
		response.sendRedirect("index.jsp");
		break;
	}
		}
		
			
	}
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		String job = request.getParameter("job") != null ? request.getParameter("job") : "";
    		Users user = (Users)request.getSession(false).getAttribute("user") ;
    		
    		
    		switch(job) {
    		
    		
    		
    		case "addCustomer": {
    			
    			String firstname = request.getParameter("firstname");
    			String lastname = request.getParameter("lastname");
    			Long corporationId = Long.parseLong(request.getParameter("corporation"));
    			String department = request.getParameter("department");
    			String position = request.getParameter("position");
    			String email = request.getParameter("email");
    			String telNum = request.getParameter("telNum");
    			String address = request.getParameter("address");
    			
    			Customer customer = new CustomerPreService().createCustomer(
    					firstname,
    					lastname,
    					corporationId,
    					department,
    					position,
    					email,
    					telNum,
    					address,
    					user);
   			
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
    			
    			Corporation corporation = new CorporationPreService().createCorporation(name, sector, isActive, user);
    			if(corporation != null) {
    				request.setAttribute("corporation", corporation); 
        			request.setAttribute("message", corporation.getName() + " created!");
        			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp"); 
        			rd.forward(request, response);
    			}
    			else {
    				request.setAttribute("alert", "Corporation creation failed! Corporation name must be unique. Please check the Corporation List.");
        			RequestDispatcher rd = request.getRequestDispatcher("Error.jsp"); 
        			rd.forward(request, response);
    			}
    			
    			break;
    		}
    		
    	case "addCustomerEmail": {
    		    		
    		String newEmail = request.getParameter("output");
    		Long id = Long.parseLong(request.getParameter("id"));

			Customer customer = new CustomerPreService().addEmail(id, newEmail, user);
			if(customer != null) {
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Email added!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("customer", request.getSession(false).getAttribute("customer"));
				request.setAttribute("alert", "Email fail to add! Please enter a unique email!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			
			break;
		}

		case "addCustomerTelNum": {
			
			String newTelNum = request.getParameter("output");
    		Long id = Long.parseLong(request.getParameter("id"));
    		
			Customer customer = new CustomerPreService().addTelNum(id, newTelNum, user);
			if(customer != null) {
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Tel. Num. added!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("customer", request.getSession(false).getAttribute("customer"));
				request.setAttribute("alert", "Tel. Num. fail to add! Please enter a unique tel. num.!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			
			break;
		}

		case "addCustomerAddress": {
			
			String newAddress = request.getParameter("output");
    		Long id = Long.parseLong(request.getParameter("id"));
    		
			Customer customer = new CustomerPreService().addAddress(id, newAddress, user);
			if(customer != null) {
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Address added!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("customer", request.getSession(false).getAttribute("customer"));
				request.setAttribute("alert", "Address fail to add! Please enter a unique address!");
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
			}
			
			break;
		}
		
		default : {
			response.sendRedirect("index.jsp");
			break;
		}
    		 	
	}

}
}
