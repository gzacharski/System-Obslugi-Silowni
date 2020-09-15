<%@	page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>Strefa Klienta</title>
		<jsp:include page="/WEB-INF/view/components/metadata.jsp"/>
		<jsp:include page="/WEB-INF/view/components/stylesheets.jsp"/>

		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/strefa-klienta-zalogowany-user.css" type="text/css" />
		<script defer="defer" src="${pageContext.request.contextPath}/resources/js/currentDate.js"></script>
	</head>

	<body onload="setCurrentDate();">
		<jsp:include page="/WEB-INF/view/components/header.jsp"/>
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
		
		<jsp:include page="/WEB-INF/view/components/footer.jsp"/>
		<jsp:include page="/WEB-INF/view/components/scripts.jsp"/>
	</body>
</html>