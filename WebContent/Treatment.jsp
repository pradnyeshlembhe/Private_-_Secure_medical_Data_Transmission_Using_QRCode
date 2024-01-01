<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.config.DBConnection"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>MEDICO</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
  	<script src="https://unpkg.com/jspdf@latest/dist/jspdf.min.js"></script>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    
   <!--  <style>
    @CHARSET "UTF-8";
    .page-break {
      page-break-after: always;
      page-break-inside: avoid;
      clear:both;
    }
    .page-break-before {
      page-break-before: always;
      page-break-inside: avoid;
      clear:both;
    }
    #html-2-pdfwrapper{
      position: absolute; 
      left: 20px; 
      top: 50px; 
      bottom: 0; 
      overflow: auto; 
      width: 1600px;
    }
  </style> -->
  <style>
		thead {color:green;}
		tbody {color:blue;}
		tfoot {color:red;}
		
		table, th, td {
		  border: 2px solid black;
		  height: 50px;
		  width: -1px;
		  padding: 10px;
		  text-align: center;
		}
		th {
		  background-color: #4CAF50;
		  color: white;
		}
	</style>
  
  </head>
  <body>
  <%
	if(request.getParameter("verify")!=null){
		   out.println("<script>alert('OTP Match Successfull.......!!');</script>"); 
		}
	%>
	<!-- <div id="html-2-pdfwrapper"> -->
    <div class="py-md-5 py-4 border-bottom">
    	<div class="container">
    		<div class="row no-gutters d-flex align-items-start align-items-center px-3 px-md-0">
    			<div class="col-md-4 order-md-2 mb-2 mb-md-0 align-items-center text-center">
		    		<a class="navbar-brand" href="index.jsp">MEDICO<span>using BioMetric</span></a>
	    		</div>
	    		<div class="col-md-4 order-md-1 d-flex topper mb-md-0 mb-2 align-items-center text-md-right">
	    			<div class="icon d-flex justify-content-center align-items-center order-md-last">
	    				<span class="icon-map"></span>
	    			</div>
	    			<div class="pr-md-4 pl-md-0 pl-3 text">
					    <p class="con"><span>Free Call</span> <span>+91 7022053116</span></p>
					    <p class="con">K.L.E IT</p>
				    </div>
			    </div>
			    <div class="col-md-4 order-md-3 d-flex topper mb-md-0 align-items-center">
			    	<div class="icon d-flex justify-content-center align-items-center"><span class="icon-paper-plane"></span></div>
			    	<div class="text pl-3 pl-md-3">
					    <p class="hr"><span>Open Hours</span></p>
					    <p class="time"><span>Mon - Sat:</span> <span>8:00am - 9:00pm</span> Sun: Closed</p>
				    </div>
			    </div>
		    </div>
		  </div>
    </div>
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container d-flex align-items-center">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav m-auto">
	        	<li class="nav-item active"><a href="DoctorHome.jsp" class="nav-link pl-0">Home</a></li>
	        	<li class="nav-item"><a href="#" class="nav-link">Appointment</a></li>
	        	<li class="nav-item"><a href="PatientsRecord.jsp" class="nav-link">Patients Records</a></li>
	        	<li class="nav-item"><a href="#" class="nav-link">Doctor</a></li>
	            <li class="nav-item"><a href="index.jsp?logout" class="nav-link">Logout</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
    <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
            <h1 class="mb-2 bread">Doctor Section</h1>
            <p class="breadcrumbs"><span class="mr-2"><a href="index.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Patient Records <i class="ion-ios-arrow-forward"></i></span></p>
          </div>
        </div>
      </div>
    </section>
		
		<section class="ftco-section ftco-no-pt ftco-no-pb">
			<div class="container">
				<div class="row no-gutters">
					<div class="col-md-5 p-md-5 img img-2 mt-5 mt-md-0" style="background-image: url(images/about.jpg);">
					</div>
					<div class="col-md-7 wrap-about py-4 py-md-5 ftco-animate">
	          <div class="heading-section mb-5">
	          	<div class="pl-md-5 ml-md-5 pt-md-5">
		            <h2 class="mb-2" style="font-size: 32px;">Patient Treatment Task</h2>
	       
	        <form action="Treatment" method="post">  
           <table align="center" border="10" cellpadding="10px" cellspacing="0px">
                  
              	<%		
              			String username=session.getAttribute("username").toString();
              			String id=session.getAttribute("id").toString();
						Connection con=DBConnection.getConnection();
						PreparedStatement ps=con.prepareStatement("select * from patient where id=?");
						ps.setString(1, id);
						ResultSet rs=ps.executeQuery();
						if(rs.next()) 
						{
				%>
					<tr align="center">
						<td colspan="1"><img src="ProfilePicture/<%=session.getAttribute("ppicture") %>" width="80px" height="80px" style="border-radius: 70%;"></td>
						<td colspan="3"><span style="font-size:20px; color: red">Mr./Ms. <b><%=rs.getString("pfname") %>&nbsp;<%=rs.getString("plname") %>'s</b> Detal Treatment Task </span><br>
						<b>Smart Card No.: </b><%=session.getAttribute("SmartCardNo") %></td>
					</tr>
		            <tr align="center">
			            <th><b>CheckUp</b></th>
			            <th><b>n(%)</b></th>
			            <th><b>CheckUp</b></th>
			            <th><b>n(%)</b></th>
			        </tr>
			        <tr> 
			        	<td colspan="2"><b>Health of Teeth:</b></td>   
						<td colspan="2"><b>Gums:</b></td>
					</tr>
					 <tr> 
			        	<td><b>Good</b></td>   
						<td><input type="text" name="ha" style="width:100px;" required></td>
						<td><b>Good</b></td>   
						<td><input type="text" name="gaa" style="width:100px;" required></td>
					</tr>
					 <tr> 
			        	<td><b>Average</b></td>   
						<td><input type="text" name="hb" style="width:100px;" required></td>
						<td><b>Average</b></td>   
						<td><input type="text" name="gab" style="width:100px;" required></td>
					</tr>
					 <tr> 
			        	<td><b>Poor</b></td>   
						<td><input type="text" name="hc" style="width:100px;" required></td>
						<td><b>Poor</b></td>   
						<td><input type="text" name="gac" style="width:100px;" required></td>
					</tr>
					
					 <tr> 
			        	<th><b>Dental Condition:</b></th>   
						<th><b>n(%):</b></th>
			        	<th><b>Reason for last Dental Visit:</b></th>   
						<th><b>n(%):</b></th>
					</tr>
					<tr>
						<td><b>Noncavitated caries</b></td>   
						<td><input type="text" name="dca" style="width:100px;" required></td>
						<td><b>Pain</b></td>   
						<td><input type="text" name="dva" style="width:100px;" required></td>
					</tr>
					<tr>
						<td><b>Cavitated caries</b></td>   
						<td><input type="text" name="dcb" style="width:100px;" required></td>
						<td><b>Tooth Decay</b></td>   
						<td><input type="text" name="dvb" style="width:100px;" required></td>
					</tr>
					<tr>
						<td><b>Missing teeth</b></td>   
						<td><input type="text" name="dcc" style="width:100px;" required></td>
						<td><b>Bleeding Gums, Mobile teeth</b></td>   
						<td><input type="text" name="dvc" style="width:100px;" required></td>
					</tr>
					<tr>
						<td><b>Stains</b></td>   
						<td><input type="text" name="dcd" style="width:100px;" required></td>
						<td><b>Malocclusion</b></td>   
						<td><input type="text" name="dvd" style="width:100px;" required></td>
					</tr>
					<tr>
						<td><b>Mobility</b></td>   
						<td><input type="text" name="dce" style="width:100px;" required></td>
						<td><b>Discolored teeth</b></td>   
						<td><input type="text" name="dve" style="width:100px;" required></td>
					</tr>
					<tr>
						<td><b>Grossly decayed indicated for extraction</b></td>   
						<td><input type="text" name="dcf" style="width:100px;" required></td>
						<td><b>Trauma</b></td>   
						<td><input type="text" name="dvf" style="width:100px;" required></td>
					</tr>
					<tr>
						<td><b>Nonvital tooth</b></td>   
						<td><input type="text" name="dcg" style="width:100px;" required></td>
						<td><b>Routine dental checkup</b></td>   
						<td><input type="text" name="dvg" style="width:100px;" required></td>
					</tr>
					<tr>
						<!-- <td><b>Submit</b></td>  -->  
						<td><b>Others</b></td>   
						<td><input type="text" name="others" style="width:100px;" required></td>
						<th colspan="2" align="center"><input class="input-rounded-button" type="submit" value="Submit" style="height: 30px;width: 80px;"/></th>
					</tr>	
            <%
				}
			%>
            </table>
            </form>	
            
            <button onclick="generate()">Generate PDF</button>
            <button target="blank" style="cursor: pointer" onclick="window.print();">Print</button>
            <button target="blank" style="cursor: pointer" onclick="jsPDF();">PDF</button>
		  </div>
	    </div>
      </div>
    </div></div>
</section>
		
		<section class="ftco-intro" style="background-image: url(images/bg_3.jpg);" data-stellar-background-ratio="0.5">
			<div class="overlay"></div>
			<div class="container">
				<div class="row">
					<div class="col-md-9">
						<h2>We Provide Free Dental Care Consultation</h2>
						<p class="mb-0">Your Health is Our Top Priority with Comprehensive, Affordable medical.</p>
						<p></p>
					</div>
					<div class="col-md-3 d-flex align-items-center">
						<p class="mb-0"><a href="#" class="btn btn-secondary px-4 py-3">Free Consutation</a></p>
					</div>
				</div>
			</div>
		</section>

   	
    <footer class="ftco-footer ftco-bg-dark ftco-section">
      <div class="container">
        </div>
        <div class="row">
          <div class="col-md-12 text-center">

            <p>
			  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made <i class="icon-heart" aria-hidden="true"></i> by <a href="#" target="_blank">K.L.E IT</a>
			  </p>
          </div>
        </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>
</div>

  <script src='dist/jspdf.min.js'></script>
  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/jquery.timepicker.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>