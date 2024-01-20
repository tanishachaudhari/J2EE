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
	 background-image:url('https://t4.ftcdn.net/jpg/04/60/71/01/240_F_460710131_YkD6NsivdyYsHupNvO3Y8MPEwxTAhORh.jpg');
   
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
}



table {
	width: 300px;
	border-collapse: collapse;
	background-color: #fff;
	border: 1px solid #ccc;
	margin-top: 200px;
}

td {
	padding: 10px;
	text-align: left;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #65B741;
	border: none;
	border-radius: 4px;
	color: #fff;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #1B4242;
}

a {
	text-decoration: none;
	color: #A1EEBD;
	background-color:gray;
 margin-top:30px;
	display: block;
}

a:hover {
	text-decoration: underline;
}

div[align="center"] {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: auto;
}

h1 {
	
	color: #007bff;
}
#hyp{
margin-top: 20px;
}
</style>
</head>
<body>
	<div align="center" id=img>
		<form action="log_in" method="post">
			<table border="1px solid">
				<tr>
					<td>Email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
				</tr>
			</table>
			<input type="submit" value="LOG IN">
		</form>
	</div>
	<div align="center">
		<a href="add_admin">New user? Create account</a>
	</div>
	<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<div align="center" id=hyp>
		<h1><%=message%></h1>
	</div>
	<%
	}
	%>
</body>
</html>