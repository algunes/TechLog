package com.TechLog.CustomerControllers;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Corporations.Corporation;
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
		
		request.getSession(false).setAttribute("customer", new CustomerServiceImp().getCustomer(id, true));

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

		request.getSession(false).setAttribute("customer", new CustomerServiceImp().getCustomer(id, true));
		
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
		
		request.getSession(false).setAttribute("customer", new CustomerServiceImp().getCustomer(id, true));

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
    		Users user = (Users)request.getSession(false).getAttribute("user") ;
    		
    		
    		switch(job) {
    		
    		case "addCustomer": {

    			Customer customer = new CustomerServiceImp().createCustomer(request);
   			
    			request.setAttribute("customer", customer); 
    			request.setAttribute("message", customer.getFirstname() + " " + customer.getLastname() + " created succesfully!");
    			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp"); 
    			rd.forward(request, response);
    			break;
    		
    		}
    		
    		case "addCorporation" : {
    			
    			request.getSession(false).setAttribute("corporationName", request.getParameter("name"));
    			request.getSession(false).setAttribute("corporationSector", request.getParameter("sector"));
    			request.getSession(false).setAttribute("corporationIsActive", Boolean.parseBoolean(request.getParameter("isActive")));
    			
    			Corporation corporation = new CustomerServiceImp().createCorporation(request.getSession(false));
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
    		    		
    		request.getSession(false).setAttribute("newEmail", request.getParameter("output"));

			Customer customer = new CustomerServiceImp().addEmail(request.getSession(false));
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
			
			request.getSession(false).setAttribute("newTelNum", request.getParameter("output"));

			Customer customer = new CustomerServiceImp().addTelNum(request.getSession(false));
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
			
			request.getSession(false).setAttribute("newAddress", request.getParameter("output"));

			Customer customer = new CustomerServiceImp().addAddress(request.getSession(false));
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
    		 	
	}

}
}
