<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.ideas2it.employee.model.Employee"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="update" action="updateEmployee"  method="post">
 <table>
 <%Employee employee = (Employee)request.getSession().getAttribute("employeeToBeUpdated"); %>
 <tr> 
 <td>FirstName:</td>
 <td><input type="text" name="firstName" value='${employeeToBeUpdated.getFirstName()}'/></td>
 </tr>
 <tr>
 <td>LastName:</td>
 <td><input type="text" name="lastName" value='${employeeToBeUpdated.getLastName()}'/></td>
 </tr>
 <tr>
 <td>Phone Number</td>
 <td><input type="text" name="dateOfBirth" required value='${employeeToBeUpdated.getDateOfBirth()}'/></td>
 </tr>
 <tr>
 <td>E-Mail:</td>
 <td><input type="email"  name="email" value='${employeeToBeUpdated.getEmail()}'/></td>
 </tr>
 <tr>
 <td>Date Of Birth</td>
 <td><input type="text" name="phoneNumber value='${employeeToBeUpdated.getPhoneNumber()}'"/></td>
 </tr>
 <tr>
 <td><h3>Current Address:</h3></td>
 </tr>
 <tr> 
 <td>Street</td>
 <td><input type="text" name="currentStreet"/></td>
 </tr>
 <tr>
 <td>Area</td>
 <td><input type="text" name="currentArea"/></td>
 </tr>
 <tr>
 <td>City</td>
 <td><input type="text" name="currentCity" required/></td>
 </tr>
 <tr>
 <td>PinCode</td>
 <td><input type="text"  name="currentPincode"/></td>
 </tr>
 <tr>
 <td><h3>Permanent Address:</h3></td>
 </tr>
 <tr> 
 <td>Street</td>
 <td><input type="text" name="permanentStreet"/></td>
 </tr>
 <tr>
 <td>Area</td>
 <td><input type="text" name="permanentArea"/></td>
 </tr>
 <tr>
 <td>City</td>
 <td><input type="text" name="permanentCity" required/></td>
 </tr>
 <tr>
 <td>PinCode</td>
 <td><input type="text"  name="permanentPincode"/></td>
 </tr>
 <td>Click to Submit</td>
 <td><input type="submit" value="Update"/></td>
 </tr>
 
 </table>
 </form>
</body>
</html>