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


@WebServlet("/PatientsCheckup")
public class PatientsCheckup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatientsCheckup() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session = request.getSession();
		//String SmartCardNo = request.getParameter("SmartCardNo");
		String SmartCardNo=session.getAttribute("SmartCardNo").toString();
		System.out.println(SmartCardNo);
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from uploads where SmartCardNo=?");
			ps.setString(1, SmartCardNo);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				session.setAttribute("SmartCardNo", SmartCardNo);	
				response.sendRedirect("ViewCheckup.jsp");
			}
			else{
				response.sendRedirect("GetPatientsRecords.jsp?invalid");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
