<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

						<script>
							function sendInfo(productId) {

								//var id=document.getElementById("${cart.value.getProduct_id()}").value;

								var quantity = document
										.getElementById(productId).value;

							//	alert(quantity + "=====" + productId);

								var xhttp = new XMLHttpRequest();

								xhttp.onreadystatechange = function() {

									if (xhttp.readyState == 4
											&& xhttp.status == 200) {

										var cart = xhttp.responseText;
                                           
									//	alert(cart);
										
										
										var cartdetails = cart.split("*"); 
										
										//alert(cartdetails[1]);
									//	alert(productId);
										
										
										
									    document.getElementById('Total').innerHTML=cartdetails[1];
									    
									    document.getElementById("SubTotal"+productId).innerHTML = cartdetails[2];

										document.getElementById("demo").innerHTML = cartdetails[0];
										
										
                                     //   document.getElementById("Total").innerHTML = cartdetails[1];

										
                                             
									}
								};

								xhttp.open("GET", "upDateCart.html?&id="
										+ productId + "&quantity=" + quantity,
										true);

								xhttp.send();

							}
						</script>
						
						
						
						<script>

 function remove(productid) {
	 
	//alert(productid);
  
	 var xhttp = new XMLHttpRequest();
  
	 xhttp.onreadystatechange = function() {
    
		 if (xhttp.readyState == 4 && xhttp.status == 200) {
      
       			// document.getElementById("demo").innerHTML = xhttp.responseText;
    
			 var cart =xhttp.responseText;
			 
			 var cartdetails = cart.split("*");
			 
             
			 document.getElementById('Total').innerHTML=cartdetails[1];
			    
		   document.getElementById("row"+productid).innerHTML=cartdetails[2];

				document.getElementById("demo").innerHTML = cartdetails[0];
				
				

			 
		 }
  
	 };
  
	 xhttp.open("GET","delete.html?id="+productid, true);
  
	 xhttp.send();

 }

 </script>
						
<style>
table {
	margin-top: -20%;


}

#page{

margin-right: 10%;

margin-left: 5%;
}

 th {
	
	colspan="2";

}

td{

colspan ="2";
}

/* #page {
	position: absolute;
	visibility: visible;

} */


/* #page :hover  {
	visibility: visible;
     color:white;
} */

</style>

</head>


<body>
<div id="page" >	

		<table cellpadding="15" cellspacing="15" align="center" >
			<tr>
			
			    
				<th colspan="6" >Product</th>
				<th colspan="4">Name</th>
				<th colspan="4">Quantity</th>
				<th colspan="4">Price</th>
				<th colspan="4">SubTotal</th>
				<th colspan="4">option</th>

			</tr>

			 <c:forEach items="${cartList}" var="cart">
				<tr id="row${cart.value.getProduct_id()}">
					<%-- <c:out value="${cart.key} "/><br> --%>
                     
					<td colspan="6" ><center>
							<img src="image.html?&id=${cart.value.getProduct_id()}"
								width="35%" height="55%" />
						</center></td>

					<td colspan="4"><c:out value="${cart.value.getProduct_Name()} " /></td>

					
					<!-- this form calls send info method and sends 
					product id and quantity to senInfo
					
					 -->
					
					<td colspan="4"><input type="text" id="${cart.value.getProduct_id()}"
						value="${cart.value.getQuantity()}" size="1" maxlength="1" /> <input
						type="submit" value="add" size="1px"
						onclick="sendInfo('${cart.value.getProduct_id()}')"> 
						
                    </td>

					<td colspan="4" ><c:out value="${cart.value.getPrice()} " /></td>

					<td colspan="4"><span id="SubTotal${cart.value.getProduct_id()}">${cart.value.getSub_total()}</span></td>
                   
                   

					<%-- <td><a href="delete.html?Id=${cart.value.getProduct_id()}">delete</a></td> --%>
              
              
              
              
              
              
              <!-- to remove the total selected items from cart -->        
              
              <td colspan="4">  <button type="button" onclick="remove('${cart.value.getProduct_id()}')">remove</button>
                    
				</td>		  
  
				</tr>

			</c:forEach>
 
			<tr height="100%">
				<td colspan="6"><center>Total</center></td>
				<td ><span id="Total">${Total}</span></td>
			</tr>
		</table>

		<a href="body.html"><img
			src="Resources/Continueshopping-Button-24-09-2013-1.png" /></a>





<c:if test="${size>0}">

    <td align="right"><a href="placeOrder.html"><img
			src="Resources/Purchase-Now.png" /></a></td>
</c:if>

   
 
       
</div>
</body>
</html>