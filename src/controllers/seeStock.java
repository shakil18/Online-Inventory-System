package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.ConnectionAdapters;


public class seeStock extends HttpServlet {
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
				request.setAttribute("stolist", ea.getAllStock());
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/stock_view.jsp");
				disp.forward(request, response);
			}
			else{
				response.sendRedirect("/inventory/LoginServlet");
			}
		}
		else{
			response.sendRedirect("/inventory/LoginServlet");
		}
	}
}
