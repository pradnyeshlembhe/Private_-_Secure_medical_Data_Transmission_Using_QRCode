package com.dental;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.config.DBConnection;


@WebServlet("/Download1")
public class Download1 extends HttpServlet 
{

	private static final long serialVersionUID = 1L;
	Connection con=null;
	

	public void init(ServletConfig config) throws ServletException 
	{
		try {
			con=DBConnection.getConnection();
			
		} catch (Exception e) 
		{
			System.out.println("Exception Download Connection "+con);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
				
		String checkup=request.getParameter("checkup");
		System.out.println("file name"+checkup);
		
		String filepath="F:\\Workspace\\Medico\\WebContent\\Uploads\\";
		
		//String filepath = DbConnection.path+"\\";
		
		BufferedReader br = new BufferedReader(new FileReader(filepath+checkup));
        
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) 
        {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        
        String encData = sb.toString();
       
        
         try 
         {
        	 
        	 long startDT=System.currentTimeMillis();

			Thread.sleep(2000);
			long endtimeDT = System.currentTimeMillis();
			long DecryptTime = endtimeDT-startDT;                          
			
			System.out.println("Write done");
			
		} catch (Exception e) 
		{
			System.out.println("Downlaod Time Exception "+e);
		}

        // display  
        response.setContentType("");   
 		response.setHeader("Content-Disposition","attachment; prescription=\"" + checkup + "\"");
 		PrintWriter out = response.getWriter();
 		//FileInputStream fileInputStream = new FileInputStream(DbConnection.path+"\\"+filename);
 		FileInputStream fileInputStream = new FileInputStream("F:\\Workspace\\Medico\\WebContent\\Uploads\\"+checkup);
		int i;   
		while ((i=fileInputStream.read()) != -1) 
		{  
		out.write(i);   
		}   
		fileInputStream.close();   
		out.close(); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}
}
