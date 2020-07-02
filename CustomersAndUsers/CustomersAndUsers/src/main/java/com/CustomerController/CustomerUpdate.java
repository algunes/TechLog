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

@WebServlet("/customerUpdate")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id = Long.parseLong(request.getParameter("id"));
		int job = Integer.parseInt(request.getParameter("job"));

		switch (job) {
		/*
		 * 1- Email Update 2- Phone Update 3- Address Update 4- Email Add 5- Phone
		 * Number Add 6- Address Add 7- Email Remove 8- Phone Remove 9- Address Remove
		 */
		case 1: {
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

		case 2: {
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

		case 3: {
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

		case 4: {

			request.setAttribute("id", id);
			request.setAttribute("job", job);
			request.setAttribute("placeholder", "Enter an Email");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		case 5: {

			request.setAttribute("id", id);
			request.setAttribute("job", job);
			request.setAttribute("placeholder", "Enter a Phone Number");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		case 6: {

			request.setAttribute("id", id);
			request.setAttribute("job", job);
			request.setAttribute("placeholder", "Enter an Address");

			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}

		case 7: {

			int emailIndex = Integer.parseInt(request.getParameter("emailIndex"));
			String email = request.getParameter("email");

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.removeEmail(id, emailIndex);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", email + " succesfully removed!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}

		case 8: {

			int phoneIndex = Integer.parseInt(request.getParameter("phoneIndex"));
			String phone = request.getParameter("phone");

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.removePhone(id, phoneIndex);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", phone + " succesfully removed!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}

		case 9: {

			int addressIndex = Integer.parseInt(request.getParameter("addressIndex"));
			String address = request.getParameter("address");

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.removeAddress(id, addressIndex);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", address + " succesfully removed!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case 10: {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getFirstname());
			request.setAttribute("job", 7);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
		}
		
		case 11: {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getLastname());
			request.setAttribute("job", 8);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
		}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int job = Integer.parseInt(request.getParameter("job"));
		Long id = Long.parseLong(request.getParameter("id"));

		switch (job) {
		
		/*
		 * 1- Update Email 2- Update Phone Number 3- Update Address Number 4- Add Email
		 * 5- Add Phone Number 6- Add Address 7- Update Firstname
		 */
		
		case 1: {
			String email = request.getParameter("output");
			int index = Integer.parseInt(request.getParameter("index"));

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.updateEmail(id, index, email);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", email + " succesfully updated!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case 2: {
			String phone = request.getParameter("output");
			int index = Integer.parseInt(request.getParameter("index"));

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.updatePhone(id, index, phone);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", phone + " succesfully updated!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case 3: {
			String address = request.getParameter("output");
			int index = Integer.parseInt(request.getParameter("index"));

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.updateAddress(id, index, address);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", address + " succesfully updated!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case 4: {
			String email = request.getParameter("output");

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.addEmail(id, email);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", email + " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case 5: {
			String phone = request.getParameter("output");

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.addPhone(id, phone);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", phone + " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case 6: {
			String address = request.getParameter("output");

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.addAddress(id, address);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", address + " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}
		
		case 7: {
			String firstname = request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerFirstname(id, firstname);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getFirstname() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
		}
		
		case 8: {
			String lastname = request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerLastname(id, lastname);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getLastname() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
		}

		}

	}

}
