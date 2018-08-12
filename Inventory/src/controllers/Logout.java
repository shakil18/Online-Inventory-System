package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Cookie c = new Cookie("username",null);
		Cookie[] cookies = request.getCookies();
		Cookie username = cookies[0];
		String s = username.getValue();
		if(session != null){
			username.setMaxAge(0);
			username.setPath("/");
			//co.setMaxAge(0);
			session.removeAttribute("username");
			//session.removeAttribute("admin");
			//response.addCookie(c);
    		session.invalidate();
    		response.sendRedirect("/inventory/LoginServlet");
    	} 
	}
}
