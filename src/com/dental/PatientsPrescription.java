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


@WebServlet("/PatientsPrescription")
public class PatientsPrescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatientsPrescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String SmartCardNo = request.getParameter("SmartCardNo");
		//String password = request.getParameter("password");
		System.out.println(SmartCardNo);
		
		HttpSession session = request.getSession();
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from uploads where SmartCardNo=?");
			ps.setString(1, SmartCardNo);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				session.setAttribute("SmartCardNo", SmartCardNo);	
				response.sendRedirect("ViewPrescription.jsp?succ");
			}
			else{
				response.sendRedirect("PatientsPres.jsp?invalid");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
