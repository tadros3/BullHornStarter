<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>this is the search page</h1>

<form action="NewsfeedServlet" method="post">
	Search by User ID<input type="text" name="userid" /><br>
	Search by keyword<input type="text" name="searchtext" /><br>
	<input type="hidden" name="action" value="search">
	<input type="submit" value="Search">
</form>
</body>
</html>