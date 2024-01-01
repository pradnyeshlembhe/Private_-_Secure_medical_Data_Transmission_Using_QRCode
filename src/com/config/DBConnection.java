package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {

	//public static String presfilepath;
	public static String presfilepath="F:\\Workspace\\Medico\\WebContent\\QRCode\\"; 

	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medico","root","");
		// s3://elasticbeanstalk-ap-south-1-004338337616/.elasticbeanstalk
		return con;
	}
}


