<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
li{
display:inline-block;

margin: 50px;
}

#page{
margin-left: 5%;

margin-right: 5%;


}



</style>

</head>
<body>

<div id="page">


<ul><li>
<c:forEach items="${msg}" var="item">         
         <li>
      <table> <tr>      
      
    <tr> <td><a href="singleProduct.html?&ProductId=${item.getProduct_id()}"><img src="image.html?&id=${item.getProduct_id()}" height="120%" width="120%"></a><br></td></tr>
       
      <tr><td>Name :<c:out value="${item.getProduct_Name()}"/></td></tr>
         
       <tr><td>Price:<c:out value="${item.getPrice()}"/></td></tr>
        
         
     
         
         </tr></table>
        
        </li>
            
     </c:forEach>
     </li></ul>

</div>
</body>
</html>