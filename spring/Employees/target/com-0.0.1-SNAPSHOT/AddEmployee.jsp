<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>  
    <html>  
    <head>     
    <title>Add Employee Form</title>  
    </head>  
    <body>  
 <h2>Enter The Employee Details:</h2>
 <form name="insert" action="addEmployee"  method="post">
 <table>
 <tr> 
 <td>FirstName:</td>
 <td><input type="text" name="firstName"/></td>
 </tr>
 <tr>
 <td>LastName:</td>
 <td><input type="text" name="lastName"/></td>
 </tr>
 <tr>
 <td>DateOfBirth:</td>
 <td><input type="date" name="dateOfBirth" required/></td>
 </tr>
 <tr>
 <td>E-Mail:</td>
 <td><input type="email"  name="email"/></td>
 </tr>
 <tr>
 <td>PhoneNumber:</td>
 <td><input type="text" name="phoneNumber"/></td>
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
 <td><input type="submit" value="Add"/></td>
 </tr>
 
 </table>
 </form>
      
    </body>  
    </html>