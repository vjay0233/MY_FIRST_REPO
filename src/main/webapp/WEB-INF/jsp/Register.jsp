 <html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
function validation()
{
var a = document.getElementById("t1").value;
if(a=="")
{
alert("Please Enter Your Password");
document.getElementById();
return false;
}
if ((a.length < 4) || (a.length > 8))
{
alert("Your Password must be 4 to 8 Character");
document.form.pass.select();
return false;
}
}
</script>
<script>
$(document).ready(function(){
    $("tr:odd").css("background-color", "white");
    $(":button").hide();
});
</script>
<script lang="javascript">
function check()
{
	var cno=document.getElementById("t2").value;
	if(isNaN(cno))
		{
		alert("enter numbers only");
		}
	else
		{
	
		if(cno.length!=10)
			{
			alert("enter 10 digit number");
			}
		}
	
	}
	</script>
	
	<script>
function validateForm() {
    var x = document.forms["myForm"]["firstname"].value;
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }
}
</script>
	
<style>

#body {
    line-height:50px;
    background-color:white;
    text-align:center;
    float:center;
    padding:150px;	  
    width:80%;
    height:70%;    
}

</style>

</head>

<body id="body">
<center>
	 <table border="0" align="center">
		<form name="myform" method="post" action="register.html">
		<tr>
			<td rowspan="19"></td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr><td><h3>REGISTER HERE</h3></td></tr>
		<tr>
			<td>Title</td>
			<td> 
			<select>
<OPTION>PLEASE SELECT</OPTION>
  <option value="Mr">Mr</option>
  <option value="Mrs">Mrs</option>
  <option value="Ms">Ms</option>
  <option value="Miss">Miss</option>
</select></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text"  name="First_Name" placeholder="enter ur firstname" required></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="Last_Name"
				placeholder="enter your lastname" required></td>
		</tr>
		
		
		<tr>
			<td>email</td>
			<td><input type="email" name="Email"
				placeholder="choose ur email" required></td>
		</tr>
		 <tr>
                        <td>Password</td>
                        <td><input type="Password" name="password" value=""  id="t1" onmouseleave="return validation()"required/></td>
                    </tr>
                   
                   
                   <td>Role</td>
                        <td><input type="text" name="Role" required="required"  /></td>
                    </tr>
		
		<tr>
			<td><input type="submit" value="Register"></td>
			<td><input type="reset" value="Reset" /></td>
			
		</tr>
		</form>
		
		</table>
	 	
	 
	<!--  <form:form method="POST" commandname="person-entity" action="reigster.html">  
<table>  
    <tbody><tr>  
        <td><form:label path="firstName">Name:</form:label></td>  
        <td><form:input path="firstName"></form:input></td>  
    </tr>  
    
    <tr>  
        <td><form:label path="">Age:</form:label></td>  
        <td><form:input path="age"></form:input></td>  
    </tr>  
    
    
    
    
    <tr>  
        <td><form:label path="age">Age:</form:label></td>  
        <td><form:input path="age"></form:input></td>  
    </tr>  
    <tr>  
        <td colspan="2">  
            <input value="Submit" type="submit">  
        </td>  
        <td></td>  
        <td></td>  
    </tr>  
</tbody></table>    
</form:form>  
	  -->
	 
	 
	 </center>
		
		
</body>
</html>