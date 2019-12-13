<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Table V01</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
<!--===============================================================================================-->
</head>
<body style="max-width:100%">
<nav>
	<div id="myHeader">
		<ul>
		<ul>
						<li class="has-dropdown">
							<ul class="dropdown">
								<li><a href="#">Dashboard</a></li>
								<li><a href="#">Visitor Management</a></li>
								<li><a href="#">Employees Management</a></li>
								<li><a href="#">Meeting Management</a></li>
							</ul>
						</li>
						<li><a href="#">Register</a></li>
						<li><a href="#">Help</a></li>
					</ul>	
		</ul>
		<div class="vl"></div>
	</div>
	
</nav>
	<c:if test="${param.act == 'wel' }">
	<p>${wel }</p> 
	</c:if>
	<c:if test="${ex !=null }">
	<p>${ex}</p> 
	</c:if>>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
				<button class="button button1">Add New Employee</button>
				<button class="button button2">Edit Employee Details</button>
				<button class="button button3">Delete Selected Employee</button>
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">ID</th>
								<th class="column2">First name</th>
								<th class="column3">Last name</th>
								<th class="column4">Email</th>
								<th class="column5">Department</th>
								<th class="column6">Phone no</th>
							</tr>
						</thead>
						<c:forEach var="u" items="${emplist }">
								<tr>
									<td class="column1">${u.e_Id}</td>
									<td class="column2">${u.e_firstname}</td>
									<td class="column3">${u.e_lastname}</td>
									<td class="column4">${u.e_email}</td>
									<td class="column5">${u.e_department}</td>
									<td class="column6">${u.e_phone}</td>
								</tr>
								
					</c:forEach>
					</table>
					
				</div>
			</div>
		</div>
	</div>


	

<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>