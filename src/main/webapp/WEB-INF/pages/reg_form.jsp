<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
	
	<!-- Animate.css -->
	<s:url value="css/animate.css" var="css1"></s:url>
	<link rel="stylesheet" href="${css1 }">
	
	<!-- Icomoon Icon Fonts-->
	<s:url var="css2" value="css/icomoon.css"></s:url>
	<link rel="stylesheet" href="">
	
	<!-- Themify Icons-->
	<s:url var="css3" value="css/themify-icons.css"></s:url>
	<link rel="stylesheet" href="${css3 }">
	
	<!-- Bootstrap  -->
	<s:url value="css/bootstrap.css" var="css4"></s:url>
	<link rel="stylesheet" href="${css4 }">

	<!-- Magnific Popup -->
	<s:url value="css/magnific-popup.css" var="css5"></s:url>
	<link rel="stylesheet" href="${css5 }">

	<!-- Magnific Popup -->
	<s:url value="css/bootstrap-datepicker.min.css" var="css6"></s:url>
	<link rel="stylesheet" href="${css6 }">

	<!-- Owl Carousel  -->
	<s:url value="css/owl.carousel.min.css" var="css7"></s:url>
	<s:url value="css/owl.theme.default.min.css" var="css8"></s:url>
	<link rel="stylesheet" href="${css7 }">
	<link rel="stylesheet" href="${css8 }">

	<!-- Theme style  -->
	<s:url var="css9" value="css/style.css"></s:url>
	<link rel="stylesheet" href="${css9 }">

	<!-- Modernizr JS -->
	<s:url value="js/modernizr-2.6.2.min.js" var="src1"></s:url>
	<script src="${src1 }"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	
	<script src="js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<header id="gtco-header" class="gtco-cover gtco-cover-md" role="banner" style="background-image: url(images/img_bg_2.jpg)">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				
					<div class="row row-mt-15em">
						
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<h3>Sign Up Form</h3>
											<s:url var="url_register" value="/register"></s:url>
											
											<f:form action="${url_register } modelAttribute="command" >
												<div class="row form-group">
													<div class="col-md-12">
														<label for="e_firstname">First Name</label>
														<f:input class="form-control" type="text"   path="emp.e_firstname"/>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="E_lastname">Last Name</label>
														<f:input   class="form-control" type="text"   path="emp.e_lastname"/>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="E_phone">Phone no</label>
														<f:input   class="form-control" type="tel" pattern="[0-9]{11}" placeholder="08168432657" path="emp.e_phone"/>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="E_email">Email Address</label>
														<f:input type="email"  class="form-control"  placeholder="example@verraki.com" pattern=".+@verraki.com" path="emp.e_email"/>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="E_department">Department</label>
														<f:input type="text"  class="form-control"  path="emp.e_department"/>
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="E_img">Password</label>
														<f:input type="password" id="password" class="form-control"  path="emp.e_password"/>			
													</div>
												</div>
											<!-- 	<div class="row form-group">
													<div class="col-md-12">
														<label for="destination">Destination</label>
														<select name="#" id="destination" class="form-control">
															<option value="">Philippines</option>
															<option value="">USA</option>
															<option value="">Australia</option>
															<option value="">Singapore</option>
														</select>
													</div>
												</div>
												
												<div class="row form-group">
													<div class="col-md-12">
														<label for="date-start">Date Travel</label>
														<input type="text" id="date-start" class="form-control">
													</div>
												</div>
														 -->
												<div class="row form-group">
													<div class="col-md-12">
														<input type="submit" class="btn btn-primary btn-block" value="Submit">
													</div>
												</div>
											</f:form>	
										</div>

										
									</div>
								</div>
							</div>
						</div>
					</div>
							
					
			</div>
		</div>
	</header>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>

	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>

	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	
	<!-- Datepicker -->
	<script src="js/bootstrap-datepicker.min.js"></script>
	

	<!-- Main -->
	<script src="js/main.js"></script>
	
</body>
</html>