<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd"> 
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<HTML>
<HEAD>
    <TITLE>joins of two tables through jsp</TITLE>
</HEAD>
<BODY bgcolor="#6E6E6E">
<font size="+3" color="#F6CECE"><br>Welcome in www.roseindia.net !</font>
<br>
<font size="+1" color="#F2F2F2"><br>Joins of two tables</font>
      <%   int current = 0;
       // declare a connection by using Connection interface 
     Connection connection = null;/* Create string of connection url within specified format with machine 
     name, port number and database name. Here machine name id localhost 
     and database name is student. */
         // String connectionURL = "jdbc:mysql://localhost:3306/student";
               /*declare a resultSet that works as a table resulted by execute a specified 
     sql query. */
     ResultSet rs = null;
%>
<FORM NAME="form1" ACTION="join.jsp" METHOD="GET"><%
    if (request.getParameter("hidden") != null) {
                current = Integer.parseInt(request.getParameter("hidden"));
      }
            // Declare statement.
       Statement statement = null;
       try {
               // Load JDBC driver "com.mysql.jdbc.Driver".
         Class.forName("oracle.jdbc.OracleDriver");
                 /* Create a connection by using getConnection() method that takes 
	 parameters of string type connection url, user name and password to 
	 connect to database. */
         connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pradyumna","pradyumna");
                  /* createStatement() is used for create statement object that is 
	 used for sending sql statements to the specified database. */
         statement = connection.createStatement();
                // executeQuery() method execute specified sql query. 
         rs = statement.executeQuery("select * from  doctors,intimate where "+
			"doctors.email=intimate.email");
			         //for (int i = 0; i < current; i++) {
           rs.next();
           
              if (!rs.next()) {
%>
<FONT size="+2" color="red"></b>
<%
        out.println("Sorry ! found some problems with database.");
    } else {
%>
<TABLE style="background-color: #D8D8D8;" WIDTH="30%">
    
    <TR><TH width="50%">ID</TH><TD width="50%"> <%= rs.getInt(1)%> </TD></tr>
    <TR><TH>Name</TH><TD> <%= rs.getString(2)%> </TD></tr>
    <TR><TH>Email</TH><TD> <%= rs.getString(3)%> </TD></tr>
    <TR><TH>Date</TH><TD> <%= rs.getString("LEAVEDATE")%> </TD></tr>
	
</TABLE>

</FORM>
<%
    }
} 
catch (Exception ex) {
%>
<FONT size="+3" color="red"></b>
    <%
                out.println("Unable to connect to database.");
            } finally {
                // close all the connections.
                rs.close();
                statement.close();
                connection.close();
            }
    %>
</FONT>
</FORM>
</body> 
</html>