package com.dental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/InsuVerification")
public class InsuVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("im in verification.java");
		HttpSession session=request.getSession();
		String otpm=session.getAttribute("otpm").toString();
		String email=session.getAttribute("email").toString();
		String id=session.getAttribute("id").toString();
		String otpe=request.getParameter("otpe");
		System.out.println("OYPE: "+otpe+" OTPM: "+otpm+" id: "+id+"..Email: "+email);
		if(otpe.equals(otpm))
		{
			response.sendRedirect("GetPatientsRecord.jsp?verify");	
		}
		else
		{
			response.sendRedirect("GetPDetails.jsp?incorrect");
		}	
	}
}
