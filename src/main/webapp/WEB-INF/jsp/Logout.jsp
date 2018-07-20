
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
</head>
<body>

<!-----before:<c:out value="${ Employee}"></c:out>--->
<c:remove var="Customer"/>
<!-----after:<c:out value="${Employee}"></c:out>--->
<center>${msg}
<jsp:include page="Login.jsp"></jsp:include>
</center>

	


 </body>
</html>