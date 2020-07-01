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

		/*
		 * 1- Email Update 2- Phone Update 3- Address Update 4- Email Add 5- Phone
		 * Number Add 6- Address Add 7- Email Remove 8- Phone Remove 9- Address Remove
		 */

		switch (job) {
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
			request.setAttribute("placeholder", "Enter a Phone");

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
		
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int job = Integer.parseInt(request.getParameter("job"));

		switch (job) {
		case 1: {
			Long id = Long.parseLong(request.getParameter("id"));
			String email = request.getParameter("output");
			int index = Integer.parseInt(request.getParameter("index"));

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.updateEmail(id, index, email);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", email + " succesfully modified!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case 2: {
			Long id = Long.parseLong(request.getParameter("id"));
			String phone = request.getParameter("output");
			int index = Integer.parseInt(request.getParameter("index"));

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.updatePhone(id, index, phone);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", phone + " succesfully modified!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case 3: {
			Long id = Long.parseLong(request.getParameter("id"));
			String address = request.getParameter("output");
			int index = Integer.parseInt(request.getParameter("index"));

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.updateAddress(id, index, address);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", address + " succesfully modified!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		case 4: {
			Long id = Long.parseLong(request.getParameter("id"));
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
			Long id = Long.parseLong(request.getParameter("id"));
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
			Long id = Long.parseLong(request.getParameter("id"));
			String address = request.getParameter("output");

			CustomerServiceImp cservice = new CustomerServiceImp();
			cservice.addAddress(id, address);
			Customer customer = cservice.getCustomer(id, true);

			request.setAttribute("customer", customer);
			request.setAttribute("message", address+ " succesfully added!");
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);

			break;
		}

		}

	}

}
