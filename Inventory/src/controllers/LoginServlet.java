package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Employee;
import adapters.ConnectionAdapters;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/login_view.jsp");
			disp.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String msg = "Your Username/Passwrod is not correct";
		HttpSession session = request.getSession(false);//don't create if it doesn't exists
		Employee emp = new Employee();
		emp.setEmpUsername(username);
		emp.setEmpPassword(pwd);
		emp.setMsg(msg);
		ConnectionAdapters ea = new ConnectionAdapters();
		String s = ea.Login(emp);
		if(s.equals(username)){
			String pos = ea.returnPosition(username);
			if(pos.equals("admin")){
				Cookie c = new Cookie("username",username);
				c.setMaxAge(60*60);
				response.addCookie(c);
				session.setAttribute("username", username);
				response.sendRedirect("/inventory/EmployeeList");
			}
			else if(pos.equals("Stock Manager")){
				
				session.setAttribute("username", username);
				response.sendRedirect("/inventory/ProductWithStock");
			}
			else if(pos.equals("saler")){
				
				session.setAttribute("username", username);
				response.sendRedirect("/inventory/productSell");
			}
		}
		else{
			request.setAttribute("error", emp);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/login_view.jsp");
			disp.forward(request, response);
		}
	}

}
