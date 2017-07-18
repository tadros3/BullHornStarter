<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<h1>this is the profile page</h1>

	<c:if test="${editProfile==null}">
		<h1>the session doesn't exist</h1>
	</c:if>

	<c:choose>
		<c:when test="${editProfile==false}">
			<table border="1">
				<tr>
					<td>Name:</td>
					<td><c:out value="${username}" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><c:out value="${useremail}" /></td>
				</tr>
				<tr>
					<td>Motto:</td>
					<td><c:out value="${usermotto}" /></td>
				</tr>
			</table>
		</c:when>
		<c:when test="${editProfile==true}">
			<form action="UpdateUser" method="post">
				<table border="1">
					<tr>
						<td>Name:</td>
						<td><input type="text" name="username"
							value="<c:out value="${username}"/>"></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="useremail" 
						    value="<c:out value="${useremail}"/>"></td>
					</tr>
					<tr>
						<td>Motto:</td>
						<td><input type="text" name="usermotto"
						     value="<c:out value="${usermotto}"/>"></td>
					</tr>
				</table>
				<input type="hidden" name="userid" value="${userid}">
				<input type="hidden" name="action" value="updateProfile">
				 <input	type="submit" value="update">
			</form>
		</c:when>
	</c:choose>
<form role="form" action="PostServlet" method="post">
    <div class="form-group">  
       <label for="post" id="charsLeft">Create New Post (141 char):</label>
       <textarea name="posttext" id="posttext" class="form-control" rows="2" placeholder= "Express yourself!" maxlength="141"></textarea>
    </div> 
    <div class = "form-group"> 
       <input type="submit" value="Submit" id="submit"/>
       <input type="reset" value="Clear"/>
    </div>  
</form>
<script>
$(document).ready(function() {
    var text_max = 141;
    $('#charsLeft').html("Create New Post (" + text_max + " char):");

    $('#posttext').keyup(function() {
        var text_length = $('#posttext').val().length;
        var text_remaining = text_max - text_length;

        $('#charsLeft').html("Create New Post (" + text_remaining + " char):");
    });
});
</script>
<ul>
	<c:forEach var="post" items="${userPosts}">
		<li>
			<c:out value="${post.posttext}"/><br>
			<c:out value="${post.postdate}"/>
		</li>
	</c:forEach>
</ul>
</body>
</html>