<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.qrcode.GlobalFunction"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.config.DBConnection"%>
<%@page import="java.sql.Connection"%>
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
  </head>
  <body>
  <%
	if(request.getParameter("done")!=null)
	{
	out.println("<script>alert('Login Sucessful .. Welcome to Patient Section')</script>");	
	}
   %>
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
					    <p class="con">198 West 21th Street, Suite 721 New York NY 10016</p>
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
	        	<li class="nav-item"><a href="PatientHome.jsp" class="nav-link pl-0">Home</a></li>
	        	<li class="nav-item"><a href="Profile.jsp" class="nav-link">Profile</a></li>
	        	<li class="nav-item"><a href="Appointment.jsp" class="nav-link">Appointment</a></li>
	        	<li class="nav-item active"><a href="ProgressReport.jsp" class="nav-link">Progress Report</a></li>
	        	<li class="nav-item"><a href="#" class="nav-link">Treatement</a></li>
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
            <h1 class="mb-2 bread">Our Dentist</h1>
            <p class="breadcrumbs"><span class="mr-2"><a href="index.jsp">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Doctors <i class="ion-ios-arrow-forward"></i></span></p>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="staff">
							<div class="img-wrap d-flex align-items-stretch">
								<div class="img align-self-stretch" style="background-image: url(images/doc-1.jpg);"></div>
							</div>
							<div class="text pt-3 text-center">
								<h3>Dr. Lloyd Wilson</h3>
								<span class="position mb-2">Denstist</span>
								<div class="faded">
									<p>I am an ambitious workaholic, but apart from that, pretty simple person.</p>
									<ul class="ftco-social text-center">
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="icon-twitter"></span></a></li>
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="icon-facebook"></span></a></li>
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="icon-google-plus"></span></a></li>
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="icon-instagram"></span></a></li>
		              </ul>
	              </div>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-lg-6 ftco-animate">	
					
					<script>
					window.onload = function() {
					
					var chart = new CanvasJS.Chart("chartContainer", {       
						animationEnabled: true,
						title: {
							text: "Patients Progress Reports"
						},
						axisX:{
							minimum: 5,
							maximum: 95
						},
						data: [{
							type: "column",
							dataPoints: [
							             { x: 10, y: 230, indexLabel: "Stains" },
										  { x: 20, y: 710, indexLabel: "Malocclusion" },
										  { x: 30, y: 380, indexLabel: "Mobility" },
										  { x: 40, y: 567, indexLabel: "Tooth Decay" },
										  { x: 50, y: 210, indexLabel: "Pain" },
										  { x: 60, y: 507, indexLabel: "Trauma" },
										  { x: 70, y: 680, indexLabel: "Nonvital tooth" },
										  { x: 80, y: 157, indexLabel: "Bleeding Gums" },
										  { x: 90, y: 360, indexLabel: "Mobile teeth" }
										    /*{ x: 100, y: 509 } */
							]
						}]
					});
					chart.render();
					
					var xSnapDistance = chart.axisX[0].convertPixelToValue(chart.get("dataPointWidth")) / 2;
					var ySnapDistance = 3;
					
					var xValue, yValue;
					
					var mouseDown = false;
					var selected = null;
					var changeCursor = false;
					
					var timerId = null;
					
					function getPosition(e) {
						var parentOffset = $("#chartContainer > .canvasjs-chart-container").offset();          	
						var relX = e.pageX - parentOffset.left;
						var relY = e.pageY - parentOffset.top;
						xValue = Math.round(chart.axisX[0].convertPixelToValue(relX));
						yValue = Math.round(chart.axisY[0].convertPixelToValue(relY));
					}
					
					function searchDataPoint() {
						var dps = chart.data[0].dataPoints;
						for(var i = 0; i < dps.length; i++ ) {
							if( (xValue >= dps[i].x - xSnapDistance && xValue <= dps[i].x + xSnapDistance) && (yValue >= dps[i].y - ySnapDistance && yValue <= dps[i].y + ySnapDistance) ) 
							{
								if(mouseDown) {
									selected = i;
									break;
								} else {
									changeCursor = true;
									break; 
								}
							} else {
								selected = null;
								changeCursor = false;
							}
						}
					}
					
					jQuery("#chartContainer > .canvasjs-chart-container").on({
						mousedown: function(e) {
							mouseDown = true;
							getPosition(e);  
							searchDataPoint();
						},
						mousemove: function(e) {
							getPosition(e);
							if(mouseDown) {
								clearTimeout(timerId);
								timerId = setTimeout(function(){
									if(selected != null) {
										chart.data[0].dataPoints[selected].y = yValue;
										chart.render();
									}   
								}, 0);
							}
							else {
								searchDataPoint();
								if(changeCursor) {
									chart.data[0].set("cursor", "n-resize");
								} else {
									chart.data[0].set("cursor", "default");
								}
							}
						},
						mouseup: function(e) {
							if(selected != null) {
								chart.data[0].dataPoints[selected].y = yValue;
								chart.render();
								mouseDown = false;
							}
						}
					});
					
					}
					</script>
					<div id="chartContainer" style="height: 370px; max-width: 2420px; margin: 0px auto;"></div> 
					</div>
					
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="staff">
							<div class="img-wrap d-flex align-items-stretch">
								<div class="img align-self-stretch" style="background-image: url(images/doc-4.jpg);"></div>
							</div>
							<div class="text pt-3 text-center">
								<h3>Dr. Alicia Henderson</h3>
								<span class="position mb-2">Dentist</span>
								<div class="faded">
									<p>I am an ambitious workaholic, but apart from that, pretty simple person.</p>
									<ul class="ftco-social text-center">
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="icon-twitter"></span></a></li>
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="icon-facebook"></span></a></li>
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="icon-google-plus"></span></a></li>
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="icon-instagram"></span></a></li>
		              </ul>
	              </div>
							</div>
						</div>
					</div>
					</div>	
		</section>


		
    <footer class="ftco-footer ftco-bg-dark ftco-section">
      <div class="container">
        
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
			  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made <i class="icon-symbols" aria-hidden="true"></i> by <a href="" target="_blank">Dental Healthcare</a>
			  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


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
   
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> 
  </body>
</html>