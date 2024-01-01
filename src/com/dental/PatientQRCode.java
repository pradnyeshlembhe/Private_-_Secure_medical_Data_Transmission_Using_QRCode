package com.dental;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qrcode.AESAlgorithm;
import com.qrcode.GlobalFunction;
import com.qrcode.Mailer;
import com.qrcode.PasswordAthenticationProtocol;
import com.qrcode.QRCodeGenerator;
import com.mail.EmailAttachmentSender;

import net.glxn.qrgen.exception.QRGenerationException;

import com.config.DBConnection;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@WebServlet("/PatientQRCode")
public class PatientQRCode extends HttpServlet {
	
	private String host;
	private String port;
	private String user;
	private String pass;
	

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException {
    	ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
		System.out.println("Hello");
    	response.setContentType("text/html;charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	HttpSession session = request.getSession();
    	try{
    		long s_time=System.currentTimeMillis();
    		
    		String filePath = "F:\\Workspace\\Medico\\WebContent\\QRCode\\";
    		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();            
            String Addeddate=dateFormat.format(date); 
    		
            Map hintMap = new HashMap();
    		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    		
    		String pfname=request.getParameter("pfname");
    		String pmname=request.getParameter("pmname");
    		String plname=request.getParameter("plname");
    		
    		String dob=request.getParameter("dob");
    		String age=request.getParameter("age");	
    		String gender=request.getParameter("gender");
    		
    		String bloodgroup=request.getParameter("bloodgroup");
    		String refdoc=request.getParameter("refdoc");
    		String address=request.getParameter("address");
    		
    		String city=request.getParameter("city");
    		String email=request.getParameter("email");
    		String mobile=request.getParameter("mobile");    		
    		
    		String username=request.getParameter("username");
    		String password=request.getParameter("password");
    		
    		Connection con = DBConnection.getConnection(); 
            Statement st = con.createStatement();
            AESAlgorithm AES = new AESAlgorithm();
 		
           // String id = null;
            int id = 0;
            String temp_id = "CH201920";
            PreparedStatement ps=con.prepareStatement("SELECT * FROM patient ORDER BY ID DESC LIMIT 1");
 			ResultSet rs=ps.executeQuery();
 			System.out.println("User Query: "+ps);
 			 if(rs.next())
 			 {
 			    id=rs.getInt("id");
 				System.out.println("User id: "+id);
 			 }
 			 int a = id+1;
             System.out.println("Max Id: "+a);
 			 String SmartCardNo = temp_id + a;
 			 System.out.println("Ration Card No. is ="+SmartCardNo);
	             
             PasswordAthenticationProtocol RN = new PasswordAthenticationProtocol();
             ResultSet rs1 = st.executeQuery("select * from patient where email='"+email+"'");
          
             if(rs1.next())
             {
                 response.sendRedirect("AddPatients.jsp?Exist=Exist");
             }else{
            	
            	 String SecretKey = RN.generateRandomString();
            	 String Encrpted=AES.encrypt(mobile, SecretKey);
            	 Encrpted=Encrpted.replaceAll("[-+.^:,!]","");
            	 System.out.println("---Encrpted---"+Encrpted);
            	 String files = filePath+"//"+username+".png";
          
            	 QRCodeGenerator QR = new QRCodeGenerator();
            	 QR.createQRCode(Encrpted, files, hintMap, 200, 200);
            	 long e_time=System.currentTimeMillis();
            	 System.out.println("Start time : "+s_time);
            	 System.out.println("End time : "+e_time);
            	 long t_time=e_time-s_time;
            	 System.out.println("Total time  : "+t_time);
            	 System.out.println(files);
            	 System.out.println("dddd");
            	 
                 int r = st.executeUpdate("insert into patient (id,SmartCardNo,pfname,pmname,plname,dob,age,gender,bloodgroup,refdoc,address,city,email,mobile,username,password,SecretKey,QRCode,regDate)"
                 		+ " values(null,'"+SmartCardNo+ "','"+ pfname+ "','"+ pmname+ "','"
                 		+ plname+ "','"+ dob+ "','"+ age+ "','"+ gender+ "','"
                 		+ bloodgroup+ "','"+ refdoc+ "','"+ address+ "','"
                 		+ city + "','"+email+ "','" + mobile+ "','"
                 		+ username+ "','"+password+ "','"
                 		+SecretKey+"','"+Encrpted+"','"+Addeddate+"')");
                 if(r>0){
                     
                	 System.out.println("Data Inserted");
                 	//////////send mail/////////////
                	 
                    String host = "smtp.gmail.com";
                    String port = "587";
                    String mailFrom = "college2021project@gmail.com";
                    String pass = "Ritesh1432";
              
                     // message info
                     System.out.println("Mail()");
                     
                     String subject = "Patient QR Code generated Successfull";
                     String message = "Patient Smart Card Number is :"+SmartCardNo +"<br> & Your Details.<br>"+
                            
                             "User Name : "+username +"<br>"+
                             "Address : "+ address + " "+"<br>"+
                             "Smart Card No. : "+ SmartCardNo + " "+"<br>"+
                             "Your Password :"+ password + " "+"<br>"+
                             "QR Code : "+ Encrpted + " "+"<br>";
              
                     // attachments
                     String[] attachFiles = new String[1];
                     attachFiles[0] = "F:\\Workspace\\Medico\\WebContent\\QRCode\\"+username+".png";
                    
                     try {
                   EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, pass, email,
                      subject, message, attachFiles);
    			         System.out.println("Email sent.");
                     } catch (Exception ex) {
                         System.out.println("Could not send email.");
                         ex.printStackTrace();
                     }
                 }
                 
                 session.setAttribute("id", id);
                 response.sendRedirect("HospitalHome.jsp?Done");
               }
    		//}
         } catch (Exception e) { e.getMessage();
                       e.printStackTrace();
         }finally{
    		out.close();
    		
    	}
	}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
