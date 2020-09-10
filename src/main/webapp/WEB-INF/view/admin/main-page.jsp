<%@	page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<meta charset="UTF-8">
		<title>Strefa Admina</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
	</head>
	<body>
		<header>
			<jsp:include page="/WEB-INF/view/myHeader.jsp"/>
		</header>
		<main>
			<div class="container">
				<article>
					<section>

						<div class="row">

							<div class="col-12 mt-2">
								<figure class="headerTile">
									<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
									  <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
									  <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
									  <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
									</svg>
									<span>Witaj Adminie</span>
									<br>
									<security:authentication property="principal.username"/><br/>
								</figure>
							</div>
						</div>

						<div class="row">

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
								
									<form:form id="userAccounts" action="${pageContext.request.contextPath}/user/admin/users" method="get"> 
										<button type="submit" class="tileButton" form="userAccounts">
											<span class="text-center">Zarządzaj kontami</span>
											<svg width="1.2em" height="1.2em" viewBox="0 0 16 16" class="bi bi-people-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											  <path fill-rule="evenodd" d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5.784 6A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216zM4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
											</svg>
										</button>
									</form:form>
									
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form id="fitnessEvents" action="${pageContext.request.contextPath}/user/admin/events" method="get"> 
										<button type="submit" class="tileButton" form="fitnessEvents">
											<span class="text-center">Zarządzaj zajęciami</span>
											<svg width="1.2em" height="1.2em" viewBox="0 0 16 16" class="bi bi-list-check" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
											  <path fill-rule="evenodd" d="M5 11.5a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h9a.5.5 0 0 1 0 1h-9a.5.5 0 0 1-.5-.5zM3.854 2.146a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708L2 3.293l1.146-1.147a.5.5 0 0 1 .708 0zm0 4a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708L2 7.293l1.146-1.147a.5.5 0 0 1 .708 0zm0 4a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 0 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0z"/>
											</svg>
										</button>
									</form:form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/trainers" method="get"> 
										<input type="submit" value="Zarządzaj trenerami" class="tileButton">
									</form:form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/trainingRooms" method="get"> 
										<input type="submit" value="Zarządzaj salami treningowymi" class="tileButton">
									</form:form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/workouts" method="get"> 
										<input type="submit" value="Zarządzaj typami treningu" class="tileButton">
									</form:form>
								</figure>
							</div>
							
							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/equipment" method="get"> 
										<input type="submit" value="Zarządzaj sprzętem" class="tileButton">
									</form:form>
								</figure>
							</div>
							
							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form:form action="${pageContext.request.contextPath}/user/admin/statistics" method="get"> 
										<input type="submit" value="Statystyki" class="tileButton">
									</form:form>
								</figure>
							</div>

						</div>
						
					</section>
				</article>
			</div>
		</main>
		<footer>
			<jsp:include page="/WEB-INF/view/myFooter.jsp"/>
		</footer>
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
			integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
			crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
			integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
			crossorigin="anonymous"></script>
		<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</html>