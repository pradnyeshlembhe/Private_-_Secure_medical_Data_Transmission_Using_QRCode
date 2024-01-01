package com.dental;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mail.OTP;
import com.qrcode.EmailAttachmentSender;
import com.config.DBConnection;
import com.google.zxing.client.result.EmailAddressParsedResult;

@WebServlet("/InsuAuthentication")
public class InsuAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public InsuAuthentication() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		
	System.out.println("Hello Servlet");
	response.setContentType("text/html;charset=UTF-8");
	HttpSession session = request.getSession();
	PrintWriter out = response.getWriter();
	
	try{
		String SmartCardNos = request.getParameter("SmartCardNo");
		System.out.println("Details "+SmartCardNos);
		Connection con = DBConnection.getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from `patient` where SmartCardNo='"+SmartCardNos+"'");
		System.out.println(rs);
		if(rs.next()){
			
			String id = rs.getString("id");
			String pfname = rs.getString("pfname");
			String p = rs.getString("SmartCardNo");
			String address=rs.getString("address");
			String ppicture=rs.getString("ppicture");
			String email=rs.getString("email");
			
			System.out.println("id: "+id);
			
			
			if(SmartCardNos.equalsIgnoreCase(p)){
				
				//SessionTest.username = rs.getString("username");
				SessionTest.id = rs.getString("id");
				session.setAttribute("pfname", pfname);
				session.setAttribute("id", id);
				System.out.println("UserId: "+id);
				System.out.println("pfname:= "+pfname);
				session.setAttribute("address", address);
				session.setAttribute("ppicture",ppicture);
				session.setAttribute("email", email);
				OTP otp=new OTP();
				String otpe=otp.skKeyGenerate();
				System.out.println(otpe);
				
				com.mail.SendMailSSL sendmail= new com.mail.SendMailSSL();
				String Sub="OTP For Authentcation";
				String Msg="Hello '"+SmartCardNos+"' for login please use OTP for login is:"+otpe;
				session.setAttribute("otpm", otpe);
				sendmail.EmailSending(email, Sub, Msg);
				
				response.sendRedirect("Verify1.jsp");
				
			}else{
				
				response.sendRedirect("GetPDetails.jsp?incorrect");
			}	
		}
			
	}catch(Exception e){
e.printStackTrace();
}finally{
		
		out.close();
	}	 
  }
}
