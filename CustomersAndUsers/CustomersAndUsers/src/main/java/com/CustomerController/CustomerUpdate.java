package com.CustomerController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.TechLog.Customers.Corporation;
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
		String job = request.getParameter("job");

		switch (job) {
		
		case "updateCorporationName": {
			Corporation corporation = new CustomerServiceImp().getCorporation(id, false);
			
			request.setAttribute("id", id);
			request.setAttribute("value", corporation.getName());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;			
		}
		
		case "updateCorporationSector": {
			Corporation corporation = new CustomerServiceImp().getCorporation(id, false);
			
			request.setAttribute("id", id);
			request.setAttribute("value", corporation.getSector());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;			
		}
		
		case "updateCustomerFirstname": {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getFirstname());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerLastname": {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getLastname());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
					
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerDepartment": {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getDepartment());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
					
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerPosition": {
			Customer customer = new CustomerServiceImp().getCustomer(id, true);
			
			request.setAttribute("id", customer.getCustomer_id());
			request.setAttribute("value", customer.getPosition());
			request.setAttribute("job", job);
			request.setAttribute("formAction", "customerUpdate");
					
			RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
			rd.forward(request, response);
			break;
		}
		
		
		case "updateCustomerEmail": {
		
				CustomerServiceImp cs = new CustomerServiceImp();
				int index = Integer.parseInt(request.getParameter("index"));
				Customer customer = cs.getCustomer(id, true);
				String email = customer.getEmails().get(index);
				
				HttpSession session = request.getSession(false);
				session.setAttribute("customer", customer);				

				request.setAttribute("id", id);
				request.setAttribute("job", job);
				request.setAttribute("value", email);
				request.setAttribute("formAction", "customerUpdate");

				RequestDispatcher rd = request.getRequestDispatcher("InputBox.jsp");
				rd.forward(request, response);
							
			break;
		}

		case "updateCustomerTelNum": {
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

		case "updateCustomerAddress": {
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

		String job = request.getParameter("job");
		Long id = Long.parseLong(request.getParameter("id"));
		Users user = new UserServiceImp().getUser(1L, false) ; 

		switch (job) {
		
		case "updateCorporationName": {
			
			String name = request.getParameter("output");
			Corporation corporation = new CustomerServiceImp().updateCorporationName(id, name, user);
			
			request.setAttribute("message", name + " is succesfully updated!");
			request.setAttribute("corporation", corporation);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCorporationSector": {
			
			String sector = request.getParameter("output");
			Corporation corporation = new CustomerServiceImp().updateCorporationSector(id, sector, user);
			
			request.setAttribute("message", sector + " is succesfully updated to " + corporation.getSector());
			request.setAttribute("corporaion", corporation);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCorporation.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerFirstname": {
			String firstname = request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerFirstname(id, firstname, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getFirstname() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerLastname": {
			String lastname = request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerLastname(id, lastname, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getLastname() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerDepartment": {
			String department= request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerDepartment(id, department, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getDepartment() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerPosition": {
			String position= request.getParameter("output");
			Customer customer = new CustomerServiceImp().updateCustomerPosition(id, position, user);

			request.setAttribute("customer", customer);
			request.setAttribute("message", customer.getPosition() + " is updated successfully!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
			rd.forward(request, response);
			break;
		}
		
		case "updateCustomerEmail": {
			
			String newEmail = request.getParameter("output");
			String oldEmail = request.getParameter("oldValue");
			
			HttpSession session = request.getSession(false);
			
			CustomerServiceImp cservice = new CustomerServiceImp();
			Customer customer = cservice.updateCustomerEmail(oldEmail, newEmail, session, user);
			
			if(customer != null ) {
				
				request.setAttribute("customer", customer);
				request.setAttribute("message", "Email succesfully updated to " + newEmail);
				RequestDispatcher rd = request.getRequestDispatcher("ShowCustomer.jsp");
				rd.forward(request, response);
				if(session.getAttribute("customer") == null) {
				System.out.println("No customer object");
				}
				else {
					System.out.println("Customer object exist");
				}
				if(session.getAttribute("user") == null) {
					System.out.println("No user object");
					}
					else {
						System.out.println("User object exist");
					}			
			}
			
			else {
				request.setAttribute("alert", "Email update failed! Someone might be deleted or updated this customer's data just before you! Please check the customer again.");
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
			
			break;
		}

		case "updateCustomerTelNum": {
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

		case "updateCustomerAddress": {
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
