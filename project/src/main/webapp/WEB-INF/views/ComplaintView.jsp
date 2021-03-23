<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/hibernate"
        user="root" password="admin"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM complaint;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Complaints</h2></caption>
            <tr>
                <th>ComplaintId</th>
                <th>Complaint Description</th>
                <th>Complaint InCharge</th>
                <th>Subject</th>
                <th>Type</th>
                <th>Status</th>
                <th>Date</th>
                <th>Edit</th>
                
                                
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                 <td><c:out value="${user. comid}" /></td>
                 <td><c:out value="${user.complaint_description}" /></td>
                 <td><c:out value="${user.complaint_incharge}" /></td>
                 <td><c:out value="${user.complaint_subject}" /></td>
                 <td><c:out value="${user.complaint_type}" /></td>
                 <td><c:out value="${user.request_status}" /></td>
                 <td><c:out value="${user.date }" /></td>
                                     <td>
                    <a href="/edit/${complaint.complaint_id}">Update</a>
                    &nbsp;&nbsp;&nbsp;
                </td>
                </tr>
            </c:forEach>
            <a href="welcome">Back To Previous page</a>
        </table>
    </div>

</body>
</html>