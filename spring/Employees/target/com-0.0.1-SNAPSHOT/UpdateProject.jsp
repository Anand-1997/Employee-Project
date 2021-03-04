<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.project.model.Project"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Update Details:</h2>
 <form name="update" action="updateProject"  method="post" >
 <table>
 <%Project project = (Project)request.getSession().getAttribute("projectToBeUpdated"); %>
 <tr> 
 <td>ProjectName:</td>
 <td><input type="text" name="projectName" value='${projectToBeUpdated.getProjectName()}'/></td>
 </tr>
 <tr>
 <td>Due Date:</td>
 <td><input type="date" name="dueDate" value='${projectToBeUpdated.getDueDate()}'/></td>
 </tr>
 <tr>
 <td>Manager Name:</td>
 <td><input type="text" name="managerName" required value='${projectToBeUpdated.getManagerName()}'/></td>
 </tr>
 <td>Click to Submit</td>
 <td><input type="submit" value="Update"/>
 </td>
 </tr>
 
 </table>
 </form>
</body>
</html>