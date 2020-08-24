<%@	page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Strefa Klienta</title>

		<meta name="description" content="System obsługi twojej siłowni" />
		<meta name="keywords" content="system, obsługa, siłowni" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/footer.css" type="text/css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />
		
		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fontello.css">
		<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">
		
		<script defer="defer" src="${pageContext.request.contextPath}/resources/js/currentDate.js"></script>
	</head>

	<body onload="setCurrentDate();">
		<header>
			<jsp:include page="/WEB-INF/view/myHeader.jsp"/>
		</header>
		<main>
			<div class="container">
				<article>
					<section>

						<div class="row">

							<div class="col-9">
								<figure class="headerTile">
									Witaj Trenerze: <security:authentication property="principal.username"/>
									Jaki plan treningowy na dziś?
									<!--  itaj ${client.name} ${sessionScope.client.surname} <br/>
									Jaki plan treningowy na dziś? -->
								</figure>
							</div>

							<div class="col-3">
								<figure class="buttonWrapper">
								
									<form:form action="${pageContext.request.contextPath}/logout" method="POST">
										<input type="submit" value="Wyloguj się" class="headerButton"/>
									</form:form>
								
								</figure>
							</div>

						</div>
						
						<div class="row">

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="SignUp" method="post"> 
										<input type="hidden" name="clientId" value="${sessionScope.client.id}"/>
										<input type="hidden" name="command" value="SHOW_PROFILE"/>
										<input type="submit" value="Zarządzaj kontem" class="tileButton"/>
									</form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="FitnessEvents" method="post"> 
										<input type="hidden" name="clientId" value="${sessionScope.client.id}"/>
										<input type="hidden" name="command" value="SHOW_CLIENT_EVENTS"/>
										<input type="hidden" id="selectedDateTime" name="selectedDateTime"/>
										<input type="submit" value="Zarządzaj rezerwacjami zajęć" class="tileButton"/>
									</form>
								</figure>
							</div>
							
							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="" method="post"> 
										<input type="hidden" name="clientId" value="${sessionScope.client.id}"/>
										<input type="hidden" name="command" value="SHOW_EQUIPMENT"/>
										<input type="submit" value="Zarządzaj rezerwacjami sprzętu" class="tileButton"/>
									</form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="" method="post"> 
										<input type="submit" value="Funkcja1" class="tileButton"/>
									</form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="" method="post"> 
										<input type="submit" value="Funkcja2" class="tileButton"/>
									</form>
								</figure>
							</div>

							<div class="col-12 col-md-6 col-lg-4">
								<figure class="buttonWrapper">
									<form action="" method="post"> 
										<input type="submit" value="Funkcja3" class="tileButton"/>
									</form>
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