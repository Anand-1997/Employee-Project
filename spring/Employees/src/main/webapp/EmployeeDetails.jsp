<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Details</title>
<style>
.menu{
display:flex;
justify-content: space-between;
}
.menu button{
	padding: 15px 15px;
	font-size: 20px;
	display: inline-block;
	border-style: none;
	background: grey;
	border-radius: 999px;
	}
	a :hover{
		color: orange;	
	}
</style>
</head>
<body>
<h1>Enter the operation you wish to perform</h1>
	<div class="menu">
	<a href="AddEmployee.jsp">
	<button>Add Employee</button>
	</a><br>
	<!-- <a href="/project/DeleteEmployee.jsp">
		<button>Delete Employee</button>
	</a><br> -->
	<a href="listEmployees">
		<button>List Employees</button>
	</a><br>
	<!-- <a href="/Employees/assignProject">
		<button>Assign Projects</button>
	</a><br> -->
	<!-- <a href="/project/UpdateEmployee.jsp">
		<button>Update Employee</button>
	</a><br>
	<a href="retriveEmployee.jsp">
		<button>Retrive Employee</button>
	</a> -->
	</div>
</body>
</html>
