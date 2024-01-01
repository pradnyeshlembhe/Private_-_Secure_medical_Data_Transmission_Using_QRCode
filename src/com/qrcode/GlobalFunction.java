package com.qrcode;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.config.DBConnection;
import com.mysql.jdbc.Connection;

public class GlobalFunction {

		 public static String Uid()throws Exception
		 {
			 String id="";
			 Connection con1=(Connection) DBConnection.getConnection();
			 PreparedStatement ps1=con1.prepareStatement("select id from patient ORDER BY id DESC LIMIT 1");
			 ResultSet rs1=ps1.executeQuery();
			 if(rs1.next())
			 {
				 id=rs1.getString("id");
			 }
				 
			return id;
			 
		 }	  
	}
