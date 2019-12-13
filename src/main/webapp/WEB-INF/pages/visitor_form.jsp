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
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
				<s:url  var="reg_visitor" value="/addvisitor"></s:url>
				<f:form action="${reg_visitor}" modelAttribute="command">
					<table >
						<tr>
						<td><label for="e_firstname"><b><em>First Name</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="text" path="vcmd.V_firstname" /></td>
						</tr>
						<tr>
						<td><label for="e_lastname"><b><em>Last Name</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="text" path="vcmd.V_lastname" /></td>
						</tr>		
						<tr>
						<td><label for="e_email"><b><em>Email</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="email" pattern=".+verraki.com" placeholder="example@verraki.com" path="vcmd.V_email" /></td>
						</tr>
						<tr>
						<td><label for="e_password"><b><em>Phone</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="text" pattern="[0-9]{11}" placeholder="09000013312" path="vcmd.V_phone" /></td>
						</tr>
						<tr>
						<td><label for="e_address"><b><em>Address</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="text" path="vcmd.v_address" /></td>
						</tr>
						<tr>
						<td><label for="e_company"><b><em>Company</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="text" path="vcmd.V_company" /></td>
						</tr>
						<tr>
						<td style="align:right" colspan=2><input type="submit" class="btn btn-primary btn-block" value="Submit"></td>
						</tr>
					</table>
					
					</f:form>
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