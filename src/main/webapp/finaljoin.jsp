<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Doctor Profile</title>
<style type="text/css">
.reg table {
	width: 500px;
	height: 425px;
	margin-left: 415px;
	border-style: 50px;
	background-color: floralwhite;
}

.reg input[type="tel"], input[type="number"], input[type="text"],
	input[type="password"], input[type="date"] {
	width: 300px;
	height: 35px;
}
.reg input[readonly="readonly"]	{
	width: 300px;
	height: 35px;
	background-color:#f1f1f1;
}

.reg input[type="submit"] {
	width: 300px;
	height: 35px;
	border-radius:30px;
	border-bottom: 2px solid black;
}

.roundbox {
	display: inline-block;
	height: 40px;
	background-color: #9C9E9E;
	width: 180px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.09);
	text-align: center;
	line-height: 40px;
	border-radius: 30px;
	cursor: pointer;
	color:yellow;
	text-decoration: none;
}
	.welcome	{
  		display: inline-block;
    	float: right;
       	width: 50%;
  		line-height: 40px;
       	border-radius:30px;
      	cursor: pointer;
       }
.container {
	border-radius: 20px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.59);
	background-color: #f2f2f2;
	padding: 2px;
}

h1 {
	text-align: center;
}
</style>
</head>
<body bgcolor="#ADD8E6">
	<%@page import="dba.ConnectionProvider,java.sql.*"%>
	<br>
	<div class="container">

		<ul>
			
			<a href="AdPUpdate.jsp"><li class="roundbox">Update Profile</li></a>
			
			<a href="Logout"><li class="roundbox">Logout</li></a>
			<li class="welcome"><marquee>
		<% 

        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache");	  //HTTP 1.0    
        response.setHeader("Expires", "0");  	//	Proxies 	
				
			       if(session.getAttribute("email")==null){
					response.sendRedirect("DoctorLogin.jsp");
					}
			       else if(session!=null)	{
					String email=(String) session.getAttribute("email");
					out.println("Hello ,  "+email);
					}
				%> </marquee></li>
	</ul>

		<h1>Update Profile</h1>
		<hr>
		<form action="finaljoin" method="get">
	<div class="reg">
 		<% 
			try{
			Connection conn=ConnectionProvider.getConnection();
			Statement stat=conn.createStatement();
 			//String e=(String)session.getAttribute("email");
 			ResultSet rs=stat.executeQuery("select * from  doctors,intimate where "+
 					"doctors.email=intimate.email");
 			while(rs.next()){
 		%> 
	<table border="1px solid black">
		<tr><td></td></tr>
		<tr><td>Doctor ID:</td><td><%= rs.getInt(1)%></td></tr>
		<tr><td>Doctor Name:</td><td><%= rs.getString(2)%></td></tr>
		<tr><td>Email ID:</td><td><%= rs.getString(3)%></td></tr>
		<tr><td>Date :</td><td><%= rs.getString("LEAVEDATE")%></td></tr>
			</table>
	</div>
	</form>
	<br>
	</div>
	<br>
	
 		<%} 
		
 			conn.close();
 			}
 			catch(Exception e){
 				e.printStackTrace();			
 			}
 		%> 
</body>
</html>