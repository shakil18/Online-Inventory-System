package controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.ConnectionAdapters;
import models.Sale;

public class SaleProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id ;
	int productId;
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
		if(session !=null){
			if(!name.equals("")){
				ConnectionAdapters ca = new ConnectionAdapters();
				productId = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("cuslist", ca.getAllCustomer());
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/saleToCustomer_view.jsp");
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
		HttpSession session = request.getSession();
		ConnectionAdapters ca = new ConnectionAdapters();
		String name = session.getAttribute("username").toString();
		id = ca.returnEmpId(name);
		Sale sl = new Sale();
		String customerName = request.getParameter("cusName");
		String quantity = request.getParameter("quantity");
		String sellDate = request.getParameter("sellDate");
		if(customerName.equals("") || quantity.equals("") || sellDate.equals("")){
			sl.setMsg("You have to fill all the fields");
			request.setAttribute("cuslist", ca.getAllCustomer());
			request.setAttribute("sales", sl);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/saleToCustomer_view.jsp");
			disp.forward(request, response);
		}
		else{
			int q = ca.returnQuantity(productId);
			if(q < Integer.parseInt(quantity)){
				sl.setMsg("You stock is not enough");
				request.setAttribute("cuslist", ca.getAllCustomer());
				request.setAttribute("sales", sl);
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/saleToCustomer_view.jsp");
				disp.forward(request, response);
			}
			else{
				ca.updateQuantity(Integer.parseInt(quantity), productId);
				int sale = Integer.parseInt(quantity) * ca.returnPrice(productId);
				String saleCost = Integer.toString(sale);
				
				int cusId = ca.returnCusId(customerName);
				ca.insertIntoSale(productId,ca.returnProductName(productId), saleCost, quantity, sellDate, cusId, id);
				request.setAttribute("prolist", ca.getAllProduct());
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/sale_view.jsp");
				disp.forward(request, response);
			}
		}
	}

}
