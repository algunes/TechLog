package com.CustomerController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TechLog.Customers.Customer;
import com.TechLog.Services.CustomerImp.CustomerServiceImp;
import com.TechLog.Services.UserImp.UserServiceImp;
import com.TechLog.Users.Users;

@WebServlet("/customerUpdate")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		int job = Integer.parseInt(request.getParameter("job"));

		switch (job) {
		/*
		 * 1- Update customer firstname
		 * 2- Update customer lastname
		 * 3- update customer department
		 * 4- update customer position
		 * 5- update customer email 
		 * 6- update customer tel. number 
		 * 7- update customer address  
		 * 
		 */
		
		case 1: {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getFirstname());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 2: {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getLastname());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
					
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 3: {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getDepartment());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
					
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 4: {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getPosition());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
					
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		
		case 5: {
			int emailIndex = Integer.parseInt(request.getParameter("index"));
			String email = new CustomerServiceImp()
					.getCustomer(id, true)
					.getEmails()
					.get(emailIndex);

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", email);
			request.setAttribute("index", emailIndex);
			request.setAttribute("formAction", "customerUpdate");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		case 6: {
			int telNumIndex = Integer.parseInt(request.getParameter("index"));
			String telNum = new CustomerServiceImp()
					.getCustomer(id, true)
					.getTelNums()
					.get(telNumIndex);

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", telNum);
			request.setAttribute("index", telNumIndex);
			request.setAttribute("formAction", "customerUpdate");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		case 7: {
			int addressIndex = Integer.parseInt(request.getParameter("index"));
			String address = new CustomerServiceImp()
					.getCustomer(id, true)
					.getAddresses()
					.get(addressIndex);

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", address);
			request.setAttribute("index", addressIndex);
			request.setAttribute("formAction", "customerUpdate");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int job = Integer.parseInt(request.getParameter("job"));
		Long id = Long.parseLong(request.getParameter("id"));
		Users user = new UserServiceImp().getUser(1L, false) ; 

		switch (job) {
		
		/*
		 * 1- Update customer firstname 
		 * 2- Update customer lastname 
		 * 3- Update customer department 
		 * 4- Update customer position 
		 * 5- Update customer email
		 * 6- Update customer tel. number
		 * 7- Update customer address 
		 */
		
		case 1: {
			String firstname = request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerFirstname(id, firstname, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getFirstname() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 2: {
			String lastname = request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerLastname(id, lastname, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getLastname() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 3: {
			String department= request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerDepartment(id, department, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getDepartment() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 4: {
			String position= request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerPosition(id, position, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getDepartment() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 5: {
			int index = Integer.parseInt(request.getParameter("index"));
			String email = request.getParameter("output");

			CustomerServiceImp cservice = new CustomerServiceImp();
			Customer customer = cservice.updateCustomerEmail(id, index, email, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", email + " succesfully updated!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}

		case 6: {
			String telNum = request.getParameter("output");
			int index = Integer.parseInt(request.getParameter("index"));

			CustomerServiceImp cservice = new CustomerServiceImp();
			Customer customer = cservice.updateTelNum(id, index, telNum, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", telNum + " succesfully updated!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}

		case 7: {
			String address = request.getParameter("output");
			int index = Integer.parseInt(request.getParameter("index"));

			CustomerServiceImp cservice = new CustomerServiceImp();
			Customer customer = cservice.updateAddress(id, index, address, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", address + " succesfully updated!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}

		}

	}

}
