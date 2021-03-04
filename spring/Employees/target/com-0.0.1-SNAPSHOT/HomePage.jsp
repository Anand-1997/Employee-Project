<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
	body{
	display : flex;
	flex-direction: column;
	}
	h1{
		align-self:center;	
	}
	.main{
	display: flex;
	margin-bottom: 50px;
	}
	button{
	padding: 15px 15px;
	font-size: 30px;
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
	<h1>Welcome to Employee Project Details !!!!</h1>
	<div class="main">
	<a href = "EmployeeDetails.jsp" >
		<button> Employee Details</button>
	</a>
	<a href = "ProjectDetails.jsp" >
		<button> Project Details</button>
	</a>
	</div>
</body>
</html>