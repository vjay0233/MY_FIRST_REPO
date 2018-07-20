<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
<style>
#navMenu {
	margin: 0;
	padding: 0px;
}

#navMenu ul {
	margin: 0;
	padding: 0px;
	line height: 20px;
}

#navMenu li {
	
	internal-style: none;
	position: relative;
	float: left;
	text-align: center;
	background:gray;
	padding:0px;
	width: 130px;
	height: 30px;
}

#navMenu ul li a {
	
	text-decoration: none;

	border: 0px;
	color: black;
	
}

#navMenu ul ul {
	position: absolute;
	visibility: hidden;

}

#navMenu ul li:hover ul {
	visibility: visible;
     color:white;
}



#navMenu a:hover {
	color:red;
}
</style>
</head>

<body>
<div id="wrapper">
<div id="navMenu">


 <c:forEach items="${Category}" var="customer">
 
  <ul style="list-style-type: none">
    
    <li>

     <a href="#"><c:out value="${customer.key}"/> </a> 
   
   <ul style="list-style-type: none">
  
   <li>
   
<c:forEach items="${customer.value}" var="item">
  
          <li><a href="customer.html?&ProductId=${item.getCategory_Id()}"><c:out value="${item.getCategory_Name()}"/> </a></li>
         
    </c:forEach>
    
    
    </li>
    
    </ul>
    </li>
    
    </ul>
    
    </c:forEach>
    

</div>
</div>

</body>
</html>





