<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="http://malsup.github.com/jquery.cycle2.js"></script>
<style type="text/css">

*{
margin:0;
padding:0;
}
#container{
width: 100%;
height: 500px;
overflow: hidden;
background: white;

margin-top: -20%;
margin-right: 

float: right;
}
#slideshow{
height: 100%;
width: 100%;
}
#slideshow img {
	height: 100%;
	width: 100%;
}
#pager{
height: 80px;
width: 60%;
position: absolute;
bottom: 5%;

z-index: 1000;
opacity:0;
transition:all 0.5s ease-in-out os;
}
#pager:HOVER {
	opacity:1;
}
#prev{
height: 12px;
width: 80px;
position: absolute;
top: 0;
bottom: 0;
left: 0;
margin: auto 10px;
}
#next{
height: 0px;
width: 0px;
position: absolute;
top: 0;
bottom: 0;
left: 0;
right:0;
margin: auto up;

}

#pager img {
margin: 5px;
opacity:0.6;
transition:all 0.5s ease-in-out os;

}
#pager img h:HOVER {
	opacity:1;
	transition:scale(1.05);
	z-index: 800;
}


</style>


</head>
<body>


<div id="container" >
<div id="slideshow" class="cycle-slideshow"  data-cycle-fx="fade" 
data-cycle-speed="600"
data-cycle-timeout="2000"
data-cycle-pager="#pager"
data-cycle-pager-template="<a href='#'><img src='{{src}}' width=120 height=80></a>"
data-cycle-next="#next"
data-cycle-prev="#prev"
data-cycle-manual-fx="scrollHorz"
data-cycle-manual-speed="500"
data-cycle-pager-fx="fade">

<img src="Resources/yepme-logo.gif" alt=""/>
<img src="Resources/tamannah.jpg" alt=""/>
<img src="Resources/Dresses_4Dec.jpg" alt=""/>
<img src="Resources/sharuk.jpg" alt=""/>
<img src="Resources/shoe.jpg" alt=""/>
<img src="Resources/Watches.jpg" alt=""/>

<img src="Resources/12342774_1523135911346013_2783959443908045681_n.jpg" alt="" style="height:145%"/>

</div>
<div>
<div id="pager"></div>
<img id="prev" src=""/>

<img id="next" src="Resources/sharuk.jpg"/>
<img id="next"src="Resources/tamannah.jpg"/>
</div>




</div>
<br>
</body>
</html>