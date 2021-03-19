<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/hibernate";%>
<%!String user = "root";%>
<%!String psw = "admin";%>
<%
String comid = request.getParameter("comid");
String complaintDescription=request.getParameter("complaintDescription");
String complaintType=request.getParameter("complaintType");
String complaintIncharge=request.getParameter("complaintIncharge");
String complaintStatus=request.getParameter("complaintStatus");
if(comid != null)
{
Connection con = null;
PreparedStatement ps = null;
int complaintID = Integer.parseInt(comid);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update complaint set comid=?,complaintDescription=?,complaintType=?,complaintIncharge=?,complaintStatus=? where comid="+comid;
ps = con.prepareStatement(sql);
ps.setString(1,comid);
ps.setString(2, complaintDescription);
ps.setString(3, complaintType);
ps.setString(4, complaintIncharge);
ps.setString(5, complaintStatus);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
}
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>