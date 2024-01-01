package com.dental;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.config.DBConnection;

@WebServlet("/Patient")
public class Patient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Patient() {
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
		System.out.println(username);
		System.out.println(password);
		HttpSession session = request.getSession();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from patient where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				 SessionTest.id = rs.getString("id"); 
				 session.setAttribute("id", rs.getString("id"));
				 session.setAttribute("username", username);
				 session.setAttribute("pfname", rs.getString("pfname"));
				 session.setAttribute("plname", rs.getString("plname"));
				 session.setAttribute("SmartCardNo", rs.getString("SmartCardNo"));
				 response.sendRedirect("PatientHome.jsp?done");
			}
			else{
				response.sendRedirect("Patient.jsp?invalid");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
