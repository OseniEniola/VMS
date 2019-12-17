<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Meeting Management</title>
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
								<li><a href="/visitor">Visitor Management</a></li>
								<li><a href="/employee">Employees Management</a></li>
								<li><a class="active" href="/meetingList">Meeting Management</a></li>
							</ul>
						</li>
						<li><a href="#">Register</a></li>
						<li><a href="#">Help</a></li>
					</ul>	
		</ul>
		<div class="vl"></div>
	</div>	
</nav>
<s:url value="/add_meeting" var="url_meet"></s:url>
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
				<button class="button button1" href="${url_meet}">Add New Meeting</button>
				
					<table>
						<thead>
							<tr class="table100-head">
								<th class="column1">ID</th>
								<th class="column2">Meeting Host</th>
								<th class="column3">Meeting Purpose</th>
								<th class="column4">Meeting Venue</th>
								<th class="column5">Meeting Subject</th>
								<th class="column3">Meeting Date</th>
								<th class="column3">Meeting Start Time</th>
								<th class="column3">Meeting End Time</th>
								<th class="column3">Meeting Status</th>
								
							</tr>
						</thead>
						<c:forEach var="u" items="${m_list }">
								<tr>
									<td class="column1">${u.m_id}</td>
									<td class="column2">${u.m_host}</td>
									<td class="column3">${u.m_purpose}</td>
									<td class="column4">${u.m_venue}</td>
									<td class="column5">${u.m_subject}</td>
									<td class="column3">${u.m_date}</td>
									<td class="column3">${u.m_start_time}</td>
									<td class="column3">${u.m_end_time}</td>
									<td class="column3">${u.m_status}</td>
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