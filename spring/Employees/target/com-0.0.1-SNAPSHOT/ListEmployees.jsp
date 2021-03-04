<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="com.ideas2it.employee.model.Address" %>
<%@ page import ="java.util.Set" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "/Employees/EmployeeDetails.jsp">Back To Options</a>

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
            <caption><h2>List of Employees</h2></caption>
            <tr>
                <th>Employee ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Phone Number</th>
                <th>Email</th>
                <th>Date Of Birth</th>
                <th>Status</th>
                <th>Address</th>
                <th>Update/Delete</th>
                <th>Assign Project</th>
            </tr>
           <c:forEach items="${employees}" var="employees">
                <tr>
                    <td><c:out value="${employees.eid}" /></td>
                    <td><c:out value="${employees.firstName}" /></td>
                    <td><c:out value="${employees.lastName}" /></td>
                    <td><c:out value="${employees.dateOfBirth}" /></td> 
                    <td><c:out value="${employees.email}"/></td>
                    <td><c:out value="${employees.phoneNumber}"/></td>
                    <td><c:out value="${employees.status}"/></td>
                    <%-- <% Set<Address> address = employees.getAddress();
       			 	for(Address addresses : address ) %> --%>
                    <td><c:out value="${employees.getAddress()}"/></td>
                    <td class="flex">
                        <form action = "getEmployeeId" method = "post">
                       <input type = "hidden" name = "eid" value = '${employees.eid}'/>
                       <button type="submit">Update</button>
                       </form> 
                       <form action = "deleteEmployee" method = "post">
                       <input type = "hidden" name = "eid" value = '${employees.eid}'/>
                       <button type="submit">Delete</button>
                       </form>
                     </td>
                     <td>
                    <form action = "getAssignEmployeeId" method = "post">
                       <input type = "hidden" name = "eid" value = '${employees.eid}'/>
                       <button type="submit">Assign</button>
                      </form>
                     </td> 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
