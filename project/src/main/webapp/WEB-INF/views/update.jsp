<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("id");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "test";
String userid = "root";
String password = "admin";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from users where id="+id;
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<body>
<h1>Update data from database in jsp</h1>
<form method="post" action="update-process.jsp">
<input type="hidden" name="id" value="<%=resultSet.getString("id") %>">
<input type="text" name="id" value="<%=resultSet.getString("id") %>">
<br>
Complaint Description:<br>
<input type="text" name="complaintDescription" value="<%=resultSet.getString("complaintDescription") %>">
<br>
Complaint InCharge:<br>
<input type="text" name="complaintIncharge" value="<%=resultSet.getString("complaintIncharge") %>">
<br>
Subject:<br>
<input type="text" name="complaintSubject" value="<%=resultSet.getString("complaintSubject") %>">
<br>
Type:<br>
<input type="text" name="complaintType" value="<%=resultSet.getString("complaintType") %>">
<br><br>
Status:<br>
<input type="text" name="requestStatus" value="<%=resultSet.getString("requestStatus") %>">
<br><br>
Date:<br>
<input type="text" name="date" value="<%=resultSet.getString("date") %>">
<br><br>
<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>