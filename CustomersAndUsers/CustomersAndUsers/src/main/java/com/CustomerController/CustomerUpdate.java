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
			request.setAttribute("job", 7);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
		}
		
		case 2: {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getLastname());
			request.setAttribute("job", 8);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
		}
		
		
		
		case 5: {
			int emailIndex = Integer.parseInt(request.getParameter("emailIndex"));
			String email = request.getParameter("email");

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", email);
			request.setAttribute("index", emailIndex);

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);

			break;
		}

		case 6: {
			int phoneIndex = Integer.parseInt(request.getParameter("phoneIndex"));
			String phone = request.getParameter("phone");

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", phone);
			request.setAttribute("index", phoneIndex);

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		case 7: {
			int addressIndex = Integer.parseInt(request.getParameter("addressIndex"));
			String address = request.getParameter("address");

			request.setAttribute("job", job);
			request.setAttribute("id", id);
			request.setAttribute("value", address);
			request.setAttribute("index", addressIndex);

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
			Customer customer = new CustomerServiceImp().updateCustomerFirstname(id, firstname, new Users());

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getFirstname() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 2: {
			String lastname = request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerLastname(id, lastname, new Users());

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getLastname() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 3: {
			String department= request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerDepartment(id, department, new Users());

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getDepartment() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 4: {
			String position= request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerPosition(id, position, new Users());

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
			Customer customer = cservice.updateCustomerEmail(id, index, email, new Users());

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
			Customer customer = cservice.updateTelNum(id, index, telNum, new Users());

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
			Customer customer = cservice.updateAddress(id, index, address, new Users());

			request.setAttribute("customer", customer);
			request.setAttribute("message", address + " succesfully updated!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}

		}

	}

}
