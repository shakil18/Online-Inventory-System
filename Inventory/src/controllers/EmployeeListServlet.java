package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.ConnectionAdapters;

public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String name = "";
		try{
			if(session.getAttribute("username") == null || session.getAttribute("username").equals("")){
				name = "";
			}
			else{
				name = session.getAttribute("username").toString();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		if(session != null){
					if(!name.equals("")){
						ConnectionAdapters ea = new ConnectionAdapters();
						request.setAttribute("emplist", ea.getAll());
						RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/empList_view.jsp");
						disp.forward(request, response);
					}
					else{
						/*Employee em = new Employee();
						em.setMsg("You have to login first");
						request.setAttribute("error", em);
						//RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/login_view.jsp");
						//disp.forward(request, response);*/
						response.sendRedirect("/inventory/LoginServlet");
					}
		}
		else{
			/*Employee em = new Employee();
			em.setMsg("You have to login first");
			request.setAttribute("error", em);*/
			response.sendRedirect("/inventory/LoginServlet");
			//RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/login_view.jsp");
			//disp.forward(request, response);
		}
	}
	
}
