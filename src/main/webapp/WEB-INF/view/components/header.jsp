<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<header>
	<h1 class="logo"><a href="${pageContext.request.contextPath}/" style="text-decoration: none; color: inherit;">System Obsługi Siłowni</a></h1>
	
	<nav id="topnav" class="navbar navbar-dark bg-mynavbg navbar-expand-lg">
		
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
			<span class="togglenav"><i class="icon-pitch"></i>System obsługi siłowni</span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mx-auto menu">
				<li class="nav-item">
					<a class="nav-link" href="${pageContext.request.contextPath}/">Strona główna</a>
				</li>
				<li>
					<a class="nav-link" href="${pageContext.request.contextPath}/workouts/list">Zajęcia</a>
				</li>
				<li>
					<a class="nav-link" href="${pageContext.request.contextPath}/trainers/list">Trenerzy</a>
				</li>
				<li>
					<a class="nav-link" href="${pageContext.request.contextPath}/fitnessEvents">Grafik</a>
				</li>
				<li>
					<a class="nav-link" href="${pageContext.request.contextPath}/equipment">Sprzęt</a>
				</li>
				<li>
					<a class="nav-link" href="#">O siłowni</a>
				</li>
				<li>
					<a class="nav-link" href="${pageContext.request.contextPath}/user/">Siłownia online</a>
				</li>
				<security:authorize access="isAuthenticated()">
					<li>
						<div class="dropdown">
						  <a class="nav-link dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    <jsp:include page="/WEB-INF/view/components/bootstrap-icons/door-open-fill.jsp"/>
						  </a>
						
						  <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
						  	<p style="font-weight: bold; text-align: center; ">
								<security:authentication property="principal.username"/>
							</p>
							<div class="dropdown-divider"></div>

							<security:authorize access="hasRole('ROLE_ADMIN')">
								<button form="adminRole" class="dropdown-item" style="text-align: center; cursor: pointer">Admin</button>
								<form:form id="adminRole" action="${pageContext.request.contextPath}/user/setLeadingRole/ROLE_ADMIN" method="GET"/>
							</security:authorize>
							
							<security:authorize access="hasRole('ROLE_EMPLOYEE')">
								<button form="employeeRole" class="dropdown-item" style="text-align: center; cursor: pointer">Pracownik</button>
								<form:form id="employeeRole" action="${pageContext.request.contextPath}/user/setLeadingRole/ROLE_EMPLOYEE" method="GET"/>
							</security:authorize>
							
							<security:authorize access="hasRole('ROLE_TRAINER')">
								<button form="trainerRole" class="dropdown-item" style="text-align: center; cursor: pointer">Trener</button>
								<form:form id="trainerRole" action="${pageContext.request.contextPath}/user/setLeadingRole/ROLE_TRAINER" method="GET"/>
							</security:authorize>
							
							<security:authorize access="hasRole('ROLE_CLIENT')">
								<button form="clientRole" class="dropdown-item" style="text-align: center; cursor: pointer">Klient</button>
								<form:form id="clientRole" action="${pageContext.request.contextPath}/user/setLeadingRole/ROLE_CLIENT" method="GET"/>
							</security:authorize>
							
							<security:authorize access="hasRole('ROLE_MANAGER')">
								<button form="managerRole" class="dropdown-item" style="text-align: center; cursor: pointer">Manager</button>
								<form:form id="managerRole" action="${pageContext.request.contextPath}/user/setLeadingRole/ROLE_MANAGER" method="GET"/>
							</security:authorize>
							
								
						  	<div class="dropdown-divider"></div>
						  	<button form="logOut" class="dropdown-item" style="text-align: center; cursor: pointer">Wyloguj się</button>
	
						  </div>
						  
						  <form:form id="logOut" action="${pageContext.request.contextPath}/logout" method="POST"/>
						</div>
					</li>
				</security:authorize>
				
			</ul>
			
		</div>
	</nav>
	<div class="container">
	
		<c:if test="${success != null}">
			<c:forEach var="tempSuccess" items="${success}">
				<div class="alert alert-success alert-dismissible fade show my-2" role="alert" >
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/check-circle.jsp"/>
					<span><c:out value="${tempSuccess}"/></span>
				</div>
			</c:forEach>
		</c:if>
		
		<c:if test="${danger!= null}">
			<c:forEach var="tempDanger" items="${danger}">
				<div class="alert alert-danger alert-dismissible fade show my-2" role="alert" >
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/x-circle.jsp"/>
					<span><c:out value="${tempDanger}"/></span>
				</div>
			</c:forEach>
		</c:if>
		
		<c:if test="${info!= null}">
			<c:forEach var="tempInfo" items="${info}">
				<div class="alert alert-info alert-dismissible fade show my-2" role="alert" >
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/info-circle.jsp"/>
					<span><c:out value="${tempInfo}"/></span>
				</div>
			</c:forEach>
		</c:if>
		
		<c:if test="${warning != null}">
			<c:forEach var="tempWarning" items="${warning}">
				<div class="alert alert-warning alert-dismissible fade show my-2" role="alert" >
					<jsp:include page="/WEB-INF/view/components/bootstrap-icons/exclamation-triangle.jsp"/>
					<span><c:out value="${tempWarning}"/></span>
				</div>
			</c:forEach>
		</c:if>	
	</div>
</header>
