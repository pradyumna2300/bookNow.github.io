<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="TemplateMo">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Host Cloud Template - Services</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-host-cloud.css">
    <link rel="stylesheet" href="assets/css/owl.css">
<title>Insert title here</title>
</head>
  <style>
.cent {
	position: relative;
	text-align: center;
}

.top-left {
	position: absolute;
	top: 15px;
	left: 100px;
	color: black;
	font-size: 40px;
}

.text-block {
	position: absolute;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.99);
	border-radius:30px;
	bottom: 130px;
	right: 100px;
	background-color: white;
	color: white;
	padding-left: 80px;
	padding-right: 80px;
}
 .text-block a	{
 	color: blue;
	 	
 }		
.topnav {
	overflow: hidden;
	background-color: #21618C;
}

.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: gray;
	color: black;
}
 blink {
           color:red;
           -webkit-animation: blink 1s step-end infinite;
           animation: blink 1s step-end infinite
         }
 @keyframes blink {
         67% { opacity: 0 }
        }
	 
</style>

<body>
	<jsp:include page="Header.jsp" />

	<div class="topnav" class="containerh">
		<a href="Home.jsp">Home</a> <a href="Specialization.jsp">Specialization</a>
		<a href="Contact.jsp">Contact</a> <a href="About.jsp">About</a>
	</div>
	
<marquee style="font-size: 30px;" onmouseover="this.stop();" onmouseout="this.start();"><blink> &#9733</blink>  Need an appointment ?  <a href="PatientRegister.jsp" style="color: black;"> Get Registered</a>
	</marquee>

	
	
    <div id="preloader">
        <div class="jumper">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>  
    <!-- ***** Preloader End ***** -->

    <!-- Page Content -->
    <!-- Heading Starts Here -->
    
    <div class="page-heading header-text">
    
      <div class="container">
        		
		
        <div class="row">
        <div class="col-md-12">

            <h1><span>Book Appointment</h1>
            <br>
          </div>
	  <div class="col-md-12">
	   <div class="functional-buttons">
            <ul>
               <li><a href="PatientLogin.jsp"><b>Click Here</b></a></li>
             
            </ul><br><br>
          </div>
	  </div>
<br>
        
		<img src="Img/home1.png" alt="Doctor Appointment System"
			style="width: 1200px; height: 375px;">
	<br>
     
		<div class="text-block">
		    
			<br>
			<div class="col-md-12">
	   			<div class="functional-buttons">
            		<ul>
               			<li><a href="AdminLogin.jsp">Admin  Login</a></li>
				
             
            </ul>
          </div>
	  </div><br>
			<div class="col-md-12">
	   			<div class="functional-buttons">
            		<ul>
               			<li><a href="ReporterLogin.jsp"><b>Reporter Login</b></a></li>
				
             
            </ul>
          </div>
	  </div><br>
			<div class="col-md-12">
	   			<div class="functional-buttons">
            		<ul>
               			<li><a href="PatientLogin.jsp"><b>Patient Login</b></a></li>
				
             
            </ul>
          </div>
	  </div><br>
		
		</div>
	

        </div>
      </div>
    </div>
    <!-- Heading Ends Here -->
    
     



	
   
    <!-- Footer Starts Here -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="footer-item">
              <div class="footer-heading">
                <h2></h2>
              </div>
              <p><br><br><br><br><br><br></p>
            </div>
          </div>
          
          
          
            <div class="col-md-12">
            <div class="sub-footer">
              <p>Copyright &copy; 2020 Cloud Hosting Company
				- Designed by <a rel="nofollow" href="https://templatemo.com">TemplateMo</a></p>
            </div>
          </div>
        </div>
      </div>
    </footer>
    <!-- Footer Ends Here -->


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Additional Scripts -->
    <script src="assets/js/custom.js"></script>
    <script src="assets/js/owl.js"></script>
    <script src="assets/js/accordions.js"></script>

    <script language = "text/Javascript"> 
      cleared[0] = cleared[1] = cleared[2] = 0; //set a cleared flag for each field
      function clearField(t){                   //declaring the array outside of the
      if(! cleared[t.id]){                      // function makes it static and global
          cleared[t.id] = 1;  // you could use true and false, but that's more typing
          t.value='';         // with more chance of typos
          t.style.color='#fff';
          }
      }
    </script>
	




</body>
</html>