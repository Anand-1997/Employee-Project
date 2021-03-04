<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="com.ideas2it.project.model.Project"%>
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
<form action = "assignProject" method = "post">
	<label>Select the Projects you wish to assign</label>
	<select class="selection" multiple size="15" name="pro">
		 <c:forEach items="${projects}" var="project">
	     <option value="${project.projectId}"> ${project.projectName}</option>
	     </c:forEach>
	 </select>  	
	<input type = "hidden" name = "projectId" value = '${project.projectId}'/>
	<button class="btn" type = "submit">Assign</button>

</form>
<!-- <form name="insert" action="assignProject"  method="post">
 <table>
 <tr> 
 <td>ProjectID:</td>
 <td><input type="text" name="projectId"/></td>
 </tr>
 <td>Click to Submit</td>
 <td><input type="submit" value="Assign"/></td>
 </tr>
 </table>
 </form> -->
</body>
</html>