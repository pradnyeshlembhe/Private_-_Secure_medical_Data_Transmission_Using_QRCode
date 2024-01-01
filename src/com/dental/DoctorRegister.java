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

import com.config.DBConnection;


@WebServlet("/DoctorRegister")
public class DoctorRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoctorRegister() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pfname=req.getParameter("pfname");
		String plname=req.getParameter("plname");
		int age=Integer.parseInt(req.getParameter("age"));			
		String gender=req.getParameter("gender");
		String specialist=req.getParameter("specialist");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		String username=req.getParameter("username");
		String password=req.getParameter("password");

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps1 = con.prepareStatement("select * from doctor where username=?");
			ps1.setString(1, username);
			ResultSet rs = ps1.executeQuery();
			if(!rs.next())
			{
				PreparedStatement ps = con.prepareStatement("insert into doctor(pfname,plname,age,gender,specialist,address,email,mobile,username,password)"+"values(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,pfname);
				ps.setString(2,plname);
				ps.setInt(3,age);
				ps.setString(4, gender);
				ps.setString(5, specialist);
				ps.setString(6, address);
				ps.setString(7, email);
				ps.setString(8, mobile);
				ps.setString(9, username);
				ps.setString(10, password);
				
				ps.executeUpdate();
				res.sendRedirect("HospitalHome.jsp?done");
			}
			else
			{
				res.sendRedirect("DoctorRegister.jsp?present");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

