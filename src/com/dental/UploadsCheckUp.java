package com.dental;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.config.DBConnection;


@WebServlet("/UploadsCheckUp")
public class UploadsCheckUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con = null;
	final String UPLOAD_DIRECTORY = "F:\\Workspace\\Medico\\WebContent\\Uploads";
	
	public void init(ServletConfig config) throws ServletException {
		try {
			con = DBConnection.getConnection();

		} catch (Exception e) {

			System.out.println("Exception in DB" + e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(request)) 
		{
			try 
			{
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				System.out.println("ABCD");
				String checkup = "";
				String SecKey = "";
				String FileExtention = "";
				String FileData = "";
				long FileSize = 0;

				for (FileItem item1 : multiparts) 
				{
					if (!item1.isFormField()) 
					{
						System.out.println("Checkup");
						String name = new File(item1.getName()).getName();
						item1.write(new File(UPLOAD_DIRECTORY + File.separator+ name));
						checkup = item1.getName();
						FileExtention = item1.getContentType();
						FileSize = item1.getSize();
					}
				}
				
				DateFormat df = new SimpleDateFormat("dd/MM/yy");
				Date dateobj = new Date();
				String c_date = df.format(dateobj);
				
				HttpSession session=request.getSession();
				String SmartCardNo=session.getAttribute("SmartCardNo").toString();
				String username=session.getAttribute("username").toString();
				System.out.println("SS "+SmartCardNo);
				System.out.println("UU "+username);
				System.out.println("FileName " + checkup);
				System.out.println("File Extension " + FileExtention);
				System.out.println("File Size " + FileSize);
			
					try {
						PreparedStatement ps=con.prepareStatement("update uploads set checkup='"+checkup+"' where SmartCardNo='"+SmartCardNo+"'");
						// PreparedStatement ps =con.prepareStatement("INSERT INTO `uploads` (`id`, `SmartCardNo`, `username`, `prescription`, `checkup`) VALUES (NULL,'"+SmartCardNo+"','"+username+"','"+prescription+"', '"+checkup+"')");
						
						 int res=ps.executeUpdate();
							if(res>0)
						    {
								response.sendRedirect("PatientsRecord.jsp?upload");
							}
							else
							{
								response.sendRedirect("Uploads.jsp?fail");
							}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}catch (Exception e) {
				}

			}
		}
	}
