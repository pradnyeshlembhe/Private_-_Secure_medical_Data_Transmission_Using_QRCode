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


@WebServlet("/Treatment")
public class Treatment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Treatment() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		String SmartCardNo=session.getAttribute("SmartCardNo").toString();
		String username=session.getAttribute("username").toString();
		
		String ha=req.getParameter("ha");
		String gaa=req.getParameter("gaa");
		String hb=req.getParameter("hb");
		String gab=req.getParameter("gab");
		String hc=req.getParameter("hc");
		String gac=req.getParameter("gac");
		
		String dva=req.getParameter("dva");
		String dca=req.getParameter("dca");
		String dvb=req.getParameter("dvb");
		String dcb=req.getParameter("dcb");
		String dvc=req.getParameter("dvc");
		String dcc=req.getParameter("dcc");
		String dvd=req.getParameter("dvd");
		String dcd=req.getParameter("dcd");
		String dve=req.getParameter("dve");
		String dce=req.getParameter("dce");
		String dvf=req.getParameter("dvf");
		String dcf=req.getParameter("dcf");
		String dvg=req.getParameter("dvg");
		String dcg=req.getParameter("dcg");
		String others=req.getParameter("others");

		try {
			Connection con = DBConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("insert into checkup(SmartCardNo,username,ha,gaa,hb,gab,hc,gac,dva,dca,dvb,dcb,dvc,dcc,dvd,dcd,dve,dce,dvf,dcf,dvg,dcg,others)"+"values"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, SmartCardNo);
				ps.setString(2, username);
				ps.setString(3, ha);
				ps.setString(4, gaa);
				ps.setString(5, hb);
				ps.setString(6, gab);
				ps.setString(7, hc);
				ps.setString(8, gac);
				
				ps.setString(9, dva);
				ps.setString(10, dca);
				ps.setString(11, dvb);
				ps.setString(12, dcb);
				ps.setString(13, dvc);
				ps.setString(14, dcc);
				ps.setString(15, dvd);
				ps.setString(16, dcd);
				ps.setString(17, dve);
				ps.setString(18, dce);
				ps.setString(19, dvf);
				ps.setString(20, dcf);
				ps.setString(21, dvg);
				ps.setString(22, dcg);
				ps.setString(23, others);
				
				int res=ps.executeUpdate();
				if(res>0)
				{
					response.sendRedirect("PatientsRecord.jsp?added");
				}
				else
				{
					response.sendRedirect("Treatment.jsp?fail");
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

