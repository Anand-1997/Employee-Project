<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
    <html>  
    <head>     
    <title>Add Employee Form</title>  
    </head>  
    <body>  
    <a href = "/Employees/ProjectDetails.jsp">Back To Options</a>
 <h2>Enter The Employee Details:</h2>
 <form name="insert" action="addProject"  method="post">
 <table>
 <tr> 
 <td>ProjectName:</td>
 <td><input type="text" name="projectName"/></td>
 </tr>
 <tr>
 <td>Due Date:</td>
 <td><input type="date" name="dueDate"/></td>
 </tr>
 <tr>
 <td>Manager Name:</td>
 <td><input type="text" name="managerName" required/></td>
 </tr>
 <td>Click to Submit</td>
 <td><input type="submit" value="Add"/></td>
 </tr>
 
 </table>
 </form>
      
    </body>  
    </html>