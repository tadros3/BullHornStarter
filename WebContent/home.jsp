<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>this is the home page</h1>
<h1>${message}</h1>
<h1>Welcome, ${user.getUsername()}</h1>
<h2>${user.getMotto()}</h2>
<ul>
	<c:forEach var="post" items="${posts}">
		<li><c:out value="${post.bhuser.username}"/><br>
			<c:out value="${post.posttext}"/><br>
			<c:out value="${post.postdate}"/>
		</li>
	</c:forEach>
</ul>
</body>
</html>