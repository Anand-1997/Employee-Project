<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Application</title>
    <style>
     .flex{
     display:flex;
     flex-direction: row;
     justify-content: space-between;
     }
    </style>
</head>
<body>
<a href = "/Employees/ProjectDetails.jsp">Back To Options</a>
<!-- <div style="position: absolute; width: 250px;">
            <a href="Employees/ProjectDetails.jsp" class="previous round">&#8249;</a>
     </div> -->
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <center>
        <h1>Project</h1>
        <!-- <h2>
            <a href="jsp/projectForm.jsp">Add New project</a>
            &nbsp;&nbsp;&nbsp;
            <a href="jsp/cinemax.jsp">  <button class="btn" type = "submit"><i class="fa fa-home"></i></button></a>
        </h2> -->
    </center>
    <div align="center">
        <table border="1" cellspacing="10" cellpadding="1" width="100%">
            <caption><h2>List of projects</h2></caption>
            <tr>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Due Date</th>
                <th>Manager Name</th>
                <th>Status</th>
                <th>Update/Delete</th>
            </tr>
           <c:forEach items="${projects}" var="projects">
                <tr>
                    <td><c:out value="${projects.projectId}" /></td>
                    <td><c:out value="${projects.projectName}" /></td>
                    <td><c:out value="${projects.dueDate}" /></td>
                    <td><c:out value="${projects.managerName}" /></td> 
                    <td><c:out value="${projects.status}"/></td>
                    <td class="flex">
                       <form action = "getUpdateId" method = "post">
                       <input type = "hidden" name = "projectId" value = '${projects.projectId}'/>
                       <button type="submit">Update</button>
                       </form> 
                       <form action = "deleteProject" method = "post">
                       <input type = "hidden" name = "projectId" value = '${projects.projectId}'/>
                       <button type="submit">Delete</button>
                       </form>
                     </td>
                     <td>
                     <form action = "getAssignProjectId" method = "post">
                       <input type = "hidden" name = "projectId" value = '${projects.projectId}'/>
                       <button type="submit">Assign</button>
                      </form>
                      </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>