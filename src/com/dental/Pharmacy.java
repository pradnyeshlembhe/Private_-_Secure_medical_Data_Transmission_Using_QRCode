package com.dental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Pharmacy")
public class Pharmacy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Pharmacy() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
			if(username.equals("admin") && password.equals("admin"))
			{
								
				response.sendRedirect("PharmacyHome.jsp?succ");
			}
			else{
				response.sendRedirect("Pharmacy.jsp?invalid");
			}		
		}
}
