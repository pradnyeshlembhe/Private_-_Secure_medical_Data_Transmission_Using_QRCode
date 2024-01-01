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


@WebServlet("/Appointment")
public class Appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Appointment() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		try {
			//String username=req.getParameter("username");
			String SmartCardNo=session.getAttribute("SmartCardNo").toString();
			String username=session.getAttribute("username").toString();
			
			String apdate=req.getParameter("apdate");
			String aptime=req.getParameter("aptime");
			
			System.out.println("UserName: "+username+" Card No.: "+SmartCardNo+" Date: "+apdate+"..Time: "+aptime);

		    Connection con = DBConnection.getConnection();
		    ResultSet rs;
			PreparedStatement ps = con.prepareStatement("insert into appointment(SmartCardNo, username, apdate, aptime)"+"values(?,?,?,?)");
			
				ps.setString(1, SmartCardNo);
				ps.setString(2, username);
				ps.setString(3, apdate);
				ps.setString(4, aptime);
				
				int res=ps.executeUpdate();
				if(res>0)
			    {
					response.sendRedirect("PatientHome.jsp?apdone");
				}
				else
				{
					response.sendRedirect("Appointment.jsp?fail");
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

