<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

nav {
	background-color: #333;
	padding: 10px 0;
	text-align: center;
}

nav a {
	color: #fff;
	padding: 14px 15px;
	text-decoration: none;
	display: inline-block;
	transition: background-color 0.3s;
}

nav a:hover {
	background-color: #555;
}



h1 {
	color: #007bff;
	font-size: 2em;
	
}
#img{
   height:400px;
   width: 670px;
  margin:auto;
   margin-top:50px;
   background-image:url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcToRBimgon8w2JlfD_4K4ztZ2Mzu-Dy8MM6gfMpmRbtu9AZOa0KaTBVsf4--A97PShZo8c&usqp=CAU');
   
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
}
</style>
</head>
<body>
	<%
	String email = (String) request.getAttribute("admin");
	%>
	<nav>
		<a href="home">HOME</a> <a href="add_student">ADD</a> <a
			href="edit_student">EDIT</a> <a href="delete_student">DELETE</a> <a
			href="search">SEARCH</a><a href="Search_id">SEARCHBYID</a> <a href="search_em">SEARCHBYEMAIL</a>
			<a href="search_age">SEARCHBYAGE</a><a href="get_students">ALL STUDENTS</a> <a
			href="delete_admin?email=<%=email%>">DELETE ADMIN</a> <a
			href="log_out">LOG OUT</a>
	</nav>
	<div align="center">
		<h1>WELCOME TO STUDENT MANAGEMENT SYSTEM</h1>
	</div>
	<div id=img></div>
</body>
</html>