<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
a {
	text-decoration: none;
}

ul {
	float: left;
	margin-top: -40px;
	margin-left: -60px;
}

li {
	display: inline;
}

button {
	float: right;
}

body {
	
}
</style>


</head>
<body>

  <center> <td><input type="text"></td><td><input type="button" value="search"></td><c/enter>
	<img src="Resources/yepme-logo.gif"
		style="float: left; margin-left: -15px">

<%-- <c:if test="${sessionScope.Customer != null}">
    <a href="logout.html" >Logout</a>
</c:if>

<c:if test="${sessionScope.Customer = null}">
    <a href="login.html" style="float: right;"><small
		style="font-size: small;">Login</small></a>
       
</c:if> --%>


	<%--  <c:choose>
    <c:when  test="${sessionScope.Customer != null}">
       
       
       <a href="logout.html" >Logout</a>
       
    </c:when>
    <c:otherwise>
       
       <a href="login.html" style="float: right;"><small
		style="font-size: small;">Login</small></a>
       
    </c:otherwise>
</c:choose>
 --%>	
	
	<c:choose>
    <c:when  test="${sessionScope.Customer1 != null}">
       
     <%--   Hello :  <td>  <c:out value="${Customer.getFirst_Name()}"/></td> --%>
       <a href="profile.html" ><small
		style="font-size: small;">Profile</small></a>
       <!-- <p align="right"><a href="logout.html" >Logout</a></p> -->
       
       
       <a href='<c:url value="/j_spring_security_logout" />' > <small
		style="font-size: small;">Logout</small></a>
       
    </c:when>
    
    <c:otherwise>
       
       <a href="login.html" style="float: right;"><small
		style="font-size: small;">Login</small></a>
       
      
    </c:otherwise>
</c:choose>
	
	
	
	<!-- <a href="reg.html" style="float: right;"><small
		style="font-size: small;">Register</small></a>
 -->
	<a href="body.html" style="float: right;"><small
		style="font-size: small;">Home</small></a>

	<a href="addToCart.html"><img src="Resources/index.png"
		style="float: right; margin-right: 50px; background-color: white;"
		height="50px" ,width="10px"> 
		<span id="demo"style="float: right; margin-right: 8">${size}</span> 
		
		
		</a>
</body>
</html>