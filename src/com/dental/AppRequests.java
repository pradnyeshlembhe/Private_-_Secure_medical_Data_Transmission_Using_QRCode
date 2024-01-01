package com.dental;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.config.DBConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@WebServlet(name = "AppRequests", urlPatterns = { "/AppRequests" })
public class AppRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init(ServletConfig config) throws ServletException {

	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		System.out.println("Services method");
		String sts = request.getParameter("status");
		String SmartCardNo = request.getParameter("SmartCardNo");
		String username=session.getAttribute("username").toString();
		System.out.println(username);
		
		if (sts != null) {

			System.out.println("username " + username);
			System.out.println("Status " + sts);

			Connection con = null;
			try {
				con = (Connection) DBConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Statement st1;
			try {
				st1 = (Statement) con.createStatement();

				st1.executeUpdate("Update appointment set status='" + sts
						+ "', doctor='" + username + "' where SmartCardNo='" + SmartCardNo + "'");

				System.out.println("done");
				response.sendRedirect("PatientsAppointment.jsp?request=done");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			/*String privilege=request.getParameter("privilege");

			System.out.println("username " + username);
			System.out.println("Privilege " + privilege);

			Connection con = null;
			try {
				con = (Connection) DBConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Statement st1;
			try {
				st1 = (Statement) con.createStatement();

				st1.executeUpdate("Update users set privilege='" + privilege
						+ "' where username='" + username + "'");

				System.out.println("done2");
				response.sendRedirect("UserRequests.jsp?request=done");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			System.out.println("fail");
			response.sendRedirect("PatientsAppointment.jsp?request=fail");
			
		}

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet method");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPost method");

	}
}
