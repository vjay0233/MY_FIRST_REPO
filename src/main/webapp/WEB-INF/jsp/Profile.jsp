<%@page isELIgnored="false" %>
 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
${msg}

<table>
<tr>
      <td>  <c:out value="${Customer1.getFirst_Name()}"/></td>
      <td>  <c:out value="${Customer1.getLast_Name()}"/></td>
        
<tr>
</table>
      