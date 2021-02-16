<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.ideas2it.employee.model.Employee"%>
    <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.selection{
width : 200px;
height : 200px;
}
form{
display: flex;
flex-direction: column;

}
</style>

</head>
<body>
<!-- <form name="insert" action="assignEmployee"  method="post"> -->

<form action = "assignEmployee" method = "post">
	<label>Select the Employees you wish to assign</label>
	<select class="selection" multiple size="15" name="emp">
		 <c:forEach items="${employees}" var="employee">
	     <option value="${employee.eid}"> ${employee.firstName}</option>
	     </c:forEach>
	 </select>  	
	<input type = "hidden" name = "eid" value = '${employee.eid}'/>
	<button class="btn" type = "submit">Assign</button>

</form>






 <%-- <table>
 <tr>
                <th>EmployeeID</th>
                <th>FirstName</th>
                <th>Distribute</th>               
            </tr>
            <tr>
            <td><select multiple size="15" name="emp">
            <c:forEach items="${employees}" var="employee">
            	 <option value="${employee.eid}">
        	${employee.firstName}
    </option>
            </c:forEach>
            </select>  	
             </td>
             </tr>
           <c:forEach items="${employees}" var="employee">
                <tr>
                	
                    <td><c:out value="${employee.eid}" /></td>
                    <td><c:out value="${employee.firstName}" /></td>
                    <td>
                    
                       <form action = "assignEmployee" method = "post">
                       <input type = "hidden" name = "eid" value = '${employee.eid}'/>
                     <button class="btn" type = "submit">Assign</button>
						</form>
                    </td>
                </tr>
          </c:forEach>
</td>
</tr>
<!-- <tr>
 <td>Click to Submit</td>
 <td><input type="submit" value="Assign"/></td>
 </tr> -->
 </table> --%>
</body>
</html>