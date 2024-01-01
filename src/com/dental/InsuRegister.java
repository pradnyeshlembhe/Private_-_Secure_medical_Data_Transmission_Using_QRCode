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


@WebServlet("/InsuRegister")
public class InsuRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsuRegister() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = req.getSession();
		String id=req.getParameter("id");
		String cname=req.getParameter("cname");
		String sname=req.getParameter("sname");
		String domain=req.getParameter("domain");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String contact=req.getParameter("contact");
		String username=req.getParameter("username");
		String password=req.getParameter("password");

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps1 = con.prepareStatement("select * from insurance where username=?");
			ps1.setString(1, username);
			ResultSet rs = ps1.executeQuery();
			if(!rs.next())
			{
				PreparedStatement ps = con.prepareStatement("insert into insurance(cname,sname,domain,address,email,contact,username,password)"+"values(?,?,?,?,?,?,?,?)");
				ps.setString(1,	cname);
				ps.setString(2,	sname);
				ps.setString(3, domain);
				ps.setString(4, address);
				ps.setString(5, email);
				ps.setString(6, contact);
				ps.setString(7, username);
				ps.setString(8, password);
				
				ps.executeUpdate();
				
				session.setAttribute("cname", cname);
				session.setAttribute("id", id);
				
				res.sendRedirect("HospitalHome.jsp?add");
			}
			else
			{
				res.sendRedirect("InsuRegister.jsp?present");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

