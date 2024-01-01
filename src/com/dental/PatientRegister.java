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

@WebServlet("/PatientRegister")
public class PatientRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PatientRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pfname=req.getParameter("pfname");
		String pmname=req.getParameter("pmname");
		String plname=req.getParameter("plname");
		String dob=req.getParameter("dob");
		int age=Integer.parseInt(req.getParameter("age"));			
		String gender=req.getParameter("gender");
		String bloodgroup=req.getParameter("bloodgroup");
		String refdoc=req.getParameter("refdoc");
		String address=req.getParameter("address");
		String city=req.getParameter("city");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		//int mobile=Integer.parseInt(req.getParameter("mobile"));
		String username=req.getParameter("username");
		String password=req.getParameter("password");

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps1 = con.prepareStatement("select * from patient where username=?");
			ps1.setString(1, username);
			ResultSet rs = ps1.executeQuery();
			if(!rs.next())
			{
				PreparedStatement ps = con.prepareStatement("insert into patient(pfname,pmname,plname,dob,age,gender,bloodgroup,refdoc,address,city,email,mobile,username,password)"+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,pfname);
				ps.setString(2,pmname);
				ps.setString(3,plname);
				ps.setString(4, dob);
				ps.setInt(5,age);
				ps.setString(6, gender);
				ps.setString(7, bloodgroup);
				ps.setString(8, refdoc);
				ps.setString(9, address);
				ps.setString(10, city);
				ps.setString(11, email);
				ps.setString(12, mobile);
				ps.setString(13, username);
				ps.setString(14, password);
				
				
				ps.executeUpdate();
				res.sendRedirect("Patients.jsp?donee");
			}
			else
			{
				res.sendRedirect("PatientRegister.jsp?present");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

