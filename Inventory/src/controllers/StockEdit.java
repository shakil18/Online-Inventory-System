package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.ConnectionAdapters;
import models.Stock;

public class StockEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id;
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
				id = Integer.parseInt(request.getParameter("id"));
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/stockEdit_view.jsp");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnectionAdapters ea = new ConnectionAdapters();
		Stock st = new Stock();
		String s = request.getParameter("amount");
		if(s.equals("")){
			st.setMsg("You have to put a amount");
			request.setAttribute("s", st);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/stockEdit_view.jsp");
			disp.forward(request, response);
		}
		else{
			int bl = Integer.parseInt(s);
			ea.updateStock(bl,id);
			response.sendRedirect("/inventory/ProductWithStock");
		}
	}

}
