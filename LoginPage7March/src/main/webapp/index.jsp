<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<div align = "center">
	    <img src= "logo.jpg" width="100" height="100">
		<h1>Welcome to  Login Page </h1>
		<div>
		<form action ="loginJsp" method="get">
		  
			UserName : <input type="text" name ="name"><br><br>
			Password : <input type="password" name="pass"><br><br>
			<input type="submit" value="submit">
			</div>
	
	</form>
	
	</div>

</body>
</html>