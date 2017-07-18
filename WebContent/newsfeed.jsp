<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<h1>this is the newsfeed page</h1>
<!-- 
I've hard coded three posts here to show you what this might look like. 
The newsfeed servlet would be called to query the database and populate the
posts into an arraylist which would be displayed in this JSP
-->
<ul>
	<c:forEach var="post" items="${filteredPosts}">
		<li><c:out value="${post.bhuser.username}"/><br>
			<c:out value="${post.posttext}"/><br>
			<c:out value="${post.postdate}"/>
		</li>
	</c:forEach>
</ul>
</body>
</html>