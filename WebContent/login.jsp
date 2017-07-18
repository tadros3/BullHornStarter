<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Bullhorn</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<div style="float:left;">
<h1>Login</h1>

	<form action="LoginServlet" method="post">
		Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email" value="larry12345@gmail.com"><br/>
		Password:&nbsp;<input type="password" name="password" value="password"><br/>
		<input type="hidden" name="action" value="login">
		<input type="submit" value="Log In">
	</form>
</div>
<div style="float:right;">
<h1>Sign Up</h1>
	<form action="SignupServlet" method="post">
		Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="email"><br/>
		Password:&nbsp;<input type="password" name="password"><br/>
		Username:&nbsp;<input type="text" name="username"><br>
		Motto:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="motto"><br>
		<input type="hidden" name="action" value="login">
		<input type="submit" value="Sign Up">
	</form>
</div>
<p/>
<a href="LoginServlet">What happens if you go directly to login servlet without logging in?</a>
</body>
</html>