<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.button {
  position: relative;
  background-color: #4CAF50;
  border: none;
  font-size: 22px;
  color: #FFFFFF;
  padding: 10px;
  width: 150px;
  text-align: center;
  -webkit-transition-duration: 0.4s; 
  transition-duration: 0.4s;
  text-decoration: none;
  overflow: hidden;
  cursor: pointer;
}

.button:after {
  content: "";
  background: #90EE90;
  display: block;
  position: absolute;
  padding-top: 300%;
  padding-left: 350%;
  margin-left: -20px!important;
  margin-top: -120%;
  opacity: 0;
  transition: all 0.8s
}


.button:active:after {
  padding: 0;
  margin: 0;
  opacity: 1;
  transition: 0s
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:rgb(173,216,230);">
<h1 style="text-align:center">Welcome to my Project</h1><br><br>

<center>
 <a href="login" > <button class="button">LogIn</button> </a><br><br>
<a href="registration"><button class="button">Registration</button></a>
</center>
</body>
</body>
</html>