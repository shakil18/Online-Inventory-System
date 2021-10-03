package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.ConnectionAdapters;
import models.Category;
import models.Product;

public class addNewProduct extends HttpServlet {
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
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/addNewProduct_view.jsp");
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
		Category cat = new Category();
		pd.setProductName(request.getParameter("productName"));
		pd.setProductPrice(request.getParameter("productPrice"));
		cat.setCategoryName(request.getParameter("cate"));
		int a =  ea.returnCategoryId(request.getParameter("cate"));
		if(request.getParameter("productName").equals("") || request.getParameter("productPrice").equals("")){
			pd.setMsg("You have to fill all the fields");
			request.setAttribute("inputs", pd);
			request.setAttribute("catlist", ea.getAllCategoryName());
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/addNewProduct_view.jsp");
			disp.forward(request, response);
		}
		else{
			ea.insert(pd, a);

			int productId = ea.returnRecentProduct();
			Product pds = ea.get(productId);
			ea.insertIntoStock(pds);

			response.sendRedirect("/inventory/seeProducts");
		}
	}
}
