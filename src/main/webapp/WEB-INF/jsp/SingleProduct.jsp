<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#page {
	margin-left: 14%;
	margin-right: 20%;
}
</style>




</head>

<body>






	<div id="page">

		<center>

			<ul>
				<li><c:forEach items="${msg}" var="item">

						<li>

							<table cellpadding="10" cellspacing="10">
								<tr>
								<tr>
									<th colspan="5"><img
										src="image.html?&id=${item.getProduct_id()}" width="300"
										height="400"></th>

									<th rowspan="">

										<table>

											<!--       <tr><button  onclick="myCart()" >BUY</button></tr> -->



											<tr colspan="6">
												<td>Dress:</td>
												<td colspan="6"><mark>
													<c:out value="${item.getProduct_Name()}" /></mark></td>
											</tr>

											<tr>
												<td>Price:</td>
												<td><c:out value="${item.getPrice()}" /></td>
											</tr>

											<tr>
												<td>Id:</td>
												<td><c:out value="${item.getSuper_id()}" /></td>
											</tr>

											<tr>
												<td>SubTotal:</td>
												<td><c:out value="${item.getSub_total()}" /></td>
											</tr>

											<tr>
												<td>quantity:</td>
												<td><c:out value="${item.getQuantity()}" /></td>
											</tr>

											<tr>
												<td>quantityId:</td>
												<td><c:out value="${item.getProduct_id()}" /></td>
											</tr>

											<button type="button" onclick="loadDoc( )">Add To
												Cart</button>

                                       <script>

 function loadDoc() {
	 
	/*  alert("${item.getProduct_id()}"); */
  
	 var xhttp = new XMLHttpRequest();
  
	 xhttp.open("GET","cart.html?id=${item.getProduct_id()}" , true);
	  
	 xhttp.send();
 
	
	xhttp.onreadystatechange = function() {
    
		 if (xhttp.readyState == 4 && xhttp.status == 200) {
      
			 document.getElementById("demo").innerHTML = xhttp.responseText;
    
		 }
  
	 };
  
	 
 }

 </script>
                                       											

										</table>
									</th>


								</tr>
							</table>

						</li>

					</c:forEach></li>
			</ul>
		</center>
	</div>


</body>
</html>