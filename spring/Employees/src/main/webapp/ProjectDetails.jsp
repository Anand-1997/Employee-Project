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
<a href = "/Employees/">Home Page</a>
<h1>Enter the operation you wish to perform</h1>
	<div class="menu">
	<a href="/Employees/AddProject.jsp">
	<button>Add Project</button>
	</a><br>
	<!-- <a href="/project/DeleteEmployee.jsp">
		<button>Delete Employee</button>
	</a><br> -->
	<a href="/Employees/listProjects">
		<button>List Projects</button>
	</a><br>
	<!-- <a href="/project/UpdateEmployee.jsp">
		<button>Update Employee</button>
	</a><br> -->
	<a href="/Employees/DistributeProjects">
		<button>Distribute Projects</button>
	</a>
	</div>
</body>
</html>