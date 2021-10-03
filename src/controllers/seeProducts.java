package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.ConnectionAdapters;
import models.Product;

public class seeProducts extends HttpServlet {
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
				request.setAttribute("catlist", ea.getAllCategoryName());
				request.setAttribute("prolist", ea.getAllProduct());
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/product_view.jsp");
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
		Product pd = new Product();
		request.setAttribute("catlist", ea.getAllCategoryName());
		int a =  ea.returnCategoryId(request.getParameter("cate"));
		ArrayList<Product> s = ea.searchCategory(a);
		if(s.isEmpty()){
			pd.setMsg("Not Found");
			request.setAttribute("searchs", pd);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/product_view.jsp");
			disp.forward(request, response);
		}
		else{
			request.setAttribute("prolist", s);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/product_view.jsp");
			disp.forward(request, response);
		}
	}
}
