<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>

<div align="center">
<h1>Patient Login</h1></div>

<form action="LoginServlet" method="post">

<table>

<tr><td>Enter UserID:</td><td><input type=text name=remail></td></tr>
<tr><td>Enter Password:</td><td><input type=password  name=renterpass></td></tr>
<tr><td></td><td><input type=submit value=login ></td><td><input type=reset></td></tr>
<tr><td><a href="http://localhost:8084/ORegistration/index.jsp">registration</a></td></tr>
<tr><td><a href="forgotPassword.jsp">ForgotPassword</a></td></tr> 
<br><br>
<tr><td><a href="AdminLogin.jsp">AdminLogin</a></td></tr> 

</table>

</form>

</body>
</html>