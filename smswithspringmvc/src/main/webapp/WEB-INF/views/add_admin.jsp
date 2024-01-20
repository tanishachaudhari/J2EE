<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

div {
	margin-top: 50px;
}

table {
	width: 80%;
	border-collapse: collapse;
	background-color: #fff;
	border: 1px solid #ccc;
	margin-bottom: 20px;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #007bff;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2; /* Alternate row color */
}

div[align="center"] {
	display: flex;
	justify-content: center;
	align-items: center;
	height: auto;
}

input[type="text"] {
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
	background-color: #007bff;
	border: none;
	border-radius: 4px;
	color: #fff;
	font-size: 16px;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

h1 {
	color: #007bff;
	text-align: center;
	margin-top: 30px;
}

</style>
</head>
<body>
<h1>WELCOME TO SIGNUP PAGE</h1>
<div align="center">

		<form action="add_admin" method="post">
			<table border="1px solid">
				<tr>
					<td>UserName</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
				</tr>
			</table>
			<input type="submit" value="SIGN UP">
		</form>
	</div>
</body>
</html>