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
<jsp:include page="/WEB-INF/pages/menu.jsp"></jsp:include>

<!-- <nav> -->
<!-- 	<div id="myHeader"> -->
<!-- 		<ul> -->
<!-- 		<ul> -->
<!-- 						<li class="has-dropdown"> -->
<!-- 							<ul class="dropdown"> -->
<!-- 								<li><a href="#">Visitor Management</a></li> -->
<!-- 								<li><a href="#">Employees Management</a></li> -->
<!-- 								<li><a href="#">Meeting Management</a></li> -->
<!-- 							</ul> -->
<!-- 						</li> -->
<!-- 						<li><a href="#">Help</a></li> -->
<!-- 					</ul>	 -->
<!-- 		</ul> -->
<!-- 		<div class="vl"></div> -->
<!-- 	</div> -->
	
<!-- </nav> -->
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100">
				<s:url  var="reg_meeting" value="/addMeeting"></s:url>
				<f:form action="${reg_meeting}" modelAttribute="mModel">
					<table >
						<tr>
						<td><label for="m_subject"><b><em>Meeting Subject</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="text" path="Meeting.m_subject" /></td>
						</tr>
						<tr>
						<td><label for="m_purpose"><b><em>Meeting Purpose</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="text" path="Meeting.m_purpose" /></td>
						</tr>		
						<tr>
						<td><label for="m_venue"><b><em>Venue</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="text" path="Meeting.m_venue" /></td>
						</tr>
						<tr>
						<td><label for="m_date"><b><em>Date</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="date" path="Meeting.m_date" /></td>
						</tr>
						<tr>
						<td><label for="m_start_time"><b><em>Start time</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="time" path="Meeting.m_start_time" /></td>
						</tr>
						<tr>
						<td><label for="m_end_time"><b><em>End Time</em></b></label></td>
						<td style="border:2px solid black"><f:input  class="form-control" type="time" path="Meeting.m_end_time" /></td>

						</tr>
						<tr>
						<td id="ul"><label for="Employee"><b><em>Employee(s)</em></b></label></td>
						<td id="ul" style="border:2px solid black"><f:input  class="form-control" list="employess"  path="Emp.e_firstname"/></td>
						<datalist id="employess">
						<c:forEach var="u" items="${empList}">
						<option  value="${u.e_firstname } ${u.e_lastname}">
						</c:forEach>
						</datalist>
						</tr>
						<tr>
						<td id="ul"><label for="Visitor"><b><em>Visitor(s)</em></b></label></td>
						<td id="ul" style="border:2px solid black"><f:input  class="form-control" list="visitors" path="Vi.v_firstname"/></td>
						<datalist id="visitors">
						<c:forEach var="u" items="${visitList}">
						<option value="${u.v_firstname} ${u.v_lastname}">
						</c:forEach>
						</datalist>
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