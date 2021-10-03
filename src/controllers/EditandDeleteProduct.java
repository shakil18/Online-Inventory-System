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

public class EditandDeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id = 0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = Integer.parseInt(request.getParameter("id"));
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
				String s = request.getParameter("s");
				ConnectionAdapters ca = new ConnectionAdapters(); 
				if(s.equals("1")){
					Product pd = ca.get(id);
					pd.getProductId();
					pd.getProductName();
					pd.getProductPrice();
					request.setAttribute("catlist", ca.getAllCategoryName());
					request.setAttribute("edits", pd);
					RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/editProduct_view.jsp");
					disp.forward(request, response);
				}
				else if(s.equals("2")){
					ca.delete(id);
					response.sendRedirect("/inventory/seeProducts");
				}
				else{
				}
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
			request.setAttribute("edits", pd);
			request.setAttribute("catlist", ea.getAllCategoryName());
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/editProduct_view.jsp");
			disp.forward(request, response);
		}
		else{
			ea.update(pd, a, id);
			int productId = ea.returnRecentProduct();
			Product pds = ea.get(productId);
			ea.insertIntoStock(pds);
			response.sendRedirect("/inventory/seeProducts");
		}
	}

}
