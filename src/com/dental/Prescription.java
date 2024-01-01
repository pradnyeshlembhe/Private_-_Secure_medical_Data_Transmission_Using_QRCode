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


@WebServlet("/Prescription")
public class Prescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Prescription() {
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
	
			String SmartCardNo=session.getAttribute("SmartCardNo").toString();
			String username=session.getAttribute("username").toString();
			
			String tab=req.getParameter("tab");
			String syrup=req.getParameter("syrup");
			String taba=req.getParameter("taba");
			String syrupa=req.getParameter("syrupa");
			String cleaner=req.getParameter("cleaner");
			String clips=req.getParameter("clips");


		    Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into prescription(SmartCardNo, username, tab, syrup, taba, syrupa, cleaner, clips)"+"values(?,?,?,?,?,?,?,?)");
			
				ps.setString(1, SmartCardNo);
				ps.setString(2, username);
				ps.setString(3, tab);
				ps.setString(4, syrup);
				ps.setString(5, taba);
				ps.setString(6, syrupa);
				ps.setString(7, cleaner);
				ps.setString(8, clips);
				
				int res=ps.executeUpdate();
				if(res>0)
			    {
					response.sendRedirect("PatientsRecord.jsp?added");
				}
				else
				{
					response.sendRedirect("Prescripton.jsp?fail");
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

