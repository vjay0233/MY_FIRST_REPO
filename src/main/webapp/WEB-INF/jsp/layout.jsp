<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>

#page{

margin-left: 15%;
margin-right: 15%;

height: 100%;
}



#header {
     background-color:orange;
    color:grey;
    text-align:left;
    padding:15px;
    font-family:Arial, Helvetica, sans-serif;
    width:94.5%;
   border: 2px;
   padding-top: 2px;
   
   margin-top: 10px;
}
 



#body {
  line-height:50px;
    background-color:white;
    text-align:center;
    float:center;
    padding:300px;	  
    width:60%;
    height:90%;
}

#footer {
   
   background-color:white;
    color:grey;
    clear:both;
    text-align:center;
   padding:3px;	
   width:100%; 
     	
   	 	 
}
</style>
</head>
<body > 


   <div id="page">
            
            <div id="header" >
            <h1><tiles:insertAttribute name="header" /></h1>
            </div>  
            
            
            
            
            <div id="navigation_bar" style="float:left;padding:3px;width:100%;border-left:0px solid grey;border-right:0px solid grey;">
            <tiles:insertAttribute name="navigation_bar"/>
            </div>
            
                        
            
            
             <div id="body">
            <tiles:insertAttribute name="body" /> 
            </div>
            
            
            
            <div id="footer">
          <tiles:insertAttribute name="footer" />  
            </div>
          
          
            
</div>
</body>
</html>