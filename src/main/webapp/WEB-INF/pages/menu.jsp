<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <%! String page1="/WEB-INF/pages/adminUI";%>
 <%!String page2="/WEB-INF/pages/empUI"; %>
 <%!String page3="/WEB-INF/pages/meeting_form"; %>
 <%!String page4="/WEB-INF/pages/meetingUI"; %>
 <%!String page5="/WEB-INF/pages/reg_form"; %>
 <%!String page6="/WEB-INF/pages/visitor_form";%>
 <%!String page7="/WEB-INF/pages/visitorUI"; %>
 



   <!-- Admin -->
   
   <c:if test="${sessionScope.e_id != null && sessionScope.erole==1}"> 
   <nav>
	<s:url var="url_vm" value="/"></s:url>
	<div id="myHeader">
		<ul>
		<ul>
						<li class="has-dropdown">
							<ul class="dropdown">
								<li><a class="active" href="#">Dashboard</a></li>
								<li><a href="/visitor">Visitor Management</a></li>
								<li><a href="/employee">Employees Management</a></li>
								<li><a href="/meetingList">Meeting Management</a></li>
							</ul>
						</li>
						<li><a href="/reg_form">Register</a></li>
						<li><a href="https://verraki.africa/contact/">Help</a></li>
					</ul>	
		</ul>
		<div class="vl"></div>
	</div>
	
</c:if>


<!-- Employee menu -->
<c:if test="${sessionScope.e_id !=null && sessionScope.erole==2 }">
</nav>
    <nav>
	<div id="myHeader">
		<ul>
		<ul>
						<li class="has-dropdown">
							<ul class="dropdown">
							
								<li><a href="/visitor">Visitor Management</a></li>
								<li><a class="active" href="/employee">Employees Management</a></li>
								<li><a href="/meetingList">Meeting Management</a></li>
							</ul>
						</li>
						<li><a href="/reg_form">Register</a></li>
						<li><a href="https://verraki.africa/contact/">Help</a></li>
					</ul>	
		</ul>
		<div class="vl"></div>
	</div>
	
</nav>
</c:if>
<%--
<!-- Visitor Menu -->
<c:if test="${sessionScope.e_id != null && sessionScope.erole==2}">

</c:if>

<!-- Meeting Menu -->
<c:if test="${sessionScope.e_id != null && sessionScope.erole==2  }">

</c:if>

<!-- Reg form -->
<c:if test="${sessionScope.e_id != null && sessionScope.erole==2  }">

</c:if>

<!-- Visitor reg form -->
<c:if test="${sessionScope.e_id != null && sessionScope.erole==2}">

</c:if>

<!-- Meeting Form -->
<c:if test="${sessionScope.e_id !=null && sessionScope.erole==2 }">

</c:if> --%>