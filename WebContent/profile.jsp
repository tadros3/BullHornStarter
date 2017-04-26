<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<table>
<c:choose>
    <c:when test="${editProfile==false}">
<tr><td>Name:</td><td><c:out value="${user.username}"/></td></tr>
<tr><td>Email:</td><td><c:out value="${user.email}"/></td></tr>
<tr><td>Motto: </td><td><c:out value="${user.motto}"/></td></tr>
</table>
    </c:when>
    <c:when test="${editProfile==true}">
<form action="UpdateUser" method="post">
<table>
<tr><td>Name:</td><td><input type="text" value="<c:out value="${user.username}"/>"></td></tr>
<tr><td>Email:</td><td><input type="text" value="<c:out value="${user.email}"/>"></td></tr>
<tr><td>Motto: </td><td><input type="text" value="<c:out value="${user.motto}"/>"></td></tr>
</table>
<input type="submit" value="update">
</form>
    </c:when>
</c:choose>

</body>
</html>